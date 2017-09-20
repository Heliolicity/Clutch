package com.bh25034.entities;

public class GoalType {

	private String type;
	private String result;
	private double rarity;
	
	public GoalType() {}
	
	public GoalType(String type, String result, double rarity) {
		super();
		this.type = type;
		this.result = result;
		this.rarity = rarity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public double getRarity() {
		return rarity;
	}

	public void setRarity(double rarity) {
		this.rarity = rarity;
	}
	
	@Override
	public String toString() {
		
		return this.type + "\n" + 
				this.result + "\n" + 
				this.rarity;
		
	}
	
}
