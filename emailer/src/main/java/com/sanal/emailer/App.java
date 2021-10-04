package com.sanal.emailer;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;






public class App 
{
  
   
    
    public static void main(String... args) throws MessagingException, IOException {
        List<String> lrgs = Arrays.asList(args);
        if (lrgs.size() < 2 || lrgs.contains("-help")) {
            System.out.println("" +
                    "Emailer .\n" +
                    "\t-h Host name or IP\n" +
                    "\t-s sender email address e\n" +
                    "\t-r reciepient of test email \n" +
                    "\t-p smtp port  \n" +
                    "Example:\n" +
                    "\t java -jar emailer.jar  -h10.11.22.333  -ssanal@email.com -rsanal@reciever.com -p25" +
                    "");
            return;
        }
        AppSettings appSettings = getAppSettings(lrgs);
        process(appSettings);
    }
    
 
        

    private static AppSettings getAppSettings(List<String> lrgs) {
        AppSettings appSettings = new AppSettings();
        for (String arg : lrgs) {
            if (arg.startsWith("-h") && arg.length() > 2) {
                appSettings.setHost(arg.substring(2));
            }
            if (arg.startsWith("-s") && arg.length() > 2) {
                appSettings.setSender(arg.substring(2));
            }
            if (arg.startsWith("-r") && arg.length() > 2) {
                appSettings.setReciepient(arg.substring(2));
            }
            if (arg.startsWith("-p") && arg.length() > 2) {
                appSettings.setPort(arg.substring(2));
            }
         
          
           
        }
    
      
     
        return appSettings;
    }
    

    
    private static void process(final AppSettings appSettings) throws IOException 
    
    {
        System.out.println( "EMAILER TESTER!" );
        
       
 
        		String host = appSettings.getHost();
        		String sender = appSettings.getSender();
        		String reciever = appSettings.getReciepient();
        		String port = appSettings.getPort();
    		
        		System.out.println(host + " "+ sender+ " "  + reciever + " ");
        		
    			Properties properties = System.getProperties();
    			properties.setProperty("mail.smtp.host", host);
    			properties.setProperty("mail.smtp.port", port);

    			Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
    				protected PasswordAuthentication getPasswordAuthentication() {
    					return new PasswordAuthentication(appSettings.getSender(), "");
    				}
    			});

    			try {
    				MimeMessage message = new MimeMessage(session);

    				message.setFrom(new InternetAddress(sender));

    				message.addRecipient(Message.RecipientType.TO, new InternetAddress(reciever));
    			
    			

    				message.setSubject("TESTING EMAil with "+host );

    			
    				
    			
    				message.setContent(host + " "+ sender+ " "  + reciever + " ", "text/plain");

    				Address[] add = message.getAllRecipients();
    				System.out.println("Sending mail");
    				System.out.println("Mail sent successfully to {}"+ add[0] );
    				Transport.send(message);
    				System.out.println("Mail sent successfully to {}"+ message.getAllRecipients());

    			} catch (Exception e) {
    				e.printStackTrace();
    				System.out.println("Error while sending mail");
    			
    			}
    		} 
    	
    
        
    }

