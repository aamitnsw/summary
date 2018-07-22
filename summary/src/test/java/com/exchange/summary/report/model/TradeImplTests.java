package com.exchange.summary.report.model;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TradeImplTests {
	
	TradeImpl trade;
	
	@Before
	public void setUp() throws ParseException
	{
		trade=new TradeImpl(315,"CL",4321,2,1,
				"SGXDC","FU","SGX","NK",new SimpleDateFormat("dd/MM/yyyy").parse("22/07/2018"),
				"JPY","01","B","1",Long.valueOf(1),
				"1",Long.valueOf(1),60.0,"D",
				"USD",30.0,"D","USD",
				0.0,"D","JPY",new SimpleDateFormat("dd/MM/yyyy").parse("22/07/2018"),1190,
				"0",687756,23.0,"AKS","AUS","0","filler");
	}

	@Test
	public void recordType() {
		assertEquals("recordType mismatch",315,trade.getRecordCode());
	}
	
	@Test
	public void clientType()
	{
		assertEquals("clientType mismatch",trade.getClientType(),"CL");
	}

	@Test
	public void traderInitials()
	{
		assertEquals("traderInitials mismatch",trade.getTraderInitials(),"AKS");
	}
}
