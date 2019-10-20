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
	public List<Media> getMedia(String searchString, int limit) throws InterruptedException, ExecutionException {

		CompletableFuture<List<Media>> ituneContentsList = CompletableFuture.supplyAsync(() -> {
			return ituneService.getAlbums(MediaContentType.ALBUM, searchString, limit);
		});

		CompletableFuture<List<Media>> booksList = CompletableFuture.supplyAsync(() -> {
			return googleBooksService.getBooks(searchString,limit);
		});

		CompletableFuture<List<Media>> allMediaContentList = ituneContentsList.thenCombine(booksList, (a, b) -> {
			a.addAll(b);
			return a;
		});

		
		allMediaContentList.get().sort((r1, r2) -> r1.getTitle().compareTo(r2.getTitle()));
		return allMediaContentList.get();
		
	}

}
