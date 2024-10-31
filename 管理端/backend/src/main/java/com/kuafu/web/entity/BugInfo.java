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
 * <p>  BUG表 </p>
 *
 * @author kuafuai
 * @description
 * @date 2024/09/23 11:10
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("bug_info")
public class BugInfo  {
    @TableId(value = "bug_info_id", type = IdType.AUTO)
    @JsonProperty(value = "bugInfoId")
    private Integer bugInfoId;
    @JsonProperty(value = "bugDiscoverer")
    private Integer bugDiscoverer;
    @JsonProperty(value = "bugSubmitter")
    private Integer bugSubmitter;
    @JsonProperty(value = "bugHandler")
    private Integer bugHandler;
    @JsonProperty(value = "bugTitle")
    private String bugTitle;
    @JsonProperty(value = "bugDescription")
    private String bugDescription;
    @JsonProperty(value = "bugImage")
    private String bugImage;
    @JsonProperty(value = "projectInfoId")
    private Integer projectInfoId;
    @JsonProperty(value = "bugDeadline")
    private Date bugDeadline;
    @JsonProperty(value = "bugPriority")
    private Integer bugPriority;
    @JsonProperty(value = "bugHandleStatus")
    private Integer bugHandleStatus;
    @JsonProperty(value = "createdTime")
    private Date createdTime;
}
