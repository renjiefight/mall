package com.renjie.mall.controller;

import com.renjie.mall.entity.FootprintEntity;
import com.renjie.mall.service.FootprintService;
import com.renjie.mall.utils.PageUtils;
import com.renjie.mall.utils.Query;
import com.renjie.mall.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-13 10:41:08
 */
@RestController
@RequestMapping("footprint")
public class FootprintController {
    @Autowired
    private FootprintService footprintService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("footprint:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<FootprintEntity> footprintList = footprintService.queryList(query);
        int total = footprintService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(footprintList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("footprint:info")
    public R info(@PathVariable("id") Integer id) {
        FootprintEntity footprint = footprintService.queryObject(id);

        return R.ok().put("footprint", footprint);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("footprint:save")
    public R save(@RequestBody FootprintEntity footprint) {
        footprintService.save(footprint);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("footprint:update")
    public R update(@RequestBody FootprintEntity footprint) {
        footprintService.update(footprint);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("footprint:delete")
    public R delete(@RequestBody Integer[] ids) {
        footprintService.deleteBatch(ids);

        return R.ok();
    }

}
