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

import com.kramp.hub.level1.task.mediasearcher.model.ItuneContent;
import com.kramp.hub.level1.task.mediasearcher.model.ItuneContents;
import com.kramp.hub.level1.task.mediasearcher.model.Media;
import com.kramp.hub.level1.task.mediasearcher.model.MediaContentType;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ItuneServiceImpl implements ItuneService{
	
	@Value("${itune.search}")
	private String searchUrl;

	@Autowired
	RestTemplate restTemplate;

	private static final Logger log = LoggerFactory.getLogger(ItuneServiceImpl.class);
	
	@Override
	@HystrixCommand(fallbackMethod = "defaultAlbums")
	public List<Media> getAlbums(MediaContentType mediaType, String searchString, int limit) {

		log.info("Fetching" + mediaType.label() + "from itune store for searchString" + searchString);
		
		String finalURL = searchUrl + "?term=" + searchString + "&entity=" + mediaType.label() + "&limit=" + limit;
		ItuneContents iTuneContents = restTemplate.getForEntity(finalURL, ItuneContents.class, searchString).getBody();
        List<ItuneContent> ituneContents =  iTuneContents.getResults();
        List<Media> mediaList = ituneContents.stream().map(m -> m.convertToMediaObj()).collect(Collectors.toList());
	
        log.info("Itune store returned total" + mediaList.size() + "records for searchString" + searchString);
	    return mediaList;
	}
	
	
	public  List<Media> defaultAlbums(MediaContentType mediaType, String searchString, int limit, Throwable t){
		
		log.error("Error ocurred while fetching data from itune store for searchString" + searchString + t);
	
		Media media = new Media();
		media.setTitle("Your  Search for "+searchString+" with meadiaType"+mediaType+" is not available temporarily. Kindly try after some time ");
		media.setMediaType(mediaType);
		List<Media> erroMediaList= new ArrayList<Media>();
		 return erroMediaList;
	}


}
