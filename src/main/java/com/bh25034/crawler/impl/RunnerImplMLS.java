package com.bh25034.crawler.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bh25034.crawler.Crawler;
import com.bh25034.crawler.Runner;
import com.bh25034.entities.Goal;

public class RunnerImplMLS implements Runnable, Runner {

	private List<String> URLs;
	private List<Goal> goals;
	private Crawler crawler;
	private String baseURL;
	private String baseKOURL;
	private String subURL;
	private List<String> months;
	private long waitTime;
	
	public RunnerImplMLS() {}
	
	public RunnerImplMLS(String url, String suburl) { 
	
		this.baseURL = url;
		this.subURL = suburl;
		
	}
	
	public RunnerImplMLS(String url, String suburl, List<String> months) { 
		
		this.baseURL = url;
		this.subURL = suburl;
		this.months = months;
		
	}
	
	public RunnerImplMLS(String url, String suburl, List<String> months, int waitTime) { 
		
		this.baseURL = url;
		this.subURL = suburl;
		this.months = months;
		this.waitTime = waitTime;
		
	}
	
	public RunnerImplMLS(Crawler crawler, String url, String suburl, List<String> months) { 
		
		this.crawler = crawler;
		this.baseURL = url;
		this.subURL = suburl;
		this.months = months;
		
	}
	
	public RunnerImplMLS(Crawler crawler, String url, String suburl, List<String> months, int waitTime) { 
		
		this.crawler = crawler;
		this.baseURL = url;
		this.subURL = suburl;
		this.months = months;
		this.waitTime = waitTime;
		
	}
	
	@Override
	public void scrapeLinks() {
		// TODO Auto-generated method stub
		
		String month = "";
		
		for (int i = 0; i < this.months.size(); i ++) {
			
			month = this.months.get(i);
			//pl(month);
			
			this.crawler.setMainURL(this.baseURL + month + "/");
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
		
		this.crawler.setMainURL(this.baseKOURL + "conference-semi-finals/first-leg/");
		this.crawler.setSubURL(this.subURL);
		List<String> tempURLs = new ArrayList<String>();
		this.crawler.setURLs(tempURLs);
		
		try {
			
			this.crawler.scrapeLinks();
			this.URLs.addAll(this.crawler.getURLs());
	
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			pl(e.getMessage());
			e.printStackTrace();
		
		}
		
		this.crawler.setMainURL(this.baseKOURL + "conference-semi-finals/second-leg/");
		this.crawler.setSubURL(this.subURL);
		tempURLs = new ArrayList<String>();
		this.crawler.setURLs(tempURLs);
		
		try {
			
			this.crawler.scrapeLinks();
			this.URLs.addAll(this.crawler.getURLs());
	
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			pl(e.getMessage());
			e.printStackTrace();
		
		}
		
		this.crawler.setMainURL(this.baseKOURL + "conference-finals/cf/");
		this.crawler.setSubURL(this.subURL);
		tempURLs = new ArrayList<String>();
		this.crawler.setURLs(tempURLs);
		
		try {
			
			this.crawler.scrapeLinks();
			this.URLs.addAll(this.crawler.getURLs());
	
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			pl(e.getMessage());
			e.printStackTrace();
		
		}
		
		this.crawler.setMainURL(this.baseKOURL + "mls-cup/final/");
		this.crawler.setSubURL(this.subURL);
		tempURLs = new ArrayList<String>();
		this.crawler.setURLs(tempURLs);
		
		try {
			
			this.crawler.scrapeLinks();
			this.URLs.addAll(this.crawler.getURLs());
	
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			pl(e.getMessage());
			e.printStackTrace();
		
		}
		
		this.crawler.setMainURL(this.baseKOURL + "knock-out-round/ko/");
		this.crawler.setSubURL(this.subURL);
		tempURLs = new ArrayList<String>();
		this.crawler.setURLs(tempURLs);
		
		try {
			
			this.crawler.scrapeLinks();
			this.URLs.addAll(this.crawler.getURLs());
	
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			pl(e.getMessage());
			e.printStackTrace();
		
		}
		
		/*this.crawler.setMainURL(this.baseKOURL + "knock-out-round/ko/");
		this.crawler.setSubURL(this.subURL);
		List<String> tempURLs = new ArrayList<String>();
		this.crawler.setURLs(tempURLs);
		
		try {
			
			this.crawler.scrapeLinks();
			this.URLs.addAll(this.crawler.getURLs());
		
			//for (int k = 0; k < this.crawler.getURLs().size(); k ++) pl("URL: " + this.crawler.getURLs().get(k));
			
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			pl(e.getMessage());
			e.printStackTrace();
		
		}
		
		this.crawler.setMainURL(this.baseKOURL + "conference-semi-finals/first-leg/");
		this.crawler.setSubURL(this.subURL);
		tempURLs = new ArrayList<String>();
		this.crawler.setURLs(tempURLs);
		
		try {
			
			this.crawler.scrapeLinks();
			this.URLs.addAll(this.crawler.getURLs());
		
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			pl(e.getMessage());
			e.printStackTrace();
		
		}
		
		this.crawler.setMainURL(this.baseKOURL + "conference-semi-finals/second-leg/");
		this.crawler.setSubURL(this.subURL);
		tempURLs = new ArrayList<String>();
		this.crawler.setURLs(tempURLs);
		
		try {
			
			this.crawler.scrapeLinks();
			this.URLs.addAll(this.crawler.getURLs());
		
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			pl(e.getMessage());
			e.printStackTrace();
		
		}
		
		this.crawler.setMainURL(this.baseKOURL + "conference-finals/first-leg/");
		this.crawler.setSubURL(this.subURL);
		tempURLs = new ArrayList<String>();
		this.crawler.setURLs(tempURLs);
		
		try {
			
			this.crawler.scrapeLinks();
			this.URLs.addAll(this.crawler.getURLs());
		
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			pl(e.getMessage());
			e.printStackTrace();
		
		}
		
		this.crawler.setMainURL(this.baseKOURL + "conference-finals/second-leg/");
		this.crawler.setSubURL(this.subURL);
		tempURLs = new ArrayList<String>();
		this.crawler.setURLs(tempURLs);
		
		try {
			
			this.crawler.scrapeLinks();
			this.URLs.addAll(this.crawler.getURLs());
		
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			pl(e.getMessage());
			e.printStackTrace();
		
		}*/
		
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
				
				if (this.URLs.get(j).contains("play-offs")) this.crawler.setPlayOffs(true);
				else this.crawler.setPlayOffs(false);
				
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

	public List<String> getMonths() {
		return months;
	}
	
	public void setMonths(List<String> months) {
		this.months = months;
	}

	public long getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(long waitTime) {
		this.waitTime = waitTime;
	}
	
	public String getBaseKOURL() {
		return baseKOURL;
	}

	public void setBaseKOURL(String baseKOURL) {
		this.baseKOURL = baseKOURL;
	}
	
	private void pl(String s) { System.out.println(s); }

}
