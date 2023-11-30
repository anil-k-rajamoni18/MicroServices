package com.reporthub.coreapis.dtos.digital;

import jakarta.validation.constraints.NotBlank;

public record DigitalOrgApiReq(
        @NotBlank
        String uuid) {
}
