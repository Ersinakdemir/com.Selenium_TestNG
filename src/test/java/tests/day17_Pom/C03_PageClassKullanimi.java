package tests.day17_Pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FaceBookPage;
import utilities.Driver;

public class C03_PageClassKullanimi {
    @Test
    public void test01() {
        FaceBookPage faceBookPage =new FaceBookPage();
        //Facebook ana sayfaya gidin
        Driver.getDriver().get("https://facebook.com");

        //cookies i kabul edin
        faceBookPage.cookiesAgree.click();

        //kullanici kutusuna rastgele bir isim yazdirinf
        Faker faker =new Faker();
        faceBookPage.mailKutusu.sendKeys(faker.internet().emailAddress());

        //sifre kullanici kutusuna rastgele bir passwort yazdirin
        faceBookPage.sifreKutusu.sendKeys(faker.internet().password());

        //login butonuna basin
        faceBookPage.loginTusu.click();

        //login ola,adiginizi ttest edin
        Assert.assertTrue(faceBookPage.girilemediYaziElementi.isDisplayed());
    }
}
