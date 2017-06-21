package com.chm.SpringActivemq.controller;

/**
 * Created by caohaiming on 2017/6/5.
 */
import javax.annotation.Resource;

import com.chm.SpringActivemq.mq.producer.queue.QueueSender;
import com.chm.SpringActivemq.mq.producer.topic.TopicSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author liang
 * @description controller����
 */
@Controller
@RequestMapping("/activemq")
public class ActivemqController {

    @Resource
    QueueSender queueSender;
    @Resource
    TopicSender topicSender;

    /**
     * ������Ϣ������
     * Queue���У�����һ�������߻��յ���Ϣ����Ϣһ��������Ͳ�����ڶ�����
     * @param message
     * @return String
     */
    @ResponseBody
    @RequestMapping("queueSender")
    public String queueSender(@RequestParam("message")String message){
        String opt="";
        try {
            queueSender.send("test.queue", message);
            opt = "suc";
        } catch (Exception e) {
            opt = e.getCause().toString();
        }
        return opt;
    }

    /**
     * ������Ϣ������
     * Topic���� ������һ����Ϣ�����ж����߶����յ�
     * ���������Ŀ�ĵ���һ�Զ��
     * @param message
     * @return String
     */
    @ResponseBody
    @RequestMapping("topicSender")
    public String topicSender(@RequestParam("message")String message){
        String opt = "";
        try {
            topicSender.send("test.topic", message);
            opt = "suc";
        } catch (Exception e) {
            opt = e.getCause().toString();
        }
        return opt;
    }

}
