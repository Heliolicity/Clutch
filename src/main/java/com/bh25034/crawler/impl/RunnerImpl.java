package com.bh25034.crawler.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bh25034.crawler.Crawler;
import com.bh25034.crawler.Runner;
import com.bh25034.entities.Goal;

public class RunnerImpl implements Runnable, Runner {

	private List<String> URLs;
	private List<Goal> goals;
	//private CrawlerImpl crawler;
	private Crawler crawler;
	private String baseURL;
	private String subURL;
	private int games;
	private long waitTime;
	
	public RunnerImpl() {}
	
	public RunnerImpl(String url, String suburl) { 
	
		this.baseURL = url;
		this.subURL = suburl;
		
	}
	
	public RunnerImpl(String url, String suburl, int games) { 
		
		this.baseURL = url;
		this.subURL = suburl;
		this.games = games;
		
	}
	
	public RunnerImpl(String url, String suburl, int games, int waitTime) { 
		
		this.baseURL = url;
		this.subURL = suburl;
		this.games = games;
		this.waitTime = waitTime;
		
	}
	
	public RunnerImpl(Crawler crawler, String url, String suburl, int games) { 
		
		this.crawler = crawler;
		this.baseURL = url;
		this.subURL = suburl;
		this.games = games;
		
	}

	public RunnerImpl(CrawlerImpl crawler, String url, String suburl, int games, int waitTime) { 
		
		this.crawler = crawler;
		this.baseURL = url;
		this.subURL = suburl;
		this.games = games;
		this.waitTime = waitTime;
		
	}
	
	public void scrapeLinks() {
		
		for (int i = 1; i <= this.games; i ++) {
			
			//this.crawler = new Crawler("http://www.scorespro.com/soccer/england/premier-league/1999-2000/round-" + i + "/", "http://www.scorespro.com/soccer/livescore/");
			//this.crawler = new Crawler(this.baseURL + i + "/", this.subURL);
			this.crawler.setMainURL(this.baseURL + i + "/");
			this.crawler.setSubURL(this.subURL);
			
			try {
				
				this.crawler.scrapeLinks();
				this.URLs = this.crawler.getURLs();
			
			} 
			
			catch (IOException e) {
				// TODO Auto-generated catch block
				pl(e.getMessage());
				e.printStackTrace();
			
			}
			
		}
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		this.goals = new ArrayList<Goal>();
		List<Goal> subgoals;
		
		try {
			
			int count = 0;
			this.crawler.setCount(count);
			
			for (int j = 0; j < this.URLs.size(); j ++) {
				
				//pl(this.URLs.get(j));
				this.crawler.setCount(count);
				this.crawler.scrapeGoals(this.URLs.get(j));
				subgoals = this.crawler.getGoals();
				this.goals.addAll(subgoals);
				count += subgoals.size();
				
				//Thread.sleep(3000);
				Thread.sleep(this.waitTime);
				
			}
			
		}
		
		catch (Exception e) {
			
			pl(e.getMessage());
			e.printStackTrace();
			
		}
		
	}
	
	public String getBaseURL() {
		return baseURL;
	}

	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}

	public String getSubURL() {
		return subURL;
	}

	public void setSubURL(String subURL) {
		this.subURL = subURL;
	}

	public List<String> getURLs() {
		return URLs;
	}

	public void setURLs(List<String> uRLs) {
		URLs = uRLs;
	}

	public List<Goal> getGoals() {
		return goals;
	}

	public void setGoals(List<Goal> goals) {
		this.goals = goals;
	}

	public Crawler getCrawler() {
		return crawler;
	}

	public void setCrawler(Crawler crawler) {
		this.crawler = crawler;
	}

	public int getGames() {
		return games;
	}

	public void setGames(int games) {
		this.games = games;
	}

	public long getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(long waitTime) {
		this.waitTime = waitTime;
	}

	private void pl(String s) { System.out.println(s); }
	
}
