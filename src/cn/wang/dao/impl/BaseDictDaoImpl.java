package cn.wang.dao.impl;

import cn.wang.dao.BaseDictDao;
import cn.wang.domain.BaseDict;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao {

    @Override
    public List<BaseDict> getListByTypeCode(String code) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BaseDict.class);
        detachedCriteria.add(Restrictions.eq("dict_type_code", code));

        List<BaseDict> list = (List<BaseDict>) getHibernateTemplate().findByCriteria(detachedCriteria);
        return list;
    }
}
