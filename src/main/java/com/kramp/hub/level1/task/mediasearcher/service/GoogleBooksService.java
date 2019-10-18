package com.kramp.hub.level1.task.mediasearcher.service;

import java.util.List;

import com.kramp.hub.level1.task.mediasearcher.model.Media;

public interface GoogleBooksService {


	public List<Media> getBooks(String searchString);
}
