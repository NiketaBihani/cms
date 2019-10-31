/*
 * Created By: Abhinav Kumar Mishra
 * Copyright &COPY; Houghton Mifflin Harcourt 2018.
 * All rights reserved.
 */
package com.hmh.automation.utils;

import java.io.File;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class AutomationUtils.
 */
public final class AutomationUtils {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(AutomationUtils.class);
	
	/** The os. */
	private static final String OS = System.getProperty("os.name").toLowerCase();

	/** The cfg. */
	public static Config cfg;
	
	static {
		try {
			if (cfg == null) {
				LOGGER.info("Initializing the config.xml");
			    cfg = (Config) XMLUnmarshaller.convertXmlInputStreamToJaxbObject(AutomationUtils.class.getResourceAsStream("/config.xml"), Config.class);
			    LOGGER.info("Successfully loaded and parsed config.xml");
			}
		} catch (JAXBException excp) {
			LOGGER.error("Failed to initialize the config", excp);
		}
		if (cfg == null) {
	    	throw new IllegalStateException("Could not initialize the config!");
	    }
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public static String getUserName() {
		return cfg.getAutomationUser();
	}
	
	/**
	 * Gets the user display name.
	 *
	 * @return the user display name
	 */
	public static String getUserDisplayName() {
		return cfg.getAutomationUserDispName();
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public static String getPassword() {
		return cfg.getAutomationUserPass();
	}

	/**
	 * Gets the environment.
	 *
	 * @return the environment
	 */
	public static String getEnvironment() {
		return cfg.getAutomationEnvironmentUrl();
	}
	
	/**
	 * Gets the automation test suite.
	 *
	 * @return the automation test suite
	 */
	public static String getAutomationTestSuite() {
		return cfg.getAutomationTestSuite();
	}
	
	/**
	 * Gets the download path.
	 *
	 * @return the download path
	 */
	public static String getDownloadPath() {
		String downloadPath = cfg.getAutomationDownloadPath();
		if (StringUtils.isEmpty(downloadPath)) {
			LOGGER.info("Generating download path into workspace..");
			final File currentDirFile = new File(".");
			final String absPath = currentDirFile.getAbsolutePath();
			if (isWindows()) {
				final String ctxPath = StringUtils.substringBeforeLast(absPath, "\\");
				final String driverPath = ctxPath+"\\downloads";
				downloadPath = driverPath;
			} else {
				final String ctxPath = StringUtils.substringBeforeLast(absPath, "/");
				final String driverPath = ctxPath+"/downloads";
				downloadPath = driverPath;
			}
			LOGGER.info("Download path generated : {}", downloadPath);
		}
		return downloadPath;
	}

	/**
	 * Gets the driver path.
	 *
	 * @return the driver path
	 */
	public static String getDriverPath() {
		String inputDriver = cfg.getAutomationDriverPath();
		if (StringUtils.isEmpty(inputDriver)) {
			LOGGER.info("Generating driver path from workspace..");
			final File currentDirFile = new File(".");
			final String absPath = currentDirFile.getAbsolutePath();
			if (isWindows()) {
				final String ctxPath = StringUtils.substringBeforeLast(absPath, "\\");
				final String driverPath = ctxPath+"\\webdrivers\\chromedriver.exe";
				inputDriver = driverPath;
			} else {
				final String ctxPath = StringUtils.substringBeforeLast(absPath, "/");
				final String driverPath = ctxPath+"/webdrivers/chromedriver.exe";
				inputDriver = driverPath;
			}
			LOGGER.info("Driver path generated : {}", inputDriver);
		}
		return inputDriver;
	}
	
	/**
	 * Checks if is windows.
	 *
	 * @return true, if checks if is windows
	 */
	public static boolean isWindows() {
		return (OS.indexOf("win") >= 0);
	}

	/**
	 * Checks if is unix.
	 *
	 * @return true, if checks if is unix
	 */
	public static boolean isUnix() {
		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
	}

	/**
	 * The Constructor.
	 */
	private AutomationUtils() {
		super();
	}
}
