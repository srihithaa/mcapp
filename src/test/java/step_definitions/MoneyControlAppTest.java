package step_definitions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.text.TabableView;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.github.fge.jsonschema.library.Keyword;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import mcWebPages.MoneyControlAppPage;
import mobileutil.MobileKeywords;
import utilities.ExcelDataUtil;
import utilities.GlobalUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

public class MoneyControlAppTest extends MobileKeywords {

	
	public static HashMap<String, String> dataMap = new HashMap<String, String>();

	@Given("^User Open MoneyControl$")
	public void openapp() {
		GlobalUtil.getMobileApp();
	}

	@When("^User clicks on profile icon$")
	public void user_clicks_profileIcon() {
		MoneyControlAppPage.click_profileicon();
	}

	@When("^User Click on Menu$")
	public void clickMenu() {
		KeywordUtil.delay(2000);
		if (GlobalUtil.isWebElementPresent(MoneyControlAppPage.OK, MoneyControlAppPage.type_xpath)) {
			GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.OK)).click();
		}
		MoneyControlAppPage.clickMenuTab();
	}

	@Then("^User Click on MyPortfolio$")
	public void clickMyPortfolio() {

		Assert.assertEquals(
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.myportfoliobutton)).getText(),
				"My Portfolio", "My portfolio link is visible");
		RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("My portfolio link is visible"));
		MoneyControlAppPage.clickmyportfolio();
	}

	@And("^User Clicks on Login with facebook$")
	public void clickLoginwithfacebookbutton() {
		try {
			Assert.assertEquals(
					GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.loginwithfacebook)).getText(),
					"LOGIN WITH FACEBOOK", "facebook login link is visible");
			RunCukesTest.logger.log(LogStatus.PASS,
					HTMLReportUtil.passStringGreenColor("Login with facebook is displayed"));
			MoneyControlAppPage.clickloginwithfacebook();

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

		explicitWaitForElementforGivenTime(MoneyControlAppPage.emailoruserid, MoneyControlAppPage.type_xpath, 10);
		GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.emailoruserid)).sendKeys(dataMap.get("Email"));
		GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.emailpassword))
		.sendKeys(dataMap.get("Password"));

		// GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.emaillogin)).click();

	}

	@And("^User enters facebook details and click login$")
	public void loginwithfacebook() {
		MoneyControlAppPage.do_facebook_login(dataMap.get("Email"), dataMap.get("Password"));

	}

	@And("^User enters Google details and click login$")
	public void loginwithgoogle() {
		MoneyControlAppPage.do_google_login(dataMap.get("Email"), dataMap.get("Password"));
	}

	@And("^User verifies login page and click on logout$")
	public void verifyloginpage() {
		MoneyControlAppPage.verify_loginpage(dataMap.get("Email"));

	}

	@And("^User Clicks on Login with google$")
	public void clickLoginwithgooglebutton() {
		try {
			Assert.assertEquals(
					GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.loginwithgoogle)).getText(),
					"LOGIN WITH GOOGLE", "google link is visible");
			RunCukesTest.logger.log(LogStatus.PASS,
					HTMLReportUtil.passStringGreenColor("Login with google is displayed"));
			MoneyControlAppPage.clickgooglelogin();

		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@And("^Add stocks \"(.*)\" to profile$")
	public void addStocksToProfile(String stockname) {
		dataMap = ExcelDataUtil.getTestDataWithTestCaseID("MoneyControl", stockname);
		MoneyControlAppPage.add_stocks_to_profile(dataMap.get("StockName"));
	}

	@And("^Add Mutualfunds \"(.*)\" to profile$")
	public void add_mutualfunds_ToProfile(String stockname) {
		dataMap = ExcelDataUtil.getTestDataWithTestCaseID("MoneyControl", stockname);
		MoneyControlAppPage.add_mutualfunds_toprofile(dataMap.get("Mutualfunds"));
	}

	@And("^Add ULIPs \"(.*)\" to profile$")
	public void add_ULIPs_ToProfile(String stockname) {
		dataMap = ExcelDataUtil.getTestDataWithTestCaseID("MoneyControl", stockname);
		MoneyControlAppPage.add_ulips_toprofile(dataMap.get("ULIP"));
	}

	@And("^Add Bullions \"(.*)\" to profile$")
	public void add_Bullions_ToProfile(String stockname) {
		dataMap = ExcelDataUtil.getTestDataWithTestCaseID("MoneyControl", stockname);
		MoneyControlAppPage.add_bullions_toprofile(dataMap.get("Bullions"));
	}

	@And("^Verify stocks are correctly reflected or not with respect to stockname$")
	public void verifyStocksreflection() {
		MoneyControlAppPage.verify_stocks_reflection(dataMap.get("StockName"));
	}

	@And("^User get the networth amount and checks for the confirmation$")
	public void user_get_networth() {
		KeywordUtil.delay(2000);
		explicitWaitForElementforGivenTime(MoneyControlAppPage.summary_option, MoneyControlAppPage.type_xpath, 10);
		GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.summary_option)).click();

		float total_investment = MoneyControlAppPage.user_verifies_investment_amounts();

		KeywordUtil.delay(3000);

		String networth = GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.Networth)).getText();
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
			Assert.assertEquals(
					GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.my_watchlist)).getText(),
					"My Watchlist", "My Watchlist link is visible");
			RunCukesTest.logger.log(LogStatus.PASS,
					HTMLReportUtil.passStringGreenColor("My Watchlist link is visible"));
			MoneyControlAppPage.clickmywatchlist();

		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@And("^User Click on AddStocks$")
	public void click_addstocks_mywatchlist() {
		try {

			MoneyControlAppPage.click_addstocks_symbol_mywatchlist();

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
		GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.stocks_option_in_watchlist)).click();
		KeywordUtil.delay(2000);
		MoneyControlAppPage.enter_stockname_to_watchlist(dataMap.get("StockName"));
		KeywordUtil.delay(2000);
		GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.stocks_option_in_watchlist)).click();
		KeywordUtil.delay(2000);
		MoneyControlAppPage.user_verifies_stocknames_watchlist(dataMap.get("StockName"));

	}

	@And("^User enters \"(.*)\" mutualfunds to watchlist$")
	public void enter_mutualfundname_watchlist(String stockname) {
		dataMap = ExcelDataUtil.getTestDataWithTestCaseID("MoneyControl", stockname);
		KeywordUtil.delay(2000);
		GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.mutualfunds_option_in_watchlist)).click();
		KeywordUtil.delay(2000);
		try {
			MoneyControlAppPage.enter_mfname_to_watchlist(dataMap.get("Mutualfunds"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		KeywordUtil.delay(2000);
		GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.mutualfunds_option_in_watchlist)).click();
		KeywordUtil.delay(2000);
		MoneyControlAppPage.user_verifies_stocknames_watchlist(dataMap.get("Mutualfunds"));

	}

	@And("^User enters \"(.*)\" commodities to watchlist$")
	public void enter_commodityname_watchlist(String stockname) {
		dataMap = ExcelDataUtil.getTestDataWithTestCaseID("MoneyControl", stockname);
		KeywordUtil.delay(2000);
		GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.commodities_option_in_watchlist)).click();
		KeywordUtil.delay(2000);
		MoneyControlAppPage.enter_commodityname_in_watchlist(dataMap.get("Commodities"));
		KeywordUtil.delay(2000);
		GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.commodities_option_in_watchlist)).click();
		KeywordUtil.delay(2000);
		MoneyControlAppPage.user_verifies_stocknames_watchlist(dataMap.get("Commodities"));
	}

	@And("^User enters \"(.*)\" futures to watchlist$")
	public void enter_futurename_watchlist(String stockname) {
		dataMap = ExcelDataUtil.getTestDataWithTestCaseID("MoneyControl", stockname);
		KeywordUtil.delay(2000);
		GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.futures_option_in_watchlist)).click();
		KeywordUtil.delay(2000);
		MoneyControlAppPage.enter_futurename_in_watchlist(dataMap.get("Futures"));
		KeywordUtil.delay(2000);
		GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.futures_option_in_watchlist)).click();
		KeywordUtil.delay(2000);
		MoneyControlAppPage.user_verifies_stocknames_watchlist(dataMap.get("Futures"));
	}

	@And("^User enters \"(.*)\" currencies to watchlist$")
	public void enter_currencyname_watchlist(String stockname) {
		dataMap = ExcelDataUtil.getTestDataWithTestCaseID("MoneyControl", stockname);
		KeywordUtil.delay(2000);
		GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.currencies_option_in_watchlist)).click();
		KeywordUtil.delay(2000);
		MoneyControlAppPage.enter_currencyname_in_watchlist(dataMap.get("Currencies"));
		KeywordUtil.delay(2000);
		GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.currencies_option_in_watchlist)).click();
		KeywordUtil.delay(2000);
		MoneyControlAppPage.user_verifies_stocknames_watchlist(dataMap.get("Currencies"));
	}

	@And("^User Click on Done button$")
	public void click_done_mywatchlist() {
		try {

			MoneyControlAppPage.click_done_watchlist();
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
		MoneyControlAppPage.clickMenuTab();
		KeywordUtil.delay(1000);
		MoneyControlAppPage.clickmywatchlist();
		KeywordUtil.delay(2000);
		GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.stocks_option_in_watchlist)).click();
		KeywordUtil.delay(2000);
		MoneyControlAppPage.user_verifies_stocknames_watchlist(dataMap.get("StockName"));

		KeywordUtil.delay(2000);
		/*GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.mutualfunds_option_in_watchlist)).click();
		KeywordUtil.delay(2000);
		MoneyControlAppPage.user_verifies_stocknames_watchlist(dataMap.get("Mutualfunds"));

		KeywordUtil.delay(2000);*/
		GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.commodities_option_in_watchlist)).click();
		KeywordUtil.delay(2000);
		MoneyControlAppPage.user_verifies_stocknames_watchlist(dataMap.get("Commodities"));

		KeywordUtil.delay(2000);
		GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.futures_option_in_watchlist)).click();
		KeywordUtil.delay(2000);
		MoneyControlAppPage.user_verifies_stocknames_watchlist(dataMap.get("Futures"));

		KeywordUtil.delay(2000);
		GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.currencies_option_in_watchlist)).click();
		KeywordUtil.delay(2000);
		MoneyControlAppPage.user_verifies_stocknames_watchlist(dataMap.get("Currencies"));

	}

	@And("^User click logout$")
	public static void pro_user_logout() {
		MoneyControlAppPage.prouser_logout();
	}

	@And("^User enters ProUser credentials and click login$")
	public static void enter_prouser_credentials() {
		MoneyControlAppPage.enter_pro_user_credentials(dataMap.get("Email"), dataMap.get("Password"));
	}

	@And("^User Click on News tab$")
	public void user_click_on_News_tab() {
		try {
			MoneyControlAppPage.click_News_Tab();
			//KeywordUtil.delay(2000);
		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@And("^User moves to Opinion tab$")
	public void user_moves_to_Opinion_tab() {

		try {
			//MoneyControlAppPage.click_Opinion_Tab();
			/*TouchAction t=new TouchAction(GlobalUtil.getMDriver());
			for(int i=0;i<=3;i++)
			{
			t.press(700, 1100).moveTo(480, 1100).release().perform();
			KeywordUtil.delay(3000);
			}*/
			GlobalUtil.getMDriver().findElements(By.xpath("//*[@resource-id='com.divum.MoneyControl:id/tabs']/android.widget.LinearLayout/android.widget.TextView")).get(4).click();
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
		MoneyControlAppPage.opinion_get_news();
		TouchAction ta = new TouchAction(GlobalUtil.getMDriver());

		ta.press(500, 1600).moveTo(500, 1450).release().perform();

		MoneyControlAppPage.opinion_get_news();

		ta.press(500, 1600).moveTo(500, 1450).release().perform();

		MoneyControlAppPage.opinion_get_news();

	}

	@And("^Pro User reads news with Pro symbol$")
	public void pro_user_reads_news_with_pro_symbol() {

		MoneyControlAppPage.pro_user_opinion_get_news();
		TouchAction ta = new TouchAction(GlobalUtil.getMDriver());

		KeywordUtil.delay(1000);
		ta.press(500, 1600).moveTo(500, 1450).release().perform();
		MoneyControlAppPage.pro_user_opinion_get_news();

		KeywordUtil.delay(1000);
		ta.press(500, 1600).moveTo(500, 1450).release().perform();
		MoneyControlAppPage.pro_user_opinion_get_news();

		KeywordUtil.delay(1000);

	}

	@And("^User accepts messages$")
	public static void accept_messages() {
		MoneyControlAppPage.accept_messages();
	}

	@And("^User click on SignUp$")
	public static void clickSignup() {
		MoneyControlAppPage.click_signup_button();
	}

	@And("^User clic on Sign up with Email$")
	public static void clickSignupwithEmail() {
		MoneyControlAppPage.click_SignupwithEmail();
	}

	@And("^User enters firstname, lastname, Email username and Email password$")
	public static void enterEmailcredentials() {
		MoneyControlAppPage.enter_emaildetails(dataMap.get("Password"));

	}

	@Then("^User verifies the verification message$")
	public static void emailVerification() {
		MoneyControlAppPage.email_success_verification();
	}

	@Then("^Enter Pro users details like \"([^\"]*)\" and \"([^\"]*)\" and click login$")
	public static void enter_Pro_users_details_like_and_and_click_login(String Pro_usersID, String Pro_userspassword) {

		MoneyControlAppPage.enter_Prousers_details_and_click_login(Pro_usersID, Pro_userspassword);
	}

	////////////////////////////////////////////////////

	@When("^User click on searchbutton$")
	public void user_click_on_searchbutton() {
		try {

			MoneyControlAppPage.clicksearchbt();

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
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			System.out.println("app launching time is " + dtf.format(now));
			
			// RunCukesTest.logger.log(LogStatus.PASS,
			// HTMLReportUtil.passStringGreenColor("before launch date"));
			
			String x = dtf.format(now);
			System.out.println(
					x.substring(x.length() - 5, x.length() - 3) + ":" + x.substring(x.length() - 2, x.length()));
			int a = Integer.parseInt(x.substring(x.length() - 5, x.length() - 3));
			
			int a1 = Integer.parseInt(x.substring(x.length() - 2, x.length()));

			KeywordUtil.delay(3000);
			Assert.assertEquals(
					GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.home_display)).getText(), "Home",
					"MoneyControl app opened verified");
			
			MoneyControlAppPage.click_profileicon();
			KeywordUtil.delay(50000); 
			MoneyControlAppPage.click_profileicon();
			KeywordUtil.delay(50000); 
			
			GlobalUtil.getMDriver().quit();
			DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime end = LocalDateTime.now();
			System.out.println("app ending time is " + dt.format(end));
			String y = dtf.format(end);
			System.out.println(
					y.substring(y.length() - 5, y.length() - 3) + ":" + y.substring(y.length() - 2, y.length()));
			int b = Integer.parseInt(y.substring(y.length() - 5, y.length() - 3));

			int b1 = Integer.parseInt(y.substring(y.length() - 2, y.length()));
			//int c=b-a;
			int c = (b+(b1/60)) - (a+(a1/60));
			int c1 = ((b * 60 + b1) - (a * 60 + a1));
			c1=c1-(c*60);

			System.out.println("Time Dfference is " + c + " minutes " + c1 + " sec");

		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@When("^User Click on Menu_tab$")
	public void user_Click_on_Menutab() {

		try {
			MoneyControlAppPage.clickMenuTab();
		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@Then("^User Click on Moneycontrol_Pro$")
	public void user_Click_on_Moneycontrol_Pro() {

		try {
			MoneyControlAppPage.clickMoneycontrolpro();
		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@Then("^User Click on MCProfile$")
	public void user_Click_on_Profile() {
		try {

			MoneyControlAppPage.clickprofile();
		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@Given("^User open Mobile notifications$")
	public void Open_notification_bar() {
		try {
			GlobalUtil.getMDriver().openNotifications();
			KeywordUtil.delay(10000);

		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	@Given("^User click on notification and verify correct page$")
	public void verify_notification() {
		GlobalUtil.getMDriver().lockDevice();
		KeywordUtil.delay(5000);
		GlobalUtil.getMDriver().unlockDevice();
		TouchAction tact=new TouchAction(GlobalUtil.getMDriver());
		tact.press(500, 1900).moveTo(500, 700).release().perform();

	}

	@Then("^User_Clicks on Markets_Tab$")
	public void user_Clicks_on_Markets_Tab() {

		MoneyControlAppPage.MarketTab();

	}

	@Then("^User_Click on Top_Gainers$")
	public void user_Click_on_Top_Gainers() {
		MoneyControlAppPage.topGainers();
		GlobalUtil.getMDriver().swipe(383, 1090, 383, 900, 500);
		MoneyControlAppPage.topGainers();
		GlobalUtil.getMDriver().swipe(383, 1090, 383, 900, 500);
		MoneyControlAppPage.topGainers();

	}

	@Then("^User_verify top_gainers$")
	public void user_verify_topgainers() {
		MoneyControlAppPage.verifyTopgainers();
	}

	@Then("^User_Click on Top Losers$")
	public void user_Click_on_Top_Losers() {

		MoneyControlAppPage.ClickToplosers();
		GlobalUtil.getMDriver().swipe(383, 1090, 383, 900, 500);
		MoneyControlAppPage.ClickToplosers();
		GlobalUtil.getMDriver().swipe(383, 1090, 383, 900, 500);
		MoneyControlAppPage.ClickToplosers();

	}

	@Then("^User_verify top losers$")
	public void user_verify_toplosers() {
		MoneyControlAppPage.verifyToplosers();
	}

	String userid1;
	String userid2;

	@When("^User run App in Background$")
	public void user_run_App_in_Background() throws Throwable {
		System.out.println();
		System.out.println("MC App will be going to run in background");
		explicitWaitForElementforGivenTime(MoneyControlAppPage.portfolio_profile, MoneyControlAppPage.type_xpath, 10);
		GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.portfolio_profile)).click();
		userid1 = GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.portfolio_profile_useremail))
				.getText();
		System.out.println("Before App Background run Pro user ID is   :" + userid1);
		GlobalUtil.getMDriver().runAppInBackground(30);
		Thread.sleep(5000);

	}

	@When("^User re launch MC App$")
	public void user_re_launch_MC_App() throws Throwable {

		userid2 = GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.portfolio_profile_useremail))
				.getText();
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
		MoneyControlAppPage.click_profileicon();
		String loginbt = GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.emaillogin)).getText();
		System.out.println();
		System.out.println("Re-launch app cheking ext   :" + loginbt);
		System.out.println();

		if (GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.emaillogin)).isDisplayed()) {
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
				MoneyControlAppPage.swipeVerticalBottom1();
				Thread.sleep(3000);
				System.out.println("swipe done for Stock Action visibility");
			}
		}
		MoneyControlAppPage.swipeVerticalBottom2();
	}

	@And("^user get the Absolute value and percentage value for Stocks Action$")
	public void user_get_the_Absolute_value_and_percentage_value() throws Throwable {

		MoneyControlAppPage.stockActionTopGainers();
		for (int i = 0; i < 3; i++) {
			MoneyControlAppPage.refreshPage();
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
				MoneyControlAppPage.swipeVerticalBottom1();
				System.out.println("swipe done for Stock Action visibility");
			}
		}
		MoneyControlAppPage.swipeVerticalBottom2();
		MoneyControlAppPage.stockActionTopGainers();

	}

	@Given("^user get the Absolute value and percentage value for Commodities And currencies$")
	public void getCommodityAndCurrencyValue() throws Exception {

		while (2 > 1) {
			try {
				GlobalUtil.getMDriver().findElement(By.xpath("//*[@text='Commodities and Currencies']")).isDisplayed();
				break;
			} catch (Exception ex) {
				Thread.sleep(2000);
				MoneyControlAppPage.swipeVerticalBottom1();

			}
		}
		//MoneyControlAppPage.swipeVerticalBottom2();
		System.out.println("swipe done for Commodities And Currencies visibility");
		MoneyControlAppPage.commoditiesAndCurrencies();

		for (int i = 0; i <= 4; i++) {
			MoneyControlAppPage.refreshPage();
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
				MoneyControlAppPage.swipeVerticalBottom1();

			}
		}
		//MoneyControlAppPage.swipeVerticalBottom2();
		System.out.println("swipe done for Commodities And Currencies visibility");
		MoneyControlAppPage.commoditiesAndCurrencies();
		Thread.sleep(2000);
		System.out.println("Horizantal Swipe");

		for (int i = 0; i <= 1; i++) {
			MoneyControlAppPage.Horizontalswipe();
		}

		System.out.println("Horizantal swipe Done");
		MoneyControlAppPage.getCurrenciesVal();
	}

	@Then("^User validate the order of absolute and percentage values$")
	public void user_validate_the_order_of_absolute_and_percentage_values() {
		try {

			MoneyControlAppPage.stockActionValidation();

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

		//System.out.println("driver collect the Adds");
		List<AndroidElement> list = GlobalUtil.getMDriver().findElements(By.xpath(MoneyControlAppPage.NonproAdds));
		//System.out.println(list.size());

		String x = "";
		for (int j = 0; j < list.size(); j++) {
			System.out.println("Add Name is :" + list.get(j).getText());
			NonProAdds_Text = list.get(j).getText();
			x = x + NonProAdds_Text;
		}
		if (GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.NonproAdds)).isDisplayed()) {
			System.out.println("Non Pro users getting Adds and able to see Adds :Test case Passed");
		} else {
			System.out.println("Non Pro users not getting Adds :Test case Failed");
		}

	}

	@Then("^User_Click on Moneycontrol_Pro$")
	public void user_Click_on_Moneycontrol_Pro1() throws Throwable {
		try {
			MoneyControlAppPage.clickMoneycontrolpro();
		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@Then("^User_Click on MCProfile$")
	public void user_Click_on_Profile1() throws Throwable {

		try {

			MoneyControlAppPage.clickprofile();
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
			MoneyControlAppPage.getcontenthome();
			MoneyControlAppPage.clickProfilelogout();
			MoneyControlAppPage.clicklogout();
			Assert.assertNotEquals(MoneyControlAppPage.pro_user_indices, "Indices",
					"pro user is not getting adds is verified");
		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@Then("^User verifies Notifications$")
	public void user_verifies_Notifications() throws Throwable {
		MoneyControlAppPage.Pushnotifications();
		TouchAction tact=new TouchAction(GlobalUtil.getMDriver());
		tact.press(500, 1900).moveTo(500, 700).release().perform();
	}

	@Then("^User click on Active by value$")
	public void user_click_on_Active_by_value() throws Throwable {
		MoneyControlAppPage.activeByValue();
	}

	@Then("^User Verify the Stocks$")
	public void user_Verify_the_Stocks() throws Throwable {
		MoneyControlAppPage.verifyStockDuplicate();
	}

	@Then("^User_Enter stockname for Checking MC stack value with \"(.*)\"$")
	public void mcStockvalue(String name) {

		MoneyControlAppPage.enterMcStock(dataMap.get(name));
	}

	@Then("^User_get the MCS stackvalues$")
	public void mcStockValue() throws InterruptedException {
		MoneyControlAppPage.getMcStockValues();

	}

	@Then("^User_switch to NSE stock App$")
	public void nscApp() throws Throwable {
		MoneyControlAppPage.switchToNscApp();
	}

	@Then("^User_Enter stockname for checking NSES with \"(.*)\"$")
	public void nscStockName(String name) throws Throwable {

		MoneyControlAppPage.enterNscStockName(dataMap.get(name));
	}

	@Given("^User_switch to ET stock Appp$")
	public void etApp() throws Throwable {
		GlobalUtil.getMDriver().pressKeyCode(AndroidKeyCode.HOME);
		System.out.println("Back Home Done");
		MoneyControlAppPage.switchToEtApp();

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

		MoneyControlAppPage.enterEtStockName(dataMap.get(name));
	}

	@Then("^User validate the NIFTY Stocks for MC, NSE and ET, compare values bellow two percentage$")
	public void validation() throws Exception {
		MoneyControlAppPage.mcNseEtComapreStockPercentage();
	}

	//////************** New Test Cases************************///////////////////////////////////////////////////

	@When("^User clicks skips next option$")
	public void user_clicks_skip()
	{
		TouchAction t=new TouchAction(GlobalUtil.getMDriver());
		for(int i=0;i<13;i++)
		{
			t.tap(520,125).perform();
			KeywordUtil.delay(800);
		}
		//KeywordUtil.delay(6000);

	}

	@And("^User goes to TopNews section in News tab$")
	public void user_goes_to_topnews_section_in_news_tab()
	{
		MoneyControlAppPage.click_News_Tab();
		KeywordUtil.delay(2000);
	}
	@And("^User collects top 5 news from TopNews section$")
	public void user_collects_top5news_from_TopNews_section()
	{
		MoneyControlAppPage.read_top5news_in_topNews();

	}
	@And("^User goes to Homepage$")
	public void user_goes_to_homepage()
	{
		MoneyControlAppPage.go_to_home();
	}

	@And("^User checks for the top 5 news headlines in Homepage$")
	public void user_checks_for_top5news_in_homepage()
	{
		MoneyControlAppPage.user_checks_for_top5news_in_homepage();
	}

	@And("^User checks for the top 5 news time in Homepage$")
	public void user_checks_for_top5news_time_in_homepage()
	{
		MoneyControlAppPage.user_checks_for_top5news_time_in_homepage();
	}
	@And("^User verifies if the news uploaded with in 3 hrs$")
	public void user_verifies_if_the_news_uploaded_within_3hrs()
	{
		MoneyControlAppPage.user_verifies_news_time();
	}
	@And("^User clicks on TopNews in Homepage$")
	public void user_clicks_on_TopNews_in_homepage()
	{
		MoneyControlAppPage.click_on_TopNews_homepage();
	}
	@Then("^User verifies if TopNews list page is triggered$")
	public void user_verifies_if_topnews_list_page_triggered()
	{
		MoneyControlAppPage.topnews_page_triggered();
	}

	@And("^User goes to Indices section in Homepage$")
	public void user_goes_to_indices_section_in_homepage()
	{
		size = GlobalUtil.getMDriver().manage().window().getSize();
		int starty = (int) (size.height * 0.70);
		int endy = (int) (size.height * 0.10);
		int startx = size.width / 2;
		GlobalUtil.getMDriver().swipe(startx, starty, startx, endy, 1000);
	}
	@And("^User checks Indian indices and Global indices display$")
	public void user_checks_indian_and_global_indices()
	{
		List<AndroidElement> indian_indices_list=GlobalUtil.getMDriver().findElements(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.LinearLayout/android.view.ViewGroup"));
		System.out.println("Indian indices list in home page is "+indian_indices_list.size());
		if(indian_indices_list.size()-1==4)
		{
			System.out.println("4 Indian indices are diplayed");
		}
		List<AndroidElement> global_indices_list=GlobalUtil.getMDriver().findElements(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='1']/android.widget.LinearLayout/android.view.ViewGroup"));
		System.out.println("Global indices list in home page is "+global_indices_list.size());
		if(global_indices_list.size()-1==4)
		{
			System.out.println("4 Global indices are diplayed");
		}

	}
	String indian_4_indices_names[]=new String[4];
	String indian_4_indices_dateTime[]=new String[4];
	String indian_4_indices_values[]=new String[4];
	String indian_4_indices_percentages[]=new String[4];

	String global_4_indices_names[]=new String[4];
	String global_4_indices_dateTime[]=new String[4];
	String global_4_indices_values[]=new String[4];
	String global_4_indices_percentages[]=new String[4];

	@And("^User gets indices values$")
	public void user_gets_indices_values()
	{
		for(int i=0;i<4;i++)
		{
			indian_4_indices_names[i]=GlobalUtil.getMDriver().findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.LinearLayout/android.view.ViewGroup[@index='"+i+"']/android.widget.RelativeLayout/android.widget.TextView [@index='0']")).getText();
			//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='1']/android.widget.LinearLayout/android.view.ViewGroup[@index='0']/android.widget.RelativeLayout/android.widget.TextView[@index='0']
			System.out.println("indian index name is "+indian_4_indices_names[i]);
			KeywordUtil.delay(2000);
			indian_4_indices_dateTime[i]=GlobalUtil.getMDriver().findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.LinearLayout/android.view.ViewGroup[@index='"+i+"']/android.widget.RelativeLayout/android.widget.TextView [@index='2']")).getText();
			System.out.println("indian index dateTime is "+indian_4_indices_dateTime[i]);
			KeywordUtil.delay(2000);
			indian_4_indices_values[i]=GlobalUtil.getMDriver().findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.LinearLayout/android.view.ViewGroup[@index='"+i+"']/android.widget.LinearLayout[@index='2']/android.widget.TextView")).getText();
			System.out.println("indian index value is "+indian_4_indices_values[i]);
			KeywordUtil.delay(2000);
			indian_4_indices_percentages[i]=GlobalUtil.getMDriver().findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.LinearLayout/android.view.ViewGroup[@index='"+i+"']/android.widget.LinearLayout[@index='3']/android.widget.TextView[@index='1']")).getText();
			System.out.println("indian index percentage is "+indian_4_indices_percentages[i]);
			KeywordUtil.delay(2000);
			System.out.println();
		}

		Dimension dim = GlobalUtil.getMDriver().manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int y = (int) (height * 0.70);
		int startx = (int) (width * 0.80);
		int endx = (int) (width * 0.30);
		GlobalUtil.getMDriver().swipe(startx, y, endx, y, 1000);

		KeywordUtil.delay(2000);
		for(int i=0;i<4;i++)
		{
			global_4_indices_names[i]=GlobalUtil.getMDriver().findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='1']/android.widget.LinearLayout/android.view.ViewGroup[@index='"+i+"']/android.widget.RelativeLayout/android.widget.TextView [@index='0']")).getText();
			System.out.println("global index name is "+global_4_indices_names[i]);
			KeywordUtil.delay(2000);
			global_4_indices_dateTime[i]=GlobalUtil.getMDriver().findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='1']/android.widget.LinearLayout/android.view.ViewGroup[@index='"+i+"']/android.widget.RelativeLayout/android.widget.TextView [@index='2']")).getText();
			System.out.println("global index dateTime is "+global_4_indices_dateTime[i]);
			KeywordUtil.delay(2000);
			global_4_indices_values[i]=GlobalUtil.getMDriver().findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='1']/android.widget.LinearLayout/android.view.ViewGroup[@index='"+i+"']/android.widget.LinearLayout[@index='2']/android.widget.TextView")).getText();
			System.out.println("global index value is "+global_4_indices_values[i]);
			KeywordUtil.delay(2000);
			global_4_indices_percentages[i]=GlobalUtil.getMDriver().findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='1']/android.widget.LinearLayout/android.view.ViewGroup[@index='"+i+"']/android.widget.LinearLayout[@index='3']/android.widget.TextView[@index='1']")).getText();
			System.out.println("global index percentage is "+global_4_indices_percentages[i]);
			KeywordUtil.delay(2000);
			System.out.println();
		}

	}
	
	@And("^User gets indices values for New App$")
	public void user_gets_indices_values_new_app()
	{
		System.out.println("start");
		KeywordUtil.delay(3000);
		/*for(int i=0;i<4;i++)
		{
			indian_4_indices_names[i]=GlobalUtil.getMDriver().findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.LinearLayout/android.view.ViewGroup[@index='"+i+"'][@resource-id='com.divum.MoneyControl.debug:id/data_"+(i+1)+"']/android.widget.RelativeLayout/android.widget.TextView [@index='0'][contains(@content-desc,'stockname')]")).getText();
			//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='1']/android.widget.LinearLayout/android.view.ViewGroup[@index='0']/android.widget.RelativeLayout/android.widget.TextView[@index='0']
			System.out.println("indian index name is "+indian_4_indices_names[i]);
			//KeywordUtil.delay(2000);
			indian_4_indices_dateTime[i]=GlobalUtil.getMDriver().findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.LinearLayout/android.view.ViewGroup[@index='"+i+"'][@resource-id='com.divum.MoneyControl.debug:id/data_"+(i+1)+"']/android.widget.RelativeLayout/android.widget.TextView [@index='2'][contains(@content-desc,'date')]")).getText();
			System.out.println("indian index dateTime is "+indian_4_indices_dateTime[i]);
			//KeywordUtil.delay(2000);
			indian_4_indices_values[i]=GlobalUtil.getMDriver().findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.LinearLayout/android.view.ViewGroup[@index='"+i+"'][@resource-id='com.divum.MoneyControl.debug:id/data_"+(i+1)+"']/android.widget.LinearLayout[@index='2']/android.widget.TextView[contains(@content-desc,'amount')]")).getText();
			System.out.println("indian index value is "+indian_4_indices_values[i]);
			//KeywordUtil.delay(2000);
			indian_4_indices_percentages[i]=GlobalUtil.getMDriver().findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.LinearLayout/android.view.ViewGroup[@index='"+i+"'][@resource-id='com.divum.MoneyControl.debug:id/data_"+(i+1)+"']/android.widget.LinearLayout[@index='3']/android.widget.TextView[@index='1'][contains(@content-desc,'changepercent')]")).getText();
			System.out.println("indian index percentage is "+indian_4_indices_percentages[i]);
			//KeywordUtil.delay(2000);
			System.out.println();
		}

		Dimension dim = GlobalUtil.getMDriver().manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int y = (int) (height * 0.70);
		int startx = (int) (width * 0.80);
		int endx = (int) (width * 0.30);
		GlobalUtil.getMDriver().swipe(startx, y, endx, y, 1000);

		KeywordUtil.delay(2000);
		for(int i=0;i<4;i++)
		{
			global_4_indices_names[i]=GlobalUtil.getMDriver().findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='1']/android.widget.LinearLayout/android.view.ViewGroup[@index='"+i+"'][@resource-id='com.divum.MoneyControl.debug:id/data_"+(i+1)+"']/android.widget.RelativeLayout/android.widget.TextView [@index='0'][contains(@content-desc,'stockname')]")).getText();
			System.out.println("global index name is "+global_4_indices_names[i]);
			//KeywordUtil.delay(2000);
			global_4_indices_dateTime[i]=GlobalUtil.getMDriver().findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='1']/android.widget.LinearLayout/android.view.ViewGroup[@index='"+i+"'][@resource-id='com.divum.MoneyControl.debug:id/data_"+(i+1)+"']/android.widget.RelativeLayout/android.widget.TextView [@index='2'][contains(@content-desc,'date')]")).getText();
			System.out.println("global index dateTime is "+global_4_indices_dateTime[i]);
			//KeywordUtil.delay(2000);
			global_4_indices_values[i]=GlobalUtil.getMDriver().findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='1']/android.widget.LinearLayout/android.view.ViewGroup[@index='"+i+"'][@resource-id='com.divum.MoneyControl.debug:id/data_"+(i+1)+"']/android.widget.LinearLayout[@index='2']/android.widget.TextView[contains(@content-desc,'amount')]")).getText();
			System.out.println("global index value is "+global_4_indices_values[i]);
			//KeywordUtil.delay(2000);
			global_4_indices_percentages[i]=GlobalUtil.getMDriver().findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='1']/android.widget.LinearLayout/android.view.ViewGroup[@index='"+i+"'][@resource-id='com.divum.MoneyControl.debug:id/data_"+(i+1)+"']/android.widget.LinearLayout[@index='3']/android.widget.TextView[@index='1'][contains(@content-desc,'changepercent')]")).getText();
			System.out.println("global index percentage is "+global_4_indices_percentages[i]);
			//KeywordUtil.delay(2000);
			System.out.println();
		}*/
		
		/*for(int i=0;i<4;i++)
		{
			indian_4_indices_names[i]=GlobalUtil.getMDriver().findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.LinearLayout/android.view.ViewGroup[@index='"+i+"'][@resource-id='com.divum.MoneyControl.debug:id/data_"+(i+1)+"']/android.widget.RelativeLayout/android.widget.TextView [@index='0'][contains(@content-desc,'stockname')]")).getText();
			//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='1']/android.widget.LinearLayout/android.view.ViewGroup[@index='0']/android.widget.RelativeLayout/android.widget.TextView[@index='0']
			System.out.println("indian index name is "+indian_4_indices_names[i]);
			//KeywordUtil.delay(2000);
			indian_4_indices_dateTime[i]=GlobalUtil.getMDriver().findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.LinearLayout/android.view.ViewGroup[@index='"+i+"'][@resource-id='com.divum.MoneyControl.debug:id/data_"+(i+1)+"']/android.widget.RelativeLayout/android.widget.TextView [@index='2'][contains(@content-desc,'date')]")).getText();
			System.out.println("indian index dateTime is "+indian_4_indices_dateTime[i]);
			//KeywordUtil.delay(2000);
			indian_4_indices_values[i]=GlobalUtil.getMDriver().findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.LinearLayout/android.view.ViewGroup[@index='"+i+"'][@resource-id='com.divum.MoneyControl.debug:id/data_"+(i+1)+"']/android.widget.LinearLayout[@index='2']/android.widget.TextView[contains(@content-desc,'amount')]")).getText();
			System.out.println("indian index value is "+indian_4_indices_values[i]);
			//KeywordUtil.delay(2000);
			indian_4_indices_percentages[i]=GlobalUtil.getMDriver().findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.LinearLayout/android.view.ViewGroup[@index='"+i+"'][@resource-id='com.divum.MoneyControl.debug:id/data_"+(i+1)+"']/android.widget.LinearLayout[@index='3']/android.widget.TextView[@index='1'][contains(@content-desc,'changepercent')]")).getText();
			System.out.println("indian index percentage is "+indian_4_indices_percentages[i]);
			//KeywordUtil.delay(2000);
			System.out.println();
		}*/

		Dimension dim = GlobalUtil.getMDriver().manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int y = (int) (height * 0.70);
		int startx = (int) (width * 0.80);
		int endx = (int) (width * 0.30);
		GlobalUtil.getMDriver().swipe(startx, y, endx, y, 1000);

		KeywordUtil.delay(2000);
		for(int i=0;i<4;i++)
		{
			global_4_indices_names[i]=GlobalUtil.getMDriver().findElement(By.xpath("//*[@resource-id='com.divum.MoneyControl.debug:id/rv_linear_tray']/android.view.ViewGroup[@index='1']//*[@resource-id='com.divum.MoneyControl.debug:id/data_"+(i+1)+"']//*[contains(@content-desc,'stockname')]")).getText();
			System.out.println("global index name is "+global_4_indices_names[i]);
			//KeywordUtil.delay(2000);
			global_4_indices_dateTime[i]=GlobalUtil.getMDriver().findElement(By.xpath("//*[@resource-id='com.divum.MoneyControl.debug:id/rv_linear_tray']/android.view.ViewGroup[@index='1']//*[@resource-id='com.divum.MoneyControl.debug:id/data_"+(i+1)+"']//*[contains(@content-desc,'date')]")).getText();
			System.out.println("global index dateTime is "+global_4_indices_dateTime[i]);
			//KeywordUtil.delay(2000);
			global_4_indices_values[i]=GlobalUtil.getMDriver().findElement(By.xpath("//*[@resource-id='com.divum.MoneyControl.debug:id/rv_linear_tray']/android.view.ViewGroup[@index='1']//*[@resource-id='com.divum.MoneyControl.debug:id/data_"+(i+1)+"']//*[contains(@content-desc,'amount')]")).getText();
			System.out.println("global index value is "+global_4_indices_values[i]);
			//KeywordUtil.delay(2000);
			global_4_indices_percentages[i]=GlobalUtil.getMDriver().findElement(By.xpath("//*[@resource-id='com.divum.MoneyControl.debug:id/rv_linear_tray']/android.view.ViewGroup[@index='1']//*[@resource-id='com.divum.MoneyControl.debug:id/data_"+(i+1)+"']//*[contains(@content-desc,'changepercent')]")).getText();
			System.out.println("global index percentage is "+global_4_indices_percentages[i]);
			//KeywordUtil.delay(2000);
			System.out.println();
		}
		

	}
	@And("^User switches to Investing app$")
	public void user_switches_to_investing_app()
	{
		GlobalUtil.getMDriver().pressKeyCode(AndroidKeyCode.HOME);
		MoneyControlAppPage.open_investing_app();
		KeywordUtil.delay(3000);
	}

	String indian_index_value_IA[]=new String[4];
	String indian_index_percentage_IA[]=new String[4];
	String global_index_value_IA[]=new String[4];
	String global_index_percentage_IA[]=new String[4];

	String indian_4_indices_names1[]={"NIFTY Smallcap 100","S&P BSE SENSEX","NIFTY  50","NIFTY Midcap 100"};
	String global_4_indices_names1[]={"SGX Nifty","KOSPI","Shanghai Composite","Straits Times"};

	@And("^User verifies the indices values and percentages in Investing app$")
	public void user_verifies_indices_in_Investingapp()
	{
		for(int i=0;i<4;i++)
		{
			click(MoneyControlAppPage.search_in_Investing_app, MoneyControlAppPage.type_xpath);
			KeywordUtil.inputText(By.xpath(MoneyControlAppPage.enter_index_in_Investing_app), indian_4_indices_names1[i] , "user entered index name");
			KeywordUtil.delay(5000);
			click("//android.widget.ListView/android.widget.RelativeLayout[@index='0']", MoneyControlAppPage.type_xpath);
			indian_index_value_IA[i]=KeywordUtil.getElementText(By.xpath(MoneyControlAppPage.get_index_value_in_Investing_app));
			System.out.println(indian_index_value_IA[i]);
			indian_index_percentage_IA[i]=KeywordUtil.getElementText(By.xpath(MoneyControlAppPage.get_index_percentage_in_Investing_app));
			System.out.println(indian_index_percentage_IA[i]);
			GlobalUtil.getMDriver().navigate().back();
			KeywordUtil.delay(1000);
			click(MoneyControlAppPage.back_in_Investing_app, MoneyControlAppPage.type_xpath);
		}

		for(int i=0;i<4;i++)
		{
			click(MoneyControlAppPage.search_in_Investing_app, MoneyControlAppPage.type_xpath);
			KeywordUtil.inputText(By.xpath(MoneyControlAppPage.enter_index_in_Investing_app), global_4_indices_names1[i] , "user entered index name");
			KeywordUtil.delay(5000);
			click("//android.widget.ListView/android.widget.RelativeLayout[@index='0']", MoneyControlAppPage.type_xpath);
			global_index_value_IA[i]=KeywordUtil.getElementText(By.xpath(MoneyControlAppPage.get_index_value_in_Investing_app));
			System.out.println(global_index_value_IA[i]);
			global_index_percentage_IA[i]=KeywordUtil.getElementText(By.xpath(MoneyControlAppPage.get_index_percentage_in_Investing_app));
			System.out.println(global_index_percentage_IA[i]);
			GlobalUtil.getMDriver().navigate().back();
			KeywordUtil.delay(1000);
			click(MoneyControlAppPage.back_in_Investing_app, MoneyControlAppPage.type_xpath);
		}

	}
	
	String All_Indices_value_IA[];
	String All_Indices_percentage_IA[];

	@And("^User checks all the indices values of \"(.*)\" in Investing app$")
	public void user_checks_all_indices_values_in_InvestingApp(String stockname)
	{
		dataMap = ExcelDataUtil.getTestDataWithTestCaseID("AllIndicesData", stockname);
		String[] all_Indices=dataMap.get("AllIndices").split("\n");
		All_Indices_value_IA=new String[all_Indices.length];
		All_Indices_percentage_IA=new String[all_Indices.length];
		
		for(int i=0;i<all_Indices.length;i++)
		{
			System.out.println(all_Indices[i]);
			click(MoneyControlAppPage.search_in_Investing_app, MoneyControlAppPage.type_xpath);
			KeywordUtil.inputText(By.xpath(MoneyControlAppPage.enter_index_in_Investing_app), all_Indices[i] , "user entered index name");
			KeywordUtil.delay(5000);
			if(MobileKeywords.isWebElementPresent("//android.widget.ListView/android.widget.RelativeLayout[@index='0']",MoneyControlAppPage.type_xpath))
			{
				click("//android.widget.ListView/android.widget.RelativeLayout[@index='0']", MoneyControlAppPage.type_xpath);
				WebDriverWait wait=new WebDriverWait(GlobalUtil.getMDriver(),20);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MoneyControlAppPage.get_index_value_in_Investing_app)));
				All_Indices_value_IA[i]=KeywordUtil.getElementText(By.xpath(MoneyControlAppPage.get_index_value_in_Investing_app));
				if(All_Indices_value_IA[i].contains(","))
				{
					All_Indices_value_IA[i]=All_Indices_value_IA[i].replaceAll(",", "");
				}
				System.out.println(All_Indices_value_IA[i]);
				KeywordUtil.delay(1500);
				All_Indices_percentage_IA[i]=KeywordUtil.getElementText(By.xpath(MoneyControlAppPage.get_index_percentage_in_Investing_app));
				System.out.println(All_Indices_percentage_IA[i]);
				if(All_Indices_percentage_IA[i].contains(" "))
				{
					All_Indices_percentage_IA[i]=All_Indices_percentage_IA[i].split(" ")[1];
					All_Indices_percentage_IA[i]=All_Indices_percentage_IA[i].substring(2, All_Indices_percentage_IA[i].length()-2);
				}
				System.out.println(All_Indices_percentage_IA[i]);
				GlobalUtil.getMDriver().navigate().back();
				KeywordUtil.delay(1000);
				click(MoneyControlAppPage.back_in_Investing_app, MoneyControlAppPage.type_xpath);
			}
			else
			{
				KeywordUtil.takeMobileScreenshot(
						System.getProperty("user.dir")+"\\"+"ActiveByValueScreenShots\\Sample"+i+".png");
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
	public void user_clicks_in_IndianIndices()
	{
		MoneyControlAppPage.click_on_IndianIndices();
	}


	String all_indices_names[];
	String all_indices_dateTime[];
	String all_indices_values[];


	ArrayList<String> namesList = new ArrayList<String>();
	ArrayList<String> dateTimeList = new ArrayList<String>();
	ArrayList<String> valuesList = new ArrayList<String>();

	@And("^User gets all indices details$")
	public void user_gets_all_indices_details()
	{

		for(int k=0;k<5;k++)
		{
			List<AndroidElement> all_indices_list=GlobalUtil.getMDriver().findElements(By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout"));
			System.out.println("all indices list size is "+all_indices_list.size());

			all_indices_names=new String[all_indices_list.size()-1];
			all_indices_dateTime=new String[all_indices_list.size()-1];
			all_indices_values=new String[all_indices_list.size()-1];

			for(int i=0;i<all_indices_list.size()-1;i++)
			{
				if(MobileKeywords.isWebElementPresent("//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout[@index='"+(i+1)+"']/android.widget.LinearLayout/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='0']", MoneyControlAppPage.type_xpath))
				{
					all_indices_names[i]=GlobalUtil.getMDriver().findElement(By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout[@index='"+(i+1)+"']/android.widget.LinearLayout/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='0']")).getText();
					System.out.println("name is "+all_indices_names[i]);
					namesList.add(all_indices_names[i]);
				}
				KeywordUtil.delay(1000);

				if(MobileKeywords.isWebElementPresent("//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout[@index='"+(i+1)+"']/android.widget.LinearLayout/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='1']", MoneyControlAppPage.type_xpath))
				{
					all_indices_dateTime[i]=GlobalUtil.getMDriver().findElement(By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout[@index='"+(i+1)+"']/android.widget.LinearLayout/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='1']")).getText();
					System.out.println("date is "+all_indices_dateTime[i]);
					dateTimeList.add(all_indices_dateTime[i]);
				}
				KeywordUtil.delay(1000);
				if(MobileKeywords.isWebElementPresent("//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout[@index='"+(i+1)+"']/android.widget.LinearLayout/android.widget.LinearLayout//android.widget.TextView", MoneyControlAppPage.type_xpath))
				{
					all_indices_values[i]=GlobalUtil.getMDriver().findElement(By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout[@index='"+(i+1)+"']/android.widget.LinearLayout/android.widget.LinearLayout//android.widget.TextView")).getText();
					System.out.println("value is "+all_indices_values[i]);
					valuesList.add(all_indices_values[i]);
				}
				System.out.println();
			}
			System.out.println("individual getting is completed");
			System.out.println();
			MoneyControlAppPage.swipeVerticalBottom1();
			KeywordUtil.delay(3000);
		}

		System.out.println("total names are "+namesList.size());
		for (String name : namesList) { 		      
			System.out.println(name); 		
		}
		System.out.println();
		System.out.println();

		System.out.println("total names are "+dateTimeList.size());
		for (String name : dateTimeList) { 		      
			System.out.println(name); 		
		}
		System.out.println();
		System.out.println();

		System.out.println("total names are "+valuesList.size());
		for (String name : valuesList) { 		      
			System.out.println(name); 		
		}

	}

	String NSE_indices_names[];
	ArrayList<String> namesList_NSE = new ArrayList<String>();

	@And("^User gets indices list in NSE tab$")
	public void user_gets_indices_list_in_NSE_tab()
	{
		KeywordUtil.delay(2000);
		click(MoneyControlAppPage.NSE_tab_in_Allindices, MoneyControlAppPage.type_xpath);
		System.out.println("NSE clicked");
		for(int k=0;k<3;k++)
		{
			List<AndroidElement> all_indices_list=GlobalUtil.getMDriver().findElements(By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout"));
			System.out.println("NSE all indices list size is "+all_indices_list.size());

			NSE_indices_names=new String[all_indices_list.size()-1];


			for(int i=0;i<all_indices_list.size()-1;i++)
			{
				if(MobileKeywords.isWebElementPresent("//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout[@index='"+(i+1)+"']/android.widget.LinearLayout/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='0']", MoneyControlAppPage.type_xpath))
				{
					NSE_indices_names[i]=GlobalUtil.getMDriver().findElement(By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout[@index='"+(i+1)+"']/android.widget.LinearLayout/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='0']")).getText();
					System.out.println("name is "+NSE_indices_names[i]);
					namesList_NSE.add(NSE_indices_names[i]);
				}
				KeywordUtil.delay(1000);
				System.out.println();
			}
			System.out.println("individual getting is completed");
			System.out.println();
			MoneyControlAppPage.swipeVerticalBottom1();
			KeywordUtil.delay(3000);
		}

		System.out.println("total NSE names are "+namesList_NSE.size());
		for (String name : namesList_NSE) { 		      
			System.out.println(name); 		
		}
		System.out.println();



	}

	String BSE_indices_names[];
	ArrayList<String> namesList_BSE = new ArrayList<String>();

	@And("^User gets indices list in BSE tab$")
	public void user_gets_indices_list_in_BSE_tab()
	{
		KeywordUtil.delay(2000);
		click(MoneyControlAppPage.BSE_tab_in_Allindices, MoneyControlAppPage.type_xpath);
		System.out.println("BSE clicked");
		for(int k=0;k<2;k++)
		{
			List<AndroidElement> all_indices_list=GlobalUtil.getMDriver().findElements(By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout"));
			System.out.println("BSE all indices list size is "+all_indices_list.size());

			BSE_indices_names=new String[all_indices_list.size()-1];


			for(int i=0;i<all_indices_list.size()-1;i++)
			{
				if(MobileKeywords.isWebElementPresent("//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout[@index='"+(i+1)+"']/android.widget.LinearLayout/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='0']", MoneyControlAppPage.type_xpath))
				{
					BSE_indices_names[i]=GlobalUtil.getMDriver().findElement(By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout[@index='"+(i+1)+"']/android.widget.LinearLayout/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='0']")).getText();
					System.out.println("name is "+BSE_indices_names[i]);
					namesList_BSE.add(BSE_indices_names[i]);
				}
				KeywordUtil.delay(1000);
				System.out.println();
			}
			System.out.println("individual getting is completed");
			System.out.println();
			MoneyControlAppPage.swipeVerticalBottom1();
			KeywordUtil.delay(3000);
		}

		System.out.println("total BSE names are "+namesList_BSE.size());
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
				GlobalUtil.getMDriver().findElementByXPath(MoneyControlAppPage.Watchlist).getText();
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
				GlobalUtil.getMDriver().findElementByXPath(MoneyControlAppPage.Myportfolio).getText();
				break;
			} catch (Exception e) {
				swipeVerticalBottom();

			}
		swipeVerticalBottom();
		AndroidElement portfolio = GlobalUtil.getMDriver().findElementByXPath(MoneyControlAppPage.Create_newportfolio);

		if (portfolio.isDisplayed()) {
		
			RunCukesTest.logger.log(LogStatus.PASS, "<font color='blue'>+ " + portfolio.getText()
			+ "</font> display validation in Create new portfolio button in  Portfolio Section - Successful.");
		
		}
		else {
			RunCukesTest.logger.log(LogStatus.FAIL, "<font color='blue'>+ " + portfolio.getText()
			+ "</font> display validation in Create new portfolio button in  Portfolio Section - Fail.");
		}
	
	AndroidElement Signin_bt = GlobalUtil.getMDriver().findElementByXPath(MoneyControlAppPage.Signin_btn);

	if(GlobalUtil.getMDriver().findElementByXPath(MoneyControlAppPage.Signin_btn).isDisplayed())
	
		RunCukesTest.logger.log(LogStatus.PASS, "<font color='blue'>+ " + Signin_bt.getText()
				+ "</font> display validation in Signin button Portfolio Section - Successful.");

		else 
			RunCukesTest.logger.log(LogStatus.FAIL, "<font color='blue'>+ " + Signin_bt.getText()
			+ "</font> display validation in Create new portfolio button in  Portfolio Section - Fail.");
		
	
	} 
	@Then("^User Navigate to homepage and Refresh the page$")
	public void navigatetoHomepageandRefreshthepage() {
		KeywordUtil.delay(2000);
		MoneyControlAppPage.clickbackbtn();
		KeywordUtil.delay(2000);
		MoneyControlAppPage.clickbackbtn();
		KeywordUtil.delay(2000);
		MoneyControlAppPage.clickbackbtn();
		KeywordUtil.delay(2000);
		//GlobalUtil.getMDriver().navigate().refresh();
		//MobileKeywords.pageRefresh();
		
	}
	
	@Then("^User verifies Stocks Last Visited Section$")
	public void verifiesStocksLastVisitedSection()  {
		for (int i = 1; i <= 9; i++)
			try {
				GlobalUtil.getMDriver().findElementByXPath(MoneyControlAppPage.Stocklast_visited).getText();
				break;
			} catch (Exception e) {
				swipeVerticalBottom();

			}
		AndroidElement Stockname = GlobalUtil.getMDriver().findElementByXPath(MoneyControlAppPage.stockname);
		if(Stockname.isDisplayed())
		{	
			RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("<font color='blue'>+ " + Stockname.getText()
					+ "</font> display validation in Stocks in Stocks validation Section - Successful."));
			System.out.println(Stockname.getText()+" is displayed in Stocks Last Visited section");
		}
		else
		{	
			RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.passStringGreenColor("<font color='blue'>+ " + Stockname.getText()
			+ "</font> display validation in Stocks in Stocks validation Section - Fail."));
			System.out.println(Stockname.getText()+" is not displayed in Stocks Last Visited section");
		}
	}
	@Then("^User verifies the Stocks last visited with \"([^\"]*)\"$")
	public void user_verifies_stocks_last_visited_two_more_stocks(String stockname)
	{
		dataMap = ExcelDataUtil.getTestDataWithTestCaseID("MoneyControl", stockname);
		String[] stocksLastVisited=dataMap.get("StocksLastVisited").split("\n");
		for(int i=0;i<stocksLastVisited.length;i++)
		{
		user_click_on_searchbutton();
		MoneyControlAppPage.enterMcStock(stocksLastVisited[i]);
		navigatetoHomepageandRefreshthepage();
		verifiesStocksLastVisitedSection();
		}
		
	}
	

}
