package cn.wang.service;

import cn.wang.domain.SaleVisite;
import cn.wang.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface SaleVisiteService {
    void save(SaleVisite saleVisite);
    PageBean list(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize);
}
