package com.kuafu.web.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;


import lombok.RequiredArgsConstructor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.kuafu.common.domin.BaseResponse;
import com.kuafu.common.domin.ErrorCode;
import com.kuafu.common.domin.ResultUtils;
import com.kuafu.common.util.StringUtils;
import com.kuafu.web.entity.SelectVO;
import com.kuafu.web.entity.BugInfoAll;
import com.kuafu.web.service.IBugInfoAllService;
import com.kuafu.web.vo.BugInfoAllPageVO;

import com.kuafu.web.service.IUserInfoService;
import com.kuafu.web.entity.UserInfo;
import com.kuafu.web.service.IBugHandleStatusService;
import com.kuafu.web.entity.BugHandleStatus;
import com.kuafu.web.service.IBugPriorityStatusService;
import com.kuafu.web.entity.BugPriorityStatus;
import com.kuafu.web.service.IProjectInfoService;
import com.kuafu.web.entity.ProjectInfo;


/**
 * <p> BUG表 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2024/09/23 11:10
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/bugInfoAll")
@Api(tags = {"BUG表"})
public class BugInfoAllController  {

    private final IBugInfoAllService bugInfoAllService;

    @PostMapping("page")
    @ApiOperation("全字段分页")
    public BaseResponse page(@RequestBody BugInfoAllPageVO pageVO){
        IPage<BugInfoAll> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());
        LambdaQueryWrapper<BugInfoAll> queryWrapper = new LambdaQueryWrapper<>();

        if(StringUtils.isNotEmpty(pageVO.getBugDescription())) {
            queryWrapper.eq(BugInfoAll::getBugDescription, pageVO.getBugDescription());
        }
        if(StringUtils.isNotEmpty(pageVO.getBugImage())) {
            queryWrapper.eq(BugInfoAll::getBugImage, pageVO.getBugImage());
        }
        if(StringUtils.isNotEmpty(pageVO.getUserName())) {
            queryWrapper.like(BugInfoAll::getUserName, pageVO.getUserName());
        }
            if(pageVO.getTechnicalDirection() != null){
            queryWrapper.eq(BugInfoAll::getTechnicalDirection, pageVO.getTechnicalDirection());
        }
        if(StringUtils.isNotEmpty(pageVO.getProjectName())) {
            queryWrapper.like(BugInfoAll::getProjectName, pageVO.getProjectName());
        }
            if(pageVO.getTechnicalDirection() != null){
            queryWrapper.eq(BugInfoAll::getTechnicalDirection, pageVO.getTechnicalDirection());
        }
        if(StringUtils.isNotEmpty(pageVO.getHandleStatusDescription())) {
            queryWrapper.eq(BugInfoAll::getHandleStatusDescription, pageVO.getHandleStatusDescription());
        }
            if(pageVO.getBugPriority() != null){
            queryWrapper.eq(BugInfoAll::getBugPriority, pageVO.getBugPriority());
        }
            if(pageVO.getTechnicalDirection() != null){
            queryWrapper.eq(BugInfoAll::getTechnicalDirection, pageVO.getTechnicalDirection());
        }
        if(StringUtils.isNotEmpty(pageVO.getPriorityStatusDescription())) {
            queryWrapper.eq(BugInfoAll::getPriorityStatusDescription, pageVO.getPriorityStatusDescription());
        }
            if(pageVO.getBugSubmitter() != null){
            queryWrapper.eq(BugInfoAll::getBugSubmitter, pageVO.getBugSubmitter());
        }
        if(StringUtils.isNotEmpty(pageVO.getPhoneNumber())) {
            queryWrapper.eq(BugInfoAll::getPhoneNumber, pageVO.getPhoneNumber());
        }
        if(StringUtils.isNotEmpty(pageVO.getPhoneNumber())) {
            queryWrapper.eq(BugInfoAll::getPhoneNumber, pageVO.getPhoneNumber());
        }
        if(StringUtils.isNotEmpty(pageVO.getUserName())) {
            queryWrapper.like(BugInfoAll::getUserName, pageVO.getUserName());
        }
            if(pageVO.getCreatedTime() != null){
            queryWrapper.eq(BugInfoAll::getCreatedTime, pageVO.getCreatedTime());
        }
        if(StringUtils.isNotEmpty(pageVO.getBugTitle())) {
            queryWrapper.eq(BugInfoAll::getBugTitle, pageVO.getBugTitle());
        }
        if(StringUtils.isNotEmpty(pageVO.getUserName())) {
            queryWrapper.like(BugInfoAll::getUserName, pageVO.getUserName());
        }
        if(StringUtils.isNotEmpty(pageVO.getProjectLeader())) {
            queryWrapper.eq(BugInfoAll::getProjectLeader, pageVO.getProjectLeader());
        }
            if(pageVO.getBugHandleStatus() != null){
            queryWrapper.eq(BugInfoAll::getBugHandleStatus, pageVO.getBugHandleStatus());
        }
            if(pageVO.getBugDiscoverer() != null){
            queryWrapper.eq(BugInfoAll::getBugDiscoverer, pageVO.getBugDiscoverer());
        }
            if(pageVO.getProjectInfoId() != null){
            queryWrapper.eq(BugInfoAll::getProjectInfoId, pageVO.getProjectInfoId());
        }
        if(StringUtils.isNotEmpty(pageVO.getPhoneNumber())) {
            queryWrapper.eq(BugInfoAll::getPhoneNumber, pageVO.getPhoneNumber());
        }
        if(StringUtils.isNotEmpty(pageVO.getProjectVersion())) {
            queryWrapper.eq(BugInfoAll::getProjectVersion, pageVO.getProjectVersion());
        }
            if(pageVO.getBugDeadline() != null){
            queryWrapper.eq(BugInfoAll::getBugDeadline, pageVO.getBugDeadline());
        }
            if(pageVO.getBugHandler() != null){
            queryWrapper.eq(BugInfoAll::getBugHandler, pageVO.getBugHandler());
        }
        return ResultUtils.success(bugInfoAllService.page(page, queryWrapper));
    }

    @PostMapping("list")
    @ApiOperation("全字段列表")
    public BaseResponse list(@RequestBody BugInfoAllPageVO vo){
        LambdaQueryWrapper<BugInfoAll> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(vo.getBugDescription())) {
            queryWrapper.eq(BugInfoAll::getBugDescription, vo.getBugDescription());
        }
            if(StringUtils.isNotEmpty(vo.getBugImage())) {
            queryWrapper.eq(BugInfoAll::getBugImage, vo.getBugImage());
        }
            if(StringUtils.isNotEmpty(vo.getUserName())) {
            queryWrapper.like(BugInfoAll::getUserName, vo.getUserName());
        }
                if(vo.getTechnicalDirection() != null){
            queryWrapper.eq(BugInfoAll::getTechnicalDirection, vo.getTechnicalDirection());
        }
            if(StringUtils.isNotEmpty(vo.getProjectName())) {
            queryWrapper.like(BugInfoAll::getProjectName, vo.getProjectName());
        }
                if(vo.getTechnicalDirection() != null){
            queryWrapper.eq(BugInfoAll::getTechnicalDirection, vo.getTechnicalDirection());
        }
            if(StringUtils.isNotEmpty(vo.getHandleStatusDescription())) {
            queryWrapper.eq(BugInfoAll::getHandleStatusDescription, vo.getHandleStatusDescription());
        }
                if(vo.getBugPriority() != null){
            queryWrapper.eq(BugInfoAll::getBugPriority, vo.getBugPriority());
        }
                if(vo.getTechnicalDirection() != null){
            queryWrapper.eq(BugInfoAll::getTechnicalDirection, vo.getTechnicalDirection());
        }
            if(StringUtils.isNotEmpty(vo.getPriorityStatusDescription())) {
            queryWrapper.eq(BugInfoAll::getPriorityStatusDescription, vo.getPriorityStatusDescription());
        }
                if(vo.getBugSubmitter() != null){
            queryWrapper.eq(BugInfoAll::getBugSubmitter, vo.getBugSubmitter());
        }
            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
            queryWrapper.eq(BugInfoAll::getPhoneNumber, vo.getPhoneNumber());
        }
            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
            queryWrapper.eq(BugInfoAll::getPhoneNumber, vo.getPhoneNumber());
        }
            if(StringUtils.isNotEmpty(vo.getUserName())) {
            queryWrapper.like(BugInfoAll::getUserName, vo.getUserName());
        }
                if(vo.getCreatedTime() != null){
            queryWrapper.eq(BugInfoAll::getCreatedTime, vo.getCreatedTime());
        }
            if(StringUtils.isNotEmpty(vo.getBugTitle())) {
            queryWrapper.eq(BugInfoAll::getBugTitle, vo.getBugTitle());
        }
            if(StringUtils.isNotEmpty(vo.getUserName())) {
            queryWrapper.like(BugInfoAll::getUserName, vo.getUserName());
        }
            if(StringUtils.isNotEmpty(vo.getProjectLeader())) {
            queryWrapper.eq(BugInfoAll::getProjectLeader, vo.getProjectLeader());
        }
                if(vo.getBugHandleStatus() != null){
            queryWrapper.eq(BugInfoAll::getBugHandleStatus, vo.getBugHandleStatus());
        }
                if(vo.getBugDiscoverer() != null){
            queryWrapper.eq(BugInfoAll::getBugDiscoverer, vo.getBugDiscoverer());
        }
                if(vo.getProjectInfoId() != null){
            queryWrapper.eq(BugInfoAll::getProjectInfoId, vo.getProjectInfoId());
        }
            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
            queryWrapper.eq(BugInfoAll::getPhoneNumber, vo.getPhoneNumber());
        }
            if(StringUtils.isNotEmpty(vo.getProjectVersion())) {
            queryWrapper.eq(BugInfoAll::getProjectVersion, vo.getProjectVersion());
        }
                if(vo.getBugDeadline() != null){
            queryWrapper.eq(BugInfoAll::getBugDeadline, vo.getBugDeadline());
        }
                if(vo.getBugHandler() != null){
            queryWrapper.eq(BugInfoAll::getBugHandler, vo.getBugHandler());
        }
        return ResultUtils.success(bugInfoAllService.list(queryWrapper));
    }

    @GetMapping("get/{id}")
    @ApiOperation("根据Id查询")
    public BaseResponse get(@PathVariable(value="id") Integer bugInfoId) {
        BugInfoAll entity = this.bugInfoAllService.getById(bugInfoId);
        return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }


        private final IUserInfoService userInfoService;

        @GetMapping("get/user_info_list")
        @ApiOperation("查询下拉框的外键信息")
        public BaseResponse get_user_info_list() {
            List<UserInfo> list = this.userInfoService.list();
            final List<SelectVO> selectVoList = list.stream().map(p ->
                new SelectVO(p.getUserInfoId(), p.getUserName().toString()))
                        .collect(Collectors.toList());
            return ResultUtils.success(selectVoList);
        }
        private final IBugHandleStatusService bugHandleStatusService;

        @GetMapping("get/bug_handle_status_list")
        @ApiOperation("查询下拉框的外键信息")
        public BaseResponse get_bug_handle_status_list() {
            List<BugHandleStatus> list = this.bugHandleStatusService.list();
            final List<SelectVO> selectVoList = list.stream().map(p ->
                new SelectVO(p.getHandleStatusId(), p.getHandleStatusDescription().toString()))
                        .collect(Collectors.toList());
            return ResultUtils.success(selectVoList);
        }
        private final IBugPriorityStatusService bugPriorityStatusService;

        @GetMapping("get/bug_priority_status_list")
        @ApiOperation("查询下拉框的外键信息")
        public BaseResponse get_bug_priority_status_list() {
            List<BugPriorityStatus> list = this.bugPriorityStatusService.list();
            final List<SelectVO> selectVoList = list.stream().map(p ->
                new SelectVO(p.getPriorityStatusId(), p.getPriorityStatusDescription().toString()))
                        .collect(Collectors.toList());
            return ResultUtils.success(selectVoList);
        }
        private final IProjectInfoService projectInfoService;

        @GetMapping("get/project_info_list")
        @ApiOperation("查询下拉框的外键信息")
        public BaseResponse get_project_info_list() {
            List<ProjectInfo> list = this.projectInfoService.list();
            final List<SelectVO> selectVoList = list.stream().map(p ->
                new SelectVO(p.getProjectInfoId(), p.getProjectName().toString()))
                        .collect(Collectors.toList());
            return ResultUtils.success(selectVoList);
        }

}
