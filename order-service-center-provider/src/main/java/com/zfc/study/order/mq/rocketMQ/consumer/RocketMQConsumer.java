package com.zfc.study.order.mq.rocketMQ.consumer;


import com.zfc.study.order.mq.rocketMQ.message.MessageListener;
import com.zfc.study.order.mq.rocketMQ.message.impl.SaleOrderProcessorImpl;
import com.zfc.study.order.mq.rocketMQ.message.impl.TestProcessorImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author zufeichao
 * @ProjectName springboot-mysql-mybatisplus
 * @Description TODO
 * @Date 2019-06-12 11:06
 **/
@Component
@Slf4j
public class RocketMQConsumer {

    @Autowired
    private SaleOrderProcessorImpl saleOrderProcessor;
    @Autowired
    private TestProcessorImpl testProcessor;

/*    @Autowired
    private AnimalProcessorImpl animalProcessor;*/

    @Value("${rocketmq.consumer.namesrvAddr}")
    private String namesrvAddr;
    @Value("${rocketmq.consumer.groupName}")
    private String groupName;
    @Value("${rocketmq.consumer.consumeThreadMin}")
    private int consumeThreadMin;
    @Value("${rocketmq.consumer.consumeThreadMax}")
    private int consumeThreadMax;

    //主题和标签
    @Value("${rocketmq.consumer.order.topic}")
    private String orderTopic;
    @Value("${rocketmq.consumer.saleOrder.tag}")
    private String saleOrderTag;

    @Value("${rocketmq.consumer.test.topic}")
    private String testTopic;
    @Value("${rocketmq.consumer.test.tag}")
    private String testTag;


    @Bean
    public DefaultMQPushConsumer getRocketMQConsumer(){
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(groupName);
        consumer.setNamesrvAddr(namesrvAddr);
        consumer.setConsumeThreadMin(consumeThreadMin);
        consumer.setConsumeThreadMax(consumeThreadMax);
        consumer.setVipChannelEnabled(false);
        MessageListener messageListener = new MessageListener();
        //在监听类中增加两个消息处理类，当然可以增加更多，也就是往MessageListen类中的map集合放入处理类。
       // messageListener.registerHandle(saleOrderTag,saleOrderProcessor);
        messageListener.registerHandle(testTag,testProcessor);
        consumer.registerMessageListener(messageListener);

        try {
           // consumer.subscribe(orderTopic,this.saleOrderTag);
            //这里需要多加一个设置。第二个参数是tag表示只会消费topic下面标签为tag的消息，如果是* 就表示会消费tapic下面所有的消息。
            //consumer.subscribe(animalTopic,"*");
            consumer.subscribe(testTopic,"*");
            consumer.start();
            log.info("consumer is start !!! groupName:{},topic:{},namesrvAddr:{}",groupName,testTopic,namesrvAddr);
        }catch (MQClientException e){
            log.error("consumer is start error !!! groupName:{},topic:{},namesrvAddr:{},errorMsg:{}",groupName,testTopic,namesrvAddr,e);
        }
        return consumer;

    }


}
