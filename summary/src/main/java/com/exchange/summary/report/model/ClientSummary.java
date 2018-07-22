package com.exchange.summary.report.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ClientSummary {

	String clientType;
	int clientNumber;
	int accountNumber;
	int subAccountNumber;
	String exchangeCode;
	String productGroupCode;
	String symbol;
	Date expirationDate;
	double totalTransactionAmount;
	
	
	public ClientSummary(String clientType, int clientNumber, int accountNumber, int subAccountNumber,
			String exchangeCode, String productGroupCode, String symbol, Date date,
			double totalTransactionAmount) {
		super();
		this.clientType = clientType;
		this.clientNumber = clientNumber;
		this.accountNumber = accountNumber;
		this.subAccountNumber = subAccountNumber;
		this.exchangeCode = exchangeCode;
		this.productGroupCode = productGroupCode;
		this.symbol = symbol;
		this.expirationDate = date;
		this.totalTransactionAmount = totalTransactionAmount;
	}
	
	public String getClientType() {
		return clientType;
	}


	public void setClientType(String clientType) {
		this.clientType = clientType;
	}


	public int getClientNumber() {
		return clientNumber;
	}


	public void setClientNumber(int clientNumber) {
		this.clientNumber = clientNumber;
	}


	public int getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public int getSubAccountNumber() {
		return subAccountNumber;
	}


	public void setSubAccountNumber(int subAccountNumber) {
		this.subAccountNumber = subAccountNumber;
	}


	public String getExchangeCode() {
		return exchangeCode;
	}


	public void setExchangeCode(String exchangeCode) {
		this.exchangeCode = exchangeCode;
	}


	public String getProductGroupCode() {
		return productGroupCode;
	}


	public void setProductGroupCode(String productGroupCode) {
		this.productGroupCode = productGroupCode;
	}


	public String getSymbol() {
		return symbol;
	}


	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}


	public Date getExpirationDate() {
		return expirationDate;
	}


	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}


	public double getTotalTransactionAmount() {
		return totalTransactionAmount;
	}


	public void setTotalTransactionAmount(double totalTransactionAmount) {
		this.totalTransactionAmount = totalTransactionAmount;
	}
	
	public final String getFormattedDate(Date date) {
		if(date == null){
			return null;
		}
		return new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(date);
	}


	@Override
	public String toString() {
		return "ClientSummary [clientType=" + clientType + ", clientNumber=" + clientNumber + ", accountNumber="
				+ accountNumber + ", subAccountNumber=" + subAccountNumber + ", exchangeCode=" + exchangeCode
				+ ", productGroupCode=" + productGroupCode + ", symbol=" + symbol + ", expirationDate=" + getFormattedDate(expirationDate)
				+ ", totalTransactionAmount=" + totalTransactionAmount + "]";
	}

}
