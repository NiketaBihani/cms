package com.hmh.automation.utils;

/****************************************************************************************************************************
#Java Class Name: Excel Reader ()
#Description: Helps in reading and writing into xls
#Created By: Niketa Bihani
#Date of creation: 16-Aug-2018
#Input Parameters: NILL
#Name of person modifying: 
#Date of modification: 

 ****************************************************************************************************************************/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public  String sPath; 
	public  FileInputStream fIS = null; 
	public  FileOutputStream fOut =null; 
	private XSSFWorkbook workbook = null; 
	private XSSFSheet sheet = null;
	private XSSFRow row   =null;
	private XSSFCell cell = null;

	public ExcelReader(String sPath) {
		this.sPath=sPath;
		try {
			fIS = new FileInputStream(sPath);
			workbook = new XSSFWorkbook(fIS);
			sheet = workbook.getSheetAt(0);
			fIS.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public int defGetRowCount(String sheetName){
		int iIndex = workbook.getSheetIndex(sheetName); // gets the index of the sheet given as an input
		// index will be -1 if the sheet does not exist in the 
		if(iIndex==-1){
			return 0;
		} else{
			sheet = workbook.getSheetAt(iIndex);
			int iNumber=sheet.getLastRowNum()+1;
			return iNumber;
		}
	}

	public String defGetCellData(String sSheetName, String sColName, int iRowNum) {
		try {
			// initialise the String which will hold the data

			String sData;

			// to verify the row number
			if (iRowNum <= 0) {
				return "";
			}

			int iIndex = workbook.getSheetIndex(sSheetName);
			int iColNum = -1;

			// to verify whether is sheet is present or not
			if (iIndex == -1) {
				return "";
			}

			// if sheet is present get the index of the sheet in the work book
			sheet = workbook.getSheetAt(iIndex);

			// go to the first row of the sheet
			row = sheet.getRow(0);

			// loop to get the column number for the given column name give as
			// the input parameter
			for (int i = 0; i < row.getLastCellNum(); i++) {

				if (row.getCell(i).getStringCellValue().trim()
						.equals(sColName.trim())) {
					iColNum = i; // iColNum will hold the column number
				}
			}

			if (iColNum == -1) {
				return "";
			}

			// point to the rownumber specified as the input parameter for sheet
			row = sheet.getRow(iRowNum - 1);

			// to check number is present in sheet
			if (row == null) {
				return "";
			}

			// point to the cell of the given row and coloum
			cell = row.getCell(iColNum);

			// to check if cell is existed or not
			if (cell == null) {
				return "";
			}

			// check the type of the cell and move the data into sData string
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				sData = cell.getRichStringCellValue().getString();
				break;
			case Cell.CELL_TYPE_NUMERIC:

				long t = (long) cell.getNumericCellValue();
				String cellText = String.valueOf(t);
				if (DateUtil.isCellDateFormatted(cell)) {

					double d = cell.getNumericCellValue();
					Calendar cal = Calendar.getInstance();
					cal.setTime(DateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR)))
							.substring(2);
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/"
							+ cal.get(Calendar.MONTH) + 1 + "/" + cellText;
				}
				sData = cellText;
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				sData = String.valueOf(cell.getBooleanCellValue());
				break;
			case Cell.CELL_TYPE_FORMULA:
				sData = cell.getCellFormula();
				break;
			default:
				sData = "";
			}
			return sData;
		}

		catch (Exception e) {
			e.printStackTrace();
			return "row " + iRowNum + " or column " + sColName
					+ " does not exist in xls";
		}
	}


	public String defGetCellDataCR(String sSheetName,int iColNum,int iRowNum){
		try{

			// initialise the String which will hold the data 

			String sData;

			// to verify the row number 
			if(iRowNum <=0){
				return "";
			}


			int iIndex = workbook.getSheetIndex(sSheetName);
			int iColNumSample=-1;

			// to verify whether is sheet is present or not
			if(iIndex==-1){
				return "";
			}

			// if sheet is present get the index of the sheet in the work book
			sheet = workbook.getSheetAt(iIndex);


			iColNumSample=iColNum; // iColNum will hold the column number


			if(iColNumSample==-1){
				return "";	
			}


			// point to the rownumber specified as the input parameter for sheet
			row = sheet.getRow(iRowNum-1);

			//to check number is present in sheet 
			if(row==null){
				return "";
			}

			//point to the cell of the given row and column
			cell = row.getCell(iColNumSample);

			// to check if cell is existed or not
			if(cell==null){
				return "";
			}


			// check the type of the cell and move the data into sData string
			switch (cell.getCellType()) {

			case Cell.CELL_TYPE_STRING:
				sData = cell.getRichStringCellValue().getString();
				break;
			case Cell.CELL_TYPE_NUMERIC:
				long t = (long)cell.getNumericCellValue();
				String cellText  = String.valueOf(t);
				//	                							String cellText  = String.valueOf(cell.getNumericCellValue());
				if (DateUtil.isCellDateFormatted(cell)) {

					double d = cell.getNumericCellValue();
					Calendar cal =Calendar.getInstance();
					cal.setTime(DateUtil.getJavaDate(d));
					cellText =(String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" +
							cal.get(Calendar.MONTH)+1 + "/" + 
							cellText;
				}
				sData= cellText;
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				sData= String.valueOf(cell.getBooleanCellValue());
				break;
			case Cell.CELL_TYPE_FORMULA:
				sData=cell.getCellFormula();
				break;
			default:
				sData= "";
			}

			return sData;
		}

		catch(Exception e){

			e.printStackTrace();
			return "row "+iRowNum+" or column "+iColNum +" does not exist in xls";
		}
	}


	public boolean defSetCellData(String sSheetName,String sColName,int iRowNum, String sData){
		try{

			// open the workbook instances
			fIS = new FileInputStream(sPath); 
			workbook = new XSSFWorkbook(fIS);

			// check if the row number given is valid
			if(iRowNum<=0){
				return false;
			}

			// get the index of the sheet
			int iIndex = workbook.getSheetIndex(sSheetName);
			int iColNum=-1;

			// to verify whether is sheet is present or not
			if(iIndex==-1){
				return false;
			}

			// get the sheet instances
			sheet = workbook.getSheetAt(iIndex);

			//open the first row of the shee
			row=sheet.getRow(0);

			// get the column number for the given column name
			for(int i=0;i<row.getLastCellNum();i++){
				if(row.getCell(i).getStringCellValue().trim().equals(sColName)){
					iColNum=i;
				}
			}

			//check if the column number is correct
			if(iColNum==-1){
				return false;
			}

			// assign to the same size
			sheet.autoSizeColumn(iColNum);

			//get the object pointed to the specific path
			row = sheet.getRow(iRowNum-1);

			//if there is not row existed adding the row
			if (row == null){
				row = sheet.createRow(iRowNum-1);
			}

			//if these is not cell existed then adding new cell
			cell = row.getCell(iColNum);	
			if (cell == null){
				cell = row.createCell(iColNum);
			}

			// making the cell style
			CellStyle cs = workbook.createCellStyle();
			cs.setWrapText(true);
			cell.setCellStyle(cs);
			cell.setCellValue(sData);

			//open the workbook in write mode
			fOut = new FileOutputStream(sPath);
			workbook.write(fOut);

			//closing the work book
			fOut.close();	

		}

		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean defAddSheet(String  sSheetname){		

		FileOutputStream fileOut;
		try {
			workbook.createSheet(sSheetname);	
			fileOut = new FileOutputStream(sPath);
			workbook.write(fileOut);
			fileOut.close();		    
		}
		catch (Exception e) {			
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean defRemoveSheet(String sSheetName){		

		int iIndex = workbook.getSheetIndex(sSheetName);

		// check whether sheet is present or not
		if(iIndex==-1){
			return false;
		}

		FileOutputStream fileOut;

		try {
			workbook.removeSheetAt(iIndex);
			fileOut = new FileOutputStream(sPath);
			workbook.write(fileOut);
			fileOut.close();		    
		}
		catch (Exception e) {			
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean defAddColumn(String sSheetName,String sColName){


		try{			

			//open the workbook instance
			fIS = new FileInputStream(sPath); 
			workbook = new XSSFWorkbook(fIS);

			//get the index of the sheet for the sheet name specified
			int iIndex = workbook.getSheetIndex(sSheetName);

			//checking for whether 
			if(iIndex==-1) {
				return false;	
			}


			XSSFCellStyle style = workbook.createCellStyle();
			//style.setFillForegroundColor(XSSFColor.GREY_40_PERCENT.index);
			//style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);

			sheet=workbook.getSheetAt(iIndex);

			//going to the first row of the workbook 

			row = sheet.getRow(0);

			// checking if row exist if not create a new row
			if (row == null){
				row = sheet.createRow(0);
			}

			//checking if any cells exits else create 
			if(row.getLastCellNum() == -1){
				cell = row.createCell(0);
			}
			else{
				int kon =row.getLastCellNum();	
				cell = row.createCell(kon);
			}

			//sending data into the cell
			cell.setCellValue(sColName);

			cell.setCellStyle(style);


			fOut = new FileOutputStream(sPath);
			workbook.write(fOut);
			fOut.close();		    

		}

		catch(Exception e){
			e.printStackTrace();
			return false;
		}

		return true;
	}


	public boolean defRemoveColumn(String sSheetName, int colNum) {
		try{
			if(!defIsSheetExist(sSheetName)){
				return false;
			}

			fIS = new FileInputStream(sPath); 
			workbook = new XSSFWorkbook(fIS);
			sheet=workbook.getSheet(sSheetName);


			XSSFCellStyle style = workbook.createCellStyle();
			//style.setFillForegroundColor(XSSFColor.GREY_40_PERCENT.index);
			//style.setFillPattern(XSSFCellStyle.NO_FILL);


			//removing the data from the column and deleting the cell
			for(int i =0;i<defGetRowCount(sSheetName);i++){
				row=sheet.getRow(i);	
				if(row!=null){
					cell=row.getCell(colNum);
					if(cell!=null){
						cell.setCellStyle(style);
						row.removeCell(cell);
					}
				}
			}

			fOut = new FileOutputStream(sPath);
			workbook.write(fOut);
			fOut.close();
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;

	}

	public boolean defIsSheetExist(String sSheetName){

		//get the index of the sheet	
		int iIndex=workbook.getSheetIndex(sSheetName.toUpperCase());

		//checking whether sheet is exits
		if(iIndex==-1){
			return false;
		}
		else{
			return true;
		}
	}

	public int defGetColumnCount(String sSheetName){
		// check if sheet exists
		if(!defIsSheetExist(sSheetName)){
			return -1;
		}
		sheet = workbook.getSheet(sSheetName);
		row = sheet.getRow(0);
		if(row==null){
			return -1;
		}
		return row.getLastCellNum();

	}




}

