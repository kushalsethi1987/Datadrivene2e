package rough;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

public class SendGmailEmail
{
    public boolean sendEmail(String to,String from,String subject,String text)
    {

        boolean flag=false;

        //smtp properties
        Properties props=new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.EnableSSL.enable","true");


        String username="kushal.sethi.nkaps";
        String password="jpvewapduthhhjdq";

        //Session setup

        Session session=Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });

        try
        {
            Message message= new MimeMessage(session);

            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("reena.runam@gmail.com"));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
            flag=true;


        }
        catch(Exception e)
        {
         e.printStackTrace();
        }
        return flag;

    }

}
