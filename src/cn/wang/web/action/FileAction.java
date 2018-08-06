package cn.wang.web.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.File;

public class FileAction extends ActionSupport {
    private String name;
    private File file;
    private String fileFileName;
    private String fileContentType;


    //文件上传接口测试
    public String uploadFile() {
        ServletActionContext.getResponse().setHeader("Access-Control-Allow-Origin","*");
        System.out.println(name);
        System.out.println(fileContentType);
        System.out.println(fileFileName);
        file.renameTo(new File("E:/javaTest/"+fileFileName+""));
        return null;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }
}
