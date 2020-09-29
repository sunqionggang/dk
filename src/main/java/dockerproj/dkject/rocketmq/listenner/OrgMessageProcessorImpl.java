package dockerproj.dkject.rocketmq.listenner;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author makaiyu
 * @date 2019/7/20 10:47
 */
@Slf4j
@Component
public class OrgMessageProcessorImpl implements OrgMessageProcessor {

    private ObjectMapper objectMapper = new ObjectMapper();

    /*@Autowired
    private IDrdUserService drdUserService;*/

    @Override
    public boolean handleMessage(MessageExt messageExt) {
        log.info("org receive : " + messageExt.toString());
        log.info("org 消息内容：{}", new String(messageExt.getBody()));
        return true;
    }

    @Override
    public boolean handleCSMessage(MessageExt messageExt) {
        log.info("receive : " + messageExt.toString());
        log.info("消息内容：{}", new String(messageExt.getBody()));
        /*Msg msg = null;
        try {
            msg = objectMapper.readValue(messageExt.getBody(), Msg.class);
        } catch (IOException e) {
            e.printStackTrace();
            log.info("接受消息失败,{}", e.getMessage());
            return false;
        }

        // 处理订阅消息
        Object object = msg.getArgs().get(msg.getId().toString());*/
        //OauthOrganizationDTO dto = objectMapper.convertValue(object, OauthOrganizationDTO.class);
        //log.info("消息内容OauthOrganizationDTO：{}", dto);

        try {
             //.synchOrg(dto);
        }catch (Exception e){
            //e.printStackTrace();
            //log.error("机构信息同步失败，organizationDTO: {}, 异常信息：{}", dto, e);
        }


        return true;
    }
}