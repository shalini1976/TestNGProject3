package amazonTestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import callingAmazonTestCases.CallingProgramAmazon;

public class VerifyLanguage extends CallingProgramAmazon {

	// TEST CASE: Test the functionality of Change Language Icon

	WebDriver driver;

	public VerifyLanguage(WebDriver ldriver)
	{
		driver = ldriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[@class='icp-nav-flag icp-nav-flag-us icp-nav-flag-lop']") WebElement clklang;
	@FindBy(xpath="//div[@id='icp-language-settings']/child::div[@id='icp-language-headings']/following-sibling::div[2]")WebElement es;

	@FindBy(xpath = "//span[@id='icp-save-button']/child::span/child::input")  WebElement svchngs;
	@FindBy(xpath = "//div[@id='navbar']/child::div") WebElement vrfychngs;
	@FindBy(id="twotabsearchtextbox") WebElement nullclk;
	@FindBy(xpath="//span[@class='nav-line-2']/child::span[@class='icp-nav-flag icp-nav-flag-us icp-nav-flag-lop']")WebElement clklangicon;
    @FindBy(xpath = "//div[@id='icp-language-headings']/following-sibling::div[1]/child::div/child::label/child::i")WebElement langeng;

	public void clickChangeLanguageIcon()
	{
		clklang.click();
		System.out.println("Change Language icon clicked");
	}

	public void selectLanguageEspanol()
	{
		es.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("Spanish (espanol) Language Selected");
	}
	public void saveChanges()
	{
		svchngs.click();
		System.out.println("Changes saved");
	}
	public void verifyChanges()
	{
		String expectedTitle="Change Language & Currency Settings";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("'"+actualTitle+"' is visible in Spanish(espanol): Verified");
	}
	public void changeToEnglish()
	{
		System.out.println("inside change");
		nullclk.click();
		System.out.println("null clicked");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		clklangicon.click();
		System.out.println("Icon clicked");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		langeng.click();
		System.out.println("english clicked");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		svchngs.click();
		String expectedTitle="Change Language & Currency Settings";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("'"+actualTitle+"' is visible in English)\nLanguage changed to Engish: Verified");
	}

}
