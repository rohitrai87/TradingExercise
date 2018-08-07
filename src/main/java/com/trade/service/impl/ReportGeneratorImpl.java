/**
 *
 * File Name             :ReportGeneratorImpl.java
 *
 * Package Name          :com.trade.service.impl
 *
 * Class Name            :ReportGeneratorImpl.java
 *
 * Class Type            :Public
 *
 * Description           :This class implements ReportGenerator Interface
 * 
 * Super Class           :None
 *
 * Interfaces Implemented:ReportGenerator
 *
 * Author Name           :Rohit.Rai
 *
 * Date                  :07-Aug-2018
 *
 * Revision History      :1.0.0.0
 *                        Author Name  Date        Change Description  Version	 	
 *
 */

package com.trade.service.impl;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Map.Entry;

import com.trade.constants.TradeConstants;
import com.trade.service.ReportGenerator;
import com.trade.util.TradeUtility;

public class ReportGeneratorImpl implements ReportGenerator {
	private Map<String, Double> hmIncomingStlmntAmnt;
	private Map<String, Double> hmOutgoingStlmntAmnt;
	private Map<String, Double> hmIncomingEntityRank;
	private Map<String, Double> hmOutgoingEntityRank;
	private static DecimalFormat df = new DecimalFormat("####0.00");
	
	/**
	 * This method is used to generate trade sales report
	 * @param strReportDate for Reporting Date
	 * @param hmMap for HashMap containing trade details HashMap
	 */
	public void generateTradeSalesReport(String strReportDate, Map<String, Map<String, Double>> hmMap) {
		//Printing the reporting output
		System.out.println("***************** Amount in USD settled incoming: *************************");
		if(hmMap.containsKey(TradeConstants.INCOMING_SETTLEMENT_AMNT)) {
			hmIncomingStlmntAmnt = hmMap.get(TradeConstants.INCOMING_SETTLEMENT_AMNT);
			if(hmIncomingStlmntAmnt.containsKey(strReportDate)) {
				System.out.println(hmIncomingStlmntAmnt.get(strReportDate));
			} else {
				System.out.println("There are no incoming trades for the settlement day " + strReportDate + "!!!");
			}
		} else {
			System.out.println("There are no incoming trades settled on the reporting day!!!");
		}
		System.out.println("***************************************************************************");

		System.out.println("***************** Amount in USD settled outgoing: *************************");
		if(hmMap.containsKey(TradeConstants.OUTGOING_SETTLEMENT_AMNT)) {
			hmOutgoingStlmntAmnt = hmMap.get(TradeConstants.OUTGOING_SETTLEMENT_AMNT);
			if(hmOutgoingStlmntAmnt.containsKey(strReportDate)) {
				System.out.println(hmOutgoingStlmntAmnt.get(strReportDate));
			} else {
				System.out.println("There are no outgoing trades for the settlement day " + strReportDate + "!!!");
			}
		} else {
			System.out.println("There are no outgoing trades in the system!!!");
		}
		System.out.println("***************************************************************************");

		System.out.println("***************** Ranking of Incmoing Entities: ***************************");
		if(hmMap.containsKey(TradeConstants.INCOMING_ENTITY_RANK)) {
			hmIncomingEntityRank = hmMap.get(TradeConstants.INCOMING_ENTITY_RANK);
			printRankReport(TradeUtility.sortMapByEntities(hmIncomingEntityRank));
		} else {
			System.out.println("There are no incoming trades in the system!!!");
		}
		System.out.println("***************************************************************************");

		System.out.println("***************** Ranking of Outgoing Entities: ***************************");
		if(hmMap.containsKey(TradeConstants.OUTGOING_ENTITY_RANK)) {
			hmOutgoingEntityRank = hmMap.get(TradeConstants.OUTGOING_ENTITY_RANK);
			printRankReport(TradeUtility.sortMapByEntities(hmOutgoingEntityRank));
		} else {
			System.out.println("There are no outgoing trades in the system!!!");
		}
		System.out.println("***************************************************************************");

	}
	
	/**
	 * This method is used to print trade sales report
	 * @param hmSortedMap for Sorted Ranking Map
	 */
	private void printRankReport(Map<String, Double> hmSortedMap) {
		//Printing values after sorting the map
		int iRank = 0;
		System.out.println("-------------------------------------------------");
		System.out.println("Entity		Rank		Trading Amount");
		for(Entry<String, Double> entry : hmSortedMap.entrySet()) {
			iRank ++;
			System.out.println(entry.getKey() + "\t\t" + iRank + "\t\t $" + df.format(entry.getValue()));
		}
		System.out.println("-------------------------------------------------");
	}//End of printRankReport method
	
}//End of ReportGeneratorImpl class
