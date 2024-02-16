package amazonTestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import callingAmazonTestCases.CallingProgramAmazon;

public class VerifyMenuDisplayAll extends CallingProgramAmazon {

	//TEST CASE: Verify the sub-menu options are displayed when you click 'All' menu on the left side
	//Also click 'Electronics' sub-menu and go back to main menu by clicking 'Main Menu'

	WebDriver driver;

	public VerifyMenuDisplayAll(WebDriver ldriver)
	{
		driver=ldriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[@class='hm-icon-label']") WebElement menuall;
	@FindBy(xpath="//div[@id='hmenu-content']/child::ul") WebElement submenuall;
	@FindBy(xpath="//div[text()='Electronics']") WebElement submenuelctrncs;
	@FindBy(xpath="//i[@class='nav-sprite hmenu-arrow-prev']") WebElement back2main;


public void menuDisplayAll()
{
	menuall.click();
	System.out.println("All menu clicked");
}
public void displayMenuOptions()
{
	System.out.println(submenuall.getText());
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	System.out.println("submenu displayed");
}
public void clickSubMenu()
{
	submenuelctrncs.click();
	System.out.println("Electronics clicked");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}
public void clickMain()
{
	back2main.click();
	System.out.println("Back to Main clicked");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}

}
