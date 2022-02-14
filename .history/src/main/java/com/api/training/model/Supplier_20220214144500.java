/**
 *
 */
package com.api.training.model;

import javax.persistence.*;

import com.api.training.Dto.SupplierDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Imane
 *
 */
@Entity
@Table(name = "supplier")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "suppliername")
	private String suppliername;
	@Column(name = "service")
	private String service;
	@Column(name = "email")
	private String email;

	

	public SupplierDto convertToDto() {
		return new SupplierDto(id, suppliername, service, email);
	}

	public Supplier updateFromDto(SupplierDto supplierDto) {
		this.setId(supplierDto.getId());
		this.setSuppliername(supplierDto.getSuppliername());
		this.setService(supplierDto.getService());
		this.setEmail(supplierDto.getEmail());

		return this;
	}
}
