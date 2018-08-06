package cn.wang.service;

import cn.wang.domain.Customer;
import cn.wang.domain.LinkMan;
import cn.wang.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface LinkManService {
    void save(LinkMan linkMan, Long cust_id);
    PageBean list(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize);
}
