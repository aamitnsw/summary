package com.exchange.summary.report.parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.exchange.summary.report.model.TradeImpl;
import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.conversions.Conversions;
import com.univocity.parsers.fixed.FixedWidthParser;
import com.univocity.parsers.fixed.FixedWidthParserSettings;

@Configuration
public class FileReadParser<T> {
	
	private final Logger logger = LoggerFactory.getLogger(FileReadParser.class);
	
	@Value("${input.filename}")
	String inputFileName;
	
	public <T> List<T> parseFile(Class<T> beanClass) {

		BeanListProcessor<T> rowProcessor = new BeanListProcessor<T>(beanClass);
		rowProcessor.convertType(java.util.Date.class, Conversions.toDate("yyyyMMdd"));

		FixedWidthParserSettings settings = new FixedWidthParserSettings();

		settings.getFormat().setPadding('_');
		settings.getFormat().setLineSeparator("\r\n");
		settings.setRecordEndsOnNewline(true);
		settings.setProcessor(rowProcessor);

		FixedWidthParser parser = new FixedWidthParser(settings);
		
		
		List<T> allRows = null;
		try {
			logger.info("inputFileName1 "+inputFileName);
			parser.parse(new InputStreamReader(new FileInputStream(inputFileName), "UTF-8"));
			allRows = rowProcessor.getBeans();
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			logger.info("Input file not found");
			e.printStackTrace();
		}

		return allRows;
	}

}
