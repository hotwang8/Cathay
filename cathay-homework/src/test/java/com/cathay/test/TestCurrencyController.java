package com.cathay.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.cathay.db.model.Currency;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class TestCurrencyController {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testCreateCurrency() throws Exception {
		Currency currency = new Currency();
		currency.setCode("AUD");
		currency.setName("澳幣");
		String url = "/api/currencies/create";
		mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(currency))).andExpect(status().isOk());
	}

	@Test
	public void testUpdateCurrency() throws Exception {
		Currency currency = new Currency();
		currency.setName("美金");
		String url = "/api/currencies/update/USD";
		String result = mockMvc.perform(put(url).contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(currency))).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		System.out.println(result);
	}

	@Test
	public void testDeleteCurrency() throws Exception {
		Currency currency = new Currency();
		currency.setCode("USD");
		String url = "/api/currencies/delete/USD";
		String result = mockMvc.perform(delete(url).contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(currency))).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		System.out.println(result);
	}

	@Test
	public void testFindAllCurrency() throws Exception {
		String url = "/api/currencies/findAll";
		String result = mockMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		System.out.println(result);
	}
}
