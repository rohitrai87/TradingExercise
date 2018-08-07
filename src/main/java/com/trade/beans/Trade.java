/**
 *
 * File Name             :Trade.java
 *
 * Package Name          :com.trade.beans
 *
 * Class Name            :Trade.java
 *
 * Class Type            :Public
 *
 * Description           :This is the Trade Java Bean class
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

package com.trade.beans;

import java.util.Date;

/**
 * This class is to represent Trades
 */
public class Trade {
	public Trade(String strEntity, String strFlag, double fFxRate, String strCurr, Date instrDate, Date origStlmntDate, long lUnits, double fPrcPerUnit) {
		this.strEntity = strEntity;
		this.strFlag = strFlag;
		this.dFxRate = fFxRate;
		this.strCurr = strCurr;
		this.instrDate = instrDate;
		this.origStlmntDate = origStlmntDate;
		this.lUnits = lUnits;
		this.dPrcPerUnit = fPrcPerUnit;
	}
	
	private String strEntity;
	private String strFlag;
	private String strCurr;
	private Date instrDate;
	private Date origStlmntDate;
	private Date revStlmntDate;
	private long lUnits;
	private double dFxRate;
	private double dPrcPerUnit;
	private double dTrdAmnt;
	
	public String getStrEntity() {
		return strEntity;
	}
	
	public String getStrFlag() {
		return strFlag;
	}
	
	public double getFxRate() {
		return dFxRate;
	}
	
	public String getStrCurr() {
		return strCurr;
	}
	
	public Date getInstrDate() {
		return instrDate;
	}
	
	public void setRevStlmntDate(Date revStlmntDate) {
		this.revStlmntDate = revStlmntDate;
	}
	
	public Date getRevStlmntDate() {
		return revStlmntDate;
	}
	
	public Date getOrigStlmntDate() {
		return origStlmntDate;
	}
	
	public long getUnits() {
		return lUnits;
	}
	
	public double getPricePerUnit() {
		return dPrcPerUnit;
	}
	
	public void setTrdAmount(double dAmnt) {
		this.dTrdAmnt = dAmnt;
	}
	
	public double getTrdAmount() {
		return dTrdAmnt;
	}
    
}//End of Trade class
