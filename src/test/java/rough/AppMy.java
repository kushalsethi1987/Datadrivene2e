package rough;

import utilities.MonitoringMail;
import utilities.TestConfig;


import javax.mail.MessagingException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class AppMy {

    public static void main(String[] args) throws UnknownHostException, MessagingException {

        System.out.println(InetAddress.getLocalHost().getHostAddress());
        MonitoringMail monitoringMail= new MonitoringMail();
        String messageBody= "http://" + InetAddress.getLocalHost().getHostAddress()+ ":8080/job/DataDrivenE2E/HTML_5fReport/";
        System.out.println(messageBody);
        monitoringMail.sendMail(TestConfig.server,TestConfig.from,TestConfig.to,TestConfig.subject,messageBody,"","");

        /*SendGmailEmail sendEmailMy = new SendGmailEmail();
        //String [] to={"reena.runam@gmail.com","testingbluestacksformyself@gmail.com"};
        String to = "reena.runam@gmail.com";
        String from = "kushal.sethi.nkaps@gmail.com";
        String subject = "Sending email through gmail";
        String text="Sending email through gmail without the app access";
        boolean b = sendEmailMy.sendEmail(to, from, subject, text);
        if (b) {
            System.out.println("Email is sent");
        } else {
            System.out.println("Email not sent");
        }*/
    }
}
