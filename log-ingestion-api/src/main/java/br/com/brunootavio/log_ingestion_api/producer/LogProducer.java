package br.com.brunootavio.log_ingestion_api.producer;

import br.com.brunootavio.log_ingestion_api.config.RabbitMQConfig;
import br.com.brunootavio.log_ingestion_api.dto.LogRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@RequiredArgsConstructor
public class LogProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendLog(LogRequestDTO logRequest) {

        rabbitTemplate.convertAndSend(RabbitMQConfig.LOG_QUEUE, logRequest);
    }
}
