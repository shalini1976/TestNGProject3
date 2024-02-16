package amazonTestCases;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import callingAmazonTestCases.CallingProgramAmazon;

public class VerifyScrollUpDownWithoutLink extends CallingProgramAmazon{

	//Verify Scroll Up (without using 'Back to Top' button) and Scroll Down functionality

	WebDriver driver;
	public VerifyScrollUpDownWithoutLink(WebDriver ldriver) {
		driver = ldriver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//li[@class='nav_last']/child::span") WebElement lastline;
	@FindBy(xpath = "//div[@id='nav-logo']/child::a") WebElement firstline;

	public void verifyScrollDown()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", lastline);
		System.out.println("Scrolled down to the bottom of the page");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void verifyScrollUp()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", firstline);
		System.out.println("Scrolled up to the top of the page");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
}
