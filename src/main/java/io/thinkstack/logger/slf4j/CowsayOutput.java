package io.thinkstack.logger.slf4j;

import com.github.ricksbrown.cowsay.Cowsay;
import jfortune.Fortune;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CowsayOutput {
  public static void main(String[] args) {
    Logger logger = LoggerFactory.getLogger(CowsayOutput.class);
    logger.info("Initiate Cowsay Loop");

    Fortune fortune = new Fortune();

    Integer loopCount = (Integer) PropertyHelper.getProperty("logger.loopCount", 10);
    Integer sleep = (Integer) PropertyHelper.getProperty("logger.sleep", 500);

    for (int i = 0; i < loopCount; i++) {
      logger.info(String.format("#%s %s", i, Cowsay.say(new String[]{"-f", "tux", fortune.getCookie().toString()})));
      try {
        Thread.sleep(sleep);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    if(logger.isDebugEnabled()) {
      logger.debug("Java logging level is DEBUG enabled");
    }
  }
}
