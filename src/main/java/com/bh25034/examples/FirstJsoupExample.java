package com.bh25034.examples;

//import java.io.File;
import java.io.IOException;
//import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
//import org.joda.time.format.DateTimeFormat;
//import org.joda.time.format.DateTimeFormatter;
//import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;  

import com.bh25034.entities.Goal;

public class FirstJsoupExample{  

	public static void main( String[] args ) throws IOException {

		List<Goal> goals = new ArrayList<Goal>();
		
		String url = "http://www.scorespro.com/soccer/livescore/newcastle-vs-arsenal/14-05-2000/";
		
		//StringTokenizer st;
		
	    Document doc = Jsoup.connect(url).get();  
	
	    /*Elements links = doc.select("a[href]");  
	    for (Element link : links) {  
	        System.out.println("\nlink : " + link.attr("href"));  
	        System.out.println("text : " + link.text());  
	    } */
	    
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
	    //DateTimeFormatter formatter = DateTimeFormat.forPattern("dd MMM yyyy");
	    LocalTime localTime = new LocalTime();
	    
	    for (Element element : elements) {
	    	
	    	//pl("SELECTOR: " + element.cssSelector());
	    	//pl("TEXT: " + element.text());
	    	//pl(element.nodeName());
	    	//pl(element.tagName());
	    	
	    	if (element.cssSelector().equals("html")) {
	    		
	    		text = element.text();
	    		
	    		if (text.contains("vs")) {
	    			
	    			//pl(text);
	    			homeTeam = text.substring(0, text.indexOf("vs")).trim();
	    			//pl(homeTeam);
	    			awayTeam = text.substring(text.indexOf("vs") + 2, text.indexOf("-")).trim();
	    			//pl(awayTeam);
	    			
	    			text = text.substring(text.indexOf("-") + 1, text.length()).trim();
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
		
		for (Element element : elements) {
			    	
	    	//pl("SELECTOR: " + element.cssSelector());
	    	//pl("TEXT: " + element.text());
			
	    	//pl("TEXT: " + element.text());
	    	
	    	if (element.cssSelector().contains("tr.score_row")) {
	    		
	    		allText = element.text();
	    		index = allText.indexOf("'");
	    		
	    		if (index > 0) {
	    			
	    			goal = new Goal();
	    			
		    		//If the ' is on the LHS of - it's a home goal
		    		//Else it's an away goal
	    			
	    			divider = allText.indexOf("-");
	    			score = allText.substring(divider - 2, divider + 3);
	    			goal.setScore(score);
	    			
	    			first = allText.substring(0, divider);
	    			second = allText.substring(divider, allText.length());
	    			
	    			if (first.indexOf("'") > 0) {
	    			
	    				//Goal for the home team
	    				homeGoals = homeGoals + 1;
	    				
	    				goal.setHome(1);
	    				goal.setScoredFor(homeTeam);
	    				goal.setAway(0);
	    				goal.setScoredAgainst(awayTeam);
	    				goal.setDate(dateTime);
	    				goal.setTime(localTime);
	    				index = first.indexOf("'");
	    				goalMinute = new Integer(first.substring(0, index)).intValue();
	    				goal.setTimeScored(goalMinute);
	    				space = first.lastIndexOf(" ");
	    				goalScorer = first.substring(index + 1, space - 1).trim();
	    				goal.setScorer(goalScorer);
	    				
	    			}
	    			
	    			else {
	    				
	    				awayGoals = awayGoals + 1;
	    				
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
	    				space = second.lastIndexOf(" ");
	    				third = second.substring(0, space).trim();
	    				index = third.lastIndexOf(" ");
	    				goalScorer = third.substring(index + 1, space).trim();
	    				goal.setScorer(goalScorer);
	    				
	    			}
	    			
	    			diff = homeGoals - awayGoals;
    				curr = diff;
    				
    				//pl("DIFFERENCE: " + diff);
    				//pl("CURRENT DIFFERENCE: " + curr);
    				//pl("PREVIOUS DIFFERENCE: " + prev);
    				
    				if (curr > prev) {
    					
    					if (homeGoals < awayGoals) type = curr + "down";
    					else if (homeGoals == awayGoals) type = "E";
    					else if (homeGoals > awayGoals) type = curr + "up";
    					
    				}
    				
    				else if (curr < prev) {
    					
    					if (homeGoals < awayGoals) type = curr + "down";
    					else if (homeGoals == awayGoals) type = "E";
    					else if (homeGoals > awayGoals) type = curr + "up";
    					
    				}
    				
    				
    				goal.setType(type);
    				prev = curr;
	    			
    				goals.add(goal);
	    			pl(goal.toString());
	    			
	    		}
	    		
	    	}
	    	
		}
	    
		pl("");
		pl("GOALS: " + goals.size());
		
	}
	
	private static void pl(String s) { System.out.println(s); }
	
}  