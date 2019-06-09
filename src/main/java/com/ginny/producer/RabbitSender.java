package com.ginny.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Harry
 * @Description //TODO
 * @Date 2019/6/910:28
 */
@Component
//@PropertySource("classpath:gupaomq.properties")
public class RabbitSender {
//    @Value("${com.ginny.directexchange}")
//    private String directExchange;
//
//    @Value("${com.ginny.topicexchange}")
//    private String topicExchange;
//
//    @Value("${com.ginny.fanoutexchange}")
//    private String fanoutExchange;
//
//    @Value("${com.ginny.directroutingkey}")
//    private String directRoutingKey;
//
//    @Value("${com.ginny.topicroutingkey1}")
//    private String topicRoutingKey1;
//
//    @Value("${com.ginny.topicroutingkey2}")
//    private String topicRoutingKey2;


    // 自定义的模板，所有的消息都会转换成JSON发送
    @Autowired
RabbitTemplate ginnyTemplate;

    public void send() {
        ginnyTemplate.convertAndSend("DIRECT_EXCHANGE","ginny.test", "a direct msg : 中原镖局,汉中省解放路266号");
        ginnyTemplate.convertAndSend("TOPIC_EXCHANGE","shanghai.ginny.test","a topic msg : shanghai.ginny.test");
        ginnyTemplate.convertAndSend("TOPIC_EXCHANGE","changsha.ginny.test","a topic msg : changsha.ginny.test");
        // 发送JSON字符串
        //ObjectMapper mapper = new ObjectMapper();
        String json = "a fanoutExchange msg : this message is from fanout";
        ginnyTemplate.convertAndSend("FOUNT_EXCHANGE","", json);
    }

}
