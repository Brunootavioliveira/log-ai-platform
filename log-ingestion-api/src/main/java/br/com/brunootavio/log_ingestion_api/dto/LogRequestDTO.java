package br.com.brunootavio.log_ingestion_api.dto;

import jakarta.validation.constraints.NotBlank;

public record LogRequestDTO(
        @NotBlank
        String service,

        @NotBlank
        String level,

        @NotBlank
        String message) {
}
