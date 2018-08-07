package com.trade.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.trade.constants.TradeConstants;

public class ReportGeneratorImplTest {
	private ReportGeneratorImpl objRepGenImplTest = new ReportGeneratorImpl();
	private Map<String, Double> hmIncomingStlmntAmnt = new HashMap<String, Double>();
	private Map<String, Double> hmOutgoingStlmntAmnt = new HashMap<String, Double>();
	private Map<String, Double> hmIncomingEntityRank = new HashMap<String, Double>();
	private Map<String, Double> hmOutgoingEntityRank = new HashMap<String, Double>();
	private Map<String, Map<String, Double>> hmMap = new HashMap<String, Map<String, Double>>();
	
	@Before
	public void before() {
		hmIncomingStlmntAmnt.put("30/07/2018", 435345.5);
		hmIncomingStlmntAmnt.put("29/07/2018", 883843.5);
		hmIncomingStlmntAmnt.put("31/07/2018", 854968458.5);
		hmIncomingStlmntAmnt.put("28/07/2018", 2376.5);
		
		hmOutgoingStlmntAmnt.put("30/07/2018", 3423423.99);
		hmOutgoingStlmntAmnt.put("29/07/2018", 35454.99);
		hmOutgoingStlmntAmnt.put("31/07/2018", 234555.99);
		hmOutgoingStlmntAmnt.put("28/07/2018", 9879665.99);
		
		hmIncomingEntityRank.put("foo", 3423423432.56);
		hmIncomingEntityRank.put("bar", 123131231.67);
		hmIncomingEntityRank.put("moo", 45345343.56767);
		hmIncomingEntityRank.put("noo", 54645646456.45645);
		hmIncomingEntityRank.put("zoo", 657657567565.6756);
		hmIncomingEntityRank.put("hoo", 4234343545.60);
		
		hmOutgoingEntityRank.put("foo", 213123.56);
		hmOutgoingEntityRank.put("bar", 3454353.67);
		hmOutgoingEntityRank.put("moo", 7654322.56767);
		hmOutgoingEntityRank.put("noo", 5464567.45645);
		hmOutgoingEntityRank.put("zoo", 456587674.6756);
		hmOutgoingEntityRank.put("hoo", 12132423.60);
		
		hmMap.put(TradeConstants.INCOMING_SETTLEMENT_AMNT, hmIncomingStlmntAmnt);
		hmMap.put(TradeConstants.OUTGOING_SETTLEMENT_AMNT, hmOutgoingStlmntAmnt);
		hmMap.put(TradeConstants.INCOMING_ENTITY_RANK, hmIncomingEntityRank);
		hmMap.put(TradeConstants.OUTGOING_ENTITY_RANK, hmOutgoingEntityRank);
	}
	
	@Test
	public void testGenerateTradeSalesReport() {
		objRepGenImplTest.generateTradeSalesReport("28/07/2018", hmMap);
		objRepGenImplTest.generateTradeSalesReport("29/07/2018", hmMap);
		objRepGenImplTest.generateTradeSalesReport("30/07/2018", hmMap);
		objRepGenImplTest.generateTradeSalesReport("31/07/2018", hmMap);
	}

}
