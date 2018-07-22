package com.exchange.summary.report;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(TradeConfiguration.class)
@SpringBootApplication(scanBasePackages = { "com.exchange.summary.report" })
public class SummaryApplication {
	
	private final static Logger logger = LoggerFactory.getLogger(TradeConfiguration.class);

	public static void main(String[] args) {
		logger.info("Run Started");
		SpringApplication.run(SummaryApplication.class, args);
		
	}
}
