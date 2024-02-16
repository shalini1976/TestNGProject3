package amazonTestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import callingAmazonTestCases.CallingProgramAmazon;


public class VerifySearchButton extends CallingProgramAmazon
{
	// Search a product in the Search box, verify the products are displayed, click any one product from the list and verify the product details are visible
	WebDriver driver;
	public VerifySearchButton(WebDriver ldriver)
	{
		driver=ldriver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="twotabsearchtextbox") WebElement srchbx;
	@FindBy(id="nav-search-submit-button")  WebElement srchbtn;
	@FindBy(xpath="//span[@class='a-size-base-plus a-color-base a-text-normal']") WebElement clkprodb;
	@FindBy(xpath="//span[@id='productTitle']") WebElement clkproda;

	String nm,strprodb,strproda;
	public void enterName(String name)
	{
		srchbx.sendKeys(name);
		nm=name;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void clickSearchButton()
	{
		srchbtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("Search button clicked");
	}
	public void verifyPageDisplay()
	{
		String actualTitle=driver.getTitle();
		String actual="Amazon.com : ";
		String tname=actual.concat(nm);
		String expectedTitle=tname;
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("'"+actualTitle+"' "+"page is displayed: Verified");
	}
	public void clickProduct()
	{
		strprodb=clkprodb.getText();
		System.out.println(clkprodb.getText());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		clkprodb.click();
	}
	public void verifyProduct()
	{
		System.out.println("Inside Verify Product");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		strproda=clkproda.getText();
		System.out.println(clkproda.getText());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Assert.assertEquals(strproda, strprodb);
		System.out.println("Product details are visible and same: Verified");
	}
}
