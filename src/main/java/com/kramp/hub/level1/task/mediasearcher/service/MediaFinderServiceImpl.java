package com.kramp.hub.level1.task.mediasearcher.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kramp.hub.level1.task.mediasearcher.model.Media;
import com.kramp.hub.level1.task.mediasearcher.model.MediaContentType;

@Service
public class MediaFinderServiceImpl implements MediaFinderService {

	@Autowired
	private GoogleBooksService googleBooksService;

	@Autowired
	private ItuneService ituneService;

	@Override
	public List<Media> getMedia(String searchString) throws InterruptedException, ExecutionException {

		CompletableFuture<List<Media>> ituneContentsList = CompletableFuture.supplyAsync(() -> {
			return ituneService.getAlbums(MediaContentType.ALBUM, searchString);
		});

		CompletableFuture<List<Media>> booksList = CompletableFuture.supplyAsync(() -> {
			return googleBooksService.getBooks(searchString);
		});

		CompletableFuture<List<Media>> allMediaContentList = ituneContentsList.thenCombine(booksList, (a, b) -> {
			a.addAll(b);
			return a;
		});

		return allMediaContentList.get();
	}

}
