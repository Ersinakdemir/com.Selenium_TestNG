package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    /*
    POM de Driver icin TestBase clasina extend etmek yerine Driver classin dan
    static methodlar kullanarak driver olusturupilgili ayarlarin yapilmasi ve
     enson da driver in kapatilmasi tercih edilmistir

     */
    static WebDriver driver;
    public static WebDriver getDriver(){
        if (driver==null){
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }
    public static void clossDriver(){
        if (driver!=null){
            driver.close();
            driver=null;
        }
    }

}
