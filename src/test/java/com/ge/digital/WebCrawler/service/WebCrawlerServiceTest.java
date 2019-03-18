/**
 * 
 */
package com.ge.digital.WebCrawler.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.ge.digital.webcrawler.model.Page;
import com.ge.digital.webcrawler.model.WebCrawlerRequest;
import com.ge.digital.webcrawler.model.WebCrawlerResponse;
import com.ge.digital.webcrawler.service.WebCrawlerService;

/**
 * @author NitinAmbastha
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class WebCrawlerServiceTest {

	@InjectMocks
	WebCrawlerService webCrawlerService;
	
	WebCrawlerRequest request = null;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp()  {
		request = new WebCrawlerRequest();
		List<Page> pages = new ArrayList<>();
		Page page = new Page();
		List<String> links = new ArrayList<>();
		
		page.setAddress("a");
		links.add("b");
		page.setLinks(links);
		pages.add(page);
		
		page = new Page();
		page.setAddress("b");
		links = new ArrayList<>();
		links.add("c");
		page.setLinks(links);
		pages.add(page);
		
		request.setPages(pages);
	}

	@Test
	public void test() {
		WebCrawlerResponse response = new WebCrawlerResponse();
		Set<String> success = new HashSet<>();
		Set<String> error = new HashSet<>();
		Set<String> skipped = new HashSet<>();
		success.add("a");
		success.add("b");
		error.add("c");
		
		
		response.setError(error);
		response.setSkipped(skipped);
		response.setSuccess(success);
		response = webCrawlerService.visitLinks(request);
		assertEquals(success, webCrawlerService.visitLinks(request).getSuccess());
		assertEquals(error, webCrawlerService.visitLinks(request).getError());
		assertEquals(skipped, webCrawlerService.visitLinks(request).getSkipped());
	}

}
