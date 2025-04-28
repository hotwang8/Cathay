package com.cathay.info;

public class CurrencyInfo {
	private String currency;
	private String currencyName;
	private Double rate;

	public CurrencyInfo(String currency, String currencyName, Double rate) {
        this.currency = currency;
        this.currencyName = currencyName;
        this.rate = rate;
    }

	public String getCurrency() {
		return currency;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public Double getRate() {
		return rate;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}
}
