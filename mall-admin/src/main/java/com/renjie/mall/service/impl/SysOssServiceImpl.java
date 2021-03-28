package com.renjie.mall.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.renjie.mall.dao.SysOssDao;
import com.renjie.mall.entity.SysOssEntity;
import com.renjie.mall.service.SysOssService;
import com.renjie.mall.utils.PageUtilsPlus;
import com.renjie.mall.utils.QueryPlus;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author 李鹏军
 * @email 939961241@qq.com
 * @gitee https://gitee.com/fuyang_lipengjun/platform
 */
@Service("sysOssService")
public class SysOssServiceImpl extends ServiceImpl<SysOssDao, SysOssEntity> implements SysOssService {

    @Override
    public PageUtilsPlus queryPage(Map<String, Object> params) {
        //排序
        params.put("sidx", "t.create_date");
        params.put("asc", false);
        Page<SysOssEntity> page = new QueryPlus<SysOssEntity>(params).getPage();
        return new PageUtilsPlus(page.setRecords(baseMapper.selectSysOssPage(page, params)));
    }
}
