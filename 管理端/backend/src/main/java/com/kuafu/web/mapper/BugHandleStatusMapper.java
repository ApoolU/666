package com.kuafu.web.mapper;

import java.util.List;
import com.kuafu.web.entity.BugHandleStatus;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p> BUG处理状态表 Mapper </p>
 *
 * @author kuafuai
 * @description
 * @date 2024/09/23 11:10
 */
@Mapper
public interface BugHandleStatusMapper extends BaseMapper<BugHandleStatus> {

}
