package com.samsung.restdemo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samsung.restdemo.model.CloudVendor;
import com.samsung.restdemo.response.ResponseHandler;
import com.samsung.restdemo.service.CloudVendorService;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {
	
	CloudVendorService cloudVendorService;
	
	
	
	public CloudVendorController(CloudVendorService cloudVendorService) {
		super();
		this.cloudVendorService = cloudVendorService;
	}

	// Read Specific Cloud Vendor Details.
	@GetMapping("/{vendorId}")
	public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
		
		return ResponseHandler.responseBuilder("Requested Vendor Details are given here",HttpStatus.OK ,
				 						cloudVendorService.getCloudVendor(vendorId));
//		return cloudVendorService.getCloudVendor(vendorId);
	}
	
	
	// Read all Cloud Vendor
	@GetMapping
	public List<CloudVendor> getAllCloudVendorDetails() {
		return cloudVendorService.getAllCloudVendors();
	}
	
	
	@PostMapping  // direct mapping from above
	public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
		cloudVendorService.createCloudVendor(cloudVendor);
		return "Cloud Vendor Created Successfully";
	}
	
	
	@PutMapping  // direct mapping from above
	public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
		cloudVendorService.createCloudVendor(cloudVendor);
		return "Cloud Vendor Updated Successfully";
	}
	
	
	@DeleteMapping("/{vendorId}")  // direct mapping from above
	public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
		cloudVendorService.deleteCloudVendor(vendorId);
		return "Cloud Vendor deleted Successfully";
	}
}
