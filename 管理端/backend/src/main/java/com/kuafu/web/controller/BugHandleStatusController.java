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
import com.kuafu.web.entity.BugHandleStatus;
import com.kuafu.web.service.IBugHandleStatusService;
import com.kuafu.web.vo.BugHandleStatusPageVO;
import com.kuafu.web.vo.BugHandleStatusVO;


/**
 * <p> BUG处理状态表 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2024/09/23 11:10
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/bugHandleStatus")
@Api(tags = {"BUG处理状态表"})
public class BugHandleStatusController  {

    private final IBugHandleStatusService bugHandleStatusService;

    @PostMapping("page")
    @ApiOperation("分页")
    public BaseResponse page( @RequestBody BugHandleStatusPageVO pageVO){
        IPage<BugHandleStatus> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());
        LambdaQueryWrapper<BugHandleStatus> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(pageVO.getHandleStatusDescription())) {
            queryWrapper.eq(BugHandleStatus::getHandleStatusDescription, pageVO.getHandleStatusDescription());
        }
        return ResultUtils.success(bugHandleStatusService.page(page, queryWrapper));
    }

    @PostMapping("list")
    @ApiOperation("列表")
    public BaseResponse list( @RequestBody BugHandleStatusVO vo){
        LambdaQueryWrapper<BugHandleStatus> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(vo.getHandleStatusDescription())) {
            queryWrapper.eq(BugHandleStatus::getHandleStatusDescription, vo.getHandleStatusDescription());
        }
        return ResultUtils.success(bugHandleStatusService.list(queryWrapper));
    }


            @PostMapping("get_select_list")
            @ApiOperation("获取所有的下拉列表")
            public BaseResponse get_select_list( ){
                LambdaQueryWrapper<BugHandleStatus> queryWrapper = new LambdaQueryWrapper<>();
                queryWrapper.select(BugHandleStatus::getHandleStatusId);

        List<BugHandleStatus> list =bugHandleStatusService.list(queryWrapper);
        final List<SelectVO> selectVOS = list.stream().map(l -> new SelectVO(l.getHandleStatusId(), l.getHandleStatusId().toString())).collect(Collectors.toList());
        return ResultUtils.success(selectVOS);

                }

    @PostMapping("add")
    @ApiOperation("新增")
    public BaseResponse add( @RequestBody BugHandleStatusVO vo) {
        BugHandleStatus entity =  BugHandleStatus.builder()
                    .handleStatusDescription(vo.getHandleStatusDescription())
                .build();
        boolean flag =this.bugHandleStatusService.save(entity);
        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }

    @PutMapping("update")
    @ApiOperation("更新")
    public BaseResponse update( @RequestBody BugHandleStatusVO vo) {
        BugHandleStatus entity =  BugHandleStatus.builder()
                    .handleStatusId(vo.getHandleStatusId())
                    .handleStatusDescription(vo.getHandleStatusDescription())
                .build();
        boolean flag = this.bugHandleStatusService.updateById(entity);
        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }


    @GetMapping("get/{id}")
    @ApiOperation("根据Id查询")
    public BaseResponse get(@PathVariable(value="id") Integer handleStatusId) {
        BugHandleStatus entity = this.bugHandleStatusService.getById(handleStatusId);
        return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }


    @DeleteMapping("delete/{id}")
    @ApiOperation("删除")
    public BaseResponse delete(@PathVariable(value="id") Integer handleStatusId) {
        boolean flag = this.bugHandleStatusService.removeById(handleStatusId);
        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }

}
