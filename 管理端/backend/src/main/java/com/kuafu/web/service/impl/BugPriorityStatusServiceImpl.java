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

import com.kuafu.web.mapper.BugPriorityStatusMapper;
import com.kuafu.web.entity.BugPriorityStatus;
import com.kuafu.web.service.IBugPriorityStatusService;
import lombok.extern.slf4j.Slf4j;

/**
 * <p> BUG优先级表 服务实现类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2024/09/23 11:10
 */
@Slf4j
@Service("BugPriorityStatus")
public class BugPriorityStatusServiceImpl extends ServiceImpl<BugPriorityStatusMapper, BugPriorityStatus> implements IBugPriorityStatusService {


}
