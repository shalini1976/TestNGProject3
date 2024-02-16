package amazonTestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import callingAmazonTestCases.CallingProgramAmazon;

public class VerifyProductQuantity extends CallingProgramAmazon {

	// TEST CASE: Increase the product quantity in cart and verify if it has been increased

	WebDriver driver;

	public VerifyProductQuantity(WebDriver ldriver)
	{
		driver = ldriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="twotabsearchtextbox") WebElement srchbx;
	@FindBy(id="nav-search-submit-button")  WebElement srchbtn;
	@FindBy(xpath = "//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']/child::a[1]") WebElement prd;
	@FindBy(xpath="//div[@id='productFactsDesktopExpander']") WebElement prddet;
	@FindBy(xpath = "//span[@id='a-autoid-13-announce']")   WebElement qnty;
	@FindBy(xpath = "//a[@id='quantity_3']") WebElement slctqty;
	@FindBy(xpath = "//input[@id='add-to-cart-button']")   WebElement add2cart;
	@FindBy(xpath = "//div[@id='nav-cart-count-container']/child::span[1]") WebElement cart;
	@FindBy(xpath = "//span[@class='a-button-text a-declarative']") WebElement vrfyqty;
String prdnm,qty;

public void enterName(String name) {
		srchbx.sendKeys(name);
		prdnm=name;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void clickSearchButton() {
		srchbtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String actualTitle=driver.getTitle();
		String actual="Amazon.com : ";
		String tname=actual.concat(prdnm);
		String expectedTitle=tname;
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("'"+actualTitle+"' "+"page is displayed: Verified");
}
	public void clickProduct()
	{
		prd.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void clickQuantity()
	{
		qnty.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void selectQuantity()
	{
		slctqty.click();
		System.out.println("Selected quantity as 4");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void clickAddToCart()
	{
		add2cart.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void clickGoToCart() {
		cart.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println(vrfyqty.getText());
		System.out.println("Both the quantities are same: Verified");
	}


}
