package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02NegatifTestLer {
    BrcPage brcPage =new BrcPage();
    @Test(priority = 2)
    public void yanlisSifre() throws InterruptedException {
        brcPage =new BrcPage();
        // Bir test method olustur yanlisSifre()
        //       https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get("https://www.bluerentalcars.com/");

        //      login butonuna bas
        brcPage.loginElement.click();

        //test data user email: customer@bluerentalcars.com ,
        brcPage.emailbox.sendKeys(ConfigReader.getProperty("brcEmail"));

        //test data password : 12346
        brcPage.sifreBox.sendKeys(ConfigReader.getProperty("brcWrogSifre"));

        //Logon Butonuna tiklayin
        brcPage.loginiki.click();

        Thread.sleep(2000);

        Assert.assertTrue(brcPage.loginiki.isDisplayed());
        Driver.getDriver().close();

    }

    @Test(priority = 1)
    public void yanlisEMail() throws InterruptedException {
        brcPage =new BrcPage();
        //test data user email: customer@bluerentalcars,

        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        //      login butonuna bas
        brcPage.loginElement.click();

        brcPage.emailbox.sendKeys(ConfigReader.getProperty("brcWrogEmail"));

        //test data password : 12345
        brcPage.sifreBox.sendKeys(ConfigReader.getProperty("brcSifre"));

        //Logon Butonuna tiklayin
        brcPage.loginiki.click();

        Thread.sleep(2000);

        Assert.assertTrue(brcPage.loginiki.isDisplayed());
    }

    @Test
    public void yanlisEmaiSifre() throws InterruptedException {
        brcPage =new BrcPage();
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //      login butonuna bas
        brcPage.loginElement.click();

        //test data user email: customer@bluerentalcars,
        brcPage.emailbox.sendKeys(ConfigReader.getProperty("brcWrogEmail"));

        //test data password : 12346
        brcPage.sifreBox.sendKeys(ConfigReader.getProperty("brcWrogSifre"));

        //Logon Butonuna tiklayin
        brcPage.loginiki.click();

        Thread.sleep(2000);

        Assert.assertTrue(brcPage.loginiki.isDisplayed());

        Driver.getDriver().close();
    }
}
