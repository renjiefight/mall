package com.renjie.mall.controller;

import com.alibaba.fastjson.JSON;
import com.renjie.mall.annotation.SysLog;
import com.renjie.mall.entity.SysOssEntity;
import com.renjie.mall.oss.CloudStorageConfig;
import com.renjie.mall.oss.OSSFactory;
import com.renjie.mall.service.SysConfigService;
import com.renjie.mall.service.SysOssService;
import com.renjie.mall.utils.Constant;
import com.renjie.mall.utils.PageUtilsPlus;
import com.renjie.mall.utils.R;
import com.renjie.mall.utils.RRException;
import com.renjie.mall.validator.ValidatorUtils;
import com.renjie.mall.validator.group.AliyunGroup;
import com.renjie.mall.validator.group.DiskGroup;
import com.renjie.mall.validator.group.QcloudGroup;
import com.renjie.mall.validator.group.QiniuGroup;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * 文件上传Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @gitee https://gitee.com/fuyang_lipengjun/platform
 * @date 2017-03-25 12:13:26
 */
@RestController
@RequestMapping("sys/oss")
public class SysOssController {
    @Autowired
    private SysOssService sysOssService;
    @Autowired
    private SysConfigService sysConfigService;

    private final static String KEY = Constant.CLOUD_STORAGE_CONFIG_KEY;

    /**
     * 列表
     *
     * @param params 请求参数
     * @return R
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:oss:all")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        PageUtilsPlus pageUtil = sysOssService.queryPage(params);
        return R.ok().put("page", pageUtil);
    }


    /**
     * 获取云存储配置信息
     *
     * @return R
     */
    @RequestMapping("/config")
    @RequiresPermissions("sys:oss:all")
    public R config() {
        CloudStorageConfig config = sysConfigService.getConfigObject(KEY, CloudStorageConfig.class);

        return R.ok().put("config", config);
    }


    /**
     * 保存云存储配置信息
     *
     * @param config 配置信息
     * @return R
     */
    @SysLog("保存云存储配置信息")
    @RequestMapping("/saveConfig")
    @RequiresPermissions("sys:oss:all")
    public R saveConfig(@RequestBody CloudStorageConfig config) {
        //校验类型
        ValidatorUtils.validateEntity(config);

        if (config.getType() == Constant.CloudService.QINIU.getValue()) {
            //校验七牛数据
            ValidatorUtils.validateEntity(config, QiniuGroup.class);
        } else if (config.getType() == Constant.CloudService.ALIYUN.getValue()) {
            //校验阿里云数据
            ValidatorUtils.validateEntity(config, AliyunGroup.class);
        } else if (config.getType() == Constant.CloudService.QCLOUD.getValue()) {
            //校验腾讯云数据
            ValidatorUtils.validateEntity(config, QcloudGroup.class);
        } else if (config.getType() == Constant.CloudService.DISCK.getValue()) {
            //校验腾讯云数据
            ValidatorUtils.validateEntity(config, DiskGroup.class);
        }

        sysConfigService.updateValueByKey(KEY, JSON.toJSONString(config));

        return R.ok();
    }

    /**
     * 上传文件
     *
     * @param file 文件
     * @return R
     * @throws Exception 异常
     */
    @RequestMapping("/upload")
    public R upload(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new RRException("上传文件不能为空");
        }
        //上传文件
        String url = OSSFactory.build().upload(file);

        //保存文件信息
        SysOssEntity ossEntity = new SysOssEntity();
        ossEntity.setUrl(url);
        ossEntity.setCreateDate(new Date());
        sysOssService.save(ossEntity);

        R r = new R();
        r.put("url", url);
        r.put("link", url);
        return r;
    }


    /**
     * 删除图片
     *
     * @param ids 主键集
     * @return R
     */
    @SysLog("删除图片")
    @RequestMapping("/delete")
    @RequiresPermissions("sys:oss:all")
    public R delete(@RequestBody Long[] ids) {
        sysOssService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}
