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
 * Date                  :08-Aug-2018
 *
 * Revision History      :1.0.0.0
 *                        Author Name  Date        Change Description  Version	 	
 *
 */

package com.trade.executor;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import com.trade.DAO.TradeDAO;
import com.trade.service.ReportGenerator;
import com.trade.service.TradeMapping;
import com.trade.service.impl.ReportGeneratorImpl;
import com.trade.service.impl.TradeMappingImpl;
import com.trade.constants.TradeConstants;

public class TradeReportingMainApp {
	public static void main(String[] args) {
		try {
			TradeMapping objTrdProc = new TradeMappingImpl();
			ReportGenerator objRepGen = new ReportGeneratorImpl();
			Map<String, Map<String, BigDecimal>> hmMap;
			TradeDAO objTrdDAO = new TradeDAO();
			hmMap = objTrdProc.getTradeMap(objTrdDAO.getTrades());
			//Read Reporting Date from the console
			System.out.print("Enter a date for reporting in dd/MM/yyyy format: ");
			Scanner scanner = new Scanner(System.in);
			Date repDate = TradeConstants.sdf.parse(scanner.nextLine());
			String strReportDate = TradeConstants.sdf.format(repDate);
			scanner.close();
			System.out.println("Reporting date: " + strReportDate);
			objRepGen.generateTradeSalesReport(strReportDate, hmMap);
		} catch(ParseException dateFormatExcp) {
			System.out.println("Date format should be in dd/MM/yyyy format!!!!");
			dateFormatExcp.printStackTrace();
		}//End of catch block
	}//End of main method
}//End of TradeReportingMainApp class
