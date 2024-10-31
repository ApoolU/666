package com.kuafu.web.mapper;

import java.util.List;
import com.kuafu.web.entity.TechnicalDirectionStatus;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p> 技术方向枚举表 Mapper </p>
 *
 * @author kuafuai
 * @description
 * @date 2024/09/23 11:10
 */
@Mapper
public interface TechnicalDirectionStatusMapper extends BaseMapper<TechnicalDirectionStatus> {

}
