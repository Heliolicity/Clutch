package com.bh25034.engine;

import java.util.List;
import java.util.stream.Collectors;
//import java.util.stream.Stream;
import java.util.ArrayList;

import com.bh25034.entities.Goal;
import com.bh25034.entities.GoalType;

public class CalculationEngine {
	
	private List<Goal> goals;
	private List<GoalType> goalTypes;
	
	private long totalGoals;
	private long totalGoalsE;
	private long totalGoals1up;
	private long totalGoals2up;
	private long totalGoals3up;
	private long totalGoals4up;
	private long totalGoals5up;
	private long totalGoals6up;
	private long totalGoals1down;
	private long totalGoals2down;
	private long totalGoals3down;
	private long totalGoals4down;
	private long totalGoalsEWin;
	private long totalGoalsEDraw;
	private long totalGoalsELoss;
	private long totalGoals1upWin;
	private long totalGoals1upDraw;
	private long totalGoals1upLoss;
	private long totalGoals2upWin;
	private long totalGoals2upDraw;
	private long totalGoals2upLoss;
	private long totalGoals3upWin;
	private long totalGoals3upDraw;
	private long totalGoals3upLoss;
	private long totalGoals4upWin;
	private long totalGoals4upDraw;
	private long totalGoals4upLoss;
	private long totalGoals5upWin;
	private long totalGoals5upDraw;
	private long totalGoals5upLoss;
	private long totalGoals6upWin;
	private long totalGoals6upDraw;
	private long totalGoals6upLoss;
	private long totalGoals1downWin;
	private long totalGoals1downDraw;
	private long totalGoals1downLoss;
	private long totalGoals2downWin;
	private long totalGoals2downDraw;
	private long totalGoals2downLoss;
	private long totalGoals3downWin;
	private long totalGoals3downDraw;
	private long totalGoals3downLoss;
	private long totalGoals4downWin;
	private long totalGoals4downDraw;
	private long totalGoals4downLoss;
	
	public CalculationEngine() {}
	
	public CalculationEngine(List<Goal> goals) {
		super();
		this.goals = goals;
	}
	
	public void run() {
		
		this.goalTypes = new ArrayList<GoalType>();
		
		List<Goal> tmp;
		List<Goal> tmpW;
		List<Goal> tmpD;
		List<Goal> tmpL;
		
		GoalType goalType;
		
		this.totalGoals = this.goals.size();
		
		tmp = this.goals.stream().filter(g -> g.getType().equals("E")).collect(Collectors.toList());
		this.totalGoalsE = tmp.size();
		tmpW = tmp.stream().filter(g -> g.getResult().equals("W")).collect(Collectors.toList());
		this.totalGoalsEWin = tmpW.size();
		tmpD = tmp.stream().filter(g -> g.getResult().equals("D")).collect(Collectors.toList());
		this.totalGoalsEDraw = tmpD.size();
		tmpL = tmp.stream().filter(g -> g.getResult().equals("L")).collect(Collectors.toList());
		this.totalGoalsELoss = tmpL.size();
		
		goalType = new GoalType();
		goalType.setType("E");
		goalType.setResult("T");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoalsE / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("E");
		goalType.setResult("W");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoalsEWin / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("E");
		goalType.setResult("D");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoalsEDraw / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("E");
		goalType.setResult("L");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoalsELoss / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		tmp = this.goals.stream().filter(g -> g.getType().equals("1 up")).collect(Collectors.toList());
		this.totalGoals1up = tmp.size();
		tmpW = tmp.stream().filter(g -> g.getResult().equals("W")).collect(Collectors.toList());
		this.totalGoals1upWin = tmpW.size();
		tmpD = tmp.stream().filter(g -> g.getResult().equals("D")).collect(Collectors.toList());
		this.totalGoals1upDraw = tmpD.size();
		tmpL = tmp.stream().filter(g -> g.getResult().equals("L")).collect(Collectors.toList());
		this.totalGoals1upLoss = tmpL.size();
		
		goalType = new GoalType();
		goalType.setType("1 up");
		goalType.setResult("T");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals1up / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("1 up");
		goalType.setResult("W");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals1upWin / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("1 up");
		goalType.setResult("D");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals1upDraw / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("1 up");
		goalType.setResult("L");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals1upLoss / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		tmp = this.goals.stream().filter(g -> g.getType().equals("2 up")).collect(Collectors.toList());
		this.totalGoals2up = tmp.size();
		tmpW = tmp.stream().filter(g -> g.getResult().equals("W")).collect(Collectors.toList());
		this.totalGoals2upWin = tmpW.size();
		tmpD = tmp.stream().filter(g -> g.getResult().equals("D")).collect(Collectors.toList());
		this.totalGoals2upDraw = tmpD.size();
		tmpL = tmp.stream().filter(g -> g.getResult().equals("L")).collect(Collectors.toList());
		this.totalGoals2upLoss = tmpL.size();
		
		goalType = new GoalType();
		goalType.setType("2 up");
		goalType.setResult("T");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals2up / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("2 up");
		goalType.setResult("W");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals2upWin / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("2 up");
		goalType.setResult("D");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals2upDraw / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("2 up");
		goalType.setResult("L");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals2upLoss / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		tmp = this.goals.stream().filter(g -> g.getType().equals("3 up")).collect(Collectors.toList());
		this.totalGoals3up = tmp.size();
		tmpW = tmp.stream().filter(g -> g.getResult().equals("W")).collect(Collectors.toList());
		this.totalGoals3upWin = tmpW.size();
		tmpD = tmp.stream().filter(g -> g.getResult().equals("D")).collect(Collectors.toList());
		this.totalGoals3upDraw = tmpD.size();
		tmpL = tmp.stream().filter(g -> g.getResult().equals("L")).collect(Collectors.toList());
		this.totalGoals3upLoss = tmpL.size();
		
		goalType = new GoalType();
		goalType.setType("3 up");
		goalType.setResult("T");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals3up / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("3 up");
		goalType.setResult("W");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals3upWin / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("3 up");
		goalType.setResult("D");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals3upDraw / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("3 up");
		goalType.setResult("L");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals3upLoss / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		tmp = this.goals.stream().filter(g -> g.getType().equals("4 up")).collect(Collectors.toList());
		this.totalGoals4up = tmp.size();
		tmpW = tmp.stream().filter(g -> g.getResult().equals("W")).collect(Collectors.toList());
		this.totalGoals4upWin = tmpW.size();
		tmpD = tmp.stream().filter(g -> g.getResult().equals("D")).collect(Collectors.toList());
		this.totalGoals4upDraw = tmpD.size();
		tmpL = tmp.stream().filter(g -> g.getResult().equals("L")).collect(Collectors.toList());
		this.totalGoals4upLoss = tmpL.size();
		
		goalType = new GoalType();
		goalType.setType("4 up");
		goalType.setResult("T");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals4up / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("4 up");
		goalType.setResult("W");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals4upWin / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("4 up");
		goalType.setResult("D");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals4upDraw / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("4 up");
		goalType.setResult("L");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals4upLoss / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		tmp = this.goals.stream().filter(g -> g.getType().equals("5 up")).collect(Collectors.toList());
		this.totalGoals5up = tmp.size();
		tmpW = tmp.stream().filter(g -> g.getResult().equals("W")).collect(Collectors.toList());
		this.totalGoals5upWin = tmpW.size();
		tmpD = tmp.stream().filter(g -> g.getResult().equals("D")).collect(Collectors.toList());
		this.totalGoals5upDraw = tmpD.size();
		tmpL = tmp.stream().filter(g -> g.getResult().equals("L")).collect(Collectors.toList());
		this.totalGoals5upLoss = tmpL.size();
		
		goalType = new GoalType();
		goalType.setType("5 up");
		goalType.setResult("T");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals5up / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("5 up");
		goalType.setResult("W");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals5upWin / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("5 up");
		goalType.setResult("D");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals5upDraw / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("5 up");
		goalType.setResult("L");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals5upLoss / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		tmp = this.goals.stream().filter(g -> g.getType().equals("6 up")).collect(Collectors.toList());
		this.totalGoals6up = tmp.size();
		tmpW = tmp.stream().filter(g -> g.getResult().equals("W")).collect(Collectors.toList());
		this.totalGoals6upWin = tmpW.size();
		tmpD = tmp.stream().filter(g -> g.getResult().equals("D")).collect(Collectors.toList());
		this.totalGoals6upDraw = tmpD.size();
		tmpL = tmp.stream().filter(g -> g.getResult().equals("L")).collect(Collectors.toList());
		this.totalGoals6upLoss = tmpL.size();
		
		goalType = new GoalType();
		goalType.setType("6 up");
		goalType.setResult("T");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals6up / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("6 up");
		goalType.setResult("W");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals6upWin / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("6 up");
		goalType.setResult("D");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals6upDraw / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("6 up");
		goalType.setResult("L");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals6upLoss / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		tmp = this.goals.stream().filter(g -> g.getType().equals("1 down")).collect(Collectors.toList());
		this.totalGoals1down = tmp.size();
		tmpW = tmp.stream().filter(g -> g.getResult().equals("W")).collect(Collectors.toList());
		this.totalGoals1downWin = tmpW.size();
		tmpD = tmp.stream().filter(g -> g.getResult().equals("D")).collect(Collectors.toList());
		this.totalGoals1downDraw = tmpD.size();
		tmpL = tmp.stream().filter(g -> g.getResult().equals("L")).collect(Collectors.toList());
		this.totalGoals1downLoss = tmpL.size();
		
		goalType = new GoalType();
		goalType.setType("1 down");
		goalType.setResult("T");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals1down / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("1 down");
		goalType.setResult("W");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals1downWin / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("1 down");
		goalType.setResult("D");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals1downDraw / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("1 down");
		goalType.setResult("L");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals1downLoss / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		tmp = this.goals.stream().filter(g -> g.getType().equals("2 down")).collect(Collectors.toList());
		this.totalGoals2down = tmp.size();
		tmpW = tmp.stream().filter(g -> g.getResult().equals("W")).collect(Collectors.toList());
		this.totalGoals2downWin = tmpW.size();
		tmpD = tmp.stream().filter(g -> g.getResult().equals("D")).collect(Collectors.toList());
		this.totalGoals2downDraw = tmpD.size();
		tmpL = tmp.stream().filter(g -> g.getResult().equals("L")).collect(Collectors.toList());
		this.totalGoals2downLoss = tmpL.size();

		goalType = new GoalType();
		goalType.setType("2 down");
		goalType.setResult("T");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals2down / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("2 down");
		goalType.setResult("W");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals2downWin / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("2 down");
		goalType.setResult("D");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals2downDraw / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("2 down");
		goalType.setResult("L");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals2downLoss / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		tmp = this.goals.stream().filter(g -> g.getType().equals("3 down")).collect(Collectors.toList());
		this.totalGoals3down = tmp.size();
		tmpW = tmp.stream().filter(g -> g.getResult().equals("W")).collect(Collectors.toList());
		this.totalGoals3downWin = tmpW.size();
		tmpD = tmp.stream().filter(g -> g.getResult().equals("D")).collect(Collectors.toList());
		this.totalGoals3downDraw = tmpD.size();
		tmpL = tmp.stream().filter(g -> g.getResult().equals("L")).collect(Collectors.toList());
		this.totalGoals3downLoss = tmpL.size();
		
		goalType = new GoalType();
		goalType.setType("3 down");
		goalType.setResult("T");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals3down / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("3 down");
		goalType.setResult("W");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals3downWin / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("3 down");
		goalType.setResult("D");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals3downDraw / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("3 down");
		goalType.setResult("L");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals3downLoss / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		tmp = this.goals.stream().filter(g -> g.getType().equals("4 down")).collect(Collectors.toList());
		this.totalGoals4down = tmp.size();
		tmpW = tmp.stream().filter(g -> g.getResult().equals("W")).collect(Collectors.toList());
		this.totalGoals4downWin = tmpW.size();
		tmpD = tmp.stream().filter(g -> g.getResult().equals("D")).collect(Collectors.toList());
		this.totalGoals4downDraw = tmpD.size();
		tmpL = tmp.stream().filter(g -> g.getResult().equals("L")).collect(Collectors.toList());
		this.totalGoals4downLoss = tmpL.size();
		
		goalType = new GoalType();
		goalType.setType("4 down");
		goalType.setResult("T");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals4down / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("4 down");
		goalType.setResult("W");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals4downWin / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("4 down");
		goalType.setResult("D");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals4downDraw / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		goalType = new GoalType();
		goalType.setType("4 down");
		goalType.setResult("L");
		
		if (this.totalGoals > 0) goalType.setRarity(this.totalGoals4downLoss / this.totalGoals);
		else goalType.setRarity(0);
		
		this.goalTypes.add(goalType);
		
		/*pl("" + this.totalGoals);
		pl("" + this.totalGoalsE);
		pl("" + this.totalGoals1up);
		pl("" + this.totalGoals2up);
		pl("" + this.totalGoals3up);
		pl("" + this.totalGoals4up);
		pl("" + this.totalGoals5up);
		pl("" + this.totalGoals6up);
		pl("" + this.totalGoals1down);
		pl("" + this.totalGoals2down);
		pl("" + this.totalGoals3down);
		pl("" + this.totalGoals4down);
		pl("" + this.totalGoalsEWin);
		pl("" + this.totalGoalsEDraw);
		pl("" + this.totalGoalsELoss);
		pl("" + this.totalGoals1upWin);
		pl("" + this.totalGoals1upDraw);
		pl("" + this.totalGoals1upLoss);
		pl("" + this.totalGoals2upWin);
		pl("" + this.totalGoals2upDraw);
		pl("" + this.totalGoals2upLoss);
		pl("" + this.totalGoals3upWin);
		pl("" + this.totalGoals3upDraw);
		pl("" + this.totalGoals3upLoss);
		pl("" + this.totalGoals4upWin);
		pl("" + this.totalGoals4upDraw);
		pl("" + this.totalGoals4upLoss);
		pl("" + this.totalGoals5upWin);
		pl("" + this.totalGoals5upDraw);
		pl("" + this.totalGoals5upLoss);
		pl("" + this.totalGoals6upWin);
		pl("" + this.totalGoals6upDraw);
		pl("" + this.totalGoals6upLoss);
		pl("" + this.totalGoals1downWin);
		pl("" + this.totalGoals1downDraw);
		pl("" + this.totalGoals1downLoss);
		pl("" + this.totalGoals2downWin);
		pl("" + this.totalGoals2downDraw);
		pl("" + this.totalGoals2downLoss);
		pl("" + this.totalGoals3downWin);
		pl("" + this.totalGoals3downDraw);
		pl("" + this.totalGoals3downLoss);
		pl("" + this.totalGoals4downWin);
		pl("" + this.totalGoals4downDraw);
		pl("" + this.totalGoals4downLoss);*/
		
	}
	
	public List<Goal> getGoals() {
		return goals;
	}

	public void setGoals(List<Goal> goals) {
		this.goals = goals;
	}

	public List<GoalType> getGoalTypes() {
		return goalTypes;
	}

	public void setGoalTypes(List<GoalType> goalTypes) {
		this.goalTypes = goalTypes;
	}

	//private void pl(String s) { System.out.println(s); }
	
}
