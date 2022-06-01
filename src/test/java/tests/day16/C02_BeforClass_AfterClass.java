package tests.day16;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_BeforClass_AfterClass extends TestBase {
    //JUnitte @BeforClass ve @AfterClass static olmak zorundaydi
    //Ama burda test NG de olmak zorunda degil

    /*
    TestNg bize daha fazla before ve after notasyonlari sunar diger
before/afte notasyonlari tanimlyacagimiz grup  test ve suit den once ve sonra calisirlar
ilerdie xml dosyalari ile birlikte bunu gorecegiz
     */
    @BeforeClass
    public void beforClassMethod(){
        System.out.println("Before Class");
    }
    @AfterClass
    public void afterClassMethod(){
        System.out.println("After Class");
    }
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
