package cn.wang.web.action;

import cn.wang.domain.LinkMan;
import cn.wang.service.LinkManService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {
    private LinkMan linkMan = new LinkMan();

    private Long custId;

    private LinkManService linkManService;

    public String save() throws Exception {
        linkManService.save(linkMan, custId);
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
}
