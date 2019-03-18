/**
 * 
 */
package com.ge.digital.webcrawler.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ge.digital.webcrawler.model.Page;
import com.ge.digital.webcrawler.model.WebCrawlerRequest;
import com.ge.digital.webcrawler.model.WebCrawlerResponse;

/**
 * @author NitinAmbastha
 *
 */
@Service
public class WebCrawlerService {
	
	public WebCrawlerService() {
		//needed for instantiation
	}
	
	private Logger log = LoggerFactory.getLogger(WebCrawlerService.class);
	
	/**
	 * @param request
	 * @return response with success, error and skipped links
	 * @throws BusinessException 
	 */
	public WebCrawlerResponse visitLinks(WebCrawlerRequest request) {
		log.info("Inside visitLinks method in WebCrawlerService class");
		WebCrawlerResponse response = new WebCrawlerResponse();
		
		Map<String, List<String>> pageMap = new HashMap<>();		
		Set<String> success = new TreeSet<>();
		Set<String> skipped = new TreeSet<>();
		Set<String> error = new TreeSet<>();
		
		for(Page page : request.getPages()) {
			pageMap.put(page.getAddress(), page.getLinks());
		}
				
		String address = null;

		address = request.getPages().get(0).getAddress();
		getLinks(pageMap, address , success, skipped, error);
		
		response.setSuccess(success);
		response.setSkipped(skipped);
		response.setError(error);

		return response;
	}
	
	/**
	 * @param pageMap
	 * @param link
	 * @param success
	 * @param skipped
	 * @param error
	 * returns success if a link is successfully visited, skipped if link is already visited and error when address is unavailable
	 */
	public void getLinks(Map<String, List<String>> pageMap, String link, Set<String> success, Set<String> skipped, Set<String> error) {
		log.info("Inside getLinks method for link : "+link);
		if(pageMap.containsKey(link) && !success.contains(link)) {
			success.add(link);
			for (String currentLink : pageMap.get(link)) {
				getLinks(pageMap, currentLink, success, skipped, error);
			}
		} else if (success.contains(link)) {
			skipped.add(link);
		} else {
			error.add(link);
		}		
	}
}
