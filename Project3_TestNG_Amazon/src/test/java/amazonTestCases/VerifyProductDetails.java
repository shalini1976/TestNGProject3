package amazonTestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import callingAmazonTestCases.CallingProgramAmazon;

public class VerifyProductDetails extends CallingProgramAmazon
{
	// Verify the product details are displayed correctly. Test for atleast 2 different category products
WebDriver driver;
public VerifyProductDetails(WebDriver ldriver)
{
	driver=ldriver;
	PageFactory.initElements(driver, this);
}
@FindBy(id="twotabsearchtextbox") WebElement srchbx;
@FindBy(id="nav-search-submit-button")  WebElement srchbtn;

@FindBy(xpath="//span[@class='a-size-base-plus a-color-base a-text-normal']") WebElement clkprod1b;
@FindBy(xpath="//span[@id='productTitle']") WebElement clkprod1a;
@FindBy(xpath="//span[@class='a-size-base-plus a-color-base a-text-normal']") WebElement clkprod2b;
@FindBy(xpath="//span[@id='productTitle']") WebElement clkprod2a;

String p1ctnm,strprod1b,strprod1a,p2ctnm,strprod2b,strprod2a;
public void searchProductCategory1(String prodcat1nm)
{
	srchbx.sendKeys(prodcat1nm);
	p1ctnm=prodcat1nm;
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	srchbtn.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	System.out.println("Search button clicked");
}
public void verifyProd1PageDisplay()
{
	String actualTitle=driver.getTitle();
	String actual="Amazon.com : ";
	String tname=actual.concat(p1ctnm);
	String expectedTitle=tname;
	Assert.assertEquals(actualTitle, expectedTitle);
	System.out.println("'"+actualTitle+"' "+"page is displayed: Verified");
}
public void clickProduct1()
{
	strprod1b=clkprod1b.getText();
	System.out.println(clkprod1b.getText());
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	clkprod1b.click();
}
public void verifyProduct1()
{
	System.out.println("Inside Verify Product");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	strprod1a=clkprod1a.getText();
	System.out.println(clkprod1a.getText());
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	Assert.assertEquals(strprod1a, strprod1b);
	System.out.println("Product details for product1 are visible and same: Verified");
}
public void backToHomePage()
{
	driver.navigate().back();
	driver.navigate().back();

}
public void searchProductCategory2(String prodcat2nm)
{
	srchbx.sendKeys(prodcat2nm);
	p2ctnm=prodcat2nm;
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	srchbtn.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	System.out.println("Search button clicked");
}
public void verifyProd2PageDisplay()
{
	String actualTitle=driver.getTitle();
	String actual="Amazon.com : ";
	String tname=actual.concat(p2ctnm);
	String expectedTitle=tname;
	Assert.assertEquals(actualTitle, expectedTitle);
	System.out.println("'"+actualTitle+"' "+"page is displayed: Verified");
}
public void clickProduct2()
{
	strprod2b=clkprod2b.getText();
	System.out.println(clkprod2b.getText());
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	clkprod2b.click();
}
public void verifyProduct2()
{
	System.out.println("Inside Verify Product");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	strprod2a=clkprod2a.getText();
	System.out.println(clkprod2a.getText());
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	Assert.assertEquals(strprod2a, strprod2b);
	System.out.println("Product details for product2 are visible and same: Verified");
}

}
