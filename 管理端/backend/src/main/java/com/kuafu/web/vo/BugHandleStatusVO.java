package com.kuafu.web.vo;

import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Date;
import lombok.NoArgsConstructor;

/**
 * <p>BUG处理状态表</p>
 *
 * @author kuafuai
 * @description
 * @date 2024/09/23 11:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BugHandleStatusVO  {

     @JsonProperty(value = "handleStatusId")
    private Integer handleStatusId;
     @JsonProperty(value = "handleStatusDescription")
    private String handleStatusDescription;

}
