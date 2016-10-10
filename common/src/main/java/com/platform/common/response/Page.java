package com.platform.common.response;

import com.alibaba.fastjson.serializer.NameFilter;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xiaowu lei
 * Date: 13-12-27
 * Time: 上午9:25
 */
public abstract class Page<T> extends ResponseBody{
    private Long count;

    public Page() {
    }

    private Integer pageNumber;
    private Integer pageSize;
    private List<T> messages;

    public Page(Long count,Integer pageNumber,Integer pageSize){
        this.count=count;
        this.pageNumber=pageNumber;
        this.pageSize=pageSize;
    }

    public Page(Long count,Integer pageNumber,Integer pageSize,List<T> messages){
        this.count=count;
        this.pageNumber=pageNumber;
        this.pageSize=pageSize;
        this.messages=messages;
    }

    public List<T> getMessages() {
        return messages;
    }

    @Override
    public  List<NameFilter> nameFilters(){
        NameFilter listAlias= new NameFilter() {
            @Override
            public String process(Object object, String name, Object value) {
                if(listAlias()==null || listAlias().equals("")){
                    return name;
                }
                return name.equals("messages")?listAlias():name;  //To change body of implemented methods use File | Settings | File Templates.
            }
        };
        return Lists.newArrayList(listAlias);
    }

    protected abstract String listAlias();

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public void setMessages(List<T> messages) {
        this.messages = messages;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public static void main(String[]args){
//        Page page= new Page() {
//            @Override
//            protected String listAlias() {
//                return "messages";  //To change body of implemented methods use File | Settings | File Templates.
//            }
//
//        };
//        page.setCount("33");
//        page.setMessages(Lists.newArrayList("44", "55"));
//        JSONSerializer serializer = new JSONSerializer(new SerializeWriter());
//        serializer.getNameFilters().addAll(page.nameFilters()) ;
//                serializer.write(page);
//        System.out.println(serializer.toString());
    }
}