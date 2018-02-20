package io.thinkstack.logger.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class PropertyHelper {
  protected static String getProperty(String key, String defaultValue) {
    Logger logger = LoggerFactory.getLogger(PropertyHelper.class);
    Properties properties = System.getProperties();

    String value = properties.getProperty(key) != null ? properties.getProperty(key) : defaultValue;

    if (logger.isDebugEnabled()) {
      logger.debug(String.format("Getting property with key %s returned the value %s", key, value));
    }

    return value;
  }
}
