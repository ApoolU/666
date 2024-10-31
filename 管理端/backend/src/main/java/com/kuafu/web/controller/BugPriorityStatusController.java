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
import com.kuafu.web.entity.BugPriorityStatus;
import com.kuafu.web.service.IBugPriorityStatusService;
import com.kuafu.web.vo.BugPriorityStatusPageVO;
import com.kuafu.web.vo.BugPriorityStatusVO;


/**
 * <p> BUG优先级表 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2024/09/23 11:10
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/bugPriorityStatus")
@Api(tags = {"BUG优先级表"})
public class BugPriorityStatusController  {

    private final IBugPriorityStatusService bugPriorityStatusService;

    @PostMapping("page")
    @ApiOperation("分页")
    public BaseResponse page( @RequestBody BugPriorityStatusPageVO pageVO){
        IPage<BugPriorityStatus> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());
        LambdaQueryWrapper<BugPriorityStatus> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(pageVO.getPriorityStatusDescription())) {
            queryWrapper.eq(BugPriorityStatus::getPriorityStatusDescription, pageVO.getPriorityStatusDescription());
        }
        return ResultUtils.success(bugPriorityStatusService.page(page, queryWrapper));
    }

    @PostMapping("list")
    @ApiOperation("列表")
    public BaseResponse list( @RequestBody BugPriorityStatusVO vo){
        LambdaQueryWrapper<BugPriorityStatus> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(vo.getPriorityStatusDescription())) {
            queryWrapper.eq(BugPriorityStatus::getPriorityStatusDescription, vo.getPriorityStatusDescription());
        }
        return ResultUtils.success(bugPriorityStatusService.list(queryWrapper));
    }


            @PostMapping("get_select_list")
            @ApiOperation("获取所有的下拉列表")
            public BaseResponse get_select_list( ){
                LambdaQueryWrapper<BugPriorityStatus> queryWrapper = new LambdaQueryWrapper<>();
                queryWrapper.select(BugPriorityStatus::getPriorityStatusId);

        List<BugPriorityStatus> list =bugPriorityStatusService.list(queryWrapper);
        final List<SelectVO> selectVOS = list.stream().map(l -> new SelectVO(l.getPriorityStatusId(), l.getPriorityStatusId().toString())).collect(Collectors.toList());
        return ResultUtils.success(selectVOS);

                }

    @PostMapping("add")
    @ApiOperation("新增")
    public BaseResponse add( @RequestBody BugPriorityStatusVO vo) {
        BugPriorityStatus entity =  BugPriorityStatus.builder()
                    .priorityStatusDescription(vo.getPriorityStatusDescription())
                .build();
        boolean flag =this.bugPriorityStatusService.save(entity);
        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }

    @PutMapping("update")
    @ApiOperation("更新")
    public BaseResponse update( @RequestBody BugPriorityStatusVO vo) {
        BugPriorityStatus entity =  BugPriorityStatus.builder()
                    .priorityStatusId(vo.getPriorityStatusId())
                    .priorityStatusDescription(vo.getPriorityStatusDescription())
                .build();
        boolean flag = this.bugPriorityStatusService.updateById(entity);
        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }


    @GetMapping("get/{id}")
    @ApiOperation("根据Id查询")
    public BaseResponse get(@PathVariable(value="id") Integer priorityStatusId) {
        BugPriorityStatus entity = this.bugPriorityStatusService.getById(priorityStatusId);
        return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }


    @DeleteMapping("delete/{id}")
    @ApiOperation("删除")
    public BaseResponse delete(@PathVariable(value="id") Integer priorityStatusId) {
        boolean flag = this.bugPriorityStatusService.removeById(priorityStatusId);
        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }

}
