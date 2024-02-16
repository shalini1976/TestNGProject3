package amazonTestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import callingAmazonTestCases.CallingProgramAmazon;

public class RemoveFromCart extends CallingProgramAmazon {

	// TEST CASE: Verify the functionality 'Delete' (from cart) button

	WebDriver driver;

	public RemoveFromCart(WebDriver ldriver)
	{
		driver = ldriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="twotabsearchtextbox") WebElement srchbx;
	@FindBy(id="nav-search-submit-button")  WebElement srchbtn;
	@FindBy(xpath = "//div[@class='a-section a-spacing-base']/descendant::h2/child::a/child::span") WebElement prdshrt;
    @FindBy(xpath = "//input[@id='add-to-cart-button']")  WebElement add2cart;
    @FindBy(xpath = "//div[@id='sw-atc-actions-buy-box-sign-in']/descendant::span[@id='sw-gtc']/child::span/child::a") WebElement go2cart;
    @FindBy(xpath = "//div[@class='a-row sc-action-links']/child::span[@data-action='delete']/child::span/child::input") WebElement delete;
    @FindBy(xpath="//div[@class='sc-list-item-removed-msg']/child::div/child::span/child::a")WebElement remmsg;

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
	public void clickDelete()
	{
		delete.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void verifyMessage()
	{
		//System.out.println(remmsg.getText());
		Assert.assertTrue(remmsg.isDisplayed());
		System.out.println("'"+remmsg.getText()+" was removed from Shopping Cart.' is displayed: Verified");
	}
}
