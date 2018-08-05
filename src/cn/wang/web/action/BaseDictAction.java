package cn.wang.web.action;

import cn.wang.domain.BaseDict;
import cn.wang.service.BaseDictService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.util.List;

public class BaseDictAction extends ActionSupport {
    private String code;
    private BaseDictService baseDictService;
    @Override
    public String execute() throws Exception {
        List<BaseDict> listByTypeCode = baseDictService.getListByTypeCode(code);
        Gson gson = new Gson();
        String json = gson.toJson(listByTypeCode).toString();
        ServletActionContext.getResponse().setContentType("application/json;charset=UTF-8");
        ServletActionContext.getResponse().getWriter().write(json);
        return null;//struts不需要对结果进行处理
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BaseDictService getBaseDictService() {
        return baseDictService;
    }

    public void setBaseDictService(BaseDictService baseDictService) {
        this.baseDictService = baseDictService;
    }
}
