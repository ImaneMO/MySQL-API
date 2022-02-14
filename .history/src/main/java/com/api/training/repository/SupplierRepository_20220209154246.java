package com.api.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.training.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
