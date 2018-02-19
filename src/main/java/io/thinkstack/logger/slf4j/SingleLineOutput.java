package io.thinkstack.logger.slf4j;

import jfortune.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

public class SingleLineOutput {
  public static void main(String[] args) throws InterruptedException {
    Logger logger = LoggerFactory.getLogger(SingleLineOutput.class);
    logger.info("Initiate Loop");

    Fortune fortune = new Fortune(Locale.ENGLISH);

    Integer loopCount = (Integer) PropertyHelper.getProperty("logger.loopCount", 10);
    Integer sleep = (Integer) PropertyHelper.getProperty("logger.sleep", 500);

    for (int i = 0; i < loopCount; i++) {
      logger.info(String.format("#%s %s", i,
          fortune.getShortCookie()
              .toString()
              .replaceAll(System.lineSeparator(), " ")
              .replaceAll("\t", "")));
      Thread.sleep(sleep);
    }

    if (logger.isDebugEnabled()) {
      logger.debug("Java logging level is DEBUG enabled");
    }
  }


}
