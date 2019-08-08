Feature: Assigned Tasks Validation


 Background: 
 Given User Open MoneyControl


     @ProfileLoginwithfacebook @Test
		 Scenario Outline: Money Control Android App Profile Login via Facebook
     When User clicks skips next option
     When User clicks on profile icon
     And Read login Testdata "<TestData>" from Excel file
     Then User Clicks on Login with facebook 
     And User accepts messages
     And User enters facebook details and click login
     Then User verifies login page and click on logout
     
     Examples:
     |TestData|
     |LoginWithFBTestData|
      
     @ProfileLoginwithgoogle @Test
		 Scenario Outline: Money Control Android App Profile Login via Google account
     When User clicks skips next option
     When User clicks on profile icon
     And Read login Testdata "<TestData>" from Excel file
     Then User Clicks on Login with google 
     And User accepts messages
     And User enters Google details and click login
     Then User verifies login page and click on logout
     
     Examples:
     |TestData|
     |LoginWithGoogleTestData|

     @ProfileLoginwithemail @Test
		 Scenario Outline: Money Control Android App Profile Login via Email account
     When User clicks skips next option
     When User clicks on profile icon
     And Read login Testdata "<TestData>" from Excel file
     Then User enters ProUser credentials and click login
     And User accepts messages
     Then User click logout
	
     
     Examples:
     |TestData|
     |LoginWithProUserTestData|
     
     @ProfilePortfoliocheckwithfacebook @Test
		 Scenario Outline: Money Control Android App User is able to see correct Portfolio after logging in
		 When User clicks skips next option
     When User clicks on profile icon
     And Read login Testdata "<TestData>" from Excel file
     Then User enters ProUser credentials and click login
     And User accepts messages
     And User Click on Menu
     When User clicks skips next option
     And User Click on MyPortfolio
   	 And Add stocks "<StockData>" to profile
     And Add Mutualfunds "<StockData>" to profile 
     And Add ULIPs "<StockData>" to profile
     And Add Bullions "<StockData>" to profile
     And Verify stocks are correctly reflected or not with respect to stockname
     And User get the networth amount and checks for the confirmation
     Then User click logout
    
     Examples:
     |TestData|StockData|
     |LoginWithProUserTestData|StockVariationTestData|
     
     @Prousercontentcheck @Test
		 Scenario Outline: Money Control Android App Pro Users are able to see exclusive Moneycontrol Pro content fully
     
     When User clicks skips next option
     When User clicks on profile icon
     And Read login Testdata "<TestData>" from Excel file
     Then User enters ProUser credentials and click login
     And User accepts messages
     And User Click on News tab
   	 And User moves to Opinion tab
   	 And Pro User reads news with Pro symbol
   	 Then User click logout
   	  
   	 Examples:
     |TestData|
     |LoginWithProUserTestData|
     
     @NonProusercontentcheck @Test
		 Scenario Outline: Money Control Android App Non-Pro users are not able to see exclusive Moneycontrol Pro content fully
     When User clicks skips next option
     When User clicks on profile icon
     And Read login Testdata "<TestData>" from Excel file
     Then User Clicks on Login with facebook 
     And User accepts messages
     And User enters facebook details and click login
   	 When User Click on News tab
   	 And User moves to Opinion tab
   	 And Non Pro User reads a news with Pro symbol
   	 Then User click logout
      
     Examples:
     |TestData|
     |LoginWithFBTestData|
     
     @Profilewatchlistcheckwithfacebook @Test
		 Scenario Outline: Money Control Android App User is able to see correct Watchlist after logging in
     
     When User clicks skips next option
     When User clicks on profile icon
     And Read login Testdata "<TestData>" from Excel file
     Then User enters ProUser credentials and click login
     And User accepts messages
     And User Click on Menu
     When User clicks skips next option
     And User Click on MyWatchlist
     And User enters "StockVariationTestData" stocks to watchlist
     And User enters "StockVariationTestData" commodities to watchlist
     And User enters "StockVariationTestData" futures to watchlist
     And User enters "StockVariationTestData" currencies to watchlist
     And Verify stocks are correctly reflected or not with respect to "StockVariationTestData" in watchlist
     Then User click logout
     
     Examples:
     |TestData|
     |LoginWithProUserTestData|
     
     @Applaunchtime @Test211
     Scenario: monitor time to App launch
 	   Given User open MoneycontrolApp and verify App launching and App closing Time
   
     @prouserscheckingadds @Test2
		 Scenario Outline: Check if Pro users are seeing any adds
		 When User clicks skips next option
		 When User checks NonProuser Adds 
	   And User Click on Menu
	   When User clicks skips next option
	   And User_Click on Moneycontrol_Pro
	   When User clicks on profile icon
     And Read login Testdata "<TestData>" from Excel file
     Then User enters ProUser credentials and click login
     And User accepts messages
     When User clicks skips next option
	   Then Pro User Verifies Adds
  	 Examples: 
     |TestData|
     |LoginWithProUserTestData|
      
     
     @Topgainers  @Test2
     Scenario Outline: Verify Top Gainers
     When User clicks skips next option
     When User clicks on profile icon
     And Read login Testdata "<TestData>" from Excel file
     Then User enters ProUser credentials and click login
     And User accepts messages
     And User_Clicks on Markets_Tab  
     And User_Click on Top_Gainers  
     Then User click logout
     
     Examples:
     |TestData|
     |LoginWithProUserTestData|
    
 		 @Toplosers @Test
     Scenario Outline: Verify Top Losers
     When User clicks skips next option
     When User clicks on profile icon
     And Read login Testdata "<TestData>" from Excel file
     And User enters ProUser credentials and click login
     And User accepts messages
     And User_Clicks on Markets_Tab
     And User_Click on Top Losers
     Then User click logout
 	
 	 	 Examples:
     |TestData|
     |LoginWithProUserTestData|
     
 	   
 	   @MCprostillloggedin @Test2
	   Scenario Outline: User login to Moneycontrol Pro run App in background, again relaunch MC app for checking user still logged in or not
	   When User clicks skips next option
	   When User clicks on profile icon
	   And Read login Testdata "<TestData>" from Excel file
     Then User enters ProUser credentials and click login
     And User accepts messages
     When User clicks skips next option
	   And User run App in Background
	   And User re launch MC App
	   When User clicks skips next option
	   Then User verify Before App Background run and relaunch MC app pro User login 
	      
      Examples:
     |TestData|
     |LoginWithProUserTestData|
      
      
 	   @MCprokillApp @Test2
	 	 Scenario Outline: Login as a Moneycontrol Pro user, simulate killing the app, relaunch and see if you are still logged in as  Pro user
	   When User clicks skips next option
	   When User clicks on profile icon
	   And Read login Testdata "<TestData>" from Excel file
     Then User enters ProUser credentials and click login
     And User accepts messages
     When User clicks skips next option
	   And User kill the App
	   And User re-Open MoneyControl_App
	   When User clicks skips next option
	   Then User verify After kill the App and relaunch MC app, pro User are logged in or not
	      
      
     Examples:
     |TestData|
     |LoginWithProUserTestData|
     

 	   
 	   @pushnotifications @Test2
     Scenario: Check Notification and user navigate to correct page
     Then User verifies Notifications
     
     
     @Activebyvalue1 @Test2
     Scenario Outline: Verify the Active by value, Same stock name sometimes comes consecutively Should not happen
	   When User clicks skips next option
	   When User clicks on profile icon
	   And Read login Testdata "<TestData>" from Excel file
     And User enters ProUser credentials and click login
     And User accepts messages
     When User clicks skips next option
	   Then User_Clicks on Markets_Tab
	   Then User click on Active by value
	   Then User Verify the Stocks 
	   Examples:
     |TestData|
     |LoginWithProUserTestData|
     
     @stockdifference @Test
     Scenario Outline: Stock price comparision
   	 When User clicks skips next option
     When User click on searchbutton
     And Read "StockVariationTestData" data from Excel file
     Then User_Enter stockname for Checking MC stack value with "<TestData>"
     And User_get the MCS stackvalues
     Then User_switch to ET stock Appp
     And Read "StockVariationTestData" data from Excel file
 		 And User_Enter stockname for ETS Stack to get_ETS value with "<TestData>"
 		 Then User_switch to NSE stock App
     And Read "StockVariationTestData" data from Excel file 
     And User_Enter stockname for checking NSES with "<TestData>"
 		 Then User validate the NIFTY Stocks for MC, NSE and ET, compare values bellow two percentage 
 		
 		 Examples:
 		 |TestData          |
 		 |StockName SBI     |
 		 |StockName Reliance|
     |StockName TCS     |
     |StockName Infosys |
     |StockName Yes Bank|
     
	 
     @StockAnctionAndCommodities  @Test
     Scenario: For stock actions, commodities and currencies, for all cards check absolute and percentage value even page refresh
	   When User clicks skips next option
	   Given User perform vertical swipe for Stock_Action  
	   And user get the Absolute value and percentage value for Stocks Action 
	   And user get the Absolute value and percentage value for Commodities And currencies
	   Then User validate the order of absolute and percentage values
     