package amazonTestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import callingAmazonTestCases.CallingProgramAmazon;

public class VerifyCurrencyConverter extends CallingProgramAmazon {

	// TEST CASE: Verify INR is displayed in the list of supported currencies in Amazon currency Converter

	WebDriver driver;

	public VerifyCurrencyConverter(WebDriver ldriver) {
		driver = ldriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='navFooterVerticalRow navAccessibility']/child::div[5]/child::ul/child::li[4]")WebElement currconv;
	@FindBy(xpath = "//img[@alt='Exchange Rates']")WebElement excngrts;
	@FindBy(xpath = "//div[@class='cs-help-sidebar']/child::div/child::div/following-sibling::div/child::ul/child::li[6]")WebElement suppcurr;
	@FindBy(xpath = "//section[@class='a-section']/child::p")WebElement tablehd;
	@FindBy(xpath = "//tbody/child::tr[36]/child::td[1]")WebElement currnameinr;


	public void clickAmazonCurrencyConverter()
	{
		currconv.click();
		System.out.println("'Amazon Currency Converter' clicked");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void clickExchangeRates()
	{
		excngrts.click();
		System.out.println("Exchange Rates clicked");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void clickSupportedCurrencies()
	{
		suppcurr.click();
		System.out.println("Supported Currencies in left pane clicked");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void displayAvailableCurrencies()
	{
		System.out.println(tablehd.getText());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println(currnameinr.getText());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		System.out.println("INR is displayed: Verified");

	}


}
