package com.kuafu.web.service.impl;

import java.util.List;
import org.springframework.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.kuafu.web.mapper.BugHandleStatusMapper;
import com.kuafu.web.entity.BugHandleStatus;
import com.kuafu.web.service.IBugHandleStatusService;
import lombok.extern.slf4j.Slf4j;

/**
 * <p> BUG处理状态表 服务实现类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2024/09/23 11:10
 */
@Slf4j
@Service("BugHandleStatus")
public class BugHandleStatusServiceImpl extends ServiceImpl<BugHandleStatusMapper, BugHandleStatus> implements IBugHandleStatusService {


}
