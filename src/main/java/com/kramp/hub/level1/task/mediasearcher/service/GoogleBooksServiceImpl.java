package com.kramp.hub.level1.task.mediasearcher.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kramp.hub.level1.task.mediasearcher.model.GoogleBooks;
import com.kramp.hub.level1.task.mediasearcher.model.Media;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GoogleBooksServiceImpl implements GoogleBooksService {

	@Value("${google.books.search}")
	private String searchUrl;

	@Autowired
	RestTemplate restTemplate;

	private static final Logger log = LoggerFactory.getLogger(GoogleBooksServiceImpl.class);
			
	@HystrixCommand(fallbackMethod = "defaultBooks")
	public List<Media> getBooks(String searchString, int limit) {
		log.info("Fetching list of books from google store for searchString" + searchString);

		String finalURL = searchUrl + "?q=" + searchString + "&maxResults=" + limit;
		GoogleBooks googleBooks = restTemplate.getForEntity(finalURL, GoogleBooks.class, searchString).getBody();
		List<Media> mediaList = googleBooks.getItems().stream().map(b -> b.convertToMediaObj())
				.collect(Collectors.toList());

		log.info("Google books store returned total" + mediaList.size() + "records for searchString" + searchString);

		return mediaList;
	}

	public List<Media> defaultBooks(String searchString, int limit, Throwable t) {
		
		log.error("Error ocurred while fetching data from google store for searchString " + searchString + t);
        
		Media media = new Media();
		media.setTitle("Could not find books for search string " + searchString);
		List<Media> erroMediaList = new ArrayList<Media>();
		return erroMediaList;
	}
}
