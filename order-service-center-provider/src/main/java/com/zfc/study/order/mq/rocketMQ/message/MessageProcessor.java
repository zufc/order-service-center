package com.zfc.study.order.mq.rocketMQ.message;

import com.zfc.study.order.util.JsonUtil;

/**
 * @Author zufeichao
 * @Description
 * @Date 11:15 2019/6/12
 **/
public interface MessageProcessor<T> {

    boolean handleMessage(T message);

   Class<T> getClazz();

   default T transferMessage(String message){
       return JsonUtil.fromJson(message,getClazz());
   }

}
