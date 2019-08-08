package locators.ios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import mobileutil.MobileKeywords;

public class HomePageLocators extends MobileKeywords {

	public static final String type_xpath = "xPath";
	public static final String type_name = "name";

	@FindBy(name = "Close Advertisement")
	public WebElement clodeAd;
	public static By profile_icon = By.xpath("//*[@name='user inactive']");
	public static By profile_icon1 = By.xpath("//*[@name='user active']");
	public static String newsbutton1 = "//*[@resource-id='com.divum.MoneyControl:id/bottomTabs']/android.widget.RelativeLayout[@index='3']";
	public static String portfolio_profile = "//*[@resource-id='com.divum.MoneyControl:id/header_user_icon_img']";
	public static String closeadd = "//*[@content-desc='Interstitial close button']";
	public static By newsTab = By.xpath("//*[@name='News']");
}
