package com.exchange.summary.report;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.exchange.summary.report.model.ClientSummary;
import com.exchange.summary.report.model.TradeImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = {
	    "inputFileName=src/test/resources/TestInput.txt1",
	    "outputFileHeader=Client_Information, Product_Information, Total_Transaction_Amount"
	})
public class TradeConfigurationTests {

	@Autowired
	TradeConfiguration<TradeImpl> tc;
	
	TradeImpl trade;
	
	@Before
	public void setup() throws ParseException
	{
		trade=new TradeImpl(315,"CL",4321,2,1,
				"SGXDC","FU","SGX","NK",new SimpleDateFormat("dd/MM/yyyy").parse("22/07/2018"),
				"JPY","01","B","1",Long.valueOf(1),
				"1",Long.valueOf(1),60.0,"D",
				"USD",30.0,"D","USD",
				0.0,"D","JPY",new SimpleDateFormat("dd/MM/yyyy").parse("22/07/2018"),1190,
				"0",687756,23.0,"AKS","AUS","0","filler");
	}
	
	@AfterClass
	public static void cleanUp()
	{
		File file = new File("TestOutput.csv");
		if(file.exists())
			file.delete();
	}
	
	@Test
	public void testManagerSingapore() {
		Map<String, String> clientSummary=tc.managerSingapore();
		assertEquals("managerSingapore failed",clientSummary.size(),5);
		
		assertEquals("managerSingapore data corrupt",clientSummary.get("CL-4321-2-1,SGX-FU-NK-20100910"),"  46.00");
	}

	@Test
	public void testGetClientSpecificDetails()
	{
		List<TradeImpl> list = new ArrayList<TradeImpl>();
		list.add(trade);
		
		List<ClientSummary> clientDetails=tc.getClientSpecificDetails(list);
		
		assertEquals("clientDetails mismatch",clientDetails.size(),1);
		assertEquals("clientsDetails not correct",clientDetails.get(0).getAccountNumber(),2);
	}
	
	@Test 
	public void testgetClientSummary() throws ParseException
	{
		List<ClientSummary> clientDetails=new ArrayList<ClientSummary>(); 
		clientDetails.add(new ClientSummary("CL",1234,2,1,"SGX","FU","NK",new SimpleDateFormat("dd/MM/yyyy").parse("22/07/2018"),2.0));
		clientDetails.add(new ClientSummary("CL",1234,2,1,"SGX","FU","NK",new SimpleDateFormat("dd/MM/yyyy").parse("22/07/2018"),4.0));
		
		Map<String, String> clientSummary=tc.getClientSummary(clientDetails);
		
		assertEquals("clientSummary size mistmatch",clientSummary.size(),1);
		assertEquals("clientSummary grouping issue",clientSummary.get("CL-1234-2-1,SGX-FU-NK-20180722"),"   6.00");
	}
	
	@Test
	@Profile("hongkong")
	public void testManagerHongkong() {
		Map<String, String> clientSummary=tc.managerSingapore();
		
		assertEquals("managerHongkong failed",clientSummary.size(),5);
		assertEquals("managerHongkong data corrupt",clientSummary.get("CL-4321-2-1,SGX-FU-NK-20100910"),"  46.00");
	}
	
	@Test
	public void testManagerWrite()
	{
		tc.managerWrite();
		File file = new File("TestOutput.csv");
		assertTrue("Output file Not created",file.exists());

	}
}
