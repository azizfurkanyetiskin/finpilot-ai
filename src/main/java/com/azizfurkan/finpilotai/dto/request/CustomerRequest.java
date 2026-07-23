package com.azizfurkan.finpilotai.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
        @NotBlank String companyName,
        @NotBlank String taxNumber,
        @NotBlank String phone,
        @NotBlank @Email String email,
        String address,
        @NotNull Long companyId
) {
}
