package com.kramp.hub.level1.task.mediasearcher.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kramp.hub.level1.task.mediasearcher.model.Media;
import com.kramp.hub.level1.task.mediasearcher.model.MediaItems;
import com.kramp.hub.level1.task.mediasearcher.service.MediaFinderService;

@RestController
public class MediaSearchController {
	
	@Autowired
	private MediaFinderService mediaFinderService;

	@RequestMapping(value = "/search")
	public @ResponseBody MediaItems getMedia(@RequestParam("searchString") String searchString) 
			throws InterruptedException, ExecutionException {
		
		List<Media> mediaList = mediaFinderService.getMedia(searchString);
		MediaItems list = new MediaItems();
		list.setItems(mediaList);
		list.setTotalItems(mediaList.size());
		return list;
		 
	}
}
