package com.kuafu.web.vo;

import com.kuafu.common.domin.PageRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * <p>BUG表-分页列表-响应参数</p>
 *
 * @author kuafuai
 * @description
 * @date 2024/09/23 11:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BugInfoAllPageVO extends PageRequest {

    @JsonProperty(value = "bugDescription")
    private String bugDescription;
    @JsonProperty(value = "bugImage")
    private String bugImage;
    @JsonProperty(value = "userName")
    private String userName;
    @JsonProperty(value = "technicalDirectionUi1")
    private Integer technicalDirectionUi1;
    @JsonProperty(value = "projectName")
    private String projectName;
    @JsonProperty(value = "technicalDirectionUi2")
    private Integer technicalDirectionUi2;
    @JsonProperty(value = "handleStatusDescription")
    private String handleStatusDescription;
    @JsonProperty(value = "bugPriority")
    private Integer bugPriority;
    @JsonProperty(value = "technicalDirection")
    private Integer technicalDirection;
    @JsonProperty(value = "priorityStatusDescription")
    private String priorityStatusDescription;
    @JsonProperty(value = "bugSubmitter")
    private Integer bugSubmitter;
    @JsonProperty(value = "phoneNumberUi2")
    private String phoneNumberUi2;
    @JsonProperty(value = "phoneNumberUi1")
    private String phoneNumberUi1;
    @JsonProperty(value = "userNameUi1")
    private String userNameUi1;
    @JsonProperty(value = "createdTime")
    private Date createdTime;
    @JsonProperty(value = "bugTitle")
    private String bugTitle;
    @JsonProperty(value = "userNameUi2")
    private String userNameUi2;
    @JsonProperty(value = "projectLeader")
    private String projectLeader;
    @JsonProperty(value = "bugHandleStatus")
    private Integer bugHandleStatus;
    @JsonProperty(value = "bugDiscoverer")
    private Integer bugDiscoverer;
    @JsonProperty(value = "bugInfoId")
    private Integer bugInfoId;
    @JsonProperty(value = "projectInfoId")
    private Integer projectInfoId;
    @JsonProperty(value = "phoneNumber")
    private String phoneNumber;
    @JsonProperty(value = "projectVersion")
    private String projectVersion;
    @JsonProperty(value = "bugDeadline")
    private Date bugDeadline;
    @JsonProperty(value = "bugHandler")
    private Integer bugHandler;

}
