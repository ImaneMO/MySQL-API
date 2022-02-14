/**
 *
 */
package com.api.training.model;

import javax.persistence.*;

import com.api.training.Dto.SupplierDto;

/**
 * @author Imane
 *
 */
@Entity
@Table(name = "supplier")
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id = 0;
	@Column(name = "supplierName")
	private String supplierName;
	@Column(name = "service")
	private String service;
	@Column(name = "email")
	private String email;

	public Supplier() {}

	public Supplier(long id, String supplierName, String service, String email) {
		super();
		this.id = id;
		this.supplierName = supplierName;
		this.service = service;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Supplier [id=" + id + ", supplierName=" + supplierName + ", service=" + service + ", email=" + email
				+ "]";
	}

	public SupplierDto convertToDto() {
		return new SupplierDto(id, supplierName, service, email);
	}

	public Supplier updateFromDto(SupplierDto supplierDto) {
		this.setId(supplierDto.getId());
		this.setSupplierName(supplierDto.getSupplierName());
		this.setService(supplierDto.getService());
		this.setEmail(supplierDto.getEmail());

		return this;
	}


}
