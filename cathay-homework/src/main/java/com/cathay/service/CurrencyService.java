package com.cathay.service;

import java.util.List;

import com.cathay.db.model.Currency;


public interface CurrencyService {
	public List<Currency> findAll();

	public String create(Currency currency);

	public String update(String code, Currency currency);

	public String delete(String code);
}
