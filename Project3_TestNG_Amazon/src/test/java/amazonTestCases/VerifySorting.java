package amazonTestCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;

import callingAmazonTestCases.CallingProgramAmazon;

public class VerifySorting extends CallingProgramAmazon {

	// TEST CASE: Verify the functionality of Sort by - Low to High, High to Low, Avg. Customer Review, Newest Arrivals, Best Seller

	WebDriver driver;

	public VerifySorting(WebDriver ldriver)
	{
		driver = ldriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="twotabsearchtextbox") WebElement srchbx;
	@FindBy(id="nav-search-submit-button")  WebElement srchbtn;
	@FindBy(xpath = "//span[@class='a-button-text a-declarative']")  WebElement sortby;
	@FindBy(xpath = "//ul[@class='a-nostyle a-list-link']/child::li[2]/child::a") WebElement low2high;
	@FindBy(xpath = "//div[@class='a-row a-size-base a-color-base']/child::div/child::a/child::span/child::span")
	List<WebElement> vrfyprc;
	@FindBy(xpath = "//body/child::div[@id='a-page']/following-sibling::div[@id='a-popover-3']/descendant::ul/child::li[3]/child::a") WebElement high2low;
	@FindBy(xpath = "//body/child::div[@id='a-page']/following-sibling::div[@id='a-popover-4']/child::div/child::div/child::ul/child::li[4]/child::a")WebElement avgcustrev;
	@FindBy(xpath="//div[@class='s-main-slot s-result-list s-search-results sg-row']/child::div/following-sibling::div/child::div/descendant::div[@class='a-row a-size-small']/child::span") WebElement vrfycustrev;
	@FindBy(xpath="//body/child::div[@id='a-page']/following-sibling::div[@id='a-popover-5']/child::div/child::div/child::ul/child::li[5]/child::a")WebElement newarrvls;
	@FindBy(xpath="//body/child::div[@id='a-page']/following-sibling::div[@id='a-popover-5']/child::div/child::div/child::ul/child::li[6]/child::a")WebElement bstslrs;
	String pctnm;

	public void enterName(String name)
	{
		srchbx.sendKeys(name);
		pctnm=name;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void verifyProductPage()
	{
		srchbtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		String actualTitle=driver.getTitle();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String actual="Amazon.com : ";
		String tname=actual.concat(pctnm);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String expectedTitle=tname;
		AssertJUnit.assertEquals(actualTitle, expectedTitle);
		System.out.println("'"+actualTitle+"' "+"page is displayed: Verified");
	}
	public void clickSortBy()
	{
		sortby.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void clickLowNHigh()
	{
		low2high.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		System.out.println("Low to High price\n");
		for(WebElement lowprice:vrfyprc)
		{
			System.out.println(lowprice.getText());
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		System.out.println("Items arranged from low to high based on price: Verified");
	}
	//clickSortBy()
	public void clickHighNLow()
	{
		high2low.click();
		for(WebElement highprice:vrfyprc)
		{
			System.out.println(highprice.getText());
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		System.out.println("Items arranged from high to low based on price: Verified");
	}
	//clickSortBy()
	public void clickAvgCustReview()
	{
		avgcustrev.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("Average Customer Review for 1st product");
		String label=vrfycustrev.getAttribute("aria-label");
		System.out.println(label);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		System.out.println("Items arranged according to average customer feedback: Verified");
	}
	//clickSortBy()
	public void clickNewestArrivals()
	{
		newarrvls.click();
		System.out.println("Items arranged according to Newest Arrivals: Verified");
	}
	//clickSortBy()
	public void clickBestSellers()
	{
		bstslrs.click();
		System.out.println("Items arranged according to Best Sellers: Verified");
	}
}
