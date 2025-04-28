package com.cathay.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class TestCoindeskController {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetRawCoindeskData() throws Exception {
		String url = "/api/getRawData";
		mockMvc.perform(get(url)).andExpect(status().isOk()).andDo(result -> {
			System.out.println(result.getResponse().getContentAsString());
		});
	}

		@Test
	    public void testGetTransformedCoindeskData() throws Exception {
	        mockMvc.perform(get("/api/transformed"))
	                .andExpect(status().isOk())
	                .andDo(result -> {
	                    System.out.println(result.getResponse().getContentAsString());
	                });
	    }
}
