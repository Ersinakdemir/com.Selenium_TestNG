package tests.denemeler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Reach_ShoppingPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Reach_Shopping{
    @Test
    public void test01() throws InterruptedException {
        Reach_ShoppingPage reach_shoppingPage =new Reach_ShoppingPage();
        // 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("reachUrl"));

        // 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
        Reach_ShoppingPage rs = new Reach_ShoppingPage();
        for (int i = 0; i < rs.ürünlistesi.size(); i++) {
            System.out.println(i + 1 + ".Ürün :" + rs.ürünlistesi.get(i).getText());
        }
        // 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
        for (WebElement each : rs.ürünIsmi
        ) {
            System.out.println(each.getText());
        }
// 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
// (Her ürün 1 defadan fazla eklenemez!)
        Random rnd = new Random();
        List<String> fiyat = new ArrayList<>();
        List<WebElement>sepetList =new ArrayList<>();

        /*for (int i = 0; i < 5; i++) {
            int index = rnd.nextInt(rs.randomListe.size());
            rs.randomListe.get(index).click();
            System.out.println("********" + rs.ürünIsmi.get(index).getText());
            Thread.sleep(1000);
            rs.butonTiklama.click();
            // 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
            System.out.println(rs.fiyatListesi.get(index).getText());
            fiyat.add(rs.fiyatListesi.get(index).getText());
        }*/
        WebDriverWait wait =new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        while (sepetList.size()<5){
            int index = rnd.nextInt(rs.randomListe.size());
            if (!sepetList.contains(rs.ürünIsmi.get(index))){
                sepetList.add(rs.randomListe.get(index));
                System.out.println(rs.fiyatListesi.get(index).getText());
                fiyat.add(rs.fiyatListesi.get(index).getText());
                rs.randomListe.get(index).click();
//        WebElement itsGoneYaziElementi=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]")));
                //Thread.sleep(1000);
                WebElement sepetKapatmaButonu =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/button/span")));
                //rs.butonTiklama.click();
                sepetKapatmaButonu.click();

            }

        }
        System.out.println("Fiyat Toplami :" + fiyat.stream().map(t -> t.substring(1)).map(Double::valueOf).reduce(Double::sum));
        Optional opt = fiyat.stream().map(t -> t.substring(1)).map(Double::valueOf).reduce(Double::sum);

        double expectedToplam = (double) opt.get();

        // 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin
        // 7.Checkout'a tıklayın
        rs.sepet.click();
        System.out.println("toplam acrualden önce   "+rs.toplamFiyat.getText());
        double actualGesamtPreis = Double.parseDouble(rs.toplamFiyat.getText().substring(2));

        DecimalFormat df = new DecimalFormat("#.##");
        expectedToplam= Double.parseDouble(df.format(expectedToplam));


        Assert.assertEquals(actualGesamtPreis,expectedToplam);
        rs.checkbutton.click();
        Driver.getDriver().switchTo().alert().accept();
    }
}
