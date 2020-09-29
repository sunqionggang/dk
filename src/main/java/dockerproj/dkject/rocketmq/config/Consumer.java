package dockerproj.dkject.rocketmq.config;

import dockerproj.dkject.rocketmq.listenner.OrgMessageListener;
import dockerproj.dkject.rocketmq.listenner.OrgMessageProcessor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author zdl
 * @date 2019/9/26 17:00
 */
@Component
@Slf4j
public class Consumer {

    @Autowired
    private OrgMessageProcessor orgMessageProcessor;

    @Value("${rocketmq.name-server}")
    private String namesrvAddr;

//    @Value("${spring.profiles.active}")
//    private String env;

    @Bean
    public DefaultMQPushConsumer OrgRocketMQConsumer() {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("sqg");
        consumer.setNamesrvAddr(namesrvAddr);
        consumer.setConsumeThreadMin(16);
        consumer.setConsumeThreadMax(32);
        //RECONSUME_LATER的重试次数，RocketMQ默认是16次
        consumer.setMaxReconsumeTimes(3);
        OrgMessageListener messageListener = new OrgMessageListener();
        messageListener.setTagMessageProcessor(orgMessageProcessor);
        consumer.registerMessageListener(messageListener);

        try {
            consumer.subscribe("TopicTest","*");
            consumer.start();
            log.info("生产者开始订阅");
        } catch (MQClientException e) {
            e.printStackTrace();
        }

        return consumer;
    }
}
