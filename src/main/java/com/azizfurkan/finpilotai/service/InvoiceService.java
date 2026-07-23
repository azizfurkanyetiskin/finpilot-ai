package com.azizfurkan.finpilotai.service;

import com.azizfurkan.finpilotai.dto.request.InvoiceRequest;
import com.azizfurkan.finpilotai.entity.Customer;
import com.azizfurkan.finpilotai.entity.Invoice;
import com.azizfurkan.finpilotai.exception.ResourceNotFoundException;
import com.azizfurkan.finpilotai.repository.CustomerRepository;
import com.azizfurkan.finpilotai.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final CustomerRepository customerRepository;

    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    public Invoice findById(Long id) {
        return invoiceRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Invoice not found with id: " + id
                        )
                );
    }

    public Invoice create(InvoiceRequest request) {
        Invoice invoice = new Invoice();
        applyRequest(invoice, request);
        return invoiceRepository.save(invoice);
    }

    public Invoice update(Long id, InvoiceRequest request) {
        Invoice invoice = findById(id);
        applyRequest(invoice, request);
        return invoiceRepository.save(invoice);
    }

    public void delete(Long id) {
        Invoice invoice = findById(id);
        invoiceRepository.delete(invoice);
    }

    private void applyRequest(
            Invoice invoice,
            InvoiceRequest request
    ) {
        Customer customer = customerRepository
                .findById(request.customerId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Customer not found with id: " +
                                        request.customerId()
                        )
                );

        invoice.setInvoiceNumber(request.invoiceNumber());
        invoice.setInvoiceDate(request.invoiceDate());
        invoice.setDueDate(request.dueDate());
        invoice.setTotalAmount(request.totalAmount());
        invoice.setStatus(request.status());
        invoice.setCustomer(customer);
    }
}
