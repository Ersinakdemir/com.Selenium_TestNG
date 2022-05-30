package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

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
            switch (ConfigReader.getProperty("browser")){
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver= new SafariDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver= new EdgeDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver= new ChromeDriver();

            }
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
