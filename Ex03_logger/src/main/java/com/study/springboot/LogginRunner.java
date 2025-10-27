package com.study.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Service;

@Service
public class LogginRunner implements ApplicationRunner {
	Logger LOGGER = LoggerFactory.getLogger(LogginRunner.class);
	@Override
	public void run(ApplicationArguments args) throws Exception {
		LOGGER.trace("Trace 레벨 로그");
		LOGGER.debug("Debug 레벨 로그");
		LOGGER.info("INFO 레벨 로그");
		LOGGER.warn("WARN 레벨 로그");
		LOGGER.error("ERROR 레벨 로그");
	}
}