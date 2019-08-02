
package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * This ConfigReader file will read the config file
 *
 */
public class ConfigReader {
	/**
	 * will read the properties file with this function
	 * 
	 * @param filePath
	 * @return
	 */
	public static Properties loadPropertyFile(String filePath) {
		// Read from properties file
		Properties prop = new Properties();
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(new File(filePath));
			prop.load(fileInput);
		} catch (Exception e) {
			LogUtil.errorLog(ConfigReader.class, "Caught the exception", e);
		}
		return prop;
	}

	/**
	 * will get sting value from properties file
	 * 
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {
		Properties prop = loadPropertyFile("src/main/resources/Config/config.properties");
		return prop.getProperty(key);
	}

	/**
	 * will get int value from properties file
	 * 
	 * @param key
	 * @return
	 */
	public static int getIntValue(String key) {
		Properties prop = loadPropertyFile("src/main/resources/Config/config.properties");
		return Integer.parseInt(prop.getProperty(key));
	}
}