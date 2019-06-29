package com.zfc.study.order.mq.rocketMQ.message.impl;


import com.zfc.study.order.mq.rocketMQ.message.MessageProcessor;
import org.apache.poi.ss.formula.functions.T;

/**
 * @Author zufeichao
 * @ProjectName springboot-mysql-mybatisplus
 * @Description TODO
 * @Date 2019-06-12 11:58
 **/
public class MessageProcessorImpl implements MessageProcessor<T> {
    @Override
    public boolean handleMessage(T message) {
        return false;
    }

    @Override
    public Class getClazz() {
        return null;
    }


}
