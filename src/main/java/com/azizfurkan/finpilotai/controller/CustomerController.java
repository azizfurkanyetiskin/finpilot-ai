package com.azizfurkan.finpilotai.controller;

import com.azizfurkan.finpilotai.dto.request.CustomerRequest;
import com.azizfurkan.finpilotai.entity.Customer;
import com.azizfurkan.finpilotai.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer create(
            @Valid @RequestBody CustomerRequest request
    ) {
        return customerService.create(request);
    }

    @PutMapping("/{id}")
    public Customer update(
            @PathVariable Long id,
            @Valid @RequestBody CustomerRequest request
    ) {
        return customerService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        customerService.delete(id);
    }
}
