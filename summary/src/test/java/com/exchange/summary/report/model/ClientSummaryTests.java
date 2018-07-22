package com.exchange.summary.report.model;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientSummaryTests {
	
	ClientSummary summary=null;

	@Before
	public void setUp() throws Exception {
		
		summary=new ClientSummary("CL",1234,2,1,"SGX","FU","NK",new SimpleDateFormat("dd/MM/yyyy").parse("22/07/2018"),2.0);
	}

	@Test
	public void clientType() {
		assertEquals("clientType mismatch",summary.getClientType(),"CL");
	}
	
	@Test
	public void accountNumber() {
		assertEquals("accountNumber mismatch",summary.getAccountNumber(),2);
	}

}
