package com.zhaohg.service2;

import com.zhaohg.entity.Teacher;
import com.zhaohg.model.QueryTeacherList;
import com.zhaohg.service.IService;
import com.zhaohg.util.Page;

import java.util.List;
import java.util.Map;

public interface TeacherService extends IService<Teacher>{
    public List<Teacher> queryTeacherList(Page<QueryTeacherList> page);

    public Map<String,Object> saveOrUpdateTeacher(Teacher teacher);


}
