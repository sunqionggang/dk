package dockerproj.dkject.rocketmq.config;


import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @description: 生产者
 * @author: sqg
 * @create: 2020-09-29 10:31
 */
@Component
@Slf4j
public class Producer {
    @PostConstruct
    public void producer() throws MQClientException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("sqg");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();
        log.info("生产者开始推送");
        for (int i = 0; i < 10; i++) {
            try {
                Message msg = new Message("TopicTest", // topic
                        "TagA", // tag
                        ("Hello RocketMQ " + i).getBytes()// body
                );
                SendResult sendResult = producer.send(msg);
                System.out.println(sendResult);
            }
            catch (Exception e) {
                e.printStackTrace();
                Thread.sleep(3000);
            }
        }

        producer.shutdown();
    }
}
