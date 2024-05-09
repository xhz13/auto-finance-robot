package com.finance.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.finance.domain.entity.VO.InquireStockfoundation;

@Mapper
public interface InquireStockfoundationMapper extends BaseMapper<InquireStockfoundation>{
    
    @Select("SELECT * FROM stock_data_2018 WHERE stkcd = #{stkcd}")
    InquireStockfoundation findByStkcdInTable2018(String stkcd);

    @Select("SELECT * FROM stock_data_2019 WHERE stkcd = #{stkcd}")
    InquireStockfoundation findByStkcdInTable2019(String stkcd);

    @Select("SELECT * FROM stock_data_2020 WHERE stkcd = #{stkcd}")
    InquireStockfoundation findByStkcdInTable2020(String stkcd);

    @Select("SELECT * FROM stock_data_2021 WHERE stkcd = #{stkcd}")
    InquireStockfoundation findByStkcdInTable2021(String stkcd);

    @Select("SELECT * FROM stock_data_2022 WHERE stkcd = #{stkcd}")
    InquireStockfoundation findByStkcdInTable2022(String stkcd);

}
