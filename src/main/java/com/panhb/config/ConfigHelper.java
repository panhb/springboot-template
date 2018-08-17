package com.panhb.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author panhb
 */
@Component
@Order(1)
@Slf4j
public class ConfigHelper implements CommandLineRunner {


	@Override
	public void run(String... strings) {
		log.info("启动之后运行");
	}
}
