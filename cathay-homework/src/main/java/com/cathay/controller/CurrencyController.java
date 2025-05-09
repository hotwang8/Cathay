package com.cathay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cathay.db.model.Currency;
import com.cathay.service.CurrencyService;

@RestController
@RequestMapping("/api/currencies")
public class CurrencyController {

	@Autowired
	private CurrencyService currencyService;

	@GetMapping("/findAll")
	public List<Currency> getAllCurrencieList() {
		return currencyService.findAll();
	}

	@PostMapping("/create")
	public String createCurrency(@RequestBody Currency currency) {
		return currencyService.create(currency);
	}

	@PutMapping("/update/{code}")
	public String updateCurrency(@PathVariable String code, @RequestBody Currency currency) {
		return currencyService.update(code, currency);
	}

	@DeleteMapping("/delete/{code}")
	public void deleteCurrency(@PathVariable String code) {
		currencyService.delete(code.toUpperCase());
	}
}