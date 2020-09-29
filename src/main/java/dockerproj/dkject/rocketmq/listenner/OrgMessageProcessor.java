package dockerproj.dkject.rocketmq.listenner;

import org.apache.rocketmq.common.message.MessageExt;

/**
 * @author makaiyu
 * @date 2019/7/20 10:47
 */
public interface OrgMessageProcessor {
    /**
     * 处理消息的接口
     *
     * @param messageExt
     * @return
     */
    boolean handleMessage(MessageExt messageExt);

    /**
     * @param messageExt
     * @return boolean
     * @author makaiyu
     * @description 处理订阅消息
     * @date 15:00 2019/7/27
     **/
    boolean handleCSMessage(MessageExt messageExt);
}