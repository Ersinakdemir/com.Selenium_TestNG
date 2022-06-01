package tests.denemeler;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Demo_Guru99_Page;
import utilities.ConfigReader;
import utilities.Driver;

//➢ doubleClick ( ): WebElement’e çift tıklama yapar
//
//➢ clickAndHold ( ): WebElement uzerinde click yapili
//olarak bizden komut bekler.
//
//➢ dragAndDrop ( ): WebElement’i bir noktadan diğerine
//sürükler ve bırakır
//
//➢ moveToElement ( ): Mouse’u istedigimiz WebElement’in
//uzerinde tutar
//
//➢ contextClick ( ): Mouse ile istedigimiz WebElement’e
//sag tiklama yapar.

public class Demo_Guru99_Surukle {
    @Test
    public void test01() throws InterruptedException {
        Demo_Guru99_Page demoGuru=new Demo_Guru99_Page();
        // http://demo.guru99.com/test/drag_drop.html url e git
        Driver.getDriver().get(ConfigReader.getProperty("demoguru99"));
        Thread.sleep(2000);
        demoGuru.cookiesConset.click();

        Actions actions=new Actions(Driver.getDriver());

        //    DEBIT SIDE da Account bolumune BANK butonunu surukle ve birak
        actions.dragAndDrop(demoGuru.bankElement, demoGuru.accountAlti).perform();

        //    CREDIT SIDE da Account bolumune SALES butonunu surukle ve birak
        actions.dragAndDrop(demoGuru.salesElment, demoGuru.creditSideAccount).perform();

        //    DEBIT SIDE da Amount bolumune 5000 butonunu surukle ve birak
        actions.dragAndDrop(demoGuru.birinciBesBin, demoGuru.amaountAlti).perform();

        //    CREDIT SIDE da Amount bolumune ise ikinci 5000  butonunu surukle ve birak
        actions.dragAndDrop(demoGuru.ikinciBesBin, demoGuru.amountAltiCreditSide).perform();

        //    Perfect butonun goruntulendigini dogrulayin
        Assert.assertTrue(demoGuru.perfectElement.isDisplayed());

        Driver.getDriver().close();
    }
}
