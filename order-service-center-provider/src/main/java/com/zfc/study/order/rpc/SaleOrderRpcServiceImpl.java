package com.zfc.study.order.rpc;

import com.zfc.study.order.service.SaleOrderService;
import com.zfc.study.order.util.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author zufeichao
 * @ProjectName order-service-center
 * @Description TODO
 * @Date 2019-06-28 15:21
 **/
@RestController
@RequestMapping("/api/v1/saleOrder")
public class SaleOrderRpcServiceImpl  {

    @Autowired
    private SaleOrderService saleOrderService;

    @GetMapping("/list")
    public List<Map<String,Object>> queryList(){
        return saleOrderService.listMaps();
    }
}
