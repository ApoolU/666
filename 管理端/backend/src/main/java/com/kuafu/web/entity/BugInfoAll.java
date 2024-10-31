package com.kuafu.web.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
public class BugInfoAll  {
    @TableField(value="bi.bug_description")
@JsonProperty(value = "bugDescription")
    private String bugDescription;
    @TableField(value="bi.bug_image")
@JsonProperty(value = "bugImage")
    private String bugImage;
    @TableField(value="ui.user_name")
@JsonProperty(value = "userName")
    private String userName;
    @TableField(value="technical_direction_ui1")
@JsonProperty(value = "technicalDirectionUi1")
    private Integer technicalDirectionUi1;
    @TableField(value="pi.project_name")
@JsonProperty(value = "projectName")
    private String projectName;
    @TableField(value="technical_direction_ui2")
@JsonProperty(value = "technicalDirectionUi2")
    private Integer technicalDirectionUi2;
    @TableField(value="bhs.handle_status_description")
@JsonProperty(value = "handleStatusDescription")
    private String handleStatusDescription;
    @TableField(value="bi.bug_priority")
@JsonProperty(value = "bugPriority")
    private Integer bugPriority;
    @TableField(value="ui.technical_direction")
@JsonProperty(value = "technicalDirection")
    private Integer technicalDirection;
    @TableField(value="bps.priority_status_description")
@JsonProperty(value = "priorityStatusDescription")
    private String priorityStatusDescription;
    @TableField(value="bi.bug_submitter")
@JsonProperty(value = "bugSubmitter")
    private Integer bugSubmitter;
    @TableField(value="phone_number_ui2")
@JsonProperty(value = "phoneNumberUi2")
    private String phoneNumberUi2;
    @TableField(value="phone_number_ui1")
@JsonProperty(value = "phoneNumberUi1")
    private String phoneNumberUi1;
    @TableField(value="user_name_ui1")
@JsonProperty(value = "userNameUi1")
    private String userNameUi1;
    @TableField(value="bi.created_time")
@JsonProperty(value = "createdTime")
    private Date createdTime;
    @TableField(value="bi.bug_title")
@JsonProperty(value = "bugTitle")
    private String bugTitle;
    @TableField(value="user_name_ui2")
@JsonProperty(value = "userNameUi2")
    private String userNameUi2;
    @TableField(value="pi.project_leader")
@JsonProperty(value = "projectLeader")
    private String projectLeader;
    @TableField(value="bi.bug_handle_status")
@JsonProperty(value = "bugHandleStatus")
    private Integer bugHandleStatus;
    @TableField(value="bi.bug_discoverer")
@JsonProperty(value = "bugDiscoverer")
    private Integer bugDiscoverer;
    @TableField(value="bi.bug_info_id")
@JsonProperty(value = "bugInfoId")
    private Integer bugInfoId;
    @TableField(value="bi.project_info_id")
@JsonProperty(value = "projectInfoId")
    private Integer projectInfoId;
    @TableField(value="ui.phone_number")
@JsonProperty(value = "phoneNumber")
    private String phoneNumber;
    @TableField(value="pi.project_version")
@JsonProperty(value = "projectVersion")
    private String projectVersion;
    @TableField(value="bi.bug_deadline")
@JsonProperty(value = "bugDeadline")
    private Date bugDeadline;
    @TableField(value="bi.bug_handler")
@JsonProperty(value = "bugHandler")
    private Integer bugHandler;
}
