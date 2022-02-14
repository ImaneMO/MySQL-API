package com.api.training.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.training.Dto.SupplierDto;
import com.api.training.exceptionHandler.NotFoundException;
import com.api.training.model.Supplier;
import com.api.training.repository.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService {

	private SupplierRepository supplierRepository;


	@Autowired
	public SupplierServiceImpl(SupplierRepository supplierRepository) {
			this.supplierRepository = supplierRepository;
	}

	@Override
	public List<SupplierDto> findAll() {
		List<Supplier> suppliers = supplierRepository.findAll();
		List<SupplierDto> suppliersDto = new ArrayList<>();
		for (Supplier s:suppliers) {
			suppliersDto.add(new SupplierDto(s.getId(), s.getSuppliername(), s.getService(), 
					s.getEmail()));
		}

		return suppliersDto;
	}

	@Override
	public SupplierDto findById(long theID) {
		Optional<Supplier> supplierWanted = supplierRepository.findById(theID);
		if(supplierWanted.isPresent()) {
			return new SupplierDto(supplierWanted.get().getId(), 
					supplierWanted.get().getSuppliername(), supplierWanted.get().getService(), 
					supplierWanted.get().getEmail());
		}else {
			throw new NotFoundException();
		}
	}

	@Override
	public SupplierDto save(SupplierDto theSupplier) {
		Supplier savedSupplier = supplierRepository.save(theSupplier.convertToSupplier());
		return savedSupplier.convertToDto();
	}

	@Override
	public void deleteById(long theId) {
		if(supplierRepository.existsById(theId)) {
			supplierRepository.deleteById(theId);
		}else {
			throw new NotFoundException();
		}
	}

	@Override
	public SupplierDto updateSupplier(SupplierDto supplierDto) {
		Optional<Supplier> supplier = supplierRepository.findById(supplierDto.getId());
		if(supplier.isPresent()) {
			Supplier newSupplier = supplier.get().updateFromDto(supplierDto);
			Supplier savedSupplier = supplierRepository.save(newSupplier);

			return savedSupplier.convertToDto();
		}else {
			throw new NotFoundException();
		}
	}





}
