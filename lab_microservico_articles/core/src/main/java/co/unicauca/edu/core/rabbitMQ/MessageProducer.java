package co.unicauca.edu.core.rabbitMQ;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import co.unicauca.edu.core.fachadaServices.DTO.ArticleDTO;

@Service
public class MessageProducer {

    private final AmqpTemplate amqpTemplate;
    private final String exchange = "myExchange";
    private final String routingKey = "routingKey";

    public MessageProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sendMessage(ArticleDTO objClienteCreado) {
        amqpTemplate.convertAndSend(exchange, routingKey, objClienteCreado);
        System.out.println("Datos del cliente enviado a la cola");
    }
}
    