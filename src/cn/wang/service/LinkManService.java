package cn.wang.service;

import cn.wang.domain.Customer;
import cn.wang.domain.LinkMan;

public interface LinkManService {
    void save(LinkMan linkMan, Long cust_id);
}
