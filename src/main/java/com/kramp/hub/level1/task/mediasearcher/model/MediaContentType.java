package com.kramp.hub.level1.task.mediasearcher.model;

public enum MediaContentType {
	ALBUM("album"), BOOK("book"), UNKNOWN("unknown");

	private String name;

	MediaContentType(String name) {
		this.name = name;
	}

	public String label() {
		return name;
	}
	
	public static MediaContentType getContentType(String mediaContentTypeStr) {
		for(MediaContentType mediaContentType : MediaContentType.values()) {
		  if (mediaContentType.label().equalsIgnoreCase(mediaContentTypeStr)) {
			  return mediaContentType;
		  }
		}
		return UNKNOWN;
	}
}
