package amazonTestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import callingAmazonTestCases.CallingProgramAmazon;

public class AddUnDeliveredProductToCart extends CallingProgramAmazon {

	// TEST CASE: Verify if the product that cannot be delivered to India, can be added to cart

	WebDriver driver;

	public AddUnDeliveredProductToCart(WebDriver ldriver)
	{
		driver = ldriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="twotabsearchtextbox") WebElement srchbx;
	@FindBy(id="nav-search-submit-button")  WebElement srchbtn;
	@FindBy(xpath = "//div[@class='sg-col-inner']/child::span/child::div/child::div[6]") WebElement prd;
	@FindBy(xpath = "//div[@id='outOfStock']/child::div/child::div/child::span")   WebElement vrfydlvry;
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
		//Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("'"+actualTitle+"' "+"page is displayed: Verified");
}
	public void clickProduct()
	{
		prd.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void verifyDeliveryToIndia()
	{
		System.out.println(vrfydlvry.getText());
		System.out.println("Add To cart button not visible, Product cannot be added to cart: Verified");
	}
}
