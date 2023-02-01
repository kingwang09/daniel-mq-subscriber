package org.daniel.mq.subscriber.hello.listener;

import lombok.extern.slf4j.Slf4j;
import org.daniel.mq.subscriber.hello.entity.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HelloQueueReceiver {

    @RabbitListener(queues="hello.queue")
    public void consume(final Message message){
        log.debug("hello queue receive: {}", message);
    }
}
