package tests.day17_Pom;

import org.testng.annotations.Test;
import utilities.Driver;

public class C01_YeniDriverIlkClass {
    @Test(groups = "grup1")
    public void test01() {
        Driver.getDriver().get("https://www.amazon.com");
        /*
        Bugüne kadar TestBase class ina extends ederek kullandigimiz driver yerine bundan sonra Driver class indan
        kullanacagimiz getDriver static methodunu kullanacagiz
         */
        Driver.getDriver().get("https://bestbuy.com");
        Driver.getDriver().get("https://facebook.com");
        Driver.clossDriver();
    }
}
