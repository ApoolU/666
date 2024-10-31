package com.kuafu.web.vo;

import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Date;
import lombok.NoArgsConstructor;

/**
 * <p>BUG表</p>
 *
 * @author kuafuai
 * @description
 * @date 2024/09/23 11:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BugInfoVO  {

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
