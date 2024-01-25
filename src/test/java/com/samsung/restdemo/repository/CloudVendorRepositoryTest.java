package com.samsung.restdemo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.samsung.restdemo.model.CloudVendor;

@DataJpaTest // Will signifies that this test will use in memory database.
public class CloudVendorRepositoryTest {
	
	
	
	/*
	Keep the following in mind
	==========================
	methodOne(input){
		stat1;
		stat2;
		
		
		.....
		
		output
	}
	
	provided / given -> when there is execution -> then ans/output 
	given 

	*/
	
	
	@Autowired
	private CloudVendorRepository cloudVendorRepository;
	CloudVendor cloudVendor;
	
	@BeforeEach
	void setUp() {
		cloudVendor = new CloudVendor("1","Amazon" ,"USA","XXXXXX");
		cloudVendorRepository.save(cloudVendor);
	}
	
	@AfterEach
	void tearDown() { 
		cloudVendor = null;
		cloudVendorRepository.deleteAll();
	}
	
	
	// Test case SUCCESS
	
	@Test
	void testFindByVendorName_Found()
	{
		List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("Amazon");
		assertThat(cloudVendorList.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
		assertThat(cloudVendorList.get(0).getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());
	}
	
	
	
	// Test case FAILURE
	@Test
	void testFindByVendorName_NotFound() {
		List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("GCP");
		assertThat(cloudVendorList.isEmpty()).isTrue();
	}
	
}


