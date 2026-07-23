package com.azizfurkan.finpilotai.service;

import com.azizfurkan.finpilotai.dto.request.CompanyRequest;
import com.azizfurkan.finpilotai.entity.Company;
import com.azizfurkan.finpilotai.exception.ResourceNotFoundException;
import com.azizfurkan.finpilotai.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company findById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Company not found with id: " + id
                        )
                );
    }

    public Company create(CompanyRequest request) {
        Company company = new Company();
        applyRequest(company, request);
        return companyRepository.save(company);
    }

    public Company update(Long id, CompanyRequest request) {
        Company company = findById(id);
        applyRequest(company, request);
        return companyRepository.save(company);
    }

    public void delete(Long id) {
        Company company = findById(id);
        companyRepository.delete(company);
    }

    private void applyRequest(
            Company company,
            CompanyRequest request
    ) {
        company.setName(request.name());
        company.setTaxNumber(request.taxNumber());
        company.setPhone(request.phone());
        company.setEmail(request.email());
        company.setAddress(request.address());
    }
}
