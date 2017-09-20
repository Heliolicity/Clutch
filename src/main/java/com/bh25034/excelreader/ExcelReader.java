package com.bh25034.excelreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;

import com.google.common.base.Optional;

import com.bh25034.entities.Goal;

/**
 * Code based on example taken from: 
 * @author www.codejava.net
 *
 */
public class ExcelReader {
    
	private String excelFilePath;
	private FileInputStream inputStream;
	private List<Goal> goals;
	
	public ExcelReader() {}

	public ExcelReader(String excelFilePath) {
		this.excelFilePath = excelFilePath;
	}
	
    public void readIn() throws IOException {

    	this.inputStream = new FileInputStream(new File(this.excelFilePath));
         
        Workbook workbook = new XSSFWorkbook(this.inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();

        this.goals = new ArrayList<Goal>();
        
        while (iterator.hasNext()) {
            
        	Goal goal = new Goal();
        	
        	Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            
            if (nextRow.getRowNum() > 0) {
            
	            while (cellIterator.hasNext()) {
	            
	            	Cell cell = cellIterator.next();
	            	int column = cell.getColumnIndex();
	            	int type = cell.getCellType();
	            	Double db;
	            	Date date;
	            	DateTime dateTime;
	            	Boolean b;
	            	LocalTime localTime;
	            	
	            	switch(column) {
	            		
		            	case 0 : 
		            		if (type == Cell.CELL_TYPE_NUMERIC) {
		            			
			            		db = new Double(cell.getNumericCellValue());
			            		goal.setIdNumber(db.intValue());
			            		
		            		}
		            		
		            		break;
		            	case 1 : 
		            		goal.setScorer(cell.getStringCellValue()); 
			        		break;
		            	case 2 : 
		            		if (type == Cell.CELL_TYPE_NUMERIC) {
		            			
			            		db = new Double(cell.getNumericCellValue());
				        		goal.setTimeScored(db.doubleValue());
				        		
		            		}
		            		
			        		break;	
		            	case 3 : 
		            		goal.setType(cell.getStringCellValue()); 
		        			break;
		            	case 4 : 
		            		goal.setScoredFor(cell.getStringCellValue()); 
		        			break;
		            	case 5 : 
		            		goal.setScoredAgainst(cell.getStringCellValue()); 
		        			break;
		            	case 6 :
		            		if (type == Cell.CELL_TYPE_NUMERIC){
		            		
		            			db = new Double(cell.getNumericCellValue());
		            			goal.setHome(db.intValue());
		            		
		            		}
		            		
			        		break;
		            	case 7 :
		            		if (type == Cell.CELL_TYPE_NUMERIC || type == Cell.CELL_TYPE_FORMULA) {
		            			
			            		db = new Double(cell.getNumericCellValue());
				        		goal.setAway(db.intValue());
				        		
		            		}
		            		
			        		break;
		            	case 8 : 
		            		goal.setResult(cell.getStringCellValue()); 
		        			break;
		            	case 9 : 
		            		goal.setScore(cell.getStringCellValue());
		            		break;
		            	case 10 :
		            		if (type == Cell.CELL_TYPE_NUMERIC) {
			            		
		            			date = cell.getDateCellValue();
				            	dateTime = new DateTime(date);
				            	goal.setDate(dateTime);
				            	
		            		}
		            		
			        		break;
		            	case 11 :
		            		if (type == Cell.CELL_TYPE_NUMERIC) {
		            			
			            		date = cell.getDateCellValue();
				            	localTime = new LocalTime(date);
				            	goal.setTime(localTime);
				            	
		            		}
		            		
			        		break;
		            	case 12 :
		            		if (type == Cell.CELL_TYPE_BOOLEAN) {
		            			
			            		b = cell.getBooleanCellValue();
				            	Optional<Boolean> optB = Optional.of(b);
				            	boolean bn = optB.or(false);
				            	goal.setPenalty(bn);
				            	
			            	}
		            		
			            	break;
	            	
	            	}
	            	
	            }

	            this.goals.add(goal);
	            
            }
            
        }
         
        workbook.close();
        this.inputStream.close();
        
    }
 
    public List<Goal> getGoals() {
		return goals;
	}

	public void setGoals(List<Goal> goals) {
		this.goals = goals;
	}

	private void pl(String s) { System.out.println(s); }
    
}
