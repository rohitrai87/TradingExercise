/**
 *
 * File Name             :TradeProcessorImpl.java
 *
 * Package Name          :com.trade.service.impl
 *
 * Class Name            :TradeProcessorImpl.java
 *
 * Class Type            :Public
 *
 * Description           :This class implements TradeProcessor Interface
 * 
 * Super Class           :None
 *
 * Interfaces Implemented:TradeProcessor
 *
 * Author Name           :Rohit.Rai
 *
 * Date                  :06-Aug-2018
 *
 * Revision History      :1.0.0.0
 *                        Author Name  Date        Change Description  Version	 	
 *
 */

package com.trade.service.impl;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.trade.beans.Trade;
import com.trade.constants.TradeConstants;
import com.trade.constants.TradeCurrency;
import com.trade.constants.TradeType;
import com.trade.constants.TradeWeekends;
import com.trade.service.TradeProcessor;
import com.trade.util.TradeUtility;

public class TradeProcessorImpl implements TradeProcessor {
	private static SimpleDateFormat day = new SimpleDateFormat("EEEE");
	private Map<String, Double> hmIncomingStlmntAmnt = new HashMap<String, Double>();
	private Map<String, Double> hmOutgoingStlmntAmnt = new HashMap<String, Double>();
	private Map<String, Double> hmIncomingEntityRank = new HashMap<String, Double>();
	private Map<String, Double> hmOutgoingEntityRank = new HashMap<String, Double>();
	private Map<String, Map<String, Double>> hmMap = new HashMap<String, Map<String, Double>>();

	public Map<String, Map<String, Double>> processTrade(List<Trade> alTrade) {
		for(Trade objTrade : alTrade) {
			double dTrdAmount;
			double dPrcPerUnit;
			double dFx;
			double dTotalAmount = 0.00;
			long lUnits;
			String strStlmntDate;
			String strEntity;

			//Calculating Revised settlement date based on Currency
			if((objTrade.getStrCurr().equalsIgnoreCase(TradeCurrency.AED)) 
					|| (objTrade.getStrCurr().equalsIgnoreCase(TradeCurrency.SAR))) {
				if(day.format(objTrade.getOrigStlmntDate()).equalsIgnoreCase(TradeWeekends.FRI)) {
					objTrade.setRevStlmntDate(TradeUtility.addDays(objTrade.getOrigStlmntDate(), 2));
				} else if(day.format(objTrade.getOrigStlmntDate()).equalsIgnoreCase(TradeWeekends.SAT)) {
					objTrade.setRevStlmntDate(TradeUtility.addDays(objTrade.getOrigStlmntDate(), 1));
				} else {
					objTrade.setRevStlmntDate(objTrade.getOrigStlmntDate());
				}
			} else {
				if(day.format(objTrade.getOrigStlmntDate()).equalsIgnoreCase(TradeWeekends.SAT)) {
					objTrade.setRevStlmntDate(TradeUtility.addDays(objTrade.getOrigStlmntDate(), 2));
				} else if(day.format(objTrade.getOrigStlmntDate()).equalsIgnoreCase(TradeWeekends.SUN)) {
					objTrade.setRevStlmntDate(TradeUtility.addDays(objTrade.getOrigStlmntDate(), 1));
				} else {
					objTrade.setRevStlmntDate(objTrade.getOrigStlmntDate());
				}
			}//End of currency else block

			//Reading properties from the trade object and setting the trade amount
			strEntity = objTrade.getStrEntity();
			strStlmntDate = objTrade.getRevStlmntDate().toString();
			dPrcPerUnit = objTrade.getPricePerUnit();
			lUnits = objTrade.getUnits();
			dFx = objTrade.getFxRate();
			dTrdAmount = dPrcPerUnit * lUnits * dFx;
			objTrade.setTrdAmount(dTrdAmount);

			//Populating the Incoming and Outgoing HashMaps for Entities and Reporting dates
			if(objTrade.getStrFlag().equalsIgnoreCase(TradeType.SELL)) {
				if(hmIncomingStlmntAmnt.containsKey(strStlmntDate)) {
					dTotalAmount = hmIncomingStlmntAmnt.get(strStlmntDate);
					dTotalAmount = dTotalAmount + dTrdAmount;
					hmIncomingStlmntAmnt.put(strStlmntDate, dTotalAmount);
				} else {
					hmIncomingStlmntAmnt.put(strStlmntDate, dTrdAmount);
				}
				if(hmIncomingEntityRank.containsKey(strEntity)) {
					dTotalAmount = hmIncomingEntityRank.get(strEntity);
					dTotalAmount = dTotalAmount + dTrdAmount;
					hmIncomingEntityRank.put(strEntity, dTotalAmount);
				} else {
					hmIncomingEntityRank.put(strEntity, dTrdAmount);
				}
			} else if (objTrade.getStrFlag().equalsIgnoreCase(TradeType.BUY)) {
				if(hmOutgoingStlmntAmnt.containsKey(strStlmntDate)) {
					dTotalAmount = hmOutgoingStlmntAmnt.get(strStlmntDate);
					dTotalAmount = dTotalAmount + dTrdAmount;
					hmOutgoingStlmntAmnt.put(strStlmntDate, dTotalAmount);
				} else {
					hmOutgoingStlmntAmnt.put(strStlmntDate, dTrdAmount);
				}
				if(hmOutgoingEntityRank.containsKey(strEntity)) {
					dTotalAmount = hmOutgoingEntityRank.get(strEntity);
					dTotalAmount = dTotalAmount + dTrdAmount;
					hmOutgoingEntityRank.put(strEntity, dTotalAmount);
				} else {
					hmOutgoingEntityRank.put(strEntity, dTrdAmount);
				}
			}//End of BUY block
		}//End of trades for loop

		hmMap.put(TradeConstants.INCOMING_SETTLEMENT_AMNT, hmIncomingStlmntAmnt);
		hmMap.put(TradeConstants.OUTGOING_SETTLEMENT_AMNT, hmOutgoingStlmntAmnt);
		hmMap.put(TradeConstants.INCOMING_ENTITY_RANK, hmIncomingEntityRank);
		hmMap.put(TradeConstants.OUTGOING_ENTITY_RANK, hmOutgoingEntityRank);

		return hmMap;
	}
}
