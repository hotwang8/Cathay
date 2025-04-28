package com.cathay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cathay.db.model.Currency;
import com.cathay.db.repository.CurrencyRepository;
import com.cathay.service.CurrencyService;

@Service
public class CurrencyServiceImpl implements CurrencyService {
	private static final String SUCCESS = "SUCCESS";
	@Autowired
	private CurrencyRepository currencyRepository;

	@Override
	public List<Currency> findAll() {
		return currencyRepository.findAll();
	}

	@Override
	public String create(Currency currency) {
		currencyRepository.save(currency);
		return SUCCESS;
	}

	@Override
	public String update(String code, Currency currency) {
		currency.setCode(code);
		currencyRepository.save(currency);
		return SUCCESS;
	}

	@Override
	public String delete(String code) {
		currencyRepository.deleteById(code.toUpperCase());
		return SUCCESS;
	}

}
