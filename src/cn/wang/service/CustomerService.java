package cn.wang.service;

import cn.wang.domain.Customer;
import cn.wang.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface CustomerService {
    PageBean getPageBean(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize);
    void saveCustomer(Customer customer);
    void saveOrUpdate(Customer customer);
    Customer getById(Long id);
    List industryCount();
}
