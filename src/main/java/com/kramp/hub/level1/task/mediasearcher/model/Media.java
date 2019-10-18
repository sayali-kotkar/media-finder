package com.kramp.hub.level1.task.mediasearcher.model;

import java.util.List;

public class Media {

    private String title;
    private List<String> authorName;
    private String artistName;
    private MediaContentType mediaType;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getAuthorName() {
		return authorName;
	}
	public void setAuthorName(List<String> authorName) {
		this.authorName = authorName;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public MediaContentType getMediaType() {
		return mediaType;
	}
	public void setMediaType(MediaContentType mediaType) {
		this.mediaType = mediaType;
	}
    
    
}
