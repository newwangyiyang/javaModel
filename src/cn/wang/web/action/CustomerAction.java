package cn.wang.web.action;

import cn.wang.domain.Customer;
import cn.wang.service.CustomerService;
import cn.wang.utils.PageBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
    private Customer customer = new Customer();
    private Integer currentPage;
    private Integer pageSize;

    private CustomerService customerService;

    public String list() {
        System.out.println("world");
        System.out.println(currentPage);
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
        System.out.println(customer);
        if(StringUtils.isNotBlank(customer.getCust_name())) {
            detachedCriteria.add(Restrictions.like("cust_name", "%" + customer.getCust_name() + "%"));
        }
        PageBean pageBean = customerService.getPageBean(detachedCriteria, currentPage, pageSize);

        System.out.println(pageBean.getTotalCount());
        System.out.println(pageBean.getList());
        return SUCCESS;
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
}
