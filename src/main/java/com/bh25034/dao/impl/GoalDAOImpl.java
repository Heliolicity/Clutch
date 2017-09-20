package com.bh25034.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bh25034.dao.GoalDAO;
import com.bh25034.entities.Goal;

public class GoalDAOImpl implements GoalDAO {

	private SessionFactory sessionFactory;

    public GoalDAOImpl() {}
	
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	@Override
	public List<Goal> getGoals() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		List<Goal> goals = session.createQuery("from Goal").list();
		session.close();
		return null;
	}

	@Override
	public List<Goal> getGoals(List<Goal> goals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goal> getGoal(Goal goal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean writeGoal(Goal goal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean writeGoals(List<Goal> goals) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateGoal(Goal goal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateGoals(List<Goal> goals) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteGoal(Goal goal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteGoals(List<Goal> goals) {
		// TODO Auto-generated method stub
		return false;
	}

}
