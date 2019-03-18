/**
 * 
 */
package com.ge.digital.webcrawler.model;

import java.io.Serializable;
import java.util.Set;

/**
 * @author NitinAmbastha
 *
 */
public class WebCrawlerResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Set<String> success;
	private Set<String> skipped;
	private Set<String> error;
	
	/**
	 * @return the success
	 */
	public Set<String> getSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(Set<String> success) {
		this.success = success;
	}
	/**
	 * @return the skipped
	 */
	public Set<String> getSkipped() {
		return skipped;
	}
	/**
	 * @param skipped the skipped to set
	 */
	public void setSkipped(Set<String> skipped) {
		this.skipped = skipped;
	}
	/**
	 * @return the error
	 */
	public Set<String> getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(Set<String> error) {
		this.error = error;
	}

	

}
