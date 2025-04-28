package com.cathay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cathay.dto.CoindeskResponseDto;
import com.cathay.service.CoindeskService;

@RestController
@RequestMapping("/api")
public class CoindeskController {
	@Autowired
	private CoindeskService coindeskService;

	@GetMapping("/getRawData")
	public Object getRawData() {
		return coindeskService.getRawData();
	}

	@GetMapping("/transformed")
	public CoindeskResponseDto getTransformedData() {
		return coindeskService.getTransformedData();
	}
}
