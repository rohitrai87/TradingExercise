package com.trade.DAO;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;

import com.trade.beans.Trade;
import com.trade.executor.TradeSalesSimulator;

public class TradeDAOTest {
	private TradeSalesSimulator objTradeSalSim = new TradeSalesSimulator();
	@Test
	
	public void testGetTradeDetails() throws ParseException {
		List<Trade> alTradeList = objTradeSalSim.getTradeDetails();
		assertNotNull(alTradeList);
		assertTrue(!alTradeList.isEmpty());
		assertEquals(5, alTradeList.stream().filter(event -> event.getStrEntity().equals("foo")).count());
		assertEquals(5, alTradeList.stream().filter(event -> event.getStrEntity().equals("bar")).count());
		assertEquals(2, alTradeList.stream().filter(event -> event.getStrEntity().equals("zoo")).count());
		assertEquals(1, alTradeList.stream().filter(event -> event.getStrEntity().equals("noo")).count());
		assertEquals(1, alTradeList.stream().filter(event -> event.getStrEntity().equals("moo")).count());
		assertEquals(1, alTradeList.stream().filter(event -> event.getStrEntity().equals("boo")).count());
		assertEquals(2, alTradeList.stream().filter(event -> event.getStrEntity().equals("hoo")).count());
	}

}
