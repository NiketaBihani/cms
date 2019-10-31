package com.hmh.automation.pages;

import java.util.List;

import net.serenitybdd.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ixxus.ipm.automation.pages.AbstractPage;

public class HMHreferencesPage extends AbstractPage {

    public HMHreferencesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div[id $= 'references-cntrl-picker-left'] tr[class *= 'dt-rec']")
    private List<WebElement> assetList;

    @FindBy(css = "div[id $= 'references-cntrl-picker-right'] tr[class *= 'dt-rec']")
    private List<WebElement> selectedReferencesList;

    @FindBy(css = "button[id*='references-cntrl-ok-button']")
    private WebElement confirmReferenceBtn;

    public void selectOutgoingReference(String itemName) {
        boolean found = false;
        waitABit(1000);
        for (WebElement aspect : assetList) {
            element(aspect).waitUntilVisible();
            if (aspect.getText().toLowerCase().contains(itemName.toLowerCase())) {
                WebElement addB = aspect.findElement(By.cssSelector("td > div > a > span.addIcon"));
                found = true;
                addB.click();
                break;
            }
        }
        Assert.assertTrue("The asset was not found", found);
    }

    public void confirmReferenceButtonClick() {
        confirmReferenceBtn.click();
    }

}
