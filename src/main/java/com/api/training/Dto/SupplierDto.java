package com.api.training.Dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.api.training.model.Supplier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class SupplierDto {
	
	//@JsonProperty(value="Id")
		@NotNull
		private long id;
		
		@NotNull(message = "Name cannot be null.")
		@Pattern(
			    regexp = "/^[a-z ,.'-]+$/i", 
			    message = "Enter a valid name."
			    ) 
		private String suppliername;
		
		private String service;
		
		@Email(message = "the email is not valid")
		private String email;

	
		
		public Supplier convertToSupplier() {
			return new Supplier(id, suppliername, service, email);
		}
		
		public SupplierDto build(Supplier supplier) {
			return new SupplierDto(supplier.getId(), supplier.getSuppliername(),
					supplier.getService(), supplier.getEmail());
		}

}
