package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.ErrandsEntity;
import com.entity.view.ErrandsView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户 Dao 接口
 */
public interface ErrandsDao extends BaseMapper<ErrandsEntity> {

   List<ErrandsView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
