package com.kramp.hub.level1.task.mediasearcher.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kramp.hub.level1.task.mediasearcher.model.Media;
import com.kramp.hub.level1.task.mediasearcher.model.MediaItems;
import com.kramp.hub.level1.task.mediasearcher.service.MediaFinderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
public class MediaSearchController {
	
	@Autowired
	private MediaFinderService mediaFinderService;

	@GetMapping(value = "/media")
	@ApiOperation(value="Fetches list of albums and books matching the searchString. "
			+ "By default the reponse contains maximum of 5 books and albums each.")
	public @ResponseBody MediaItems getMedia(@RequestParam("searchString") String searchString,
			@RequestParam(name = "limit", defaultValue = "5") int limit) 
			throws InterruptedException, ExecutionException {
		
		List<Media> mediaList = mediaFinderService.getMedia(searchString, limit);
		MediaItems list = new MediaItems(mediaList.size(),mediaList);
		return list;
		 
	}
}
