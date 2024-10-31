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
import com.kuafu.web.entity.SelectVO;

import lombok.RequiredArgsConstructor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.kuafu.common.domin.BaseResponse;
import com.kuafu.common.domin.ErrorCode;
import com.kuafu.common.domin.ResultUtils;
import com.kuafu.common.util.StringUtils;
import com.kuafu.web.entity.BugInfo;
import com.kuafu.web.service.IBugInfoService;
import com.kuafu.web.vo.BugInfoPageVO;
import com.kuafu.web.vo.BugInfoVO;


/**
 * <p> BUG表 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2024/09/23 11:10
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/bugInfo")
@Api(tags = {"BUG表"})
public class BugInfoController  {

    private final IBugInfoService bugInfoService;

    @PostMapping("page")
    @ApiOperation("分页")
    public BaseResponse page( @RequestBody BugInfoPageVO pageVO){
        IPage<BugInfo> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());
        LambdaQueryWrapper<BugInfo> queryWrapper = new LambdaQueryWrapper<>();

            if(pageVO.getBugDiscoverer() != null){
            queryWrapper.eq(BugInfo::getBugDiscoverer, pageVO.getBugDiscoverer());
        }
            if(pageVO.getBugSubmitter() != null){
            queryWrapper.eq(BugInfo::getBugSubmitter, pageVO.getBugSubmitter());
        }
            if(pageVO.getBugHandler() != null){
            queryWrapper.eq(BugInfo::getBugHandler, pageVO.getBugHandler());
        }
            if(StringUtils.isNotEmpty(pageVO.getBugTitle())) {
            queryWrapper.eq(BugInfo::getBugTitle, pageVO.getBugTitle());
        }
            if(StringUtils.isNotEmpty(pageVO.getBugDescription())) {
            queryWrapper.eq(BugInfo::getBugDescription, pageVO.getBugDescription());
        }
            if(StringUtils.isNotEmpty(pageVO.getBugImage())) {
            queryWrapper.eq(BugInfo::getBugImage, pageVO.getBugImage());
        }
            if(pageVO.getProjectInfoId() != null){
            queryWrapper.eq(BugInfo::getProjectInfoId, pageVO.getProjectInfoId());
        }
            if(pageVO.getBugDeadline() != null){
            queryWrapper.eq(BugInfo::getBugDeadline, pageVO.getBugDeadline());
        }
            if(pageVO.getBugPriority() != null){
            queryWrapper.eq(BugInfo::getBugPriority, pageVO.getBugPriority());
        }
            if(pageVO.getBugHandleStatus() != null){
            queryWrapper.eq(BugInfo::getBugHandleStatus, pageVO.getBugHandleStatus());
        }
            if(pageVO.getCreatedTime() != null){
            queryWrapper.eq(BugInfo::getCreatedTime, pageVO.getCreatedTime());
        }
        return ResultUtils.success(bugInfoService.page(page, queryWrapper));
    }

    @PostMapping("list")
    @ApiOperation("列表")
    public BaseResponse list( @RequestBody BugInfoVO vo){
        LambdaQueryWrapper<BugInfo> queryWrapper = new LambdaQueryWrapper<>();

                if(vo.getBugDiscoverer() != null){
            queryWrapper.eq(BugInfo::getBugDiscoverer, vo.getBugDiscoverer());
        }
                if(vo.getBugSubmitter() != null){
            queryWrapper.eq(BugInfo::getBugSubmitter, vo.getBugSubmitter());
        }
                if(vo.getBugHandler() != null){
            queryWrapper.eq(BugInfo::getBugHandler, vo.getBugHandler());
        }
            if(StringUtils.isNotEmpty(vo.getBugTitle())) {
            queryWrapper.eq(BugInfo::getBugTitle, vo.getBugTitle());
        }
            if(StringUtils.isNotEmpty(vo.getBugDescription())) {
            queryWrapper.eq(BugInfo::getBugDescription, vo.getBugDescription());
        }
            if(StringUtils.isNotEmpty(vo.getBugImage())) {
            queryWrapper.eq(BugInfo::getBugImage, vo.getBugImage());
        }
                if(vo.getProjectInfoId() != null){
            queryWrapper.eq(BugInfo::getProjectInfoId, vo.getProjectInfoId());
        }
                if(vo.getBugDeadline() != null){
            queryWrapper.eq(BugInfo::getBugDeadline, vo.getBugDeadline());
        }
                if(vo.getBugPriority() != null){
            queryWrapper.eq(BugInfo::getBugPriority, vo.getBugPriority());
        }
                if(vo.getBugHandleStatus() != null){
            queryWrapper.eq(BugInfo::getBugHandleStatus, vo.getBugHandleStatus());
        }
                if(vo.getCreatedTime() != null){
            queryWrapper.eq(BugInfo::getCreatedTime, vo.getCreatedTime());
        }
        return ResultUtils.success(bugInfoService.list(queryWrapper));
    }


            @PostMapping("get_select_list")
            @ApiOperation("获取所有的下拉列表")
            public BaseResponse get_select_list( ){
                LambdaQueryWrapper<BugInfo> queryWrapper = new LambdaQueryWrapper<>();
                queryWrapper.select(BugInfo::getBugInfoId);

        List<BugInfo> list =bugInfoService.list(queryWrapper);
        final List<SelectVO> selectVOS = list.stream().map(l -> new SelectVO(l.getBugInfoId(), l.getBugInfoId().toString())).collect(Collectors.toList());
        return ResultUtils.success(selectVOS);

                }

    @PostMapping("add")
    @ApiOperation("新增")
    public BaseResponse add( @RequestBody BugInfoVO vo) {
        BugInfo entity =  BugInfo.builder()
                    .bugDiscoverer(vo.getBugDiscoverer())
                    .bugSubmitter(vo.getBugSubmitter())
                    .bugHandler(vo.getBugHandler())
                    .bugTitle(vo.getBugTitle())
                    .bugDescription(vo.getBugDescription())
                    .bugImage(vo.getBugImage())
                    .projectInfoId(vo.getProjectInfoId())
                    .bugDeadline(vo.getBugDeadline())
                    .bugPriority(vo.getBugPriority())
                    .bugHandleStatus(vo.getBugHandleStatus())
                    .createdTime(vo.getCreatedTime())
                .build();
        boolean flag =this.bugInfoService.save(entity);
        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }

    @PutMapping("update")
    @ApiOperation("更新")
    public BaseResponse update( @RequestBody BugInfoVO vo) {
        BugInfo entity =  BugInfo.builder()
                    .bugInfoId(vo.getBugInfoId())
                    .bugDiscoverer(vo.getBugDiscoverer())
                    .bugSubmitter(vo.getBugSubmitter())
                    .bugHandler(vo.getBugHandler())
                    .bugTitle(vo.getBugTitle())
                    .bugDescription(vo.getBugDescription())
                    .bugImage(vo.getBugImage())
                    .projectInfoId(vo.getProjectInfoId())
                    .bugDeadline(vo.getBugDeadline())
                    .bugPriority(vo.getBugPriority())
                    .bugHandleStatus(vo.getBugHandleStatus())
                    .createdTime(vo.getCreatedTime())
                .build();
        boolean flag = this.bugInfoService.updateById(entity);
        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }


    @GetMapping("get/{id}")
    @ApiOperation("根据Id查询")
    public BaseResponse get(@PathVariable(value="id") Integer bugInfoId) {
        BugInfo entity = this.bugInfoService.getById(bugInfoId);
        return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }


    @DeleteMapping("delete/{id}")
    @ApiOperation("删除")
    public BaseResponse delete(@PathVariable(value="id") Integer bugInfoId) {
        boolean flag = this.bugInfoService.removeById(bugInfoId);
        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }

    @PostMapping("pageList")
    @ApiOperation("分页")
    public BaseResponse pageList( @RequestBody BugInfoPageVO pageVO){
        IPage<BugInfo> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());
        LambdaQueryWrapper<BugInfo> queryWrapper = new LambdaQueryWrapper<>();

        if(pageVO.getBugDiscoverer() != null){
            queryWrapper.eq(BugInfo::getBugDiscoverer, pageVO.getBugDiscoverer());
        }
        if(pageVO.getBugSubmitter() != null){
            queryWrapper.eq(BugInfo::getBugSubmitter, pageVO.getBugSubmitter());
        }
        if(pageVO.getBugHandler() != null){
            queryWrapper.eq(BugInfo::getBugHandler, pageVO.getBugHandler());
        }
        if(StringUtils.isNotEmpty(pageVO.getBugTitle())) {
            queryWrapper.eq(BugInfo::getBugTitle, pageVO.getBugTitle());
        }
        if(StringUtils.isNotEmpty(pageVO.getBugDescription())) {
            queryWrapper.eq(BugInfo::getBugDescription, pageVO.getBugDescription());
        }
        if(StringUtils.isNotEmpty(pageVO.getBugImage())) {
            queryWrapper.eq(BugInfo::getBugImage, pageVO.getBugImage());
        }
        if(pageVO.getProjectInfoId() != null){
            queryWrapper.eq(BugInfo::getProjectInfoId, pageVO.getProjectInfoId());
        }
        if(pageVO.getBugDeadline() != null){
            queryWrapper.eq(BugInfo::getBugDeadline, pageVO.getBugDeadline());
        }
        if(pageVO.getBugPriority() != null){
            queryWrapper.eq(BugInfo::getBugPriority, pageVO.getBugPriority());
        }
        if(pageVO.getBugHandleStatus() != null){
            queryWrapper.eq(BugInfo::getBugHandleStatus, pageVO.getBugHandleStatus());
        }
        if(pageVO.getCreatedTime() != null){
            queryWrapper.eq(BugInfo::getCreatedTime, pageVO.getCreatedTime());
        }
        return ResultUtils.success(bugInfoService.page(page, queryWrapper));
    }


}
