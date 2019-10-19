package com.kramp.hub.level1.task.mediasearcher.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MediaItems {

	private int totalItems;
	private List<Media> items;

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public List<Media> getItems() {
		return items;
	}

	public void setItems(List<Media> items) {
		this.items = items;
	}

}
