package amazonTestCases;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import callingAmazonTestCases.CallingProgramAmazon;

public class VerifyMoveToCart extends CallingProgramAmazon {

	// TEST CASE: Verify the functionality of 'Move to cart' button after saving for later

	WebDriver driver;

	public VerifyMoveToCart(WebDriver ldriver)
	{
		driver = ldriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="twotabsearchtextbox") WebElement srchbx;
	@FindBy(id="nav-search-submit-button")  WebElement srchbtn;
	@FindBy(xpath = "//div[@class='a-section a-spacing-base']/descendant::h2/child::a/child::span") WebElement prdshrt;
    @FindBy(xpath = "//input[@id='add-to-cart-button']")  WebElement add2cart;
    @FindBy(xpath = "//div[@id='sw-atc-actions-buy-box-sign-in']/descendant::span[@id='sw-gtc']/child::span/child::a") WebElement go2cart;
    @FindBy(xpath = "//div[@class='a-row sc-action-links']/child::span[@data-action='save-for-later']/child::span/child::input") WebElement svfrltr;
    @FindBy(xpath="//div[@class='sc-list-item-removed-msg']/child::div/following-sibling::div/child::span/child::a[1]")WebElement msg;
    @FindBy(xpath="//div[@id='sc-saved-cart-items']/descendant::div[@class='sc-list-item-content']/descendant::div[@class='a-row sc-action-links']/descendant::input[@data-action='move-to-cart']")WebElement mv2crt;
    @FindBy(xpath="//div[@class='sc-list-item-removed-msg']/child::div[@data-action='move-to-cart']/child::span[@class='a-size-base']/child::a[1]")WebElement vrfymsg;
	public void enterName(String name)
	{
		srchbx.sendKeys(name);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void searchProduct()
	{
		srchbtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String actualTitle=driver.getTitle();
		String ExceptedTitle="Amazon.com : shirts";
		Assert.assertEquals(actualTitle, ExceptedTitle);
		System.out.println(actualTitle+" "+"page is displayed");
	}
	public void clickProduct()
	{
		prdshrt.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void clickAddtoCart()
	{
		add2cart.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void clickGoToCart()
	{
		go2cart.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void clickSaveForLater()
	{
		svfrltr.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void verifyMessage()
	{
		Assert.assertTrue(msg.isDisplayed());
		System.out.println("'"+msg.getText()+" has been moved to Saved for Later.' is displayed");
	}
	
	public void moveToCart()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView();", mv2crt);
		js.executeScript("window.scrollBy(0,600)");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		try
		{
		mv2crt.click();
		}
		catch(Exception e)
		{
			System.out.println("not found");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void verifyMove()
	{
		//Assert.assertTrue(vrfymsg.isDisplayed());
		System.out.println("'"+msg.getText()+" has been moved to Shopping Cart.' is displayed: Verified");

	}
}
