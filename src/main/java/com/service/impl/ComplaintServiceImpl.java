package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import com.dao.ComplaintDao;
import com.entity.ComplaintEntity;
import com.service.ComplaintService;
import com.entity.view.ComplaintView;

/**
 * 投诉信息 服务实现类
 */
@Service("complaintService")
@Transactional
public class ComplaintServiceImpl extends ServiceImpl<ComplaintDao, ComplaintEntity> implements ComplaintService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ComplaintView> page =new Query<ComplaintView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}