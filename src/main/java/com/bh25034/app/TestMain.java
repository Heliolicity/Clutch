package com.bh25034.app;

import java.io.IOException;
import java.util.List;

import com.bh25034.engine.CalculationEngine;
import com.bh25034.entities.Goal;
import com.bh25034.excelreader.ExcelReader;

public class TestMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ExcelReader reader = new ExcelReader("1617_EPL_RAW.xlsx");
		reader.readIn();
		List<Goal> goals = reader.getGoals();
		CalculationEngine engine = new CalculationEngine(goals);
		engine.run();
		
	}

}
