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
 * <p>  技术方向枚举表 </p>
 *
 * @author kuafuai
 * @description
 * @date 2024/09/23 11:10
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("technical_direction_status")
public class TechnicalDirectionStatus  {
    @TableId(value = "technical_status_id", type = IdType.AUTO)
    @JsonProperty(value = "technicalStatusId")
    private Integer technicalStatusId;
    @JsonProperty(value = "technicalStatusDescription")
    private String technicalStatusDescription;
}
