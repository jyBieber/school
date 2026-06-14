package com.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.ErrandsDao;
import com.entity.ErrandsEntity;
import com.entity.view.ErrandsView;
import com.service.ErrandsService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 用户 服务实现类
 */
@Service("errandsService")
@Transactional
public class ErrandsServiceImpl extends ServiceImpl<ErrandsDao, ErrandsEntity> implements ErrandsService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ErrandsView> page =new Query<ErrandsView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }
}