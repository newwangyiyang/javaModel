package cn.wang.service.impl;

import cn.wang.dao.CustomerDao;
import cn.wang.dao.LinkManDao;
import cn.wang.domain.Customer;
import cn.wang.domain.LinkMan;
import cn.wang.service.LinkManService;

public class LinkManServiceImpl implements LinkManService {
    private LinkManDao linkManDao;
    private CustomerDao customerDao;
    @Override
    public void save(LinkMan linkMan, Long cust_id) {
        Customer customer = customerDao.getById(cust_id);
        linkMan.setCustomer(customer);
        linkManDao.saveOrUpdate(linkMan);
    }

    public LinkManDao getLinkManDao() {
        return linkManDao;
    }

    public void setLinkManDao(LinkManDao linkManDao) {
        this.linkManDao = linkManDao;
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}
