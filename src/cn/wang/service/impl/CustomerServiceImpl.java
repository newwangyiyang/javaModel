package cn.wang.service.impl;

import cn.wang.dao.BaseDictDao;
import cn.wang.dao.CustomerDao;
import cn.wang.domain.BaseDict;
import cn.wang.domain.Customer;
import cn.wang.service.CustomerService;
import cn.wang.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;
    private BaseDictDao baseDictDao;
    @Override
    public PageBean getPageBean(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize) {
        //1、得到总记录数
        Integer totalCount = customerDao.getTotalCount(detachedCriteria);
        //2、得到PageBean对象
        PageBean pageBean = new PageBean(currentPage, pageSize, totalCount);
        //3、取得list<Customer>
        List<Customer> list = customerDao.getPageList(detachedCriteria, pageBean.getStart(), pageSize);

        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public void saveOrUpdate(Customer customer) {
        customerDao.saveOrUpdate(customer);
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public BaseDictDao getBaseDictDao() {
        return baseDictDao;
    }

    public void setBaseDictDao(BaseDictDao baseDictDao) {
        this.baseDictDao = baseDictDao;
    }
}
