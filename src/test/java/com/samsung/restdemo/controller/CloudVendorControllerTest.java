package com.samsung.restdemo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.samsung.restdemo.model.CloudVendor;
import com.samsung.restdemo.service.CloudVendorService;

import ch.qos.logback.core.net.ObjectWriter;



@WebMvcTest(CloudVendorController.class)
class CloudVendorControllerTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	
	@MockBean
	private CloudVendorService cloudVendorService;
	
	CloudVendor cloudVendorOne;
	CloudVendor cloudVendorTwo;
	List<CloudVendor> cloudVendorList = new ArrayList<>();
	
	
	@BeforeEach
	void setUp() throws Exception {
		cloudVendorOne = new CloudVendor("1", "Amazon", "USA","xxxxxx");
		cloudVendorTwo = new CloudVendor("2", "GCP", "UK" , "yyyyyy");
		cloudVendorList.add(cloudVendorOne);
		cloudVendorList.add(cloudVendorTwo);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	
	@Test
	void testGetCloudVendorDetails() throws Exception {
		
		when(cloudVendorService.getCloudVendor("1")).thenReturn(cloudVendorOne);
		this.mockMvc.perform(get("/cloudvendor/1"))
				.andDo(print()).andExpect(status().isOk());
	}

	@Test
	void testGetAllCloudVendorDetails() throws Exception {
//		fail("Not yet implemented");
		when(cloudVendorService.getAllCloudVendors()).thenReturn(cloudVendorList);
		this.mockMvc.perform(get("/cloudvendor"))
				.andDo(print()).andExpect(status().isOk());
	}

	@Test
	void testCreateCloudVendorDetails() throws Exception {
//		fail("Not yet implemented");
		ObjectMapper objectMapper = new ObjectMapper();
		String requestJson = objectMapper.writeValueAsString(cloudVendorOne);
		
		
		when(cloudVendorService.createCloudVendor(cloudVendorOne))
			.thenReturn("Success!");
		this.mockMvc.perform(post("/cloudvendor")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestJson))
			.andDo(print()).andExpect(status().isOk());
	}

	@Test
	void testUpdateCloudVendorDetails() throws Exception {
//		fail("Not yet implemented");
	
		ObjectMapper objectMapper = new ObjectMapper();
		String requestJson = objectMapper.writeValueAsString(cloudVendorOne);
		
		
		when(cloudVendorService.updateCloudVendor(cloudVendorOne))
			.thenReturn("Success!");
		this.mockMvc.perform(put("/cloudvendor")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestJson))
			.andDo(print()).andExpect(status().isOk());
	}

	@Test
	void testDeleteCloudVendorDetails() throws Exception{
//		fail("Not yet implemented");
		
		when(cloudVendorService.deleteCloudVendor("1"))
			.thenReturn("Success!");
		this.mockMvc.perform(delete("/cloudvendor/1"))
			.andDo(print()).andExpect(status().isOk());
	}

}
