package com.azizfurkan.finpilotai.service;

import com.azizfurkan.finpilotai.dto.request.CustomerRequest;
import com.azizfurkan.finpilotai.entity.Company;
import com.azizfurkan.finpilotai.entity.Customer;
import com.azizfurkan.finpilotai.exception.ResourceNotFoundException;
import com.azizfurkan.finpilotai.repository.CompanyRepository;
import com.azizfurkan.finpilotai.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CompanyRepository companyRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Customer not found with id: " + id
                        )
                );
    }

    public Customer create(CustomerRequest request) {
        Customer customer = new Customer();
        applyRequest(customer, request);
        return customerRepository.save(customer);
    }

    public Customer update(Long id, CustomerRequest request) {
        Customer customer = findById(id);
        applyRequest(customer, request);
        return customerRepository.save(customer);
    }

    public void delete(Long id) {
        Customer customer = findById(id);
        customerRepository.delete(customer);
    }

    private void applyRequest(
            Customer customer,
            CustomerRequest request
    ) {
        Company company = companyRepository.findById(request.companyId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Company not found with id: " +
                                        request.companyId()
                        )
                );

        customer.setCompanyName(request.companyName());
        customer.setTaxNumber(request.taxNumber());
        customer.setPhone(request.phone());
        customer.setEmail(request.email());
        customer.setAddress(request.address());
        customer.setCompany(company);
    }
}
