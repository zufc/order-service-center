package com.zfc.study.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zfc.study.stock.vo.TestVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TestMapper extends BaseMapper<TestVo> {

    List<TestVo> queryTestList();

    int saveTest(@Param("testVo") TestVo testVo);

}
