package cn.wang.dao.impl;

import cn.wang.dao.CustomerDao;
import cn.wang.domain.Customer;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao{

    @Override
    public List industryCount() {
//        final String sql = "SELECT b.dict_item_name name, COUNT(*) total FROM cst_customer c, base_dict b WHERE c.cust_industry=b.dict_id GROUP BY c.cust_industry";
        final String sql = "SELECT b.dict_item_name name, COUNT(*) total FROM cst_customer c, base_dict b WHERE c.cust_source=b.dict_id GROUP BY c.cust_source";
        List list = getHibernateTemplate().execute(new HibernateCallback<List>() {
            @Override
            public List doInHibernate(Session session) throws HibernateException {
                SQLQuery sqlQuery = session.createSQLQuery(sql);
                return sqlQuery.list();
            }
        });
        return list;
    }
}
