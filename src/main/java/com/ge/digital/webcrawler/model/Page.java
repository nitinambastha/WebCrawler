/**
 * 
 */
package com.ge.digital.webcrawler.model;

import java.util.List;

/**
 * @author NitinAmbastha
 *
 */
public class Page {
	
	private String address;
	private List<String> links;
	
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the links
	 */
	public List<String> getLinks() {
		return links;
	}
	/**
	 * @param links the links to set
	 */
	public void setLinks(List<String> links) {
		this.links = links;
	}
	
}
