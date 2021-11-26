package com.java.lcs;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class LongestCommonSubstringApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;


	@Test
	public void testPost() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		mockMvc.perform(post("/lms")).andExpect(status().isBadRequest());
	}

	@Test
	public void testlms() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		mockMvc.perform(post("/lms").contentType(MediaType.APPLICATION_JSON).content(new String(
				"{\"setOfStrings\": [ {\"value\": \"comcast\"},  {\"value\": \"comcastic\"}, {\"value\": \"broadcaster\"} ] }"))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("msg").value("Success"));
				//.andExpect(MockMvcResultMatchers.jsonPath("value").value("com"));

	}

	@Test
	public void testlmsFailure() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		mockMvc.perform(post("/lms").contentType(MediaType.APPLICATION_JSON).content(new String(
				"{\"setOfStrings\": [ {\"\": \"comcast\"},  {\"value\": \"comcastic\"}, {\"value\": \"broadcaster\"} ] }"))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
				

	}

}
