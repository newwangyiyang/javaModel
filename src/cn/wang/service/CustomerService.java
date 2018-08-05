package cn.wang.service;

import cn.wang.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface CustomerService {
    PageBean getPageBean(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize);
}
