package com.azizfurkan.finpilotai.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CompanyRequest(
        @NotBlank String name,
        @NotBlank String taxNumber,
        @NotBlank String phone,
        @NotBlank @Email String email,
        String address
) {
}
