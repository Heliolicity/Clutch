package com.bh25034.csvwriter;

import java.io.FileWriter;
import java.io.IOException;

import com.bh25034.entities.Goal;

public class CSVWriter {

	private String path;
	private boolean append;
	private FileWriter writer;
	private Goal goal;
	
	public CSVWriter() {}
	
	public CSVWriter(String path, boolean append) {
		super();
		this.path = path;
		this.append = append;
	}

	public void write(Goal goal) throws IOException {
		
		this.goal = goal;
		this.writer = new FileWriter(this.path, this.append);
		this.writer.append(this.goal.toString());
		this.writer.flush();
		this.writer.close();
		
	}
	
	public void write(String s) throws IOException {
		
		this.writer = new FileWriter(this.path, this.append);
		this.writer.append(s);
		this.writer.flush();
		this.writer.close();
		
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isAppend() {
		return append;
	}

	public void setAppend(boolean append) {
		this.append = append;
	}
	
	
	
}
