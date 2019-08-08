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
	int hubPort = 1223;
	int nodePort = 4723;
	public static String appiumURL;
	public static String deviceName;
	public static String platformVersion;
	public static String udid;
	public static String app;
	public static String appPackage;

	public void main() {
		String seleniumPath = System.getProperty("user.dir") + "/lib/selenium-server-standalone-3.2.0.jar";
		if (!new File(seleniumPath).exists())
			downloadFileFromInternet(
					"https://selenium-release.storage.googleapis.com/3.2/selenium-server-standalone-3.2.0.jar",
					seleniumPath);
		startSeleniumGrid();
		// HubConfigManager.appiumURL = updateAndroidJSON();
		HubConfigManager.appiumURL = updateiOSJSON();
		KeywordUtil.delay(1000);
		// hookAndroidNodeToGrid();
		hookiOSNodeToGrid();

		// To unlock Device use "adb shell input keyevent 224"
	}

	public void startSeleniumGrid() {
		if (System.getProperty("os.name").toLowerCase().contains("mac")) {
			saveStringToFile(
					"java -jar " + System.getProperty("user.dir")
							+ "/lib/selenium-server-standalone-3.2.0.jar -role hub -port " + hubPort,
					System.getProperty("user.dir") + "/lib/grid.command");
			excCommandNewWindow("chmod +x " + System.getProperty("user.dir") + "/lib/grid.command");
			excCommandNewWindow("open " + System.getProperty("user.dir") + "/lib/grid.command");
		} else
			excCommandNewWindow("java -jar " + System.getProperty("user.dir")
					+ "/lib/selenium-server-standalone-3.2.0.jar -role hub -port " + hubPort);
	}

	public void hookAndroidNodeToGrid() {
		if (System.getProperty("os.name").toLowerCase().contains("mac")) {
			saveStringToFile("appium --nodeconfig " + System.getProperty("user.dir") + "/lib/nodeConfig_Android.json",
					System.getProperty("user.dir") + "/lib/node.command");
			excCommandNewWindow("chmod +x " + System.getProperty("user.dir") + "/lib/node.command");
			excCommandNewWindow("open " + System.getProperty("user.dir") + "/lib/node.command");
		} else
			excCommandNewWindow(
					"appium --nodeconfig " + System.getProperty("user.dir") + "/lib/nodeConfig_Android.json");
	}

	public void hookiOSNodeToGrid() {
		if (System.getProperty("os.name").toLowerCase().contains("mac")) {
			saveStringToFile("appium --nodeconfig " + System.getProperty("user.dir") + "/lib/nodeConfig_iOS.json",
					System.getProperty("user.dir") + "/lib/node.command");
			excCommandNewWindow("chmod +x " + System.getProperty("user.dir") + "/lib/node.command");
			excCommandNewWindow("open " + System.getProperty("user.dir") + "/lib/node.command");
		} else
			excCommandNewWindow("appium --nodeconfig " + System.getProperty("user.dir") + "/lib/nodeConfig_iOS.json");
	}

	public void downloadFileFromInternet(String fileURL, String filePathToSave) {
		URLConnection con;
		DataInputStream dis;
		FileOutputStream fos;
		byte[] fileData;
		try {
			con = new URL(fileURL).openConnection();
			dis = new DataInputStream(con.getInputStream());
			fileData = new byte[con.getContentLength()];
			for (int q = 0; q < fileData.length; q++)
				fileData[q] = dis.readByte();
			dis.close();
			fos = new FileOutputStream(new File(filePathToSave));
			fos.write(fileData);
			fos.close();
		} catch (Exception m) {
			System.out.println(m);
		}
	}

	public String updateAndroidJSON() {
		String appiumURL = null;
		String fileJSON = fileAsString(System.getProperty("user.dir") + "/lib/defaultAndroidNode.json");
		JSONObject root = new JSONObject(fileJSON);
		JSONArray capsArrayRoot = (JSONArray) root.get("capabilities");
		JSONObject capsObj = (JSONObject) capsArrayRoot.get(0);
		if (!capsObj.get("deviceName").toString().isEmpty())
			capsObj.remove("deviceName");
		try {
			capsObj.put("deviceName", readCmd("adb shell getprop ro.product.model"));
		} catch (NullPointerException e) {
			System.err.println(
					"Looks like Android device is not connected/authorized. Please hook device to machine and retry....");
			System.exit(0);
		}
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
		saveStringToFile(root.toString(), System.getProperty("user.dir") + "/lib/nodeConfig_Android.json");
		return appiumURL;
	}

	public String updateiOSJSON() {
		String appiumURL = null;
		String fileJSON = fileAsString(System.getProperty("user.dir") + "/lib/defaultiOSNode.json");
		JSONObject root = new JSONObject(fileJSON);
		JSONArray capsArrayRoot = (JSONArray) root.get("capabilities");
		JSONObject capsObj = (JSONObject) capsArrayRoot.get(0);
		String deviceDetails = readCmd("xcrun instruments -s");
		if (!capsObj.get("deviceName").toString().isEmpty())
			capsObj.remove("deviceName");
		if (deviceDetails.split("]")[2].contains("(Simulator)")) {
			System.err.println("Looks like iOS device is not connected. Please hook device to Mac and retry....");
			System.exit(0);
		}
		capsObj.put("deviceName", deviceDetails.split("]")[1].split(" ")[0]);
		deviceName = (String) capsObj.get("deviceName");
		if (!capsObj.get("platformVersion").toString().isEmpty())
			capsObj.remove("platformVersion");
		capsObj.put("platformVersion", deviceDetails.split("]")[1].split(" ")[1].replace("(", "").replace(")", ""));
		platformVersion = (String) capsObj.get("platformVersion");
		if (!capsObj.get("udid").toString().isEmpty())
			capsObj.remove("udid");
		capsObj.put("udid", deviceDetails.split("]")[1].split(" ")[2].replace("[", ""));
		udid = (String) capsObj.get("udid");
		if (!capsObj.get("app").toString().isEmpty())
			capsObj.remove("app");
		capsObj.put("app",
				System.getProperty("user.dir").replace("\\", "/") + "/src/test/resources/APK/moneycontrol.ipa");
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
		saveStringToFile(root.toString(), System.getProperty("user.dir") + "/lib/nodeConfig_iOS.json");
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
			if (System.getProperty("os.name").toLowerCase().contains("mac")) {
				// String[] command = { "xterm", "-e", cmd };
				Runtime.getRuntime().exec(cmd);
			} else
				Runtime.getRuntime().exec("cmd.exe /c start cmd /k " + cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String readCmd(String cmd) {
		String op = null;
		try {
			Process p;
			if (System.getProperty("os.name").toLowerCase().contains("mac"))
				p = cmd.startsWith("adb")
						? Runtime.getRuntime().exec("/Users/damco/Library/Android/sdk/platform-tools/" + cmd)
						: Runtime.getRuntime().exec(cmd);
			else
				p = Runtime.getRuntime().exec(cmd);
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