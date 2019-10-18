package com.kramp.hub.level1.task.mediasearcher.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kramp.hub.level1.task.mediasearcher.model.ItuneContent;
import com.kramp.hub.level1.task.mediasearcher.model.ItuneContents;
import com.kramp.hub.level1.task.mediasearcher.model.Media;
import com.kramp.hub.level1.task.mediasearcher.model.MediaContentType;

@Service
public class ItuneServiceImpl implements ItuneService{
	
	@Value("${itune.search}")
	private String searchUrl;

	@Autowired
	RestTemplate restTemplate;

	public List<Media> getAlbums(MediaContentType mediaType, String searchString) {

		String finalURL = searchUrl + "?term=" + searchString + "&entity=" + mediaType.label();
		ItuneContents iTuneContents = restTemplate.getForEntity(finalURL, ItuneContents.class, searchString).getBody();
        List<ItuneContent> ituneContents =  iTuneContents.getResults();
        List<Media> mediaList = ituneContents.stream().map(m -> m.convertToMediaObj()).collect(Collectors.toList());
	
	    return mediaList;
	}

}
