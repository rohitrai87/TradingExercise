package com.trade.service.impl;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import com.trade.beans.Trade;
import com.trade.constants.TradeConstants;
import com.trade.executor.TradeSalesSimulator;

public class TradeProcessorImplTest {
	private TradeProcessorImpl objTrdProcImplTest = new TradeProcessorImpl();
	private TradeSalesSimulator objTradeSalSim = new TradeSalesSimulator();
	private Map<String, Map<String, Double>> hmMap;
	
	private List<Trade> alTrades = new ArrayList<Trade>();
	
	@Test
	public void testProcessTrade() throws ParseException {
		alTrades = objTradeSalSim.getTradeDetails();
		
		for(Trade t : alTrades) {
			System.out.println("--------------------------");
			System.out.println(t.getStrEntity());
			System.out.println(t.getFxRate());
			System.out.println(t.getPricePerUnit());
			System.out.println(t.getStrCurr());
			System.out.println(t.getStrFlag());
			System.out.println(t.getUnits());
			System.out.println(t.getOrigStlmntDate());
		}
		
		hmMap = objTrdProcImplTest.processTrade(alTrades);
		assertNotNull(hmMap);
		assertTrue(!hmMap.isEmpty());
		assertNotNull(hmMap.get(TradeConstants.INCOMING_SETTLEMENT_AMNT));
		assertNotNull(hmMap.get(TradeConstants.OUTGOING_SETTLEMENT_AMNT));
		assertNotNull(hmMap.get(TradeConstants.INCOMING_ENTITY_RANK));
		assertNotNull(hmMap.get(TradeConstants.OUTGOING_ENTITY_RANK));
		assertTrue(!(hmMap.get(TradeConstants.INCOMING_SETTLEMENT_AMNT)).isEmpty());
		assertTrue(!(hmMap.get(TradeConstants.OUTGOING_SETTLEMENT_AMNT)).isEmpty());
		assertTrue(!(hmMap.get(TradeConstants.INCOMING_ENTITY_RANK)).isEmpty());
		assertTrue(!(hmMap.get(TradeConstants.OUTGOING_ENTITY_RANK)).isEmpty());
		assertNotNull((hmMap.get(TradeConstants.INCOMING_SETTLEMENT_AMNT)).get("Sun Jul 29 00:00:00 BST 2018"));
		
	}
}
