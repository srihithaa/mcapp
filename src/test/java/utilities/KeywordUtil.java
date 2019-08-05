package utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.relevantcodes.extentreports.LogStatus;

import step_definitions.RunCukesTest;

/**
 * @author TX
 *
 */
public class KeywordUtil extends GlobalUtil {
	public static String cucumberTagName;
	private static final int DEFAULT_WAIT_SECONDS = 0;
	protected static final int FAIL = 0;
	static WebElement webElement;
	protected static String url = "";
	private static String userDir = "user.dir";
	public static final String VALUE = "value";
	public static String lastAction = "";
	public static Xlsx_Reader AutomationDataSheet;

	public static void onExecutionFinish() {
		String htmlReportFile = System.getProperty("user.dir") + "/" + ConfigReader.getValue("HtmlReportFullPath");
		System.out.println("cucumber path is" + htmlReportFile);
		File f = new File(htmlReportFile);
		if (f.exists())
			try {
				Runtime.getRuntime().exec(
						"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe \"" + htmlReportFile + "\"");
			} catch (IOException e) {
				e.printStackTrace();
			}
		if (cucumberTagName.equals("Mobile") || cucumberTagName.equals("Web")) {
			String htmlExtentReportFile = System.getProperty("user.dir") + "\\"
					+ ConfigReader.getValue("extentReportPath");
			File extentReport = new File(htmlExtentReportFile);
			if (extentReport.exists()) {
				try {
					Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe \""
							+ htmlExtentReportFile + "\"");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static byte[] takeScreenshot(String screenshotFilePath) {
		try {
			byte[] screenshot = ((TakesScreenshot) GlobalUtil.getDriver()).getScreenshotAs(OutputType.BYTES);
			FileOutputStream fileOuputStream = new FileOutputStream(screenshotFilePath);
			fileOuputStream.write(screenshot);
			fileOuputStream.close();
			return screenshot;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean scrollingToElementofAPage(By locator, String logStep) throws InterruptedException {
		Thread.sleep(5000);
		WebElement element = GlobalUtil.getDriver().findElement(locator);
		((JavascriptExecutor) GlobalUtil.getDriver()).executeScript("arguments[0].scrollIntoView();", element);
		// highLightElement(driver, element);
		RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

		return true;
	}

	public static byte[] takeMobileScreenshot(String screenshotFilePath) {
		try {
			byte[] screenshot = ((TakesScreenshot) GlobalUtil.getMDriver()).getScreenshotAs(OutputType.BYTES);
			FileOutputStream fileOuputStream = new FileOutputStream(screenshotFilePath);
			fileOuputStream.write(screenshot);
			fileOuputStream.close();
			return screenshot;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getCurrentDateTime() {

		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMddHHmmss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		System.out.println(strDate);
		return strDate;
	}

	/**
	 * @param locator
	 * @return
	 */
	public static void navigateToUrl(String url) {
		try {
			KeywordUtil.lastAction = "Navigate to: " + url;
			LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
			getDriver().navigate().to(url);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static String getCurrentUrl() {
		return getDriver().getCurrentUrl();
	}

	public static WebElement waitForClickable(By locator) {
		WebDriverWait wait = new WebDriverWait(getMDriver(), DEFAULT_WAIT_SECONDS);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(WebDriverException.class);

		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static WebElement waitForClickable(By locator, int WaitSeconds) {
		WebDriverWait wait = new WebDriverWait(getDriver(), WaitSeconds);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(WebDriverException.class);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static boolean clickTest(By locator, String logStep) {
		KeywordUtil.lastAction = "Click: " + locator.toString();
		LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
		getDriver().findElement(locator).click();
		RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));
		return true;
	}

	/**
	 * @param locator
	 * @return
	 */
	public static WebElement waitForPresent(By locator) {
		WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_WAIT_SECONDS);
		wait.ignoring(ElementNotVisibleException.class);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * @param locator
	 * @return
	 */
	public static WebElement waitForVisible(By locator) {
		try {
			// WebDriverWait wait = new WebDriverWait(getDriver(),
			// DEFAULT_WAIT_SECONDS);
			WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), DEFAULT_WAIT_SECONDS);
			// wait.ignoring(ElementNotVisibleException.class);
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean waitForInVisibile(By locator) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public static WebElement waitForVisibleIgnoreStaleElement(By locator) {
		WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_WAIT_SECONDS);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(ElementNotVisibleException.class);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * @param locator
	 * @param seconds
	 * @param poolingMil
	 * @return
	 * @throws Exception
	 */
	public static WebElement findWithFluintWait(By locator, int seconds, int poolingMil) throws Exception {
		// Because if implicit wait is set then fluint wait will not work

		getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
		WebElement element = null;
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver()).withTimeout(seconds, TimeUnit.SECONDS)
					.pollingEvery(poolingMil, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class).ignoring(ElementNotVisibleException.class)
					.ignoring(WebDriverException.class);
			element = wait.until(new Function<WebDriver, WebElement>() {
				@Override
				public WebElement apply(WebDriver driver) {
					return driver.findElement(locator);
				}
			});

		} catch (Exception t) {
			throw new Exception("Timeout reached when searching for element! Time: " + seconds + " seconds " + "\n"
					+ t.getMessage());
		} finally {
			// getDriver().manage().timeouts().implicitlyWait(Utility.getIntValue("implicitlyWait"),
			// TimeUnit.SECONDS);
		}

		return element;
	}// End FindWithWait()

	/**
	 * @param locator
	 * @return
	 * @throws Exception
	 */
	public static WebElement findWithFluintWait(By locator) throws Exception {
		getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
		// Because if implict wait is set then fluint wait will not work
		KeywordUtil.lastAction = "Find Element: " + locator.toString();
		// getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebElement element = null;

		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
					.withTimeout(DEFAULT_WAIT_SECONDS, TimeUnit.SECONDS).pollingEvery(200, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class)
					.ignoring(ElementNotVisibleException.class);

			element = wait.until(new Function<WebDriver, WebElement>() {
				@Override
				public WebElement apply(WebDriver driver) {
					return driver.findElement(locator);
				}
			});

		} catch (Exception t) {
			throw new Exception("Timeout reached when searching for element! Time: " + DEFAULT_WAIT_SECONDS
					+ " seconds " + "\n" + t.getMessage());
		} finally {
			// getDriver().manage().timeouts().implicitlyWait(Utility.getIntValue("implicitlyWait"),
			// TimeUnit.SECONDS);
		}

		return element;
	}// End FindWithWait()

	public static WebElement getWebElement(By locator) throws Exception {
		KeywordUtil.lastAction = "Find Element: " + locator.toString();
		LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
		return findWithFluintWait(locator);
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/*
	 * Web driver common functions
	 * ===========================================================
	 */

	/**
	 * @param locator
	 * @return
	 */
	public static boolean click(By locator, String logStep) {

		KeywordUtil.lastAction = "Click: " + locator.toString();
		LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
		WebElement elm = waitForClickable(locator);
		if (elm == null) {
			return false;
		} else {
			((JavascriptExecutor) GlobalUtil.getDriver()).executeScript("arguments[0].scrollIntoView();", elm);
			elm.click();
			RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

			return true;
		}
	}

	public static boolean acceptAlert() {

		Alert alert = GlobalUtil.getDriver().switchTo().alert();
		alert.accept();
		return true;

	}

	/**
	 * @param linkText
	 * @return
	 */
	public static boolean clickLink(String linkText, String logStep) {
		KeywordUtil.lastAction = "Click Link: " + linkText;
		LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
		WebElement elm = waitForClickable(By.linkText(linkText));
		if (elm == null) {
			return false;
		} else {
			elm.click();
			RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

			return true;
		}
	}

	/**
	 * @param locator
	 * @return
	 */
	public static String getElementText(By locator) {
		KeywordUtil.lastAction = "Get Element text: " + locator.toString();
		LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
		WebElement elm = waitForClickable(locator);
		return elm.getText().trim();
	}

	public static String getImageTitle(By locator) {
		WebElement elm = waitForVisible(locator);
		return elm.getAttribute("title");

	}

	/**
	 * @param locator
	 * @return
	 */
	public static boolean isWebElementVisible(By locator, String logStep) {
		try {
			KeywordUtil.lastAction = "Check Element visible: " + locator.toString();
			LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
			WebElement elm = waitForVisible(locator);
			RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

			return elm.isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}

	public static boolean isWebElementEnable(By locator, String logStep) {
		KeywordUtil.lastAction = "Check Element visible: " + locator.toString();
		LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
		WebElement elm = waitForVisible(locator);
		RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

		return elm.isEnabled();
	}

	/**
	 * @param locator
	 * @return
	 */
	public static List<WebElement> getListElements(By locator, String logStep) {
		KeywordUtil.lastAction = "Get List of Elements: " + locator.toString();
		LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);

		try {
			findWithFluintWait(locator, 60, 300);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

		return getDriver().findElements(locator);

	}

	public static boolean isWebElementPresent(By locator, String logStep) {
		KeywordUtil.lastAction = "Check Element present: " + locator.toString();
		LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
		List<WebElement> elements = getDriver().findElements(locator);
		if (elements.isEmpty()) {
			return false;
		}
		RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

		return true;
	}

	public static boolean hoverOnElement(By by) throws InterruptedException {

		WebElement element = getDriver().findElement(by);
		// highLightElement(driver,element );
		// Thread.sleep(5000);

		Actions act = new Actions(getDriver());
		act.moveToElement(element).build().perform();

		Thread.sleep(3000);

		return true;

	}

	/**
	 * @param locator
	 * @return
	 */
	public static boolean isWebElementNotPresent(By locator) {
		KeywordUtil.lastAction = "Check Element not present: " + locator.toString();
		LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
		List<WebElement> elements = (new WebDriverWait(getDriver(), DEFAULT_WAIT_SECONDS))
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

		if (elements.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * @param locator
	 * @param data
	 * @return
	 */
	public static boolean enterText(By locator, String data, String logStep) {
		KeywordUtil.lastAction = "Click: " + locator.toString();
		LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
		getDriver().findElement(locator).sendKeys(data);
		RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));
		return true;
	}

	public static boolean inputText(By locator, String data, String logStep) {
		KeywordUtil.lastAction = "Input Text: " + data + " - " + locator.toString();
		LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
		WebElement elm = waitForVisible(locator);
		if (elm == null) {
			return false;
		} else {
			// elm.clear();
			elm.sendKeys(data);
			RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));
			return true;
		}
	}

	public static void pressTabKey(By locator) {
		WebElement elm = waitForVisible(locator);
		elm.sendKeys(Keys.TAB);
	}

	public static void pressEnter(By locator) {
		WebElement elm = waitForVisible(locator);
		elm.sendKeys(Keys.ENTER);
	}

	/**
	 * @param locator
	 * @param data
	 * @return
	 */
	public static boolean inputTextJS(By locator, String data, String logStep) {
		KeywordUtil.lastAction = "Input Text: " + data + " - " + locator.toString();
		LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
		WebElement element = waitForVisible(locator);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].value = arguments[1]", element, data);
		if (element.getText().equalsIgnoreCase(data)) {
			RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

			return true;
		} else
			return false;
	}

	/**
	 * @param locator
	 * @return
	 */
	public static boolean isRadioSelected(By locator, String logStep) {
		KeywordUtil.lastAction = "Is Radio Selected: " + locator.toString();
		LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
		WebElement element = waitForVisible(locator);
		RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

		return element.isSelected();
	}

	/**
	 * @param locator
	 * @return
	 */
	public static boolean isRadioNotSelected(By locator, String logStep) {
		KeywordUtil.lastAction = "Is Radio Not Selected: " + locator.toString();
		LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
		boolean check = isRadioSelected(locator, logStep);
		RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

		return (!check);
	}

	/**
	 * @param locator
	 * @return
	 */
	public static boolean clearInput(By locator) {
		WebElement element = waitForVisible(locator);
		element.clear();
		element = waitForVisible(locator);
		return element.getAttribute(VALUE).isEmpty();
	}

	/**
	 * @param locator
	 * @param data
	 * @return
	 */
	public static boolean verifyCssProperty(By locator, String data, String logStep) {
		KeywordUtil.lastAction = "Verify CSS : " + data + " - " + locator.toString();
		LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);

		String[] property = data.split(":", 2);
		String expProp = property[0];
		String expValue = property[1];
		boolean flag = false;
		String prop = (waitForPresent(locator)).getCssValue(expProp);
		if (prop.trim().equals(expValue.trim())) {
			flag = true;
			RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

			return flag;
		} else {
			return flag;
		}
	}

	/**
	 * @param locator
	 * @param data
	 * @return
	 */
	public static boolean verifyInputText(By locator, String data, String logStep) {
		KeywordUtil.lastAction = "Verify Input Expected Text: " + data + " - " + locator.toString();
		LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
		WebElement element = waitForVisible(locator);
		String actual = element.getAttribute(VALUE);
		LogUtil.infoLog(KeywordUtil.class, "Actual:" + actual);
		RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

		return actual.equalsIgnoreCase(data);

	}

	/**
	 * @param locator
	 * @param data
	 * @return
	 */
	public static boolean verifyInputTextJS(By locator, String data, String logStep) {
		KeywordUtil.lastAction = "Verify Input Expected Text: " + data + " - " + locator.toString();
		LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
		WebElement element = waitForVisible(locator);

		String message = String.format("Verified text expected \"%s\" actual \"%s\" ", data, element.getText());
		LogUtil.infoLog(KeywordUtil.class, message);
		RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

		return data.equalsIgnoreCase(element.getText());
	}

	/**
	 * <h1>Log results</h1>
	 * <p>
	 * This function will write results to the log file.
	 * </p>
	 * 
	 * @param locator
	 * @param data
	 * @return
	 */
	/**
	 * @param locator
	 * @param data
	 * @return
	 */
	public static boolean verifyText(By locator, String data, String logStep) {
		KeywordUtil.lastAction = "Verify Expected Text: " + data + " - " + locator.toString();
		LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
		WebElement element = waitForVisible(locator);
		String message = String.format("Verified text expected \"%s\" actual \"%s\" ", data, element.getText());
		LogUtil.infoLog(KeywordUtil.class, message);
		RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

		return element.getText().equalsIgnoreCase(data);

	}

	public static boolean verifyTextContains(By locator, String data, String logStep) {
		KeywordUtil.lastAction = "Verify Text Contains: " + data + " - " + locator.toString();
		LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
		WebElement element = waitForVisible(locator);
		String message = new String(
				String.format("Verified text expected \"%s\" actual \"%s\" ", data, element.getText()));
		LogUtil.infoLog(KeywordUtil.class, message);
		RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

		return element.getText().toUpperCase().contains(data.toUpperCase());

	}

	/**
	 * @param locator
	 * @return
	 */
	public static boolean verifyDisplayAndEnable(By locator, String logStep) {
		KeywordUtil.lastAction = "Is Element Displayed and Enable : " + locator.toString();
		LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
		WebElement element = waitForVisible(locator);
		RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));
		return element.isDisplayed() && element.isEnabled();
	}

	/**
	 * @param locator
	 * @param data
	 * @return
	 */
	public static boolean clickJS(By locator, String logStep) {
		KeywordUtil.lastAction = "Click : " + locator.toString();
		LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
		WebElement element = waitForVisible(locator);
		Object obj = ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
		RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

		return obj == null;
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/*
	 * Handling selects
	 * ===========================================================
	 */

	/**
	 * @param locator
	 * @param index
	 * @return
	 */
	public static boolean selectByIndex(By locator, int index, String logStep) {
		KeywordUtil.lastAction = "Select dropdown by index : " + index + " - " + locator.toString();
		LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
		Select sel = new Select(getDriver().findElement(locator));
		sel.selectByIndex(index);

		// Check whether element is selected or not
		sel = new Select(getDriver().findElement(locator));
		if (sel.getFirstSelectedOption().isDisplayed()) {
			RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param locator
	 * @param value
	 * @return
	 */
	public static boolean selectByValue(By locator, String value, String logStep) {
		KeywordUtil.lastAction = "Select dropdown by value : " + value + " - " + locator.toString();
		LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
		Select sel = new Select(getDriver().findElement(locator));
		sel.selectByValue(value);

		// Check whether element is selected or not
		sel = new Select(getDriver().findElement(locator));
		if (sel.getFirstSelectedOption().isDisplayed()) {
			RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param locator
	 * @param value
	 * @return
	 */
	public static boolean selectByVisibleText(By locator, String value, String logStep) {
		try {
			KeywordUtil.lastAction = "Select dropdown by text : " + value + " - " + locator.toString();
			LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
			Select sel = new Select(getDriver().findElement(locator));
			sel.selectByVisibleText(value);
			RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		// Check whether element is selected or not
		// sel = new Select(getDriver().findElement(locator));
		// if (sel.getFirstSelectedOption().getText().equalsIgnoreCase(value)) {
		// return true;
		// } else {
		// return false;
		// }
	}

	/**
	 * @param locator
	 * @param data
	 * @return
	 * @throws Throwable
	 */
	public static boolean verifyAllValuesOfDropDown(By locator, String data, String logStep) throws Throwable {
		KeywordUtil.lastAction = "Verify Dropdown all values: " + data + " - " + locator.toString();
		LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
		boolean flag = false;
		WebElement element = findWithFluintWait(locator);
		List<WebElement> options = element.findElements(By.tagName("option"));
		String[] allElements = data.split(",");
		String actual;
		for (int i = 0; i < allElements.length; i++) {
			LogUtil.infoLog(KeywordUtil.class, options.get(i).getText());
			LogUtil.infoLog(KeywordUtil.class, allElements[i].trim());

			actual = options.get(i).getText().trim();
			if (actual.equalsIgnoreCase(allElements[i].trim())) {
				RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		return flag;
	}

	/**
	 * @param locator
	 * @param data
	 * @return
	 */
	public static boolean verifyDropdownSelectedValue(By locator, String data, String logStep) {
		KeywordUtil.lastAction = "Verify Dropdown selected option: " + data + " - " + locator.toString();
		LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
		Select sel = new Select(waitForVisible(locator));
		String defSelectedVal = sel.getFirstSelectedOption().getText();
		RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));
		return defSelectedVal.trim().equals(data.trim());
	}

	/**
	 * @param locator
	 * @param size
	 * @return
	 */
	public static boolean verifyElementSize(By locator, int size, String logStep) {
		KeywordUtil.lastAction = "Verify Element size: " + size + " - " + locator.toString();
		LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
		List<WebElement> elements = getDriver().findElements(locator);
		if (elements.size() == size) {
			LogUtil.infoLog(KeywordUtil.class, "Element is Present " + size + "times");
			RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

			return true;
		} else {
			LogUtil.infoLog(KeywordUtil.class, "Element is not Present with required size");
			LogUtil.infoLog(KeywordUtil.class, "Expected size:" + size + " but actual size: " + elements.size());
			return false;
		}
	}

	/**
	 * @param locator
	 * @param data
	 * @return
	 * @throws InterruptedException
	 */
	public static boolean writeInInputCharByChar(By locator, String data, String logStep) throws InterruptedException {
		WebElement element = waitForVisible(locator);
		element.clear();
		String[] b = data.split("");
		for (int i = 0; i < b.length; i++) {
			element.sendKeys(b[i]);
			Thread.sleep(250);
		}
		RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

		return true;
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//
	// /**
	// * @param check
	// * @param className
	// * @param logstep
	// * @throws Exception
	// */
	// public static void executeStep(Boolean check, String logstep) throws
	// Exception {
	// if (check) {
	// logStepPass(logstep);
	// } else {
	// logStepFail(logstep);
	// throw new Exception("Step failed - " + logstep);
	// }
	// }

	/**
	 * @param check
	 * @param className
	 * @param logstep
	 * @throws Exception
	 *             //
	 */
	// public static void verifyStep(Boolean check, String logstep) throws
	// TestStepFailedException {
	// if (check) {
	// logStepPass(logstep);
	// } else {
	// logStepFail(logstep);
	// throw new TestStepFailedException("Varification failed-->" + logstep );
	// }
	// }

	// Get Tag name and locator value of Element
	public static String getElementInfo(By locator) throws Exception {
		return " Locator: " + locator.toString();
	}

	public static String getElementInfo(WebElement element) throws Exception {
		String webElementInfo = "";
		webElementInfo = webElementInfo + "Tag Name: " + element.getTagName() + ", Locator: ["
				+ element.toString().substring(element.toString().indexOf("->") + 2);
		return webElementInfo;

	}

	/**
	 * @param time
	 * @throws InterruptedException
	 */
	public static void delay(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
		}
	}

	/**
	 * @param locator
	 * @return
	 */
	public boolean verifyCurrentDateInput(By locator, String logStep) {
		boolean flag = false;
		WebElement element = waitForVisible(locator);
		String actual = element.getAttribute(VALUE).trim();
		DateFormat dtFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		dtFormat.setTimeZone(TimeZone.getTimeZone("US/Central"));
		String expected = dtFormat.format(date).trim();
		if (actual.trim().contains(expected)) {
			RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

			flag = true;

		}
		return flag;
	}

	/**
	 * @param locator
	 * @param data
	 * @return
	 * @throws InterruptedException
	 */
	public static boolean uploadFilesUsingSendKeys(By locator, String data, String logStep)
			throws InterruptedException {
		WebElement element = waitForVisible(locator);
		element.clear();
		element.sendKeys(System.getProperty(userDir) + "\\src\\test\\resources\\uploadFiles\\" + data);
		RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

		return true;
	}

	// /**
	// * @param data
	// * @param page
	// * @param fileName
	// * @return
	// * @throws IOException
	// */
	// public static boolean verifyPDFData(String data, int page, String
	// fileName) throws IOException {
	// FileInputStream fis = null;
	// String dwnFile = null;
	// try {
	//
	// String dirName = System.getProperty(userDir) +
	// "\\src\\test\\resources\\downloadFile\\";
	// File dir = new File(dirName);
	// File[] path1 = dir.listFiles();
	//
	// for (int k = 0; k < path1.length; k++) {
	// dwnFile = path1[k].toString();
	// if (dwnFile.contains(fileName)) {
	// break;
	// }
	//
	// continue;
	// }
	// File file = new File(dwnFile);
	// fis = new FileInputStream(file.getAbsolutePath());
	// PdfReader text = new PdfReader(fis);
	// String expected = PdfTextExtractor.getTextFromPage(text, page);
	//
	// String[] b = data.split(",");
	// fis.close();
	// for (int i = 0; i < b.length; i++) {
	// if (expected.contains(b[i]))
	// continue;
	// }
	// } catch (Exception e) {
	// LogUtil.errorLog(KeywordUtil.class, e.getMessage(), e);
	// }
	// return true;
	// }

	/**
	 * @return
	 */
	public boolean delDirectory() {
		File delDestination = new File(System.getProperty(userDir) + "\\src\\test\\resources\\downloadFile");
		if (delDestination.exists()) {
			File[] files = delDestination.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					delDirectory();
				} else {
					files[i].delete();
				}
			}
		}
		return delDestination.delete();
	}

	// public static void hoverElement(By locator) throws InterruptedException{
	// KeywordUtil.lastAction="Hover Element: "+locator.toString();
	// LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
	//
	// WebElement element = waitForClickable(locator);
	// Point p =element.getLocation();
	// Actions builder = new Actions(getDriver());
	// builder.moveToElement(element, p.getX(), p.getY()).build().perform();
	// pause(1000);
	//
	// }
	public static boolean doubleClick(By locator, String logStep) {
		boolean result = false;
		try {
			KeywordUtil.lastAction = "Double click: " + locator.toString();
			LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
			WebElement element = getDriver().findElement(locator);
			Actions action = new Actions(getDriver()).doubleClick(element);
			action.build().perform();
			RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

			result = true;

		} catch (StaleElementReferenceException e) {
			LogUtil.infoLog("DoubleClick",
					locator.toString() + " - Element is not attached to the page document " + e.getStackTrace());
			result = false;
		} catch (NoSuchElementException e) {
			LogUtil.infoLog("DoubleClick",
					locator.toString() + " - Element is not attached to the page document " + e.getStackTrace());
			result = false;
		} catch (Exception e) {
			LogUtil.infoLog("DoubleClick",
					locator.toString() + " - Element is not attached to the page document " + e.getStackTrace());
			result = false;
		}
		return result;
	}

	public static boolean switchToFrame(String frameName) {

		try {
			getDriver().switchTo().frame(frameName);
			return true;

		} catch (Exception e) {
			LogUtil.infoLog("switchToFrame", frameName + " TO FRAME FAILED" + e.getStackTrace());
			return false;
		}
	}

	public static String getDataFromAutomationControlSheet(String SheetName, String Control)
			throws InterruptedException {
		Xlsx_Reader AutomationControlSheet = new Xlsx_Reader(
				System.getProperty("user.dir") + "\\src\\test\\resources\\ExcelFiles\\AutomationControlSheet.xlsx");
		String ProjectName = AutomationControlSheet.getCellData(SheetName, Control);
		return ProjectName;

	}

	public static boolean switchToFrameIndex(int frameIndex) {

		try {
			getDriver().switchTo().frame(frameIndex);
			return true;

		} catch (Exception e) {
			LogUtil.infoLog("switchToFrame", frameIndex + " TO FRAME FAILED" + e.getStackTrace());
			return false;
		}
	}

	public static boolean switchToFrameById(By locator) {

		try {
			WebElement fr = getDriver().findElement(locator);
			getDriver().switchTo().frame(fr);

			return true;

		} catch (Exception e) {
			LogUtil.infoLog("switchToFrame", " TO FRAME FAILED" + e.getStackTrace());
			return false;
		}
	}

	public static String generateRandomEmail() {

		String emailBody = "abcdefghijklmnopqrstuvwxyz1234567890";
		StringBuilder emailFL = new StringBuilder();
		Random rnd = new Random();
		while (emailFL.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * emailBody.length());
			emailFL.append(emailBody.charAt(index));
		}
		String emailStr = emailFL.toString();
		String email = emailStr + "@gmail.com";
		return email;
	}
}
