package mcWebPages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import mobileutil.MobileKeywords;
import step_definitions.RunCukesTest;
import utilities.GlobalUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

public class MoneyControlAppPage extends MobileKeywords {

	public static final String type_xpath = "xPath";
	public static final String type_name = "name";
	public static final String type_id = "id";
	public static final String type_class = "classname";

	public static final String allow = "//*[@resource-id='com.android.packageinstaller:id/permission_allow_button']";
	public static String home_display = "//*[@resource-id='com.divum.MoneyControl:id/header_tittle_txt']";
	public static String homebutton = "//*[@text='Home']";
	public static String marketsbutton = "//*[@text='Markets']";
	public static String portfoliobutton = "//*[@text='Portfolio']";
	public static String newsbutton1 = "//*[@resource-id='com.divum.MoneyControl:id/bottomTabs']/android.widget.RelativeLayout[@index='3']";
	public static String menubutton1 = "//*[@resource-id='com.divum.MoneyControl:id/bottomTabs']/android.widget.RelativeLayout[@index='3']";
	public static String topnews_in_homepage ="//*[@text='Top News']";
	// *[@resource-id='com.divum.MoneyControl:id/nav_label'][@text='News']";

	public static String menubutton = "//android.widget.LinearLayout[@resource-id='com.divum.MoneyControl:id/bottomTabs']/android.widget.RelativeLayout[@index='4']";
	public static String newsbutton2 = "//*[@class='android.widget.RelativeLayout'][@index='4']";
	public static String myportfoliobutton = "//*[@text='My Portfolio']";
	public static String Opinion_tab = "//android.widget.TextView[@text='Opinion'][@index='4']";

	public static String loginwithfacebook = "//*[@resource-id='com.divum.MoneyControl:id/fbLogin']";
	public static String loginwithfacebook_text_display = "//*[@resource-id='m-future-page-header-title']";
	public static String facebook_text_display = "//*[@text='facebook']";
	public static String facebookusername = "//*[@resource-id='m_login_email'][@text='Mobile number or email address']";
	public static String facebookpassword = "//*[@resource-id='m_login_password'][@text='Facebook password']";
	public static String facebookloginbutton = "//*[@class='android.widget.Button'][@index='0']";
	public static String facebookcontinue = "//*[contains(@text,'Continue')]";
	public static String msg_1 = "//*[@resource-id='com.divum.MoneyControl:id/age_consent_chk']";
	public static String msg_2 = "//*[@resource-id='com.divum.MoneyControl:id/recommendation_adv_remarketting_consent_chk']";
	public static String msg_3 = "//*[@resource-id='com.divum.MoneyControl:id/marketting_communication_consent_chk']";
	public static String iaccept = "//*[@text='I ACCEPT']";

	public static String loginwithgoogle = "//*[@resource-id='com.divum.MoneyControl:id/googleLogin']";
	public static String useanotheraccount = "//*[@text='Use another account']";
	public static String chooseanaccount_text = "//*[@resource-id='com.google.android.gms:id/main_title']";
	public static String google_signin_text = "//*[@resource-id='headingText']";
	public static String googleemailorphone = "//*[@class='android.view.View'][@instance='9']";
	// *[@text='Login With google']";
	public static String googleemailnext = "//*[@resource-id='identifierNext']";
	public static String googlepassword = "//*[@resource-id='password']";
	public static String googlepasswordnext = "//*[@resource-id='passwordNext']";
	public static String googleagree = "//*[@text='I agree']";
	public static String googlemore = "//*[@text='MORE']";
	public static String googleaccept = "//*[@text='ACCEPT']";

	public static String useexistingaccount = "//*[@resource-id='com.google.android.gms:id/account_display_name']";

	public static String emailsignup = "//*[@text='Sign Up']";
	public static String signinwithemail = "//*[@text='SIGN UP WITH EMAIL']";
	public static String email_Firstname = "//*[@resource-id='com.divum.MoneyControl:id/registerFNameET']";
	public static String email_Lastname = "//*[@resource-id='com.divum.MoneyControl:id/registerLNameET']";
	public static String email_sampleemail = "//*[@resource-id='com.divum.MoneyControl:id/registerEmailET']";
	public static String email_password = "//*[@resource-id='com.divum.MoneyControl:id/registerPassET']";
	public static String email_signinbutton = "//*[@resource-id='com.divum.MoneyControl:id/signUp']";
	public static String email_verification_msg = "//*[@text='A verification email has been sent to']";
	public static String email_verification_maildisply = "//*[@resource-id='com.divum.MoneyControl:id/messageEmailLine']";
	public static String email_verification_heading = "//*[@text='Email Verification']";
	public static String email_verification_msg2 = "//*[@text='click the link in the verification email and verify your account.']";
	public static String emil_resend = "//*[@resource-id='com.divum.MoneyControl:id/resendMailTV']";

	public static String emailoruserid = "//*[@resource-id='com.divum.MoneyControl:id/loginEmailET']";
	// public static By
	// emailoruserid=By.xpath("//*[@resource-id='com.divum.MoneyControl:id/loginEmailET']");
	public static String emailpassword = "//*[@resource-id='com.divum.MoneyControl:id/loginePassET']";
	public static String emaillogin = "//*[@resource-id='com.divum.MoneyControl:id/loginBtn']";

	public static String portfolio_text_display = "//*[@text='Portfolio'][@index='0']";
	public static String portfolio_profile = "//*[@resource-id='com.divum.MoneyControl:id/header_user_icon_img']";
	public static String portfolio_profile_useremail = "//*[@resource-id='com.divum.MoneyControl:id/email_id']";
	public static String portfolio_profile_cancel = "//*[@text='Cancel']";
	public static String portfolio_profile_logout = "//*[@text='Logout']";

	public static String stocksoption = "//*[@text='Stocks'][@index='1']";
	public static String summary_option = "//*[@text='Summary'][@index='0']";

	public static String addstockssymbol = "//*[@resource-id='com.divum.MoneyControl:id/tvAdd'][@index='1']";
	public static String addstocks_text = "//*[@class='android.widget.TextView'][@instance='1']";
	public static String companyname = "//*[@resource-id='com.divum.MoneyControl:id/addstockrl']/android.widget.RelativeLayout[@index='4']";

	public static String investmentdate = "//*[@resource-id='com.divum.MoneyControl:id/iv_st_invt_date_cal']";
	public static String selectdate = "//*[@text='21']";
	//public static String OK = "//*[@text='OK']";
	public static String OK = "//*[@class='android.widget.Button'][@text='OK']";





	public static String OK1 = "//*[@class='android.widget.Button']";
	public static String OK2 = "//*[@resource-id='com.divum.MoneyControl:id/btnExit']";
	//public static String OK3 = "//*[@class='android.widget.FrameLayout']";
	public static String please_enter_stock_name = "//*[@text='Please enter Stock Name']";

	public static String quantity = "//*[@resource-id='com.divum.MoneyControl:id/edt_st_qty']";
	public static String savestock_button = "//*[@resource-id='com.divum.MoneyControl:id/btnAddStock']";
	public static String stockadded = "//*[@text='Stock Added.']";
	public static String stocksafteradded = "//*[@resource-id='com.divum.MoneyControl:id/tv_item_investments']";
	public static String stocksafteraddedframe = "//*[@resource-id='com.divum.MoneyControl:id/nomatchrl']";

	public static String mutualfunds_option = "//*[@text='Mutual Funds'][@index='2']";
	public static String one_time_option = "//*[@resource-id='com.divum.MoneyControl:id/opt1txt']";
	public static String enter_scheme_name_mutualfunds = "//*[@resource-id='com.divum.MoneyControl:id/edt_mf_schm_name']";
	public static String investment_date_mutualfunds = "//*[@resource-id='com.divum.MoneyControl:id/iv_mf_invt_date_cal']";
	public static String investment_amount_mutualfunds = "//*[@resource-id='com.divum.MoneyControl:id/edt_mf_invt_amt']";
	public static String savestock_option__mutualfunds = "//*[@resource-id='com.divum.MoneyControl:id/btnAddMutualFund']";
	public static String scheme_added_mutualfunds = "//*[@text='Scheme Added.']";

	public static String ULIP_option = "//*[@text='ULIP'][@index='3']";
	public static String ULIP_enter_scheme_name = "//*[@resource-id='com.divum.MoneyControl:id/edt_mf_schm_name']";
	public static String ULIP_investmentdate_select = "//*[@resource-id='com.divum.MoneyControl:id/iv_mf_invt_date_cal']";
	public static String ULIP_quantity = "//*[@resource-id='com.divum.MoneyControl:id/edt_mf_units']";
	public static String ULIP_savescheme = "//*[@resource-id='com.divum.MoneyControl:id/btnAddMutualFund']";
	public static String ULIP_scheme_added = "//*[@text='Ulip Added.']";

	public static String Bullion_option = "//*[@text='Bullion'][@index='4']";
	public static String Bullion_select_silver = "//*[@resource-id='com.divum.MoneyControl:id/iv_bullion_metals_silver']";
	public static String Bullion_enter_quantity = "//*[@resource-id='com.divum.MoneyControl:id/edt_bullion_qty']";
	public static String Bullion_investmentdate_select = "//*[@resource-id='com.divum.MoneyControl:id/iv_bullion_invst_date_cal']";
	public static String Bullion_savescheme = "//*[@resource-id='com.divum.MoneyControl:id/btnAddBullion']";

	public static String Networth = "//*[@resource-id='com.divum.MoneyControl:id/tvNetWorthValue']";

	public static String closeadd = "//*[@content-desc='Interstitial close button']";
	// *[@class='android.widget.FrameLayout'][@index=1]
	public static String closeadd1 = "//*[@resource-id='android:id/content']/android.widget.RelativeLayout/android.view.View[@index='2']";

	public static String my_watchlist = "//*[@resource-id='com.divum.MoneyControl:id/menuName'][@instance='17']";
	public static String watchlist_stocks = "//*[@text='Stocks'][@index='0']";
	public static String watchlist_addstocks_symbol = "//*[@resource-id='com.divum.MoneyControl:id/tvAddWatchList'][@index='1']";
	// *[@resource-id='com.divum.MoneyControl:id/tvAddWatchList'][@instance='2']
	public static String watchlist_stocks_select = "//*[@resource-id='com.divum.MoneyControl:id/opt1txt']";
	public static String watchlist_text_display = "//*[@resource-id='com.divum.MoneyControl:id/tvWlTitle']";
	public static String enter_stockname_in_watchlist = "//android.widget.EditText[@text='Search']";
	public static String enter_stockname_in_watchlist1 = "// android.widget.EditText[@resource-id='com.divum.MoneyControl:id/edt_st_cmp_name']";
	public static String enter_stockname_in_watchlist2 = "// android.widget.FrameLayout[@resource-id='com.divum.MoneyControl:id/fragmentcontainer']/android.widget.RelativeLayout/android.widget.RelativeLayout[@index='1']/android.widget.EditText";

	public static String suggesed_stockname = "//*[@resource-id='com.divum.MoneyControl:id/search_item_name']";
	// *[@resource-id='com.divum.MoneyControl:id/addstockrl']/descendant::android.widget.TextView
	public static String suggesed_stockname1 = "//*[@resource-id='com.divum.MoneyControl:id/autosuggrl']";
	public static String suggesed_stockname2 = "//*[@resource-id='com.divum.MoneyControl:id/autosuggrl']/android.widget.ListView/android.widget.LinearLayout/android.widget.TextView";
	public static String suggesed_stockname3 = "//*[@resource-id='com.divum.MoneyControl:id/autosuggrl']";

	public static String stockadded_message = "//*[@class='android.widget.TextView'][@resource-id='com.divum.MoneyControl:id/search_item_name']";
	public static String stock_added_done = "//*[@text='DONE']";
	public static String watchlist_addedstocks_list_frame = "//*[@resource-id='com.divum.MoneyControl:id/pager']";
	public static String watchlist_addedstocks_list = "//*[@resource-id='com.divum.MoneyControl:id/tvWlItemName'][@instance='10']";
	// public static String
	// watchlist_addedstocks_list="//*[@resource-id='android:id/list']/android.widget.RelativeLayout[@index='1']";

	public static String stocks_option_in_watchlist = "//*[@text='Stocks'][@index='0']";
	public static String mutualfunds_option_in_watchlist = "//*[@text='Mutual Funds'][@index='1']";
	public static String commodities_option_in_watchlist = "//*[@text='Commodities'][@index='2']";
	public static String futures_option_in_watchlist = "//*[@text='Futures'][@index='3']";
	public static String currencies_option_in_watchlist = "//*[@text='Currencies'][@index='4']";

	public static String ETcancel = "//*[@resource-id='com.et.reader.activities:id/rating_close']";
	public static String ETlater = "//*[@resource-id='com.et.reader.activities:id/btn_later']";

	public static TouchAction ta = new TouchAction(GlobalUtil.getMDriver());

	public static String money_control_pro = "//*[@text='Moneycontrol Pro']";
	public static String users_Profile = "//*[@resource-id='com.divum.MoneyControl:id/header_user_icon_img']";
	public static String pro_user_ID = "//*[@resource-id='com.divum.MoneyControl:id/loginEmailET']";
	public static String pro_user_password = "//*[@resource-id='com.divum.MoneyControl:id/loginePassET']";
	public static String pro_user_alert_OK_bt = "//*[@text='OK']";
	public static String pro_user_login_button = "//*[@text='LOGIN']";

	// asserts1
	public static String menu_Title = "//*[contains(@text,'Moneycontrol Pro')]";
	public static String moneycontrolpro = "//*[text()='LIMITED PERIOD OFFER!']";
	public static String profile_iconn = "//*[text()='Login']";
	public static String moneycontrol_pro_login = "//*[text()='Home']";
	public static String non_pro_user_adds = "//*[@class='android.widget.RelativeLayout'][@index='0']";

	public static String search_bt = "//*[@resource-id='com.divum.MoneyControl:id/header_search_icon']";
	// public static String
	// search_text_enter="//*[@resource-id='com.divum.MoneyControl:id/getQuote_editSearchBox']";
	public static String search_text_enter = "//*[@class='android.widget.EditText']";
	public static String Click_stackname_tab = "//*[@class='android.widget.TextView'][@instance='0']";
	public static String mcw_stack_value = "//*[@resource-id='com.divum.MoneyControl:id/tv_stock_value'][@index='1']";

	public static String App_list_tab = "//*[@accessibility id='Apps list']";
	// public static String add_stack_nm = "//*[text()='ADD']";

	public static String add_stack_nm = "//*[@resource-id='com.adore.stock:id/add_button'][@instance='0']";
	// public static String input_text = "//*[text()='Input Symbol']";

	public static String input_text = "//*[@bounds='[15,1502][801,1605]']";
	public static String add_stack_nm1 = "//*[@resource-id='com.adore.stock:id/watch_add_symbols_button'][@index='1']";
	public static String nscw_stack_value = "//*[@resource-id='com.adore.stock:id/current'][@instance='6']";
	public static String Et_search_bt_1 = "//*[@resource-id='com.et.reader.activities:id/action_search'][@index='2']";
	public static String Et_search_bt_2 = "//*[@resource-id='com.et.reader.activities:id/action_search']";
	public static String Enter_et_text = "//*[@resource-id='com.et.reader.activities:id/search_src_text']";
	public static String et_text = "//*[@class='android.widget.TextView'][@index='0']";
	public static String click_et_text = "//*[@resource-id='com.et.reader.activities:id/companyName']";

	public static String nsc_Stack_app = "//*[@text='NSEMobile']";
	public static String nsc_Stocks_app = "//*[@text='NSE Stocks']";
	public static String marketdata = "//*[@text='Market Data']";
	public static String nsequotes = "//android.widget.GridView[@resource-id='com.msf.nse:id/homeGrid']/android.widget.LinearLayout[@index='0']";
	public static String et_Stack_app = "//*[@text='ET']";

	public static String get_et_text_value = "//*[@resource-id='com.et.reader.activities:id/lastTradedValue']";
	public static String pro_user_indices = "//*[text()='Indices']";
	public static String Overview = "//*[@text='Overview']";
	public static String nsc_symbol = "//*[@text='SYMBOL']";
	public static String et_page = "//*[@text='RESEARCH MARKET TREND']";
	public static String pro_user_home_content = "//*[@resource-id='com.divum.MoneyControl:id/coordinatorLayout']";
	public static String pro_user_clickprofile = "//*[@resource-id='com.divum.MoneyControl:id/header_user_icon_img']";
	public static String pro_user_click_logout = "//*[@text='Logout']";

	public static String Markts_tab = "//*[@resource-id='com.divum.MoneyControl:id/bottomTabs']/android.widget.RelativeLayout[@index='1']";
	// *[@resource-id='com.divum.MoneyControl:id/nav_label'][@text='Markets']";

	public static final String Topgainers = "//*[@resource-id='com.divum.MoneyControl:id/tabs']/android.widget.LinearLayout/android.widget.TextView[@index='0']";
	// *[@text='Top Gainers']";

	public static final String top_gainer_text = "//*[@resource-id = 'com.divum.MoneyControl:id/tv_home_item_change'][@index='1']";
	public static final String top_looser_text = "//*[@resource-id = 'com.divum.MoneyControl:id/tv_home_item_change'][@index='1']";
	public static final String Top_losers = "//*[@text='Top Losers'][@index='1']";

	public static String absoluteValue = "";
	public static String percentageValue = "";
	public static String absoluteValue2 = "";
	public static String percentageValue2 = "";
	public static String absoluteValue3 = "";
	public static String percentageValue3 = "";
	public static String absoluteValue4 = "";
	public static String percentageValue4 = "";
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
	public static Float mcPercentage;
	public static Float nsePercentage;
	public static Float etPercentage;
	public static Float Diff_Between_MC_nad_NSC;
	public static Float Diff_Between_MC_nad_ET;
	public static String mcDiffandPer = "//*[@resource-id='com.divum.MoneyControl:id/tv_stock_change'][@index='5']";
	public static String mcprevclose = "//android.widget.LinearLayout[@resource-id='com.divum.MoneyControl:id/ll_bid_price_overview']/android.view.ViewGroup[@index='2']/android.widget.TextView[@index='1']";
	//public static String nse_search1 = "//*[@resource-id='com.msf.nse:id/equity_edit'][@index='1']";
	//public static String Nse_current_price = "//android.widget.TextView[@resource-id='com.msf.nse:id/last'][@index='0']";
	public static String Nse_Diff_perc = "//android.widget.TextView[@resource-id='com.msf.nse:id/change'][@index='1']";
	//public static String Nse_prev_value = "//android.widget.TableLayout[@resource-id='com.msf.nse:id/row_details']/android.widget.TableRow[@index='10']/android.widget.TextView[@index='1']";
	public static String ncebackclick = "//android.widget.Button[@resource-id='android:id/button3'][@index='0']";
	public static String et_Diff_value = "//android.widget.LinearLayout[@resource-id='com.et.reader.activities:id/llTradedValue'][@index='2']/android.widget.RelativeLayout/android.widget.TextView[@index='1']";
	public static String et_Percentage_value = "//android.widget.LinearLayout[@resource-id='com.et.reader.activities:id/llTradedValue'][@index='2']/android.widget.RelativeLayout/android.widget.TextView[@index='2']";
	public static String et_prevclose_value = "//*[@resource-id='com.et.reader.activities:id/prevCloseValue'][@index='4']";
	public static String searchbt = "//*[@text='Search']";
	public static String relianceeq = "//*[@text='RELIANCE-EQ']";
	public static String sbin_eq = "//*[@text='SBIN-EQ']";
	public static String tcs_eq = "//*[@text='TCS-EQ']";
	public static String infosys_eq = "//*[@text='INFY-EQ']";
	public static String yesBank_eq = "//*[@text='YESBANK-EQ']";
	public static String NonproAdds = "//*[@resource-id='aw0'][@instance='1']";
	public static final String notificationTitles = "//*[@class='android.widget.TextView'][@resource-id = 'com.android.systemui:id/notification_title' and @text='ET']";
	public static final String Activeby_value = "//android.widget.HorizontalScrollView[@resource-id='com.divum.MoneyControl:id/tabs']/android.widget.LinearLayout/android.widget.TextView[@index='2']";
	public static String click_nse_search = "//*[@resource-id='android:id/search_button']";
	public static String nse_search1 = "//android.widget.EditText[@ resource-id='android:id/search_src_text']";
	public static String Nse_current_price = "//android.widget.TextView[@resource-id='in.tazone.nsestocks:id/ltp'][@index='2']";
	public static String Nse_Diff = "//android.widget.TextView[@resource-id='in.tazone.nsestocks:id/change'][@index='5']";
	public static String Nse_perc = "//android.widget.TextView[@resource-id='in.tazone.nsestocks:id/change_perc'][@index='6']";
	public static String Nse_prev_value = "//android.widget.TextView[@resource-id='in.tazone.nsestocks:id/prev_close'][@index='3']";
	public static String nse_click_tap = "//*[@resource-id='in.tazone.nsestocks:id/value_container']";
	//*[@class='android.view.ViewGroup'][@instance='2']";

	/////////////********************* For New Test Cases ***************///////////////
	public static String Investing_app="//*[@class='android.widget.TextView'][@text='Investing']";
	public static String search_in_Investing_app="//*[@resource-id='com.fusionmedia.investing:id/action_item_3']";
	public static String enter_index_in_Investing_app="//*[@resource-id='com.fusionmedia.investing:id/menuSearchEditText']";
	public static String get_index_value_in_Investing_app="//*[@resource-id='com.fusionmedia.investing:id/instrumentValue']";
	public static String get_index_percentage_in_Investing_app="//*[@resource-id='com.fusionmedia.investing:id/instrumentDataChange']";
	public static String back_in_Investing_app="//*[@resource-id='com.fusionmedia.investing:id/action_item_1']";
	public static String Indices_in_homepage="//*[@resource-id='com.divum.MoneyControl:id/linear_tray_header'][@text='Indices']";
	public static String Indian_Indices_in_homepage="//*[@resource-id='com.divum.MoneyControl:id/rv_linear_tray']/android.view.ViewGroup[@index='0']/android.view.ViewGroup/android.widget.TextView[@index='0']";
	//android.widget.TextView[@resource-id='com.divum.MoneyControl:id/tv_market_data_heading'][@text='INDIAN INDICES'][@index='0']";
	public static String TopNews_heading_homepage="//android.widget.TextView[@resource-id='com.divum.MoneyControl:id/linear_tray_header'][@text='Top News'][@index='0']";
	public static String Top_News_page_text="//*[@text='Top News']";
	public static String All_indices_text="//*[@text='All Indices']";
	public static String NSE_tab_in_Allindices="//android.widget.TextView[@text='NSE']";
	public static String BSE_tab_in_Allindices="//android.widget.TextView[@text='BSE']";
	
	public static final String Myportfolio="//*[@text='My Portfolio']";

	public static final String Watchlist="//*[@text='My Portfolio']";

	public static String Create_newportfolio="//*[@resource-id='com.divum.MoneyControl:id/btn_create']";

	public static String Signin_btn="//*[@resource-id='com.divum.MoneyControl:id/btn_sign_in']";
	public static final String  Stocklast_visited="//*[@text='Commodities and Currencies']";
	public static String back_btn="//*[@resource-id='com.divum.MoneyControl:id/back_button']";
	public static final String stockname="//*[@resource-id='com.divum.MoneyControl:id/tv_indices_name']";


	public static WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), 10);

	public static void clickMenuTab() {
		try {
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(menubutton)));
			//explicitWaitForElementforGivenTime(menubutton, type_xpath, 10);
			KeywordUtil.delay(2000);
			click(menubutton, type_xpath);

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	public static void click_profileicon() {
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
			String text=GlobalUtil.getMDriver().findElement(By.xpath("//android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.TextView[@instance='2']")).getText();
			System.out.println("text is : "+text);
			if((text.contains("Opinion"))!=true)
			{
				if(MobileKeywords.isWebElementPresent(Opinion_tab, type_xpath))
				{
					click(Opinion_tab, type_xpath);
					System.out.println("2");
				}
			}
			if(MobileKeywords.isWebElementPresent(Opinion_tab, type_xpath))
			{
				click(Opinion_tab, type_xpath);
				System.out.println("2");
			}
			KeywordUtil.delay(4000);
			/*KeywordUtil.delay(1000);
			if((GlobalUtil.getMDriver().findElement(By.xpath(Opinion_tab)).isDisplayed())!=true)
			{
				clickMenuTab();
				clickmyportfolio();
				click_News_Tab();
				KeywordUtil.delay(1000);
				click(Opinion_tab, type_xpath);
				System.out.println("3");
			}*/
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

	public static void accept_messages() {
		// KeywordUtil.delay(2000);
		try {
			if (KeywordUtil.isWebElementPresent(msg_1, type_xpath)) {
				Assert.assertEquals(
						GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.iaccept)).getText(),
						"I ACCEPT", "consent messages are visible");
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
			if (MobileKeywords.isWebElementPresent(MoneyControlAppPage.closeadd, MoneyControlAppPage.type_xpath)) {
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.closeadd)).click();
				KeywordUtil.delay(1000);
				ta.tap(576, 147).perform();
			}
			List<AndroidElement> news_list = GlobalUtil.getMDriver().findElements(
					By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.view.ViewGroup"));
			// System.out.println("news_list size is " + news_list.size());
			int num = 0;
			for (int i = 0; i < news_list.size(); i++) {
				try {
					num = i + 1;
					//System.out.println("11");
					if (MobileKeywords
							.isWebElementPresent(
									"//android.widget.ListView[@resource-id='android:id/list']/android.view.ViewGroup[@index='"
											+ num + "']//android.widget.LinearLayout/android.widget.ImageView",
											type_xpath)) {
						//System.out.println("12");
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
						ta.press(500, 1600).moveTo(500, 1450).release().perform();
						KeywordUtil.delay(2000);
						check_news_content();
						ta.press(500, 1600).moveTo(500, 1450).release().perform();
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

		List<AndroidElement> news_list = GlobalUtil.getMDriver().findElements(
				By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.view.ViewGroup"));
		//System.out.println("news_list size is " + news_list.size());
		int num = 0;
		for (int i = 0; i < news_list.size(); i++) {
			try {
				num = i + 1;
				//System.out.println("11");
				if (MobileKeywords
						.isWebElementPresent(
								"//android.widget.ListView[@resource-id='android:id/list']/android.view.ViewGroup[@index='"
										+ num + "']//android.widget.LinearLayout/android.widget.ImageView",
										type_xpath)) {
					//System.out.println("12");
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
					ta.press(500, 1600).moveTo(500, 1450).release().perform();
					check_news_content();
					ta.press(500, 1600).moveTo(500, 1450).release().perform();
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
				Assert.assertEquals(
						GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.emailsignup)).getText(),
						"Sign Up", "Sign Up link is visible");
				RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Sign Up link is visible"));
				GlobalUtil.getMDriver().findElement(By.xpath(emailsignup)).click();
				break;
			} catch (Exception e) {
				TouchAction ta = new TouchAction(GlobalUtil.getMDriver());

				ta.press(600, 1300).moveTo(600, 1200).release().perform();
				KeywordUtil.delay(3000);
			}
		}

	}

	public static void click_SignupwithEmail() {
		GlobalUtil.getMDriver().hideKeyboard();
		while (2 > 1) {
			try {

				Assert.assertEquals(
						GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.signinwithemail)).getText(),
						"SIGN UP WITH EMAIL", "Sign Up with email link is visible");
				RunCukesTest.logger.log(LogStatus.PASS,
						HTMLReportUtil.passStringGreenColor("Sign Up with email link is visible"));
				GlobalUtil.getMDriver().findElement(By.xpath(signinwithemail)).click();
				break;
			} catch (Exception e) {
				TouchAction ta = new TouchAction(GlobalUtil.getMDriver());

				ta.press(600, 1300).moveTo(600, 1200).release().perform();
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
			Assert.assertEquals(GlobalUtil.getMDriver()
					.findElement(By.xpath(MoneyControlAppPage.email_verification_msg)).isDisplayed(), true);
		} catch (Exception e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}
	public static void click_OK()
	{
		if (KeywordUtil.isWebElementPresent(MoneyControlAppPage.OK, MoneyControlAppPage.type_xpath)) {
			GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.OK)).click();
		}
		KeywordUtil.delay(1000);
		if (KeywordUtil.isWebElementPresent(MoneyControlAppPage.OK1, MoneyControlAppPage.type_xpath)) {
			GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.OK1)).click();
		}
		KeywordUtil.delay(1000);
		if (KeywordUtil.isWebElementPresent(MoneyControlAppPage.OK2, MoneyControlAppPage.type_xpath)) {
			GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.OK2)).click();
		}
	}
	public static void do_facebook_login(String facebookemail, String facebookpassword) {
		try {
			KeywordUtil.delay(3000);
			if (KeywordUtil.isWebElementPresent(MoneyControlAppPage.facebookusername, MoneyControlAppPage.type_xpath)) {
				Assert.assertEquals(GlobalUtil.getMDriver()
						.findElement(By.xpath(MoneyControlAppPage.facebook_text_display)).getText(), "facebook",
						"facebook login page is displayed");
				RunCukesTest.logger.log(LogStatus.PASS,
						HTMLReportUtil.passStringGreenColor("facebook login page is displayed"));
				KeywordUtil.delay(2000);
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.facebookusername))
				.sendKeys(facebookemail);
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.facebookpassword))
				.sendKeys(facebookpassword);
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.facebookloginbutton)).click();
			}
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(facebookcontinue)));
			explicitWaitForElementforGivenTime(MoneyControlAppPage.facebookcontinue, MoneyControlAppPage.type_xpath,
					20);
			GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.facebookcontinue)).click();
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

			explicitWaitForElementforGivenTime(MoneyControlAppPage.googleemailorphone, MoneyControlAppPage.type_xpath,
					20);
			Assert.assertEquals(
					GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.google_signin_text)).getText(),
					"Sign in", "Signin page is displayed");
			RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Signin page is displayed"));
			GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.googleemailorphone)).sendKeys(googleemail);

			explicitWaitForElementforGivenTime(MoneyControlAppPage.googleemailnext, MoneyControlAppPage.type_xpath, 10);
			GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.googleemailnext)).click();

			explicitWaitForElementforGivenTime(MoneyControlAppPage.googlepassword, MoneyControlAppPage.type_xpath, 20);
			GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.googlepassword)).sendKeys(googlepassword);

			explicitWaitForElementforGivenTime(MoneyControlAppPage.googlepasswordnext, MoneyControlAppPage.type_xpath,
					10);
			GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.googlepasswordnext)).click();

			explicitWaitForElementforGivenTime(MoneyControlAppPage.googleagree, MoneyControlAppPage.type_xpath, 10);
			GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.googleagree)).click();

			explicitWaitForElementforGivenTime(MoneyControlAppPage.googlemore, MoneyControlAppPage.type_xpath, 10);
			GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.googlemore)).click();

			explicitWaitForElementforGivenTime(MoneyControlAppPage.googleaccept, MoneyControlAppPage.type_xpath, 10);
			GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.googleaccept)).click();
		} catch (Exception ex) {
			Assert.assertEquals(
					GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.chooseanaccount_text)).getText(),
					"Choose an account", "Choose an account page is displayed");
			RunCukesTest.logger.log(LogStatus.PASS,
					HTMLReportUtil.passStringGreenColor("Choose an account page is displayed"));
			GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.useexistingaccount)).click();
		}

	}

	public static void verify_loginpage(String email) {
		try {
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(portfolio_profile)));
			explicitWaitForElementforGivenTime(MoneyControlAppPage.portfolio_profile, MoneyControlAppPage.type_xpath,
					10);
			GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.portfolio_profile)).click();

			String useremail_name = GlobalUtil.getMDriver()
					.findElement(By.xpath(MoneyControlAppPage.portfolio_profile_useremail)).getText();
			if (useremail_name.contains(email)) {
				System.out.println("User emailid is verified");
			}

			Assert.assertEquals(GlobalUtil.getMDriver()
					.findElement(By.xpath(MoneyControlAppPage.portfolio_profile_useremail)).getText().contains(email),
					true);
			RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user email is verified"));

			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(portfolio_profile_logout)));
			explicitWaitForElementforGivenTime(MoneyControlAppPage.portfolio_profile_logout,
					MoneyControlAppPage.type_xpath, 10);
			WebElement a = GlobalUtil.getMDriver().findElementByXPath(MoneyControlAppPage.portfolio_profile_logout);
			TouchAction act = new TouchAction(GlobalUtil.getMDriver());
			act.tap(a).release().perform();

			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(portfolio_profile)));
			explicitWaitForElementforGivenTime(MoneyControlAppPage.portfolio_profile, MoneyControlAppPage.type_xpath,
					10);
			GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.portfolio_profile)).click();
			if (GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.loginwithfacebook)).isDisplayed()) {
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
			explicitWaitForElementforGivenTime(MoneyControlAppPage.portfolio_profile, MoneyControlAppPage.type_xpath,
					10);
			GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.portfolio_profile)).click();
			// explicitWaitForElementforGivenTime(MoneyControlAppPage.portfolio_profile_logout,
			// MoneyControlAppPage.type_xpath,10);
			WebElement a = GlobalUtil.getMDriver().findElementByXPath(MoneyControlAppPage.portfolio_profile_logout);
			TouchAction act = new TouchAction(GlobalUtil.getMDriver());
			act.tap(a).release().perform();
			explicitWaitForElementforGivenTime(MoneyControlAppPage.portfolio_profile, MoneyControlAppPage.type_xpath,
					15);
			GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.portfolio_profile)).click();
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
				// explicitWaitForElementforGivenTime(MoneyControlAppPage.addstockssymbol,
				// MoneyControlAppPage.type_xpath, 10);
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.addstockssymbol)).click();

				// Assert.assertEquals(GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.addstocks_text)).getText(),
				// "ADD STOCKS","Add Stocks page display is verified");

				WebElement a = GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.companyname));
				a.sendKeys(stock_list[i]);

				// KeywordUtil.delay(1000);
				if (MobileKeywords.isWebElementPresent(MoneyControlAppPage.closeadd, MoneyControlAppPage.type_xpath)) {
					GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.closeadd)).click();
					KeywordUtil.delay(1000);
					ta.tap(576, 147).perform();

					a.clear();
					a.sendKeys(stock_list[i]);
				}

				KeywordUtil.delay(3000);
				int x= a.getLocation().getX();
				int y= a.getLocation().getY();
				int h= a.getSize().getHeight();
				int w=a.getSize().getWidth();
				//System.out.println("x is : "+x+" y is : "+y+" h is : "+h+" w is: "+w);
				TouchAction t = new TouchAction(GlobalUtil.getMDriver());
				//t.tap(230, 806).perform();
				t.tap(x+h, y+h+50).perform();
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.investmentdate)).click();

				for (int j = 1; j <= 10; j++) {

					if (MobileKeywords.isWebElementPresent(MoneyControlAppPage.please_enter_stock_name,
							MoneyControlAppPage.type_xpath)) {
						System.out.println(j);
						GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.OK)).click();
						a.clear();
						KeywordUtil.delay(1000);
						a.sendKeys(stock_list[i]);
						KeywordUtil.delay(2000);
						t.tap(x+h+j*30, y+h+50+j*3).perform();
						GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.investmentdate)).click();
					}

				}
				explicitWaitForElementforGivenTime(MoneyControlAppPage.OK, MoneyControlAppPage.type_xpath, 10);
				// GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.selectdate)).click();
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.OK)).click();

				GlobalUtil.getMDriver().hideKeyboard();
				KeywordUtil.delay(3000);
				if (MobileKeywords.isWebElementPresent(MoneyControlAppPage.closeadd, MoneyControlAppPage.type_xpath)) {
					GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.closeadd)).click();
					KeywordUtil.delay(1000);
					ta.tap(576, 147).perform();

				}
				explicitWaitForElementforGivenTime(MoneyControlAppPage.quantity, MoneyControlAppPage.type_xpath, 10);
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.quantity)).sendKeys("2");

				GlobalUtil.getMDriver().hideKeyboard();
				explicitWaitForElementforGivenTime(MoneyControlAppPage.savestock_button, MoneyControlAppPage.type_xpath,
						10);
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.savestock_button)).click();

				explicitWaitForElementforGivenTime(MoneyControlAppPage.stockadded, MoneyControlAppPage.type_xpath, 10);
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.OK)).click();

				KeywordUtil.delay(1000);
				if (MobileKeywords.isWebElementPresent(MoneyControlAppPage.closeadd, MoneyControlAppPage.type_xpath)) {
					GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.closeadd)).click();
					KeywordUtil.delay(1000);
					ta.tap(576, 147).perform();
				}

				explicitWaitForElementforGivenTime(MoneyControlAppPage.stocksoption, MoneyControlAppPage.type_xpath,
						10);
			}
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void add_stocks_to_profile(String stockname) {
		try {
			explicitWaitForElementforGivenTime(MoneyControlAppPage.stocksoption, MoneyControlAppPage.type_xpath, 10);

			Assert.assertEquals(
					GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.stocksoption)).getText(), "Stocks",
					"Stocks link is visibility is verified");
			GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.stocksoption)).click();

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
			List<AndroidElement> list3 = GlobalUtil.getMDriver()
					.findElements(By.xpath("//*[@resource-id='android:id/list']/android.widget.LinearLayout"));
			System.out.println("elements list size is " + list3.size());
			System.out.println();
			for (int i = 1; i < list3.size(); i++) {
				if(MobileKeywords.isWebElementPresent("//*[@resource-id='android:id/list']/android.widget.LinearLayout[@index='" + i
										+ "']/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[@index='0']", type_xpath))
				{
				String stock_name = GlobalUtil.getMDriver()
						.findElement(
								By.xpath("//*[@resource-id='android:id/list']/android.widget.LinearLayout[@index='" + i
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
			List<AndroidElement> list3 = GlobalUtil.getMDriver()
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
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.addstockssymbol)).click();
				KeywordUtil.delay(1000);
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.one_time_option)).click();
				KeywordUtil.delay(1000);
				AndroidElement a=GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.enter_scheme_name_mutualfunds));
				a.sendKeys(mutualfunds_list[i]);
				KeywordUtil.delay(2000);
				int x= a.getLocation().getX();
				int y= a.getLocation().getY();
				int h= a.getSize().getHeight();
				int w=a.getSize().getWidth();
				//System.out.println("x is : "+x+" y is : "+y+" h is : "+h+" w is: "+w);
				TouchAction t = new TouchAction(GlobalUtil.getMDriver());
				//t.tap(230, 806).perform();

				t.tap(x+h, y+h+50).perform();
				//ta.tap(230, 806).perform();
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.investment_date_mutualfunds)).click();
				KeywordUtil.delay(1000);
				explicitWaitForElementforGivenTime(MoneyControlAppPage.OK, MoneyControlAppPage.type_xpath, 10);
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.OK)).click();
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.investment_amount_mutualfunds))
				.sendKeys("1000");
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.savestock_option__mutualfunds))
				.click();
				KeywordUtil.delay(2000);
				explicitWaitForElementforGivenTime(MoneyControlAppPage.OK, MoneyControlAppPage.type_xpath, 10);
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.OK)).click();
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
			GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.mutualfunds_option)).click();
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
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.addstockssymbol)).click();
				KeywordUtil.delay(2000);

				AndroidElement a=GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.ULIP_enter_scheme_name));
				a.sendKeys(ULIPs_list[i]);
				KeywordUtil.delay(3000);
				int x= a.getLocation().getX();
				int y= a.getLocation().getY();
				int h= a.getSize().getHeight();
				int w=a.getSize().getWidth();
				//System.out.println("x is : "+x+" y is : "+y+" h is : "+h+" w is: "+w);
				TouchAction t = new TouchAction(GlobalUtil.getMDriver());
				t.tap(x+h, y+h+50).perform();
				//ta.tap(230, 806).perform();
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.ULIP_investmentdate_select)).click();
				explicitWaitForElementforGivenTime(MoneyControlAppPage.OK, MoneyControlAppPage.type_xpath, 10);
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.OK)).click();
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.ULIP_quantity)).sendKeys("2");
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.ULIP_savescheme)).click();
				KeywordUtil.delay(2000);
				explicitWaitForElementforGivenTime(MoneyControlAppPage.OK, MoneyControlAppPage.type_xpath, 10);
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.OK)).click();
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
			GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.ULIP_option)).click();
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
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.addstockssymbol)).click();
				KeywordUtil.delay(1000);
				if (i == 3) {
					GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.Bullion_select_silver)).click();
					KeywordUtil.delay(1000);
				}
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.Bullion_enter_quantity))
				.sendKeys(Bullions_list[i]);
				KeywordUtil.delay(2000);
				//ta.tap(230, 806).perform();
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.Bullion_investmentdate_select))
				.click();
				explicitWaitForElementforGivenTime(MoneyControlAppPage.OK, MoneyControlAppPage.type_xpath, 10);
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.OK)).click();
				KeywordUtil.delay(1000);
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.Bullion_savescheme)).click();
				KeywordUtil.delay(2000);
				explicitWaitForElementforGivenTime(MoneyControlAppPage.OK, MoneyControlAppPage.type_xpath, 10);
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.OK)).click();
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
			GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.Bullion_option)).click();
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
		explicitWaitForElementforGivenTime(MoneyControlAppPage.summary_option, MoneyControlAppPage.type_xpath, 10);
		GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.summary_option)).click();
		user_verifies_stocknames(stockname);
	}

	public static float user_verifies_investment_amounts() {
		float total_investment = 0;
		try {
			KeywordUtil.delay(2000);
			List<AndroidElement> list = GlobalUtil.getMDriver()
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
			//System.out.println("stock_list size is " + stock_list.length);

			for (int i = 0; i < 2; i++) {

				System.out.println(stock_list[i]);

				MobileElement sg_stck = GlobalUtil.getMDriver()
						.findElement(By.xpath(MoneyControlAppPage.enter_stockname_in_watchlist));
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
				int x= sg_stck.getLocation().getX();
				int y= sg_stck.getLocation().getY();
				int h= sg_stck.getSize().getHeight();
				int w=sg_stck.getSize().getWidth();
				//System.out.println("x is : "+x+" y is : "+y+" h is : "+h+" w is: "+w);
				TouchAction t = new TouchAction(GlobalUtil.getMDriver());
				//t.tap(230, 806).perform();
				t.tap(x+h, y+h+50).perform();
				//ta.tap(230, 600).perform();

				KeywordUtil.delay(2000);
				select_suggested_stockname();
				KeywordUtil.delay(1000);

			}
			KeywordUtil.delay(1000);
			MoneyControlAppPage.click_done_watchlist();
			KeywordUtil.delay(1000);
			MoneyControlAppPage.clickMenuTab();
			KeywordUtil.delay(1000);
			MoneyControlAppPage.clickmywatchlist();
			KeywordUtil.delay(1000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void select_suggested_stockname() {
		try {
			if (MobileKeywords.isWebElementPresent(MoneyControlAppPage.suggesed_stockname,
					MoneyControlAppPage.type_xpath)) {
				System.out.println("1");
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.suggesed_stockname)).click();
			}
			KeywordUtil.delay(2000);
			if (MobileKeywords.isWebElementPresent(MoneyControlAppPage.suggesed_stockname1,
					MoneyControlAppPage.type_xpath)) {
				System.out.println("2");
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.suggesed_stockname1)).click();
			}
			// KeywordUtil.delay(2000);
			if (MobileKeywords.isWebElementPresent(MoneyControlAppPage.suggesed_stockname2,
					MoneyControlAppPage.type_xpath)) {
				System.out.println("3");
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.suggesed_stockname2)).click();
			}
			// KeywordUtil.delay(2000);
			if (MobileKeywords.isWebElementPresent(MoneyControlAppPage.suggesed_stockname3,
					MoneyControlAppPage.type_xpath)) {
				System.out.println("4");
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.suggesed_stockname3)).click();
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
				 * WebElement sg_stck =
				 * GlobalUtil.getMDriver().findElement(By.xpath(
				 * MoneyControlAppPage. enter_stockname_in_watchlist));
				 * sg_stck.sendKeys(stock_list[i]);
				 */

				MobileElement sg_stck = GlobalUtil.getMDriver()
						.findElement(By.xpath(MoneyControlAppPage.enter_stockname_in_watchlist));
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
				ta.tap(230, 600).perform();

				// GlobalUtil.getMDriver().findElement(By.xpath("//*[@resource-id='com.divum.MoneyControl:id/lv_addmutulfundshints']/android.widget.LinearLayout[@index='0']/android.widget.TextView")).click();
				KeywordUtil.delay(2000);
				select_suggested_stockname();
				KeywordUtil.delay(2000);
			}
			KeywordUtil.delay(1000);
			MoneyControlAppPage.click_done_watchlist();
			KeywordUtil.delay(1000);
			MoneyControlAppPage.clickMenuTab();
			KeywordUtil.delay(1000);
			MoneyControlAppPage.clickmywatchlist();
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
			//System.out.println("stock_list size is " + stock_list.length);

			for (int i = 0; i < 2; i++) {

				System.out.println(stock_list[i]);

				/*
				 * WebElement sg_stck =
				 * GlobalUtil.getMDriver().findElement(By.xpath(
				 * MoneyControlAppPage. enter_stockname_in_watchlist));
				 * sg_stck.sendKeys(stock_list[i]);
				 */

				MobileElement sg_stck = GlobalUtil.getMDriver()
						.findElement(By.xpath(MoneyControlAppPage.enter_stockname_in_watchlist));
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
				int x= sg_stck.getLocation().getX();
				int y= sg_stck.getLocation().getY();
				int h= sg_stck.getSize().getHeight();
				int w=sg_stck.getSize().getWidth();
				System.out.println("x is : "+x+" y is : "+y+" h is : "+h+" w is: "+w);
				TouchAction t = new TouchAction(GlobalUtil.getMDriver());
				//t.tap(230, 806).perform();
				t.tap(x+h, y+h+50).perform();
				//ta.tap(230, 600).perform();
				// GlobalUtil.getMDriver().findElement(By.xpath("//*[@resource-id='com.divum.MoneyControl:id/lv_addmutulfundshints']/android.widget.LinearLayout[@index='0']/android.widget.TextView")).click();
				KeywordUtil.delay(2000);
				select_suggested_stockname();
				KeywordUtil.delay(1000);
			}
			KeywordUtil.delay(1000);
			MoneyControlAppPage.click_done_watchlist();
			KeywordUtil.delay(1000);
			MoneyControlAppPage.clickMenuTab();
			KeywordUtil.delay(1000);
			MoneyControlAppPage.clickmywatchlist();
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
			//System.out.println("stock_list size is " + stock_list.length);

			/*for (int i = 0; i < 2; i++) {

				System.out.println(stock_list[i]);
				
				 * WebElement sg_stck =
				 * GlobalUtil.getMDriver().findElement(By.xpath(
				 * MoneyControlAppPage. enter_stockname_in_watchlist));
				 * sg_stck.sendKeys(stock_list[i]);
				 

				MobileElement sg_stck = GlobalUtil.getMDriver()
						.findElement(By.xpath(MoneyControlAppPage.enter_stockname_in_watchlist));
				// sg_stck.sendKeys(stock_list[i]);

				*//***************** JSE **************//*
				// GlobalUtil.getMDriver().executeScript("try{var el =
				// document.getElementById('com.divum.MoneyControl:id/edt_st_cmp_name');el.value
				// = '"+stock_list[i]+"';return 0;}catch{return 1;}");

				*//************** ADB ****************//*
				try {
					sg_stck.click();
					new ProcessBuilder(new String[] { "adb", "-s", "34P3Y18903023382", "shell", "input", "text",
							"" + stock_list[i] + "" }).redirectErrorStream(true).start();
				} catch (IOException e) {
					e.printStackTrace();
				}
				KeywordUtil.delay(4000);
				int x= sg_stck.getLocation().getX();
				int y= sg_stck.getLocation().getY();
				int h= sg_stck.getSize().getHeight();
				int w=sg_stck.getSize().getWidth();
				System.out.println("x is : "+x+" y is : "+y+" h is : "+h+" w is: "+w);
				TouchAction t = new TouchAction(GlobalUtil.getMDriver());
				//t.tap(230, 806).perform();
				t.tap(x+h, y+h+50).perform();
				//ta.tap(230, 600).perform();
				// GlobalUtil.getMDriver().findElement(By.xpath("//*[@resource-id='com.divum.MoneyControl:id/lv_addmutulfundshints']/android.widget.LinearLayout[@index='0']/android.widget.TextView")).click();
				KeywordUtil.delay(2000);
				select_suggested_stockname();
				KeywordUtil.delay(1000);
			}*/
			KeywordUtil.delay(1000);
			MoneyControlAppPage.click_done_watchlist();
			KeywordUtil.delay(1000);
			MoneyControlAppPage.clickMenuTab();
			KeywordUtil.delay(1000);
			MoneyControlAppPage.clickmywatchlist();
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
			//System.out.println("stock_list size is " + stock_list.length);

			for (int i = 0; i < 2; i++) {

				System.out.println(stock_list[i]);

				/*
				 * WebElement sg_stck =
				 * GlobalUtil.getMDriver().findElement(By.xpath(
				 * MoneyControlAppPage. enter_stockname_in_watchlist));
				 * sg_stck.sendKeys(stock_list[i]);
				 */

				MobileElement sg_stck = GlobalUtil.getMDriver()
						.findElement(By.xpath(MoneyControlAppPage.enter_stockname_in_watchlist));
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
				int x= sg_stck.getLocation().getX();
				int y= sg_stck.getLocation().getY();
				int h= sg_stck.getSize().getHeight();
				int w=sg_stck.getSize().getWidth();
				System.out.println("x is : "+x+" y is : "+y+" h is : "+h+" w is: "+w);
				TouchAction t = new TouchAction(GlobalUtil.getMDriver());
				//t.tap(230, 806).perform();
				t.tap(x+h, y+h+50).perform();
				//ta.tap(230, 600).perform();
				// GlobalUtil.getMDriver().findElement(By.xpath("//*[@resource-id='com.divum.MoneyControl:id/lv_addmutulfundshints']/android.widget.LinearLayout[@index='0']/android.widget.TextView")).click();
				KeywordUtil.delay(2000);
				select_suggested_stockname();
				KeywordUtil.delay(1000);
			}
			KeywordUtil.delay(1000);
			MoneyControlAppPage.click_done_watchlist();
			KeywordUtil.delay(1000);
			MoneyControlAppPage.clickMenuTab();
			KeywordUtil.delay(1000);
			MoneyControlAppPage.clickmywatchlist();
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
			List<AndroidElement> list = GlobalUtil.getMDriver()
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
			GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.emailoruserid)).sendKeys(proemail);
			GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.emailpassword)).sendKeys(propassword);
			GlobalUtil.getMDriver().hideKeyboard();
			GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.emaillogin)).click();
			KeywordUtil.delay(3000);
			if (KeywordUtil.isWebElementPresent(OK, type_xpath)) {
				GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.OK)).click();
			}
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	public static void enter_Prousers_details_and_click_login(String Pro_usersID, String Pro_userspassword) {
		try {

			explicitWaitForElementforGivenTime(MoneyControlAppPage.pro_user_ID, MoneyControlAppPage.type_xpath, 10);
			GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.pro_user_ID)).sendKeys(Pro_usersID);
			GlobalUtil.getMDriver().hideKeyboard();
			KeywordUtil.delay(5000);
			GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.pro_user_password))
			.sendKeys(Pro_userspassword);
			GlobalUtil.getMDriver().hideKeyboard();
			KeywordUtil.delay(8000);

			GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.pro_user_login_button)).click();
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

	public static void clickprofile() {
		try {
			KeywordUtil.delay(3000);
			explicitWaitForElementforGivenTime(users_Profile, type_xpath, 10);
			click(users_Profile, type_xpath);
			// Assert.assertEquals(MoneycontrolHomepage2.profile_iconn,"Login",
			// "Moneycontrol Pro user profile Verified");

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void clickalertbt() {

		if (KeywordUtil.isWebElementPresent(OK, type_xpath)) {
			KeywordUtil.delay(3000);
			//explicitWaitForElementforGivenTime(OK, type_xpath, 10);
			click(OK, type_xpath);
			// Assert.assertEquals(MoneycontrolHomepage2.profile_iconn,"Login",
			// "Moneycontrol Pro user profile Verified");
		}

	}

	public static void getcontenthome() {
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
			MoneyControlAppPage.click(Markts_tab, type_xpath);
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
			List<AndroidElement> list = GlobalUtil.getMDriver().findElements(By
					.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout"));
			//System.out.println("elements list size is " + list.size());
			String x = "";
			for (int j = 1; j < list.size(); j++) {
				if(MobileKeywords.isWebElementPresent("//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout[@index='"
										+ j + "']/android.widget.LinearLayout/android.widget.RelativeLayout[@index='2']//android.widget.TextView", type_xpath))
				{
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
			// GlobalUtil.getMDriver().swipe(383, 1090, 383, 256, 500);
			// GlobalUtil.getMDriver().swipe(383, 1090, 383, 900, 500);

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
			List<AndroidElement> list = GlobalUtil.getMDriver().findElements(By
					.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout"));
			//System.out.println(list.size());
			String x = "";
			// GlobalUtil.getMDriver().swipe(383,1090,383,256,500);
			for (int j = 1; j < list.size(); j++) {
				if(MobileKeywords.isWebElementPresent("//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout[@index='"
										+ j + "']/android.widget.LinearLayout/android.widget.RelativeLayout[@index='2']//android.widget.TextView", type_xpath))
				{
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

	public static Boolean swipeVerticalBottom1()  {
		Boolean flag = false;

		size = GlobalUtil.getMDriver().manage().window().getSize();
		int starty = (int) (size.height * 0.60);
		int endy = (int) (size.height * 0.10);
		int startx = size.width / 2;
		GlobalUtil.getMDriver().swipe(startx, starty, startx, endy, 1000);
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
		GlobalUtil.getMDriver().swipe(startx, starty, startx, endy, 1000);
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

	public static void enterMcStock(String name){
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

	public static String getMcStockValues() throws InterruptedException {
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
			System.out.println("Stock is : "+name);
			GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.nse_search1))
			.sendKeys(name);
			Thread.sleep(4000);
			MoneyControlAppPage.clicksearch();
			System.out.println();

			Thread.sleep(2000);
			y = (GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.Nse_current_price)).getText());
			System.out.println("NSE  current price is\t\t\t\t: " +y);


			c = (GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.Nse_Diff)).getText());
			System.out.println("NSE  current Difference  is\t\t: " +c);
			Thread.sleep(2000);

			c1 = (GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.Nse_perc)).getText());
			System.out.println("NSE  current Percentage  is\t\t: " +c1);
			if(c1.contains("%"))
			{
				c1=c1.replace("%", "");
			}
			nsePercentage=Float.parseFloat(c1);
			Thread.sleep(2000);
			Thread.sleep(3000);
			d = (GlobalUtil.getMDriver().findElement(By.xpath(MoneyControlAppPage.Nse_prev_value)).getText());
			System.out.println("NSE  Previous value is\t\t\t\t: " +d);
			System.out.println();
			Thread.sleep(2000);
			GlobalUtil.getMDriver().pressKeyCode(AndroidKeyCode.BACK);
			Thread.sleep(2000);
			GlobalUtil.getMDriver().pressKeyCode(AndroidKeyCode.BACK);
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
			if(MobileKeywords.isWebElementPresent("//android.widget.TextView[@text='LATER']", type_xpath)){
				GlobalUtil.getMDriver().findElement(By.xpath("//android.widget.TextView[@text='LATER']")).click();
			}
			clicketsearch();
			Thread.sleep(2000);
			WebElement se = GlobalUtil.getMDriver().findElement(By.xpath(Enter_et_text));
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
			GlobalUtil.getMDriver().pressKeyCode(AndroidKeyCode.BACK);
			Thread.sleep(2000);
			GlobalUtil.getMDriver().pressKeyCode(AndroidKeyCode.BACK);
			Thread.sleep(2000);
			GlobalUtil.getMDriver().pressKeyCode(AndroidKeyCode.BACK);
			Thread.sleep(2000);
			GlobalUtil.getMDriver().pressKeyCode(AndroidKeyCode.BACK);
			GlobalUtil.getMDriver().pressKeyCode(AndroidKeyCode.BACK);
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
		GlobalUtil.getMDriver().swipe(startx, y, endx, y, 1000);
	}

	public static void getCurrenciesVal() {
		try {
			System.out.println();
			List<AndroidElement> list = GlobalUtil.getMDriver().findElements(By.xpath(
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
			GlobalUtil.getMDriver().swipe(startx, endy, startx, starty, 3000);
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

	public static void Pushnotifications() throws InterruptedException {
		GlobalUtil.getMDriver().openNotifications();

		Thread.sleep(8000);
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
				List<AndroidElement> list = GlobalUtil.getMDriver().findElements(By.xpath(
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
				GlobalUtil.getMDriver().swipe(383, 1090, 383, 256, 500);
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
							System.getProperty("user.dir")+"\\"+"ActiveByValueScreenShots\\Sample2"+".png");
				} else {
					System.out.println(stock_names[k] + " is not duplicated ");
				}
			}
			KeywordUtil.takeMobileScreenshot(
					System.getProperty("user.dir")+"\\"+"ActiveByValueScreenShots\\Sample2"+".png");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	public static void read_top5news_in_topNews()
	{

		int num = 0;
		String top5news="";
		for (int i = 0; i < 5; i++) {

			num = i + 1;

			String pro_opinion_news_headline_text_before = GlobalUtil.getMDriver()
					.findElement(By.xpath("//*[@resource-id='android:id/list']/android.view.ViewGroup[@index='"
							+ num + "']//android.view.ViewGroup/android.widget.TextView"))
					.getText();
			System.out.println("pro_opinion_news_headline_text_before going into the news is   "
					+ pro_opinion_news_headline_text_before);
			System.out.println();
			top5news=top5news+" "+pro_opinion_news_headline_text_before;
		}
		System.out.println(" top 5 news are "+top5news);
	}

	public static void go_to_home()
	{
		GlobalUtil.getMDriver().findElement(By.xpath(menubutton1)).click();
		KeywordUtil.delay(1000);
	}
	public static void user_checks_for_top5news_in_homepage()
	{
		AndroidElement ae=GlobalUtil.getMDriver().findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='0']"));
		int x=ae.getLocation().getX();
		int y=ae.getLocation().getY();
		int w=ae.getSize().getWidth();
		int h=ae.getSize().getHeight();
		System.out.println("x is "+x+" y is "+y+" w is "+w+" h is "+h);
		//x is 0 y is 540 w is 756 h is 189

		String news_text_homepage_first=GlobalUtil.getMDriver().findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='0']")).getText();
		System.out.println(news_text_homepage_first);
		for(int i=0;i<3;i++)
		{
			//t.press(x+850, y+80).waitAction(Duration.ofMillis(2000)).moveTo(x+200, y+80).release().perform();	
			//t.press(800,630).waitAction(Duration.ofMillis(3000)).moveTo(100,630).release().perform();
			Dimension dim = GlobalUtil.getMDriver().manage().window().getSize();
			int height = dim.getHeight();
			int width = dim.getWidth();
			int y1 = (int) (height * 0.30);
			int startx = (int) (width * 0.80);
			int endx = (int) (width * 0.30);
			GlobalUtil.getMDriver().swipe(startx, y1, endx, y1, 1000);
			String news_text_homepage=GlobalUtil.getMDriver().findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='0']")).getText();
			System.out.println(news_text_homepage);
		}
		String news_text_homepage_last=GlobalUtil.getMDriver().findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='1']/android.widget.TextView[@index='0']")).getText();
		System.out.println(news_text_homepage_last);

	}
	
	static String[] news_time=new String[5];
	
	public static void user_checks_for_top5news_time_in_homepage()
	{
		AndroidElement ae=GlobalUtil.getMDriver().findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='1']"));
		
		/*int x=ae.getLocation().getX();
		int y=ae.getLocation().getY();
		int w=ae.getSize().getWidth();
		int h=ae.getSize().getHeight();
		System.out.println("x is "+x+" y is "+y+" w is "+w+" h is "+h);*/


		KeywordUtil.delay(1000);
		String news_text_homepage_first=ae.getText();
		System.out.println(news_text_homepage_first);
		//news_time[0]=news_text_homepage_first;
		for(int i=0;i<3;i++)
		{
			//t.press(x+850, y+80).waitAction(Duration.ofMillis(2000)).moveTo(x+200, y+80).release().perform();	
			//t.press(800,630).waitAction(Duration.ofMillis(3000)).moveTo(100,630).release().perform();
			KeywordUtil.delay(1000);
			Dimension dim = GlobalUtil.getMDriver().manage().window().getSize();
			int height = dim.getHeight();
			int width = dim.getWidth();
			int y1 = (int) (height * 0.30);
			int startx = (int) (width * 0.80);
			int endx = (int) (width * 0.30);
			GlobalUtil.getMDriver().swipe(startx, y1, endx, y1, 1000);
			String news_text_homepage=ae.getText();
			System.out.println(news_text_homepage);
			//news_time[i+1]=news_text_homepage;
		}
		KeywordUtil.delay(1000);
		AndroidElement ae2=GlobalUtil.getMDriver().findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[@index='1']/android.widget.TextView[@index='1']"));
		String news_text_homepage_last=ae2.getText();
		System.out.println(news_text_homepage_last);
		//news_time[4]=news_text_homepage_first;
		System.out.println();
		/*for(int i=0;i<news_time.length;i++)
		{
			System.out.println(news_time[i]);
		}*/

	}
	
	static Integer[] hrs=new Integer[7];
	static Integer[] mins=new Integer[7];
	static Integer[] secs=new Integer[7];
	
	public static void user_verifies_news_time()
	{
		String[] news_time1={"1 hr 33 mins ago", "1 hr 4 mins ago", "44 mins 19 sec ago", "2 hrs 33 mins ago", "2 min 6 sec ago","5 sec ago", "50 sec ago"};
		
		for(int i=0;i<news_time1.length;i++)
		{
			if(news_time1[i].contains("h"))
			{
				String hr=Character.toString(news_time1[i].charAt(0));
				hrs[i]=Integer.parseInt(hr);
			}
			else
			{
				hrs[i]=0;
			}		
		}
		for(int i=0;i<news_time1.length;i++)
		{
			if(news_time1[i].contains("mins"))
			{
				int mIndex=news_time1[i].indexOf("mins");
				mins[i]=Integer.parseInt(news_time1[i].substring(mIndex-3,mIndex-1));
			}
			else if(news_time1[i].contains("min "))
			{
				/*int mIndex=news_time1[i].indexOf("min ");
				String ab=news_time1[i].substring(mIndex-3,mIndex-1);
				if(ab.contains(" "))
				{
					ab=ab.replace(" ", "");
				}
				mins[i]=Integer.parseInt(ab);*/
				
				String mIndex=Character.toString(news_time1[i].charAt(0));
				mins[i]=Integer.parseInt(mIndex);
			}
			else
			{
				mins[i]=0;
			}
		}
		for(int i=0;i<news_time1.length;i++)
		{
			if(news_time1[i].contains("sec"))
			{
				int sIndex=news_time1[i].indexOf("sec");   
				if(sIndex>5)
				{
					String sec=news_time1[i].substring(sIndex-3,sIndex-1);
					if(sec.contains(" "))
					{
						sec=sec.replace(" ", "");
					}
					secs[i]=Integer.parseInt(sec);
				}
				else if(sIndex<5)
				{
					String sec=news_time1[i].substring(0,2);
					if(sec.contains(" "))
					{
						sec=sec.replace(" ", "");
					}
					secs[i]=Integer.parseInt(sec);	
				}
			}
			else
			{
				secs[i]=0;
			}
		}
		for(int i=0;i<7;i++)
		{
			System.out.println("hrs are "+hrs[i]);
			System.out.println("mins are "+mins[i]);
			System.out.println("secs are "+secs[i]);
			System.out.println();
		}
		Integer total_time[]=new Integer[7];
		boolean Newshrs=true;
		for(int i=0;i<7;i++)
		{
			total_time[i]=hrs[i]*60*60+mins[i]*60+secs[i];
			if(total_time[i]>3*60*60)
			{
				Newshrs=false;
			}
			else
			{
				Newshrs=true;
			}
		}
		if(Newshrs=true)
		{
			System.out.println(" Top 5 News are uploaded in less than 3 hrs : Test passed");
		}
		else
		{
			System.out.println(" Top 5 News are uploaded more than 3 hrs before : Test failed");
		}
		System.out.println();
	}
	
	public static void click_on_TopNews_homepage()
	{
		try {
			click(TopNews_heading_homepage, type_xpath);
			KeywordUtil.delay(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}
	
	public static void topnews_page_triggered()
	{
		if(MobileKeywords.isWebElementPresent(Top_News_page_text, type_xpath))
		{
			System.out.println(" Top News heading in homepage is triggering to TopNews page : Test passed");
		}
		else
		{
			System.out.println(" Top News heading in homepage is not triggering to TopNews page : Test failed");
			KeywordUtil.takeMobileScreenshot(
					System.getProperty("user.dir")+"\\"+"ActiveByValueScreenShots\\Sample3"+".png");
			
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
		//Assert.assertTrue(GlobalUtil.getMDriver().findElement(By.xpath(All_indices_text)).isDisplayed());

	}
	
	public static void clickbackbtn() {
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
