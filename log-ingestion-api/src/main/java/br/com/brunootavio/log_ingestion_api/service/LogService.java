package br.com.brunootavio.log_ingestion_api.service;

import br.com.brunootavio.log_ingestion_api.dto.LogRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LogService {

    public void processLog(LogRequestDTO logRequest) {
        log.info("Log received | service: {} | level: {} | message: {}",
                logRequest.service(),
                logRequest.level(),
                logRequest.message());
    }
}
