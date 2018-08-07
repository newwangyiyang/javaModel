package cn.wang.web.action;

import cn.wang.domain.User;
import cn.wang.service.UserService;
import cn.wang.utils.MD5Utils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.junit.Test;

public class UserAction extends ActionSupport implements ModelDriven<User> {
    private UserService userService;

    private User user = new User();

    public String saveOrUpdate() {
        user.setUser_password(MD5Utils.md5(user.getUser_password()));
        userService.saveOrUpdate(user);
        return null;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User getModel() {
        return user;
    }

}
