package com.hmh.automation.steps;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hmh.automation.utils.EmailUtils;
import com.hmh.automation.utils.PropertyReader;

/**
 * The Class StartAutomation.
 */
public class EndAutomation {

	/**
	 * Test.
	 */
	@Test
	public void test() {
		boolean sendMailFlag = EmailUtils.sendMail(PropertyReader.getProperty("toAddress"), "mailContentEndTask");
		assertEquals(true, sendMailFlag);
	}
}
