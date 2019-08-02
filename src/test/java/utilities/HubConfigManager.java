package utilities;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Automated hub-node management class for plug and play connectivity of android
 * device to selenium grid.
 * 
 * @author vidyasagar.mada
 * @since Aug 1st 2019
 */
public class HubConfigManager {
	int hubPort = 1221;
	int nodePort = 4723;
	public static String appiumURL;
	public static String deviceName;
	public static String platformVersion;
	public static String udid;
	public static String app;
	public static String appPackage;

	public void main() {
		startSeleniumGrid();
		HubConfigManager.appiumURL = updateJSON();
		KeywordUtil.delay(3000);
		hookMobileNodeToGrid();
		// To unlock Device use "adb shell input keyevent 224"
	}

	public void startSeleniumGrid() {
		excCommandNewWindow("java -jar " + System.getProperty("user.dir")
				+ "/lib/selenium-server-standalone-3.141.59.jar -role hub -port " + hubPort);
	}

	public void hookMobileNodeToGrid() {
		excCommandNewWindow("appium --nodeconfig " + System.getProperty("user.dir") + "/lib/node1_Config.json");
	}

	public void downloadFileFromInternet(String fileURL) {
		URL url;
		URLConnection con;
		DataInputStream dis;
		FileOutputStream fos;
		byte[] fileData;
		try {
			url = new URL(fileURL); // File Location goes here
			con = url.openConnection(); // open the url connection.
			dis = new DataInputStream(con.getInputStream());
			fileData = new byte[con.getContentLength()];
			for (int q = 0; q < fileData.length; q++) {
				fileData[q] = dis.readByte();
			}
			dis.close(); // close the data input stream
			fos = new FileOutputStream(new File("/Users/kfang/Documents/Download/file.pdf")); // FILE
																								// Save
																								// Location
																								// goes
																								// here
			fos.write(fileData); // write out the file we want to save.
			fos.close(); // close the output stream writer
		} catch (Exception m) {
			System.out.println(m);
		}
	}

	public String updateJSON() {
		String appiumURL = null;
		String fileJSON = fileAsString(System.getProperty("user.dir") + "/lib/defaultNode.json");
		JSONObject root = new JSONObject(fileJSON);
		JSONArray capsArrayRoot = (JSONArray) root.get("capabilities");
		JSONObject capsObj = (JSONObject) capsArrayRoot.get(0);
		if (!capsObj.get("deviceName").toString().isEmpty())
			capsObj.remove("deviceName");
		capsObj.put("deviceName", readCmd("adb shell getprop ro.product.model"));
		deviceName = (String) capsObj.get("deviceName");
		if (!capsObj.get("platformVersion").toString().isEmpty())
			capsObj.remove("platformVersion");
		capsObj.put("platformVersion", readCmd("adb shell getprop ro.build.version.release"));
		platformVersion = (String) capsObj.get("platformVersion");
		if (!capsObj.get("udid").toString().isEmpty())
			capsObj.remove("udid");
		capsObj.put("udid", readCmd("adb shell getprop ro.serialno"));
		udid = (String) capsObj.get("udid");
		appPackage = capsObj.get("appPackage").toString();
		if (!capsObj.get("app").toString().isEmpty())
			capsObj.remove("app");
		capsObj.put("app", System.getProperty("user.dir").replace("\\", "/") + "/src/test/resources/APK/base.apk");
		app = (String) capsObj.get("app");
		InetAddress inetAddress;
		String myIP = null;
		try {
			inetAddress = InetAddress.getLocalHost();
			myIP = inetAddress.getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		JSONObject capsConfig = (JSONObject) root.get("configuration");
		if (!capsConfig.get("hubPort").toString().isEmpty())
			capsConfig.remove("hubPort");
		capsConfig.put("hubPort", hubPort);
		if (!capsConfig.get("port").toString().isEmpty())
			capsConfig.remove("port");
		capsConfig.put("port", nodePort);
		if (!capsConfig.get("url").toString().isEmpty())
			capsConfig.remove("url");
		capsConfig.put("url", "http://" + myIP + ":" + nodePort + "/wd/hub");
		appiumURL = (String) capsConfig.get("url");
		if (!capsConfig.get("hub").toString().isEmpty())
			capsConfig.remove("hub");
		capsConfig.put("hub", "http://" + myIP + ":" + hubPort + "/grid/register");
		if (!capsConfig.get("hubHost").toString().isEmpty())
			capsConfig.remove("hubHost");
		capsConfig.put("hubHost", myIP);
		if (!capsConfig.get("host").toString().isEmpty())
			capsConfig.remove("host");
		capsConfig.put("host", myIP);
		saveStringToFile(root.toString(), System.getProperty("user.dir") + "/lib/node1_Config.json");
		return appiumURL;
	}

	public String fileAsString(String filePath) {
		String fileAsString = null;
		try {
			BufferedReader buf = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
			String line = buf.readLine();
			StringBuilder sb = new StringBuilder();
			while (line != null) {
				sb.append(line).append("\n");
				line = buf.readLine();
			}
			fileAsString = sb.toString();
			buf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileAsString;
	}

	public void saveStringToFile(String valueToWrite, String filePath) {
		try {
			FileWriter fw = new FileWriter(filePath);
			fw.write(valueToWrite);
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void excCommandNewWindow(String cmd) {
		try {
			Runtime.getRuntime().exec("cmd.exe /c start cmd /k " + cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String readCmd(String cmd) {
		String op = null;
		try {
			Process p = Runtime.getRuntime().exec(cmd);
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = input.readLine()) != null) {
				op += line;
			}
			input.close();
		} catch (Exception err) {
			err.printStackTrace();
		}
		return op.replace("null", "");
	}
}