package com.hmh.automation.steps;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hmh.automation.utils.EmailUtils;
import com.hmh.automation.utils.PropertyReader;

/**
 * The Class StartAutomation.
 */
public class FailedAutomation {

	/**
	 * Test.
	 */
	@Test
	public void test() {
		boolean sendMailFlag = EmailUtils.sendMail(PropertyReader.getProperty("toAddress"), "mailContentFailedTask");
		assertEquals(true, sendMailFlag);
	}
}