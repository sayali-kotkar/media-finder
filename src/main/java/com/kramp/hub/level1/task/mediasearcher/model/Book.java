package com.kramp.hub.level1.task.mediasearcher.model;

import java.util.List;

public class Book {

	private VolumeInfo volumeInfo;

	public Media convertToMediaObj() {
		Media media = new Media();
		media.setTitle(volumeInfo.getTitle());
		media.setAuthorName(volumeInfo.getAuthors());
		media.setMediaType(MediaContentType.BOOK);
		return media;
	}

	public VolumeInfo getVolumeInfo() {
		return volumeInfo;
	}

	public void setVolumeInfo(VolumeInfo volumeInfo) {
		this.volumeInfo = volumeInfo;
	}

}

class VolumeInfo {
	private String title;
	private List<String> authors;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

}
