package com.exchange.summary.report;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.exchange.summary.report.model.TradeImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SummaryApplicationTests<T> {
	
	@Autowired
	TradeConfiguration<TradeImpl> tc;
	
	@Test
	public void contextLoads() {
		assertEquals("Context failed to load",tc.clientSummary.size(),5);
	}

}
