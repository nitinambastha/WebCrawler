package com.ge.digital.webcrawler.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author NitinAmbastha
 *
 */
public class WebCrawlerRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Page> pages;

	/**
	 * @return the pages
	 */
	public List<Page> getPages() {
		return pages;
	}

	/**
	 * @param pages the pages to set
	 */
	public void setPages(List<Page> pages) {
		this.pages = pages;
	}

	
}
