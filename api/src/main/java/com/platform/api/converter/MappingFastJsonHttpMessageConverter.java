package com.platform.api.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.NameFilter;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.google.common.io.ByteStreams;
import com.platform.common.response.ResponseBody;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xiaowu lei
 * Date: 13-12-25
 * Time: 下午1:22
 */
public class MappingFastJsonHttpMessageConverter extends AbstractHttpMessageConverter<Object> {

    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    public MappingFastJsonHttpMessageConverter() {
        super(new MediaType("application", "json", DEFAULT_CHARSET));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        byte body[]= ByteStreams.toByteArray(inputMessage.getBody());
        return JSON.parseObject(body, clazz);
    }

    @Override
    protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String json="";
        if(o instanceof ResponseBody){
            ResponseBody body= (ResponseBody) o;
            JSONSerializer serializer = new JSONSerializer(new SerializeWriter());
            List<NameFilter> nameFilterList=body.nameFilters();
            if(null == nameFilterList|| nameFilterList.isEmpty() ){
                json=JSON.toJSONString(o);
            }else{
                serializer.getNameFilters().addAll(body.nameFilters()) ;
                serializer.write(body);
                json=serializer.toString();
            };
        }else{
            json=JSON.toJSONString(o);
        }

        outputMessage.getBody().write(json.getBytes(DEFAULT_CHARSET));
    }
}