package com.azizfurkan.finpilotai.dto.request;

import com.azizfurkan.finpilotai.enums.PaymentMethod;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PaymentRequest(
        @NotNull @Positive BigDecimal amount,
        @NotNull LocalDate paymentDate,
        @NotNull PaymentMethod paymentMethod,
        @NotNull Long invoiceId
) {
}
