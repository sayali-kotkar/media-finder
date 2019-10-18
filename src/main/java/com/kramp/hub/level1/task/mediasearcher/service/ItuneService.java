package com.kramp.hub.level1.task.mediasearcher.service;

import java.util.List;

import com.kramp.hub.level1.task.mediasearcher.model.Media;
import com.kramp.hub.level1.task.mediasearcher.model.MediaContentType;


public interface ItuneService {
	public List<Media> getAlbums(MediaContentType mediaType, String searchString);

}
