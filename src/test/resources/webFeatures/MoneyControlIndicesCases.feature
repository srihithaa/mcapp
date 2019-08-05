Feature: Assigned Tasks Validation


 Background: 
 Given User Open MoneyControl
     
     @Top5newsCheck
		 Scenario Outline: Money Control Android App Profile Login via Email account
		 
     When User clicks skips next option
     When User clicks on profile icon
     And Read login Testdata "<TestData>" from Excel file
     Then User enters ProUser credentials and click login
     And User accepts messages
  	 And User goes to TopNews section in News tab
  	 And User collects top 5 news from TopNews section
  	# And User goes to Homepage
  	 And User checks for the top 5 news headlines in Homepage
	
     
     Examples:
     |TestData|
     |LoginWithProUserTestData|
     
     @Top5newsTimeCheck 
		 Scenario Outline: Money Control Android App Profile Login via Email account
		 
     When User clicks skips next option
     #When User clicks on profile icon
     #And Read login Testdata "<TestData>" from Excel file
     #Then User enters ProUser credentials and click login
     #And User accepts messages
  	 #And User checks for the top 5 news time in Homepage
  	 And User verifies if the news uploaded with in 3 hrs
	
     
     Examples:
     |TestData|
     |LoginWithProUserTestData|
     
     @Top5newsPageCheck 
		 Scenario Outline: Money Control Android App Profile Login via Email account
		 
     When User clicks skips next option
     When User clicks on profile icon
     And Read login Testdata "<TestData>" from Excel file
     Then User enters ProUser credentials and click login
     And User accepts messages
  	 And User clicks on TopNews in Homepage
  	 Then User verifies if TopNews list page is triggered
	
     
     Examples:
     |TestData|
     |LoginWithProUserTestData|
     
 		 @4IndicesCheck 
		 Scenario Outline: Money Control Android App Profile Login via Email account
     When User clicks skips next option
    # When User clicks on profile icon
    # And Read login Testdata "<TestData>" from Excel file
    # Then User enters ProUser credentials and click login
    # And User accepts messages
    # When User clicks skips next option
     And User goes to Indices section in Homepage
     And User checks Indian indices and Global indices display
	
     
     Examples:
     |TestData|
     |LoginWithProUserTestData|
     
     @4IndicesValuesCheck 
		 Scenario Outline: Money Control Android App Profile Login via Email account
     When User clicks skips next option
    # When User clicks on profile icon
    # And Read login Testdata "<TestData>" from Excel file
    # Then User enters ProUser credentials and click login
    # And User accepts messages
    # When User clicks skips next option
   	 And User gets indices values for New App
   	# And User switches to Investing app
   	# And User verifies the indices values and percentages in Investing app
   	 
	
     
     Examples:
     |TestData|
     |LoginWithProUserTestData|
     
     @4IndicesValuesCheckNewApp
		 Scenario: Money Control Android App Profile Login via Email account
     When User clicks skips next option
   	 And User gets indices values for New App
   	
     
     @AllIndicesCheck 
		 Scenario Outline: Money Control Android App Profile Login via Email account
     When User clicks skips next option
     When User clicks on profile icon
     And Read login Testdata "<TestData>" from Excel file
     Then User enters ProUser credentials and click login
     And User accepts messages
     When User clicks skips next option
   	 And User clicks on IndianIndices
   	 And User gets all indices details
   	 And User gets indices list in NSE tab
   	 And User gets indices list in BSE tab
   	
     Examples:
     |TestData|
     |LoginWithProUserTestData|
     
     @AllIndicesCheckInInvestingApp 
     Scenario: Money Control Android App Profile Login via Email account
     When User clicks skips next option
     And User switches to Investing app
     And User checks all the indices values of "IndicesData" in Investing app
     
     @Watchlist @HomepageValidation
 	   Scenario: Check whether the user is able to see "stocks","mutual funds",
              "commodities","futures","currencies" in watchlist button when not logged in 
     When User clicks skips next option
  	 Then User should see "stocks:mutual funds:commodities:futures:currencies" in watchlist section
  
  	 @Portfolio @HomepageValidation
  	 Scenario: Check whether the user is able to see "Create a new portfolio" and "Sign in " 
  						 button if not logged in    
  	 When User clicks skips next option
  	 Then User should see Create a new portfolio and Signin button     
  	 
  	 @Stockslastvisited @HomepageValidation
 		 Scenario Outline: Check whether stock last visited tab is working or not 
  	 When User clicks skips next option
     When User click on searchbutton
     And Read "StockVariationTestData" data from Excel file
     Then User_Enter stockname for Checking MC stack value with "<TestData>" 
     Then User Navigate to homepage and Refresh the page
     Then User verifies Stocks Last Visited Section 
     Then User verifies the Stocks last visited with "<StockData>"
     
    
 		 Examples:
 		 |TestData          |StockData|
 		 |StockName SBI     |StockVariationTestData|
