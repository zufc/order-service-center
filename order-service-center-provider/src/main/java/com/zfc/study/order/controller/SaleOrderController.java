package com.zfc.study.order.controller;


import com.zfc.study.order.service.SaleOrderService;
import com.zfc.study.order.util.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zfc
 * @since 2019-06-28
 */
@RestController
@RequestMapping("/saleOrder")
public class SaleOrderController {

    @Autowired
    private SaleOrderService saleOrderService;

    @GetMapping
    public JsonBean queryList(){
        List<Map<String,Object>> list = saleOrderService.listMaps();
        return new JsonBean(list);
    }

}
