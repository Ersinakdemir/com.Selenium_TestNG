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

     POM de Driver classindski getDrfiver() nin obje olusturulmarak kullanilmasin
     engellememk icin Simgelten Patter kullnnimi benimsenmistir


Simgelten Patter : Tekli kullanim bir class in farkli classlardan obje olusturularak kullanimini engellememk icin kullanilir

Bunu yapmak icin obj olusturmak icin gereklei olan constricter i private yaptigimizda baska classtan obje olusturulamasin diye
     */
    static WebDriver driver;
    private Driver (){

    }
    public static WebDriver getDriver(){

        if (driver==null){
            switch (ConfigReader.getProperty("browser")){
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver= new SafariDriver();
                    break;
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver= new ChromeDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver= new EdgeDriver();
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
