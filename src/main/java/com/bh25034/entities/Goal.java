package com.bh25034.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;

@Entity
@Table(name="TBL_GOALS")
public class Goal implements Comparable<Goal> {

	@Id
	@Column(name="ID_NUMBER")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idNumber;
	@Column(name="SCORER")
	private String scorer;
	@Column(name="GOAL_TIME")
	private double timeScored;
	@Column(name="TYPE")
	private String type;
	@Column(name="GOAL_FOR")
	private String scoredFor;
	@Column(name="GOAL_AGAINST")
	private String scoredAgainst;
	@Column(name="HOME")
	private int home;
	@Column(name="AWAY")
	private int away;
	@Column(name="RESULT")
	private String result;
	@Column(name="SCORE")
	private String score;
	@Column(name="GAME_DATE")
	private DateTime date;
	@Column(name="GAME_TIME")
	private LocalTime time;
	@Column(name="PENALTY")
	private boolean penalty;
	private String outcome;
	private boolean playOffGame;
	private boolean injuryTime;
	
	public Goal() {}
	
	public Goal(long idNumber, String scorer, double timeScored, String type, String scoredFor, String scoredAgainst,
			int home, int away, String result, String score, DateTime date, LocalTime time, boolean penalty, String outcome, boolean playOffGame, boolean injuryTime) {
		super();
		this.idNumber = idNumber;
		this.scorer = scorer;
		this.timeScored = timeScored;
		this.type = type;
		this.scoredFor = scoredFor;
		this.scoredAgainst = scoredAgainst;
		this.home = home;
		this.away = away;
		this.result = result;
		this.score = score;
		this.date = date;
		this.time = time;
		this.penalty = penalty;
		this.outcome = outcome;
		this.playOffGame = playOffGame;
		this.injuryTime = injuryTime;
	}

	public long getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(long idNumber) {
		this.idNumber = idNumber;
	}

	public String getScorer() {
		return scorer;
	}

	public void setScorer(String scorer) {
		this.scorer = scorer;
	}

	public double getTimeScored() {
		return timeScored;
	}

	public void setTimeScored(double timeScored) {
		this.timeScored = timeScored;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getScoredFor() {
		return scoredFor;
	}

	public void setScoredFor(String scoredFor) {
		this.scoredFor = scoredFor;
	}

	public String getScoredAgainst() {
		return scoredAgainst;
	}

	public void setScoredAgainst(String scoredAgainst) {
		this.scoredAgainst = scoredAgainst;
	}

	public int getHome() {
		return home;
	}

	public void setHome(int home) {
		this.home = home;
	}

	public int getAway() {
		return away;
	}

	public void setAway(int away) {
		this.away = away;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public boolean isPenalty() {
		return penalty;
	}

	public void setPenalty(boolean penalty) {
		this.penalty = penalty;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}


	/*@Override
	public String toString() {
		
		return "ID Number: " + this.getIdNumber() + "," + 
			"Scorer: " + this.getScorer() + "," + 
			"Time Scored: " + this.getTimeScored() + "," + 
			"Type: " + this.getType() + "," + 
			"Scored For: " + this.getScoredFor() + "," + 
			"Scored Against: " + this.getScoredAgainst() + "," + 
			"Home: " + this.getHome() + "," + 
			"Away: " + this.getAway() + "," + 
			"Result: " + this.getResult() + "," + 
			"Score: " + this.getScore() + "," + 
			"Date: " + this.getDate() + "," + 
			"Time: " + this.getTime() + "," + 
			"Penalty: " + this.isPenalty();
		
	}*/
	
	public boolean isPlayOffGame() {
		return playOffGame;
	}

	public void setPlayOffGame(boolean playOffGame) {
		this.playOffGame = playOffGame;
	}

	public boolean isInjuryTime() {
		return injuryTime;
	}

	public void setInjuryTime(boolean injuryTime) {
		this.injuryTime = injuryTime;
	}

	@Override
	public String toString() {
		
		return this.getIdNumber() + "," + 
			this.getScorer() + "," + 
			this.getTimeScored() + "," + 
			this.getType() + "," + 
			this.getScoredFor() + "," + 
			this.getScoredAgainst() + "," + 
			this.getHome() + "," + 
			this.getAway() + "," + 
			this.getResult() + "," + 
			this.getScore() + "," + 
			this.getDate() + "," + 
			this.getTime() + "," + 
			this.isPenalty() + "," + 
			this.getOutcome() + "," + 
			this.isPlayOffGame() + "," + 
			this.isInjuryTime() + "\n";
		
	}
	
	@Override
	public int compareTo(Goal o) {
		
		return Long.compare(this.idNumber, o.getIdNumber());
		
	}
	
}
