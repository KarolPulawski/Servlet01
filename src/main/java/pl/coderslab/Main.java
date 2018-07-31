package pl.coderslab;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Main {

    final static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.error("My error");
        logger.info("custom info");
    }
}
