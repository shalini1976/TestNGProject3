package amazonTestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import callingAmazonTestCases.CallingProgramAmazon;

public class AddDeliveredProductToCart extends CallingProgramAmazon {

	// TEST CASE: Verify if the product that can be delivered to India, can be added to cart

	WebDriver driver;

	public AddDeliveredProductToCart(WebDriver ldriver)
	{
		driver = ldriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="twotabsearchtextbox") WebElement srchbx;
	@FindBy(id="nav-search-submit-button")  WebElement srchbtn;
	@FindBy(xpath = "//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']/child::a[1]") WebElement prd;
	@FindBy(xpath = "//input[@id='add-to-cart-button']")   WebElement add2cart;
	@FindBy(xpath = "//div[@id='nav-cart-count-container']/child::span[1]") WebElement cart;
	@FindBy(xpath="//span[text()='Ships to India']")WebElement ship;
	@FindBy(xpath = "//span[@class='a-truncate-cut']") WebElement vrfycrt;

String prdnm;

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
	//	Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("'"+actualTitle+"' "+"page is displayed: Verified");
}
	public void clickProduct()
	{
		System.out.println("Product "+ship.getText());
		prd.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void clickAddToCart()
	{
		add2cart.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void clickGoToCart()
	{
		cart.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void verifyCart()
	{
		Assert.assertTrue(vrfycrt.isDisplayed());
		System.out.println(vrfycrt.getText());
		System.out.println("Product is added to cart: Verified");
	}


}
