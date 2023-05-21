package schoolautomationsystem;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;



/*public class MailSender {
    public static void main(String[] args) {
        
        Mailer.send("kumarraghav561@gmail.com","2000raghav22","rkranbirkumar567@gmail.com","For Checking","here mail is send and done");
    }
}*/

public class Mailer{
    
    public static void send(String from,String password,String to,String subtitle,String message){
        //get System Proprities
        Properties properties=System.getProperties();
        System.out.println("properties "+properties);
        
        //put mehod work as key value pair, mail.smtp.host is key and another is value
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");
        
        //get Session object
        Session session=Session.getInstance(properties,new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
        session.setDebug(true);
        
        //compose Message
        MimeMessage mmessage=new MimeMessage(session);
        try{
            //mmessage.setFrom(from);
            mmessage.addRecipients(Message.RecipientType.TO, to);
            mmessage.setSubject(subtitle);
            mmessage.setText(message);
                        
            Transport.send(mmessage);
            
        } catch (MessagingException ex) {
           ex.getStackTrace();
        }
    }
    
}
