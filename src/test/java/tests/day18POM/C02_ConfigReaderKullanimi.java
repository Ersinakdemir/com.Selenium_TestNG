package tests.day18POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FaceBookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigReaderKullanimi {
    @Test
    public void test01() {
        FaceBookPage faceBookPage =new FaceBookPage();
        // facebook anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));

        // cikarsa cookies kabul edin
        faceBookPage.cookiesAgree.click();

        // kullanici mail kutusuna rastgele bir isim yazdirin
        faceBookPage.mailKutusu.sendKeys(ConfigReader.getProperty("facebookWrongUsername"));

        // kullanici sifre kutusuna rastgele bir password yazdirin
        faceBookPage.sifreKutusu.sendKeys(ConfigReader.getProperty("facebookWrongPassword"));

        // login butonuna basin
        faceBookPage.loginTusu.click();
        // giris yapilamadigini test edin
        Assert.assertTrue(faceBookPage.girilemediYaziElementi.isDisplayed());

        Driver.clossDriver();
    }
}
