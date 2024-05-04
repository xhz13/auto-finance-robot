package com.finance.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.finance.domain.entity.stockSearch;

@Mapper
public interface stockSearchMapper extends BaseMapper<stockSearch> {
    
}