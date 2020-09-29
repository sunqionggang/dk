package dockerproj.dkject.rocketmq.listenner;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author makaiyu
 * @date 2019/7/20 10:47
 */
@Slf4j
public class OrgMessageListener implements MessageListenerConcurrently {

    private OrgMessageProcessor orgMessageProcessor;

    public void setTagMessageProcessor(OrgMessageProcessor orgMessageProcessor) {
        this.orgMessageProcessor = orgMessageProcessor;
    }

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        log.info("接受消息-");
        for (MessageExt msg : msgs) {
            boolean result = orgMessageProcessor.handleCSMessage(msg);
            if (!result) {
                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}