package com.hmh.automation.pages;

import java.util.List;

import net.thucydides.core.pages.PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.ixxus.ipm.automation.tools.alfresco.Constants;

public class HMHDmaPage extends PageObject {

    public HMHDmaPage(final WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div#ice-canvas")
    private WebElement canvasArea;

    @FindBy(css = "label.ui-button span.ui-button-icon-primary.ice-icon-arrow")
    private WebElement arrowButton;

    @FindBy(css = "div#ice-note-panel textarea.ui-corner-all")
    private WebElement commentInputField;

    @FindBy(css = "button#ice-note-add-button")
    private WebElement addAnnotationCommentButton;

    @FindBy(css = "div.yui-dt-liner div.status > img")
    private WebElement annotationIndicator;

    @FindBy(css = "div.navigation-bar span.backLink")
    private WebElement goBackLink;

    @FindBy(css = "div[id $= 'default-documents'] > table > tbody.yui-dt-data > tr")
    private List<WebElement> itemsListDetail;

    @FindBy(css = "button[id*='ice-next-item-button']")
    private WebElement itemLocatorNextButton;

    @FindBy(css = "div.yui-dt-liner div.status > img[title='Has 2 annotations']")
    private WebElement annotationIndicatorText;

    /**
     * Clicks on the arrow button
     */
    public void clickOnArrowButton() {
        element(arrowButton).waitUntilVisible();
        arrowButton.click();
        waitABit(Constants.WAIT_TIME);
    }

    public void clickOnGoBackLink() {
        element(goBackLink).waitUntilVisible();
        goBackLink.click();
    }

    public void clickOnNextItemLocatorButton() {
        element(itemLocatorNextButton).waitUntilVisible();
        itemLocatorNextButton.click();
        waitABit(Constants.WAIT_TIME);
        waitABit(Constants.WAIT_TIME);

    }

    /**
     * 
     * @param mesaj
     */
    public void checkAnnotationIndicatorText(final int mesaj) {
        String message = annotationIndicatorText.getAttribute("title");
        Assert.assertTrue("The message '" + mesaj + "' was not found in the page!", message.contains(String.valueOf(mesaj)));
    }

    /**
     * 
     * @param fileName
     */
    public void checkIfAnnotationIndicatorPresent(final String fileName) {

        for (WebElement elem : itemsListDetail) {
            if (elem.getText().toLowerCase().contains(fileName.toLowerCase())) {
                waitABit(Constants.WAIT_TIME);
                element(annotationIndicator).isDisplayed();
                break;
            }
        }
    }

    public void checkNavigationBetweenFiles(final int nrOfFile, final int totalFiles) {
        WebElement itemLocator = getDriver().findElement(By.id("ice-item-locator-button"));
        element(itemLocator).waitUntilVisible();

        WebElement currentFileNumber = itemLocator.findElement(By.cssSelector("span.icex-item-number"));
        element(currentFileNumber).waitUntilVisible();
        String fileNumber = currentFileNumber.getText();
        System.out.println("current file number: " + fileNumber);

        WebElement totalNrOfFilesNumber = itemLocator.findElement(By.cssSelector("span.icex-num-items"));
        element(totalNrOfFilesNumber).waitUntilVisible();
        String totalFilesNumber = totalNrOfFilesNumber.getText();
        System.out.println("total file number: " + totalFilesNumber);

        Assert.assertTrue("The current item number is: " + fileNumber + "but it should be: " + nrOfFile, fileNumber.contains(String.valueOf(nrOfFile)));
        waitABit(Constants.WAIT_TIME);
        Assert.assertTrue("The total number of items is: " + totalFilesNumber + "but it should be: " + totalFiles,
                totalFilesNumber.contains(String.valueOf(totalFiles)));
        waitABit(Constants.WAIT_TIME);
    }

    public void verifyAnnotationIndicatorNotPresent() {
        Assert.assertTrue(getDriver().findElements(By.cssSelector("div.yui-dt-liner div.status > img")).size() != 0);

    }

    public void verifyItemLocatorButtonIsPresent() {
        WebElement itemLocator = getDriver().findElement(By.cssSelector("button#ice-item-locator-button"));
        element(itemLocator).waitUntilVisible();
        Assert.assertTrue(itemLocator.isDisplayed());
        waitABit(Constants.WAIT_TIME);
    }

    /**
     * Clicks on the document to add annotation
     */
    public void clickOnCanvasArea() {
        element(canvasArea).waitUntilVisible();
        Actions action = new Actions(getDriver());
        action.dragAndDropBy(canvasArea, 15, 0).build().perform();
        waitABit(Constants.WAIT_TIME);
        waitForRenderedElements(By.cssSelector("div#ice-note-panel textarea.ui-corner-all"));
    }

    /**
     * Inputs an annotation comment
     * 
     * @param annotation
     */
    public void insertComment(final String annotation) {
        element(commentInputField).waitUntilVisible();
        commentInputField.sendKeys(annotation);
        waitABit(Constants.WAIT_TIME);
    }

    public void clickOnAddAnnotationCommentButton() {
        element(addAnnotationCommentButton).waitUntilVisible();
        addAnnotationCommentButton.click();
        waitABit(Constants.WAIT_TIME);

    }

    /**
     * Replies to the selected annotation
     */
    public void replyToSelectedAnnotation(final String reply) {
        WebElement replyButton = getDriver().findElement(By.cssSelector("div.ice-note.ui-state-selected button[title='Reply to this comment']"));
        element(replyButton).waitUntilVisible();
        replyButton.click();
        waitABit(Constants.WAIT_TIME);

        WebElement replyField = getDriver().findElement(By.cssSelector("div.ice-note.ui-state-selected > div.ice-note-content textarea"));
        element(replyField).waitUntilVisible();
        replyField.sendKeys(reply);
        waitABit(Constants.WAIT_TIME);

        WebElement doneButton = getDriver().findElement(By.cssSelector("div.ice-note.ui-state-selected > div.ice-note-content button[title='Add this reply']"));
        element(doneButton).waitUntilVisible();
        doneButton.click();
        waitABit(Constants.WAIT_TIME);
    }

    /**
     * Adds a comment from DMA
     */
    public void addCommentFromDMA(final String comment) {
        WebElement addCommentButton = getDriver().findElement(By.cssSelector("button#ice-global-note-button"));
        element(addCommentButton).waitUntilVisible();
        addCommentButton.click();
        waitABit(Constants.WAIT_TIME);

        WebElement commentField = getDriver().findElement(By.cssSelector("div[aria-labelledby='ui-dialog-title-ice-global-note-panel'] textarea"));
        element(commentField).waitUntilVisible();
        commentField.sendKeys(comment);
        waitABit(Constants.WAIT_TIME);

        WebElement addComment = getDriver().findElement(By.cssSelector("button[title='Add this comment']"));
        element(addComment).waitUntilVisible();
        addComment.click();
        waitABit(Constants.WAIT_TIME);
    }

    /**
     * Clicks on the "Go Back" button from DMA
     */
    public void clickOnGoBack() {
        WebElement goBackButton = getDriver().findElement(By.cssSelector("div.navigation-bar a"));
        element(goBackButton).waitUntilVisible();
        goBackButton.click();
        waitABit(Constants.WAIT_TIME);
    }

    /**
     * Clicks on an annotation in the right side of the screen
     */
    public void selectAnnotation(final String annotation) {
        List<WebElement> annotationsList = getDriver().findElements(By.cssSelector("div#ice-notes-list > div.jspContainer > div > div.ice-note"));
        boolean b = false;
        for (WebElement elem : annotationsList) {
            elem.click();
            if (elem.getText().contains(annotation)) {
                b = true;
                break;
            }
        }
        Assert.assertTrue(b);
    }

    /**
     * Deletes an annotation
     */
    public void deleteAnnotation(final String annotationText) {
        List<WebElement> annotationsList = getDriver().findElements(By.cssSelector("div#ice-notes-list > div.jspContainer > div > div.ice-note"));
        for (WebElement elem : annotationsList) {
            if (elem.getText().contains(annotationText)) {
                elem.findElement(By.cssSelector("div.ice-note-content > div.ice-note-footer button[title='Delete last reply or comment']")).click();
                waitABit(Constants.WAIT_TIME);
                break;
            }
        }
    }

    /**
     * Verifies that the current screen is the DMA view
     */
    public void verifyCurrentScreenIsDmaView() {
        WebElement dmaScreen = getDriver().findElement(By.cssSelector("div#ice-container"));
        Assert.assertTrue(dmaScreen.isDisplayed());
        waitABit(Constants.WAIT_TIME);
    }

    /**
     * Verifies if a file is displayed in DMA view
     */
    public void verifyFileIsDisplayedInDmaView(final String fileName) {
        WebElement fileElement = getDriver().findElement(By.cssSelector("div#ice-canvas > embed"));
        element(fileElement).waitUntilVisible();
        Assert.assertTrue(fileElement.getAttribute("src").contains(fileName));
    }

    /**
     * Verifies that there is a file rendered in the DMA view
     */
    public void verifyPictureIsRenderedInDMA(final String fileType) {
        if (fileType.contains("jpeg") || fileType.contains("jpg") || fileType.contains("png") || fileType.contains("gif")) {
            WebElement renderedFile = getDriver().findElement(By.cssSelector("div#ice-canvas > img"));
            element(renderedFile).waitUntilVisible();
            Assert.assertTrue(renderedFile.isDisplayed());
        }

        if (fileType.contains("ogv") || fileType.contains("mp4") || fileType.contains("m4v")) {
            WebElement renderedFile = getDriver().findElement(By.cssSelector("div#ice-canvas > video"));
            element(renderedFile).waitUntilVisible();
            Assert.assertTrue(renderedFile.isDisplayed());
        }

        if (fileType.contains("mp3")) {
            WebElement renderedFile = getDriver().findElement(By.cssSelector("div#ice-canvas > audio"));
            Assert.assertTrue(renderedFile.isEnabled());
        }

        if (fileType.contains("svg") || fileType.contains("pdf") || fileType.contains("rtf") || fileType.contains("txt") || fileType.contains("odt")
                || fileType.contains("odp")
                || fileType.contains("ods") || fileType.contains("doc") || fileType.contains("docx") || fileType.contains("ppt") || fileType.contains("pptx")
                || fileType.contains("xls")
                || fileType.contains("xlsx")) {
            WebElement renderedFile = getDriver().findElement(By.cssSelector("div#ice-canvas > embed"));
            element(renderedFile).waitUntilVisible();
            Assert.assertTrue(renderedFile.isDisplayed());
        }

    }
}
