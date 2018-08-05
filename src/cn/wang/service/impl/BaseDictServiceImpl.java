package cn.wang.service.impl;

import cn.wang.dao.BaseDictDao;
import cn.wang.domain.BaseDict;
import cn.wang.service.BaseDictService;

import java.util.List;

public class BaseDictServiceImpl implements BaseDictService {
    private BaseDictDao baseDictDao;
    @Override
    public List<BaseDict> getListByTypeCode(String code) {
        return baseDictDao.getListByTypeCode(code);
    }

    @Override
    public BaseDict getBaseDict(String id) {
        BaseDict baseDict = baseDictDao.getById(id);
        return baseDict;
    }

    public BaseDictDao getBaseDictDao() {
        return baseDictDao;
    }

    public void setBaseDictDao(BaseDictDao baseDictDao) {
        this.baseDictDao = baseDictDao;
    }
}
