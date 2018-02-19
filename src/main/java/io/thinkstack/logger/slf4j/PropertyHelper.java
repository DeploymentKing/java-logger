package io.thinkstack.logger.slf4j;

import java.util.Properties;

public class PropertyHelper {
  protected static Object getProperty(String key, Object defaultValue) {
    Properties properties = System.getProperties();
    return properties.getProperty(key) != null ? properties.getProperty(key) : defaultValue;
  }
}
