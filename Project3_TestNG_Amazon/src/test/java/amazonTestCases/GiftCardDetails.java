package amazonTestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import callingAmazonTestCases.CallingProgramAmazon;

public class GiftCardDetails extends CallingProgramAmazon {

	// TEST CASE: Click the menu - 'Gift Cards' and extract the details of 'Gift
	// Card in a Birthday Pop-Up Box' card

	WebDriver driver;

	public GiftCardDetails(WebDriver ldriver) {
		driver = ldriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='nav-xshop']/child::a[4]")
	WebElement gftcrd;
	@FindBy(xpath = "//ul/child::li/child::a[1]")
	WebElement amzgftcrd;
	@FindBy(xpath = "//div[@class='desktop']/child::div/child::div/child::nav/child::ul/child::li[4]")
	WebElement ftrdbday;
	@FindBy(xpath = "//div[@data-asin='B06ZY43PDR']")
	WebElement popupbdaycrd;
	@FindBy(xpath = "//form[@id='twister']/child::div/following-sibling::div[@id='variation_design_name']/child::div[1]")
	WebElement crdhead;
	@FindBy(xpath = "//div[@id='feature-bullets']")
	WebElement crddetails;

	public void clickGiftCards() {
		gftcrd.click();
		System.out.println("'Gift Cards' clicked");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void clickAmazonGiftCards() {
		amzgftcrd.click();
		System.out.println("Amazon Gift Cards clicked");
	}

	public void clickFeaturedBirthday() {
		ftrdbday.click();
		System.out.println("Featured: Birthday clicked");
	}

	public void clickGftCrdInBdayPopUpBx() {
		popupbdaycrd.click();
		System.out.println("'Amazon.com gift Card In a Birthday Pop Up Box' clicked");
	}

	public void displayGiftCardDetails() {
		System.out.println(crdhead.getText());
		System.out.println(crddetails.getText());
		System.out.println("Gift Card Details displayed: Verified");
	}

}
