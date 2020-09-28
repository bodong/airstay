package com.airstay.customer.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airstay.common.rest.response.ItemsPayload;
import com.airstay.common.rest.response.ResponseUtil;
import com.airstay.common.rest.response.RestResponse;
import com.airstay.customer.rest.dto.CustomerDto;
import com.airstay.customer.rest.request.CreateCustomerRequest;
import com.airstay.customer.service.CustomerService;

import lombok.NonNull;

/**
 * @author sarwo.wibowo
 *
 */
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
	
	private String apiVersion = "v1";
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<RestResponse> createData(@RequestBody @NonNull CreateCustomerRequest customer) {
		CustomerDto createdCustomer = customerService.register(customer.getFirstName(), customer.getLastName(), customer.getMobilePhone(), customer.getEmail());
		
		return ResponseUtil.okResponse(apiVersion, createdCustomer);
	}
	
	@GetMapping
	public ResponseEntity<RestResponse> getAll() {
		List<CustomerDto> datas = customerService.getAll();
		ItemsPayload<CustomerDto> payloadDatas = new ItemsPayload<CustomerDto>();
		payloadDatas.setItems(datas);
		return ResponseUtil.okResponse(apiVersion, payloadDatas);
	}
}
