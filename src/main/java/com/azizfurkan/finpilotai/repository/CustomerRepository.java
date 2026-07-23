package com.azizfurkan.finpilotai.repository;

import com.azizfurkan.finpilotai.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
