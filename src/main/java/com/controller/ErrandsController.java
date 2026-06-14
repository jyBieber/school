
package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.ErrandsEntity;
import com.entity.view.ErrandsView;
import com.service.DictionaryService;
import com.service.TokenService;
import com.service.ErrandsService;
import com.utils.PageUtils;
import com.utils.PoiUtil;
import com.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URL;
import java.util.*;

/**
 * 跑腿
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/errands")
public class ErrandsController {
    private static final Logger logger = LoggerFactory.getLogger(ErrandsController.class);

    @Autowired
    private ErrandsService errandsService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("跑腿".equals(role))
            params.put("errandsId",request.getSession().getAttribute("userId"));
        params.put("errandsDeleteStart",1);params.put("errandsDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = errandsService.queryPage(params);

        //字典表数据转换
        List<ErrandsView> list =(List<ErrandsView>)page.getList();
        for(ErrandsView c:list){
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
        ErrandsEntity errands = errandsService.selectById(id);
        if(errands !=null){
            //entity转view
            ErrandsView view = new ErrandsView();
            BeanUtils.copyProperties( errands , view );//把实体数据重构到view中

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
    public R save(@RequestBody ErrandsEntity errands, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,errands:{}",this.getClass().getName(),errands.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ErrandsEntity> queryWrapper = new EntityWrapper<ErrandsEntity>()
            .eq("username", errands.getUsername())
            .or()
            .eq("errands_phone", errands.getErrandsPhone())
            .or()
            .andNew()
            .eq("errands_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ErrandsEntity errandsEntity = errandsService.selectOne(queryWrapper);
        if(errandsEntity==null){
            errands.setErrandsDelete(1);
            errands.setCreateTime(new Date());
            errands.setPassword("123456");
            errandsService.insert(errands);
            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ErrandsEntity errands, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,errands:{}",this.getClass().getName(),errands.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        //根据字段查询是否有相同数据
        Wrapper<ErrandsEntity> queryWrapper = new EntityWrapper<ErrandsEntity>()
            .notIn("id",errands.getId())
            .andNew()
            .eq("username", errands.getUsername())
            .or()
            .eq("errands_phone", errands.getErrandsPhone())
            .or()
            .andNew()
            .eq("errands_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ErrandsEntity errandsEntity = errandsService.selectOne(queryWrapper);
        if("".equals(errands.getErrandsPhoto()) || "null".equals(errands.getErrandsPhoto())){
                errands.setErrandsPhoto(null);
        }
        if(errandsEntity==null){
            errandsService.updateById(errands);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<ErrandsEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ErrandsEntity errandsEntity = new ErrandsEntity();
            errandsEntity.setId(id);
            errandsEntity.setErrandsDelete(2);
            list.add(errandsEntity);
        }
        if(list != null && list.size() >0){
            errandsService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ErrandsEntity> errandsList = new ArrayList<>();//上传的东西
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
                            ErrandsEntity errandsEntity = new ErrandsEntity();
                            errandsList.add(errandsEntity);

                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //联系方式
                                if(seachFields.containsKey("errandsPhone")){
                                    List<String> errandsPhone = seachFields.get("errandsPhone");
                                    errandsPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> errandsPhone = new ArrayList<>();
                                    errandsPhone.add(data.get(0));//要改的
                                    seachFields.put("errandsPhone",errandsPhone);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<ErrandsEntity> errandsEntities_username = errandsService.selectList(new EntityWrapper<ErrandsEntity>().in("username", seachFields.get("username")).eq("errands_delete", 1));
                        if(errandsEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ErrandsEntity s:errandsEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //联系方式
                        List<ErrandsEntity> errandsEntities_errandsPhone = errandsService.selectList(new EntityWrapper<ErrandsEntity>().in("errands_phone", seachFields.get("errandsPhone")).eq("errands_delete", 1));
                        if(errandsEntities_errandsPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ErrandsEntity s:errandsEntities_errandsPhone){
                                repeatFields.add(s.getErrandsPhone());
                            }
                            return R.error(511,"数据库的该表中的 [联系方式] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        errandsService.insertBatch(errandsList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        ErrandsEntity errands = errandsService.selectOne(new EntityWrapper<ErrandsEntity>().eq("username", username));
        if(errands==null || !errands.getPassword().equals(password))
            return R.error("账号或密码不正确");
        else if(errands.getErrandsDelete() != 1)
            return R.error("账户已被删除");
        String token = tokenService.generateToken(errands.getId(),username, "errands", "跑腿");
        R r = R.ok();
        r.put("token", token);
        r.put("role","跑腿");
        r.put("username",errands.getErrandsName());
        r.put("tableName","errands");
        r.put("userId",errands.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/errandsregister")
    public R errandsregister(@RequestBody ErrandsEntity errands){
        Wrapper<ErrandsEntity> queryWrapper = new EntityWrapper<ErrandsEntity>()
            .eq("username", errands.getUsername())
            .or()
            .eq("errands_phone", errands.getErrandsPhone())
            .andNew()
            .eq("errands_delete", 1)
            ;
        ErrandsEntity errandsEntity = errandsService.selectOne(queryWrapper);
        if(errandsEntity != null)
            return R.error("账户或者联系方式已经被使用");
        errands.setErrandsDelete(1);
        errands.setCreateTime(new Date());
        errandsService.insert(errands);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        ErrandsEntity errands = new ErrandsEntity();
        errands.setPassword("123456");
        errands.setId(id);
        errandsService.updateById(errands);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        ErrandsEntity errands = errandsService.selectOne(new EntityWrapper<ErrandsEntity>().eq("username", username));
        if(errands!=null){
            errands.setPassword("123456");
            boolean b = errandsService.updateById(errands);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取跑腿的session跑腿信息
    */
    @RequestMapping("/session")
    public R getCurrErrands(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        ErrandsEntity errands = errandsService.selectById(id);
        if(errands !=null){
            //entity转view
            ErrandsView view = new ErrandsView();
            BeanUtils.copyProperties( errands , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }
}
