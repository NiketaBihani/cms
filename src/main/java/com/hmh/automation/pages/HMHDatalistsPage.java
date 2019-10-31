package com.hmh.automation.pages;

import java.util.List;

import net.serenitybdd.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ixxus.ipm.automation.pages.AbstractPage;

public class HMHDatalistsPage extends AbstractPage {

    public HMHDatalistsPage(final WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div[id='alf-filters'] div[id*='datalists'] div[id$='default-lists'] li a")
    private List<WebElement> dataLists;

    @FindBy(css = "div[id$='default-grid'] tbody[class$='data'] tr")
    private List<WebElement> standards;

    @FindBy(css = "div[id*='editDetails_prop_hmh-cms_correlated-cntrl-currentValueDisplay'] a")
    private List<WebElement> correlatedItemsListInstandardEditPane;

    @FindBy(css = "div[id*='hmh-cms_correlated-cntrl-itemGroupActions'] button")
    private WebElement editStandardCorrelationSelectButton;

    @FindBy(css = "div[id$='correlated-cntrl-picker-selectedItems'] tbody[class*='data'] tr")
    private List<WebElement> corelatedItems;

    @FindBy(css = "button[id*='hmh-cms_correlated-cntrl-ok-button']")
    private WebElement okButton;

    @FindBy(css = "div[id*='editDetails-form-buttons'] button[id*='form-submit-button']")
    private WebElement saveButton;

    @FindBy(css = "div[id*='correlated-cntrl-picker-results'] tbody[class$='data'] tr h3 a")
    private List<WebElement> itemsInCorrleationsDialgoBox;
    
    @FindBy(css = "div[id*='editDetails-form-buttons'] button[id*='form-submit-button']")
    private WebElement editStandardButtonCss2;

    String emptyCorrleatedTextCssSelector = " td[class$='col-prop_hmh-cms_correlated'] div";
    String itemNames = "div[id*='correlated-cntrl-picker-results'] tbody[class$='data'] tr ";
    String stadnardTextCss = " td[class*='standardText ']";
    String corelatedItemCss = " td[class*='_correlated'] a";
    String hiddenContainerDL = " a[title='Edit']"; 
    String editStandardButtonCss = " div[class*='grid'] tr td[class*='actions'] a[title='Edit']";  //div[class*='grid'] tr td[class*='actions'] a[title='Edit'] || a[title='Edit']
    String corelatedItemsTextCss = " h3";
    String correlatedItemsRemoveButtoncSS = " span";

    String correlatedItemsInDataListsPage = "div[id*='prop_hmh-cms_correlated-cntrl-picker-right'] tbody[class$='data'] tr";
    String emptyCorrleationlist = "div[id*='prop_hmh-cms_correlated-cntrl-picker-right'] tbody[class$='message'] tr";

    public void selectCorrelationButtonClick() {
        element(editStandardCorrelationSelectButton).waitUntilVisible();
        editStandardCorrelationSelectButton.click();
    }

    public void checkIfItemIsInCorrleationInDataSetsPage(String itemName) {
        boolean found = false;
        waitABit(2000);
        element(correlatedItemsInDataListsPage).waitUntilVisible();
        List<WebElement> itemsList = getDriver().findElements(By.cssSelector(correlatedItemsInDataListsPage));
        for (WebElement item : itemsList) {
            if (item.getText().toLowerCase().contains(itemName.toLowerCase())) {
                found = true;
                break;
            }
        }
        Assert.assertTrue("The item was not found", found);
    }

    public void removeCorrelationInDataSetsPage(String itemName) {
        boolean found = false;
        waitABit(2000);

        List<WebElement> itemsList = getDriver().findElements(By.cssSelector(correlatedItemsInDataListsPage));
        for (WebElement item : itemsList) {
            if (item.getText().toLowerCase().contains(itemName.toLowerCase())) {
                WebElement removeBtn = item.findElement(By.cssSelector(correlatedItemsRemoveButtoncSS));
                removeBtn.click();
                found = true;
                break;
            }
        }
        Assert.assertTrue("The item was not found", found);
        okButton.click();
    }

    public void checkCorrelationsInEditStandardPane(String itemName) {
        boolean found = false;
        for (WebElement item : correlatedItemsListInstandardEditPane) {
            if (item.getText().toLowerCase().contains(itemName.toLowerCase())) {
                found = true;
                break;
            }
        }
        Assert.assertTrue("The item was not found", found);
    }

    public void editStandardButtonClick(String standard) {
        boolean found = false;
        waitForElementX("//tbody//tr[1]//td[3]/div", 120, getDriver());
        final Actions action = new Actions(getDriver());
        for (WebElement standardRow : standards) {
            WebElement standardText = standardRow.findElement(By.cssSelector(stadnardTextCss));
            if (standardText.getText().toLowerCase().contains(standard.toLowerCase())) {
                action.moveToElement(standardText).build().perform();
                WebElement editBtn = standardRow.findElement(By.cssSelector(editStandardButtonCss));
                editBtn.click();
                found = true;
                break;
            }
        }
        Assert.assertTrue("The button edit was not clicked", found);
    }

    public void selectStandardFromList(String list) {
        boolean found = true;
        for (WebElement item : dataLists) {
            if (item.getText().toLowerCase().contains(list.toLowerCase())) {
                found = true;
                item.click();
                break;
            }
        }
        waitABit(4000);
        Assert.assertTrue("The item was not found", found);
    }

    public void checkIfItemWasCorrelatedToStandard(String standard, String item) {
        boolean found = false;
        waitABit(3000);
        refreshPage();
        element(stadnardTextCss).waitUntilVisible();
        System.out.println("Initiate");
        for (WebElement standardRow : getDriver().findElements(By.cssSelector("div[id$='default-grid'] tbody[class$='data'] tr"))) {
            System.out.println("In For");
            WebElement standardText = standardRow.findElement(By.cssSelector(stadnardTextCss));

            System.out.println("Standard is :" + standardText.getText());

            if (standardText.getText().toLowerCase().contains(standard.toLowerCase())) {

                List<WebElement> corelatedItems = standardRow.findElements(By.cssSelector(corelatedItemCss));
                System.out.println("Before second for: ");
                for (WebElement itemText : corelatedItems) {

                    System.out.println("Item is is :" + itemText.getText());

                    if (itemText.getText().toLowerCase().contains(item.toLowerCase())) {
                        found = true;
                        break;
                    }
                }
            }
        }
        Assert.assertTrue("The item that was corelated is not displayed for that standard", found);
    }

    public void checkIfStandardHasNoCorrelation(String standard) {
        boolean empty = false;
        waitABit(3000);
        refreshPage();
        refreshPage();
        System.out.println("Inainte de for");
        for (WebElement standardRow : getDriver().findElements(By.cssSelector("div[id$='default-grid'] tbody[class$='data'] tr"))) {
            System.out.println("In For");
            WebElement standardText = standardRow.findElement(By.cssSelector(stadnardTextCss));
            System.out.println("Standard is :" + standardText.getText());
            if (standardText.getText().toLowerCase().contains(standard.toLowerCase())) {
                WebElement correlatedColumn = standardRow.findElement(By.cssSelector(emptyCorrleatedTextCssSelector));
                if (correlatedColumn.getText().contentEquals("")) {
                    System.out.println("The text is : " + correlatedColumn.getText());
                    empty = true;
                    break;
                }

            }
        }
        Assert.assertTrue("The item that was corelated is not displayed for that standard", empty);
    }

    public void checkIfThereIsNoCorrelation(String standard, String item) {
        boolean found = false;
        for (WebElement standardRow : standards) {
            WebElement standardText = standardRow.findElement(By.cssSelector(stadnardTextCss));
            if (standardText.getText().toLowerCase().contains(standard.toLowerCase())) {
                WebElement corelatedItem = standardRow.findElement(By.cssSelector(corelatedItemCss));
                if (!(corelatedItem.getText().toLowerCase().contains(item.toLowerCase()))) {
                    found = true;
                    break;
                }
            }
        }
        Assert.assertTrue("An Item was found so the correlation was not deleted", found);
        okButton.click();
    }

    public void removeCorrelatedItemInDataListsPage(String itemName) {
        boolean found = false;
       

        List<WebElement> itemsList = getDriver().findElements(By.cssSelector(correlatedItemsInDataListsPage));
        for (WebElement item : itemsList) {
            if (item.getText().toLowerCase().contains(itemName.toLowerCase())) {
                found = true;
                WebElement removeButton = item.findElement(By.cssSelector(correlatedItemsRemoveButtoncSS));
                removeButton.click();
                break;
            }
        }
        Assert.assertTrue("The item was not found", found);
    }

    public void checkIfNoItemIsCorrelatedForStandardInDataListsPage() {
        boolean found = false;
        element(emptyCorrleationlist).waitUntilVisible();
        WebElement emptyList = getDriver().findElement(By.cssSelector(emptyCorrleationlist));
        if (emptyList.isDisplayed()) {
            found = true;
        }
        Assert.assertTrue("The Item wasn ot found", found);
    }

    public void editCorrelationPaneSaveButtonClick() {
        element(saveButton).waitUntilVisible();
        saveButton.click();
        waitABit(1000);
    }

    public void navigateInCorelationsDialgoBox(String itemName) {
    	waitABit(4000);
        boolean found = false;
        for (WebElement item : itemsInCorrleationsDialgoBox) {
            if (item.getText().toLowerCase().contains(itemName.toLowerCase())) {
                found = true;
                item.click();
                break;
            }
        }
        Assert.assertTrue("The item was not found in correlation dialog box", found);
    }

    public void addItemToCorrelate(String itemName) {
        boolean found = false;
        for (WebElement item : getDriver().findElements(By.cssSelector(itemNames))) {
            if (item.getText().toLowerCase().contains(itemName.toLowerCase())) {
                found = true;
                WebElement add = item.findElement(By.cssSelector(correlatedItemsRemoveButtoncSS));
                add.click();
                break;
            }
        }
        Assert.assertTrue("The item was not found in correlation dialog box", found);
        okButton.click();
    }
    
    public void correlateOKbuttonClick(){
    	element(okButton).waitUntilVisible();
    	okButton.click();
    }
}
