/**
 *
 * File Name             :TradeReporting.java
 *
 * Package Name          :com.trade.reporting
 *
 * Class Name            :TradeReporting.java
 *
 * Class Type            :Public
 *
 * Description           :This is the Trade Reporting class
 * 
 * Super Class           :None
 *
 * Interfaces Implemented:None
 *
 * Author Name           :Rohit.Rai
 *
 * Date                  :05-Aug-2018
 *
 * Revision History      :1.0.0.0
 *                        Author Name  Date        Change Description  Version	 	
 *
 */

package com.trade.reporting;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

/**
 * This class is for Reporting incoming/outgoing Trades settlements
 */
public class TradeReporting {
	//Instance Variables declarations
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat day = new SimpleDateFormat("EEEE");
	private static Map<String, Double> hmIncomingStlmntAmnt = new HashMap<String, Double>();
	private static Map<String, Double> hmOutgoingStlmntAmnt = new HashMap<String, Double>();
	private static Map<String, Double> hmIncomingEntityRank = new HashMap<String, Double>();
	private static Map<String, Double> hmOutgoingEntityRank = new HashMap<String, Double>();
	private static DecimalFormat df = new DecimalFormat("####0.00");

	/**
	 * This is the main method of execution
	 * @param args for String[]
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		Trade objTrade;

		try {
			objTrade = new Trade("foo", "B",0.50,"SGP",sdf.parse("22/07/2016"),sdf.parse("28/07/2018"),200,100.25);
			validateTrade(objTrade);

			objTrade = new Trade("foo", "S",0.50,"SGP",sdf.parse("22/07/2016"),sdf.parse("29/07/2018"),300,100.15);
			validateTrade(objTrade);

			objTrade = new Trade("bar", "S",0.22,"AED",sdf.parse("22/07/2016"),sdf.parse("27/07/2018"),350,101.5);
			validateTrade(objTrade);

			objTrade = new Trade("foo", "B",0.22,"AED",sdf.parse("22/07/2016"),sdf.parse("28/07/2018"),450,150.5);
			validateTrade(objTrade);

			objTrade = new Trade("bar", "S",0.22,"SAR",sdf.parse("22/07/2016"),sdf.parse("27/07/2018"),200,140.5);
			validateTrade(objTrade);

			objTrade = new Trade("foo", "B",0.40,"SAR",sdf.parse("22/07/2016"),sdf.parse("28/07/2018"),800,10.25);
			validateTrade(objTrade);

			objTrade = new Trade("bar", "B",0.70,"SGP",sdf.parse("22/07/2016"),sdf.parse("28/07/2018"),4500,90.5);
			validateTrade(objTrade);

			objTrade = new Trade("bar", "B",1.70,"GBP",sdf.parse("22/07/2016"),sdf.parse("29/07/2018"),600,90.5);
			validateTrade(objTrade);

			objTrade = new Trade("zoo", "B",0.50,"SGP",sdf.parse("22/07/2016"),sdf.parse("30/07/2018"),5420,100.25);
			validateTrade(objTrade);

			objTrade = new Trade("hoo", "S",0.50,"SGP",sdf.parse("22/07/2016"),sdf.parse("27/07/2018"),654,100.15);
			validateTrade(objTrade);

			objTrade = new Trade("hoo", "S",0.22,"AED",sdf.parse("22/07/2016"),sdf.parse("29/07/2018"),599,101.5);
			validateTrade(objTrade);

			objTrade = new Trade("moo", "B",0.22,"AED",sdf.parse("22/07/2016"),sdf.parse("28/07/2018"),9879,150.5);
			validateTrade(objTrade);

			objTrade = new Trade("boo", "S",0.22,"SAR",sdf.parse("22/07/2016"),sdf.parse("27/07/2018"),8798,140.5);
			validateTrade(objTrade);

			objTrade = new Trade("foo", "B",0.40,"SAR",sdf.parse("22/07/2016"),sdf.parse("29/07/2018"),3978,10.25);
			validateTrade(objTrade);

			objTrade = new Trade("bar", "B",0.70,"SGP",sdf.parse("22/07/2016"),sdf.parse("28/07/2018"),654,90.5);
			validateTrade(objTrade);

			objTrade = new Trade("noo", "B",1.70,"GBP",sdf.parse("22/07/2016"),sdf.parse("30/07/2018"),789,90.5);
			validateTrade(objTrade);

			objTrade = new Trade("zoo", "B",0.50,"SGP",sdf.parse("22/07/2016"),sdf.parse("29/07/2018"),6578,100.25);
			validateTrade(objTrade);

			//Read Reporting Date from the console
			System.out.print("Enter a date for reporting in dd/mm/yyyy format: ");
			Scanner scanner = new Scanner(System.in);
			String strReportDate = sdf.parse(scanner.nextLine()).toString();
			System.out.println("Reporting date: " + strReportDate);

			//Printing the reporting output
			System.out.println("***************** Amount in USD settled incoming: *************************");
			if(hmIncomingStlmntAmnt.containsKey(strReportDate)) {
				System.out.println(hmIncomingStlmntAmnt.get(strReportDate));
			} else {
				System.out.println("There are no incoming trades for the settlement day " + strReportDate + "!!!");
			}
			System.out.println("***************************************************************************");

			System.out.println("***************** Amount in USD settled outgoing: *************************");
			if(hmOutgoingStlmntAmnt.containsKey(strReportDate)) {
				System.out.println(hmOutgoingStlmntAmnt.get(strReportDate));
			} else {
				System.out.println("There are no outgoing trades for the settlement day " + strReportDate + "!!!");
			}
			System.out.println("***************************************************************************");

			System.out.println("***************** Ranking of Incmoing Entities: ***************************");
			sortMapByEntities(hmIncomingEntityRank);
			System.out.println("***************************************************************************");

			System.out.println("***************** Ranking of Outgoing Entities: ***************************");
			sortMapByEntities(hmOutgoingEntityRank);
			System.out.println("***************************************************************************");
		} catch(ParseException parExcp) {
			System.out.println("Incorrect Date Format!!!!! Please enter the date in dd/mm/yyyy format");
		}//End of Catch block

	}//End of main method

	/**
	 * This method is to validate the trade and calculate revised settlement date
	 * based on currency and total amount based on fX, Price Per Unit and Units
	 * @param objTrade for input Trade object
	 */
	private static void validateTrade(Trade objTrade) {
		double dTrdAmount;
		double dPrcPerUnit;
		double dFx;
		double dTotalAmount = 0.00;
		long lUnits;
		String strStlmntDate;
		String strEntity;

		//Calculating Revised settlement date based on Currency
		if((objTrade.getStrCurr().equalsIgnoreCase(TradeConstants.AED)) 
				|| (objTrade.getStrCurr().equalsIgnoreCase(TradeConstants.SAR))) {
			if(day.format(objTrade.getOrigStlmntDate()).equalsIgnoreCase(TradeConstants.FRI)) {
				objTrade.setRevStlmntDate(addDays(objTrade.getOrigStlmntDate(), 2));
			} else if(day.format(objTrade.getOrigStlmntDate()).equalsIgnoreCase(TradeConstants.SAT)) {
				objTrade.setRevStlmntDate(addDays(objTrade.getOrigStlmntDate(), 1));
			} else {
				objTrade.setRevStlmntDate(objTrade.getOrigStlmntDate());
			}
		} else {
			if(day.format(objTrade.getOrigStlmntDate()).equalsIgnoreCase(TradeConstants.SAT)) {
				objTrade.setRevStlmntDate(addDays(objTrade.getOrigStlmntDate(), 2));
			} else if(day.format(objTrade.getOrigStlmntDate()).equalsIgnoreCase(TradeConstants.SUN)) {
				objTrade.setRevStlmntDate(addDays(objTrade.getOrigStlmntDate(), 1));
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
		if(objTrade.getStrFlag().equalsIgnoreCase(TradeConstants.SELL)) {
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
		} else if (objTrade.getStrFlag().equalsIgnoreCase(TradeConstants.BUY)) {
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
	}//End of validateTrade method

	/**
	 * This method is to add days to the passed Date parameter
	 * @param date for input Date
	 * @param days for number of days to be added
	 */
	private static Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}//End of addDays method

	/**
	 * This method is to sort the entities based on their incoming/outgoing amounts
	 * @param unsortedMap for Unsorted Ranking Map
	 */
	private static void sortMapByEntities(Map<String, Double> unsortedMap) {
		//Retrieve entities from the unsorted map
		Set<Entry<String, Double>> mapEntities = unsortedMap.entrySet();

		//Convert mapEntities into a Linked List
		List<Entry<String, Double>> llEntities = new LinkedList<Entry<String, Double>>(mapEntities);

		//Sorting the Linked List
		Collections.sort(llEntities, new Comparator<Entry<String, Double>>() {
			public int compare(Entry<String, Double> e1,
					Entry<String, Double> e2) {
				return e2.getValue().compareTo(e1.getValue());
			}
		});

		//Storing the list into Linked HashMap to preserve the order of insertion.
		Map<String, Double> sortedMap = new LinkedHashMap<String, Double>();
		for(Entry<String, Double> entry: llEntities) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		//Printing values after sorting the map
		int iRank = 0;
		System.out.println("-------------------------------------------------");
		System.out.println("Entity		Rank		Trading Amount");
		for(Entry<String, Double> entry : sortedMap.entrySet()) {
			iRank ++;
			System.out.println(entry.getKey() + "\t\t" + iRank + "\t\t $" + df.format(entry.getValue()));
		}
		System.out.println("-------------------------------------------------");
	}//End of sortMapByEntities method

}//End of TradeReporting class
