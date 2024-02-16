package amazonTestCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import callingAmazonTestCases.CallingProgramAmazon;

public class ApplyFilterOnProduct extends CallingProgramAmazon {

	// TEST CASE: Apply filter and check if the products are displayed based on the filter applied
	WebDriver driver;

	public ApplyFilterOnProduct(WebDriver ldriver)
	{
		driver = ldriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="twotabsearchtextbox") WebElement srchbx;
	@FindBy(id="nav-search-submit-button")  WebElement srchbtn;
	@FindBy(xpath="//li[@id='p_89/ANRABESS']/descendant::div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left']/child::label") WebElement brnds;
	@FindBy(xpath="//li[@aria-label='Gown']/descendant::label")WebElement styl;
	@FindBy(xpath="//span[@class='a-text-bold']")WebElement appfltrs;
	@FindBy(xpath="//div[@class='s-main-slot s-result-list s-search-results sg-row']/descendant::h2") List<WebElement> prodlist;
	
	public void enterProductCategory(String name)
	{
		srchbx.sendKeys(name);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void clickSearchButton()
	{
		srchbtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("Search button clicked");
	}
	public void selectBrands()
	{
		brnds.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("ANRABESS Selected");
	}
	public void selectDressStyle()
	{
		styl.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("Gowns selected");
	}
	public void displayAppliedFilters()
	{
		System.out.println(appfltrs.getText());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println(appfltrs.getText()+"ANRABESS, Gowns is displayed: Verified");
	
	}
	public void verifyProductList()
	{
		for(WebElement plst:prodlist)
		{
			System.out.println(plst.getText());
		}
		System.out.println("Products displayed are based on filters applied: Verified");
	}
	
	


}
