package com.kuafu.web.vo;

import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Date;
import lombok.NoArgsConstructor;

/**
 * <p>BUG优先级表</p>
 *
 * @author kuafuai
 * @description
 * @date 2024/09/23 11:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BugPriorityStatusVO  {

     @JsonProperty(value = "priorityStatusId")
    private Integer priorityStatusId;
     @JsonProperty(value = "priorityStatusDescription")
    private String priorityStatusDescription;

}
