package amazonTestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import callingAmazonTestCases.CallingProgramAmazon;

public class VerifyBrowsingHistory extends CallingProgramAmazon {

	//TEST CASE: Verify the 'Browsing History' page displays the items viewed

	WebDriver driver;

	public VerifyBrowsingHistory(WebDriver ldriver)
	{
		driver=ldriver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="twotabsearchtextbox") WebElement srchbx;
	@FindBy(id="nav-search-submit-button")  WebElement srchbtn;
	@FindBy(xpath="//span[@class='a-size-base-plus a-color-base a-text-normal']") WebElement item1;
	@FindBy(xpath="//span[text()='Account & Lists']") WebElement acclst;
	@FindBy(xpath="//span[text()='Browsing History']") WebElement brwsnghist;
 	@FindBy(xpath="//h2[@class='_cDEzb_page-title_3M60H']") WebElement brwsnghistpg;
	@FindBy(xpath="//div[@id='gridItemRoot']") WebElement brwsditms;


public void viewItems()
{
	srchbx.sendKeys("stationary");
	srchbtn.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	item1.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.navigate().back();
}
public void mousehoverAccountAndLists()
{
	Actions action=new Actions(driver);
	action.moveToElement(acclst);
	action.perform();
	System.out.println("Account & Lists menu opened");
}
public void clickBrowsingHistory()
{
	brwsnghist.click();
	System.out.println("Browsing History clicked");
}
public void verifyBrowsingHistoryPage()
{
	String expectedTitle="Your Browsing History";
	String actualTitle=brwsnghistpg.getText();
	Assert.assertEquals(actualTitle,expectedTitle);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	System.out.println("Your Browsing History page is displayed: Verified");
	System.out.println(brwsditms.getText());
}

}
