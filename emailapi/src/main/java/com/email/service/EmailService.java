package com.email.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

	public boolean sendEmail(String subject,String message,String to) {
		
		
		boolean f= false;
		
	  String from="anshagarwal.rishikesh@gmail.com";
		//variable for gmail
		String host="smtp.gmail.com";
		
		//get the system properties
		Properties properties = System.getProperties();
		System.out.println(properties);
		
		//setting important info to properties object
		
		
		
		//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth", "true");
		
		
		//Step 1: to get session object
		
		Session session=Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				
			return new PasswordAuthentication("powerrangerspd470@gmail.com", "yelb wxzy nrvs xpkc\r\n");
			
			}
		
		
		
		});
		
		session.setDebug(true);
		//step 2: compose the message{text or image or pdf}
		
		MimeMessage m = new MimeMessage(session);
		
		try {
		//from email id 
		m.setFrom(from);
		
		
		//to email id
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		//adding subject to message
		m.setSubject(subject);
		
		//adding content to email
		m.setText(message);
		
		//send message
		//Step 3: send the message using Transport class
		
		Transport.send(m);
		System.out.println("Send successfully");
		f=true;
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
	
}
