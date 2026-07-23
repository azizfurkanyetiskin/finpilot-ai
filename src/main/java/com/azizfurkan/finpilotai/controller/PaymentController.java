package com.azizfurkan.finpilotai.controller;

import com.azizfurkan.finpilotai.dto.request.PaymentRequest;
import com.azizfurkan.finpilotai.entity.Payment;
import com.azizfurkan.finpilotai.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping
    public List<Payment> findAll() {
        return paymentService.findAll();
    }

    @GetMapping("/{id}")
    public Payment findById(@PathVariable Long id) {
        return paymentService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Payment create(
            @Valid @RequestBody PaymentRequest request
    ) {
        return paymentService.create(request);
    }

    @PutMapping("/{id}")
    public Payment update(
            @PathVariable Long id,
            @Valid @RequestBody PaymentRequest request
    ) {
        return paymentService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        paymentService.delete(id);
    }
}
