package com.azizfurkan.finpilotai.service;

import com.azizfurkan.finpilotai.dto.request.PaymentRequest;
import com.azizfurkan.finpilotai.entity.Invoice;
import com.azizfurkan.finpilotai.entity.Payment;
import com.azizfurkan.finpilotai.exception.ResourceNotFoundException;
import com.azizfurkan.finpilotai.repository.InvoiceRepository;
import com.azizfurkan.finpilotai.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final InvoiceRepository invoiceRepository;

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public Payment findById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Payment not found with id: " + id
                        )
                );
    }

    public Payment create(PaymentRequest request) {
        Payment payment = new Payment();
        applyRequest(payment, request);
        return paymentRepository.save(payment);
    }

    public Payment update(Long id, PaymentRequest request) {
        Payment payment = findById(id);
        applyRequest(payment, request);
        return paymentRepository.save(payment);
    }

    public void delete(Long id) {
        Payment payment = findById(id);
        paymentRepository.delete(payment);
    }

    private void applyRequest(
            Payment payment,
            PaymentRequest request
    ) {
        Invoice invoice = invoiceRepository
                .findById(request.invoiceId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Invoice not found with id: " +
                                        request.invoiceId()
                        )
                );

        payment.setAmount(request.amount());
        payment.setPaymentDate(request.paymentDate());
        payment.setPaymentMethod(request.paymentMethod());
        payment.setInvoice(invoice);
    }
}
