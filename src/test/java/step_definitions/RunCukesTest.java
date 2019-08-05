package step_definitions;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import utilities.ConfigReader;
import utilities.ExcelDataUtil;
import utilities.GlobalUtil;
import utilities.HTMLReportUtil;
import utilities.HubConfigManager;
import utilities.KeywordUtil;
import utilities.LogUtil;

@CucumberOptions(

		features = "classpath:webFeatures",
		// glue ={"classpath:step_definitons"},
		plugin = { "pretty", "html:target/cucumber-html-report", "json:target/cucumber.json",
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" }, tags = {
						"@Test211" }, dryRun = false, monochrome = true

)
public class RunCukesTest extends AbstractTestNGCucumberTests {

	static ExtentReports extent;
	public static ExtentTest logger;

	@BeforeClass
	public void onStart() {
		HubConfigManager hcm = new HubConfigManager();
		hcm.main();
		extent = new ExtentReports(System.getProperty("user.dir") + ConfigReader.getValue("extentReportPath"));
		extent.loadConfig(new File(System.getProperty("user.dir") + ConfigReader.getValue("extentConfigPath")));
		// Get all the common setting from excel file that are required for
		GlobalUtil.setCommonSettings(ExcelDataUtil.getCommonSettings());

		String browser = GlobalUtil.getCommonSettings().getBrowser();
		String executionEnv = GlobalUtil.getCommonSettings().getExecutionEnv();
		String url = GlobalUtil.getCommonSettings().getUrl();
		if (browser == null)
			browser = ConfigReader.getValue("defaultBrowser");
		if (executionEnv == null)
			executionEnv = ConfigReader.getValue("defaultExecutionEnvironment");
		if (url == null)
			url = ConfigReader.getValue("BASE_URL");
		GlobalUtil.getCommonSettings().setUrl(url);
		LogUtil.infoLog(getClass(),
				"\n\n+===========================================================================================================+");
		LogUtil.infoLog(getClass(), " Suite started" + " at " + new Date());
		LogUtil.infoLog(getClass(), "Suite Execution For Android mobile application on version: "
				+ GlobalUtil.getCommonSettings().getAndroidVersion());
		LogUtil.infoLog(getClass(),
				"\n\n+===========================================================================================================+");
	}

	@AfterClass
	public void onFinish() {
		LogUtil.infoLog(getClass(), " suite finished" + " at " + new Date());
		LogUtil.infoLog(getClass(),
				"\n\n+===========================================================================================================+");
		extent.flush();
		extent.close();
	}

	String imagePath;
	String pathForLogger;
	String testCaseDescription;

	@Before
	public void beforeAndroidWebTestMethod(Scenario scenario) {

		if (scenario.getName().contains("_"))
			testCaseDescription = scenario.getName().split("_")[1];
		else
			testCaseDescription = scenario.getName();
		RunCukesTest.logger = RunCukesTest.extent.startTest(testCaseDescription);

		LogUtil.infoLog(getClass(), "\n+---------------------------------------------+");
		LogUtil.infoLog(getClass(), "Mobile Tests Started: " + scenario.getName());

		LogUtil.infoLog("Mobile Test Environment",
				"Mobile Test is executed in OS: " + GlobalUtil.getCommonSettings().getAndroidName());
	}

	@After
	public void afterAndroidWebTestMethod(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotFilePath = ConfigReader.getValue("screenshotPath") + "/" + "ScreenShot_"
					+ System.currentTimeMillis() + ".png";
			try {
				imagePath = HTMLReportUtil.testFailMobileTakeScreenshot(screenshotFilePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
			pathForLogger = RunCukesTest.logger.addScreenCapture(imagePath);
			RunCukesTest.logger.log(LogStatus.FAIL,
					HTMLReportUtil.failStringRedColor("Failed at point: " + pathForLogger) + GlobalUtil.e);
			scenario.embed(KeywordUtil.takeMobileScreenshot(screenshotFilePath), "image/png");
		} else {

			LogUtil.infoLog("TestEnded",
					"Test has ended closing Application: " + GlobalUtil.getCommonSettings().getAndroidName());
		}
		GlobalUtil.getMDriver().quit();
		RunCukesTest.extent.endTest(RunCukesTest.logger);
	}
}