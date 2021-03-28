package com.renjie.mall.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.renjie.mall.dao.ScheduleJobLogDao;
import com.renjie.mall.entity.ScheduleJobLogEntity;
import com.renjie.mall.service.ScheduleJobLogService;
import com.renjie.mall.utils.PageUtilsPlus;
import com.renjie.mall.utils.QueryPlus;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author 李鹏军
 */
@Service("scheduleJobLogService")
public class ScheduleJobLogServiceImpl extends ServiceImpl<ScheduleJobLogDao, ScheduleJobLogEntity> implements ScheduleJobLogService {

    @Override
    public PageUtilsPlus queryPage(Map<String, Object> params) {
        //排序
        params.put("sidx", "T.CREATE_TIME");
        params.put("asc", false);
        Page<ScheduleJobLogEntity> page = new QueryPlus<ScheduleJobLogEntity>(params).getPage();
        return new PageUtilsPlus(page.setRecords(baseMapper.selectScheduleJobLogPage(page, params)));
    }
}
