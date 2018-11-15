package eu.nets.ms.pia.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class VersionInfo.
 */
public class SecretsStore {
    private Properties properties = null;
	
    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(SecretsStore.class);

    public SecretsStore(String secretsFile) {
    	
        try (InputStream stream = new FileInputStream(secretsFile)) {
            if (stream != null) {
                properties = new Properties();
                properties.load(stream);
            }
        } catch (IOException e) {
            LOGGER.error("Fail to read " + secretsFile + ". Fatal", e);
        }
    }

	

	public String getSecret(String key) {
		return properties.getProperty(key);
	}
    }

