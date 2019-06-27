package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesReader {

    private static Properties properties;
    private static Logger logger;

    private PropertiesReader() {
    }

    public static Properties properties() {
        if (properties == null) {
            logger =  LoggerFactory.getLogger(PropertiesReader.class);
            String propertiesFileName;
            properties = new Properties();
            propertiesFileName = System.getProperty("propFileName", "default");
            try (InputStream is = PropertiesReader.class.getClassLoader().getResourceAsStream(propertiesFileName + ".properties")){
                properties.load(is);
            } catch (NullPointerException | IOException ex) {
                logger.error(ex.getMessage());
            }
        }
        return properties;
    }
}
