package cn.wang.service.impl;

import cn.wang.dao.SaleVisiteDao;
import cn.wang.domain.SaleVisite;
import cn.wang.service.SaleVisiteService;
import cn.wang.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class SaleVisiteServiceImpl implements SaleVisiteService {
    private SaleVisiteDao saleVisiteDao;

    @Override
    public void save(SaleVisite saleVisite) {
        saleVisiteDao.save(saleVisite);
    }

    @Override
    public PageBean list(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize) {
        Integer totalCount = saleVisiteDao.getTotalCount(detachedCriteria);
        PageBean pageBean = new PageBean(currentPage, pageSize, totalCount);
        List<SaleVisite> list = saleVisiteDao.getPageList(detachedCriteria, pageBean.getStart(), pageSize);
        pageBean.setList(list);
        return pageBean;
    }

    public SaleVisiteDao getSaleVisiteDao() {
        return saleVisiteDao;
    }

    public void setSaleVisiteDao(SaleVisiteDao saleVisiteDao) {
        this.saleVisiteDao = saleVisiteDao;
    }
}
