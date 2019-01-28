package com.framework.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SubjectTerm;

import com.framework.dataprovider.ITestData;
import com.google.gson.Gson;

public class Utility {

	public static <T extends ITestData> T getDataPojo(Object jsonObject, Class<T> dataClass) {
		Gson gson = new Gson();
		return gson.fromJson(gson.toJson(jsonObject), dataClass);
	}

	public static boolean readAllMails(String subject) throws NoSuchProviderException, InterruptedException, IOException {
		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imaps");

		Session session = Session.getDefaultInstance(props, null);
		boolean isMailFound = false;
		for (int loop = 0; loop < 5; loop++) {
			try {
				Store store = session.getStore("imaps");
				store.connect("imap.gmail.com", "mayur.mohite@globant.com", "myGlober_1");
				Folder folder = store.getFolder("INBOX");
				folder.open(Folder.READ_WRITE);

				Message[] messages = null;
				// Search for mail
				for (int i = 0; i < 5; i++) {
					messages = folder.search(new SubjectTerm(subject), folder.getMessages());
					// Wait for 10 seconds
					if (messages.length == 0) {
						Thread.sleep(10000);
					}
				}

				// Search for unread mail
				if (messages.length == 0) {
					System.out.println("No new mail found with subject: " + subject);
				} else {
					isMailFound = true;
					for (Message mail : messages) {
						if (!mail.isSet(Flags.Flag.SEEN)) {
							String line;
							StringBuffer buffer = new StringBuffer();
							BufferedReader reader = new BufferedReader(new InputStreamReader(mail.getInputStream()));
							while ((line = reader.readLine()) != null) {
								buffer.append(line);
							}
						}
					}
					System.out.println("Done reading all mails with subject: " + subject);
				}
				break;

			} catch (MessagingException msgExcp) {
				System.out.println("Waiting to connect to mail server...");
				Thread.sleep(15000);
			}
		}

		return isMailFound;
	}

	public static boolean checkIfMailPresent(String subject, String searchterm) throws NoSuchProviderException,
			InterruptedException, IOException {
		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imaps");

		Session session = Session.getDefaultInstance(props, null);
		boolean isMailFound = false;
		for (int loop = 0; loop < 5; loop++) {
			try {
				Store store = session.getStore("imaps");
				store.connect("imap.gmail.com", "mayur.mohite@globant.com", "myBest@1");
				Folder folder = store.getFolder("INBOX");
				folder.open(Folder.READ_WRITE);

				Message[] messages = null;
				// Search for mail
				for (int i = 0; i < 5; i++) {
					messages = folder.search(new SubjectTerm(subject), folder.getMessages());
					// Wait for 10 seconds
					if (messages.length == 0) {
						Thread.sleep(10000);
					}
				}

				// Search for unread mail
				if (messages.length == 0) {
					System.out.println("No new mail found with subject: " + subject);
				} else {
					for (Message mail : messages) {
						if (!mail.isSet(Flags.Flag.SEEN)) {
							String line;
							StringBuffer buffer = new StringBuffer();
							BufferedReader reader = new BufferedReader(new InputStreamReader(mail.getInputStream()));
							while ((line = reader.readLine()) != null) {
								buffer.append(line);
							}
							if (buffer.toString().contains(searchterm)) {
								isMailFound = true;
								System.out.println("Mail found with subject: " + subject + " and content: " + searchterm);
								break;
							}
						}
					}
				}

				break;
			} catch (MessagingException msgExcp) {
				System.out.println("Waiting to connect to mail server...");
				Thread.sleep(15000);
			}
		}

		return isMailFound;
	}
}
