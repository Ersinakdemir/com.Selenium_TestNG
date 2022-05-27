package tests.day17_Pom;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageClassKullanimi {
    @Test
    public void test01(){
        AmazonPage amazonPage =new AmazonPage();
        //Amazonna gidelim
        Driver.getDriver().get("https://www.amazon.com");

        //Nutella aratalimse
        amazonPage.searchBox.sendKeys("nutella"+ Keys.ENTER);

        //Sonuc yazisini nutella icerdigini test edelim
        String actalSonuc =amazonPage.resultElement.getText();
        String expectSonuc ="nutella";
        Assert.assertTrue(actalSonuc.contains(expectSonuc));
        Driver.clossDriver();

    }
}
