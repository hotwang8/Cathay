package com.cathay.service;

import com.cathay.dto.CoindeskResponseDto;

public interface CoindeskService {
	public Object getRawData();

	public CoindeskResponseDto getTransformedData();
}
