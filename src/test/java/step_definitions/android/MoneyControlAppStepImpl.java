package step_definitions.android;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.pagefactory.AndroidFindBy;
import locators.android.MoneyControlLocators;
import step_definitions.RunCukesTest;
import utilities.ExcelDataUtil;
import utilities.GlobalUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;
import utilities.MobileKeywords;

public class MoneyControlAppStepImpl extends MobileKeywords implements MoneyControlLocators {

	public static HashMap<String, String> dataMap = new HashMap<String, String>();
	public static Float mcPercentage;
	public static Float nsePercentage;
	public static Float etPercentage;
	public static Float Diff_Between_MC_nad_NSC;
	public static Float Diff_Between_MC_nad_ET;
	public static String x = "";
	public static String a = "";
	public static String b = "";
	public static String y = "";
	public static String c = "";
	public static String d = "";
	public static String z = "";
	public static String e = "";
	public static String f = "";
	public static String g = "";
	public static String c1 = "";
	public static String absoluteValue = "";
	public static String percentageValue = "";
	public static String absoluteValue2 = "";
	public static String percentageValue2 = "";
	public static String absoluteValue3 = "";
	public static String percentageValue3 = "";
	public static String absoluteValue4 = "";
	public static String percentageValue4 = "";

	@Given("^User Open MoneyControl$")
	public void openApp() {
		GlobalUtil.getMobileApp();
	}

	@When("^User clicks on profile icon$")
	public void user_clicks_profileIcon() {
		try {
			clickProfileIcon();
		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@When("^User Click on Menu$")
	public void clickMenu() {
		KeywordUtil.delay(2000);
		if (GlobalUtil.isWebElementPresent(OK, type_xpath)) {
			GlobalUtil.getMDriver().findElement(By.xpath(OK)).click();
		}
		clickMenuTab();
	}

	@Then("^User Click on MyPortfolio$")
	public void clickMyPortfolio() {
		Assert.assertEquals(GlobalUtil.getMDriver().findElement(By.xpath(myportfoliobutton)).getText(), "My Portfolio",
				"My portfolio link is visible");
		RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("My portfolio link is visible"));
		clickmyportfolio();
	}

	@And("^User Clicks on Login with facebook$")
	public void clickLoginwithfacebookbutton() {
		try {
			Assert.assertEquals(GlobalUtil.getMDriver().findElement(By.xpath(loginwithfacebook)).getText(),
					"LOGIN WITH FACEBOOK", "facebook login link is visible");
			RunCukesTest.logger.log(LogStatus.PASS,
					HTMLReportUtil.passStringGreenColor("Login with facebook is displayed"));
			clickloginwithfacebook();

		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@And("^Read \"(.*)\" from Excel file$")
	public void testdata_from_Excel_file(String arg1) {
		try {
			KeywordUtil.cucumberTagName = "Mobile";
			dataMap = ExcelDataUtil.getTestDataWithTestCaseID("MoneyControl", arg1);

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	@And("^Read \"(.*)\" data from Excel file$")
	public void Read_stackvariation_testdata_from_Excel_file(String arg1) {
		try {
			KeywordUtil.cucumberTagName = "Mobile";
			dataMap = ExcelDataUtil.getTestDataWithTestCaseID("MoneyControl", arg1);

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());

		}
	}

	@And("^Read login Testdata \"(.*)\" from Excel file$")
	public void Read_the_facebook_testdata_from_Excel_file(String arg1) {
		try {
			KeywordUtil.cucumberTagName = "Mobile";
			dataMap = ExcelDataUtil.getTestDataWithTestCaseID("MoneyControl", arg1);

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	@When("^Enter email, password and click login$")
	public void loginwithEmailfromExcel() {
		explicitWaitForElementforGivenTime(emailoruserid, type_xpath, 10);
		GlobalUtil.getMDriver().findElement(By.xpath(emailoruserid)).sendKeys(dataMap.get("Email"));
		GlobalUtil.getMDriver().findElement(By.xpath(emailpassword)).sendKeys(dataMap.get("Password"));
		// GlobalUtil.getMDriver().findElement(By.xpath(emaillogin)).click();
	}

	@And("^User enters facebook details and click login$")
	public void loginwithfacebook() {
		do_facebook_login(dataMap.get("Email"), dataMap.get("Password"));

	}

	@And("^User enters Google details and click login$")
	public void loginwithgoogle() {
		do_google_login(dataMap.get("Email"), dataMap.get("Password"));
	}

	@And("^User verifies login page and click on logout$")
	public void verifyloginpage() {
		verify_loginpage(dataMap.get("Email"));
	}

	@And("^User Clicks on Login with google$")
	public void clickLoginwithgooglebutton() {
		try {
			Assert.assertEquals(GlobalUtil.getMDriver().findElement(By.xpath(loginwithgoogle)).getText(),
					"LOGIN WITH GOOGLE", "google link is visible");
			RunCukesTest.logger.log(LogStatus.PASS,
					HTMLReportUtil.passStringGreenColor("Login with google is displayed"));
			clickgooglelogin();

		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@And("^Add stocks \"(.*)\" to profile$")
	public void addStocksToProfile(String stockname) {
		dataMap = ExcelDataUtil.getTestDataWithTestCaseID("MoneyControl", stockname);
		add_stocks_to_profile(dataMap.get("StockName"));
	}

	@And("^Add Mutualfunds \"(.*)\" to profile$")
	public void add_mutualfunds_ToProfile(String stockname) {
		dataMap = ExcelDataUtil.getTestDataWithTestCaseID("MoneyControl", stockname);
		add_mutualfunds_toprofile(dataMap.get("Mutualfunds"));
	}

	@And("^Add ULIPs \"(.*)\" to profile$")
	public void add_ULIPs_ToProfile(String stockname) {
		dataMap = ExcelDataUtil.getTestDataWithTestCaseID("MoneyControl", stockname);
		add_ulips_toprofile(dataMap.get("ULIP"));
	}

	@And("^Add Bullions \"(.*)\" to profile$")
	public void add_Bullions_ToProfile(String stockname) {
		dataMap = ExcelDataUtil.getTestDataWithTestCaseID("MoneyControl", stockname);
		add_bullions_toprofile(dataMap.get("Bullions"));
	}

	@And("^Verify stocks are correctly reflected or not with respect to stockname$")
	public void verifyStocksreflection() {
		verify_stocks_reflection(dataMap.get("StockName"));
	}

	@And("^User get the networth amount and checks for the confirmation$")
	public void user_get_networth() {
		KeywordUtil.delay(2000);
		explicitWaitForElementforGivenTime(summary_option, type_xpath, 10);
		GlobalUtil.getMDriver().findElement(By.xpath(summary_option)).click();

		float total_investment = user_verifies_investment_amounts();

		KeywordUtil.delay(3000);

		String networth = GlobalUtil.getMDriver().findElement(By.xpath(Networth)).getText();
		if (networth.contains(",")) {
			networth = networth.replace(",", "");
		}
		float total_networth = Float.parseFloat(networth);
		System.out.println();
		System.out.println("total networth is " + total_networth);
		System.out.println();
		if (total_networth - total_investment < 100) {
			System.out.println("Networth amount is tallied with total of all the inverstments is verified");
		} else {
			System.out.println("Networth amount is not tallied with total of all the inverstments");
		}

	}

	@Then("^User Click on MyWatchlist$")
	public void clickMyWatchlist() {
		try {
			Assert.assertEquals(GlobalUtil.getMDriver().findElement(By.xpath(my_watchlist)).getText(), "My Watchlist",
					"My Watchlist link is visible");
			RunCukesTest.logger.log(LogStatus.PASS,
					HTMLReportUtil.passStringGreenColor("My Watchlist link is visible"));
			clickmywatchlist();

		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@And("^User Click on AddStocks$")
	public void click_addstocks_mywatchlist() {
		try {

			click_addstocks_symbol_mywatchlist();

		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@And("^User enters \"(.*)\" stocks to watchlist$")
	public void enter_stockname_watchlist(String stockname) {
		dataMap = ExcelDataUtil.getTestDataWithTestCaseID("MoneyControl", stockname);
		KeywordUtil.delay(2000);
		GlobalUtil.getMDriver().findElement(By.xpath(stocks_option_in_watchlist)).click();
		KeywordUtil.delay(2000);
		enter_stockname_to_watchlist(dataMap.get("StockName"));
		KeywordUtil.delay(2000);
		GlobalUtil.getMDriver().findElement(By.xpath(stocks_option_in_watchlist)).click();
		KeywordUtil.delay(2000);
		user_verifies_stocknames_watchlist(dataMap.get("StockName"));

	}

	@And("^User enters \"(.*)\" mutualfunds to watchlist$")
	public void enter_mutualfundname_watchlist(String stockname) {
		dataMap = ExcelDataUtil.getTestDataWithTestCaseID("MoneyControl", stockname);
		KeywordUtil.delay(2000);
		GlobalUtil.getMDriver().findElement(By.xpath(mutualfunds_option_in_watchlist)).click();
		KeywordUtil.delay(2000);
		try {
			enter_mfname_to_watchlist(dataMap.get("Mutualfunds"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		KeywordUtil.delay(2000);
		GlobalUtil.getMDriver().findElement(By.xpath(mutualfunds_option_in_watchlist)).click();
		KeywordUtil.delay(2000);
		user_verifies_stocknames_watchlist(dataMap.get("Mutualfunds"));

	}

	@And("^User enters \"(.*)\" commodities to watchlist$")
	public void enter_commodityname_watchlist(String stockname) {
		dataMap = ExcelDataUtil.getTestDataWithTestCaseID("MoneyControl", stockname);
		KeywordUtil.delay(2000);
		GlobalUtil.getMDriver().findElement(By.xpath(commodities_option_in_watchlist)).click();
		KeywordUtil.delay(2000);
		enter_commodityname_in_watchlist(dataMap.get("Commodities"));
		KeywordUtil.delay(2000);
		GlobalUtil.getMDriver().findElement(By.xpath(commodities_option_in_watchlist)).click();
		KeywordUtil.delay(2000);
		user_verifies_stocknames_watchlist(dataMap.get("Commodities"));
	}

	@And("^User enters \"(.*)\" futures to watchlist$")
	public void enter_futurename_watchlist(String stockname) {
		dataMap = ExcelDataUtil.getTestDataWithTestCaseID("MoneyControl", stockname);
		KeywordUtil.delay(2000);
		GlobalUtil.getMDriver().findElement(By.xpath(futures_option_in_watchlist)).click();
		KeywordUtil.delay(2000);
		enter_futurename_in_watchlist(dataMap.get("Futures"));
		KeywordUtil.delay(2000);
		GlobalUtil.getMDriver().findElement(By.xpath(futures_option_in_watchlist)).click();
		KeywordUtil.delay(2000);
		user_verifies_stocknames_watchlist(dataMap.get("Futures"));
	}

	@And("^User enters \"(.*)\" currencies to watchlist$")
	public void enter_currencyname_watchlist(String stockname) {
		dataMap = ExcelDataUtil.getTestDataWithTestCaseID("MoneyControl", stockname);
		KeywordUtil.delay(2000);
		GlobalUtil.getMDriver().findElement(By.xpath(currencies_option_in_watchlist)).click();
		KeywordUtil.delay(2000);
		enter_currencyname_in_watchlist(dataMap.get("Currencies"));
		KeywordUtil.delay(2000);
		GlobalUtil.getMDriver().findElement(By.xpath(currencies_option_in_watchlist)).click();
		KeywordUtil.delay(2000);
		user_verifies_stocknames_watchlist(dataMap.get("Currencies"));
	}

	@And("^User Click on Done button$")
	public void click_done_mywatchlist() {
		try {

			click_done_watchlist();
			KeywordUtil.delay(1500);

		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@And("^Verify stocks are correctly reflected or not with respect to \"(.*)\" in watchlist$")
	public void check_stocksadded_watchlist(String stockname) {
		dataMap = ExcelDataUtil.getTestDataWithTestCaseID("MoneyControl", stockname);
		KeywordUtil.delay(2000);
		clickMenuTab();
		KeywordUtil.delay(1000);
		clickmywatchlist();
		KeywordUtil.delay(2000);
		GlobalUtil.getMDriver().findElement(By.xpath(stocks_option_in_watchlist)).click();
		KeywordUtil.delay(2000);
		user_verifies_stocknames_watchlist(dataMap.get("StockName"));

		KeywordUtil.delay(2000);
		/*
		 * GlobalUtil.getMDriver().findElement(By.xpath(
		 * mutualfunds_option_in_watchlist)).click(); KeywordUtil.delay(2000);
		 * user_verifies_stocknames_watchlist(dataMap.get( "Mutualfunds"));
		 * 
		 * KeywordUtil.delay(2000);
		 */
		GlobalUtil.getMDriver().findElement(By.xpath(commodities_option_in_watchlist)).click();
		KeywordUtil.delay(2000);
		user_verifies_stocknames_watchlist(dataMap.get("Commodities"));

		KeywordUtil.delay(2000);
		GlobalUtil.getMDriver().findElement(By.xpath(futures_option_in_watchlist)).click();
		KeywordUtil.delay(2000);
		user_verifies_stocknames_watchlist(dataMap.get("Futures"));

		KeywordUtil.delay(2000);
		GlobalUtil.getMDriver().findElement(By.xpath(currencies_option_in_watchlist)).click();
		KeywordUtil.delay(2000);
		user_verifies_stocknames_watchlist(dataMap.get("Currencies"));

	}

	@And("^User click logout$")
	public static void pro_user_logout() {
		prouser_logout();
	}

	@And("^User enters ProUser credentials and click login$")
	public static void enter_prouser_credentials() {
		enter_pro_user_credentials(dataMap.get("Email"), dataMap.get("Password"));
	}

	@And("^User Click on News tab$")
	public void user_click_on_News_tab() {
		try {
			click_News_Tab();
			// KeywordUtil.delay(2000);
		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@And("^User moves to Opinion tab$")
	public void user_moves_to_Opinion_tab() {

		try {
			// click_Opinion_Tab();
			/*
			 * TouchAction t=new TouchAction(GlobalUtil.getMDriver()); for(int
			 * i=0;i<=3;i++) { t.press(700, 1100).moveTo(480,
			 * 1100).release().perform(); KeywordUtil.delay(3000); }
			 */
			GlobalUtil.getMDriver()
					.findElements(By
							.xpath("//*[@resource-id='com.divum.MoneyControl:id/tabs']/android.widget.LinearLayout/android.widget.TextView"))
					.get(4).click();
			KeywordUtil.delay(2000);
		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@And("^Non Pro User reads a news with Pro symbol$")
	public void user_reads_a_news_with_pro_symbol() {
		KeywordUtil.delay(8000);
		opinion_get_news();
		mobileSwipeTouchAction(500, 1600, 500, 1450, 1000);
		opinion_get_news();
		mobileSwipeTouchAction(500, 1600, 500, 1450, 1000);
		opinion_get_news();
	}

	@And("^Pro User reads news with Pro symbol$")
	public void pro_user_reads_news_with_pro_symbol() {

		pro_user_opinion_get_news();
		KeywordUtil.delay(1000);
		mobileSwipeTouchAction(500, 1600, 500, 1450, 1000);
		pro_user_opinion_get_news();
		KeywordUtil.delay(1000);
		mobileSwipeTouchAction(500, 1600, 500, 1450, 1000);
		pro_user_opinion_get_news();
		KeywordUtil.delay(1000);
	}

	@And("^User accepts messages$")
	public static void accept_messages() {

		// KeywordUtil.delay(2000);
		try {
			if (KeywordUtil.isWebElementPresent(msg_1, type_xpath)) {
				Assert.assertEquals(GlobalUtil.getMDriver().findElement(By.xpath(iaccept)).getText(), "I ACCEPT",
						"consent messages are visible");
				RunCukesTest.logger.log(LogStatus.PASS,
						HTMLReportUtil.passStringGreenColor("consent messages are displayed"));
				click(msg_1, type_xpath);
				click(msg_2, type_xpath);
				click(msg_3, type_xpath);
				click(iaccept, type_xpath);
			}
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());

		}

	}

	@And("^User click on SignUp$")
	public static void clickSignup() {
		click_signup_button();
	}

	@And("^User clic on Sign up with Email$")
	public static void clickSignupwithEmail() {
		click_SignupwithEmail();
	}

	@And("^User enters firstname, lastname, Email username and Email password$")
	public static void enterEmailcredentials() {
		enter_emaildetails(dataMap.get("Password"));

	}

	@Then("^User verifies the verification message$")
	public static void emailVerification() {
		email_success_verification();
	}

	@Then("^Enter Pro users details like \"([^\"]*)\" and \"([^\"]*)\" and click login$")
	public static void enter_Pro_users_details_like_and_and_click_login(String Pro_usersID, String Pro_userspassword) {

		enter_Prousers_details_and_click_login(Pro_usersID, Pro_userspassword);
	}

	////////////////////////////////////////////////////

	@When("^User click on searchbutton$")
	public void user_click_on_searchbutton() {
		try {

			clicksearchbt();

			System.out.println(GlobalUtil.getMDriver().findElement(By.id("getQuote_editSearchBox")).getText());
			Assert.assertEquals(GlobalUtil.getMDriver().findElement(By.id("getQuote_editSearchBox")).getText(),
					"Search Stocks, Funds, Commodities etc", "User click on search button is veryfied");

		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	@Given("^User open MoneycontrolApp and verify App launching and App closing Time$")
	public void openappp() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println("app launching time is " + dtf.format(now));

		// RunCukesTest.logger.log(LogStatus.PASS,
		// HTMLReportUtil.passStringGreenColor("before launch date"));

		String x = dtf.format(now);
		System.out.println(x.substring(x.length() - 5, x.length() - 3) + ":" + x.substring(x.length() - 2, x.length()));
		int a = Integer.parseInt(x.substring(x.length() - 5, x.length() - 3));

		int a1 = Integer.parseInt(x.substring(x.length() - 2, x.length()));

		KeywordUtil.delay(3000);
		Assert.assertEquals(GlobalUtil.getMDriver().findElement(By.xpath(home_display)).getText(), "Home",
				"MoneyControl app opened verified");

		GlobalUtil.getMDriver().quit();
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime end = LocalDateTime.now();
		System.out.println("app ending time is " + dt.format(end));
		String y = dtf.format(end);
		System.out.println(y.substring(y.length() - 5, y.length() - 3) + ":" + y.substring(y.length() - 2, y.length()));
		int b = Integer.parseInt(y.substring(y.length() - 5, y.length() - 3));

		int b1 = Integer.parseInt(y.substring(y.length() - 2, y.length()));
		// int c=b-a;
		int c = (b + (b1 / 60)) - (a + (a1 / 60));
		int c1 = ((b * 60 + b1) - (a * 60 + a1));
		c1 = c1 - (c * 60);

		System.out.println("Time Dfference is " + c + " minutes " + c1 + " sec");

	}

	@When("^User Click on Menu_tab$")
	public void user_Click_on_Menutab() {

		try {
			clickMenuTab();
		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@Then("^User Click on Moneycontrol_Pro$")
	public void user_Click_on_Moneycontrol_Pro() {

		try {
			clickMoneycontrolpro();
		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@Given("^User open Mobile notifications$")
	public void Open_notification_bar() {
		openNotificationsAndroid();
		KeywordUtil.delay(2000);
	}

	@Given("^User click on notification and verify correct page$")
	public void verify_notification() {
		lockDeviceAndroid();
		KeywordUtil.delay(5000);
		unlockDeviceAndroid();
		mobileSwipeTouchAction(500, 1900, 500, 700, 1000);
	}

	@Then("^User_Clicks on Markets_Tab$")
	public void user_Clicks_on_Markets_Tab() {

		MarketTab();

	}

	@Then("^User_Click on Top_Gainers$")
	public void user_Click_on_Top_Gainers() {
		topGainers();
		mobileSwipeTouchAction(383, 1090, 383, 900, 500);
		topGainers();
		mobileSwipeTouchAction(383, 1090, 383, 900, 500);
		topGainers();
	}

	@Then("^User_verify top_gainers$")
	public void user_verify_topgainers() {
		verifyTopgainers();
	}

	@Then("^User_Click on Top Losers$")
	public void user_Click_on_Top_Losers() {
		ClickToplosers();
		mobileSwipeTouchAction(383, 1090, 383, 900, 500);
		ClickToplosers();
		mobileSwipeTouchAction(383, 1090, 383, 900, 500);
		ClickToplosers();
	}

	@Then("^User_verify top losers$")
	public void user_verify_toplosers() {
		verifyToplosers();
	}

	String userid1;
	String userid2;

	@When("^User run App in Background$")
	public void user_run_App_in_Background() throws Throwable {
		System.out.println();
		System.out.println("MC App will be going to run in background");
		explicitWaitForElementforGivenTime(portfolio_profile, type_xpath, 10);
		GlobalUtil.getMDriver().findElement(By.xpath(portfolio_profile)).click();
		userid1 = GlobalUtil.getMDriver().findElement(By.xpath(portfolio_profile_useremail)).getText();
		System.out.println("Before App Background run Pro user ID is   :" + userid1);
		GlobalUtil.getMDriver().runAppInBackground(Duration.ofSeconds(30));
		Thread.sleep(5000);
	}

	@When("^User re launch MC App$")
	public void user_re_launch_MC_App() throws Throwable {

		userid2 = GlobalUtil.getMDriver().findElement(By.xpath(portfolio_profile_useremail)).getText();
		System.out.println("After App Background run Pro user ID is   :" + userid2);
	}

	@When("^User verify Before App Background run and relaunch MC app pro User login$")
	public void user_verify_Before_App_Backgroung_and_relaunch_MC_app_pro_User_login() throws Throwable {
		System.out.println();

		if (userid1.contains(userid2)) {
			System.out.println(
					"Before App Background run MC pro user and Re launch App MC pro user are Still logged in : Test Passed");

		} else {
			System.out.println("Before App Back groung run and Re launch App MC pro User are NOT same  : Test Failed");
		}
		System.out.println();
	}

	@And("^User kill the App$")
	public void user_kill_the_App() throws Throwable {
		GlobalUtil.getMDriver().closeApp();
	}

	@And("^User re-Open MoneyControl_App$")
	public void user_re_Open_MoneyControl_App() throws Throwable {
		try {

			// DriverUtil.getMobileApp();
			GlobalUtil.getMobileApp();
			Thread.sleep(3000);

		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@When("^User verify After kill the App and relaunch MC app, pro User are logged in or not$")
	public void user_verify_After_kill_the_App_and_relaunch_MC_app_pro_User_are_logged_in_or_not() throws Throwable {
		clickProfileIcon();
		String loginbt = GlobalUtil.getMDriver().findElement(By.xpath(emaillogin)).getText();
		System.out.println();
		System.out.println("Re-launch app cheking ext   :" + loginbt);
		System.out.println();

		if (GlobalUtil.getMDriver().findElement(By.xpath(emaillogin)).isDisplayed()) {
			System.out.println("Pro Users are showing logged out display");
		} else {
			System.out.println("Pro Users are showing still logged in display");
		}
		System.out.println();
	}

	@Given("^User perform vertical swipe for Stock_Action$")
	public void stockActionVerticalSwipe() throws Throwable {

		Thread.sleep(2000);
		while (2 > 1) {
			try {
				GlobalUtil.getMDriver().findElement(By.xpath("//*[@text='Stocks Action']")).isDisplayed();
				break;
			} catch (Exception ex) {
				Thread.sleep(2000);
				swipeVerticalBottom1();
				Thread.sleep(3000);
				System.out.println("swipe done for Stock Action visibility");
			}
		}
		swipeVerticalBottom2();
	}

	@And("^user get the Absolute value and percentage value for Stocks Action$")
	public void user_get_the_Absolute_value_and_percentage_value() throws Throwable {

		stockActionTopGainers();
		for (int i = 0; i < 3; i++) {
			refreshPage();
		}
		System.out.println("Refresh Done");
		System.out.println();
		KeywordUtil.delay(2000);
		while (2 > 1) {
			try {
				GlobalUtil.getMDriver().findElement(By.xpath("//*[@text='Stocks Action']")).isDisplayed();
				break;
			} catch (Exception ex) {
				Thread.sleep(2000);
				swipeVerticalBottom1();
				System.out.println("swipe done for Stock Action visibility");
			}
		}
		swipeVerticalBottom2();
		stockActionTopGainers();

	}

	@Given("^user get the Absolute value and percentage value for Commodities And currencies$")
	public void getCommodityAndCurrencyValue() throws Exception {

		while (2 > 1) {
			try {
				GlobalUtil.getMDriver().findElement(By.xpath("//*[@text='Commodities and Currencies']")).isDisplayed();
				break;
			} catch (Exception ex) {
				Thread.sleep(2000);
				swipeVerticalBottom1();

			}
		}
		// swipeVerticalBottom2();
		System.out.println("swipe done for Commodities And Currencies visibility");
		commoditiesAndCurrencies();

		for (int i = 0; i <= 4; i++) {
			refreshPage();
		}
		System.out.println("Refresh Done for Commodities ");
		System.out.println();
		KeywordUtil.delay(2000);
		while (2 > 1) {
			try {
				GlobalUtil.getMDriver().findElement(By.xpath("//*[@text='Commodities and Currencies']")).isDisplayed();
				break;
			} catch (Exception ex) {
				Thread.sleep(2000);
				swipeVerticalBottom1();

			}
		}
		// swipeVerticalBottom2();
		System.out.println("swipe done for Commodities And Currencies visibility");
		commoditiesAndCurrencies();
		Thread.sleep(2000);
		System.out.println("Horizantal Swipe");

		for (int i = 0; i <= 1; i++) {
			Horizontalswipe();
		}

		System.out.println("Horizantal swipe Done");
		getCurrenciesVal();
	}

	@Then("^User validate the order of absolute and percentage values$")
	public void user_validate_the_order_of_absolute_and_percentage_values() {
		try {

			stockActionValidation();

		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	String NonProAdds_Text;

	@When("^User checks NonProuser Adds$")
	public void user_checks_NonProuser_Adds() throws Throwable {
		Thread.sleep(8000);

		// System.out.println("driver collect the Adds");
		List<MobileElement> list = GlobalUtil.getMDriver().findElements(By.xpath(NonproAdds));
		// System.out.println(list.size());

		String x = "";
		for (int j = 0; j < list.size(); j++) {
			System.out.println("Add Name is :" + list.get(j).getText());
			NonProAdds_Text = list.get(j).getText();
			x = x + NonProAdds_Text;
		}
		if (GlobalUtil.getMDriver().findElement(By.xpath(NonproAdds)).isDisplayed()) {
			System.out.println("Non Pro users getting Adds and able to see Adds :Test case Passed");
		} else {
			System.out.println("Non Pro users not getting Adds :Test case Failed");
		}

	}

	@Then("^User_Click on Moneycontrol_Pro$")
	public void user_Click_on_Moneycontrol_Pro1() throws Throwable {
		try {
			clickMoneycontrolpro();
		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@And("^Read \"(.*)\" from Excel_file$")
	public void given_Read_the_test_data_from_Excel_file(String arg1) {
		try {
			KeywordUtil.cucumberTagName = "Mobile";
			dataMap = ExcelDataUtil.getTestDataWithTestCaseID("MoneyControl", arg1);

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	@And("^Pro User Verifies Adds$")
	public void enter_Pro_users_details_like_and_and_click_login() throws Throwable {

		try {
			Thread.sleep(3000);
			getContentHome();
			clickProfilelogout();
			clicklogout();
			Assert.assertNotEquals(pro_user_indices, "Indices", "pro user is not getting adds is verified");
		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@Then("^User verifies Notifications$")
	public void user_verifies_Notifications() throws Throwable {
		pushNotifications();
		mobileSwipeTouchAction(500, 1900, 500, 700, 1000);
	}

	@Then("^User click on Active by value$")
	public void user_click_on_Active_by_value() throws Throwable {
		activeByValue();
	}

	@Then("^User Verify the Stocks$")
	public void user_Verify_the_Stocks() throws Throwable {
		verifyStockDuplicate();
	}

	@Then("^User_Enter stockname for Checking MC stack value with \"(.*)\"$")
	public void mcStockvalue(String name) {

		enterMcStock(dataMap.get(name));
	}

	@Then("^User_get the MCS stackvalues$")
	public void mcStockValue() throws InterruptedException {
		getMcStockValues();

	}

	@Then("^User_switch to NSE stock App$")
	public void nscApp() throws Throwable {
		switchToNscApp();
	}

	@Then("^User_Enter stockname for checking NSES with \"(.*)\"$")
	public void nscStockName(String name) throws Throwable {

		enterNscStockName(dataMap.get(name));
	}

	@Given("^User_switch to ET stock Appp$")
	public void etApp() throws Throwable {
		pressKeyAndroid(AndroidKey.HOME);
		System.out.println("Back Home Done");
		switchToEtApp();

	}

	@And("^Read \"(.*)\" data from Excel_file$")
	public void Read_the_test_data_from_Excel_file(String arg1) {
		try {
			KeywordUtil.cucumberTagName = "Mobile";
			dataMap = ExcelDataUtil.getTestDataWithTestCaseID("AppTestData", arg1);
			System.out.println(arg1);

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	@And("^User_Enter stockname for ETS Stack to get_ETS value with \"(.*)\"$")
	public void etStockName(String name) throws Throwable {

		enterEtStockName(dataMap.get(name));
	}

	@Then("^User validate the NIFTY Stocks for MC, NSE and ET, compare values bellow two percentage$")
	public void validation() throws Exception {
		mcNseEtComapreStockPercentage();
	}

	////// ************** New Test
	////// Cases************************///////////////////////////////////////////////////

	@When("^User clicks skips next option$")
	public void user_clicks_skip() {
		for (int i = 0; i < 13; i++) {
			mobileTap(520, 125);
			KeywordUtil.delay(800);
		}
	}

	@And("^User goes to TopNews section in News tab$")
	public void user_goes_to_topnews_section_in_news_tab() {
		click_News_Tab();
		KeywordUtil.delay(2000);
	}

	@And("^User collects top 5 news from TopNews section$")
	public void user_collects_top5news_from_TopNews_section() {
		read_top5news_in_topNews();

	}

	@And("^User goes to Homepage$")
	public void user_goes_to_homepage() {
		go_to_home();
	}

	@And("^User checks for the top 5 news headlines in Homepage$")
	public void user_checks_for_top5news_in_homepage() {

		MobileElement ae = GlobalUtil.getMDriver().findElement(By.xpath(
				"//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='0']"));
		int x = ae.getLocation().getX();
		int y = ae.getLocation().getY();
		int w = ae.getSize().getWidth();
		int h = ae.getSize().getHeight();
		System.out.println("x is " + x + " y is " + y + " w is " + w + " h is " + h);
		// x is 0 y is 540 w is 756 h is 189

		String news_text_homepage_first = GlobalUtil.getMDriver()
				.findElement(By
						.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='0']"))
				.getText();
		System.out.println(news_text_homepage_first);
		for (int i = 0; i < 3; i++) {
			// t.press(x+850,
			// y+80).waitAction(Duration.ofMillis(2000)).moveTo(x+200,
			// y+80).release();
			// t.press(800,630).waitAction(Duration.ofMillis(3000)).moveTo(100,630).release();
			Dimension dim = GlobalUtil.getMDriver().manage().window().getSize();
			int height = dim.getHeight();
			int width = dim.getWidth();
			int y1 = (int) (height * 0.30);
			int startx = (int) (width * 0.80);
			int endx = (int) (width * 0.30);
			mobileSwipeTouchAction(startx, y1, endx, y1, 1000);
			String news_text_homepage = GlobalUtil.getMDriver()
					.findElement(By
							.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='0']"))
					.getText();
			System.out.println(news_text_homepage);
		}
		String news_text_homepage_last = GlobalUtil.getMDriver()
				.findElement(By
						.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='1']/android.widget.TextView[@index='0']"))
				.getText();
		System.out.println(news_text_homepage_last);

	}

	@And("^User checks for the top 5 news time in Homepage$")
	public void user_checks_for_top5news_time_in_homepage() {
		MobileElement ae = GlobalUtil.getMDriver().findElement(By.xpath(
				"//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='1']"));

		/*
		 * int x=ae.getLocation().getX(); int y=ae.getLocation().getY(); int
		 * w=ae.getSize().getWidth(); int h=ae.getSize().getHeight();
		 * System.out.println("x is "+x+" y is "+y+" w is "+w+" h is "+h);
		 */

		KeywordUtil.delay(1000);
		String news_text_homepage_first = ae.getText();
		System.out.println(news_text_homepage_first);
		// news_time[0]=news_text_homepage_first;
		for (int i = 0; i < 3; i++) {
			// t.press(x+850,
			// y+80).waitAction(Duration.ofMillis(2000)).moveTo(x+200,
			// y+80).release();
			// t.press(800,630).waitAction(Duration.ofMillis(3000)).moveTo(100,630).release();
			KeywordUtil.delay(1000);
			Dimension dim = GlobalUtil.getMDriver().manage().window().getSize();
			int height = dim.getHeight();
			int width = dim.getWidth();
			int y1 = (int) (height * 0.30);
			int startx = (int) (width * 0.80);
			int endx = (int) (width * 0.30);
			mobileSwipeTouchAction(startx, y1, endx, y1, 1000);
			String news_text_homepage = ae.getText();
			System.out.println(news_text_homepage);
			// news_time[i+1]=news_text_homepage;
		}
		KeywordUtil.delay(1000);
		MobileElement ae2 = GlobalUtil.getMDriver().findElement(By.xpath(
				"//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='1']/android.widget.TextView[@index='1']"));
		String news_text_homepage_last = ae2.getText();
		System.out.println(news_text_homepage_last);
		// news_time[4]=news_text_homepage_first;
		System.out.println();
		/*
		 * for(int i=0;i<news_time.length;i++) {
		 * System.out.println(news_time[i]); }
		 */

	}

	@And("^User verifies if the news uploaded with in 3 hrs$")
	public void user_verifies_if_the_news_uploaded_within_3hrs() {
		user_verifies_news_time();
	}

	@And("^User clicks on TopNews in Homepage$")
	public void user_clicks_on_TopNews_in_homepage() {
		click_on_TopNews_homepage();
	}

	@Then("^User verifies if TopNews list page is triggered$")
	public void user_verifies_if_topnews_list_page_triggered() {
		topnews_page_triggered();
	}

	@And("^User goes to Indices section in Homepage$")
	public void user_goes_to_indices_section_in_homepage() {
		size = GlobalUtil.getMDriver().manage().window().getSize();
		int starty = (int) (size.height * 0.70);
		int endy = (int) (size.height * 0.10);
		int startx = size.width / 2;
		mobileSwipeTouchAction(startx, starty, startx, endy, 1000);
	}

	@And("^User checks Indian indices and Global indices display$")
	public void user_checks_indian_and_global_indices() {
		List<MobileElement> indian_indices_list = GlobalUtil.getMDriver().findElements(By.xpath(
				"//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.LinearLayout/android.view.ViewGroup"));
		System.out.println("Indian indices list in home page is " + indian_indices_list.size());
		if (indian_indices_list.size() - 1 == 4) {
			System.out.println("4 Indian indices are diplayed");
		}
		List<MobileElement> global_indices_list = GlobalUtil.getMDriver().findElements(By.xpath(
				"//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='1']/android.widget.LinearLayout/android.view.ViewGroup"));
		System.out.println("Global indices list in home page is " + global_indices_list.size());
		if (global_indices_list.size() - 1 == 4) {
			System.out.println("4 Global indices are diplayed");
		}

	}

	String indian_4_indices_names[] = new String[4];
	String indian_4_indices_dateTime[] = new String[4];
	String indian_4_indices_values[] = new String[4];
	String indian_4_indices_percentages[] = new String[4];

	String global_4_indices_names[] = new String[4];
	String global_4_indices_dateTime[] = new String[4];
	String global_4_indices_values[] = new String[4];
	String global_4_indices_percentages[] = new String[4];

	@And("^User gets indices values$")
	public void user_gets_indices_values() {
		for (int i = 0; i < 4; i++) {
			indian_4_indices_names[i] = GlobalUtil.getMDriver()
					.findElement(By
							.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.LinearLayout/android.view.ViewGroup[@index='"
									+ i + "']/android.widget.RelativeLayout/android.widget.TextView [@index='0']"))
					.getText();
			// android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='1']/android.widget.LinearLayout/android.view.ViewGroup[@index='0']/android.widget.RelativeLayout/android.widget.TextView[@index='0']
			System.out.println("indian index name is " + indian_4_indices_names[i]);
			KeywordUtil.delay(2000);
			indian_4_indices_dateTime[i] = GlobalUtil.getMDriver()
					.findElement(By
							.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.LinearLayout/android.view.ViewGroup[@index='"
									+ i + "']/android.widget.RelativeLayout/android.widget.TextView [@index='2']"))
					.getText();
			System.out.println("indian index dateTime is " + indian_4_indices_dateTime[i]);
			KeywordUtil.delay(2000);
			indian_4_indices_values[i] = GlobalUtil.getMDriver()
					.findElement(By
							.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.LinearLayout/android.view.ViewGroup[@index='"
									+ i + "']/android.widget.LinearLayout[@index='2']/android.widget.TextView"))
					.getText();
			System.out.println("indian index value is " + indian_4_indices_values[i]);
			KeywordUtil.delay(2000);
			indian_4_indices_percentages[i] = GlobalUtil.getMDriver().findElement(By
					.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.LinearLayout/android.view.ViewGroup[@index='"
							+ i + "']/android.widget.LinearLayout[@index='3']/android.widget.TextView[@index='1']"))
					.getText();
			System.out.println("indian index percentage is " + indian_4_indices_percentages[i]);
			KeywordUtil.delay(2000);
			System.out.println();
		}

		Dimension dim = GlobalUtil.getMDriver().manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int y = (int) (height * 0.70);
		int startx = (int) (width * 0.80);
		int endx = (int) (width * 0.30);
		mobileSwipeTouchAction(startx, y, endx, y, 1000);

		KeywordUtil.delay(2000);
		for (int i = 0; i < 4; i++) {
			global_4_indices_names[i] = GlobalUtil.getMDriver()
					.findElement(By
							.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='1']/android.widget.LinearLayout/android.view.ViewGroup[@index='"
									+ i + "']/android.widget.RelativeLayout/android.widget.TextView [@index='0']"))
					.getText();
			System.out.println("global index name is " + global_4_indices_names[i]);
			KeywordUtil.delay(2000);
			global_4_indices_dateTime[i] = GlobalUtil.getMDriver()
					.findElement(By
							.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='1']/android.widget.LinearLayout/android.view.ViewGroup[@index='"
									+ i + "']/android.widget.RelativeLayout/android.widget.TextView [@index='2']"))
					.getText();
			System.out.println("global index dateTime is " + global_4_indices_dateTime[i]);
			KeywordUtil.delay(2000);
			global_4_indices_values[i] = GlobalUtil.getMDriver()
					.findElement(By
							.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='1']/android.widget.LinearLayout/android.view.ViewGroup[@index='"
									+ i + "']/android.widget.LinearLayout[@index='2']/android.widget.TextView"))
					.getText();
			System.out.println("global index value is " + global_4_indices_values[i]);
			KeywordUtil.delay(2000);
			global_4_indices_percentages[i] = GlobalUtil.getMDriver().findElement(By
					.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='1']/android.widget.LinearLayout/android.view.ViewGroup[@index='"
							+ i + "']/android.widget.LinearLayout[@index='3']/android.widget.TextView[@index='1']"))
					.getText();
			System.out.println("global index percentage is " + global_4_indices_percentages[i]);
			KeywordUtil.delay(2000);
			System.out.println();
		}

	}

	@AndroidFindBy(xpath = "//*[@class='android.widget.TextView'][@text='Ca']")
	private WebElement test;

	@And("^User gets indices values for New App$")
	public void user_gets_indices_values_new_app() {
		System.out.println("start");
		System.out.println();
		KeywordUtil.delay(3000);

		/*
		 * System.out.println(GlobalUtil.getMDriver().findElement(By..xpath(
		 * "//android.widget.TextView[@content-desc='Indian_Indices_0'][@resource-id='com.divum.MoneyControl.debug:id/tv_share_name']"
		 * )).getText());
		 * System.out.println(GlobalUtil.getMDriver().findElement(By.xpath(
		 * "//android.widget.TextView[@content-desc='Indian_Indices_1'][@resource-id='com.divum.MoneyControl.debug:id/tv_share_name']"
		 * )).getText());
		 * System.out.println(GlobalUtil.getMDriver().findElement(By.xpath(
		 * "//android.widget.TextView[@content-desc='Indian_Indices_2'][@resource-id='com.divum.MoneyControl.debug:id/tv_share_name']"
		 * )).getText());
		 * System.out.println(GlobalUtil.getMDriver().findElement(By.xpath(
		 * "//android.widget.TextView[@content-desc='Indian_Indices_3'][@resource-id='com.divum.MoneyControl.debug:id/tv_share_name']"
		 * )).getText());
		 */

		List<MobileElement> list = GlobalUtil.getMDriver()
				.findElementsByXPath("//android.widget.TextView[@content-desc='Indian_Indices_0']");

		// .findElementsByAndroidUIAutomator("new
		// UiSelector().resourceId(\"com.divum.MoneyControl.debug:id/tv_share_name\")");

		System.out.println(list.size());
		for (int i = 0; i < 4; i++) {
			System.out.println(list.get(i).getText());
		}

		/*
		 * for(int i=0;i<4;i++) {
		 * indian_4_indices_names[i]=GlobalUtil.getMDriver().findElement(By.
		 * xpath(
		 * "//android.widget.TextView[@resource-id='com.divum.MoneyControl.debug:id/tv_share_name'][@content-desc='Indian_Indices_"
		 * +i+"']")).getText();
		 * System.out.println("indian index name is "+indian_4_indices_names[i])
		 * ; KeywordUtil.delay(500);
		 * indian_4_indices_dateTime[i]=GlobalUtil.getMDriver().findElement(By.
		 * xpath(
		 * "//android.widget.TextView[@resource-id='com.divum.MoneyControl.debug:id/tv_indeces_date'][@content-desc='Indian_Indices_"
		 * +i+"']")).getText(); System.out.println("indian index dateTime is "
		 * +indian_4_indices_dateTime[i]); KeywordUtil.delay(500);
		 * indian_4_indices_values[i]=GlobalUtil.getMDriver().findElement(By.
		 * xpath(
		 * "//android.widget.TextView[@resource-id='com.divum.MoneyControl.debug:id/tv_amount'][@content-desc='Indian_Indices_"
		 * +i+"']")).getText();
		 * System.out.println("indian index value is "+indian_4_indices_values[i
		 * ]); KeywordUtil.delay(500);
		 * indian_4_indices_percentages[i]=GlobalUtil.getMDriver().findElement(
		 * By.xpath(
		 * "//android.widget.TextView[@resource-id='com.divum.MoneyControl.debug:id/tv_change_pcntg'][@content-desc='Indian_Indices_"
		 * +i+"']")).getText(); System.out.println("indian index percentage is "
		 * +indian_4_indices_percentages[i]); KeywordUtil.delay(500);
		 * System.out.println(); }
		 */

		/*
		 * for(int i=0;i<4;i++) {
		 * indian_4_indices_names[i]=GlobalUtil.getMDriver().findElement(By.
		 * xpath(
		 * "//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.LinearLayout/android.view.ViewGroup[@index='"
		 * +i+"'][@resource-id='com.divum.MoneyControl.debug:id/data_"+(i+1)
		 * +"']/android.widget.RelativeLayout/android.widget.TextView [@index='0']@content-desc,'Indian_Indices_"
		 * +i+"']")).getText();
		 * //android.support.v7.widget.RecyclerView/android.view.ViewGroup[@
		 * index='1']/android.widget.LinearLayout/android.view.ViewGroup[@index=
		 * '0']/android.widget.RelativeLayout/android.widget.TextView[@index='0'
		 * ]
		 * System.out.println("indian index name is "+indian_4_indices_names[i])
		 * ; //KeywordUtil.delay(2000);
		 * indian_4_indices_dateTime[i]=GlobalUtil.getMDriver().findElement(By.
		 * xpath(
		 * "//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.LinearLayout/android.view.ViewGroup[@index='"
		 * +i+"'][@resource-id='com.divum.MoneyControl.debug:id/data_"+(i+1)
		 * +"']/android.widget.RelativeLayout/android.widget.TextView [@index='2'][@content-desc,'Indian_Indices_"
		 * +i+"']")).getText(); System.out.println("indian index dateTime is "
		 * +indian_4_indices_dateTime[i]); //KeywordUtil.delay(2000);
		 * indian_4_indices_values[i]=GlobalUtil.getMDriver().findElement(By.
		 * xpath(
		 * "//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.LinearLayout/android.view.ViewGroup[@index='"
		 * +i+"'][@resource-id='com.divum.MoneyControl.debug:id/data_"+(i+1)+
		 * "']/android.widget.LinearLayout[@index='2']/android.widget.TextView[@content-desc,'Indian_Indices_"
		 * +i+"']")).getText();
		 * System.out.println("indian index value is "+indian_4_indices_values[i
		 * ]); //KeywordUtil.delay(2000);
		 * indian_4_indices_percentages[i]=GlobalUtil.getMDriver().findElement(
		 * By.xpath(
		 * "//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.LinearLayout/android.view.ViewGroup[@index='"
		 * +i+"'][@resource-id='com.divum.MoneyControl.debug:id/data_"+(i+1)+
		 * "']/android.widget.LinearLayout[@index='3']/android.widget.TextView[@index='1'][@content-desc,'Indian_Indices_"
		 * +i+"']")).getText(); System.out.println("indian index percentage is "
		 * +indian_4_indices_percentages[i]); //KeywordUtil.delay(2000);
		 * System.out.println(); }
		 * 
		 * Dimension dim = GlobalUtil.getMDriver().manage().window().getSize();
		 * int height = dim.getHeight(); int width = dim.getWidth(); int y =
		 * (int) (height * 0.70); int startx = (int) (width * 0.80); int endx =
		 * (int) (width * 0.30); GlobalUtil.getMDriver().swipe(startx, y, endx,
		 * y, 1000);
		 * 
		 * KeywordUtil.delay(2000); for(int i=0;i<4;i++) {
		 * global_4_indices_names[i]=GlobalUtil.getMDriver().findElement(By.
		 * xpath(
		 * "//*[@resource-id='com.divum.MoneyControl.debug:id/rv_linear_tray']/android.view.ViewGroup[@index='1']//*[@resource-id='com.divum.MoneyControl.debug:id/data_"
		 * +(i+1)+"']//*[@content-desc,'Global_Indices_"+i+"']")).getText();
		 * System.out.println("global index name is "+global_4_indices_names[i])
		 * ; //KeywordUtil.delay(2000);
		 * global_4_indices_dateTime[i]=GlobalUtil.getMDriver().findElement(By.
		 * xpath(
		 * "//*[@resource-id='com.divum.MoneyControl.debug:id/rv_linear_tray']/android.view.ViewGroup[@index='1']//*[@resource-id='com.divum.MoneyControl.debug:id/data_"
		 * +(i+1)+"']//*[@content-desc,'Global_Indices_"+i+"']")).getText();
		 * System.out.println("global index dateTime is "
		 * +global_4_indices_dateTime[i]); //KeywordUtil.delay(2000);
		 * global_4_indices_values[i]=GlobalUtil.getMDriver().findElement(By.
		 * xpath(
		 * "//*[@resource-id='com.divum.MoneyControl.debug:id/rv_linear_tray']/android.view.ViewGroup[@index='1']//*[@resource-id='com.divum.MoneyControl.debug:id/data_"
		 * +(i+1)+"']//*[@content-desc,'Global_Indices_"+i+"']")).getText();
		 * System.out.println("global index value is "+global_4_indices_values[i
		 * ]); //KeywordUtil.delay(2000);
		 * global_4_indices_percentages[i]=GlobalUtil.getMDriver().findElement(
		 * By.xpath(
		 * "//*[@resource-id='com.divum.MoneyControl.debug:id/rv_linear_tray']/android.view.ViewGroup[@index='1']//*[@resource-id='com.divum.MoneyControl.debug:id/data_"
		 * +(i+1)+"']//*[@content-desc,'Global_Indices_"+i+"']")).getText();
		 * System.out.println("global index percentage is "
		 * +global_4_indices_percentages[i]); //KeywordUtil.delay(2000);
		 * System.out.println(); }
		 */

		/*
		 * for(int i=0;i<4;i++) {
		 * indian_4_indices_names[i]=GlobalUtil.getMDriver().findElement(By.
		 * xpath(
		 * "//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.LinearLayout/android.view.ViewGroup[@index='"
		 * +i+"'][@resource-id='com.divum.MoneyControl.debug:id/data_"+(i+1)
		 * +"']/android.widget.RelativeLayout/android.widget.TextView [@index='0'][@resource-id='com.divum.MoneyControl.debug:id/tv_share_name'][@content-desc='Indian_Indices_"
		 * +i+"']")).getText();
		 * //android.support.v7.widget.RecyclerView/android.view.ViewGroup[@
		 * index='1']/android.widget.LinearLayout/android.view.ViewGroup[@index=
		 * '0']/android.widget.RelativeLayout/android.widget.TextView[@index='0'
		 * ]
		 * System.out.println("indian index name is "+indian_4_indices_names[i])
		 * ; //KeywordUtil.delay(2000);
		 * indian_4_indices_dateTime[i]=GlobalUtil.getMDriver().findElement(By.
		 * xpath(
		 * "//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.LinearLayout/android.view.ViewGroup[@index='"
		 * +i+"'][@resource-id='com.divum.MoneyControl.debug:id/data_"+(i+1)
		 * +"']/android.widget.RelativeLayout/android.widget.TextView [@index='2'][@resource-id='com.divum.MoneyControl.debug:id/tv_indeces_date'][@content-desc='Indian_Indices_"
		 * +i+"']")).getText(); System.out.println("indian index dateTime is "
		 * +indian_4_indices_dateTime[i]); //KeywordUtil.delay(2000);
		 * indian_4_indices_values[i]=GlobalUtil.getMDriver().findElement(By.
		 * xpath(
		 * "//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.LinearLayout/android.view.ViewGroup[@index='"
		 * +i+"'][@resource-id='com.divum.MoneyControl.debug:id/data_"+(i+1)+
		 * "']/android.widget.LinearLayout[@index='2']/android.widget.TextView[@resource-id='com.divum.MoneyControl.debug:id/tv_amount'][@content-desc='Indian_Indices_"
		 * +i+"']")).getText();
		 * System.out.println("indian index value is "+indian_4_indices_values[i
		 * ]); //KeywordUtil.delay(2000);
		 * indian_4_indices_percentages[i]=GlobalUtil.getMDriver().findElement(
		 * By.xpath(
		 * "//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.LinearLayout/android.view.ViewGroup[@index='"
		 * +i+"'][@resource-id='com.divum.MoneyControl.debug:id/data_"+(i+1)+
		 * "']/android.widget.LinearLayout[@index='3']/android.widget.TextView[@index='1'][@resource-id='com.divum.MoneyControl.debug:id/tv_change_pcntg'][@content-desc='Indian_Indices_"
		 * +i+"']")).getText(); System.out.println("indian index percentage is "
		 * +indian_4_indices_percentages[i]); //KeywordUtil.delay(2000);
		 * System.out.println(); }
		 * 
		 * Dimension dim = GlobalUtil.getMDriver().manage().window().getSize();
		 * int height = dim.getHeight(); int width = dim.getWidth(); int y =
		 * (int) (height * 0.70); int startx = (int) (width * 0.80); int endx =
		 * (int) (width * 0.30); GlobalUtil.getMDriver().swipe(startx, y, endx,
		 * y, 1000);
		 * 
		 * KeywordUtil.delay(2000); for(int i=0;i<4;i++) {
		 * global_4_indices_names[i]=GlobalUtil.getMDriver().findElement(By.
		 * xpath(
		 * "//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='1']/android.widget.LinearLayout/android.view.ViewGroup[@index='"
		 * +i+"'][@resource-id='com.divum.MoneyControl.debug:id/data_"+(i+1)
		 * +"']/android.widget.RelativeLayout/android.widget.TextView [@index='0'][@resource-id='com.divum.MoneyControl.debug:id/tv_share_name'][@content-desc='Global_Indices_"
		 * +i+"']")).getText();
		 * System.out.println("global index name is "+global_4_indices_names[i])
		 * ; //KeywordUtil.delay(2000);
		 * global_4_indices_dateTime[i]=GlobalUtil.getMDriver().findElement(By.
		 * xpath(
		 * "//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='1']/android.widget.LinearLayout/android.view.ViewGroup[@index='"
		 * +i+"'][@resource-id='com.divum.MoneyControl.debug:id/data_"+(i+1)
		 * +"']/android.widget.RelativeLayout/android.widget.TextView [@index='0'][@resource-id='com.divum.MoneyControl.debug:id/tv_indeces_date'][@content-desc='Global_Indices_"
		 * +i+"']")).getText(); System.out.println("global index dateTime is "
		 * +global_4_indices_dateTime[i]); //KeywordUtil.delay(2000);
		 * global_4_indices_values[i]=GlobalUtil.getMDriver().findElement(By.
		 * xpath(
		 * "//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='1']/android.widget.LinearLayout/android.view.ViewGroup[@index='"
		 * +i+"'][@resource-id='com.divum.MoneyControl.debug:id/data_"+(i+1)
		 * +"']/android.widget.RelativeLayout/android.widget.TextView [@index='0'][@resource-id='com.divum.MoneyControl.debug:id/tv_amount'][@content-desc='Global_Indices_"
		 * +i+"']")).getText();
		 * System.out.println("global index value is "+global_4_indices_values[i
		 * ]); //KeywordUtil.delay(2000);
		 * global_4_indices_percentages[i]=GlobalUtil.getMDriver().findElement(
		 * By.xpath(
		 * "//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='1']/android.widget.LinearLayout/android.view.ViewGroup[@index='"
		 * +i+"'][@resource-id='com.divum.MoneyControl.debug:id/data_"+(i+1)
		 * +"']/android.widget.RelativeLayout/android.widget.TextView [@index='0'][@resource-id='com.divum.MoneyControl.debug:id/tv_change_pcntg'][@content-desc='Global_Indices_"
		 * +i+"']")).getText(); System.out.println("global index percentage is "
		 * +global_4_indices_percentages[i]); //KeywordUtil.delay(2000);
		 * System.out.println(); }
		 */

	}

	@And("^User switches to Investing app$")
	public void user_switches_to_investing_app() {
		pressKeyAndroid(AndroidKey.HOME);
		open_investing_app();
		KeywordUtil.delay(3000);
	}

	String indian_index_value_IA[] = new String[4];
	String indian_index_percentage_IA[] = new String[4];
	String global_index_value_IA[] = new String[4];
	String global_index_percentage_IA[] = new String[4];

	String indian_4_indices_names1[] = { "NIFTY Smallcap 100", "S&P BSE SENSEX", "NIFTY  50", "NIFTY Midcap 100" };
	String global_4_indices_names1[] = { "SGX Nifty", "KOSPI", "Shanghai Composite", "Straits Times" };

	@And("^User verifies the indices values and percentages in Investing app$")
	public void user_verifies_indices_in_Investingapp() {
		for (int i = 0; i < 4; i++) {
			click(search_in_Investing_app, type_xpath);
			KeywordUtil.inputText(By.xpath(enter_index_in_Investing_app), indian_4_indices_names1[i],
					"user entered index name");
			KeywordUtil.delay(5000);
			click("//android.widget.ListView/android.widget.RelativeLayout[@index='0']", type_xpath);
			indian_index_value_IA[i] = KeywordUtil.getElementText(By.xpath(get_index_value_in_Investing_app));
			System.out.println(indian_index_value_IA[i]);
			indian_index_percentage_IA[i] = KeywordUtil.getElementText(By.xpath(get_index_percentage_in_Investing_app));
			System.out.println(indian_index_percentage_IA[i]);
			GlobalUtil.getMDriver().navigate().back();
			KeywordUtil.delay(1000);
			click(back_in_Investing_app, type_xpath);
		}

		for (int i = 0; i < 4; i++) {
			click(search_in_Investing_app, type_xpath);
			KeywordUtil.inputText(By.xpath(enter_index_in_Investing_app), global_4_indices_names1[i],
					"user entered index name");
			KeywordUtil.delay(5000);
			click("//android.widget.ListView/android.widget.RelativeLayout[@index='0']", type_xpath);
			global_index_value_IA[i] = KeywordUtil.getElementText(By.xpath(get_index_value_in_Investing_app));
			System.out.println(global_index_value_IA[i]);
			global_index_percentage_IA[i] = KeywordUtil.getElementText(By.xpath(get_index_percentage_in_Investing_app));
			System.out.println(global_index_percentage_IA[i]);
			GlobalUtil.getMDriver().navigate().back();
			KeywordUtil.delay(1000);
			click(back_in_Investing_app, type_xpath);
		}

	}

	String All_Indices_value_IA[];
	String All_Indices_percentage_IA[];

	@And("^User checks all the indices values of \"(.*)\" in Investing app$")
	public void user_checks_all_indices_values_in_InvestingApp(String stockname) {
		dataMap = ExcelDataUtil.getTestDataWithTestCaseID("AllIndicesData", stockname);
		String[] all_Indices = dataMap.get("AllIndices").split("\n");
		All_Indices_value_IA = new String[all_Indices.length];
		All_Indices_percentage_IA = new String[all_Indices.length];

		for (int i = 0; i < all_Indices.length; i++) {
			System.out.println(all_Indices[i]);
			click(search_in_Investing_app, type_xpath);
			KeywordUtil.inputText(By.xpath(enter_index_in_Investing_app), all_Indices[i], "user entered index name");
			KeywordUtil.delay(5000);
			if (MobileKeywords.isWebElementPresent(
					"//android.widget.ListView/android.widget.RelativeLayout[@index='0']", type_xpath)) {
				click("//android.widget.ListView/android.widget.RelativeLayout[@index='0']", type_xpath);
				WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), 20);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(get_index_value_in_Investing_app)));
				All_Indices_value_IA[i] = KeywordUtil.getElementText(By.xpath(get_index_value_in_Investing_app));
				if (All_Indices_value_IA[i].contains(",")) {
					All_Indices_value_IA[i] = All_Indices_value_IA[i].replaceAll(",", "");
				}
				System.out.println(All_Indices_value_IA[i]);
				KeywordUtil.delay(1500);
				All_Indices_percentage_IA[i] = KeywordUtil
						.getElementText(By.xpath(get_index_percentage_in_Investing_app));
				System.out.println(All_Indices_percentage_IA[i]);
				if (All_Indices_percentage_IA[i].contains(" ")) {
					All_Indices_percentage_IA[i] = All_Indices_percentage_IA[i].split(" ")[1];
					All_Indices_percentage_IA[i] = All_Indices_percentage_IA[i].substring(2,
							All_Indices_percentage_IA[i].length() - 2);
				}
				System.out.println(All_Indices_percentage_IA[i]);
				GlobalUtil.getMDriver().navigate().back();
				KeywordUtil.delay(1000);
				click(back_in_Investing_app, type_xpath);
			} else {
				KeywordUtil.takeMobileScreenshot(
						System.getProperty("user.dir") + "\\" + "ActiveByValueScreenShots\\Sample" + i + ".png");
				GlobalUtil.getMDriver().navigate().back();
				KeywordUtil.delay(1000);
				System.out.println("1");
				GlobalUtil.getMDriver().navigate().back();
				KeywordUtil.delay(1000);
				System.out.println("2");
			}
		}
	}

	@And("^User clicks on IndianIndices$")
	public void user_clicks_in_IndianIndices() {
		click_on_IndianIndices();
	}

	String all_indices_names[];
	String all_indices_dateTime[];
	String all_indices_values[];

	ArrayList<String> namesList = new ArrayList<String>();
	ArrayList<String> dateTimeList = new ArrayList<String>();
	ArrayList<String> valuesList = new ArrayList<String>();

	@And("^User gets all indices details$")
	public void user_gets_all_indices_details() {

		for (int k = 0; k < 5; k++) {
			List<MobileElement> all_indices_list = GlobalUtil.getMDriver().findElements(By
					.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout"));
			System.out.println("all indices list size is " + all_indices_list.size());

			all_indices_names = new String[all_indices_list.size() - 1];
			all_indices_dateTime = new String[all_indices_list.size() - 1];
			all_indices_values = new String[all_indices_list.size() - 1];

			for (int i = 0; i < all_indices_list.size() - 1; i++) {
				if (MobileKeywords.isWebElementPresent(
						"//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout[@index='"
								+ (i + 1)
								+ "']/android.widget.LinearLayout/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='0']",
						type_xpath)) {
					all_indices_names[i] = GlobalUtil.getMDriver()
							.findElement(By
									.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout[@index='"
											+ (i + 1)
											+ "']/android.widget.LinearLayout/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='0']"))
							.getText();
					System.out.println("name is " + all_indices_names[i]);
					namesList.add(all_indices_names[i]);
				}
				KeywordUtil.delay(1000);

				if (MobileKeywords.isWebElementPresent(
						"//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout[@index='"
								+ (i + 1)
								+ "']/android.widget.LinearLayout/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='1']",
						type_xpath)) {
					all_indices_dateTime[i] = GlobalUtil.getMDriver()
							.findElement(By
									.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout[@index='"
											+ (i + 1)
											+ "']/android.widget.LinearLayout/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='1']"))
							.getText();
					System.out.println("date is " + all_indices_dateTime[i]);
					dateTimeList.add(all_indices_dateTime[i]);
				}
				KeywordUtil.delay(1000);
				if (MobileKeywords.isWebElementPresent(
						"//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout[@index='"
								+ (i + 1)
								+ "']/android.widget.LinearLayout/android.widget.LinearLayout//android.widget.TextView",
						type_xpath)) {
					all_indices_values[i] = GlobalUtil.getMDriver()
							.findElement(By
									.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout[@index='"
											+ (i + 1)
											+ "']/android.widget.LinearLayout/android.widget.LinearLayout//android.widget.TextView"))
							.getText();
					System.out.println("value is " + all_indices_values[i]);
					valuesList.add(all_indices_values[i]);
				}
				System.out.println();
			}
			System.out.println("individual getting is completed");
			System.out.println();
			swipeVerticalBottom1();
			KeywordUtil.delay(3000);
		}

		System.out.println("total names are " + namesList.size());
		for (String name : namesList) {
			System.out.println(name);
		}
		System.out.println();
		System.out.println();

		System.out.println("total names are " + dateTimeList.size());
		for (String name : dateTimeList) {
			System.out.println(name);
		}
		System.out.println();
		System.out.println();

		System.out.println("total names are " + valuesList.size());
		for (String name : valuesList) {
			System.out.println(name);
		}

	}

	String NSE_indices_names[];
	ArrayList<String> namesList_NSE = new ArrayList<String>();

	@And("^User gets indices list in NSE tab$")
	public void user_gets_indices_list_in_NSE_tab() {
		KeywordUtil.delay(2000);
		click(NSE_tab_in_Allindices, type_xpath);
		System.out.println("NSE clicked");
		for (int k = 0; k < 3; k++) {
			List<MobileElement> all_indices_list = GlobalUtil.getMDriver().findElements(By
					.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout"));
			System.out.println("NSE all indices list size is " + all_indices_list.size());

			NSE_indices_names = new String[all_indices_list.size() - 1];

			for (int i = 0; i < all_indices_list.size() - 1; i++) {
				if (MobileKeywords.isWebElementPresent(
						"//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout[@index='"
								+ (i + 1)
								+ "']/android.widget.LinearLayout/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='0']",
						type_xpath)) {
					NSE_indices_names[i] = GlobalUtil.getMDriver()
							.findElement(By
									.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout[@index='"
											+ (i + 1)
											+ "']/android.widget.LinearLayout/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='0']"))
							.getText();
					System.out.println("name is " + NSE_indices_names[i]);
					namesList_NSE.add(NSE_indices_names[i]);
				}
				KeywordUtil.delay(1000);
				System.out.println();
			}
			System.out.println("individual getting is completed");
			System.out.println();
			swipeVerticalBottom1();
			KeywordUtil.delay(3000);
		}

		System.out.println("total NSE names are " + namesList_NSE.size());
		for (String name : namesList_NSE) {
			System.out.println(name);
		}
		System.out.println();

	}

	String BSE_indices_names[];
	ArrayList<String> namesList_BSE = new ArrayList<String>();

	@And("^User gets indices list in BSE tab$")
	public void user_gets_indices_list_in_BSE_tab() {
		KeywordUtil.delay(2000);
		click(BSE_tab_in_Allindices, type_xpath);
		System.out.println("BSE clicked");
		for (int k = 0; k < 2; k++) {
			List<MobileElement> all_indices_list = GlobalUtil.getMDriver().findElements(By
					.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout"));
			System.out.println("BSE all indices list size is " + all_indices_list.size());

			BSE_indices_names = new String[all_indices_list.size() - 1];

			for (int i = 0; i < all_indices_list.size() - 1; i++) {
				if (MobileKeywords.isWebElementPresent(
						"//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout[@index='"
								+ (i + 1)
								+ "']/android.widget.LinearLayout/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='0']",
						type_xpath)) {
					BSE_indices_names[i] = GlobalUtil.getMDriver()
							.findElement(By
									.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout[@index='"
											+ (i + 1)
											+ "']/android.widget.LinearLayout/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='0']"))
							.getText();
					System.out.println("name is " + BSE_indices_names[i]);
					namesList_BSE.add(BSE_indices_names[i]);
				}
				KeywordUtil.delay(1000);
				System.out.println();
			}
			System.out.println("individual getting is completed");
			System.out.println();
			swipeVerticalBottom1();
			KeywordUtil.delay(3000);
		}

		System.out.println("total BSE names are " + namesList_BSE.size());
		for (String name : namesList_BSE) {
			System.out.println(name);
		}
		System.out.println();

	}

	@Then("^User should see \"([^\"]*)\" in watchlist section$")
	public void user_should_see_in_watchlist(String watchLists) throws InterruptedException {
		String[] watchListItems = watchLists.split(":");

		for (int i = 1; i <= 4; i++)
			try {
				GlobalUtil.getMDriver().findElementByXPath(Watchlist).getText();
				break;
			} catch (Exception e) {
				swipeVerticalBottom();

			}

		for (int j = 0; j < watchListItems.length; j++)
			if (GlobalUtil.getMDriver()
					.findElement(By.xpath("//*[@text='" + "+ " + watchListItems[j].toUpperCase() + "']")).isDisplayed())
				RunCukesTest.logger.log(LogStatus.PASS, "<font color='blue'>+ " + watchListItems[j].toUpperCase()
						+ "</font> display validation in Watchlist Section - Successful.");
			else
				RunCukesTest.logger.log(LogStatus.FAIL, "<font color='red'>+ " + watchListItems[j].toUpperCase()
						+ "</font> display validation in Watchlist Section - FAILED.");
	}

	@Then("^User should see Create a new portfolio and Signin button$")
	public void verifyMyPortfolioInHomePage() throws InterruptedException {

		for (int i = 1; i <= 9; i++)
			try {
				GlobalUtil.getMDriver().findElementByXPath(Myportfolio).getText();
				break;
			} catch (Exception e) {
				swipeVerticalBottom();

			}
		swipeVerticalBottom();
		WebElement portfolio = GlobalUtil.getMDriver().findElementByXPath(Create_newportfolio);

		if (portfolio.isDisplayed()) {

			RunCukesTest.logger.log(LogStatus.PASS, "<font color='blue'>+ " + portfolio.getText()
					+ "</font> display validation in Create new portfolio button in  Portfolio Section - Successful.");

		} else {
			RunCukesTest.logger.log(LogStatus.FAIL, "<font color='blue'>+ " + portfolio.getText()
					+ "</font> display validation in Create new portfolio button in  Portfolio Section - Fail.");
		}

		WebElement Signin_bt = GlobalUtil.getMDriver().findElementByXPath(Signin_btn);

		if (GlobalUtil.getMDriver().findElementByXPath(Signin_btn).isDisplayed())

			RunCukesTest.logger.log(LogStatus.PASS, "<font color='blue'>+ " + Signin_bt.getText()
					+ "</font> display validation in Signin button Portfolio Section - Successful.");

		else
			RunCukesTest.logger.log(LogStatus.FAIL, "<font color='blue'>+ " + Signin_bt.getText()
					+ "</font> display validation in Create new portfolio button in  Portfolio Section - Fail.");

	}

	@Then("^User Navigate to homepage and Refresh the page$")
	public void navigatetoHomepageAndRefreshThePage() {
		KeywordUtil.delay(2000);
		clickBackBtn();
		KeywordUtil.delay(2000);
		clickBackBtn();
		KeywordUtil.delay(2000);
		clickBackBtn();
		KeywordUtil.delay(2000);
		// GlobalUtil.getMDriver().navigate().refresh();
		// MobileKeywords.pageRefresh();
	}

	@Then("^User verifies Stocks Last Visited Section$")
	public void verifiesStocksLastVisitedSection() {
		for (int i = 1; i <= 9; i++)
			try {
				GlobalUtil.getMDriver().findElementByXPath(Stocklast_visited).getText();
				break;
			} catch (Exception e) {
				swipeVerticalBottom();
			}
		WebElement Stockname = GlobalUtil.getMDriver().findElementByXPath(stockname);
		if (Stockname.isDisplayed()) {
			RunCukesTest.logger.log(LogStatus.PASS,
					HTMLReportUtil.passStringGreenColor("<font color='blue'>+ " + Stockname.getText()
							+ "</font> display validation in Stocks in Stocks validation Section - Successful."));
			System.out.println(Stockname.getText() + " is displayed in Stocks Last Visited section");
		} else {
			RunCukesTest.logger.log(LogStatus.FAIL,
					HTMLReportUtil.passStringGreenColor("<font color='blue'>+ " + Stockname.getText()
							+ "</font> display validation in Stocks in Stocks validation Section - Fail."));
			System.out.println(Stockname.getText() + " is not displayed in Stocks Last Visited section");
		}
	}

	@Then("^User verifies the Stocks last visited with \"([^\"]*)\"$")
	public void user_verifies_stocks_last_visited_two_more_stocks(String stockname) {
		dataMap = ExcelDataUtil.getTestDataWithTestCaseID("MoneyControl", stockname);
		String[] stocksLastVisited = dataMap.get("StocksLastVisited").split("\n");
		for (int i = 0; i < stocksLastVisited.length; i++) {
			user_click_on_searchbutton();
			enterMcStock(stocksLastVisited[i]);
			navigatetoHomepageAndRefreshThePage();
			verifiesStocksLastVisitedSection();
		}
	}

	//public static WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), 10);

	public static void clickMenuTab() {
		try {
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(menubutton)));
			// explicitWaitForElementforGivenTime(menubutton, type_xpath, 10);
			KeywordUtil.delay(2000);
			click(menubutton, type_xpath);

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	public static void clickProfileIcon() {
		try {
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(portfolio_profile)));
			explicitWaitForElementforGivenTime(portfolio_profile, type_xpath, 10);
			click(portfolio_profile, type_xpath);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void click_News_Tab() {
		try {

			explicitWaitForElementforGivenTime(portfolio_profile, type_xpath, 5);
			// explicitWaitForElementforGivenTime(newsbutton1, type_xpath, 10);
			click(newsbutton1, type_xpath);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	public static void click_Opinion_Tab() {
		try {
			explicitWaitForElementforGivenTime(Opinion_tab, type_xpath, 5);
			click(Opinion_tab, type_xpath);
			System.out.println("1");
			KeywordUtil.delay(4000);
			String text = GlobalUtil.getMDriver()
					.findElement(By
							.xpath("//android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.TextView[@instance='2']"))
					.getText();
			System.out.println("text is : " + text);
			if ((text.contains("Opinion")) != true) {
				if (MobileKeywords.isWebElementPresent(Opinion_tab, type_xpath)) {
					click(Opinion_tab, type_xpath);
					System.out.println("2");
				}
			}
			if (MobileKeywords.isWebElementPresent(Opinion_tab, type_xpath)) {
				click(Opinion_tab, type_xpath);
				System.out.println("2");
			}
			KeywordUtil.delay(4000);
			/*
			 * KeywordUtil.delay(1000);
			 * if((GlobalUtil.getMDriver().findElement(By.xpath(Opinion_tab)).
			 * isDisplayed())!=true) { clickMenuTab(); clickmyportfolio();
			 * click_News_Tab(); KeywordUtil.delay(1000); click(Opinion_tab,
			 * type_xpath); System.out.println("3"); }
			 */
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void clickmyportfolio() {
		try {

			explicitWaitForElementforGivenTime(myportfoliobutton, type_xpath, 10);
			click(myportfoliobutton, type_xpath);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	public static void clickloginwithfacebook() {
		try {
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(portfolio_profile)));
			explicitWaitForElementforGivenTime(loginwithfacebook, type_xpath, 10);
			click(loginwithfacebook, type_xpath);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void enteremaillogindetails() {
		try {
			explicitWaitForElementforGivenTime(emailoruserid, type_xpath, 10);
			GlobalUtil.getMDriver().findElement(By.xpath(emailoruserid)).sendKeys("");
			explicitWaitForElementforGivenTime(emailpassword, type_xpath, 10);
			GlobalUtil.getMDriver().findElement(By.xpath(emailpassword)).sendKeys("");
			KeywordUtil.delay(5000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	public static void clickemaillogin() {
		try {
			explicitWaitForElementforGivenTime(emaillogin, type_xpath, 10);
			click(emaillogin, type_xpath);
			KeywordUtil.delay(5000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	public static void clickgooglelogin() {
		try {
			explicitWaitForElementforGivenTime(loginwithgoogle, type_xpath, 10);
			click(loginwithgoogle, type_xpath);
			KeywordUtil.delay(5000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	public static void clickmywatchlist() {
		try {
			// explicitWaitForElementforGivenTime(my_watchlist, type_xpath, 10);
			// KeywordUtil.delay(3000);
			click(my_watchlist, type_xpath);
			KeywordUtil.delay(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void click_addstocks_symbol_mywatchlist() {
		try {

			click(watchlist_addstocks_symbol, type_xpath);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void click_done_watchlist() {
		try {
			click(stock_added_done, type_xpath);

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void opinion_get_news() {
		try {
			if (MobileKeywords.isWebElementPresent(closeadd, type_xpath)) {
				GlobalUtil.getMDriver().findElement(By.xpath(closeadd)).click();
				KeywordUtil.delay(1000);
				mobileTap(576, 147);
			}
			List<MobileElement> news_list = GlobalUtil.getMDriver().findElements(
					By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.view.ViewGroup"));
			// System.out.println("news_list size is " + news_list.size());
			int num = 0;
			for (int i = 0; i < news_list.size(); i++) {
				try {
					num = i + 1;
					// System.out.println("11");
					if (MobileKeywords
							.isWebElementPresent(
									"//android.widget.ListView[@resource-id='android:id/list']/android.view.ViewGroup[@index='"
											+ num + "']//android.widget.LinearLayout/android.widget.ImageView",
									type_xpath)) {
						// System.out.println("12");
						String news_headline_text_before = GlobalUtil.getMDriver()
								.findElement(
										By.xpath("//*[@resource-id='android:id/list']/android.view.ViewGroup[@index='"
												+ num + "']//android.view.ViewGroup/android.widget.TextView"))
								.getText();
						System.out.println(
								"news_headline_text_before going into the news is   " + news_headline_text_before);
						System.out.println();
						GlobalUtil.getMDriver()
								.findElement(
										By.xpath("//*[@resource-id='android:id/list']/android.view.ViewGroup[@index='"
												+ num + "']//android.view.ViewGroup/android.widget.TextView"))
								.click();
						KeywordUtil.delay(5000);
						String news_headline_text_after = GlobalUtil.getMDriver()
								.findElement(By.xpath("//*[@resource-id='com.divum.MoneyControl:id/tvHeadLine']"))
								.getText();
						System.out.println(
								"news_headline_text_after going into the news is   " + news_headline_text_after);
						System.out.println();
						check_news_content();
						mobileSwipeTouchAction(500, 1600, 500, 1450, 1000);
						KeywordUtil.delay(2000);
						check_news_content();
						mobileSwipeTouchAction(500, 1600, 500, 1450, 1000);
						KeywordUtil.delay(2000);
						check_news_content();
						GlobalUtil.getMDriver()
								.findElement(By.xpath("//*[@resource-id='com.divum.MoneyControl:id/back_button']"))
								.click();
						KeywordUtil.delay(3000);
					}
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}

			}
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	public static void check_news_content() {
		try {
			if (MobileKeywords.isWebElementPresent("//*[@text='Get Unlimited Access. Go Pro']", type_xpath)) {
				System.out.println("User is able to see GoToPro message is verifed");
			} else {
				System.out.println("User is not able to see GoToPro message is verified");
			}
			if (MobileKeywords.isWebElementPresent(
					"//*[contains(@text,'To view the full content of this premium section')]", type_xpath)) {
				System.out.println("User is not able to see Pro content fully is verified");
			} else {
				System.out.println("User is able to see Pro content fully is verifed");
			}
			System.out.println();
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void pro_user_opinion_get_news() {

		List<MobileElement> news_list = GlobalUtil.getMDriver().findElements(
				By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.view.ViewGroup"));
		// System.out.println("news_list size is " + news_list.size());
		int num = 0;
		for (int i = 0; i < news_list.size(); i++) {
			try {
				num = i + 1;
				// System.out.println("11");
				if (MobileKeywords
						.isWebElementPresent(
								"//android.widget.ListView[@resource-id='android:id/list']/android.view.ViewGroup[@index='"
										+ num + "']//android.widget.LinearLayout/android.widget.ImageView",
								type_xpath)) {
					// System.out.println("12");
					String pro_opinion_news_headline_text_before = GlobalUtil.getMDriver()
							.findElement(By.xpath("//*[@resource-id='android:id/list']/android.view.ViewGroup[@index='"
									+ num + "']//android.view.ViewGroup/android.widget.TextView"))
							.getText();
					System.out.println("pro_opinion_news_headline_text_before going into the news is   "
							+ pro_opinion_news_headline_text_before);
					System.out.println();

					GlobalUtil.getMDriver()
							.findElement(By.xpath("//*[@resource-id='android:id/list']/android.view.ViewGroup[@index='"
									+ num + "']//android.view.ViewGroup/android.widget.TextView"))
							.click();
					KeywordUtil.delay(5000);
					String news_headline_text_after = GlobalUtil.getMDriver()
							.findElement(By.xpath("//*[@resource-id='com.divum.MoneyControl:id/tvHeadLine']"))
							.getText();
					System.out.println("news_headline_text_after going into the news is   " + news_headline_text_after);
					System.out.println();

					check_news_content();
					mobileSwipeTouchAction(500, 1600, 500, 1450, 1000);
					check_news_content();
					mobileSwipeTouchAction(500, 1600, 500, 1450, 1000);
					check_news_content();
					GlobalUtil.getMDriver()
							.findElement(By.xpath("//*[@resource-id='com.divum.MoneyControl:id/back_button']")).click();
					KeywordUtil.delay(3000);
				}

			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}

		}

	}

	public static void click_signup_button() {

		while (2 > 1) {
			try {
				Assert.assertEquals(GlobalUtil.getMDriver().findElement(By.xpath(emailsignup)).getText(), "Sign Up",
						"Sign Up link is visible");
				RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Sign Up link is visible"));
				GlobalUtil.getMDriver().findElement(By.xpath(emailsignup)).click();
				break;
			} catch (Exception e) {
				mobileSwipeTouchAction(600, 1300, 600, 1200, 1000);
				KeywordUtil.delay(3000);
			}
		}

	}

	public static void click_SignupwithEmail() {
		GlobalUtil.getMDriver().hideKeyboard();
		while (2 > 1) {
			try {

				Assert.assertEquals(GlobalUtil.getMDriver().findElement(By.xpath(signinwithemail)).getText(),
						"SIGN UP WITH EMAIL", "Sign Up with email link is visible");
				RunCukesTest.logger.log(LogStatus.PASS,
						HTMLReportUtil.passStringGreenColor("Sign Up with email link is visible"));
				GlobalUtil.getMDriver().findElement(By.xpath(signinwithemail)).click();
				break;
			} catch (Exception e) {
				mobileSwipeTouchAction(600, 1300, 600, 1200, 1000);
				KeywordUtil.delay(3000);
			}
		}
	}

	public static void enter_emaildetails(String emailpassword) {
		try {
			explicitWaitForElementforGivenTime(email_Firstname, type_xpath, 10);
			GlobalUtil.getMDriver().findElement(By.xpath(email_Firstname)).sendKeys("nadkvnda");
			GlobalUtil.getMDriver().findElement(By.xpath(email_Lastname)).sendKeys("aeihvnoe");
			// String emai="generateRandomEmail";
			GlobalUtil.getMDriver().findElement(By.xpath(email_sampleemail))
					.sendKeys(KeywordUtil.generateRandomEmail());
			GlobalUtil.getMDriver().findElement(By.xpath(email_password)).sendKeys(emailpassword);

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());

		}
	}

	public static void email_success_verification() {
		try {

			// explicitWaitForElementforGivenTime(email_verification_msg,
			// type_xpath, 10);
			KeywordUtil.delay(1175);
			Assert.assertEquals(GlobalUtil.getMDriver().findElement(By.xpath(email_verification_msg)).isDisplayed(),
					true);
		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	public static void click_OK() {
		if (KeywordUtil.isWebElementPresent(OK, type_xpath)) {
			GlobalUtil.getMDriver().findElement(By.xpath(OK)).click();
		}
		KeywordUtil.delay(1000);
		if (KeywordUtil.isWebElementPresent(OK1, type_xpath)) {
			GlobalUtil.getMDriver().findElement(By.xpath(OK1)).click();
		}
		KeywordUtil.delay(1000);
		if (KeywordUtil.isWebElementPresent(OK2, type_xpath)) {
			GlobalUtil.getMDriver().findElement(By.xpath(OK2)).click();
		}
	}

	public static void do_facebook_login(String facebookemail, String facebookpassword) {
		try {
			KeywordUtil.delay(3000);
			if (KeywordUtil.isWebElementPresent(facebookusername, type_xpath)) {
				Assert.assertEquals(GlobalUtil.getMDriver().findElement(By.xpath(facebook_text_display)).getText(),
						"facebook", "facebook login page is displayed");
				RunCukesTest.logger.log(LogStatus.PASS,
						HTMLReportUtil.passStringGreenColor("facebook login page is displayed"));
				KeywordUtil.delay(2000);
				GlobalUtil.getMDriver().findElement(By.xpath(facebookusername)).sendKeys(facebookemail);
				GlobalUtil.getMDriver().findElement(By.xpath(facebookpassword)).sendKeys(facebookpassword);
				GlobalUtil.getMDriver().findElement(By.xpath(facebookloginbutton)).click();
			}
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(facebookcontinue)));
			explicitWaitForElementforGivenTime(facebookcontinue, type_xpath, 20);
			GlobalUtil.getMDriver().findElement(By.xpath(facebookcontinue)).click();
			KeywordUtil.delay(4000);
			click_OK();
			KeywordUtil.delay(1000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());

		}

	}

	public static void do_google_login(String googleemail, String googlepassword) {
		KeywordUtil.delay(3000);
		try {

			explicitWaitForElementforGivenTime(googleemailorphone, type_xpath, 20);
			Assert.assertEquals(GlobalUtil.getMDriver().findElement(By.xpath(google_signin_text)).getText(), "Sign in",
					"Signin page is displayed");
			RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Signin page is displayed"));
			GlobalUtil.getMDriver().findElement(By.xpath(googleemailorphone)).sendKeys(googleemail);

			explicitWaitForElementforGivenTime(googleemailnext, type_xpath, 10);
			GlobalUtil.getMDriver().findElement(By.xpath(googleemailnext)).click();

			explicitWaitForElementforGivenTime(googlepassword, type_xpath, 20);
			GlobalUtil.getMDriver().findElement(By.xpath(googlepassword)).sendKeys(googlepassword);

			explicitWaitForElementforGivenTime(googlepasswordnext, type_xpath, 10);
			GlobalUtil.getMDriver().findElement(By.xpath(googlepasswordnext)).click();

			explicitWaitForElementforGivenTime(googleagree, type_xpath, 10);
			GlobalUtil.getMDriver().findElement(By.xpath(googleagree)).click();

			explicitWaitForElementforGivenTime(googlemore, type_xpath, 10);
			GlobalUtil.getMDriver().findElement(By.xpath(googlemore)).click();

			explicitWaitForElementforGivenTime(googleaccept, type_xpath, 10);
			GlobalUtil.getMDriver().findElement(By.xpath(googleaccept)).click();
		} catch (Exception ex) {
			Assert.assertEquals(GlobalUtil.getMDriver().findElement(By.xpath(chooseanaccount_text)).getText(),
					"Choose an account", "Choose an account page is displayed");
			RunCukesTest.logger.log(LogStatus.PASS,
					HTMLReportUtil.passStringGreenColor("Choose an account page is displayed"));
			GlobalUtil.getMDriver().findElement(By.xpath(useexistingaccount)).click();
		}

	}

	public static void verify_loginpage(String email) {
		try {
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(portfolio_profile)));
			explicitWaitForElementforGivenTime(portfolio_profile, type_xpath, 10);
			GlobalUtil.getMDriver().findElement(By.xpath(portfolio_profile)).click();

			String useremail_name = GlobalUtil.getMDriver().findElement(By.xpath(portfolio_profile_useremail))
					.getText();
			if (useremail_name.contains(email)) {
				System.out.println("User emailid is verified");
			}

			Assert.assertEquals(GlobalUtil.getMDriver().findElement(By.xpath(portfolio_profile_useremail)).getText()
					.contains(email), true);
			RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user email is verified"));

			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(portfolio_profile_logout)));
			explicitWaitForElementforGivenTime(portfolio_profile_logout, type_xpath, 10);
			MobileElement a = GlobalUtil.getMDriver().findElementByXPath(portfolio_profile_logout);
			mobileTap(a);
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(portfolio_profile)));
			explicitWaitForElementforGivenTime(portfolio_profile, type_xpath, 10);
			GlobalUtil.getMDriver().findElement(By.xpath(portfolio_profile)).click();
			if (GlobalUtil.getMDriver().findElement(By.xpath(loginwithfacebook)).isDisplayed()) {
				System.out.println("User successfully loged out");
			}

		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void prouser_logout() {
		try {
			explicitWaitForElementforGivenTime(portfolio_profile, type_xpath, 10);
			GlobalUtil.getMDriver().findElement(By.xpath(portfolio_profile)).click();
			// explicitWaitForElementforGivenTime(portfolio_profile_logout,
			// type_xpath,10);
			MobileElement a = GlobalUtil.getMDriver().findElementByXPath(portfolio_profile_logout);
			mobileTap(a);
			explicitWaitForElementforGivenTime(portfolio_profile, type_xpath, 15);
			GlobalUtil.getMDriver().findElement(By.xpath(portfolio_profile)).click();
			if (GlobalUtil.isWebElementPresent(loginwithfacebook, type_xpath)) {
				System.out.println("User successfully logged out");
			}
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	public static void add_all_stocks_to_profile(String stockname) {
		try {
			String[] stock_list = stockname.split("\n");
			System.out.println("stock_list size is " + stock_list.length);
			for (int i = 0; i < stock_list.length; i++) {
				System.out.println(stock_list[i]);
				// explicitWaitForElementforGivenTime(addstockssymbol,
				// type_xpath, 10);
				GlobalUtil.getMDriver().findElement(By.xpath(addstockssymbol)).click();

				// Assert.assertEquals(GlobalUtil.getMDriver().findElement(By.xpath(addstocks_text)).getText(),
				// "ADD STOCKS","Add Stocks page display is verified");

				MobileElement a = GlobalUtil.getMDriver().findElement(By.xpath(companyname));
				a.sendKeys(stock_list[i]);

				// KeywordUtil.delay(1000);
				if (MobileKeywords.isWebElementPresent(closeadd, type_xpath)) {
					GlobalUtil.getMDriver().findElement(By.xpath(closeadd)).click();
					KeywordUtil.delay(1000);
					mobileTap(576, 147);
					a.clear();
					a.sendKeys(stock_list[i]);
				}
				KeywordUtil.delay(3000);
				int x = a.getLocation().getX();
				int y = a.getLocation().getY();
				int h = a.getSize().getHeight();
				mobileTap(x + h, y + h + 50);
				GlobalUtil.getMDriver().findElement(By.xpath(investmentdate)).click();
				for (int j = 1; j <= 10; j++) {

					if (MobileKeywords.isWebElementPresent(please_enter_stock_name, type_xpath)) {
						System.out.println(j);
						GlobalUtil.getMDriver().findElement(By.xpath(OK)).click();
						a.clear();
						KeywordUtil.delay(1000);
						a.sendKeys(stock_list[i]);
						KeywordUtil.delay(2000);
						mobileTap(x + h + j * 30, y + h + 50 + j * 3);
						GlobalUtil.getMDriver().findElement(By.xpath(investmentdate)).click();
					}
				}
				explicitWaitForElementforGivenTime(OK, type_xpath, 10);
				// GlobalUtil.getMDriver().findElement(By.xpath(selectdate)).click();
				GlobalUtil.getMDriver().findElement(By.xpath(OK)).click();

				GlobalUtil.getMDriver().hideKeyboard();
				KeywordUtil.delay(3000);
				if (MobileKeywords.isWebElementPresent(closeadd, type_xpath)) {
					GlobalUtil.getMDriver().findElement(By.xpath(closeadd)).click();
					KeywordUtil.delay(1000);
					mobileTap(576, 147);
				}
				explicitWaitForElementforGivenTime(quantity, type_xpath, 10);
				GlobalUtil.getMDriver().findElement(By.xpath(quantity)).sendKeys("2");

				GlobalUtil.getMDriver().hideKeyboard();
				explicitWaitForElementforGivenTime(savestock_button, type_xpath, 10);
				GlobalUtil.getMDriver().findElement(By.xpath(savestock_button)).click();

				explicitWaitForElementforGivenTime(stockadded, type_xpath, 10);
				GlobalUtil.getMDriver().findElement(By.xpath(OK)).click();

				KeywordUtil.delay(1000);
				if (MobileKeywords.isWebElementPresent(closeadd, type_xpath)) {
					GlobalUtil.getMDriver().findElement(By.xpath(closeadd)).click();
					KeywordUtil.delay(1000);
					mobileTap(576, 147);
				}

				explicitWaitForElementforGivenTime(stocksoption, type_xpath, 10);
			}
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void add_stocks_to_profile(String stockname) {
		try {
			explicitWaitForElementforGivenTime(stocksoption, type_xpath, 10);

			Assert.assertEquals(GlobalUtil.getMDriver().findElement(By.xpath(stocksoption)).getText(), "Stocks",
					"Stocks link is visibility is verified");
			GlobalUtil.getMDriver().findElement(By.xpath(stocksoption)).click();

			KeywordUtil.delay(1000);

			add_all_stocks_to_profile(stockname);
			user_verifies_investment_amounts();
			user_verifies_stocknames(stockname);

			KeywordUtil.delay(3000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void user_verifies_stocknames(String stockname) {
		try {
			String total_names = "";
			List<MobileElement> list3 = GlobalUtil.getMDriver()
					.findElements(By.xpath("//*[@resource-id='android:id/list']/android.widget.LinearLayout"));
			System.out.println("elements list size is " + list3.size());
			System.out.println();
			for (int i = 1; i < list3.size(); i++) {
				if (MobileKeywords.isWebElementPresent(
						"//*[@resource-id='android:id/list']/android.widget.LinearLayout[@index='" + i
								+ "']/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[@index='0']",
						type_xpath)) {
					String stock_name = GlobalUtil.getMDriver()
							.findElement(By.xpath(
									"//*[@resource-id='android:id/list']/android.widget.LinearLayout[@index='" + i
											+ "']/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[@index='0']"))
							.getText();

					total_names = total_names + " ### ### " + stock_name;
				}
			}
			System.out.println();
			System.out.println("total names are " + total_names);

			String[] stock_list = stockname.split("\n");
			System.out.println("stock_list size is " + stock_list.length);
			for (int i = 0; i < stock_list.length; i++) {

				if (total_names.contains(stock_list[i])) {
					System.out.println();
					System.out.println(stock_list[i] + " addition is successfully performed");

				}
			}
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	public static void user_verifies_stocknames_watchlist(String stockname) {
		try {
			String total_names = "";
			List<MobileElement> list3 = GlobalUtil.getMDriver()
					.findElements(By.xpath("//*[@resource-id='android:id/list']/android.widget.RelativeLayout"));
			System.out.println("list size is " + list3.size());
			System.out.println();
			for (int i = 1; i <= list3.size(); i++) {
				String stock_name = GlobalUtil.getMDriver()
						.findElement(By
								.xpath("//*[@resource-id='android:id/list']/android.widget.RelativeLayout[@index='" + i
										+ "']/android.widget.LinearLayout/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='0']"))
						.getText();
				total_names = total_names + " ### ### " + stock_name;
			}
			System.out.println();
			System.out.println("total names are " + total_names);

			String[] stock_list = stockname.split("\n");
			System.out.println("stock_list size is " + stock_list.length);
			for (int i = 0; i < 2; i++) {

				if (total_names.contains(stock_list[i])) {

					System.out.println(stock_list[i] + " addition is successfully performed");

				} else {
					System.out.println(stock_list[i] + " addition is not performed");
				}
			}
			System.out.println();
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	public static void add_all_schemes_to_mutualfunds(String stockname) {
		try {
			String[] mutualfunds_list = stockname.split("\n");
			System.out.println("stock_list size is " + mutualfunds_list.length);
			for (int i = 0; i < mutualfunds_list.length; i++) {
				System.out.println(mutualfunds_list[i]);
				GlobalUtil.getMDriver().findElement(By.xpath(addstockssymbol)).click();
				KeywordUtil.delay(1000);
				GlobalUtil.getMDriver().findElement(By.xpath(one_time_option)).click();
				KeywordUtil.delay(1000);
				MobileElement a = GlobalUtil.getMDriver().findElement(By.xpath(enter_scheme_name_mutualfunds));
				a.sendKeys(mutualfunds_list[i]);
				KeywordUtil.delay(2000);
				int x = a.getLocation().getX();
				int y = a.getLocation().getY();
				int h = a.getSize().getHeight();
				mobileTap(x + h, y + h + 50);
				GlobalUtil.getMDriver().findElement(By.xpath(investment_date_mutualfunds)).click();
				KeywordUtil.delay(1000);
				explicitWaitForElementforGivenTime(OK, type_xpath, 10);
				GlobalUtil.getMDriver().findElement(By.xpath(OK)).click();
				GlobalUtil.getMDriver().findElement(By.xpath(investment_amount_mutualfunds)).sendKeys("1000");
				GlobalUtil.getMDriver().findElement(By.xpath(savestock_option__mutualfunds)).click();
				KeywordUtil.delay(2000);
				explicitWaitForElementforGivenTime(OK, type_xpath, 10);
				GlobalUtil.getMDriver().findElement(By.xpath(OK)).click();
				KeywordUtil.delay(2000);
			}
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	public static void add_mutualfunds_toprofile(String stockname) {
		try {
			// explicitWaitForElement(mutualfunds_option, type_xpath);
			KeywordUtil.delay(2000);
			GlobalUtil.getMDriver().findElement(By.xpath(mutualfunds_option)).click();
			// KeywordUtil.delay(3000);
			add_all_schemes_to_mutualfunds(stockname);
			user_verifies_investment_amounts();
			user_verifies_stocknames(stockname);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	public static void add_all_schemes_to_ULIPs(String stockname) {
		try {
			String[] ULIPs_list = stockname.split("\n");
			System.out.println("stock_list size is " + ULIPs_list.length);
			for (int i = 0; i < ULIPs_list.length; i++) {
				System.out.println(ULIPs_list[i]);
				GlobalUtil.getMDriver().findElement(By.xpath(addstockssymbol)).click();
				KeywordUtil.delay(2000);

				MobileElement a = GlobalUtil.getMDriver().findElement(By.xpath(ULIP_enter_scheme_name));
				a.sendKeys(ULIPs_list[i]);
				KeywordUtil.delay(3000);
				int x = a.getLocation().getX();
				int y = a.getLocation().getY();
				int h = a.getSize().getHeight();
				mobileTap(x + h, y + h + 50);
				GlobalUtil.getMDriver().findElement(By.xpath(ULIP_investmentdate_select)).click();
				explicitWaitForElementforGivenTime(OK, type_xpath, 10);
				GlobalUtil.getMDriver().findElement(By.xpath(OK)).click();
				GlobalUtil.getMDriver().findElement(By.xpath(ULIP_quantity)).sendKeys("2");
				GlobalUtil.getMDriver().findElement(By.xpath(ULIP_savescheme)).click();
				KeywordUtil.delay(2000);
				explicitWaitForElementforGivenTime(OK, type_xpath, 10);
				GlobalUtil.getMDriver().findElement(By.xpath(OK)).click();
				KeywordUtil.delay(3000);

			}
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void add_ulips_toprofile(String stockname) {
		try {
			// explicitWaitForElement(ULIP_option, type_xpath);
			KeywordUtil.delay(2000);
			GlobalUtil.getMDriver().findElement(By.xpath(ULIP_option)).click();
			// KeywordUtil.delay(2000);

			add_all_schemes_to_ULIPs(stockname);
			System.out.println();
			user_verifies_investment_amounts();
			System.out.println();
			user_verifies_stocknames(stockname);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void add_all_schemes_to_Bullions(String stockname) {
		try {
			String[] Bullions_list = stockname.split("\n");
			System.out.println("stock_list size is " + Bullions_list.length);
			for (int i = 0; i < Bullions_list.length; i++) {

				System.out.println(Bullions_list[i]);
				GlobalUtil.getMDriver().findElement(By.xpath(addstockssymbol)).click();
				KeywordUtil.delay(1000);
				if (i == 3) {
					GlobalUtil.getMDriver().findElement(By.xpath(Bullion_select_silver)).click();
					KeywordUtil.delay(1000);
				}
				GlobalUtil.getMDriver().findElement(By.xpath(Bullion_enter_quantity)).sendKeys(Bullions_list[i]);
				KeywordUtil.delay(2000);
				// ta.tap(230, 806);
				GlobalUtil.getMDriver().findElement(By.xpath(Bullion_investmentdate_select)).click();
				explicitWaitForElementforGivenTime(OK, type_xpath, 10);
				GlobalUtil.getMDriver().findElement(By.xpath(OK)).click();
				KeywordUtil.delay(1000);
				GlobalUtil.getMDriver().findElement(By.xpath(Bullion_savescheme)).click();
				KeywordUtil.delay(2000);
				explicitWaitForElementforGivenTime(OK, type_xpath, 10);
				GlobalUtil.getMDriver().findElement(By.xpath(OK)).click();
				KeywordUtil.delay(3000);
			}
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void add_bullions_toprofile(String stockname) {
		try {
			// explicitWaitForElement(Bullion_option, type_xpath);
			KeywordUtil.delay(2000);
			GlobalUtil.getMDriver().findElement(By.xpath(Bullion_option)).click();
			// KeywordUtil.delay(2000);

			add_all_schemes_to_Bullions(stockname);
			user_verifies_investment_amounts();
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void verify_stocks_reflection(String stockname) {
		explicitWaitForElementforGivenTime(summary_option, type_xpath, 10);
		GlobalUtil.getMDriver().findElement(By.xpath(summary_option)).click();
		user_verifies_stocknames(stockname);
	}

	public static float user_verifies_investment_amounts() {
		float total_investment = 0;
		try {
			KeywordUtil.delay(2000);
			List<MobileElement> list = GlobalUtil.getMDriver()
					.findElements(By.xpath("//*[@resource-id='android:id/list']/android.widget.LinearLayout"));

			System.out.println("stocks added are " + list.size());
			System.out.println();

			String amount = "0";
			KeywordUtil.delay(2000);
			for (int i = 1; i < list.size(); i++) {

				amount = GlobalUtil.getMDriver()
						.findElement(By.xpath("//*[@resource-id='android:id/list']/android.widget.LinearLayout[@index='"
								+ i + "']/android.widget.LinearLayout/android.widget.TextView"))
						.getText();

				if (amount.contains(",")) {
					amount = amount.replace(",", "");
				}

				float invest_amount = Float.parseFloat(amount);
				System.out.println(invest_amount);
				total_investment = total_investment + invest_amount;

			}
			System.out.println();
			System.out.println("total investment is " + total_investment);

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
		return total_investment;

	}

	public static void enter_stockname_to_watchlist(String stockname) {
		try {
			click_addstocks_symbol_mywatchlist();
			KeywordUtil.delay(1000);
			String[] stock_list = stockname.split("\n");
			// System.out.println("stock_list size is " + stock_list.length);

			for (int i = 0; i < 2; i++) {

				System.out.println(stock_list[i]);

				MobileElement sg_stck = GlobalUtil.getMDriver().findElement(By.xpath(enter_stockname_in_watchlist));
				// sg_stck.sendKeys(stock_list[i]);

				/***************** JSE **************/
				// GlobalUtil.getMDriver().executeScript("try{var el =
				// document.getElementById('com.divum.MoneyControl:id/edt_st_cmp_name');el.value
				// = '"+stock_list[i]+"';return 0;}catch{return 1;}");

				/************** ADB ****************/
				try {
					sg_stck.click();
					new ProcessBuilder(new String[] { "adb", "-s", "34P3Y18903023382", "shell", "input", "text",
							"" + stock_list[i] + "" }).redirectErrorStream(true).start();
				} catch (IOException e) {
					e.printStackTrace();
				}

				KeywordUtil.delay(4000);
				int x = sg_stck.getLocation().getX();
				int y = sg_stck.getLocation().getY();
				int h = sg_stck.getSize().getHeight();
				mobileTap(x + h, y + h + 50);
				KeywordUtil.delay(2000);
				select_suggested_stockname();
				KeywordUtil.delay(1000);

			}
			KeywordUtil.delay(1000);
			click_done_watchlist();
			KeywordUtil.delay(1000);
			clickMenuTab();
			KeywordUtil.delay(1000);
			clickmywatchlist();
			KeywordUtil.delay(1000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void select_suggested_stockname() {
		try {
			if (MobileKeywords.isWebElementPresent(suggesed_stockname, type_xpath)) {
				System.out.println("1");
				GlobalUtil.getMDriver().findElement(By.xpath(suggesed_stockname)).click();
			}
			KeywordUtil.delay(2000);
			if (MobileKeywords.isWebElementPresent(suggesed_stockname1, type_xpath)) {
				System.out.println("2");
				GlobalUtil.getMDriver().findElement(By.xpath(suggesed_stockname1)).click();
			}
			// KeywordUtil.delay(2000);
			if (MobileKeywords.isWebElementPresent(suggesed_stockname2, type_xpath)) {
				System.out.println("3");
				GlobalUtil.getMDriver().findElement(By.xpath(suggesed_stockname2)).click();
			}
			// KeywordUtil.delay(2000);
			if (MobileKeywords.isWebElementPresent(suggesed_stockname3, type_xpath)) {
				System.out.println("4");
				GlobalUtil.getMDriver().findElement(By.xpath(suggesed_stockname3)).click();
			}
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	public static void enter_mfname_to_watchlist(String stockname) throws Exception {
		try {
			click_addstocks_symbol_mywatchlist();

			KeywordUtil.delay(2000);
			String[] stock_list = stockname.split("\n");
			System.out.println("stock_list size is " + stock_list.length);

			for (int i = 0; i < 2; i++) {
				System.out.println(stock_list[i]);
				/*
				 * MobileElement sg_stck =
				 * GlobalUtil.getMDriver().findElement(By.xpath(
				 * enter_stockname_in_watchlist));
				 * sg_stck.sendKeys(stock_list[i]);
				 */

				MobileElement sg_stck = GlobalUtil.getMDriver().findElement(By.xpath(enter_stockname_in_watchlist));
				// sg_stck.sendKeys(stock_list[i]);

				/***************** JSE **************/
				// GlobalUtil.getMDriver().executeScript("try{var el =
				// document.getElementById('com.divum.MoneyControl:id/edt_st_cmp_name');el.value
				// = '"+stock_list[i]+"';return 0;}catch{return 1;}");

				sg_stck.click();
				GlobalUtil.getMDriver().getKeyboard().sendKeys(stock_list[i]);
				/*
				 * new ProcessBuilder(new String[] { "adb", "-s",
				 * "34P3Y18903023382", "shell", "input", "text", "" +
				 * stock_list[i] + "" }).redirectErrorStream(true).start();
				 */
				// sg_stck.sendKeys(stock_list[i]);

				// sg_stck.setValue(stock_list[i]);
				KeywordUtil.delay(4000);
				mobileTap(230, 600);

				// GlobalUtil.getMDriver().findElement(By.xpath("//*[@resource-id='com.divum.MoneyControl:id/lv_addmutulfundshints']/android.widget.LinearLayout[@index='0']/android.widget.TextView")).click();
				KeywordUtil.delay(2000);
				select_suggested_stockname();
				KeywordUtil.delay(2000);
			}
			KeywordUtil.delay(1000);
			click_done_watchlist();
			KeywordUtil.delay(1000);
			clickMenuTab();
			KeywordUtil.delay(1000);
			clickmywatchlist();
			KeywordUtil.delay(1000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void enter_commodityname_in_watchlist(String stockname) {
		try {
			click_addstocks_symbol_mywatchlist();

			KeywordUtil.delay(1000);
			String[] stock_list = stockname.split("\n");
			// System.out.println("stock_list size is " + stock_list.length);

			for (int i = 0; i < 2; i++) {

				System.out.println(stock_list[i]);

				/*
				 * MobileElement sg_stck =
				 * GlobalUtil.getMDriver().findElement(By.xpath(
				 * enter_stockname_in_watchlist));
				 * sg_stck.sendKeys(stock_list[i]);
				 */

				MobileElement sg_stck = GlobalUtil.getMDriver().findElement(By.xpath(enter_stockname_in_watchlist));
				// sg_stck.sendKeys(stock_list[i]);

				/***************** JSE **************/
				// GlobalUtil.getMDriver().executeScript("try{var el =
				// document.getElementById('com.divum.MoneyControl:id/edt_st_cmp_name');el.value
				// = '"+stock_list[i]+"';return 0;}catch{return 1;}");

				/************** ADB ****************/
				try {
					sg_stck.click();
					new ProcessBuilder(new String[] { "adb", "-s", "34P3Y18903023382", "shell", "input", "text",
							"" + stock_list[i] + "" }).redirectErrorStream(true).start();
				} catch (IOException e) {
					e.printStackTrace();
				}
				KeywordUtil.delay(4000);
				int x = sg_stck.getLocation().getX();
				int y = sg_stck.getLocation().getY();
				int h = sg_stck.getSize().getHeight();
				int w = sg_stck.getSize().getWidth();
				System.out.println("x is : " + x + " y is : " + y + " h is : " + h + " w is: " + w);

				// mobileTap(230, 806);
				mobileTap(x + h, y + h + 50);
				// ta.tap(230, 600);
				// GlobalUtil.getMDriver().findElement(By.xpath("//*[@resource-id='com.divum.MoneyControl:id/lv_addmutulfundshints']/android.widget.LinearLayout[@index='0']/android.widget.TextView")).click();
				KeywordUtil.delay(2000);
				select_suggested_stockname();
				KeywordUtil.delay(1000);
			}
			KeywordUtil.delay(1000);
			click_done_watchlist();
			KeywordUtil.delay(1000);
			clickMenuTab();
			KeywordUtil.delay(1000);
			clickmywatchlist();
			KeywordUtil.delay(1000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void enter_futurename_in_watchlist(String stockname) {
		try {
			click_addstocks_symbol_mywatchlist();

			KeywordUtil.delay(1000);
			String[] stock_list = stockname.split("\n");
			// System.out.println("stock_list size is " + stock_list.length);

			for (int i = 0; i < 2; i++) {

				System.out.println(stock_list[i]);

				/*
				 * MobileElement sg_stck =
				 * GlobalUtil.getMDriver().findElement(By.xpath(
				 * enter_stockname_in_watchlist));
				 * sg_stck.sendKeys(stock_list[i]);
				 */

				MobileElement sg_stck = GlobalUtil.getMDriver().findElement(By.xpath(enter_stockname_in_watchlist));
				// sg_stck.sendKeys(stock_list[i]);

				// ***************** JSE **************//*
				// GlobalUtil.getMDriver().executeScript("try{var el =
				// document.getElementById('com.divum.MoneyControl:id/edt_st_cmp_name');el.value
				// = '"+stock_list[i]+"';return 0;}catch{return 1;}");

				// ************** ADB ****************//*
				try {
					sg_stck.click();
					new ProcessBuilder(new String[] { "adb", "-s", "34P3Y18903023382", "shell", "input", "text",
							"" + stock_list[i] + "" }).redirectErrorStream(true).start();
				} catch (IOException e) {
					e.printStackTrace();
				}
				KeywordUtil.delay(4000);
				int x = sg_stck.getLocation().getX();
				int y = sg_stck.getLocation().getY();
				int h = sg_stck.getSize().getHeight();
				int w = sg_stck.getSize().getWidth();
				System.out.println("x is : " + x + " y is : " + y + " h is : " + h + " w is: " + w);

				// mobileTap(230, 806);
				mobileTap(x + h, y + h + 50);
				// ta.tap(230, 600);
				// GlobalUtil.getMDriver().findElement(By.xpath("//*[@resource-id='com.divum.MoneyControl:id/lv_addmutulfundshints']/android.widget.LinearLayout[@index='0']/android.widget.TextView")).click();
				KeywordUtil.delay(2000);
				select_suggested_stockname();
				KeywordUtil.delay(1000);
			}
			KeywordUtil.delay(1000);
			click_done_watchlist();
			KeywordUtil.delay(1000);
			clickMenuTab();
			KeywordUtil.delay(1000);
			clickmywatchlist();
			KeywordUtil.delay(1000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void enter_currencyname_in_watchlist(String stockname) {
		try {
			click_addstocks_symbol_mywatchlist();

			KeywordUtil.delay(1000);
			String[] stock_list = stockname.split("\n");
			// System.out.println("stock_list size is " + stock_list.length);

			for (int i = 0; i < 2; i++) {

				System.out.println(stock_list[i]);

				/*
				 * MobileElement sg_stck =
				 * GlobalUtil.getMDriver().findElement(By.xpath(
				 * enter_stockname_in_watchlist));
				 * sg_stck.sendKeys(stock_list[i]);
				 */

				MobileElement sg_stck = GlobalUtil.getMDriver().findElement(By.xpath(enter_stockname_in_watchlist));
				// sg_stck.sendKeys(stock_list[i]);

				/***************** JSE **************/
				// GlobalUtil.getMDriver().executeScript("try{var el =
				// document.getElementById('com.divum.MoneyControl:id/edt_st_cmp_name');el.value
				// = '"+stock_list[i]+"';return 0;}catch{return 1;}");

				/************** ADB ****************/
				try {
					sg_stck.click();
					new ProcessBuilder(new String[] { "adb", "-s", "34P3Y18903023382", "shell", "input", "text",
							"" + stock_list[i] + "" }).redirectErrorStream(true).start();
				} catch (IOException e) {
					e.printStackTrace();
				}

				KeywordUtil.delay(4000);
				int x = sg_stck.getLocation().getX();
				int y = sg_stck.getLocation().getY();
				int h = sg_stck.getSize().getHeight();
				int w = sg_stck.getSize().getWidth();
				System.out.println("x is : " + x + " y is : " + y + " h is : " + h + " w is: " + w);

				// mobileTap(230, 806);
				mobileTap(x + h, y + h + 50);
				// ta.tap(230, 600);
				// GlobalUtil.getMDriver().findElement(By.xpath("//*[@resource-id='com.divum.MoneyControl:id/lv_addmutulfundshints']/android.widget.LinearLayout[@index='0']/android.widget.TextView")).click();
				KeywordUtil.delay(2000);
				select_suggested_stockname();
				KeywordUtil.delay(1000);
			}
			KeywordUtil.delay(1000);
			click_done_watchlist();
			KeywordUtil.delay(1000);
			clickMenuTab();
			KeywordUtil.delay(1000);
			clickmywatchlist();
			KeywordUtil.delay(1000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void check_stocks_added_in_watchlist(String stockname) {
		try {
			String x = "";
			String text = "";
			List<MobileElement> list = GlobalUtil.getMDriver()
					.findElements(By.xpath("//*[@resource-id='android:id/list']/android.widget.RelativeLayout"));
			System.out.println("list size is " + list.size());
			for (int i = 1; i <= list.size(); i++) {
				text = GlobalUtil.getMDriver()
						.findElement(By
								.xpath("//*[@resource-id='android:id/list']/android.widget.RelativeLayout[@index='" + i
										+ "']/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"))
						.getText();
				x = x + text;
			}
			System.out.println("x is     " + x);
			if (x.contains(stockname)) {
				System.out.println("stock addition is verified successfully");

			} else {
				System.out.println("stock addition is not verified");
			}
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	public static void enter_pro_user_credentials(String proemail, String propassword) {
		try {
			GlobalUtil.getMDriver().findElement(By.xpath(emailoruserid)).sendKeys(proemail);
			GlobalUtil.getMDriver().findElement(By.xpath(emailpassword)).sendKeys(propassword);
			GlobalUtil.getMDriver().hideKeyboard();
			GlobalUtil.getMDriver().findElement(By.xpath(emaillogin)).click();
			KeywordUtil.delay(3000);
			if (KeywordUtil.isWebElementPresent(OK, type_xpath)) {
				GlobalUtil.getMDriver().findElement(By.xpath(OK)).click();
			}
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	public static void enter_Prousers_details_and_click_login(String Pro_usersID, String Pro_userspassword) {
		try {

			explicitWaitForElementforGivenTime(pro_user_ID, type_xpath, 10);
			GlobalUtil.getMDriver().findElement(By.xpath(pro_user_ID)).sendKeys(Pro_usersID);
			GlobalUtil.getMDriver().hideKeyboard();
			KeywordUtil.delay(5000);
			GlobalUtil.getMDriver().findElement(By.xpath(pro_user_password)).sendKeys(Pro_userspassword);
			GlobalUtil.getMDriver().hideKeyboard();
			KeywordUtil.delay(8000);

			GlobalUtil.getMDriver().findElement(By.xpath(pro_user_login_button)).click();
			KeywordUtil.delay(5000);

		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void clicksearchbt() {
		try {
			explicitWaitForElementforGivenTime(search_bt, type_xpath, 10);
			click(search_bt, type_xpath);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void clicknscApp() {
		try {
			explicitWaitForElementforGivenTime(nsc_Stocks_app, type_xpath, 10);
			click(nsc_Stocks_app, type_xpath);
			Thread.sleep(2000);
			click(click_nse_search, type_xpath);

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void clicketApp() {
		try {
			explicitWaitForElementforGivenTime(et_Stack_app, type_xpath, 10);
			click(et_Stack_app, type_xpath);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	public static void clickAdd() {
		try {
			explicitWaitForElementforGivenTime(add_stack_nm, type_xpath, 10);
			click(add_stack_nm, type_xpath);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void clickAdd1() {
		try {
			explicitWaitForElementforGivenTime(add_stack_nm1, type_xpath, 10);
			click(add_stack_nm1, type_xpath);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void clicketsearch() {
		try {
			explicitWaitForElementforGivenTime(Et_search_bt_1, type_xpath, 10);
			click(Et_search_bt_1, type_xpath);
		} catch (Throwable e) {
			explicitWaitForElementforGivenTime(Et_search_bt_2, type_xpath, 10);
			click(Et_search_bt_2, type_xpath);
		}
	}

	public static void clickettext() {
		try {
			explicitWaitForElementforGivenTime(click_et_text, type_xpath, 10);
			click(click_et_text, type_xpath);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void clickMoneycontrolpro() {
		try {
			KeywordUtil.delay(3000);
			explicitWaitForElementforGivenTime(money_control_pro, type_xpath, 10);
			click(money_control_pro, type_xpath);
			// Assert.assertEquals(MoneycontrolHomepage2.moneycontrolpro,"LIMITED
			// PERIOD OFFER!", "Moneycontrol Pro user label Verified");

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void getContentHome() {
		try {
			KeywordUtil.delay(3000);
			if (MobileKeywords.isWebElementPresent(NonproAdds, type_xpath)) {
				System.out.println("Non Pro users getting Adds and able to see Adds :Test case Failed");

			} else {
				System.out.println();

				System.out.println("Pro users not getting Adds :Test case Passed");
				System.out.println();

			}
			// Assert.assertEquals(MoneycontrolHomepage2.profile_iconn,"Login",
			// "Moneycontrol Pro user profile Verified");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void clickProfilelogout() {
		try {
			KeywordUtil.delay(3000);
			explicitWaitForElementforGivenTime(pro_user_clickprofile, type_xpath, 10);
			click(pro_user_clickprofile, type_xpath);
			// Assert.assertEquals(MoneycontrolHomepage2.profile_iconn,"Login",
			// "Moneycontrol Pro user profile Verified");

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void clicklogout() {
		try {
			KeywordUtil.delay(3000);
			explicitWaitForElementforGivenTime(pro_user_click_logout, type_xpath, 10);
			click(pro_user_click_logout, type_xpath);
			// Assert.assertEquals(MoneycontrolHomepage2.profile_iconn,"Login",
			// "Moneycontrol Pro user profile Verified");

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void MarketTab() {
		try {

			explicitWaitForElementforGivenTime(Markts_tab, type_xpath, 5);
			// KeywordUtil.delay(2000);
			click(Markts_tab, type_xpath);
		} catch (Throwable e) {

			// Horizontalswipe();

			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void topGainers() {
		try {
			// explicitWaitForElementforGivenTime(Topgainers, type_xpath, 5);
			KeywordUtil.delay(2000);
			List<MobileElement> list = GlobalUtil.getMDriver().findElements(By
					.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout"));
			// System.out.println("elements list size is " + list.size());
			String x = "";
			for (int j = 1; j < list.size(); j++) {
				if (MobileKeywords.isWebElementPresent(
						"//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout[@index='"
								+ j
								+ "']/android.widget.LinearLayout/android.widget.RelativeLayout[@index='2']//android.widget.TextView",
						type_xpath)) {
					String a = GlobalUtil.getMDriver()
							.findElement(By
									.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout[@index='"
											+ j + "']/android.widget.LinearLayout/android.widget.RelativeLayout[@index='2']//android.widget.TextView"))
							.getText();
					System.out.println(a);
					x = x + a;
				}

			}
			System.out.println("total is " + x);
			if (x.contains("-")) {
				System.out.println("It shows  topgainers and losers values");
				// MobileKeywords.takeMobileScreenshot("D:\\MC_CT\\cucumber-java-CT_MC\\target\\cucumber-html-report");

			}

			else

			{
				System.out.println("It shows topgainers values only");

			}
			// mobileTapTouchAction(383, 1090, 383, 256, 500);
			// mobileTapTouchAction(383, 1090, 383, 900, 500);

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	public static void verifyTopgainers() {
		Assert.assertEquals(Topgainers.equalsIgnoreCase("Top Gainers"), false);
	}

	public static void ClickToplosers() {
		try {
			explicitWaitForElementforGivenTime(Top_losers, type_xpath, 10);
			click(Top_losers, type_xpath);
			KeywordUtil.delay(2000);
			List<MobileElement> list = GlobalUtil.getMDriver().findElements(By
					.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout"));
			// System.out.println(list.size());
			String x = "";
			// mobileTapTouchAction(383,1090,383,256,500);
			for (int j = 1; j < list.size(); j++) {
				if (MobileKeywords.isWebElementPresent(
						"//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout[@index='"
								+ j
								+ "']/android.widget.LinearLayout/android.widget.RelativeLayout[@index='2']//android.widget.TextView",
						type_xpath)) {
					String a = GlobalUtil.getMDriver()
							.findElement(By
									.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout[@index='"
											+ j + "']/android.widget.LinearLayout/android.widget.RelativeLayout[@index='2']//android.widget.TextView"))
							.getText();
					System.out.println(a);
					x = x + a;
				}
			}
			System.out.println("total are " + x);
			if (x.contains("+")) {
				System.out.println("It shows  topgainers and losers values");
				// MobileKeywords.takeMobileScreenshot("D:\\MC_CT\\cucumber-java-CT_MC\\target\\cucumber-html-report");
			} else {
				System.out.println("It shows toplooser values only");

			}
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void verifyToplosers() {
		Assert.assertEquals(Top_losers.equalsIgnoreCase("Top Losers"), false);
	}

	public static Boolean swipeVerticalBottom1() {
		Boolean flag = false;

		size = GlobalUtil.getMDriver().manage().window().getSize();
		int starty = (int) (size.height * 0.60);
		int endy = (int) (size.height * 0.10);
		int startx = size.width / 2;
		mobileSwipeTouchAction(startx, starty, startx, endy, 1000);
		KeywordUtil.delay(2000);
		flag = true;

		if (flag)
			return true;
		else
			return false;
	}

	public static Boolean swipeVerticalBottom2() throws InterruptedException {
		Boolean flag = false;

		size = GlobalUtil.getMDriver().manage().window().getSize();
		int starty = (int) (size.height * 0.40);
		int endy = (int) (size.height * 0.10);
		int startx = size.width / 2;
		mobileSwipeTouchAction(startx, starty, startx, endy, 1000);
		Thread.sleep(2000);
		flag = true;

		if (flag)
			return true;
		else
			return false;
	}

	public static void stockActionValidation() {
		try {

			System.out.println();
			if (absoluteValue.contains("%")) {
				System.out.println("The order of absolute values are not followed Properly: Test case Failed ");
			} else {
				System.out.println("The order of absolute values are followed Properly: Test case Passed");
			}
			System.out.println();
			if (percentageValue.contains("%")) {
				System.out.println("the order of percentage values are followed Properly: Test case Passed");
			} else {
				System.out.println("the order of percentage values are not followed Properly: Test case Failed");
			}
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void validateSearchbt() {
		try {
			// System.out.println(GlobalUtil.getMDriver().findElement(By.id("getQuote_editSearchBox")).getText());
			Assert.assertEquals(GlobalUtil.getMDriver().findElement(By.id("getQuote_editSearchBox")).getText(),
					"Search Stocks, Funds, Commodities etc", "User click on search button is veryfied");

		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void enterMcStock(String name) {
		try {

			System.out.println("Stock is :" + name);
			GlobalUtil.getMDriver().findElement(By.xpath(search_text_enter)).sendKeys("abc");
			GlobalUtil.getMDriver().findElement(By.xpath(search_text_enter)).clear();
			GlobalUtil.getMDriver().findElement(By.xpath(search_text_enter)).sendKeys(name);
			KeywordUtil.delay(4000);
			GlobalUtil.getMDriver().findElement(By.xpath(Click_stackname_tab)).click();
			KeywordUtil.delay(2000);
			// System.out.println(KeywordUtil.getElementText(MoneycontrolHomepageApp.Overview));
			Assert.assertEquals(Overview.equalsIgnoreCase("Overview"), false);
		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	public static String getMcStockValues() {
		try {
			b = (GlobalUtil.getMDriver().findElement(By.xpath(mcprevclose)).getText());
			System.out.println("MC  Previous value is\t\t\t\t: " + b);

			x = (GlobalUtil.getMDriver().findElement(By.xpath(mcw_stack_value)).getText());
			System.out.println("MC  current price is\t\t\t\t: " + x);
			Thread.sleep(2000);
			a = (GlobalUtil.getMDriver().findElement(By.xpath(mcDiffandPer)).getText());
			System.out.println("MC  current Difference and percentage value is\t: " + a);

			String mcsbiDifference = a;
			String mcsbiDifference1 = mcsbiDifference.substring(0, 5);
			System.out.println("MC  current Difference  is\t\t\t: " + mcsbiDifference1);

			String mcsbiPercentage = a;
			String mcsbiPercentage1 = mcsbiPercentage.substring(mcsbiPercentage.length() - 7,
					mcsbiPercentage.length() - 2);
			if (mcsbiPercentage1.contains("(")) {
				mcsbiPercentage1 = mcsbiPercentage1.replace("(", "");
			}
			System.out.println("MC  current Percentage  is\t\t\t: " + mcsbiPercentage1);

			mcPercentage = Float.parseFloat(mcsbiPercentage1);
			// System.out.println("mc Float value is :"+mcPercentage);
			KeywordUtil.delay(1000);

			System.out.println();
			// A = Float.parseFloat(x);

		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
		return x;
	}

	public static void switchToNscApp() {
		try {

			System.out.println();
			clicknscApp();
		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	public static void enterNscStockName(String name) {
		try {
			System.out.println("Stock is : " + name);
			GlobalUtil.getMDriver().findElement(By.xpath(nse_search1)).sendKeys(name);
			Thread.sleep(4000);
			clicksearch();
			System.out.println();

			Thread.sleep(2000);
			y = (GlobalUtil.getMDriver().findElement(By.xpath(Nse_current_price)).getText());
			System.out.println("NSE  current price is\t\t\t\t: " + y);

			c = (GlobalUtil.getMDriver().findElement(By.xpath(Nse_Diff)).getText());
			System.out.println("NSE  current Difference  is\t\t: " + c);
			Thread.sleep(2000);

			c1 = (GlobalUtil.getMDriver().findElement(By.xpath(Nse_perc)).getText());
			System.out.println("NSE  current Percentage  is\t\t: " + c1);
			if (c1.contains("%")) {
				c1 = c1.replace("%", "");
			}
			nsePercentage = Float.parseFloat(c1);
			Thread.sleep(2000);
			Thread.sleep(3000);
			d = (GlobalUtil.getMDriver().findElement(By.xpath(Nse_prev_value)).getText());
			System.out.println("NSE  Previous value is\t\t\t\t: " + d);
			System.out.println();
			Thread.sleep(2000);
			pressKeyAndroid(AndroidKey.BACK);

			Thread.sleep(2000);
			pressKeyAndroid(AndroidKey.BACK);
			Thread.sleep(2000);

			System.out.println();

		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void switchToEtApp() {
		try {

			GlobalUtil.getMDriver().findElement(By.xpath("//*[@text='ET']")).click();
			Thread.sleep(1000);
			if (MobileKeywords.isWebElementPresent("//android.widget.TextView[@text='LATER']", type_xpath)) {
				GlobalUtil.getMDriver().findElement(By.xpath("//android.widget.TextView[@text='LATER']")).click();
			}
			clicketsearch();
			Thread.sleep(2000);
			MobileElement se = GlobalUtil.getMDriver().findElement(By.xpath(Enter_et_text));
			se.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	public static void enterEtStockName(String name) {
		try {
			System.out.println("Stock is : " + name);
			GlobalUtil.getMDriver().findElement(By.xpath(Enter_et_text)).sendKeys(name);
			Thread.sleep(2000);
			clickettext();
			Thread.sleep(2000);
			Assert.assertEquals(GlobalUtil.getMDriver().findElement(By.xpath(et_page)).getText(),
					"RESEARCH MARKET TREND", "User ET stack page is displayed verified");
			System.out.println();
			Thread.sleep(3000);
			z = GlobalUtil.getMDriver().findElement(By.xpath(get_et_text_value)).getText();
			System.out.println("ET current price is\t\t\t\t: " + z);
			Thread.sleep(3000);
			e = GlobalUtil.getMDriver().findElement(By.xpath(et_Diff_value)).getText();
			System.out.println("ET current Difference value is\t\t\t: " + e);
			f = GlobalUtil.getMDriver().findElement(By.xpath(et_Percentage_value)).getText();
			if (f.contains("%")) {
				f = f.replace("%", "");
			}
			System.out.println("ET current Percentage value is\t\t\t: " + f);
			etPercentage = Float.parseFloat(f);
			g = GlobalUtil.getMDriver().findElement(By.xpath(et_prevclose_value)).getText();
			System.out.println("ET Previous close is\t\t\t\t: " + g);
			System.out.println();
			pressKeyAndroid(AndroidKey.BACK);
			Thread.sleep(2000);
			pressKeyAndroid(AndroidKey.BACK);
			Thread.sleep(2000);
			pressKeyAndroid(AndroidKey.BACK);
			Thread.sleep(2000);
			pressKeyAndroid(AndroidKey.BACK);
			pressKeyAndroid(AndroidKey.BACK);
			System.out.println("Back to app is done");

		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void mcNseEtComapreStockPercentage() {
		try {

			System.out.println("MC Percentage Value\t\t\t\t: " + mcPercentage);
			System.out.println("NSE Percentage Value\t\t\t\t: " + nsePercentage);
			System.out.println("ET Percentage Value\t\t\t\t: " + etPercentage);
			System.out.println();

			Diff_Between_MC_nad_NSC = (mcPercentage) - (nsePercentage);
			System.out.println("Difference between MC and NSC is\t\t:" + Diff_Between_MC_nad_NSC + "%");

			Diff_Between_MC_nad_ET = (mcPercentage) - (etPercentage);
			System.out.println("Difference between MC and ET is\t\t\t:" + Diff_Between_MC_nad_ET + "%");
			System.out.println();

			if (Diff_Between_MC_nad_NSC < 2) {
				System.out.println("MC and NSC Stock Percentage Defference is Bellow 2% :Test case is Passed");
			} else {
				System.out.println("MC and NSC Stock Percentage Defference is Above 2% :Test case is Failed");
			}
			if (Diff_Between_MC_nad_ET < 2) {
				System.out.println("MC and ET Stock Percentage Defference is Bellow 2% :Test case is Passed");
			} else {
				System.out.println("MC and ET Stock Percentage Defference is Above 2% :Test case is Failed");

			}
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static String commoditiesAndCurrencies() {
		try {

			System.out.println();
			for (int i = 2; i < 5; i++) {
				if (KeywordUtil.isWebElementPresent(
						"//*[@resource-id='com.divum.MoneyControl:id/rv_linear_tray']/android.view.ViewGroup/android.view.ViewGroup[@index='"
								+ i + "']"
								+ "/android.widget.LinearLayout[@index='3']/android.widget.TextView[@index='0']",
						type_xpath)) {
					absoluteValue = GlobalUtil.getMDriver()
							.findElement(By
									.xpath("//*[@resource-id='com.divum.MoneyControl:id/rv_linear_tray']/android.view.ViewGroup/android.view.ViewGroup[@index='"
											+ i + "']"
											+ "/android.widget.LinearLayout[@index='3']/android.widget.TextView[@index='0']"))
							.getText();
					System.out.println("Commodities  Absolute Value " + i + "			:" + absoluteValue);

					percentageValue = GlobalUtil.getMDriver()
							.findElement(By
									.xpath("//*[@resource-id='com.divum.MoneyControl:id/rv_linear_tray']/android.view.ViewGroup/android.view.ViewGroup[@index='"
											+ i + "']"
											+ "/android.widget.LinearLayout[@index='3']/android.widget.TextView[@index='1']"))
							.getText();
					System.out.println("Commodities Percentage Value " + i + "		:" + percentageValue);
				}
			}
			System.out.println();

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
		return App_list_tab;
	}

	public static void Horizontalswipe() {
		Dimension dim = GlobalUtil.getMDriver().manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int y = (int) (height / 2);
		int startx = (int) (width * 0.70);
		int endx = (int) (width * 0.30);
		mobileSwipeTouchAction(startx, y, endx, y, 1000);
	}

	public static void getCurrenciesVal() {
		try {
			System.out.println();
			List<MobileElement> list = GlobalUtil.getMDriver().findElements(By.xpath(
					"//*[@resource-id='com.divum.MoneyControl:id/rv_linear_tray']/android.view.ViewGroup/android.view.ViewGroup"));
			System.out.println(list.size());
			for (int i = 2; i < 5; i++) {
				absoluteValue = GlobalUtil.getMDriver()
						.findElement(By
								.xpath("//*[@resource-id='com.divum.MoneyControl:id/rv_linear_tray']/android.view.ViewGroup/android.view.ViewGroup[@index='"
										+ i + "']"
										+ "/android.widget.LinearLayout[@index='3']/android.widget.TextView[@index='0']"))
						.getText();
				System.out.println("Commodities  Absolute Value " + i + "			:" + absoluteValue);

				percentageValue = GlobalUtil.getMDriver()
						.findElement(By
								.xpath("//*[@resource-id='com.divum.MoneyControl:id/rv_linear_tray']/android.view.ViewGroup/android.view.ViewGroup[@index='"
										+ i + "']"
										+ "/android.widget.LinearLayout[@index='3']/android.widget.TextView[@index='1']"))
						.getText();
				System.out.println("Commodities Percentage Value " + i + "		:" + percentageValue);
			}
			System.out.println();

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static String stockActionTopGainers() {
		try {
			System.out.println();
			for (int i = 2; i <= 5; i++) {
				if (KeywordUtil.isWebElementPresent(
						"//*[@resource-id='com.divum.MoneyControl:id/rv_linear_tray']/android.view.ViewGroup/android.view.ViewGroup[@index='"
								+ i + "']"
								+ "/android.widget.LinearLayout[@index='3']/android.widget.TextView[@index='0']",
						type_xpath)) {

					absoluteValue = GlobalUtil.getMDriver()
							.findElement(By
									.xpath("//*[@resource-id='com.divum.MoneyControl:id/rv_linear_tray']/android.view.ViewGroup/android.view.ViewGroup[@index='"
											+ i + "']"
											+ "/android.widget.LinearLayout[@index='3']/android.widget.TextView[@index='0']"))
							.getText();
					System.out.println("absolute value is 		:" + absoluteValue);

					percentageValue = GlobalUtil.getMDriver()
							.findElement(By
									.xpath("//*[@resource-id='com.divum.MoneyControl:id/rv_linear_tray']/android.view.ViewGroup/android.view.ViewGroup[@index='"
											+ i + "']"
											+ "/android.widget.LinearLayout[@index='3']/android.widget.TextView[@index='1']"))
							.getText();
					System.out.println("Percentage Value is 	:" + percentageValue);
				}
			}
			System.out.println();

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
		return App_list_tab;
	}

	public static Boolean refreshPage() {
		try {
			size = GlobalUtil.getMDriver().manage().window().getSize();
			int starty = (int) (size.height * 0.80);
			int endy = (int) (size.height * 0.40);
			int startx = size.width / 2;
			mobileSwipeTouchAction(startx, endy, startx, starty, 3000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
		return flag1;
	}

	public static void clicksearch() {
		try {

			if (MobileKeywords.isWebElementPresent(nse_click_tap, type_xpath)) {
				MobileKeywords.click(nse_click_tap, type_xpath);
				Thread.sleep(2000);
			}
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	public static void pushNotifications() {
		openNotificationsAndroid();
		KeywordUtil.delay(8000);
		MobileKeywords.click(notificationTitles, type_xpath);

	}

	public static void activeByValue() {
		try {
			Thread.sleep(4000);
			MobileKeywords.click(Activeby_value, type_xpath);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void verifyStockDuplicate() {
		try {
			for (int i = 0; i <= 1; i++) {
				KeywordUtil.delay(2000);
				List<MobileElement> list = GlobalUtil.getMDriver().findElements(By.xpath(
						"//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout"));
				System.out.println(list.size());

				for (int j = 1; j < list.size(); j++) {

					String a = GlobalUtil.getMDriver()
							.findElement(By
									.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout[@index='"
											+ j + "']//android.widget.LinearLayout//android.widget.RelativeLayout//android.widget.TextView[@index='0']"))
							.getText();
					if (a.contains("\n")) {
						a = a.replace("\n", "");
					}
					x = x + "###" + a;
					System.out.println(x);
				}
				KeywordUtil.delay(2000);
				mobileSwipeTouchAction(383, 1090, 383, 256, 500);
				System.out.println("swipe Done");
			}
			System.out.println("total stocks are " + x);
			String[] stock_names = x.split("###");
			for (int k = 1; k < stock_names.length; k++) {
				int n = 0;
				for (int m = 1; m < stock_names.length; m++) {
					if (stock_names[k].equals(stock_names[m])) {
						n++;
					}
				}
				System.out.println("n is " + n);
				if (n > 1) {
					System.out.println(stock_names[k] + " is duplicated ");
					KeywordUtil.takeMobileScreenshot(
							System.getProperty("user.dir") + "\\" + "ActiveByValueScreenShots\\Sample2" + ".png");
				} else {
					System.out.println(stock_names[k] + " is not duplicated ");
				}
			}
			KeywordUtil.takeMobileScreenshot(
					System.getProperty("user.dir") + "\\" + "ActiveByValueScreenShots\\Sample2" + ".png");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	public static void read_top5news_in_topNews() {

		int num = 0;
		String top5news = "";
		for (int i = 0; i < 5; i++) {

			num = i + 1;

			String pro_opinion_news_headline_text_before = GlobalUtil.getMDriver()
					.findElement(By.xpath("//*[@resource-id='android:id/list']/android.view.ViewGroup[@index='" + num
							+ "']//android.view.ViewGroup/android.widget.TextView"))
					.getText();
			System.out.println("pro_opinion_news_headline_text_before going into the news is   "
					+ pro_opinion_news_headline_text_before);
			System.out.println();
			top5news = top5news + " " + pro_opinion_news_headline_text_before;
		}
		System.out.println(" top 5 news are " + top5news);
	}

	public static void go_to_home() {
		GlobalUtil.getMDriver().findElement(By.xpath(menubutton1)).click();
		KeywordUtil.delay(1000);
	}

	static String[] news_time = new String[5];
	static Integer[] hrs = new Integer[7];
	static Integer[] mins = new Integer[7];
	static Integer[] secs = new Integer[7];

	@SuppressWarnings("unused")
	public static void user_verifies_news_time() {
		String[] news_time1 = { "1 hr 33 mins ago", "1 hr 4 mins ago", "44 mins 19 sec ago", "2 hrs 33 mins ago",
				"2 min 6 sec ago", "5 sec ago", "50 sec ago" };

		for (int i = 0; i < news_time1.length; i++) {
			if (news_time1[i].contains("h")) {
				String hr = Character.toString(news_time1[i].charAt(0));
				hrs[i] = Integer.parseInt(hr);
			} else {
				hrs[i] = 0;
			}
		}
		for (int i = 0; i < news_time1.length; i++) {
			if (news_time1[i].contains("mins")) {
				int mIndex = news_time1[i].indexOf("mins");
				mins[i] = Integer.parseInt(news_time1[i].substring(mIndex - 3, mIndex - 1));
			} else if (news_time1[i].contains("min ")) {
				/*
				 * int mIndex=news_time1[i].indexOf("min "); String
				 * ab=news_time1[i].substring(mIndex-3,mIndex-1);
				 * if(ab.contains(" ")) { ab=ab.replace(" ", ""); }
				 * mins[i]=Integer.parseInt(ab);
				 */

				String mIndex = Character.toString(news_time1[i].charAt(0));
				mins[i] = Integer.parseInt(mIndex);
			} else {
				mins[i] = 0;
			}
		}
		for (int i = 0; i < news_time1.length; i++) {
			if (news_time1[i].contains("sec")) {
				int sIndex = news_time1[i].indexOf("sec");
				if (sIndex > 5) {
					String sec = news_time1[i].substring(sIndex - 3, sIndex - 1);
					if (sec.contains(" ")) {
						sec = sec.replace(" ", "");
					}
					secs[i] = Integer.parseInt(sec);
				} else if (sIndex < 5) {
					String sec = news_time1[i].substring(0, 2);
					if (sec.contains(" ")) {
						sec = sec.replace(" ", "");
					}
					secs[i] = Integer.parseInt(sec);
				}
			} else {
				secs[i] = 0;
			}
		}
		for (int i = 0; i < 7; i++) {
			System.out.println("hrs are " + hrs[i]);
			System.out.println("mins are " + mins[i]);
			System.out.println("secs are " + secs[i]);
			System.out.println();
		}
		Integer total_time[] = new Integer[7];
		boolean Newshrs = true;
		for (int i = 0; i < 7; i++) {
			total_time[i] = hrs[i] * 60 * 60 + mins[i] * 60 + secs[i];
			if (total_time[i] > 3 * 60 * 60) {
				Newshrs = false;
			} else {
				Newshrs = true;
			}
		}
		if (Newshrs = true) {
			System.out.println(" Top 5 News are uploaded in less than 3 hrs : Test passed");
		} else {
			System.out.println(" Top 5 News are uploaded more than 3 hrs before : Test failed");
		}
		System.out.println();
	}

	public static void click_on_TopNews_homepage() {
		try {
			click(TopNews_heading_homepage, type_xpath);
			KeywordUtil.delay(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void topnews_page_triggered() {
		if (MobileKeywords.isWebElementPresent(Top_News_page_text, type_xpath)) {
			System.out.println(" Top News heading in homepage is triggering to TopNews page : Test passed");
		} else {
			System.out.println(" Top News heading in homepage is not triggering to TopNews page : Test failed");
			KeywordUtil.takeMobileScreenshot(
					System.getProperty("user.dir") + "\\" + "ActiveByValueScreenShots\\Sample3" + ".png");

		}
	}

	public static void open_investing_app() {
		try {
			click(Investing_app, type_xpath);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	public static void click_on_IndianIndices() {

		click(Indian_Indices_in_homepage, type_xpath);
		KeywordUtil.delay(2000);
		// Assert.assertTrue(GlobalUtil.getMDriver().findElement(By.xpath(All_indices_text)).isDisplayed());

	}

	public static void clickBackBtn() {
		try {
			explicitWaitForElementforGivenTime(back_btn, type_xpath, 10);
			click(back_btn, type_xpath);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}
}
