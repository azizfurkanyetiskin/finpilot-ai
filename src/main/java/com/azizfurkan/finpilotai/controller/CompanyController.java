package com.azizfurkan.finpilotai.controller;

import com.azizfurkan.finpilotai.dto.request.CompanyRequest;
import com.azizfurkan.finpilotai.entity.Company;
import com.azizfurkan.finpilotai.service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public List<Company> findAll() {
        return companyService.findAll();
    }

    @GetMapping("/{id}")
    public Company findById(@PathVariable Long id) {
        return companyService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company create(
            @Valid @RequestBody CompanyRequest request
    ) {
        return companyService.create(request);
    }

    @PutMapping("/{id}")
    public Company update(
            @PathVariable Long id,
            @Valid @RequestBody CompanyRequest request
    ) {
        return companyService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        companyService.delete(id);
    }
}
