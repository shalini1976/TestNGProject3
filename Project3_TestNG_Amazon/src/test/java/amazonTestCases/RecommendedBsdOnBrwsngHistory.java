package amazonTestCases;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import callingAmazonTestCases.CallingProgramAmazon;

public class RecommendedBsdOnBrwsngHistory extends CallingProgramAmazon
{
	// Verify the visibility of 'Recommended Based on Browsing History' at the bottom of the page
WebDriver driver;
public RecommendedBsdOnBrwsngHistory(WebDriver ldriver)
{
	driver=ldriver;
	PageFactory.initElements(driver, this);
}
@FindBy(id="twotabsearchtextbox") WebElement srchbx;
@FindBy(id="nav-search-submit-button")  WebElement srchbtn;
@FindBy(xpath="//span[@class='a-size-base-plus a-color-base a-text-normal']") WebElement clkprod1b;
@FindBy(xpath="//div[@class='rhf-sign-in-button']/child::a/child::span") WebElement scrlto;
@FindBy(xpath="//h2[@class='a-carousel-heading a-inline-block a-color-base']") WebElement scrl;
@FindBy(xpath="//span[@class='a-size-base a-color-base s-line-clamp-2']") WebElement clkprod;


String prdnm;
public void searchProduct(String prod)
{
	srchbx.sendKeys(prod);
	prdnm=prod;
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	srchbtn.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	System.out.println("Search button clicked");
}
public void verifyProdPageDisplay()
{
	String actualTitle=driver.getTitle();
	String actual="Amazon.com : ";
	String tname=actual.concat(prdnm);
	String expectedTitle=tname;
	Assert.assertEquals(actualTitle, expectedTitle);
	System.out.println("'"+actualTitle+"' "+"page is displayed: Verified");
}
public void verifyRecomItem()
{
	clkprod1b.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.navigate().back();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,9000)");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	Assert.assertTrue(scrl.isDisplayed());
	System.out.println("'"+scrl.getText()+"' is displayed: Verified");
}

public void clickItemFromRecom()
{
	clkprod.click();
	System.out.println("Product clicked from Recommended Items Based on Browsing History");
}}
