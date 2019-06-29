package com.zfc.study.order.mq.rocketMQ.message.impl;

import com.zfc.study.order.mapper.TestMapper;
import com.zfc.study.order.mq.rocketMQ.message.MessageProcessor;
import com.zfc.study.stock.vo.TestVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zufeichao
 * @ProjectName order-service-center
 * @Description TODO
 * @Date 2019-06-28 16:08
 **/
@Slf4j
@Service
public class TestProcessorImpl implements MessageProcessor<TestVo> {

    @Autowired
    private TestMapper testMapper;

    @Override
    public boolean handleMessage(TestVo testVo) {
        log.info("testVo receive  :{}",testVo);
        testMapper.saveTest(testVo);
        return false;
    }

    @Override
    public Class<TestVo> getClazz() {
        return TestVo.class;
    }
}
