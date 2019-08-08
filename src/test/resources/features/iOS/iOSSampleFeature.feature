Feature: MoneyControl iOS WAP Automation

  @iOSWAPTest
  Scenario Outline: iOS WAP sample Test
    Given User navigate to Moneycontrol "ioswap"
    Given User read the data "LoginviaFBAndroidweb" from ExcelSheet
    And User click on the User Icon
    And User click on Login Button
    And User click on Login with Facebook
    And User enter the credentials of Facebook and click on Login
    And User click on the User Icon
    Then User click on SignOut Button

    Examples: 
      | TestData             |
      | LoginviaFBAndroidweb |

  @iOSAPPTest1 @iOSGmailLogin
  Scenario: iOS APP sample Test
    Given User navigate to Moneycontrol "iosapp"
    When User is login to app using "gmail"

  @iOSAPPTest1 @iOSFbLogin
  Scenario: iOS APP sample Test
    Given User navigate to Moneycontrol "iosapp"
    When User is login to app using "fb"

  @iOSAPPTest @iOSEmailLogin
  Scenario: iOS APP sample Test
    Given User navigate to Moneycontrol "iosapp"
    When User is login to app using "email"

  @iOSStockActions @iOS
  Scenario: Top Gainers validation in iOS app
    Given User navigate to Moneycontrol "iosapp"
    Then User validates top gainers listing
    
    @Applaunchtime @MCAppTest1
   Scenario: monitor time to App launch
   Given User navigate to_Moneycontrol "iosapp"
 