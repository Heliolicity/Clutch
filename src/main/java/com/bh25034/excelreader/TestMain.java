package com.bh25034.excelreader;

import java.io.IOException;

public class TestMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExcelReader reader = new ExcelReader("1617_EPL_RAW.xlsx");
		reader.readIn();

	}

}
