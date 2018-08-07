package cn.wang.service.impl;

import cn.wang.dao.UserDao;
import cn.wang.domain.User;
import cn.wang.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    @Override
    public void saveOrUpdate(User user) {
        userDao.saveOrUpdate(user);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
