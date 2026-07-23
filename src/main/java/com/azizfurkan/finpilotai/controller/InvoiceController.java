package com.azizfurkan.finpilotai.controller;

import com.azizfurkan.finpilotai.dto.request.InvoiceRequest;
import com.azizfurkan.finpilotai.entity.Invoice;
import com.azizfurkan.finpilotai.service.InvoiceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;

    @GetMapping
    public List<Invoice> findAll() {
        return invoiceService.findAll();
    }

    @GetMapping("/{id}")
    public Invoice findById(@PathVariable Long id) {
        return invoiceService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice create(
            @Valid @RequestBody InvoiceRequest request
    ) {
        return invoiceService.create(request);
    }

    @PutMapping("/{id}")
    public Invoice update(
            @PathVariable Long id,
            @Valid @RequestBody InvoiceRequest request
    ) {
        return invoiceService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        invoiceService.delete(id);
    }
}
