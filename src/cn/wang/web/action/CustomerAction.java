package cn.wang.web.action;

import cn.wang.domain.BaseDict;
import cn.wang.domain.Customer;
import cn.wang.service.BaseDictService;
import cn.wang.service.CustomerService;
import cn.wang.utils.PageBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
    private Customer customer = new Customer();

    private String custSourceId;
    private Integer currentPage;
    private Integer pageSize;

    private CustomerService customerService;

    public String list() throws IOException {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
        if(StringUtils.isNotBlank(customer.getCust_name())) {
            detachedCriteria.add(Restrictions.like("cust_name", "%" + customer.getCust_name() + "%"));
        }
        PageBean pageBean = customerService.getPageBean(detachedCriteria, currentPage, pageSize);


        String json = JSON.toJSONString(pageBean.getList(), SerializerFeature.DisableCircularReferenceDetect);
        ServletActionContext.getResponse().setContentType("application/json;charset=UTF-8");
        ServletActionContext.getResponse().getWriter().write(json);
        return null;
    }

    public String save() throws Exception {
        //问题关键点
//        System.out.println(cust_source);
        /********************************************/
        ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
        customerService.saveCustomer(customer);
        ServletActionContext.getResponse().getWriter().write("添加成功");
        return null;
    }

    public String industryCount() throws IOException {
        List list = customerService.industryCount();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        ServletActionContext.getResponse().setContentType("application/json;charset=UTF-8");
        ServletActionContext.getResponse().getWriter().write(json);
        return null;
    }

    public String saveOrUpdate() {
        customerService.saveOrUpdate(customer);
        return null;
    }

    @Override
    public Customer getModel() {
        return customer;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCustSourceId() {
        return custSourceId;
    }

    public void setCustSourceId(String custSourceId) {
        this.custSourceId = custSourceId;
    }
}
