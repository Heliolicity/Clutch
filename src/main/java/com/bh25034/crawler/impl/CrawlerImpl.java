package com.bh25034.crawler.impl;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.bh25034.crawler.Crawler;
import com.bh25034.csvwriter.CSVWriter;
import com.bh25034.entities.Goal;

public class CrawlerImpl implements Crawler {

	private String mainURL;
	private String subURL;
	private String currentURL;
	private List<Goal> goals;
	private List<String> URLs;
	private Document mainDocument;
	private int count;
	private CSVWriter csvWriter;
	
	public CrawlerImpl() { this.URLs = new ArrayList<String>(); }
	
	public CrawlerImpl(String mainURL, String subURL, CSVWriter csvWriter) {
		super();
		this.mainURL = mainURL;
		this.subURL = subURL;
		this.csvWriter = csvWriter;
		this.URLs = new ArrayList<String>();
	}
	
	public void scrapeLinks() throws IOException {
	
		String text = "";
		int index = 0;
		
		try {
			
			this.mainDocument = Jsoup.connect(this.mainURL).timeout(300000).get();
			
			Elements links = this.mainDocument.select("a[href]");  
			
			for (Element link : links) {  
		    
				text = link.attr("href");
				index = text.indexOf(",");
				
				if (index > 0) {
				
					this.currentURL = text.substring(index + 2, text.length() - 2).trim() + "/";
					//pl(this.subURL + url);
					this.csvWriter.write(this.subURL + this.currentURL + "\n");
					this.URLs.add(this.subURL + this.currentURL);
				
				}
				
		        //System.out.println("text : " + link.text());  
		    
			}
			
		}
		
		catch (HttpStatusException hse) {
			
			pl("Error getting data for " + this.currentURL);
			pl(hse.getMessage());
			hse.printStackTrace();
			
		}
		
	}
	
	public void scrapeGoals(String url) {
		
		try {
		
			pl(url);
			
			List<Goal> goals = new ArrayList<Goal>();
		    Document doc = Jsoup.connect(url).timeout(3000000).get();  
		    Elements elements = doc.getAllElements();
		
		    Goal goal = new Goal();
		    String text = "";
		    String test = "";
		    String homeTeam = "";
		    String awayTeam = "";
		    int day = 0;
		    int month = 0;
		    String strMonth = "";
		    int year = 0;
		    int hour = 0;
		    int minute = 0;
		    DateTime dateTime = new DateTime();
		    LocalTime localTime = new LocalTime();
		    
		    for (Element element : elements) {
		    	
		    	if (element.cssSelector().equals("html")) {
		    		
		    		text = element.text();
		    		
		    		if (text.contains("vs")) {
		    			
		    			//pl(text);
		    			homeTeam = text.substring(0, text.indexOf("vs")).trim();
		    			//pl(homeTeam);
		    			awayTeam = text.substring(text.indexOf("vs") + 2, text.indexOf(" - ")).trim();
		    			//pl(awayTeam);
		    			
		    			text = text.substring(text.indexOf(" - ") + 3, text.length()).trim();
		    			//pl(text);
		    			
		    			test = text.substring(0, text.indexOf(",")).trim();
		    			//pl(test);
		    			day = new Integer(test.substring(0, test.indexOf(" "))).intValue();
		    			//pl("" + day);
		    			test = test.substring(test.indexOf(" "), test.length()).trim();
		    			//pl(test);
		    			strMonth = test.substring(0, test.indexOf(" ")).trim();
		    			//pl(strMonth);
		    			
		    			switch(strMonth) {
		    			
			    			case "Jan" : month = 1; break;
			    			case "January" : month = 1; break;
			    			
			    			case "Feb" : month = 2; break;
			    			case "February" : month = 2; break;
			    			
			    			case "Mar" : month = 3; break;
			    			case "March" : month = 3; break;
			    			
			    			case "Apr" : month = 4; break;
			    			case "April" : month = 4; break;
			    			
			    			case "May" : month = 5; break;
			    			
			    			case "Jun" : month = 6; break;
			    			case "June" : month = 6; break;
			    			
			    			case "Jul" : month = 7; break;
			    			case "July" : month = 7; break;
			    			
			    			case "Aug" : month = 8; break;
			    			case "August" : month = 8; break;
			    			
			    			case "Sep" : month = 9; break;
			    			case "September" : month = 9; break;
			    			
			    			case "Oct" : month = 10; break;
			    			case "October" : month = 10; break;
			    			
			    			case "Nov" : month = 11; break;
			    			case "November" : month = 11; break;
			    			
			    			case "Dec" : month = 12; break;
			    			case "December" : month = 12; break;
		    			
		    			}
		    			
		    			test = test.substring(test.indexOf(" "), test.length()).trim();
		    			//pl(test);
		    			year = new Integer(test).intValue();
		    			//pl("" + year);
		    			
		    			test = text.substring(text.indexOf("Livescore") + 9, text.length()).trim();
		    			//pl(test);
		    			test = test.substring(test.indexOf(":") - 2, test.length()).trim();
		    			//pl(test);
		    			hour = new Integer(test.substring(0, 2)).intValue();
		    			//pl("" + hour);
		    			test = test.substring(test.indexOf(":") + 1, test.length()).trim();
		    			minute = new Integer(test.substring(0, 2)).intValue();
		    			//pl("" + minute);
		    			
		    			dateTime = new DateTime(year, month, day, hour, minute);
		    			//pl(dateTime.toString());
		    			localTime = new LocalTime(hour, minute, 0);
		    			test = text.substring(text.indexOf("Finished") + 8, text.indexOf("100% Bet Bonus")).trim();
		    			//pl(test);
		    			
		    		}
		    		
		    	}
		        	
		    }
	
		    elements = doc.getElementsByTag("tr");
		    
		    int homeGoals = 0;
			int awayGoals = 0;
			int curr = 0;
			int prev = 0;
			int diff = 0;
			String allText = "";
	    	int index = 0;
	    	int space = 0;
	    	int divider = 0;
	    	String first = "";
	    	String second = "";
	    	String third = "";
	    	int goalMinute = 0;
	    	String goalScorer = "";
	    	String score = "";
	    	String type = "";
	    	String result = "";
			String hg = "";
			String ag = "";
	    	int intHg = 0;
	    	int intAg = 0;
	    	boolean isHomeGoal = false;
	    	boolean isAwayGoal = false;
			String outcome = "";
			String temp = "";
			String remFirstName = "";
	    	
			for (Element element : elements) {
				    	
		    	//pl("SELECTOR: " + element.cssSelector());
		    	//pl("TEXT: " + element.text());
				
		    	if (element.cssSelector().contains("tr.score_row")) {
		    		
		    		allText = element.text();
		    		//pl(allText);
		    		
		    		index = allText.indexOf(":");
		    		
		    		if (index > 0) {
		    		
		    			result = allText.substring(index - 2, index + 4).trim();
		    			result = result.replaceAll(":", "-");
		    			result = result.replaceAll(" ", "");
		    		
		    			index = result.indexOf("-");
		    			hg = result.substring(0, index);
		    			ag = result.substring(index + 1, result.length());
		    			intHg = new Integer(hg).intValue();
		    			intAg = new Integer(ag).intValue();
		    			
		    		}
		    		
		    		index = allText.indexOf("'");
		    		
		    		if (index > 0) {
		    		
		    			//If the ' is on the LHS of - it's a home goal
			    		//Else it's an away goal
		    			divider = allText.indexOf(" - ");

		    			if (divider > 0) {
		    			
		    				goal = new Goal();
			    			this.count ++;
			    			goal.setIdNumber(this.count);
			    			goal.setResult(result);
			    		
			    			score = allText.substring(divider - 2, divider + 4).trim();
			    			goal.setScore(score);
			    			//pl(score);
			    		
			    			first = allText.substring(0, divider);
			    			second = allText.substring(divider, allText.length());
			    			//pl(first);
			    			//pl(second);
			    		
			    			if (first.indexOf("'") > 0) {
			    				
			    				//Goal for the home team
			    				homeGoals = homeGoals + 1;
			    				isHomeGoal = true;
			    				isAwayGoal = false;
			    		
			    				if (intHg > intAg) outcome = "W";
			    				else if (intHg < intAg) outcome = "L";
			    				else outcome = "D";
			    		
			    				goal.setOutcome(outcome);
			    				goal.setHome(1);
			    				goal.setScoredFor(homeTeam);
			    				goal.setAway(0);
			    				goal.setScoredAgainst(awayTeam);
			    				goal.setDate(dateTime);
			    				goal.setTime(localTime);
			    				
			    				if (first.contains(".")) { 
			    					
			    					remFirstName = first.substring(0, first.indexOf(".") - 2) + first.substring(first.indexOf(".") + 1, first.length());
			    					first = remFirstName;
			    					
			    				}
			    				
			    				index = first.indexOf("'");
			    				goalMinute = new Integer(first.substring(0, index)).intValue();
			    				goal.setTimeScored(goalMinute);
			    				space = first.lastIndexOf(" ");
			    		
			    				if ((index + 1) >= (space)) goalScorer = "UNKNOWN";
			    				else goalScorer = first.substring(index + 1, space).trim();
			    				
			    				space = goalScorer.lastIndexOf(" ");
			    				
			    				if (space > 0) goalScorer = goalScorer.substring(0, space).trim();
			    				
			    				goal.setScorer(goalScorer);
			    				//pl(goalScorer);
			    		
			    				if (first.indexOf("(pen)") > 0) goal.setPenalty(true);
			    		
			    			}
			    			
			    			else {
			    				
			    				awayGoals = awayGoals + 1;
			    				isHomeGoal = false;
			    				isAwayGoal = true;
			    		
			    				if (intHg > intAg) outcome = "W";
			    				else if (intHg < intAg) outcome = "L";
			    				else outcome = "D";
			    		
			    				goal.setOutcome(outcome);
			    				goal.setHome(0);
			    				goal.setScoredFor(awayTeam);
			    				goal.setAway(1);
			    				goal.setScoredAgainst(homeTeam);
			    				goal.setDate(dateTime);
			    				goal.setTime(localTime);
			    				index = second.indexOf("'");
			    				space = second.lastIndexOf(" ");
			    				goalMinute = new Integer(second.substring(space + 1, index)).intValue();
			    				goal.setTimeScored(goalMinute);
			    				
			    				if (second.contains(".")) { 
			    					
			    					remFirstName = second.substring(0, second.indexOf(".") - 2) + second.substring(second.indexOf(".") + 1, second.length());
			    					second = remFirstName;
			    					
			    				}
			    				
			    				space = second.lastIndexOf(" ");
			    				third = second.substring(0, space).trim();
			    				index = third.lastIndexOf(" ");
			    				//pl(second);
			    				//pl(third);
			    				
			    				if (third.indexOf("(pen)") > 0) {
			    		
			    					goal.setPenalty(true);
			    					index = third.trim().lastIndexOf(" ");
			    					space = third.trim().indexOf(" ");
			    					//pl("INDEX: " + index);
			    					//pl("SPACE: " + space);
			    					temp = third.substring(space, index).trim();
			    					//pl(temp);
			    					space = temp.trim().indexOf(" ");
			    					//pl("SPACE: " + space);
			    					//pl("LENGTH: " + temp.length());
			    					goalScorer = temp.substring(space, temp.length()).trim();
			    					//pl("SCORER: " + goalScorer);
			    					
			    				}
			    				
			    				else {
			    					
			    					if ((index + 1) >= (third.length())) goalScorer = "UNKNOWN";
			    					else goalScorer = third.substring(index + 1, third.length()).trim();
			    					
			    				}
			    				
			    				space = goalScorer.lastIndexOf(" ");
			    				
			    				if (space > 0) goalScorer = goalScorer.substring(0, space).trim();
			    				
			    				goal.setScorer(goalScorer);
			    				//pl(goalScorer);
			    				
			    			}
			    			
			    			diff = homeGoals - awayGoals;
		    				curr = diff;
		    				
		    				//pl("DIFFERENCE: " + diff);
		    				//pl("CURRENT DIFFERENCE: " + curr);
		    				//pl("PREVIOUS DIFFERENCE: " + prev);
		    				
		    				if (curr > prev) {
		    					
		    					if (homeGoals < awayGoals) 
		    						
		    						if (curr >= 0)
		    							
		    							type = curr + "down";
		    					
		    						else
		    							
		    							type = (curr * -1) + "down";
		    					
		    					
		    					else if (homeGoals == awayGoals) type = "E";
		    					else if (homeGoals > awayGoals) type = curr + "up";
		    					
		    				}
		    				
		    				else if (curr < prev) {
		    					
		    					if (homeGoals < awayGoals) 
		    						
		    						if (curr >= 0)
		    							
		    							type = curr + "down";
		    					
		    						else
		    							
		    							type = (curr * -1) + "down";
		    						
		    					else if (homeGoals == awayGoals) type = "E";
		    					else if (homeGoals > awayGoals) type = curr + "up";
		    					
		    				}
		    				
		    				
		    				goal.setType(type);
		    				prev = curr;
		    				goals.add(goal);
		    				this.csvWriter.write(goal);
		    				
			    			//pl(goal.toString());
		    			
		    			}
		    			
		    			else {
		    				
		    				//No " - " present in text
		    				//pl("DIVIDER IS LESS THAN ZERO: " + divider);
		    				
		    			}
		    			
		    		}
		    		
		    	}
		    	
			}
		    
			this.goals = goals;
			
			//pl("");
			//pl("GOALS: " + this.goals.size());
			
		}
		
		catch (IOException ioe) {
			
			pl("Error getting data for " + url);
			pl(ioe.getMessage());
			ioe.printStackTrace();
			
		}
		
	}
	
	public String getMainURL() {
		return mainURL;
	}

	public void setMainURL(String mainURL) {
		this.mainURL = mainURL;
	}

	public String getSubURL() {
		return subURL;
	}

	public void setSubURL(String subURL) {
		this.subURL = subURL;
	}

	public List<Goal> getGoals() {
		return goals;
	}

	public void setGoals(List<Goal> goals) {
		this.goals = goals;
	}

	public List<String> getURLs() {
		return URLs;
	}

	public void setURLs(List<String> uRLs) {
		URLs = uRLs;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public CSVWriter getCsvWriter() {
		return csvWriter;
	}

	public void setCsvWriter(CSVWriter csvWriter) {
		this.csvWriter = csvWriter;
	}

	private void pl(String s) { System.out.println(s); }

	@Override
	public boolean isPlayOffs() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setPlayOffs(boolean playOffs) {
		// TODO Auto-generated method stub
		
	}
	
}
