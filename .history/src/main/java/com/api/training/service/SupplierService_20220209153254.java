package com.api.training.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.training.Dto.SupplierDto;

@Service
public interface SupplierService {
	
	public List<SupplierDto> findAll();
	
	public SupplierDto findById(long theID);
	
	public SupplierDto save(SupplierDto theSupplier);
	
	public void deleteById(long theId);
	
	public SupplierDto updateSupplier(SupplierDto supplierDto);

}
