package io.thinkstack.logger.sl4j;

import com.github.ricksbrown.cowsay.Cowsay;
import jfortune.Cookie;
import jfortune.Fortune;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CowsayOutput {
  public static void main(String[] args) throws InterruptedException {
    Logger logger = LoggerFactory.getLogger(CowsayOutput.class);
    logger.info("Initiate Cowsay Loop");

    Fortune test = new Fortune();
    Cookie cookie = test.getCookie();

    String[] cowsayArgs = new String[]{"-f", "tux", cookie.toString()};

    for (int i = 0; i < 2; i++) {
      logger.info(String.format("I am loop iteration #%s", i));
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    String result = Cowsay.say(cowsayArgs);
    logger.info(result);

    if(logger.isDebugEnabled()) {
      logger.debug("java logging level is DEBUG Enabled");
    }
  }
}
