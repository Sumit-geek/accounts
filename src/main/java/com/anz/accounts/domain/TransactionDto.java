package com.anz.accounts.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TransactionDto {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");

	private String accountNum;
	private String accountName;
	private String valueDate;
	private String currency;
	private double debitAmt;
	private double creditAmt;
	private String debitCredit;

	public Date getValueDateeConverted(String timezone) throws ParseException {
		dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
		return dateFormat.parse(this.valueDate);
	}

	public void setValueDate(Date date, String timezone) {
		dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
		this.valueDate = dateFormat.format(date);
	}

}
