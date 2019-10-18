package com.kramp.hub.level1.task.mediasearcher.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.kramp.hub.level1.task.mediasearcher.model.Media;

public interface MediaFinderService {

	public List<Media> getMedia(String searchString) throws InterruptedException, ExecutionException;
}
