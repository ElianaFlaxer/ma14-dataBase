package worksapce.eliana.DBbuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    public Properties load() throws IOException {

        InputStream input = new FileInputStream("src/main/resources/config.properties");

        Properties prop = new Properties();
        prop.load(input);

        return prop;
    }
}
