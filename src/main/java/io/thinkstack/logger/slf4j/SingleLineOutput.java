package io.thinkstack.logger.slf4j;

import jfortune.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.Properties;

public class SingleLineOutput {
  public static void main(String[] args) throws InterruptedException {
    Logger logger = LoggerFactory.getLogger(SingleLineOutput.class);
    logger.info("Initiate Loop");

    Fortune cookie = new Fortune(Locale.ENGLISH);

    Properties properties = System.getProperties();
    Integer loopCount = getProperty(properties,"logger.loopCount", 10);
    Integer sleep = getProperty(properties,"logger.sleep", 500);

    for (int i = 0; i < loopCount; i++) {
      logger.info(String.format("#%s %s", i,
          cookie.getShortCookie()
              .toString()
              .replaceAll(System.lineSeparator(), " ")
              .replaceAll("\t", "")));
      Thread.sleep(sleep);
    }

    if (logger.isDebugEnabled()) {
      logger.debug("Java logging level is DEBUG enabled");
    }
  }

  private static Integer getProperty(Properties properties, String key, Integer defaultValue) {
    return properties.getProperty(key) != null ?
        Integer.valueOf(properties.getProperty(key)) :
        defaultValue;
  }
}
