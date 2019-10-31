package com.hmh.automation.steps;

import java.io.FileNotFoundException;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import com.hmh.automation.pages.HMHExcelReaderPage;
import com.ixxus.ipm.automation.steps.AbstractSteps;

public class HMHExcelReaderSteps extends AbstractSteps<HMHExcelReaderPage> {

    private static final long serialVersionUID = 2288209712204716852L;

    public HMHExcelReaderSteps(final Pages pages) {
        super(pages, HMHExcelReaderPage.class);
    }

    @Step("Get the Cell Data in Excel File")
    public void defGetCellData(String sPath, String sSheetName,String sColName,int iRowNum) {
        currentPage().defGetCellData(sPath, sSheetName, sColName, iRowNum);
    }
    
    @Step("Set the File Path")
    public void setFilePath(String filePath) {
        try {
			currentPage().setFilePath( filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}