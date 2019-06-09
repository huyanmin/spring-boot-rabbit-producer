package com.ginny.web;

import com.ginny.producer.RabbitSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Harry
 * @Description //TODO
 * @Date 2019/6/910:37
 */
@RestController
@RequestMapping("/api/rabbitController")
public class RabbitController {

    @Autowired
    private RabbitSender rabbitSender;

    @GetMapping("/sendRabbitMQ")
    public void sendRabbitMQ(){
        rabbitSender.send();
    }
}
