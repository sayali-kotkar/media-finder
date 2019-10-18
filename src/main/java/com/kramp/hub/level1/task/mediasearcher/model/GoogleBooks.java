package com.kramp.hub.level1.task.mediasearcher.model;

import java.util.List;

public class GoogleBooks {

	private String kind;
	private List<Book> items; 
	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public List<Book> getItems() {
		return items;
	}
	public void setItems(List<Book> items) {
		this.items = items;
	}

	
}

