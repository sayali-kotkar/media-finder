package com.kramp.hub.level1.task.mediasearcher.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kramp.hub.level1.task.mediasearcher.model.GoogleBooks;
import com.kramp.hub.level1.task.mediasearcher.model.Media;

@Service
public class GoogleBooksServiceImpl implements GoogleBooksService {

	@Value("${google.books.search}")
	private String searchUrl;

	@Autowired
	RestTemplate restTemplate;

	public List<Media> getBooks(String searchString) {

		String finalURL = searchUrl + "?q=searchString";
		GoogleBooks googleBooks = restTemplate.getForEntity(finalURL, GoogleBooks.class, searchString).getBody();
	//	List<GoogleBooks> ituneContents = iTuneContents.getResults();
	//	List<Media> mediaList = ituneContents.stream().map(m -> m.convertToMediaObj()).collect(Collectors.toList());
		List<Media> mediaList = googleBooks.getItems().stream().map(b -> b.convertToMediaObj()).collect(Collectors.toList());
		return  mediaList;
	}

}
