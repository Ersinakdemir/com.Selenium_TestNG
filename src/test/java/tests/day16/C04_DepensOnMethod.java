package tests.day16;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.TestBase;

import java.time.Duration;

public class C04_DepensOnMethod {
    /*
         DependsOnMethods test method'larinin calisma siralamasina karismaz
         Sadece bagli olan test, baglandigi testin sonucuna bakar
         baglandigi test PASSED olmazsa, baglanan test hic calismaz(ignore)
        */
    WebDriver driver;
    @BeforeClass
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test01(){
        // amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");
    }
    @Test (dependsOnMethods ="test01" , priority = 0)
    public void test02(){
        // Nutella aratalim
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
    }
    @Test (dependsOnMethods ="test02" )
    public void test03(){
        // Sonuc yazisinin Nutella icerdigini test edelim
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYaziElementi.getText().contains("Nutella"));
    }
    @Test(groups = {"grup1", "grup2"})
    public void test04(){
        System.out.println("bak bu calisti");
    }
}
