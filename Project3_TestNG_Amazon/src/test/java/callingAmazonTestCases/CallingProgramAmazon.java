package callingAmazonTestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import amazonTestCases.AddDeliveredProductToCart;
import amazonTestCases.AddUnDeliveredProductToCart;
import amazonTestCases.ApplyFilterOnProduct;
import amazonTestCases.GiftCardDetails;
import amazonTestCases.LoginWithInvalidNumber;
import amazonTestCases.LoginWithValidNumber;
import amazonTestCases.Logout;
import amazonTestCases.NewCustomerSignIn;
import amazonTestCases.RecommendedBsdOnBrwsngHistory;
import amazonTestCases.RemoveFromCart;
import amazonTestCases.SaveForLater;
import amazonTestCases.SignInWithExistingEmail;
import amazonTestCases.VerifyBrowsingHistory;
import amazonTestCases.VerifyCurrencyConverter;
import amazonTestCases.VerifyLanguage;
import amazonTestCases.VerifyMenuDisplayAll;
import amazonTestCases.VerifyMoveToCart;
import amazonTestCases.VerifyProductDetails;
import amazonTestCases.VerifyProductQuantity;
import amazonTestCases.VerifyScrollUpDownWithLink;
import amazonTestCases.VerifyScrollUpDownWithoutLink;
import amazonTestCases.VerifySearchButton;
import amazonTestCases.VerifySorting;
import amazonTestCases.VerifySubTotal;
import amazonTestCases.VerifyTodaysDeals;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CallingProgramAmazon {
	WebDriver driver;

	@BeforeSuite
	public void launchBrowser() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Browser Launched");
		driver.get("https://amazon.com");
		Thread.sleep(2000);
	}
	@BeforeMethod
	public void verifyAmazonWebPage()
	{
		//Verifying Home Page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//String actualTitle=driver.getTitle();
		//String expectedTitle ="Amazon.com. Spend less. Smile more.";
		//Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Home Page displayed successfully");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//span[@class='a-button-inner']/child::input[@type='submit']")).click();
	}
	@Test
	public void loginValid()  //Can't provide password of my valid account
	{
		LoginWithValidNumber loginvld=new LoginWithValidNumber(driver);
		loginvld.mousehoverAccountAndLists();
		loginvld.clickSignIn();
		loginvld.verifyLoginPage();
		loginvld.enterPhoneNumber("8867686307");
		loginvld.clickContinue1();
		loginvld.enterPassword("pass");
		loginvld.clickContinue2();
		loginvld.verifyLogin();
	}
	
	@Test
	public void loginInValid()
	{
		LoginWithInvalidNumber logininvld=new LoginWithInvalidNumber(driver);
		logininvld.mousehoverAccountAndLists();
		logininvld.clickSignIn();
		logininvld.verifyLoginPage();
		logininvld.enterPhoneNumber("3456728971");
		logininvld.clickContinue1();
		logininvld.displayErrorMessage();
	}
	@Test
	public void logout()
	{
		Logout lgot=new Logout(driver);
		lgot.mousehoverAccountAndLists();
		lgot.clickSignIn();
		lgot.verifyLoginPage();
		lgot.enterPhoneNumber("8867686307");
		lgot.clickContinue1();
		lgot.enterPassword("pass");
		lgot.clickContinue2();
		lgot.verifyLogin();
		lgot.mousehoverAccountAndLists();
		lgot.amzLogout();
	}
	
	@Test
	public void registerWithExistingEmail()
	{
		SignInWithExistingEmail sgnwtheml=new SignInWithExistingEmail(driver);
		sgnwtheml.mousehoverAccountAndLists();
		sgnwtheml.clickNewCustomerStartHere();
		sgnwtheml.verifyRegistrationPage();
		sgnwtheml.enterName("Shalini Shrivastava");
		sgnwtheml.enterEmail("shalini_sri@yahoo.com");
		sgnwtheml.enterPassword("password");
		sgnwtheml.reEnterPassword("password");
		sgnwtheml.clickContinue();
		sgnwtheml.verifyErrorMessage();
	}
	
	@Test
	public void newRegistration()
	{
		NewCustomerSignIn newcustsign=new NewCustomerSignIn(driver);
		newcustsign.mousehoverAccountAndLists();
		newcustsign.clickNewCustomerStartHere();
		newcustsign.verifyRegistrationPage();
		newcustsign.enterName("Shalini S");
		newcustsign.enterEmail("shalini_forwork@yahoo.com");
		newcustsign.enterPassword("password");
		newcustsign.reEnterPassword("password");
		newcustsign.clickContinue();
		newcustsign.verifyEmail("746628");
		newcustsign.clickCreateButton();
		newcustsign.verifyRegistration();
	}

	@Test (priority=1)
	public void verifyMenuAll()
	{
		VerifyMenuDisplayAll vrfymndispall=new VerifyMenuDisplayAll(driver);
		vrfymndispall.menuDisplayAll();
		vrfymndispall.displayMenuOptions();
		vrfymndispall.clickSubMenu();
		vrfymndispall.clickMain();

	}

	@Test //(priority=2)
	public void verifyBrowsingHistory()
	{
		VerifyBrowsingHistory vrfybrwshst=new VerifyBrowsingHistory(driver);
		vrfybrwshst.viewItems();
		vrfybrwshst.mousehoverAccountAndLists();
		vrfybrwshst.clickBrowsingHistory();
		vrfybrwshst.verifyBrowsingHistoryPage();
	}

	@Test
	public void checkTodaysDeals()
	{
		VerifyTodaysDeals vrfytoddls =new VerifyTodaysDeals(driver);
		vrfytoddls.clickTodaysDeals();
		vrfytoddls.verifyDealsPage();
		vrfytoddls.listCategories();
	}

	@Test
	public void verifyGiftCardDetails()
	{
		GiftCardDetails gftcrddet =new GiftCardDetails(driver);
		gftcrddet.clickGiftCards();
		gftcrddet.clickAmazonGiftCards();
		gftcrddet.clickFeaturedBirthday();
		gftcrddet.clickGftCrdInBdayPopUpBx();
		gftcrddet.displayGiftCardDetails();

	}

	@Test
	public void verifyCurrConverter()
	{
		VerifyCurrencyConverter vrfycurrconv=new VerifyCurrencyConverter(driver);
		vrfycurrconv.clickAmazonCurrencyConverter();
		vrfycurrconv.clickExchangeRates();
		vrfycurrconv.clickSupportedCurrencies();
		vrfycurrconv.displayAvailableCurrencies();
	}

	@Test
	public void verifyScrollUpDownFunctionality()
	{
		VerifyScrollUpDownWithoutLink vrfyscrlud=new VerifyScrollUpDownWithoutLink(driver);
		vrfyscrlud.verifyScrollDown();
		vrfyscrlud.verifyScrollUp();
	}

	@Test
	public void verifyScrollUpUsingBacktoTop()
	{
		VerifyScrollUpDownWithLink vrfyscrlwithlnk=new VerifyScrollUpDownWithLink(driver);

		vrfyscrlwithlnk.verifyScrollDown();
		vrfyscrlwithlnk.verifyScrollUpUsingBackToTop();
	}

	@Test
	public void searchButton()
	{
		VerifySearchButton vrfysrchbtn = new VerifySearchButton(driver);
		vrfysrchbtn.enterName("toys");
		vrfysrchbtn.clickSearchButton();
		vrfysrchbtn.verifyPageDisplay();
		vrfysrchbtn.clickProduct();
		vrfysrchbtn.verifyProduct();
	}

	@Test
	public void productDetails()
	{
		VerifyProductDetails vrfyproddet = new VerifyProductDetails(driver);
		vrfyproddet.searchProductCategory1("flowers fresh bouquet");
		vrfyproddet.verifyProd1PageDisplay();
		vrfyproddet.clickProduct1();
		vrfyproddet.verifyProduct1();
		vrfyproddet.backToHomePage();
		vrfyproddet.searchProductCategory2("baby gifts");
		vrfyproddet.verifyProd2PageDisplay();
		vrfyproddet.clickProduct2();
		vrfyproddet.verifyProduct2();
	}

	@Test
	public void recommended()
	{
		RecommendedBsdOnBrwsngHistory recm=new RecommendedBsdOnBrwsngHistory(driver);
		recm.searchProduct("fresh flowers");
		recm.verifyProdPageDisplay();
		recm.verifyRecomItem();
		recm.clickItemFromRecom();
	}

	@Test
	public void verifySortBy()
	{
		VerifySorting vrfysrtng=new VerifySorting(driver);
		vrfysrtng.enterName("hand bags");
		vrfysrtng.verifyProductPage();
		vrfysrtng.clickSortBy();
		vrfysrtng.clickLowNHigh();
		vrfysrtng.clickSortBy();
		vrfysrtng.clickHighNLow();
		vrfysrtng.clickSortBy();
		vrfysrtng.clickAvgCustReview();
		vrfysrtng.clickSortBy();
		vrfysrtng.clickNewestArrivals();
		vrfysrtng.clickSortBy();
		vrfysrtng.clickBestSellers();
	}

	@Test
	public void checkLanguageFunctionality()
	{
		VerifyLanguage vrfylng=new VerifyLanguage(driver);
		vrfylng.clickChangeLanguageIcon();
		vrfylng.selectLanguageEspanol();
		vrfylng.saveChanges();
		vrfylng.verifyChanges();
		vrfylng.changeToEnglish();
	}

	@Test
	public void verifyQuantity()
	{
		VerifyProductQuantity vrfyqty=new VerifyProductQuantity(driver);
		vrfyqty.enterName("hand bags");
		vrfyqty.clickSearchButton();
		vrfyqty.clickProduct();
		vrfyqty.clickQuantity();
		vrfyqty.selectQuantity();
		vrfyqty.clickAddToCart();
		vrfyqty.clickGoToCart();
	}

	@Test
	public void verifySubTotal()
	{
		VerifySubTotal vrfystot=new VerifySubTotal(driver);
		vrfystot.enterName("shirts ");
		vrfystot.clickSearchButton();
		vrfystot.clickProduct();
		vrfystot.clickQuantity();
		vrfystot.selectQuantity();
		vrfystot.clickAddToCart();
		vrfystot.clickGoToCart();
		vrfystot.verifySubTotal();
	}

	@Test
	public void addToCart()
	{
		AddDeliveredProductToCart addprd2crt=new AddDeliveredProductToCart(driver);
		addprd2crt.enterName("shirts ");
		addprd2crt.clickSearchButton();
		addprd2crt.clickProduct();
		addprd2crt.clickAddToCart();
		addprd2crt.clickGoToCart();
		addprd2crt.verifyCart();
	}

	@Test
	public void verifyAddToCart()
	{
		AddUnDeliveredProductToCart vrfyaddprd2crt=new AddUnDeliveredProductToCart(driver);
		vrfyaddprd2crt.enterName("chocolate covered strawberries ");
		vrfyaddprd2crt.clickSearchButton();
		vrfyaddprd2crt.clickProduct();
		vrfyaddprd2crt.verifyDeliveryToIndia();
	}

	@Test
	public void removeCart()
	{
		RemoveFromCart rmfrmcrt=new RemoveFromCart(driver);
		rmfrmcrt.enterName("shirts");
		rmfrmcrt.searchProduct();
		rmfrmcrt.clickProduct();
		rmfrmcrt.clickAddtoCart();
		rmfrmcrt.clickGoToCart();
		rmfrmcrt.clickDelete();
		rmfrmcrt.verifyMessage();
	}

	@Test
	public void saveLater()
	{
		SaveForLater svfrltr=new SaveForLater(driver);
		svfrltr.enterName("shirts");
		svfrltr.searchProduct();
		svfrltr.clickProduct();
		svfrltr.clickAddtoCart();
		svfrltr.clickGoToCart();
		svfrltr.clickSaveForLater();
		svfrltr.verifyMessage();
	}
	
	@Test
	public void moveToCart()
	{
		VerifyMoveToCart vrfymv2crt=new VerifyMoveToCart(driver);
		vrfymv2crt.enterName("shirts");
		vrfymv2crt.searchProduct();
		vrfymv2crt.clickProduct();
		vrfymv2crt.clickAddtoCart();
		vrfymv2crt.clickGoToCart();
		vrfymv2crt.clickSaveForLater();
		vrfymv2crt.verifyMessage();
		vrfymv2crt.moveToCart();
		vrfymv2crt.verifyMove();
	}
	@Test
	public void verifyFilter()
	{
		ApplyFilterOnProduct prdfilter=new ApplyFilterOnProduct(driver);
		prdfilter.enterProductCategory("dress");
		prdfilter.clickSearchButton();
		prdfilter.selectBrands();
		prdfilter.selectDressStyle();
		prdfilter.displayAppliedFilters();
		prdfilter.verifyProductList();
	}
	
	@AfterTest
	public void closeBrowser()
	{
		System.out.println("Inside close");
		//driver.close();
	}
	@AfterSuite
	public void exitBrowser()
	{
		System.out.println("Inside exit");
		//driver.quit();
	}
}
