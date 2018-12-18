package com.zhaohg.service;

import com.zhaohg.entity.TClass;
import com.zhaohg.model.QueryTClassList;
import com.zhaohg.util.Page;

import java.util.List;
import java.util.Map;

public interface TClassService  extends IService<TClass>{
    public List<TClass> queryTClassList(Page<QueryTClassList> page);

    public Map<String,Object> saveOrUpdateTClass(TClass tclass);


}
