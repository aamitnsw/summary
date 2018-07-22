package com.exchange.summary.report.parser;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.exchange.summary.report.model.TradeImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = {
	    "inputFileName=src/test/resources/TestInput.txt1",
	})
public class FileReadParserTest {
	
	@Autowired
	FileReadParser<TradeImpl> fileParser;
	
	@Test
	public void test() {
		List<TradeImpl> trades=fileParser.parseFile(TradeImpl.class);
		
		assertEquals("Trades size mismatch ",trades.size(),717);
		assertNotNull(trades.get(0).getAccountNumber());
	}

}
