
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 任务信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/task")
public class TaskController {
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskService taskService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;
    //级联表service
    @Autowired
    private YonghuService yonghuService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));

        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = taskService.queryPage(params);

        //字典表数据转换
        List<TaskView> list =(List<TaskView>)page.getList();
        for(TaskView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        TaskEntity task = taskService.selectById(id);
        if(task !=null){
            //entity转view
            TaskView view = new TaskView();
            BeanUtils.copyProperties( task , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(task.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody TaskEntity task, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,task:{}",this.getClass().getName(),task.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            task.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<TaskEntity> queryWrapper = new EntityWrapper<TaskEntity>()
            .eq("task_uuid_number", task.getTaskUuidNumber())
            .eq("yonghu_id", task.getYonghuId())
            .eq("task_name", task.getTaskName())
            .eq("task_status_types", task.getTaskStatusTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TaskEntity taskEntity = taskService.selectOne(queryWrapper);
        if(taskEntity==null){
            task.setCreateTime(new Date());
            taskService.insert(task);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody TaskEntity task, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,task:{}",this.getClass().getName(),task.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        //根据字段查询是否有相同数据
        Wrapper<TaskEntity> queryWrapper = new EntityWrapper<TaskEntity>()
            .notIn("id",task.getId())
            .andNew()
            .eq("task_uuid_number", task.getTaskUuidNumber())
            .eq("yonghu_id", task.getYonghuId())
            .eq("task_name", task.getTaskName())
            .eq("task_status_types", task.getTaskStatusTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TaskEntity taskEntity = taskService.selectOne(queryWrapper);
        if(taskEntity==null){
            taskService.updateById(task);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        taskService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<TaskEntity> taskList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            TaskEntity taskEntity = new TaskEntity();
                            taskList.add(taskEntity);
                            //把要查询是否重复的字段放入map中
                                //任务编号
                                if(seachFields.containsKey("taskUuidNumber")){
                                    List<String> taskUuidNumber = seachFields.get("taskUuidNumber");
                                    taskUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> taskUuidNumber = new ArrayList<>();
                                    taskUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("taskUuidNumber",taskUuidNumber);
                                }
                        }

                        //查询是否重复
                         //任务编号
                        List<TaskEntity> taskEntities_taskUuidNumber = taskService.selectList(new EntityWrapper<TaskEntity>().in("task_uuid_number", seachFields.get("taskUuidNumber")));
                        if(taskEntities_taskUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(TaskEntity s:taskEntities_taskUuidNumber){
                                repeatFields.add(s.getTaskUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [任务编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        taskService.insertBatch(taskList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }
}
