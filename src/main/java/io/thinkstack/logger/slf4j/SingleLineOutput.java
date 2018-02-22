package io.thinkstack.logger.slf4j;

import jfortune.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

import static java.lang.System.exit;

public class SingleLineOutput {
  public static void main(String[] args) throws InterruptedException, IllegalArgumentException {
    Logger logger = LoggerFactory.getLogger(SingleLineOutput.class);
    logger.info("Initiate Loop");

    Fortune fortune = new Fortune(Locale.ENGLISH);

    Integer loopCount = Integer.valueOf(PropertyHelper.getProperty("logger.loopCount", "10"));
    Integer sleep = Integer.valueOf(PropertyHelper.getProperty("logger.sleep", "500"));

    String outputFile = PropertyHelper.getProperty("logger.filePath", null);
    if(outputFile == null || outputFile.isEmpty()){
      throw new IllegalArgumentException("Destination file location has NOT been specified using logger.filePath");
    }

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

    exit(0);
  }
}
