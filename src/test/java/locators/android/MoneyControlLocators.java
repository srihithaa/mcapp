package locators.android;

public interface MoneyControlLocators {

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
	public static String topnews_in_homepage = "//*[@text='Top News']";
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
	// public static String OK = "//*[@text='OK']";
	public static String OK = "//*[@class='android.widget.Button'][@text='OK']";

	public static String OK1 = "//*[@class='android.widget.Button']";
	public static String OK2 = "//*[@resource-id='com.divum.MoneyControl:id/btnExit']";
	// public static String OK3 = "//*[@class='android.widget.FrameLayout']";
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
	public static String money_control_pro = "//*[@text='Moneycontrol Pro']";
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

	public static String mcDiffandPer = "//*[@resource-id='com.divum.MoneyControl:id/tv_stock_change'][@index='5']";
	public static String mcprevclose = "//android.widget.LinearLayout[@resource-id='com.divum.MoneyControl:id/ll_bid_price_overview']/android.view.ViewGroup[@index='2']/android.widget.TextView[@index='1']";
	// public static String nse_search1 =
	// "//*[@resource-id='com.msf.nse:id/equity_edit'][@index='1']";
	// public static String Nse_current_price =
	// "//android.widget.TextView[@resource-id='com.msf.nse:id/last'][@index='0']";
	public static String Nse_Diff_perc = "//android.widget.TextView[@resource-id='com.msf.nse:id/change'][@index='1']";
	// public static String Nse_prev_value =
	// "//android.widget.TableLayout[@resource-id='com.msf.nse:id/row_details']/android.widget.TableRow[@index='10']/android.widget.TextView[@index='1']";
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
	public static String nse_click_tap = "//*[@resource-id='in.tazone.nsestocks:id/symbol_search_list']/android.view.ViewGroup[@index='0']";
	// *[@resource-id='in.tazone.nsestocks:id/value_container']";
	// *[@class='android.view.ViewGroup'][@instance='2']";

	///////////// ********************* For New Test Cases
	///////////// ***************///////////////
	public static String Investing_app = "//*[@class='android.widget.TextView'][@text='Investing']";
	public static String search_in_Investing_app = "//*[@resource-id='com.fusionmedia.investing:id/action_item_3']";
	public static String enter_index_in_Investing_app = "//*[@resource-id='com.fusionmedia.investing:id/menuSearchEditText']";
	public static String get_index_value_in_Investing_app = "//*[@resource-id='com.fusionmedia.investing:id/instrumentValue']";
	public static String get_index_percentage_in_Investing_app = "//*[@resource-id='com.fusionmedia.investing:id/instrumentDataChange']";
	public static String back_in_Investing_app = "//*[@resource-id='com.fusionmedia.investing:id/action_item_1']";
	public static String Indices_in_homepage = "//*[@resource-id='com.divum.MoneyControl:id/linear_tray_header'][@text='Indices']";
	public static String Indian_Indices_in_homepage = "//*[@resource-id='com.divum.MoneyControl:id/rv_linear_tray']/android.view.ViewGroup[@index='0']/android.view.ViewGroup/android.widget.TextView[@index='0']";
	// android.widget.TextView[@resource-id='com.divum.MoneyControl:id/tv_market_data_heading'][@text='INDIAN
	// INDICES'][@index='0']";
	public static String TopNews_heading_homepage = "//android.widget.TextView[@resource-id='com.divum.MoneyControl:id/linear_tray_header'][@text='Top News'][@index='0']";
	public static String Top_News_page_text = "//*[@text='Top News']";
	public static String All_indices_text = "//*[@text='All Indices']";
	public static String NSE_tab_in_Allindices = "//android.widget.TextView[@text='NSE']";
	public static String BSE_tab_in_Allindices = "//android.widget.TextView[@text='BSE']";

	public static final String Myportfolio = "//*[@text='My Portfolio']";

	public static final String Watchlist = "//*[@text='My Portfolio']";

	public static String Create_newportfolio = "//*[@resource-id='com.divum.MoneyControl:id/btn_create']";

	public static String Signin_btn = "//*[@resource-id='com.divum.MoneyControl:id/btn_sign_in']";
	public static final String Stocklast_visited = "//*[@text='Commodities and Currencies']";
	public static String back_btn = "//*[@resource-id='com.divum.MoneyControl:id/back_button']";
	public static final String stockname = "//*[@resource-id='com.divum.MoneyControl:id/tv_indices_name']";

}
