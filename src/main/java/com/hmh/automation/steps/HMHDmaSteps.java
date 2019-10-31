package com.hmh.automation.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import com.hmh.automation.pages.HMHDmaPage;

public class HMHDmaSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;
	private HMHDmaPage pSDmaPage;

	public HMHDmaSteps(final Pages pages) {
		super(pages);
	}

	@Step("Click on the arrow button")
	public void clickOnArrowButton() {
		pSDmaPage.clickOnArrowButton();
	}

	@Step("Click on go back link")
	public void clickOnGoBackLink() {
		pSDmaPage.clickOnGoBackLink();
	}

	@Step("Click on next item locator")
	public void clickOnNextItemLocatorButton() {
		pSDmaPage.clickOnNextItemLocatorButton();
	}

	@Step("Check annotation indicator")
	public void checkAnnotationIndicatorText(final int mesaj) {
		pSDmaPage.checkAnnotationIndicatorText(mesaj);
	}

	@Step("Check if the annotation indicator is present")
	public void checkIfAnnotationIndicatorPresent(final String fileName) {
		pSDmaPage.checkIfAnnotationIndicatorPresent(fileName);
	}

	@Step("Check navigation between files")
	public void checkNavigationBetweenFiles(final int nrOfFile, final int totalFiles) {
		pSDmaPage.checkNavigationBetweenFiles(nrOfFile, totalFiles);
	}

	@Step("Annotation indicator not present")
	public void verifyAnnotationIndicatorNotPresent() {
		pSDmaPage.verifyAnnotationIndicatorNotPresent();
	}

	@Step("Verify item locator button")
	public void verifyItemLocatorButtonIsPresent() {
		pSDmaPage.verifyItemLocatorButtonIsPresent();
	}

	@Step("Click on canvas")
	public void clickOnCanvasArea() {
		pSDmaPage.clickOnCanvasArea();
	}

	@Step("Insert Comment")
	public void insertComment(final String annotation) {
		pSDmaPage.insertComment(annotation);
	}

	@Step("Click on add annotation comment button")
	public void clickOnAddAnnotationCommentButton() {
		pSDmaPage.clickOnAddAnnotationCommentButton();
	}

	@Step("Reply to selected annotation")
	public void replyToSelectedAnnotation(final String reply) {
		pSDmaPage.replyToSelectedAnnotation(reply);
	}

	@Step("Add comment from DMA")
	public void addCommentFromDMA(final String comment) {
		pSDmaPage.addCommentFromDMA(comment);
	}

	@Step("Click on go back")
	public void clickOnGoBack() {
		pSDmaPage.clickOnGoBack();
	}

	@Step("Select annotation")
	public void selectAnnotation(final String annotation) {
		pSDmaPage.selectAnnotation(annotation);
	}

	@Step("Delete annotation")
	public void deleteAnnotation(final String annotationText) {
		pSDmaPage.deleteAnnotation(annotationText);
	}

	@Step("Verify current screen is DMA")
	public void verifyCurrentScreenIsDmaView() {
		pSDmaPage.verifyCurrentScreenIsDmaView();
	}

	@Step("Verify file diplayed in DMA view")
	public void verifyFileIsDisplayedInDmaView(final String fileName) {
		pSDmaPage.verifyFileIsDisplayedInDmaView(fileName);
	}

	@Step("Verify picture is rendered in DMA")
	public void verifyPictureIsRenderedInDMA(final String fileType) {
		pSDmaPage.verifyPictureIsRenderedInDMA(fileType);
	}
}
