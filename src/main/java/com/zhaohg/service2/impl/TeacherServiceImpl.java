package com.zhaohg.service2.impl;

import com.github.pagehelper.PageHelper;
import com.zhaohg.entity.Teacher;
import com.zhaohg.mapper2.TeacherMapper;
import com.zhaohg.model.QueryTeacherList;
import com.zhaohg.service.impl.BaseService;
import com.zhaohg.service2.TeacherService;
import com.zhaohg.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.StringUtil;

import javax.transaction.Transactional;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service("teacherServiceImpl")
public class TeacherServiceImpl extends BaseService<Teacher> implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> queryTeacherList(Page<QueryTeacherList> page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        return teacherMapper.selectAll();
    }


    @Transactional
    @Override
    public Map<String, Object> saveOrUpdateTeacher(Teacher teacher) {
        LinkedHashMap<String,Object> resultMap=new LinkedHashMap<String,Object>();
        if(teacher!=null){
            if(StringUtil.isNotEmpty(teacher.getId())){//编辑
                if(StringUtil.isNotEmpty(teacher.getName())){
                    updateNotNull(teacher);
                    resultMap.put("state","success");
                    resultMap.put("message","修改教师成功");
                    return resultMap;
                }else{
                    resultMap.put("state","fail");
                    resultMap.put("message","修改失败，缺少字段");
                    return resultMap;
                }
            }else{//新建
                if(StringUtil.isNotEmpty(teacher.getName())){
                    teacher.setId(UUID.randomUUID().toString().replaceAll("-",""));
                    saveNotNull(teacher);
                    resultMap.put("state","success");
                    resultMap.put("message","新建教师成功");
                    return resultMap;
                }else{
                    resultMap.put("state","fail");
                    resultMap.put("message","新建失败，缺少字段");
                    return resultMap;
                }
            }
        }else{
            resultMap.put("state","fail");
            resultMap.put("message","失败");
            return resultMap;
        }

    }
}
