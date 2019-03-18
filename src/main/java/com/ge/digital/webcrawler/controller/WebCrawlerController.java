/**
 * 
 */
package com.ge.digital.webcrawler.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ge.digital.webcrawler.model.WebCrawlerRequest;
import com.ge.digital.webcrawler.model.WebCrawlerResponse;
import com.ge.digital.webcrawler.service.WebCrawlerService;

/**
 * @author NitinAmbastha
 *
 */
@RestController
public class WebCrawlerController {
	
	private Logger log = LoggerFactory.getLogger(WebCrawlerController.class);
	
	@Autowired
	private WebCrawlerService webCrawlerService;
	
	/**
	 * @param request to crawl links
	 * @return response with success, error and skipped links
	 */
	@RequestMapping(value = "/visitlinks", method = RequestMethod.POST)
	public WebCrawlerResponse visitLinks(@RequestBody WebCrawlerRequest request) {
		log.info("Inside visitLinks method in WebCrawlerController class");
		WebCrawlerResponse response = new WebCrawlerResponse();
		
		try {
			response = webCrawlerService.visitLinks(request);
		} catch (Exception e) {
			log.error("Exception in Web Crawler Service , ", e.getCause());
		}
		
		return response;
	}
	
}
