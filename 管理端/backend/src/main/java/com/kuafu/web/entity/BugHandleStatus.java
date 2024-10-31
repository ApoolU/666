package com.kuafu.web.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>  BUG处理状态表 </p>
 *
 * @author kuafuai
 * @description
 * @date 2024/09/23 11:10
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("bug_handle_status")
public class BugHandleStatus  {
    @TableId(value = "handle_status_id", type = IdType.AUTO)
    @JsonProperty(value = "handleStatusId")
    private Integer handleStatusId;
    @JsonProperty(value = "handleStatusDescription")
    private String handleStatusDescription;
}
