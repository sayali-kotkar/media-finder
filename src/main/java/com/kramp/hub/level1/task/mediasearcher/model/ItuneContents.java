package com.kramp.hub.level1.task.mediasearcher.model;

import java.util.List;

import lombok.ToString;

//@Getter @Setter
@ToString
public class ItuneContents {
	
	private int resultCount;
	List<ItuneContent> results;
	
	public int getResultCount() {
		return resultCount;
	}
	public void setResultCount(int resultCount) {
		this.resultCount = resultCount;
	}
	public List<ItuneContent> getResults() {
		return results;
	}
	public void setResults(List<ItuneContent> results) {
		this.results = results;
	}
	
	
	@Override
	public String toString() {
		return "ItuneContents [resultCount=" + resultCount + ", results=" + results + "]";
	}
	
}
