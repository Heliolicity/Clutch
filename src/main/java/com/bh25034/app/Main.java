package com.bh25034.app;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bh25034.crawler.Crawler;
import com.bh25034.crawler.Runner;
import com.bh25034.crawler.impl.CrawlerImpl;
import com.bh25034.crawler.impl.CrawlerImplMLS;
import com.bh25034.crawler.impl.RunnerImpl;
import com.bh25034.crawler.impl.RunnerImplMLS;
import com.bh25034.csvwriter.CSVWriter;
//import com.bh25034.dao.GoalDAO;
//import com.bh25034.dao.impl.GoalDAOImpl;

public class Main {

	public static void main(String args []) {
		
		DateTime dateTime = new DateTime();
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		CSVWriter writer = (CSVWriter) context.getBean("writer");
		
		Crawler crawler = (CrawlerImpl) context.getBean("crawler");
		//Crawler crawler = (CrawlerImplMLS) context.getBean("crawlerMLS");
		crawler.setCsvWriter(writer);
	
		Runner runner = (RunnerImpl) context.getBean("runner");
		//Runner runner = (RunnerImplMLS) context.getBean("runnerMLS");
		runner.setCrawler(crawler);
		dateTime = new DateTime();
		pl(dateTime + ": Started getting match reports");
		runner.scrapeLinks();
		dateTime = new DateTime();
		pl(dateTime + ": Finished getting match reports");
		dateTime = new DateTime();
		pl(dateTime + ": Started getting goals");
		runner.run();
		dateTime = new DateTime();
		pl(dateTime + ": Finished getting goals");
		
		//GoalDAO goalDAO = (GoalDAOImpl) context.getBean("goalDAOImpl");
		//goalDAO.getGoals();
		
	}
	
	private static void pl(String s) { System.out.println(s); }
	
}
