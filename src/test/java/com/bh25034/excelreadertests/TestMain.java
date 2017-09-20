package com.bh25034.excelreadertests;

import java.io.IOException;

import com.bh25034.excelreader.ExcelReader;

public class TestMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExcelReader reader = new ExcelReader("1617_EPL_RAW");
		reader.readIn();

	}

}
