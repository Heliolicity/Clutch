package com.bh25034.crawler;

public interface Runner {

	public void scrapeLinks();
	
	public void run();
	
	public Crawler getCrawler();
	
	public void setCrawler(Crawler crawler);
	
}
