package com.dao;

import com.entity.TaskEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.TaskView;

/**
 * 任务信息 Dao 接口
 */
public interface TaskDao extends BaseMapper<TaskEntity> {

   List<TaskView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
