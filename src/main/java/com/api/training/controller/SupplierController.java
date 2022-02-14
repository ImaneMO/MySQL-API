package com.api.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.training.Dto.SupplierDto;
import com.api.training.exceptionHandler.NotFoundException;
import com.api.training.model.Supplier;
import com.api.training.service.SupplierService;

import lombok.extern.log4j.Log4j2;

@RestController
@CrossOrigin(origins = "https://localhost/8080")
@RequestMapping("/api")
@Log4j2
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	/*Read all suppliers*/
	@GetMapping("/suppliers")
	public List<SupplierDto> findAll() {
		return supplierService.findAll();
	}

	/*Read a single supplier*/
	@GetMapping("/supplier/{id}")
	public SupplierDto findById(@PathVariable long id) {
		return supplierService.findById(id);
	}

	/*Add a new collaborator*/
	@PostMapping("/suppliers")
	public ResponseEntity<SupplierDto> addSupplier(@RequestBody Supplier supplier){
		try{
		supplier.setId(0);
		SupplierDto _supplierDto = supplierService.save(supplier.convertToDto());
		return new  ResponseEntity<>(_supplierDto, HttpStatus.CREATED);
		} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*Update supplier
	@PutMapping("/supplier/{id}")
	public ResponseEntity<SupplierDto> updateSupplier(@PathVariable("id") long id, @RequestBody Supplier supplier){
		
		try {
		SupplierDto supplierData = supplierService.findById(id);
		}catch(NotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
//		log.info(supplier.toString());
		
			SupplierDto supplierDto = supplierData;
			supplierDto.setSuppliername(supplier.getSuppliername());
			
			supplierDto.setService(supplier.getService());
			supplierDto.setEmail(supplier.getEmail());

			return new ResponseEntity<>(supplierService.save(supplierDto), HttpStatus.OK);
			
	}*/

	/*Delete supplier*/
	@DeleteMapping("/supplier/{id}")
	public ResponseEntity<HttpStatus> deleteSupplier(@PathVariable("id") long id){
		try {
		supplierService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}




}
