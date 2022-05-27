package day16_notations;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_BeforeMethod_AfterMetHod extends TestBase {

    //BeforMethod ve AfterMethod notasyonlari JUnit deki Befor ve after gobi
    //her test methodundan önce calisir
    //Test NG de test ler alfabetik siraya göre calisir
    @Test
    public void amazoTesti() {
        driver.get("https://www.amazon.com");
    }
    @Test
    public void test02() {
        driver.get("https://www.bestbuy.com");
    }
    @Test
    public void techproedTesti() {
        driver.get("https://www.techproeducation.com");
    }
}
