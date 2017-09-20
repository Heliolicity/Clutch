package com.bh25034.dao;

import java.util.List;

import com.bh25034.entities.Goal;

public interface GoalDAO {

	public List<Goal> getGoals();
	
	public List<Goal> getGoals(List<Goal> goals);
	
	public List<Goal> getGoal(Goal goal);
	
	public boolean writeGoal(Goal goal);
	
	public boolean writeGoals(List<Goal> goals);
	
	public boolean updateGoal(Goal goal);
	
	public boolean updateGoals(List<Goal> goals);
	
	public boolean deleteGoal(Goal goal);
	
	public boolean deleteGoals(List<Goal> goals);
	
}
