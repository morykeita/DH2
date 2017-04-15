package com.dhub.services;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.dhub.dao.UsersDaoImpl;

public class MailServices
{

	public MailServices()
	{
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * START OF CHANGES DONE BY SAMSEL 
	 */
	public static void sendMail(String emailIds, String iMsg, String userID, String eSubject){
		
		//Get from users emailID;
		//Integer uid= Integer.getInteger(userID);
		String fEmailID = userID;//new UsersDaoImpl().getUserInfo(uid).getEmail(); 
		System.out.println("From Email : "+userID);
		String[] fUri = fEmailID.split("@");
		
		
		//	System.out.println(emailIds);  System.out.println(" \nMsg : [ "+iMsg+" ]\n ");
		System.out.println("------------------------------------------------");
		System.out.println("REQUEST: Send a Mail");
		System.out.println("------------------------------------------------");
		String[] eIDs =  emailIds.split(";");
		System.out.println("Email IDs : ");
		for(int i=0;i<eIDs.length;i++){
			System.out.println("\t"+eIDs[i]);
			//String[] emailU = eIDs[i].split("@");
			System.out.println("Sending Message : "+fEmailID+" -> "+eIDs[i]);
			mail(eIDs[i],fEmailID,eSubject,iMsg);
		}
		
		System.out.println(" \nSubject : [ "+eSubject+" ]\n ");
		System.out.println(" \nMsg : [ "+iMsg+" ]\n ");
		System.out.println("***************************************************");
		
		//get the user From EmailID for given 'userID' -- you can get this value from the session if null
	}
	
	public static void mail(String toAdd, String fromAdd, String sub, String body){
		/*
		 * CHANGES BY BELLA
		 */
		 		String to = toAdd; //dsam@yahoo.com

				// Sender's email ID needs to be mentioned
				String from = fromAdd;//"dh2persona@yahoo.com";
				String password = "revature111";

				// Assuming you are sending email from localhost
				String host = "smtp.mail.yahoo.com"; //<--- host 

				// Get system properties
				Properties props = System.getProperties();

				String emailPort = "587";
				//props = System.getProperties();
				//props.put("mail.smtp.port", emailPort);
				//props.put("mail.smtp.auth", "true");
				//props.put("mail.smtp.starttls.enable", "true");
				
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", host);
				props.put("mail.smtp.user", from);
				props.put("mail.smtp.password", password);
				props.put("mail.smtp.port", "587");
				props.put("mail.smtp.auth", "true");


				// Setup mail server
				props.put("mail.smtp.host", host);

				// Get the default Session object
				Session sess = Session.getDefaultInstance(props);

				// Create a default MimeMessage object.
				MimeMessage mimeMessage = new MimeMessage(sess);
				
				try
				{
					// Set From: header field of the header.

					mimeMessage.setFrom(new InternetAddress(from));

					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

					mimeMessage.setSubject("sdfdf");

					// Now set the actual message
					mimeMessage.setText("sdfd");

					// Send message
					Transport transport = sess.getTransport("smtp");
					transport.connect(host, from, password);
					transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
					transport.close();
				} catch (MessagingException e)
				{
					// TODO Auto-generated catch block
					System.out.println("Exception whiile mailing");
					e.printStackTrace();
				}
		
	}
	
	/*
	 * END OF CHANGES DONE BY SAMSEL 
	 */

}
