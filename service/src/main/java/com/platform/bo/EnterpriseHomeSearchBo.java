package com.platform.bo;

import com.google.common.base.Strings;

import java.io.Serializable;

/**
 * Created by 雷晓武 on 2016/10/10.
 */
public class EnterpriseHomeSearchBo implements Serializable{

    private int pageSize=10;
    private int pageNumber=1;

    private String key ;

    private int cityId;

    public String whereSql(){
        String sql = "where 1=1 ";
        if(!Strings.isNullOrEmpty(getKey())){
            sql += " and enterprise_name like '%"+key+"%' ";
        }

        if(cityId>0){
            sql += " and current_city = "+cityId;
        }

        return sql + " limit "+(pageNumber-1)*pageSize + " , "+pageSize;
    }

    @Override
    public String toString() {
        return "EnterpriseHomeSearchBo{" +
                "pageSize=" + pageSize +
                ", pageNumber=" + pageNumber +
                ", key='" + key + '\'' +
                ", cityId=" + cityId +
                '}';
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
