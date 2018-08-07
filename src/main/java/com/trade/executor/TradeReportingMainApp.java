/**
 *
 * File Name             :TradeReportingMainApp.java
 *
 * Package Name          :com.trade.executor
 *
 * Class Name            :TradeReportingMainApp.java
 *
 * Class Type            :Public
 *
 * Description           :This class is for executing Trade Reports
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
import java.util.Map;
import java.util.Scanner;

import com.trade.DAO.TradeDAO;
import com.trade.service.ReportGenerator;
import com.trade.service.TradeProcessor;
import com.trade.service.impl.ReportGeneratorImpl;
import com.trade.service.impl.TradeProcessorImpl;

public class TradeReportingMainApp {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public static void main(String[] args) {
		try {
			TradeProcessor objTrdProc = new TradeProcessorImpl();
			ReportGenerator objRepGen = new ReportGeneratorImpl();
			Map<String, Map<String, Double>> hmMap;
			TradeDAO objTrdDAO = new TradeDAO();
			hmMap = objTrdProc.processTrade(objTrdDAO.getTrades());
			//Read Reporting Date from the console
			System.out.print("Enter a date for reporting in dd/MM/yyyy format: ");
			Scanner scanner = new Scanner(System.in);
			String strReportDate = sdf.parse(scanner.nextLine()).toString();
			scanner.close();
			//System.out.println("Reporting date: " + strReportDate);
			objRepGen.generateTradeSalesReport(strReportDate, hmMap);
		} catch(ParseException dateFormatExcp) {
			System.out.println("Date format should be in dd/MM/yyyy format!!!!");
			dateFormatExcp.printStackTrace();
		}//End of catch block
	}//End of main method
}//End of TradeReportingMainApp class
