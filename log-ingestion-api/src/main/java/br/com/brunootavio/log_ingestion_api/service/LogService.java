package br.com.brunootavio.log_ingestion_api.service;

import br.com.brunootavio.log_ingestion_api.dto.LogRequestDTO;
import br.com.brunootavio.log_ingestion_api.producer.LogProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor //construtores final
public class LogService {

    private final LogProducer logProducer;

    public void processLog(LogRequestDTO logRequest) {
        log.info("Log received | service: {} | level: {} | message: {}",
                logRequest.service(),
                logRequest.level(),
                logRequest.message());

        logProducer.sendLog(logRequest);
    }
}
