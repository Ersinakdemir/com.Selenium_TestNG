package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01PozotifLoginTest {
    BrcPage brcPage = new BrcPage();
    @Test
    public void positiveLoginTest() {
        brcPage =new BrcPage();
        // Bir test method olustur positiveLoginTest()
        //       https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        //      login butonuna bas
        brcPage.loginElement.click();

        //test data user email: customer@bluerentalcars.com ,
        brcPage.emailbox.sendKeys(ConfigReader.getProperty("brcEmail"));

        //test data password : 12345
        brcPage.sifreBox.sendKeys(ConfigReader.getProperty("brcSifre"));

        //Logon Butonuna tiklayin
        brcPage.loginiki.click();

        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        System.out.println(brcPage.nameSurname.getText());

        String expectedName =ConfigReader.getProperty("brcName");
        String actualName = brcPage.nameSurname.getText();
        Assert.assertEquals(actualName,expectedName);
    }
}
