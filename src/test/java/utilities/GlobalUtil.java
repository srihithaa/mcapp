package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
//import jirautil.JiraUtil;
import mobileutil.MobileKeywords;

/**
 * This class will get date and time and it will rename the file with date and
 * time
 *
 */
public class GlobalUtil extends MobileKeywords {

	private static CommonSettings commonSettings = new CommonSettings();
	private static WebDriver driver = null;

	private static AndroidDriver<AndroidElement> Mdriver = null;
	private static int totalSuites = 0;
	private static boolean suitesRunStarted = false;
	private static int lastRunId = 0;
	private static Exception testException;
	private static String currentBrowser;
	private static String currentSuiteName;
	private static String currentUserEmail;
	private static String currentUserType;
	static String currentUserFirstName;
	static String currentUserLastName;
	public static String currentUserFullName;
	public static Map<String, String> propertyCurrentRecord = new HashMap<>();
	public static HashMap<String, String> propertyDeletedRecord = new HashMap<>();
	public static HashMap<String, String> updatesScheduleRecord = new HashMap<>();
	public static HashMap<String, String> propertyRestoredRecord = new HashMap<>();
	public static ArrayList<String> listOfClients = new ArrayList<>();
	public static ArrayList<String> listOfProperties = new ArrayList<>();
	public static HashMap<String, String> client = new HashMap<>();
	static String clientFullName = "FullName";
	static String clientEmail = "Email";
	public static String result_FolderName = System.getProperty("user.dir") + "/target/cucumber-html-report";
	public static TestLinkUtil testlinkapi;
	// public static JiraUtil jiraapi;
	public static String ErrorMsg;
	public static Throwable e;

	// For HashMap
	public static final String PROPERTYADDRESSKEY = "Address";
	public static final String PROPERTYDATETIMEKEY = "DateTime";
	public static final String PROPERTYCLIENTKEY = "Client";
	public static final String PROPERTYAGENTKEY = "Agent";
	public static final String PROPERTYNOTEKEY = "Note";
	public static DesiredCapabilities capabilities = new DesiredCapabilities();
	public static String appium_ip_address = mobileutil.MobileKeywords.GetValue("appium_ip_address");
	public static String appium_port = mobileutil.MobileKeywords.GetValue("appium_port");

	protected static final HashMap<String, String> popupCurrentData = new HashMap<String, String>();

	/**
	 * Get data and time stamp
	 */

	public static AndroidDriver<AndroidElement> getMobileApp() {
		capabilities.setCapability("deviceName", HubConfigManager.deviceName);
		capabilities.setCapability("platformVersion", HubConfigManager.platformVersion);
		capabilities.setCapability("app", HubConfigManager.app);
		capabilities.setCapability("appPackage", HubConfigManager.appPackage);
		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("autoAcceptAlerts", true);
		capabilities.setCapability("disableWindowAnimation ", true);
		try {
			// URL url = new URL("http://" + appium_ip_address + ":" +
			// appium_port + "/wd/hub");
			URL url = new URL(HubConfigManager.appiumURL);
			System.out.println(url);
			while (2 > 1) {
				Mdriver = new AndroidDriver<>(url, capabilities);
				break;
			}
		} catch (MalformedURLException e) {
			System.err.println("Unnable to launch application in Android device.");
		}
		return Mdriver;
	}

	public static boolean tap(String path, String type) {
		WebElement element = (explicitWaitForElement(path, type));
		TouchAction action = new TouchAction((PerformsTouchActions) Mdriver);
		action.tap(element).perform();
		return true;
	}

	public static String getDateTime() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String dateOfExecution = dateFormat.format(date);
		return dateOfExecution;
	}

	/**
	 * Update filename with time stamp
	 */
	public static void renameFile() {

		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HHmmss");
		String timeStamp = dateFormat.format(date);

		try {

			File oldFile = new File(System.getProperty("user.dir") + ConfigReader.getValue("testResultExcelPath"));

			String newFilePath = oldFile.getAbsolutePath().replace(oldFile.getName(), "") + "\\ReportHistory\\"
					+ timeStamp + "-TestResult.xlsx";

			File newFile = new File(newFilePath);

			FileUtils.copyFile(oldFile, newFile);
			LogUtil.infoLog(GlobalUtil.class, "History File created successfully");

		} catch (IOException e) {
			LogUtil.errorLog(GlobalUtil.class, "Exception caught", e);
		}
	}

	// =======================
	/**
	 * @return
	 */

	/**
	 * @return
	 */
	public static CommonSettings getCommonSettings() {
		return commonSettings;
	}

	/**
	 * @param commonSettings
	 */
	public static void setCommonSettings(CommonSettings commonSettings) {
		GlobalUtil.commonSettings = commonSettings;
	}

	/**
	 * @return
	 */
	public static int getTotalSuites() {
		return totalSuites;
	}

	/**
	 * @param totalSuites
	 */
	public static void setTotalSuites(int totalSuites) {
		GlobalUtil.totalSuites = totalSuites;
	}

	/**
	 * @return
	 */
	public static boolean isSuitesRunStarted() {
		return suitesRunStarted;
	}

	/**
	 * @param suitesRunStarted
	 */
	public static void setSuitesRunStarted(boolean suitesRunStarted) {
		GlobalUtil.suitesRunStarted = suitesRunStarted;
	}

	/**
	 * @return
	 */
	public static int getLastRunId() {
		return lastRunId;
	}

	/**
	 * @param lastRunId
	 */
	public static void setLastRunId(int lastRunId) {
		GlobalUtil.lastRunId = lastRunId;
	}

	/**
	 * @return
	 */
	public static Exception getTestException() {
		return testException;
	}

	/**
	 * @param testException
	 */
	public static void setTestException(Exception testException) {
		GlobalUtil.testException = testException;
	}

	/**
	 * @return the currentBrowser
	 */
	public static String getCurrentBrowser() {
		return currentBrowser;
	}

	/**
	 * @param currentBrowser
	 *            the currentBrowser to set
	 */
	public static void setCurrentBrowser(String currentBrowser) {
		GlobalUtil.currentBrowser = currentBrowser;
	}

	/**
	 * @return the currentSuiteName
	 */
	public static String getCurrentSuiteName() {
		return currentSuiteName;
	}

	/**
	 * @param currentSuiteName
	 *            the currentSuiteName to set
	 */
	public static void setCurrentSuiteName(String currentSuiteName) {
		GlobalUtil.currentSuiteName = currentSuiteName;
	}

	/**
	 * @return the currentUserEmail
	 */
	public static String getCurrentUserEmail() {
		return currentUserEmail;
	}

	/**
	 * @param currentUserEmail
	 *            the currentUserEmail to set
	 */
	public static void setCurrentUserEmail(String currentUserEmail) {
		GlobalUtil.currentUserEmail = currentUserEmail;
	}

	/**
	 * @return the currentUserType
	 */
	public static String getCurrentUserType() {
		return currentUserType;
	}

	/**
	 * @param currentUserType
	 *            the currentUserType to set
	 */
	public static void setCurrentUserType(String currentUserType) {
		GlobalUtil.currentUserType = currentUserType;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static AndroidDriver<AndroidElement> getMDriver() {
		return Mdriver;
	}

	public static void setMDriver(AndroidDriver<AndroidElement> driver) {
		Mdriver = driver;
	}

	/**
	 * @param driver
	 *            the driver to set
	 */
	public static void setDriver(WebDriver driver) {
		GlobalUtil.driver = driver;
	}

	public static String createZipFile() throws IOException {
		result_FolderName = result_FolderName.replace("\\", "/");
		String outputFile = result_FolderName + ".zip";
		FileOutputStream fos = new FileOutputStream(outputFile);
		ZipOutputStream zos = new ZipOutputStream(fos);
		packCurrentDirectoryContents(result_FolderName, zos);
		zos.closeEntry();
		zos.close();
		fos.close();
		return outputFile;
	}

	public static void packCurrentDirectoryContents(String directoryPath, ZipOutputStream zos) throws IOException {

		for (String dirElement : new File(directoryPath).list()) {

			String dirElementPath = directoryPath + "/" + dirElement;

			if (new File(dirElementPath).isDirectory()) {
				packCurrentDirectoryContents(dirElementPath, zos);

			} else {
				ZipEntry ze = new ZipEntry(dirElementPath.replaceAll(result_FolderName + "/", ""));

				zos.putNextEntry(ze);

				FileInputStream fis = new FileInputStream(dirElementPath);
				byte[] bytesRead = new byte[512];

				int bytesNum;
				while ((bytesNum = fis.read(bytesRead)) > 0) {
					zos.write(bytesRead, 0, bytesNum);
				}

				fis.close();
			}
		}

	}

}
