package com.hmh.automation.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.security.auth.module.NTSystem;

/**
 * The Class EmailUtils.
 */
@SuppressWarnings("restriction")
public class EmailUtils {

	/** The LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtils.class);
	
	/**
	 * Send mail.
	 *
	 * @param emailId the email id
	 * @param mailContentKey the mail content key
	 */
	public static boolean sendMail(final String emailId, final String mailContentKey) {
		LOGGER.info("Sending login info to user at: {}", emailId);
		boolean sendMailFlag = false;

		if ("gmail".equals(PropertyReader.getProperty("mailMode"))) {
			sendMailFlag = sendMailViaGmail(emailId, PropertyReader.getProperty("mailSubject"), prepareContent(mailContentKey));
		} else {
			sendMailFlag= sendMail(emailId, PropertyReader.getProperty("mailSubject"), prepareContent(mailContentKey));
		}
		
		return sendMailFlag;
	}

	/**
	 * Send mail.
	 *
	 * @param to the to
	 * @param subject the subject
	 * @param content the content
	 * @return true, if send mail
	 */
	public static boolean sendMail(final String to, final String subject, final String content) {
		LOGGER.info("sendMail invoked.");
		boolean sendMailFlag = false;
		try {
			final Message message = mailProperties();
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			final Multipart multipart = new MimeMultipart("alternative");
			final BodyPart htmlMessageBodyPart = new MimeBodyPart();
			htmlMessageBodyPart.setContent(content, "text/html");
			multipart.addBodyPart(htmlMessageBodyPart);
			message.setContent(multipart);
			Transport.send(message);
			LOGGER.debug("Email Message Sent..");
			sendMailFlag = true;
		} catch (Exception excp) {
			LOGGER.error("Exception occurred while sending email", excp);
		}
		return sendMailFlag;
	}

	/**
	 * Mail properties.
	 *
	 * @return the message
	 * @throws AddressException the address exception
	 * @throws MessagingException the messaging exception
	 */
	public static Message mailProperties() throws AddressException, MessagingException {
		final Properties props = new Properties();
		final String host = PropertyReader.getProperty("mailHostName");
		final String port = PropertyReader.getProperty("mailPort");
		final String fromAddress = PropertyReader.getProperty("fromAddress");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.socketFactory.port", PropertyReader.getProperty("mailPort"));
        final Session session = Session.getDefaultInstance(props);
		final Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(fromAddress));
		return message;
	}

	/**
	 * Mail authenticate.
	 *
	 * @return the message
	 * @throws AddressException
	 *             the address exception
	 * @throws MessagingException
	 *             the messaging exception
	 */
	public static Message mailAuthenticate() throws AddressException, MessagingException {
		final String fromAddress = PropertyReader.getProperty("fromAddress");
		final Properties props = new Properties();
		props.put("mail.smtp.host", PropertyReader.getProperty("mailHostNameGmail"));
		props.put("mail.smtp.socketFactory.port", PropertyReader.getProperty("mailPortGmail"));
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", PropertyReader.getProperty("mailPortGmail"));
		final Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(PropertyReader.getProperty("smtpUserName"),
						PropertyReader.getProperty("smtpUserPassword"));
			}
		});
		final Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(fromAddress));
		return message;
	}

	/**
	 * Send mail via gmail.
	 *
	 * @param to the to
	 * @param subject the subject
	 * @param content the content
	 * @return true, if send mail via gmail
	 */
	public static boolean sendMailViaGmail(final String to, final String subject, final String content) {
		LOGGER.info("sendMailViaGmail invoked..");
		boolean sendMailFlag = false;
		try {
			final Message message = mailAuthenticate();
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			final Multipart multipart = new MimeMultipart("alternative");
			final BodyPart htmlMessageBodyPart = new MimeBodyPart();
			htmlMessageBodyPart.setContent(content, "text/html");
			multipart.addBodyPart(htmlMessageBodyPart);
			message.setContent(multipart);
			Transport.send(message);
			LOGGER.info("Email Message Sent..");
			sendMailFlag = true;
		} catch (Exception excp) {
			LOGGER.error("Exception occurred while sending email", excp);
		}
		return sendMailFlag;
	}
	
	/**
	 * Prepare content.
	 *
	 * @param mailContentKey the mail content key
	 * @return the string
	 */
	public static String prepareContent(final String mailContentKey) {
		final StringBuilder strBuild = new StringBuilder();
		strBuild.append("Hi Team,").append(PropertyReader.getProperty(mailContentKey));
		final String env = AutomationUtils.getEnvironment();
		final String usr = AutomationUtils.getUserName();
		final String testSuite = AutomationUtils.getAutomationTestSuite();

		if (StringUtils.isNotBlank(env) && StringUtils.isNotBlank(usr) && StringUtils.isNotBlank(testSuite)) {
			strBuild.append("Environment: ").append(env).append(" | User: ").append(usr).append("<br/><br/>")
			.append("Selected Suite: ").append(testSuite).append("<br/><br/>");
		}
		
		String hostName = StringUtils.EMPTY;
		String ipAddress = StringUtils.EMPTY;
		try {
			hostName = InetAddress.getLocalHost().getHostName();
			ipAddress = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException uhe) {
			hostName = "Unknown";
			ipAddress = "Unknown";
		}
		
		if (StringUtils.isNotBlank(hostName) && StringUtils.isNotBlank(ipAddress)) {
			strBuild.append("Host where executing the tests: ").append(hostName).append(" (").append(ipAddress).append(")<br/><br/>");
		}
		
		final String initiator = getSystemUserName();
		if (StringUtils.isNotBlank(initiator)) {
			strBuild.append("Initiator: ").append(initiator).append("<br/><br/>");
		}
		
		strBuild.append(PropertyReader.getProperty("mailContentThankStmt"));
		return strBuild.toString();
	}
	
	/**
	 * Gets the system user name.
	 *
	 * @return the system user name
	 */
	public static String getSystemUserName() {
		String user = "Unknown";
		final NTSystem ntSystem = new NTSystem();
		String name = ntSystem.getName();
		if (StringUtils.isNoneBlank(name)) {
			user = name;
		}
		return user;
	}
}
