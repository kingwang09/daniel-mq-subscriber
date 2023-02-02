package org.daniel.mq.subscriber.hello.listener;

import lombok.extern.slf4j.Slf4j;
import org.daniel.mq.subscriber.hello.entity.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HelloQueueReceiver {

    @RabbitListener(bindings = {@QueueBinding(value = @Queue(name = "hello.queue"), exchange = @Exchange(name="world.exchange"))})
    public void wordExchangeConsume(final Message message){
        log.debug("hello queue > world.exchange receive: {}", message);
    }

    @RabbitListener(bindings = {@QueueBinding(value = @Queue(name = "hello.queue"), exchange = @Exchange(name="rabbit.exchange"))})
    public void rabbitMQExchangeConsume(final Message message){
        log.debug("hello queue > rabbit.exchange receive: {}", message);
    }
}
