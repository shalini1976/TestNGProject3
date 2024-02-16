package amazonTestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import callingAmazonTestCases.CallingProgramAmazon;


public class NewCustomerSignIn  extends CallingProgramAmazon {
	//Test Case: Verify the process of New Customer Sign in
	WebDriver driver;

	public NewCustomerSignIn(WebDriver ldriver)
	{
		driver=ldriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[text()='Account & Lists']") WebElement acclst;
	@FindBy(xpath="//div[@id='nav-flyout-ya-signin']/child::div/child::a") WebElement strthere;
	@FindBy(xpath="//title[text()='Amazon Sign-In']") WebElement verifysignin_page;
	@FindBy(xpath="//input[@id='ap_customer_name']")WebElement cname;
	@FindBy(xpath="//input[@id='ap_email']") WebElement cemail;
	@FindBy(xpath="//input[@id='ap_password']") WebElement pass;
	@FindBy(xpath="//input[@id='ap_password_check']")WebElement repass;
	@FindBy(xpath="//span[@id='auth-continue']/child::span/child::input") WebElement cntbtn;
	@FindBy(xpath="//input[@id='cvf-input-code']") WebElement otp;
	@FindBy(xpath="//span[@id='cvf-submit-otp-button']/child::span/child::input") WebElement createbtn;
	@FindBy(xpath="//div[@class='nav-line-1-container']/child::span[@class='nav-line-1 nav-progressive-content']") WebElement vrfyregn;
	
	public void mousehoverAccountAndLists()
	{
		Actions action=new Actions(driver);
		action.moveToElement(acclst);
		action.perform();
		System.out.println("Account & Lists menu opened");
	}

	public void clickNewCustomerStartHere()
	{
		strthere.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void verifyRegistrationPage()
	{
		String actualTitle=driver.getTitle();
		String expectedTitle ="Amazon Registration";
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Amazon Registration page is visible: Verified");
	}

	public void enterName(String nm)
	{
		cname.sendKeys(nm);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void enterEmail(String eml)
	{
		cemail.sendKeys(eml);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void enterPassword(String pwd)
	{
		pass.sendKeys(pwd);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void reEnterPassword(String repwd)
	{
		repass.sendKeys(repwd);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void clickContinue()
	{
		cntbtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void verifyEmail(String num)
	{
		otp.sendKeys(num);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void clickCreateButton()
	{
		createbtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void verifyRegistration()
	{	
		Assert.assertTrue(vrfyregn.isDisplayed());
		System.out.println(vrfyregn.getText()+" is displayed: Verified");
	}
}
