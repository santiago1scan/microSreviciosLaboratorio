package co.edu.unicauca.infoii.correo.consumidor;

import org.springframework.stereotype.Service;

import co.edu.unicauca.infoii.correo.DTOs.ArticleDTO;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Service
public class MessageConsumer {

    @RabbitListener(queues = "temaCorreo")
    public void receiveMessage(ArticleDTO objClienteCreado) {
        System.out.println("Datos del cliente recibidos");
        System.out.println("Enviando correo electrónico");
        System.out.println("Id: "+objClienteCreado.getId());
        System.out.println("Nombre: "+objClienteCreado.getNombre());
        System.out.println("Autores: "+objClienteCreado.getAutores());
        System.out.println("Cantidad Autores: "+objClienteCreado.getCantidadAutores());        
        System.out.println("Revista: "+objClienteCreado.getRevista());        
    }
}
    