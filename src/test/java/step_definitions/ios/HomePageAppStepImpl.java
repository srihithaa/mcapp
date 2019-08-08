package step_definitions.ios;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;

import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import locators.ios.HomePageLocators;
import step_definitions.RunCukesTest;
import utilities.GlobalUtil;
import utilities.KeywordUtil;
import utilities.MobileKeywords;

public class HomePageAppStepImpl extends HomePageLocators {

	@When("^User navigate to_Moneycontrol \"([^\"]*)\"$")
	public void launch(String osAppType) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println("app launching time is " + dtf.format(now));
		// RunCukesTest.logger.log(LogStatus.PASS,
		// HTMLReportUtil.passStringGreenColor("before launch date"));

		String x = dtf.format(now);
		System.out.println(x.substring(x.length() - 5, x.length() - 3) + ":" + x.substring(x.length() - 2, x.length()));
		int a = Integer.parseInt(x.substring(x.length() - 5, x.length() - 3));

		int a1 = Integer.parseInt(x.substring(x.length() - 2, x.length()));
		if (osAppType.contains("wap"))
			MobileKeywords.navigateToUrl("http://moneycontrol.com");
		// else if (osAppType.contains("app") && osAppType.contains("ios")) {
		// KeywordUtil.delay(2000);
		// if (osAppType.contains("ios") && osAppType.contains("app"))
		// for (int i = 0; i < 13; i++) {
		// GlobalUtil.getMDriver().findElementByName("Home").click();
		// System.err.println("Clicked times: " + i);
		// }
		// KeywordUtil.delay(4000);
		// try {
		// if (GlobalUtil.getMDriver().findElementByName("Close
		// Advertisement").isDisplayed()) {
		// GlobalUtil.getMDriver().findElementByName("Close
		// Advertisement").click();
		// }
		// } catch (NoSuchElementException e) {
		// }
		// KeywordUtil.delay(2000);
		// }
		GlobalUtil.getMDriver().quit();

		DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime end = LocalDateTime.now();
		System.out.println("app ending time is " + dt.format(end));
		String y = dtf.format(end);
		System.out.println(y.substring(y.length() - 5, y.length() - 3) + ":" + y.substring(y.length() - 2, y.length()));
		int b = Integer.parseInt(y.substring(y.length() - 5, y.length() - 3));

		int b1 = Integer.parseInt(y.substring(y.length() - 2, y.length()));
		int c = b - a;
		int c1 = ((b * 60 + b1) - (a * 60 + a1));

		System.out.println("Time Dfference is " + c + " minutes " + c1 + " sec");

	}

	@Given("^User is login to app using \"([^\"]*)\"$")
	public void loginToApp(String loginType) {

		// GlobalUtil.getMDriver().findElementByAccessibilityId("Skip").click();
		KeywordUtil.delay(7000);
		// GlobalUtil.getMDriver().findElementByName("user inactive").click();
		GlobalUtil.getMDriver().findElement(profile_icon).click();
		// MobileKeywords.click(profile_icon, type_xpath);

		System.err.println("Clicked on User iCON.");
		KeywordUtil.delay(2000);
		try {
			if (GlobalUtil.getMDriver().findElementByName("Close Advertisement").isDisplayed()) {
				GlobalUtil.getMDriver().findElementByName("Close Advertisement").click();
				KeywordUtil.delay(1000);
			}
		} catch (NoSuchElementException e) {
		}
		if (loginType.equalsIgnoreCase("fb")) {
			GlobalUtil.getMDriver().findElementByName("LOGIN WITH FACEBOOK").click();
			System.err.println("Clicked on 'LOGIN WITH FACEBOOK'.");
			try {
				if (GlobalUtil.getMDriver().findElementByName("Close Advertisement").isDisplayed()) {
					GlobalUtil.getMDriver().findElementByName("Close Advertisement").click();
				}
			} catch (NoSuchElementException e) {
			}
			KeywordUtil.delay(2000);
			try {
				if (GlobalUtil.getMDriver().findElementByName("Continue").isDisplayed()) {
					GlobalUtil.getMDriver().findElementByName("Continue").click();
				}
			} catch (NoSuchElementException | ElementNotVisibleException e) {
			}
			KeywordUtil.delay(20000);
			GlobalUtil.getMDriver().findElementByName("Mobile number or email address")
					.sendKeys("mcontrol1001@gmail.com"); // testtxmc1234@gmail.com
															// mcontrol1001@gmail.com
			GlobalUtil.getMDriver().findElementByName("Done").click();
			KeywordUtil.delay(2000);
			GlobalUtil.getMDriver().findElementByName("Facebook password").sendKeys("Password@123"); // Test@1234
																										// Password@123
			GlobalUtil.getMDriver().findElementByName("Log In").click();
			KeywordUtil.delay(2000);

			GlobalUtil.getMDriver().findElementByAccessibilityId("Continue").click();
			KeywordUtil.delay(10000);
			GlobalUtil.getMDriver().findElement(profile_icon1).click();

			String x = GlobalUtil.getMDriver().findElementByAccessibilityId("Advance / Decline (NSE)").getText();
			System.out.println("user is on " + x + "page");
			if (GlobalUtil.getMDriver().findElementByAccessibilityId("Advance / Decline (NSE)").isDisplayed()) {
				System.out.println("User is logged in to the mc with facebook account is successfull");

			} else {
				System.out.println("User is failed to loging in  the mc with facebook account");
			}

		} else if (loginType.equalsIgnoreCase("gmail")) {
			GlobalUtil.getMDriver().findElementByName("LOGIN WITH GOOGLE").click();
			System.err.println("Clicked on 'LOGIN WITH GOOGLE'.");
			try {
				if (GlobalUtil.getMDriver().findElementByName("Close Advertisement").isDisplayed()) {
					GlobalUtil.getMDriver().findElementByName("Close Advertisement").click();
				}
			} catch (NoSuchElementException e) {
			}
			KeywordUtil.delay(2000);
			try {
				if (GlobalUtil.getMDriver().findElementByName("Continue").isDisplayed()) {
					GlobalUtil.getMDriver().findElementByName("Continue").click();
				}
			} catch (NoSuchElementException | ElementNotVisibleException e) {
			}
			KeywordUtil.delay(7000);
			GlobalUtil.getMDriver().findElementByName("Email or phone").sendKeys("mcontrol1001@gmail.com");
			GlobalUtil.getMDriver().findElementByName("Done").click();
			GlobalUtil.getMDriver().findElementByName("Next").click();
			KeywordUtil.delay(3000);
			GlobalUtil.getMDriver().findElementByName("Enter your password").sendKeys("Password@123");
			GlobalUtil.getMDriver().findElementByName("Done").click();
			GlobalUtil.getMDriver().findElementByName("Next").click();
			KeywordUtil.delay(8000);
			GlobalUtil.getMDriver().findElement(profile_icon1).click();
			KeywordUtil.delay(2000);
			String x = GlobalUtil.getMDriver().findElementByAccessibilityId("Advance / Decline (NSE)").getText();
			System.out.println("user is on " + x + "page");
			if (GlobalUtil.getMDriver().findElementByAccessibilityId("Advance / Decline (NSE)").isDisplayed()) {
				System.out.println("User is logged in to the mc with google account is successfull");

			} else {
				System.out.println("User is failed to loging in  the mc with google account");
			}

		}

		else if (loginType.equalsIgnoreCase("email")) {

			GlobalUtil.getMDriver().findElementByXPath("//XCUIElementTypeTextField").sendKeys("mctx345@gmail.com");
			// GlobalUtil.getMDriver().findElementByName("Done").click();
			// GlobalUtil.getMDriver().findElementByName("Next").click();
			KeywordUtil.delay(3000);
			GlobalUtil.getMDriver().findElementByXPath("//XCUIElementTypeSecureTextField").sendKeys("Money@12345");
			KeywordUtil.delay(1000);
			GlobalUtil.getMDriver().findElementByXPath("//XCUIElementTypeButton[@name='LOGIN']").click();
			KeywordUtil.delay(10000);
			GlobalUtil.getMDriver().findElement(profile_icon1).click();

			KeywordUtil.delay(2000);
			String x = GlobalUtil.getMDriver().findElementByAccessibilityId("Advance / Decline (NSE)").getText();
			System.out.println("user is on " + x + "page");

			if (GlobalUtil.getMDriver().findElementsByAccessibilityId("Advance / Decline (NSE)").size() > 0) {
				System.out.println("User is logged in to the mc with email account is successfull");
			} else {
				System.out.println("User is failed to loging in  the mc with email account");
			}
		}
		KeywordUtil.delay(6000);
		System.err.println("Everythign is done.!");

	}

	@When("^User validates top gainers listing$")
	public void validateTopGainers() {
		KeywordUtil.delay(3000);

		MobileKeywords.mobileSwipe("1.0", 200, 550, 200, 200);
		String beforeValue = null, beforePct = null;
		boolean beforeValidationFailed = false;
		String afterValue = null, afterPct = null;
		boolean afterValidationFailed = false;

		for (int i = 0; i < 4; i++) {
			String val1 = GlobalUtil.getMDriver().findElementByAccessibilityId("Row0" + i + "_2_ChangeValue").getText();
			String val = GlobalUtil.getMDriver().findElementByAccessibilityId("Row0" + i + "_2_ChangePercentage")
					.getText();

			System.err.println("Change Val\t\t:" + val1);
			System.err.println("Change Percent\t\t:" + val);
			beforePct += val;
			beforeValue += val1;
			if (val1.contains("%") & (!val.contains("%")))
				beforeValidationFailed = true;
		}
		if (beforeValidationFailed)
			RunCukesTest.logger.log(LogStatus.FAIL,
					"TopGainers value-percentage order of TopGainers was not as expected.");
		else
			RunCukesTest.logger.log(LogStatus.PASS, "TopGainers value-percentage order is as expected.  --PASS");
		MobileKeywords.mobileSwipe("1.0", 200, 200, 200, 550);
		MobileKeywords.mobileSwipe("1.0", 200, 200, 200, 550);
		MobileKeywords.mobileSwipe("1.0", 200, 550, 200, 200);
		for (int i = 0; i < 4; i++) {
			String val1 = GlobalUtil.getMDriver().findElementByAccessibilityId("Row0" + i + "_2_ChangeValue").getText();
			String val = GlobalUtil.getMDriver().findElementByAccessibilityId("Row0" + i + "_2_ChangePercentage")
					.getText();

			System.err.println("New change Val\t\t:" + val1);
			System.err.println("New change Percent\t:" + val);
			afterPct += val;
			afterValue += val1;
			if (val1.contains("%") & (!val.contains("%")))
				afterValidationFailed = true;
		}
		if (afterValidationFailed)
			RunCukesTest.logger.log(LogStatus.FAIL,
					"TopGainers value-percentage order of TopGainers is not as expected after screen refreshed.");
		else
			RunCukesTest.logger.log(LogStatus.PASS,
					"TopGainers value-percentage order is as expected after screen refreshed.  --PASS");
		MobileKeywords.mobileSwipe("1.0", 550, 200, 200, 200);// horizantal
		System.out.println();

		for (int i = 0; i < 4; i++) {
			KeywordUtil.delay(2000);
			String val1 = GlobalUtil.getMDriver().findElementByAccessibilityId("Row1" + i + "_2_ChangeValue").getText();
			KeywordUtil.delay(2000);
			String val = GlobalUtil.getMDriver().findElementByAccessibilityId("Row1" + i + "_2_ChangePercentage")
					.getText(); // Row11_2_ChangeValue
								// Row10_2_ChangePercentage

			System.err.println("Change Val\t\t:" + val1);
			System.err.println("Change Percent\t\t:" + val);
			beforePct += val;
			beforeValue += val1;
			if (val1.contains("%") & (!val.contains("%")))
				beforeValidationFailed = true;
			// KeywordUtil.delay(2000);
		}
		if (beforeValidationFailed)
			RunCukesTest.logger.log(LogStatus.FAIL,
					"Toplosers value-percentage order of Toplosers was not as expected.");
		else
			RunCukesTest.logger.log(LogStatus.PASS, "Toplosers value-percentage order is as expected.  --PASS");
		MobileKeywords.mobileSwipe("1.0", 200, 200, 200, 550);// refresh
		MobileKeywords.mobileSwipe("1.0", 200, 200, 200, 550);// refresh
		MobileKeywords.mobileSwipe("1.0", 200, 550, 200, 200);// vertical
		for (int i = 0; i < 4; i++) {
			String val1 = GlobalUtil.getMDriver().findElementByAccessibilityId("Row1" + i + "_2_ChangeValue").getText();
			KeywordUtil.delay(2000);
			String val = GlobalUtil.getMDriver().findElementByAccessibilityId("Row1" + i + "_2_ChangePercentage")
					.getText();

			System.err.println("New change Val\t\t:" + val1);
			System.err.println("New change Percent\t:" + val);
			afterPct += val;
			afterValue += val1;
			if (val1.contains("%") & (!val.contains("%")))
				afterValidationFailed = true;
		}
		if (afterValidationFailed)
			RunCukesTest.logger.log(LogStatus.FAIL,
					"Toplosers value-percentage order of Toplosera is not as expected after screen refreshed.");
		else
			RunCukesTest.logger.log(LogStatus.PASS,
					"Toplosers value-percentage order is as expected after screen refreshed.  --PASS");
		MobileKeywords.mobileSwipe("1.0", 550, 200, 200, 200);// horizantal
		System.out.println();

	}
}
