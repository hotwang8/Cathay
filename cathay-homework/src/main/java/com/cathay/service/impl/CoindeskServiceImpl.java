package com.cathay.service.impl;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cathay.db.model.Currency;
import com.cathay.db.repository.CurrencyRepository;
import com.cathay.dto.CoindeskResponseDto;
import com.cathay.info.CurrencyInfo;
import com.cathay.service.CoindeskService;

@Service
public class CoindeskServiceImpl implements CoindeskService {

	private static final String URL = "https://kengp3.github.io/blog/coindesk.json";

	private final RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private CurrencyRepository currencyRepository;

	@Override
	public Object getRawData() {
		return restTemplate.getForObject(URL, Object.class);
	}

	@Override
	public CoindeskResponseDto getTransformedData() {
		Map<String, Object> response = restTemplate.getForObject(URL, Map.class);

		Map<String, Object> time = (Map<String, Object>) response.get("time");
		String updatedISO = (String) time.get("updatedISO");

		Map<String, Object> bpi = (Map<String, Object>) response.get("bpi");

		List<CurrencyInfo> list = new ArrayList<>();
		bpi.forEach((key, value) -> {
			Map<String, Object> currencyMap = (Map<String, Object>) value;
			Currency currency = currencyRepository.findById(key).orElse(null);
			list.add(new CurrencyInfo(key, currency != null ? currency.getName() : "",
					(Double) currencyMap.get("rate_float")));
		});

		CoindeskResponseDto dto = new CoindeskResponseDto();
		OffsetDateTime offsetDateTime = OffsetDateTime.parse(updatedISO);
		String formattedTime = offsetDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
		dto.setUpdatedTime(formattedTime);
		dto.setCurrencieList(list);

		return dto;
	}

}
