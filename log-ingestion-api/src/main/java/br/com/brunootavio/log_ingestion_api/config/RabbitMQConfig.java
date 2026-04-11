package br.com.brunootavio.log_ingestion_api.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    public static final String LOG_QUEUE = "log-processing"; //constante global, nao objeto (unico na memória, valor fixo que todos usam)

    @Bean //criar fila automatica, e gerencia
    public Queue logQueue() { //classe que representa fila
        return new Queue(LOG_QUEUE, true); //nome da fila e fila persistente, mesmo que reiniciar o rabbitmq, continua existindo
    }

    @Bean
    public MessageConverter jsonMessageConverter() { //serializar como json
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) { //declara a fila
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) { //envia mensagem
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }
}
