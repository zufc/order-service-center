package com.zfc.study.order.mq.rocketMQ.message.impl;

import com.zfc.study.order.domain.entity.SaleOrder;
import com.zfc.study.order.mq.rocketMQ.message.MessageProcessor;
import com.zfc.study.order.service.SaleOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zufeichao
 * @ProjectName springboot-mysql-mybatisplus
 * @Description TODO
 * @Date 2019-06-12 14:48
 **/
@Service
@Slf4j
public class SaleOrderProcessorImpl implements MessageProcessor<SaleOrder> {

    @Autowired
    private SaleOrderService saleOrderService;

    @Override
    public boolean handleMessage(SaleOrder saleOrder) {
        log.info("saleOrder receive : {}",saleOrder);
        //int result = userService.insert(user);
        saleOrderService.save(saleOrder);
        return true;
    }


    @Override
    public Class<SaleOrder> getClazz() {
        return SaleOrder.class;
    }

}
