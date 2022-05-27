package tests.day16;

import org.apache.poi.hpsf.Array;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C07_SoftAssert extends TestBase {
    @Test
    public void test01() {
        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        // 2. Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        // 3. Login kutusuna “username” yazin
        WebElement loginKutusu = driver.findElement(By.xpath("//input[@id='user_login']"));
        loginKutusu.sendKeys("username");

        // 4. Password kutusuna “password” yazin
        WebElement passKutusu = driver.findElement(By.xpath("//input[@id='user_password']"));
        passKutusu.sendKeys("password");

        // 5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.navigate().back();

        // 6. Online banking menusu icinde Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        // 7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();

        // 8. “Currency” drop down menusunden Eurozone’u secin
        WebElement currencyElement = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select =new Select(currencyElement);
        select.selectByVisibleText("Eurozone (euro)");

        // 9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
        String expecktSelection ="Eurozone (euro)";
        String actuelSelection =select.getFirstSelectedOption().getText();
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertEquals(actuelSelection,expecktSelection);

        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        // "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
        // "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)",
        // "Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"
        List<String>dropDownList = new ArrayList<>(Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)",
                "Switzerland (franc)","China (yuan)", "Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
                "Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)",
                "Singapore (dollar)","Thailand (baht)"));
        dropDownList=dropDownList.stream().sorted().toList();
        List<WebElement> currencyElementList =select.getOptions();
        List<String>currencyTextList =new ArrayList<>();
        for (WebElement obj:currencyElementList) {
            currencyTextList.add(obj.getText());
        }
        currencyTextList=currencyTextList.stream().sorted().toList();
        softAssert.assertEquals(currencyTextList,dropDownList);
        System.out.println(currencyTextList);
        softAssert.assertAll();
    }
}
