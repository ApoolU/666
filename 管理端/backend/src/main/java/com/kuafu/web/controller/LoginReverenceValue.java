package com.kuafu.web.controller;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public enum LoginReverenceValue {
bugPriorityStatus("bugPriorityStatus","bug_info_all.get_bug_priority_status_list"),userInfo("userInfo","project_info_all.get_user_info_list"),projectInfo("projectInfo","bug_info_all.get_project_info_list"),bugHandleStatus("bugHandleStatus","bug_info_all.get_bug_handle_status_list"),technicalDirectionStatus("technicalDirectionStatus","user_info_all.get_technical_direction_status_list"),bug_info("bug_info","bug_info.get_select_list"),user_info("user_info","user_info.get_select_list"),technical_direction_status("technical_direction_status","technical_direction_status.get_select_list"),bug_handle_status("bug_handle_status","bug_handle_status.get_select_list"),bug_priority_status("bug_priority_status","bug_priority_status.get_select_list"),project_info("project_info","project_info.get_select_list"),;
    private String label;
    private String value;


    LoginReverenceValue(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public static String getValue(String label) {
        for (LoginReverenceValue item : values()) {
            if (StringUtils.equalsIgnoreCase(item.getLabel(), label)) {
                return item.getValue();
            }
        }
        return null;
    }
}
