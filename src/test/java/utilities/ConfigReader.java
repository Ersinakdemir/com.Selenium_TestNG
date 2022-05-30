package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties properties;

    static {
        String dosyaYolu ="configuration.properties";
        try {
            FileInputStream fis =new FileInputStream(dosyaYolu);
            properties =new Properties();
            properties.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        /*
        test methodundan yolladigimiz string key degerini alip properties in da getproperty
        methodunun kullanmak bu key e ait value bize getirir
         */
        return properties.getProperty(key);
    }
}
