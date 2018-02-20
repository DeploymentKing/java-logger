package io.thinkstack.logger.slf4j;

import com.github.ricksbrown.cowsay.Cowsay;
import jfortune.Fortune;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

public class CowsayOutput {
  public static void main(String[] args) {
    Logger logger = LoggerFactory.getLogger(CowsayOutput.class);
    logger.info("Initiate Cowsay Loop");

    Fortune fortune = new Fortune(Locale.ENGLISH);

    Integer loopCount = Integer.valueOf(PropertyHelper.getProperty("logger.loopCount", "10"));
    Integer sleep = Integer.valueOf(PropertyHelper.getProperty("logger.sleep", "500"));

    for (int i = 0; i < loopCount; i++) {
      String[] cowsayArgs = i % 2 == 0 ?
          new String[]{fortune.getCookie().toString()} :
          new String[]{"-f", "tux", fortune.getCookie().toString()};

      logger.info(String.format("\n\n%s", Cowsay.say(cowsayArgs)));

      try {
        Thread.sleep(sleep);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    if (logger.isDebugEnabled()) {
      logger.debug("Java logging level is DEBUG enabled");
    }
  }
}
