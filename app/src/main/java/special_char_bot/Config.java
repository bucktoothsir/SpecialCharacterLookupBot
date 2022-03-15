package special_char_bot;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    public String botToken;
    public String botUsername;
    InputStream inputStream;
    public Config(String fileName) throws IOException {
        try {
            Properties prop = new Properties();
            inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
            if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + fileName + "' not found in the classpath");
			}
            // Telegram Bot Token
            botToken = prop.getProperty("token");
            // Telegram Bot Username
            botUsername = prop.getProperty("username");

        }
        catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        finally {
            inputStream.close();
		}
    }
}
