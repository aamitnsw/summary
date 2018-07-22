package com.exchange.summary.report.model;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.univocity.parsers.annotations.FixedWidth;
import com.univocity.parsers.annotations.Format;
import com.univocity.parsers.annotations.Parsed;

public class TradeImpl {
	
	@Parsed(index = 0)
	@FixedWidth(3)
	int recordCode;

	@Parsed(index = 1)
	@FixedWidth(4)
	String clientType;

	@Parsed(index = 2)
	@FixedWidth(4)
	int clientNumber;

	@Parsed(index = 3)
	@FixedWidth(4)
	int accountNumber;

	@Parsed(index = 4)
	@FixedWidth(4)
	int subAccountNumber;

	@Parsed(index = 5)
	@FixedWidth(6)
	String oppositePartyCode;

	@Parsed(index = 6)
	@FixedWidth(2)
	String productGroupCode;

	@Parsed(index = 7)
	@FixedWidth(4)
	String exchangeCode;

	@Parsed(index = 8)
	@FixedWidth(6)
	String symbol;

	@Parsed(index = 9)
	@FixedWidth(8)
	@Format(formats = { "yyyyMMdd" }, options = "locale=en")
	Date expirationDate;

	@Parsed(index = 10)
	@FixedWidth(3)
	String currencyCode;

	@Parsed(index = 11)
	@FixedWidth(2)
	String movementCode;

	@Parsed(index = 12)
	@FixedWidth(1)
	String buySellCode;

	@Parsed(index = 13)
	@FixedWidth(1)
	String quantityLongSign;

	@Parsed(index = 14)
	@FixedWidth(10)
	long quantityLong;

	@Parsed(index = 15)
	@FixedWidth(1)
	String quantityShortSign;

	@Parsed(index = 16)
	@FixedWidth(10)
	long quantityShort;

	@Parsed(index = 17)
	@FixedWidth(12)
	double exchBrokerFeeDec;

	@Parsed(index = 18)
	@FixedWidth(1)
	String ecxhBrokerFeeDC;

	@Parsed(index = 19)
	@FixedWidth(3)
	String exchBrokerFeeCurCode;

	@Parsed(index = 20)
	@FixedWidth(12)
	double clearingFeeDec;

	@Parsed(index = 21)
	@FixedWidth(1)
	String clearingFeeDC;

	@Parsed(index = 22)
	@FixedWidth(3)
	String clearingFeeCurCode;

	@Parsed(index = 23)
	@FixedWidth(12)
	double commission;

	@Parsed(index = 24)
	@FixedWidth(1)
	String commissionDC;

	@Parsed(index = 25)
	@FixedWidth(3)
	String commissionCurCode;

	@Parsed(index = 26)
	@FixedWidth(8)
	@Format(formats = { "yyyyMMdd" }, options = "locale=en;lenient=false")
	Date transactionDate;

	@Parsed(index = 27)
	@FixedWidth(6)
	int futureReference;

	@Parsed(index = 28)
	@FixedWidth(6)
	String ticketNumber;

	@Parsed(index = 29)
	@FixedWidth(6)
	int externalNumber;

	@Parsed(index = 30)
	@FixedWidth(15)
	double transactionPrice;

	@Parsed(index = 31)
	@FixedWidth(6)
	String traderInitials;

	@Parsed(index = 32)
	@FixedWidth(7)
	String oppositeTraderId;

	@Parsed(index = 33)
	@FixedWidth(1)
	String openCloseCode;

	@Parsed(index = 34)
	@FixedWidth(127)
	String Filler;

	public TradeImpl() {
		super();
	}
	
	public TradeImpl(int recordCode, String clientType, int clientNumber, int accountNumber, int subAccountNumber,
			String oppositePartyCode, String productGroupCode, String exchangeCode, String symbol, Date expirationDate,
			String currencyCode, String movementCode, String buySellCode, String quantityLongSign, long quantityLong,
			String quantityShortSign, long quantityShort, double exchBrokerFeeDec, String ecxhBrokerFeeDC,
			String exchBrokerFeeCurCode, double clearingFeeDec, String clearingFeeDC, String clearingFeeCurCode,
			double commission, String commissionDC, String commissionCurCode, Date transactionDate, int futureReference,
			String ticketNumber, int externalNumber, double transactionPrice, String traderInitials,
			String oppositeTraderId, String openCloseCode, String filler) {
		super();
		this.recordCode = recordCode;
		this.clientType = clientType;
		this.clientNumber = clientNumber;
		this.accountNumber = accountNumber;
		this.subAccountNumber = subAccountNumber;
		this.oppositePartyCode = oppositePartyCode;
		this.productGroupCode = productGroupCode;
		this.exchangeCode = exchangeCode;
		this.symbol = symbol;
		this.expirationDate = expirationDate;
		this.currencyCode = currencyCode;
		this.movementCode = movementCode;
		this.buySellCode = buySellCode;
		this.quantityLongSign = quantityLongSign;
		this.quantityLong = quantityLong;
		this.quantityShortSign = quantityShortSign;
		this.quantityShort = quantityShort;
		this.exchBrokerFeeDec = exchBrokerFeeDec;
		this.ecxhBrokerFeeDC = ecxhBrokerFeeDC;
		this.exchBrokerFeeCurCode = exchBrokerFeeCurCode;
		this.clearingFeeDec = clearingFeeDec;
		this.clearingFeeDC = clearingFeeDC;
		this.clearingFeeCurCode = clearingFeeCurCode;
		this.commission = commission;
		this.commissionDC = commissionDC;
		this.commissionCurCode = commissionCurCode;
		this.transactionDate = transactionDate;
		this.futureReference = futureReference;
		this.ticketNumber = ticketNumber;
		this.externalNumber = externalNumber;
		this.transactionPrice = transactionPrice;
		this.traderInitials = traderInitials;
		this.oppositeTraderId = oppositeTraderId;
		this.openCloseCode = openCloseCode;
		Filler = filler;
	}



	public int getRecordCode() {
		return recordCode;
	}

	public void setRecordCode(int recordCode) {
		this.recordCode = recordCode;
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

	public String getOppositePartyCode() {
		return oppositePartyCode;
	}

	public void setOppositePartyCode(String oppositePartyCode) {
		this.oppositePartyCode = oppositePartyCode;
	}

	public String getProductGroupCode() {
		return productGroupCode;
	}

	public void setProductGroupCode(String productGroupCode) {
		this.productGroupCode = productGroupCode;
	}

	public String getExchangeCode() {
		return exchangeCode;
	}

	public void setExchangeCode(String exchangeCode) {
		this.exchangeCode = exchangeCode;
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

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getMovementCode() {
		return movementCode;
	}

	public void setMovementCode(String movementCode) {
		this.movementCode = movementCode;
	}

	public String getBuySellCode() {
		return buySellCode;
	}

	public void setBuySellCode(String buySellCode) {
		this.buySellCode = buySellCode;
	}

	public String getQuantityLongSign() {
		return quantityLongSign;
	}

	public void setQuantityLongSign(String quantityLongSign) {
		this.quantityLongSign = quantityLongSign;
	}

	public long getQuantityLong() {
		return quantityLong;
	}

	public void setQuantityLong(long quantityLong) {
		this.quantityLong = quantityLong;
	}

	public String getQuantityShortSign() {
		return quantityShortSign;
	}

	public void setQuantityShortSign(String quantityShortSign) {
		this.quantityShortSign = quantityShortSign;
	}

	public long getQuantityShort() {
		return quantityShort;
	}

	public void setQuantityShort(long quantityShort) {
		this.quantityShort = quantityShort;
	}

	public double getExchBrokerFeeDec() {
		return exchBrokerFeeDec;
	}

	public void setExchBrokerFeeDec(double exchBrokerFeeDec) {
		this.exchBrokerFeeDec = exchBrokerFeeDec;
	}

	public String getEcxhBrokerFeeDC() {
		return ecxhBrokerFeeDC;
	}

	public void setEcxhBrokerFeeDC(String ecxhBrokerFeeDC) {
		this.ecxhBrokerFeeDC = ecxhBrokerFeeDC;
	}

	public String getExchBrokerFeeCurCode() {
		return exchBrokerFeeCurCode;
	}

	public void setExchBrokerFeeCurCode(String exchBrokerFeeCurCode) {
		this.exchBrokerFeeCurCode = exchBrokerFeeCurCode;
	}

	public double getClearingFeeDec() {
		return clearingFeeDec;
	}

	public void setClearingFeeDec(double clearingFeeDec) {
		this.clearingFeeDec = clearingFeeDec;
	}

	public String getClearingFeeDC() {
		return clearingFeeDC;
	}

	public void setClearingFeeDC(String clearingFeeDC) {
		this.clearingFeeDC = clearingFeeDC;
	}

	public String getClearingFeeCurCode() {
		return clearingFeeCurCode;
	}

	public void setClearingFeeCurCode(String clearingFeeCurCode) {
		this.clearingFeeCurCode = clearingFeeCurCode;
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}

	public String getCommissionDC() {
		return commissionDC;
	}

	public void setCommissionDC(String commissionDC) {
		this.commissionDC = commissionDC;
	}

	public String getCommissionCurCode() {
		return commissionCurCode;
	}

	public void setCommissionCurCode(String commissionCurCode) {
		this.commissionCurCode = commissionCurCode;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public int getFutureReference() {
		return futureReference;
	}

	public void setFutureReference(int futureReference) {
		this.futureReference = futureReference;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public int getExternalNumber() {
		return externalNumber;
	}

	public void setExternalNumber(int externalNumber) {
		this.externalNumber = externalNumber;
	}

	public double getTransactionPrice() {
		return transactionPrice;
	}

	public void setTransactionPrice(double transactionPrice) {
		this.transactionPrice = transactionPrice;
	}

	public String getTraderInitials() {
		return traderInitials;
	}

	public void setTraderInitials(String traderInitials) {
		this.traderInitials = traderInitials;
	}

	public String getOppositeTraderId() {
		return oppositeTraderId;
	}

	public void setOppositeTraderId(String oppositeTraderId) {
		this.oppositeTraderId = oppositeTraderId;
	}

	public String getOpenCloseCode() {
		return openCloseCode;
	}

	public void setOpenCloseCode(String openCloseCode) {
		this.openCloseCode = openCloseCode;
	}

	public String getFiller() {
		return Filler;
	}

	public void setFiller(String filler) {
		Filler = filler;
	}

	@Override
	public String toString() {
		return "TradeImpl [recordCode=" + recordCode + ", clientType=" + clientType + ", clientNumber="
				+ clientNumber + ", accountNumber=" + accountNumber + ", subAccountNumber=" + subAccountNumber
				+ ", oppositePartyCode=" + oppositePartyCode + ", productGroupCode=" + productGroupCode
				+ ", exchangeCode=" + exchangeCode + ", symbol=" + symbol + ", expirationDate=" + expirationDate
				+ ", currencyCode=" + currencyCode + ", movementCode=" + movementCode + ", buySellCode=" + buySellCode
				+ ", quantityLongSign=" + quantityLongSign + ", quantityLong=" + quantityLong + ", quantityShortSign="
				+ quantityShortSign + ", quantityShort=" + quantityShort + ", exchBrokerFeeDec=" + exchBrokerFeeDec
				+ ", ecxhBrokerFeeDC=" + ecxhBrokerFeeDC + ", exchBrokerFeeCurCode=" + exchBrokerFeeCurCode
				+ ", clearingFeeDec=" + clearingFeeDec + ", clearingFeeDC=" + clearingFeeDC + ", clearingFeeCurCode="
				+ clearingFeeCurCode + ", commission=" + commission + ", commissionDC=" + commissionDC
				+ ", commissionCurCode=" + commissionCurCode + ", transactionDate=" + transactionDate
				+ ", futureReference=" + futureReference + ", ticketNumber=" + ticketNumber + ", externalNumber="
				+ externalNumber + ", transactionPrice=" + transactionPrice + ", traderInitials=" + traderInitials
				+ ", oppositeTraderId=" + oppositeTraderId + ", openCloseCode=" + openCloseCode + ", Filler=" + Filler
				+ "]"
				;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Filler == null) ? 0 : Filler.hashCode());
		result = prime * result + accountNumber;
		result = prime * result + ((buySellCode == null) ? 0 : buySellCode.hashCode());
		result = prime * result + ((clearingFeeCurCode == null) ? 0 : clearingFeeCurCode.hashCode());
		result = prime * result + ((clearingFeeDC == null) ? 0 : clearingFeeDC.hashCode());
		long temp;
		temp = Double.doubleToLongBits(clearingFeeDec);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + clientNumber;
		result = prime * result + ((clientType == null) ? 0 : clientType.hashCode());
		temp = Double.doubleToLongBits(commission);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((commissionCurCode == null) ? 0 : commissionCurCode.hashCode());
		result = prime * result + ((commissionDC == null) ? 0 : commissionDC.hashCode());
		result = prime * result + ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime * result + ((ecxhBrokerFeeDC == null) ? 0 : ecxhBrokerFeeDC.hashCode());
		result = prime * result + ((exchBrokerFeeCurCode == null) ? 0 : exchBrokerFeeCurCode.hashCode());
		temp = Double.doubleToLongBits(exchBrokerFeeDec);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((exchangeCode == null) ? 0 : exchangeCode.hashCode());
		result = prime * result + ((expirationDate == null) ? 0 : expirationDate.hashCode());
		result = prime * result + externalNumber;
		result = prime * result + futureReference;
		result = prime * result + ((movementCode == null) ? 0 : movementCode.hashCode());
		result = prime * result + ((openCloseCode == null) ? 0 : openCloseCode.hashCode());
		result = prime * result + ((oppositePartyCode == null) ? 0 : oppositePartyCode.hashCode());
		result = prime * result + ((oppositeTraderId == null) ? 0 : oppositeTraderId.hashCode());
		result = prime * result + ((productGroupCode == null) ? 0 : productGroupCode.hashCode());
		result = prime * result + (int) (quantityLong ^ (quantityLong >>> 32));
		result = prime * result + ((quantityLongSign == null) ? 0 : quantityLongSign.hashCode());
		result = prime * result + (int) (quantityShort ^ (quantityShort >>> 32));
		result = prime * result + ((quantityShortSign == null) ? 0 : quantityShortSign.hashCode());
		result = prime * result + recordCode;
		result = prime * result + subAccountNumber;
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		result = prime * result + ((ticketNumber == null) ? 0 : ticketNumber.hashCode());
		result = prime * result + ((traderInitials == null) ? 0 : traderInitials.hashCode());
		result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
		temp = Double.doubleToLongBits(transactionPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TradeImpl other = (TradeImpl) obj;
		if (Filler == null) {
			if (other.Filler != null)
				return false;
		} else if (!Filler.equals(other.Filler))
			return false;
		if (accountNumber != other.accountNumber)
			return false;
		if (buySellCode == null) {
			if (other.buySellCode != null)
				return false;
		} else if (!buySellCode.equals(other.buySellCode))
			return false;
		if (clearingFeeCurCode == null) {
			if (other.clearingFeeCurCode != null)
				return false;
		} else if (!clearingFeeCurCode.equals(other.clearingFeeCurCode))
			return false;
		if (clearingFeeDC == null) {
			if (other.clearingFeeDC != null)
				return false;
		} else if (!clearingFeeDC.equals(other.clearingFeeDC))
			return false;
		if (Double.doubleToLongBits(clearingFeeDec) != Double.doubleToLongBits(other.clearingFeeDec))
			return false;
		if (clientNumber != other.clientNumber)
			return false;
		if (clientType == null) {
			if (other.clientType != null)
				return false;
		} else if (!clientType.equals(other.clientType))
			return false;
		if (Double.doubleToLongBits(commission) != Double.doubleToLongBits(other.commission))
			return false;
		if (commissionCurCode == null) {
			if (other.commissionCurCode != null)
				return false;
		} else if (!commissionCurCode.equals(other.commissionCurCode))
			return false;
		if (commissionDC == null) {
			if (other.commissionDC != null)
				return false;
		} else if (!commissionDC.equals(other.commissionDC))
			return false;
		if (currencyCode == null) {
			if (other.currencyCode != null)
				return false;
		} else if (!currencyCode.equals(other.currencyCode))
			return false;
		if (ecxhBrokerFeeDC == null) {
			if (other.ecxhBrokerFeeDC != null)
				return false;
		} else if (!ecxhBrokerFeeDC.equals(other.ecxhBrokerFeeDC))
			return false;
		if (exchBrokerFeeCurCode == null) {
			if (other.exchBrokerFeeCurCode != null)
				return false;
		} else if (!exchBrokerFeeCurCode.equals(other.exchBrokerFeeCurCode))
			return false;
		if (Double.doubleToLongBits(exchBrokerFeeDec) != Double.doubleToLongBits(other.exchBrokerFeeDec))
			return false;
		if (exchangeCode == null) {
			if (other.exchangeCode != null)
				return false;
		} else if (!exchangeCode.equals(other.exchangeCode))
			return false;
		if (expirationDate == null) {
			if (other.expirationDate != null)
				return false;
		} else if (!expirationDate.equals(other.expirationDate))
			return false;
		if (externalNumber != other.externalNumber)
			return false;
		if (futureReference != other.futureReference)
			return false;
		if (movementCode == null) {
			if (other.movementCode != null)
				return false;
		} else if (!movementCode.equals(other.movementCode))
			return false;
		if (openCloseCode == null) {
			if (other.openCloseCode != null)
				return false;
		} else if (!openCloseCode.equals(other.openCloseCode))
			return false;
		if (oppositePartyCode == null) {
			if (other.oppositePartyCode != null)
				return false;
		} else if (!oppositePartyCode.equals(other.oppositePartyCode))
			return false;
		if (oppositeTraderId == null) {
			if (other.oppositeTraderId != null)
				return false;
		} else if (!oppositeTraderId.equals(other.oppositeTraderId))
			return false;
		if (productGroupCode == null) {
			if (other.productGroupCode != null)
				return false;
		} else if (!productGroupCode.equals(other.productGroupCode))
			return false;
		if (quantityLong != other.quantityLong)
			return false;
		if (quantityLongSign == null) {
			if (other.quantityLongSign != null)
				return false;
		} else if (!quantityLongSign.equals(other.quantityLongSign))
			return false;
		if (quantityShort != other.quantityShort)
			return false;
		if (quantityShortSign == null) {
			if (other.quantityShortSign != null)
				return false;
		} else if (!quantityShortSign.equals(other.quantityShortSign))
			return false;
		if (recordCode != other.recordCode)
			return false;
		if (subAccountNumber != other.subAccountNumber)
			return false;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		if (ticketNumber == null) {
			if (other.ticketNumber != null)
				return false;
		} else if (!ticketNumber.equals(other.ticketNumber))
			return false;
		if (traderInitials == null) {
			if (other.traderInitials != null)
				return false;
		} else if (!traderInitials.equals(other.traderInitials))
			return false;
		if (transactionDate == null) {
			if (other.transactionDate != null)
				return false;
		} else if (!transactionDate.equals(other.transactionDate))
			return false;
		if (Double.doubleToLongBits(transactionPrice) != Double.doubleToLongBits(other.transactionPrice))
			return false;
		return true;
	}

}