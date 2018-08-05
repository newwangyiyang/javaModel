package cn.wang.service;

import cn.wang.domain.BaseDict;

import java.util.List;

public interface BaseDictService {
    List<BaseDict> getListByTypeCode(String code);
    BaseDict getBaseDict(String id);
}
