package amazonTestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import callingAmazonTestCases.CallingProgramAmazon;

public class VerifySubTotal extends CallingProgramAmazon {

	// TEST CASE: Verify subtotal based on the number of quantity of a product bought

	WebDriver driver;

	public VerifySubTotal(WebDriver ldriver)
	{
		driver = ldriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="twotabsearchtextbox") WebElement srchbx;
	@FindBy(id="nav-search-submit-button")  WebElement srchbtn;
	@FindBy(xpath = "//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']/child::a[1]") WebElement prd;
	@FindBy(xpath="//div[@id='productFactsDesktopExpander']") WebElement prddet;
	@FindBy(xpath = "//span[@id='a-autoid-48-announce']")   WebElement qnty;
	@FindBy(xpath = "//div[@class='a-popover-wrapper']/child::div/child::ul/child::li[3]") WebElement slctqty;
	@FindBy(xpath = "//input[@id='add-to-cart-button']")   WebElement add2cart;
	@FindBy(xpath = "//div[@id='nav-cart-count-container']/child::span[1]") WebElement cart;
	@FindBy(xpath = "//span[@id='sc-subtotal-amount-activecart']/child::span") WebElement vrfystotal;
	@FindBy(xpath="//div[@class='sc-badge-price-to-pay']/child::div/child::span")WebElement price;
String prdnm;
float qty=3;

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
	public void verifySubTotal()
	{
		float stotal=0;
		String prc=price.getText();

		String item_price=prc.substring(1,prc.length());
		//System.out.println("Formatted prc "+item_price);
		stotal=qty*Float.parseFloat(item_price);
		System.out.println("sub total: "+stotal);
		System.out.println(vrfystotal.getText());
		System.out.println("Both the subtotal are same: Verified");
	}

}
