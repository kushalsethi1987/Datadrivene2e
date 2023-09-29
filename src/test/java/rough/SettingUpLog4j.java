package rough;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Date;

public class SettingUpLog4j {
    public static Logger log=Logger.getLogger(SettingUpLog4j.class.getName());
    static Date currentDate=new Date();

    public static void settingUpLog4j()
    {
        System.setProperty("current.date",currentDate.toString().replace(":","_").replace(" ","_"));
        PropertyConfigurator.configure
                (System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\log4j.properties");
    }

    public static void main(String[] args) {
        SettingUpLog4j.settingUpLog4j();
        log.info("I am in main method");
    }
}
