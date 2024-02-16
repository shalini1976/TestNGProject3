package amazonTestCases;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import callingAmazonTestCases.CallingProgramAmazon;

public class Logout extends CallingProgramAmazon {
	//Test Case: Verify the functionality of Logout
	WebDriver driver;

	public Logout(WebDriver ldriver)
	{
		driver=ldriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[text()='Account & Lists']") WebElement acclst;
	@FindBy(xpath="//div[@class='layoutToolbarPadding']/child::a/following-sibling::a/child::span") WebElement signin;
	@FindBy(xpath="//title[text()='Amazon Sign-In']") WebElement verifysignin_page;
	@FindBy(xpath="//input[@type='email']")WebElement phno;
	@FindBy(xpath="//input[@id='continue']") WebElement continuebtn;
	@FindBy(xpath="//input[@type='password']")WebElement passwd;
	@FindBy(xpath="//div[@class='nav-line-1-container']/child::span[@class='nav-line-1 nav-progressive-content']") WebElement vrfylogin;
	@FindBy(xpath="//div[@id='nav-al-your-account']/child::a[13]/child::span")WebElement signout;
	public void mousehoverAccountAndLists()
	{
		Actions action=new Actions(driver);
		action.moveToElement(acclst);
		action.perform();
		System.out.println("Account & Lists menu opened");
	}

	public void clickSignIn()
	{
		signin.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void verifyLoginPage()
	{
		String actualText=verifysignin_page.getText();
		String expectedText ="Amazon Sign-In";
		Assert.assertEquals(actualText, expectedText);
		System.out.println("Sign in page is visible: Verified");
	}

	public void enterPhoneNumber(String nm)
	{
		phno.sendKeys(nm);
	}
	public void clickContinue1()
	{
		continuebtn.click();
	}
	public void enterPassword(String pass)
	{
		passwd.sendKeys(pass);
	}
	public void clickContinue2()
	{
		continuebtn.click();
	}
	public void verifyLogin()
	{
		Assert.assertTrue(vrfylogin.isDisplayed());
		System.out.println(vrfylogin.getText()+" is displayed: Verified");
	}
	//Call mousehoverAccountAndLists()
	public void amzLogout()
	{
		signout.click();
		System.out.println("Valid user is logged out: Verified");
	}

}



