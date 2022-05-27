package day16_notations;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_Priority extends TestBase {
    /*
    TestNG methodlari isim sirasina göre calistirir
    eger isism siralamasinin disinda bir siralama ile calismasini isterseniz
    o zaman test methodlarina öncelik(priority) tanimlanir.

    Priority kücükten büxyüge göre calisir eger bir test methofu na priority
     degeri tanimlanmamissa priority 0 olarak kabul edilir
     */
    @Test(priority=5)
    public void amazoTesti() {
        System.out.println("amazon");
        driver.get("https://www.amazon.com");
    }
    @Test
    public void test02() {
        System.out.println("bestbuy");
        driver.get("https://www.bestbuy.com");
    }
    @Test
    public void techproedTesti() {
        System.out.println("techpro");
        driver.get("https://www.techproeducation.com");
    }

}
