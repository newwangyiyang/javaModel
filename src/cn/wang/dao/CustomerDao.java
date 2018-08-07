package cn.wang.dao;

import cn.wang.domain.Customer;

import java.util.List;


public interface CustomerDao extends BaseDao<Customer> {
    List industryCount();
}
