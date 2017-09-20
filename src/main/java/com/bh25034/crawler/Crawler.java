package com.bh25034.crawler;

import java.io.IOException;
import java.util.List;

import com.bh25034.csvwriter.CSVWriter;
import com.bh25034.entities.Goal;

public interface Crawler {

	public void scrapeLinks() throws IOException;
	
	public void scrapeGoals(String url);
	
	public String getMainURL();
	
	public void setMainURL(String mainURL);
	
	public String getSubURL();
	
	public void setSubURL(String subURL);
	
	public List<String> getURLs();
	
	public void setURLs(List<String> URLs);
	
	public int getCount();
	
	public void setCount(int count);
	
	public List<Goal> getGoals();
	
	//public void setGoals(List<Goal> goals);
	
	//public CSVWriter getCsvWriter();
	
	public void setCsvWriter(CSVWriter writer);
	
	public boolean isPlayOffs();
	
	public void setPlayOffs(boolean playOffs);
	
	
}
