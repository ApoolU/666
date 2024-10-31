package com.kuafu.web.mapper;

import java.util.List;
import com.kuafu.web.entity.BugPriorityStatus;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p> BUG优先级表 Mapper </p>
 *
 * @author kuafuai
 * @description
 * @date 2024/09/23 11:10
 */
@Mapper
public interface BugPriorityStatusMapper extends BaseMapper<BugPriorityStatus> {

}
