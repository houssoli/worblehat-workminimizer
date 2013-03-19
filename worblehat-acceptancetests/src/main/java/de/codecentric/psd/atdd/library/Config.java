package de.codecentric.psd.atdd.library;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.openqa.selenium.Platform;

/**
 * Reads config parameters from properties file. The properties are by maven during the build process.
 *  
 * @author aek
 *
 */
public class Config {
	private static final String BUNDLE_NAME = "de.codecentric.psd.atdd.library.config"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	public Config() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	public static String getApplicationURL() {
		return getString("application.url");
	}
	
	public static String getApplicationContext() {
		return getString("application.context");
	}
	
	public static String getDbURL() {
		return getString("db.url");
	}
	
	public static String getDbUser() {
		return getString("db.user");
	}
	
	public static String getDbPassword() {
		return getString("db.password");
	}

	public static String getSeleniumProvider() {
		return getSeleniumServer().contains("sauce")?"saucelabs":"local";
	}
	
	public static String getBrowserVersion() {
		return getString("browser.version");
	}

	public static Platform getBrowserOS() {
		return Platform.valueOf(getString("browser.os").toUpperCase());
	}

	public static String getTestDescription() {
		return getString("description");
	}

	public static String getBrowser() {
		return getString("browser");
	}

	public static String getSauceAccount() {
		return getString("saucelabs.account");
	}

	public static String getSauceKey() {
		return getString("saucelabs.key");
	}

	public static String getSeleniumServer() {
		return getString("selenium.server");
	};
	
}
