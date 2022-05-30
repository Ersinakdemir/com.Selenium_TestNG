package denemeler;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class HotelMyCamp {
    @Test
    public void testName01() {
        HotelMyCampPage hotelMyCampPage =new HotelMyCampPage();
        //1 ) Bir Class olustur : PositiveTest
        //2) Bir test method olustur positiveLoginTest()
        //https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get("https://www.hotelmycamp.com/");

        //login butonuna bas
        hotelMyCampPage.logInElement.click();

        //test data username: manager ,
        hotelMyCampPage.userNameElement.sendKeys("manager");
        Actions actions =new Actions(Driver.getDriver());

        //test data password : Manager1!
        actions.sendKeys(Keys.TAB);
        actions.sendKeys("Manager1!");
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.ENTER).perform();

        //6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
        hotelMyCampPage.hotelManagementElemet.click();
        hotelMyCampPage.hotelRoomsElement.click();
        hotelMyCampPage.addHotelRoomsElement.click();

        //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        Select select =new Select(hotelMyCampPage.idHotelElement);
        select.selectByVisibleText("Grand QA");

        actions.sendKeys(Keys.TAB);
        actions.sendKeys("ari");
        actions.sendKeys(Keys.TAB);
        actions.sendKeys("Ersin");
        actions.sendKeys(Keys.TAB);
        actions.sendKeys("Erzurum").perform();
        hotelMyCampPage.descrieptionEelement.sendKeys("Palandoken");
        actions.sendKeys(Keys.TAB);
        actions.sendKeys("300");
        actions.sendKeys(Keys.TAB).perform();
        Select select1 =new Select(hotelMyCampPage.roomTypeElement);
        select1.selectByVisibleText("Double");
        actions.sendKeys(Keys.TAB);
        actions.sendKeys("2");
        actions.sendKeys(Keys.TAB);
        actions.sendKeys("3");

        //8. Save butonuna basin.
        actions.sendKeys(Keys.ENTER)
                .perform();


        //9. “HotelRoom was inserted successfully” textinin göründüğünü test edin.
        Assert.assertTrue(hotelMyCampPage.successfullyElement.isDisplayed());
        //10. OK butonuna tıklayın.
        hotelMyCampPage.okTusuElementi.click();

        //11. Hotel rooms linkine tıklayın.
        hotelMyCampPage.hoteRoomsLink.click();

        //12. "LIST OF HOTELROOMS" textinin göründüğünü doğrulayın..
        Assert.assertTrue(hotelMyCampPage.listOFHotelroomsElement.isDisplayed());
    }
}
