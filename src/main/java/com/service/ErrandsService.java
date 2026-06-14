package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.entity.ErrandsEntity;
import com.utils.PageUtils;

import java.util.Map;

/**
 * 用户 服务类
 */
public interface ErrandsService extends IService<ErrandsEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}