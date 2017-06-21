package com.chm.SpringActivemq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by caohaiming on 2017/6/7.
 */
public class Test {
    private final static Logger logger = LoggerFactory.getLogger(Test.class);
    public static void main(String[] args) {
        logger.info("logback 成功了");
        logger.error("logback 成功了");
        logger.debug("logback 成功了");
    }

}
