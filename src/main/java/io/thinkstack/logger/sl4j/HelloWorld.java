package io.thinkstack.logger.sl4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
  public static void main(String[] args) {
    Logger logger = LoggerFactory.getLogger(HelloWorld.class);
    logger.info("Hello World");

    if(logger.isDebugEnabled()) {
      logger.debug("java logging level is DEBUG Enabled");
    }
  }
}
