package cn.wang.web.action;

import cn.wang.domain.Customer;
import cn.wang.domain.SaleVisite;
import cn.wang.service.SaleVisiteService;
import cn.wang.utils.PageBean;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.io.IOException;
import java.util.List;

public class SaleVisiteAction extends ActionSupport implements ModelDriven<SaleVisite>{
    private SaleVisiteService saleVisiteService;

    private SaleVisite saleVisite = new SaleVisite();
    private Integer currentPage;
    private Integer pageSize;

    public String save() throws Exception {
        saleVisiteService.save(saleVisite);
        return null;
    }

    public String list() throws IOException {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SaleVisite.class);
        detachedCriteria.add(Restrictions.eq("customer.cust_id", saleVisite.getCustomer().getCust_id()));

        PageBean pageBean = saleVisiteService.list(detachedCriteria, currentPage, pageSize);
        List<SaleVisite> list = pageBean.getList();
        for (SaleVisite visite : list) {
            visite.setCustomer(null);
            visite.setUser(null);
        }
        Gson gson = new Gson();
        String json = gson.toJson(pageBean.getList());

        ServletActionContext.getResponse().setContentType("application/json;charset=UTF-8");
        ServletActionContext.getResponse().getWriter().write(json);
        return null;
    }

    public SaleVisiteService getSaleVisiteService() {
        return saleVisiteService;
    }

    public void setSaleVisiteService(SaleVisiteService saleVisiteService) {
        this.saleVisiteService = saleVisiteService;
    }

    @Override
    public SaleVisite getModel() {
        return saleVisite;
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
}
