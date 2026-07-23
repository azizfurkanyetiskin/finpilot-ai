package com.azizfurkan.finpilotai.repository;

import com.azizfurkan.finpilotai.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
