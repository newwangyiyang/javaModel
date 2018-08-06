package cn.wang.web.action;

import cn.wang.domain.Customer;
import cn.wang.domain.LinkMan;
import cn.wang.service.CustomerService;
import cn.wang.service.LinkManService;
import cn.wang.utils.PageBean;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.io.IOException;
import java.util.List;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {
    private LinkMan linkMan = new LinkMan();

    private Long custId;


    private LinkManService linkManService;
    private CustomerService customerService;

    public String save() throws Exception {
        linkManService.save(linkMan, custId);
        return null;
    }

    public String test() throws IOException {
        Customer customer = customerService.getById(custId);
        customer.setSet(null);
        System.out.println(customer.getCust_id());
        Gson gson = new Gson();
        String s = gson.toJson(customer);
        ServletActionContext.getResponse().getWriter().write(s);
        return null;
    }

    public String list() throws IOException {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LinkMan.class);
        detachedCriteria.add(Restrictions.like("lkm_name", "%" + linkMan.getLkm_name() + "%"));

        Customer customer = customerService.getById(custId);

        detachedCriteria.add(Restrictions.eq("customer.cust_id", customer.getCust_id()));

        PageBean pageBean = linkManService.list(detachedCriteria, 1, 3);
        ServletActionContext.getResponse().setContentType("application/json;charset=UTF-8");
        List<LinkMan> list = pageBean.getList();

        for (LinkMan man : list) {
            man.setCustomer(null);
        }
        System.out.println(pageBean.getList());
        Gson gson = new Gson();

        String json = gson.toJson(pageBean.getList()).toString();
        System.out.println(json);
        ServletActionContext.getResponse().getWriter().write(json);
        return null;
    }

    @Override
    public LinkMan getModel() {
        return linkMan;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public LinkManService getLinkManService() {
        return linkManService;
    }

    public void setLinkManService(LinkManService linkManService) {
        this.linkManService = linkManService;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
