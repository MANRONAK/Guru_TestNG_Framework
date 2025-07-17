package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config_Properties {

    private  Properties properties=new Properties();

    {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");
            properties.load(fileInputStream);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getProperties(String property) {
        return properties.getProperty(property);
    }

}
