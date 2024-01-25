package com.samsung.restdemo.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

// Ctrl + 1 on object class

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.samsung.restdemo.model.CloudVendor;
import com.samsung.restdemo.repository.CloudVendorRepository;
import com.samsung.restdemo.service.CloudVendorService;

class CloudVendorServiceImplTest {

	@Mock
	private CloudVendorRepository cloudVendorRepository;
	private CloudVendorService cloudVendorService;
	
	AutoCloseable autoCloseable;
	CloudVendor cloudVendor;
	
	
	@BeforeEach
	void setUp() throws Exception {
		autoCloseable = MockitoAnnotations.openMocks(this);
		cloudVendorService = new CloudVendorServiceImpl(cloudVendorRepository);
		cloudVendor = new CloudVendor("1","Amazon","USA","xxxxxx");
	}

	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}

//	@Test
//	void testCloudVendorServiceImpl() {
//		fail("Not yet implemented");
//	}

	@Test
	void testCreateCloudVendor() {
//		fail("Not yet implemented");
		mock(CloudVendor.class);
		mock(CloudVendorRepository.class);
		
		// here i am mocking the operation which i required. 
		// because i am testing individual components
		when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
		
		assertThat(cloudVendorService.createCloudVendor(cloudVendor)).isEqualTo("Success!");
	}

	@Test
	void testUpdateCloudVendor() {
//		fail("Not yet implemented");
		mock(CloudVendor.class);
		mock(CloudVendorRepository.class);
		
		// here i am mocking the operation which i required. 
		// because i am testing individual components
		when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
		
		
		assertThat(cloudVendorService.updateCloudVendor(cloudVendor)).isEqualTo("Success!");
	
	}

	
	/*
	 * Special Case as return type is void in that case.
	 */
	@Test
	void testDeleteCloudVendor() {
//		fail("Not yet implemented");
		
		mock(CloudVendor.class);
		mock(CloudVendorRepository.class, Mockito.CALLS_REAL_METHODS);
		
		doAnswer(Answers.CALLS_REAL_METHODS).when(
				cloudVendorRepository).deleteById(any());
		assertThat(cloudVendorService.deleteCloudVendor("1")).isEqualTo("Success!");
		
		// because i am testing individual components
			
	}

	@Test
	void testGetCloudVendor() {
//		fail("Not yet implemented");
		mock(CloudVendor.class);
		mock(CloudVendorRepository.class);
		
		
		// here i am mocking the operation which i required. 
		// because i am testing individual components
		when(cloudVendorRepository.findById("1")).thenReturn(Optional.ofNullable(cloudVendor));
		
		
		assertThat(cloudVendorService.getCloudVendor("1").getVendorName()).isEqualTo(cloudVendor.getVendorName());
		  
		
	}

	
	@Test
	void testGetAllCloudVendors() {
//		fail("Not yet implemented");
		
		mock(CloudVendor.class);
		mock(CloudVendorRepository.class);
		
		
		// here i am mocking the operation which i required. 
		// because i am testing individual components
		when(cloudVendorRepository.findAll()).thenReturn(
				new ArrayList<CloudVendor>(Collections.singleton(cloudVendor))
		);
		
		assertThat(cloudVendorService.getAllCloudVendors().get(0).getVendorName()).isEqualTo(cloudVendor.getVendorName());
	}

	
	// i don't have any implementation of get Cloud vendor by Name in service class.
}
