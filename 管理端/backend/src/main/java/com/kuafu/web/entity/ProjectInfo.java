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
 * <p>  项目信息表 </p>
 *
 * @author kuafuai
 * @description
 * @date 2024/09/23 11:10
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("project_info")
public class ProjectInfo  {
    @TableId(value = "project_info_id", type = IdType.AUTO)
    @JsonProperty(value = "projectInfoId")
    private Integer projectInfoId;
    @JsonProperty(value = "projectName")
    private String projectName;
    @JsonProperty(value = "projectVersion")
    private String projectVersion;
    @JsonProperty(value = "projectLeader")
    private String projectLeader;
}
