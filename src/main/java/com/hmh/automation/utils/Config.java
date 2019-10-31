package com.hmh.automation.utils;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class TestConfig.
 */
@XmlRootElement(name = "config")
public class Config {
	
	/** The automation environment url. */
	private String automationEnvironmentUrl;
	
	/** The automation user. */
	private String automationUser;
	
	/** The automation user pass. */
	private String automationUserPass;
	
	/** The automation user disp name. */
	private String automationUserDispName;
	
	/** The automation test suite. */
	private String automationTestSuite;
	
	/** The automation download path. */
	private String automationDownloadPath;
	
	/** The automation driver path. */
	private String automationDriverPath;

	/**
	 * Gets the automation environment url.
	 *
	 * @return the automation environment url
	 */
	public String getAutomationEnvironmentUrl() {
		return automationEnvironmentUrl;
	}

	/**
	 * Sets the automation environment url.
	 *
	 * @param automationEnvironmentUrl the automation environment url
	 */
	@XmlElement(name = "automationEnvironmentUrl", required = true)
	public void setAutomationEnvironmentUrl(String automationEnvironmentUrl) {
		this.automationEnvironmentUrl = automationEnvironmentUrl;
	}

	/**
	 * Gets the automation user.
	 *
	 * @return the automation user
	 */
	public String getAutomationUser() {
		return automationUser;
	}

	/**
	 * Sets the automation user.
	 *
	 * @param automationUser the automation user
	 */
	@XmlElement(name = "automationUser", required = true)
	public void setAutomationUser(String automationUser) {
		this.automationUser = automationUser;
	}

	/**
	 * Gets the automation user pass.
	 *
	 * @return the automation user pass
	 */
	public String getAutomationUserPass() {
		return automationUserPass;
	}

	/**
	 * Sets the automation user pass.
	 *
	 * @param automationUserPass the automation user pass
	 */
	@XmlElement(name = "automationUserPass", required = true)
	public void setAutomationUserPass(String automationUserPass) {
		this.automationUserPass = automationUserPass;
	}

	/**
	 * Gets the automation user disp name.
	 *
	 * @return the automation user disp name
	 */
	public String getAutomationUserDispName() {
		return automationUserDispName;
	}

	/**
	 * Sets the automation user disp name.
	 *
	 * @param automationUserDispName the automation user disp name
	 */
	@XmlElement(name = "automationUserDispName", required = true)
	public void setAutomationUserDispName(String automationUserDispName) {
		this.automationUserDispName = automationUserDispName;
	}

	/**
	 * Gets the automation test suite.
	 *
	 * @return the automation test suite
	 */
	public String getAutomationTestSuite() {
		return automationTestSuite;
	}
	
	/**
	 * Sets the automation test suite.
	 *
	 * @param automationTestSuite the automation test suite
	 */
	@XmlElement(name = "automationTestSuite", required = true)
	public void setAutomationTestSuite(String automationTestSuite) {
		this.automationTestSuite = automationTestSuite;
	}

	/**
	 * Gets the automation download path.
	 *
	 * @return the automation download path
	 */
	public String getAutomationDownloadPath() {
		return automationDownloadPath;
	}

	/**
	 * Sets the automation download path.
	 *
	 * @param automationDownloadPath the automation download path
	 */
	@XmlElement(name = "automationDownloadPath", required = true)
	public void setAutomationDownloadPath(String automationDownloadPath) {
		this.automationDownloadPath = automationDownloadPath;
	}

	/**
	 * Gets the automation driver path.
	 *
	 * @return the automation driver path
	 */
	public String getAutomationDriverPath() {
		return automationDriverPath;
	}

	/**
	 * Sets the automation driver path.
	 *
	 * @param automationDriverPath the automation driver path
	 */
	@XmlElement(name = "automationDriverPath", required = true)
	public void setAutomationDriverPath(String automationDriverPath) {
		this.automationDriverPath = automationDriverPath;
	}
}
