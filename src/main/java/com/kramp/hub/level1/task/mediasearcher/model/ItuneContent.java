package com.kramp.hub.level1.task.mediasearcher.model;

import lombok.ToString;

//@Getter @Setter
@ToString
public class ItuneContent {
	
	private String artistName;
    private String collectionName;
    private String collectionType;
    
	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}	


	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public String getCollectionType() {
		return collectionType;
	}

	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}

	public Media convertToMediaObj() {
		// TODO Auto-generated method stub
		Media media = new Media(); 
		media.setArtistName(artistName);
		media.setTitle(collectionName);
		media.setMediaType(MediaContentType.getContentType(collectionType));
		return media;
	}
}
