package br.com.brunootavio.log_ingestion_api.controller;

import br.com.brunootavio.log_ingestion_api.dto.LogRequestDTO;
import br.com.brunootavio.log_ingestion_api.service.LogService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/logs")
public class LogController {

    private final LogService logService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String receiveLog(@Valid @RequestBody LogRequestDTO logRequest) {

        logService.processLog(logRequest);

        return "Log received successfully";
    }
}
