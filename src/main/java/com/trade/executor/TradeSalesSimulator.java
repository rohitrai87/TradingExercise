/**
 *
 * File Name             :TradeSalesSimulator.java
 *
 * Package Name          :com.trade.executor
 *
 * Class Name            :TradeSalesSimulator.java
 *
 * Class Type            :Public
 *
 * Description           :This class is to Simulate incoming/outgoing trades
 * 
 * Super Class           :None
 *
 * Interfaces Implemented:None
 *
 * Author Name           :Rohit.Rai
 *
 * Date                  :07-Aug-2018
 *
 * Revision History      :1.0.0.0
 *                        Author Name  Date        Change Description  Version	 	
 *
 */

package com.trade.executor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.trade.beans.Trade;

public class TradeSalesSimulator {
	//Instance Variables declarations
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public List<Trade> getTradeDetails() throws ParseException {
		Trade objTrade;
		List<Trade> alTrades = new ArrayList<Trade>();
		
		objTrade = new Trade("foo", "B",0.50,"SGP",sdf.parse("22/07/2016"),sdf.parse("28/07/2018"),200,100.25);
		alTrades.add(objTrade);

		objTrade = new Trade("foo", "S",0.50,"SGP",sdf.parse("22/07/2016"),sdf.parse("29/07/2018"),300,100.15);
		alTrades.add(objTrade);

		objTrade = new Trade("bar", "S",0.22,"AED",sdf.parse("22/07/2016"),sdf.parse("27/07/2018"),350,101.5);
		alTrades.add(objTrade);

		objTrade = new Trade("foo", "B",0.22,"AED",sdf.parse("22/07/2016"),sdf.parse("28/07/2018"),450,150.5);
		alTrades.add(objTrade);

		objTrade = new Trade("bar", "S",0.22,"SAR",sdf.parse("22/07/2016"),sdf.parse("27/07/2018"),200,140.5);
		alTrades.add(objTrade);

		objTrade = new Trade("foo", "B",0.40,"SAR",sdf.parse("22/07/2016"),sdf.parse("28/07/2018"),800,10.25);
		alTrades.add(objTrade);

		objTrade = new Trade("bar", "B",0.70,"SGP",sdf.parse("22/07/2016"),sdf.parse("28/07/2018"),4500,90.5);
		alTrades.add(objTrade);

		objTrade = new Trade("bar", "B",1.70,"GBP",sdf.parse("22/07/2016"),sdf.parse("29/07/2018"),600,90.5);
		alTrades.add(objTrade);
		
		objTrade = new Trade("zoo", "B",0.50,"SGP",sdf.parse("22/07/2016"),sdf.parse("30/07/2018"),5420,100.25);
		alTrades.add(objTrade);

		objTrade = new Trade("hoo", "S",0.50,"SGP",sdf.parse("22/07/2016"),sdf.parse("27/07/2018"),654,100.15);
		alTrades.add(objTrade);

		objTrade = new Trade("hoo", "S",0.22,"AED",sdf.parse("22/07/2016"),sdf.parse("29/07/2018"),599,101.5);
		alTrades.add(objTrade);

		objTrade = new Trade("moo", "B",0.22,"AED",sdf.parse("22/07/2016"),sdf.parse("28/07/2018"),9879,150.5);
		alTrades.add(objTrade);

		objTrade = new Trade("boo", "S",0.22,"SAR",sdf.parse("22/07/2016"),sdf.parse("27/07/2018"),8798,140.5);
		alTrades.add(objTrade);

		objTrade = new Trade("foo", "B",0.40,"SAR",sdf.parse("22/07/2016"),sdf.parse("29/07/2018"),3978,10.25);
		alTrades.add(objTrade);

		objTrade = new Trade("bar", "B",0.70,"SGP",sdf.parse("22/07/2016"),sdf.parse("28/07/2018"),654,90.5);
		alTrades.add(objTrade);

		objTrade = new Trade("noo", "B",1.70,"GBP",sdf.parse("22/07/2016"),sdf.parse("30/07/2018"),789,90.5);
		alTrades.add(objTrade);

		objTrade = new Trade("zoo", "B",0.50,"SGP",sdf.parse("22/07/2016"),sdf.parse("29/07/2018"),6578,100.25);
		alTrades.add(objTrade);
		
		return alTrades;

	}//End of getTradeDetails method
}//End of TradeSalesSimulator class
