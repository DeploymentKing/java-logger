package io.thinkstack.logger.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class PropertyHelper {
  protected static String getProperty(String key, String defaultValue) {
    Logger logger = LoggerFactory.getLogger(PropertyHelper.class);
    Properties properties = System.getProperties();
    String value;

    if (properties.getProperty(key) != null) {
      value = properties.getProperty(key);
      if (logger.isDebugEnabled()) {
        logger.debug(String.format("Getting property with key %s returned the value %s", key, value));
      }
    } else {
      value = defaultValue;
      if (logger.isWarnEnabled()) {
        logger.warn(String.format("Requested property with key %s not found. Using default value %s", key, value));
      }
    }

    return value;
  }
}
