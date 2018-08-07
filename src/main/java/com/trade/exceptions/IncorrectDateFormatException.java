/**
 *
 * File Name             :IncorrectDateFormatException.java
 *
 * Package Name          :com.trade.exceptions
 *
 * Class Name            :IncorrectDateFormatException.java
 *
 * Class Type            :Public
 *
 * Description           :This is an exception class for Incorrect date Format
 * 
 * Super Class           :Exception
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

package com.trade.exceptions;

public class IncorrectDateFormatException extends Exception {
    public IncorrectDateFormatException(String strMsg) {
        super(strMsg);
    }

    public IncorrectDateFormatException(String strMsg, Throwable cause) {
        super(strMsg, cause);
    }
}
