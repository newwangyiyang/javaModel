package cn.wang.dao.impl;

import cn.wang.dao.CustomerDao;
import cn.wang.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao{
    @Override
    public Integer getTotalCount(DetachedCriteria detachedCriteria) {
        detachedCriteria.setProjection(Projections.rowCount());
        List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(detachedCriteria);
        Long o = list.get(0);
        detachedCriteria.setProjection(null);
        return o.intValue();
    }

    @Override
    public List<Customer> getCustomerListByName(DetachedCriteria detachedCriteria, Integer start, Integer pageSize) {

        List<Customer> list = (List<Customer>) getHibernateTemplate().findByCriteria(detachedCriteria, start, pageSize);
        return list;
    }
}
