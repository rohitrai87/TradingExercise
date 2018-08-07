/**
 *
 * File Name             :ReportGenerator.java
 *
 * Package Name          :com.trade.service
 *
 * Class Name            :ReportGenerator.java
 *
 * Class Type            :Public
 *
 * Description           :This is the Report Generator Interface
 * 
 * Super Class           :None
 *
 * Interfaces Implemented:None
 *
 * Author Name           :Rohit.Rai
 *
 * Date                  :06-Aug-2018
 *
 * Revision History      :1.0.0.0
 *                        Author Name  Date        Change Description  Version	 	
 *
 */

package com.trade.service;

import java.util.Map;

public interface ReportGenerator {
    public abstract void generateTradeSalesReport(String strReportDate, Map<String, Map<String, Double>> hmMap);
}
