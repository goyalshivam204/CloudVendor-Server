package com.samsung.restdemo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.samsung.restdemo.exception.CloudVendorNotFoundException;
import com.samsung.restdemo.model.CloudVendor;
import com.samsung.restdemo.repository.CloudVendorRepository;
import com.samsung.restdemo.service.CloudVendorService;


@Service
public class CloudVendorServiceImpl implements CloudVendorService {

	CloudVendorRepository cloudVendorRepository;
	
	
	
	public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
		super();
		this.cloudVendorRepository = cloudVendorRepository;
	}

	@Override
	public String createCloudVendor(CloudVendor cloudVendor) {
		// TODO Auto-generated method stub
		cloudVendorRepository.save(cloudVendor);
		return "Success!";
	}

	@Override
	public String updateCloudVendor(CloudVendor cloudVendor) {
		// TODO Auto-generated method stub
		cloudVendorRepository.save(cloudVendor);
		return "Success!";
	}

	@Override
	public String deleteCloudVendor(String cloudVendorId) {
		// TODO Auto-generated method stub
		cloudVendorRepository.deleteById(cloudVendorId);
		return "Success!";
	}

	@Override
	public CloudVendor getCloudVendor(String cloudVendorId) {
		// TODO Auto-generated method stub
//		cloudVendorRepository.findById(cloudVendorId).get();
		if(cloudVendorRepository.findById(cloudVendorId).isEmpty()) {
			throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
		}
		return cloudVendorRepository.findById(cloudVendorId).get();
	}
 
	@Override
	public List<CloudVendor> getAllCloudVendors() {
		// TODO Auto-generated method stub
		return cloudVendorRepository.findAll();
	}

}
