/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jonathanjuanalan.proyectofinal;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author 2118887
 */
public class email {
    
    public static void send(String f, String c){
       try{
           String host = "smtp.gmail.com";
           String user = "facturacop18@gmail.com";
           String pass = "arem2018";
           String to = c.replace("%40", "@");
           String from = "facturacop18@gmail.com";
           String subject = "FACTURA ELECTRONICA";
           String messageText = f+"\n esta es la cotizacoin en formato json, esperamos su respuesta ";
           boolean sessionDebug = false;
           
           Properties props = System.getProperties();
           
           props.put("mail.smtp.starttls.enable", "true");
           props.put("mail.smtp.host", host);
           props.put("mail.smtp.port", "587");
           props.put("mail.smtp.auth", "true");
           props.put("mail.smtp.starttls.required", "true");
           
           java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
           Session mailSession = Session.getDefaultInstance(props,null);
           mailSession.setDebug(sessionDebug);
           Message msg = new MimeMessage(mailSession);
           msg.setFrom(new InternetAddress(from));
           InternetAddress[] address = {new InternetAddress(to)};
           msg.setRecipients(Message.RecipientType.TO, address);
           msg.setSubject(subject); msg.setSentDate(new Date());
           msg.setText(messageText);
           
           Transport transport = mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();                                                                
           
       }catch(Exception ex){
           System.out.println(ex);
       }
    }
	
	
 
	
 
	
    

}
/**
 *
 * @author 2118887
 */

