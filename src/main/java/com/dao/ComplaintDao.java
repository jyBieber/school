package com.dao;

import com.entity.ComplaintEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ComplaintView;

/**
 * 投诉信息 Dao 接口
 */
public interface ComplaintDao extends BaseMapper<ComplaintEntity> {

   List<ComplaintView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
