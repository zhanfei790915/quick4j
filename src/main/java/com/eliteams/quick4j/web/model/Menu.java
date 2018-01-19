package com.eliteams.quick4j.web.model;

import java.io.Serializable;

public class Menu implements Serializable{
    
	private Integer id;

    private String mname;

    private String murl;

    private Integer pid;

    private String iconcode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname == null ? null : mname.trim();
    }

    public String getMurl() {
        return murl;
    }

    public void setMurl(String murl) {
        this.murl = murl == null ? null : murl.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getIconcode() {
        return iconcode;
    }

    public void setIconcode(String iconcode) {
        this.iconcode = iconcode == null ? null : iconcode.trim();
    }
    
    @Override
	public String toString() {
		return "Menu [id=" + id + ", mname=" + mname + ", murl=" + murl
				+ ", pid=" + pid + ", iconcode=" + iconcode + "]";
	}
}