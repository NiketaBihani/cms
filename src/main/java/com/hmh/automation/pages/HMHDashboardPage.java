package com.hmh.automation.pages;

import java.util.List;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ixxus.ipm.automation.pages.AbstractPage;

public class HMHDashboardPage extends AbstractPage {
    public HMHDashboardPage(WebDriver driver) {
        super(driver);
    }
    private static final Logger LOG = LoggerFactory.getLogger(HMHDashboardPage.class);
    @FindBy(css="#FCTSRCH_RESULTS_COUNT_LABEL")
    private WebElement numberOfResults;
    @FindBy(css="footer")
    private WebElement footer;
    @FindBy(css="#FCTSRCH_SEARCH_RESULTS_LIST table")
    private WebElement searchResultsTable;
    
    public void checkIfDashletIsPresent (String Dashlet, int waitForSeconds, int manualScrollSeconds, boolean shouldBePresent)
     {
	       int results = 0;
	       int counter = 0;
	      boolean found = false;
	     LOG.info("Waiting for search results list to load for max " + waitForSeconds + " seconds");
	       while ((results == 0) && (counter < waitForSeconds))
	      {
	        try
	          {
	             String numberOfEleemnts = this.numberOfResults.getText();
	             String[] splited = numberOfEleemnts.split("\\s+");
	          results = Integer.parseInt(splited[0]);
	          }
	          catch (Exception e) {}
	         counter++;
	        waitABit(1000L);
	          refreshPage();
	        }
	      if ((results == 0) && (shouldBePresent))
	       {
	         Assert.assertTrue("There were no results found in 2 minutes", results > 0);
	         }
	       else if (results > 0)
	        {
	         LOG.info("Manual scroll for " + manualScrollSeconds + " seconds");
	      Actions action = new Actions(getDriver());
	          for (int i = 0; i < manualScrollSeconds; i++)
	          {
	           action.moveToElement(this.footer).build().perform();
	          waitABit(1000L);
	          }
	          LOG.info("Manual scroll done");
	           List<WebElement> items = this.searchResultsTable.findElements(By.cssSelector(".nameAndTitleCell > span > span > a"));
	         for (WebElement resultItem : items) {
	           if (resultItem.getText().toLowerCase().contentEquals(Dashlet.toLowerCase()))
	           {
	             found = true;
	              break;
	            }
	           }
	           if (shouldBePresent) {
	            Assert.assertTrue("Document was not found in the search results!", found);
	        } else {
	         Assert.assertFalse("Document was found but should not have been found", found);
	          }
	       }
	     }
}
