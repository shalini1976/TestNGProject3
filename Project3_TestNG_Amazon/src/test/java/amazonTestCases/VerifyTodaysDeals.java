package amazonTestCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import callingAmazonTestCases.CallingProgramAmazon;

public class VerifyTodaysDeals extends CallingProgramAmazon {

	//TEST CASE: Click the menu - Today's Deals and verify the page and its listings

	WebDriver driver;

	public VerifyTodaysDeals(WebDriver ldriver)
	{
		driver=ldriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@id='nav-xshop']/child::a[1]") WebElement toddeel;
	@FindBy(xpath="//div[@id='slot-2']/child::div/child::h1") WebElement pghead;
	@FindBy(xpath="//div[@id='anonCarousel2']/child::ol[@class='a-carousel']/child::li/child::a/child::span") List<WebElement> dealscatgry;


public void clickTodaysDeals()
{
	toddeel.click();
	System.out.println("Today's Deals clicked");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}
public void verifyDealsPage()
{
	String expectedText="Today's Deals";
	String actualText=pghead.getText();
	Assert.assertEquals(actualText,expectedText);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	System.out.println("'Today's Deals' page is displayed: Verified");
}
public void listCategories()
{
	System.out.println("List of categories where deals are available: ");
	for(WebElement categry:dealscatgry)
	{
		System.out.println(categry.getText());
	}
}
}
