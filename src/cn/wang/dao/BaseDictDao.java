package cn.wang.dao;

import cn.wang.domain.BaseDict;

import java.util.List;

public interface BaseDictDao extends BaseDao<BaseDict>{
    List<BaseDict> getListByTypeCode(String code);
}
