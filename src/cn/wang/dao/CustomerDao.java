package cn.wang.dao;

import cn.wang.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface CustomerDao {
    Integer getTotalCount(DetachedCriteria detachedCriteria);
    List<Customer> getCustomerListByName(DetachedCriteria detachedCriteria, Integer start, Integer pageSize);
}
