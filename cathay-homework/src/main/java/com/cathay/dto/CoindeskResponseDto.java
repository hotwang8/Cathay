package com.cathay.dto;

import java.util.List;

import com.cathay.info.CurrencyInfo;

public class CoindeskResponseDto {
	private String updatedTime;
	private List<CurrencyInfo> currencieList;

	public String getUpdatedTime() {
		return updatedTime;
	}

	public List<CurrencyInfo> getCurrencieList() {
		return currencieList;
	}

	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}

	public void setCurrencieList(List<CurrencyInfo> currencieList) {
		this.currencieList = currencieList;
	}
}
