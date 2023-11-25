package com.utils;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Iterator;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestUtility {
	public static int jobId;

	public static String toJson(Object src) {
		Gson gson = new Gson();
		String jsonObject = gson.toJson(src);
		return jsonObject;
	}

	public static Object toPojo(String src, Type type) {
		Gson gson = new Gson();
		Object pojoObject = gson.fromJson(src, type);
		return pojoObject;
	}


	public static Iterator<String[]> readCSVfile(String filename) {
		File file = new File(System.getProperty("user.dir") + "//testdata//" + filename);
		FileReader filereader = null;
		CSVReader csvReader;
		List<String[]> dataList = null;
		try {
			filereader = new FileReader(file);
			csvReader = new CSVReader(filereader);
			dataList = csvReader.readAll();
			csvReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvException e) {
			e.printStackTrace();
		}
		Iterator<String[]> dataIterator = dataList.iterator();
		dataIterator.next(); // starts from the next line on csv file
		return dataIterator;
	}

	/**
	 * Used to read the full excel file with provided file name and sheet name on
	 * excelsheet
	 */
	public static String[][] readExcelSheet(String fileName, String sheetName) {
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(System.getProperty("user.dir") + "\\testData\\" + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet(sheetName);
		XSSFRow rowHeader = sheet.getRow(0);
		int lastRowIndex = sheet.getLastRowNum();
		int totalColumns = rowHeader.getLastCellNum();
		XSSFRow row;
		XSSFCell cell;
		String[][] excelArray = new String[lastRowIndex][totalColumns];
		for (int rowIndex = 1; rowIndex <= lastRowIndex; rowIndex++) {
			row = sheet.getRow(rowIndex);
			for (int cellIndex = 0; cellIndex < totalColumns; cellIndex++) {
				cell = row.getCell(cellIndex);
				excelArray[rowIndex - 1][cellIndex] = cell.toString();
			}
		}
		return excelArray;
	}

	public static String getPropertyFrom(String propertyFileName, String key) {
		File file = new File(System.getProperty("user.dir") + "\\config\\" + propertyFileName);
		FileReader fileReader = null;
		Properties properties = null;
		try {
			fileReader = new FileReader(file);
			properties = new Properties();
			properties.load(fileReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String value = properties.getProperty(key);
		return value;
	}

	public static File getSchemaFile(String fileName) {
		File schema = new File(System.getProperty("user.dir") + "\\testData\\" + fileName);
		return schema;
	}



}
