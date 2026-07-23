package com.azizfurkan.finpilotai.dto.request;

import com.azizfurkan.finpilotai.enums.InvoiceStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public record InvoiceRequest(
        @NotBlank String invoiceNumber,
        @NotNull LocalDate invoiceDate,
        @NotNull LocalDate dueDate,
        @NotNull @Positive BigDecimal totalAmount,
        @NotNull InvoiceStatus status,
        @NotNull Long customerId
) {
}
