package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesReader {

    private static Properties properties;
    private static final Logger logger = LoggerFactory.getLogger(PropertiesReader.class);

    private PropertiesReader() {
    }

    public static Properties getProperties() {
        String propertiesFilename;
        if (properties == null) {
            properties = new Properties();
            propertiesFilename = System.getProperty("propFileName");
            if (propertiesFilename == null) {
                propertiesFilename = "default";
            }
            try (InputStream is = PropertiesReader.class.getClassLoader().getResourceAsStream(propertiesFilename + ".properties")){
                properties.load(is);
            } catch (NullPointerException | IOException ex) {
                logger.error(ex.getMessage());
            }
        }
        return properties;
    }
}
