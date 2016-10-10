package com.platform.common.httpclient;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * Created by ehl on 2016/6/5.
 */
public abstract  class HEAbstractHttpClient {
    private static String defaultUTF="utf-8";
    private static Charset UTF_8=Charset.forName(defaultUTF);
    private static int socket_timeout=120000;
    private static int connection_timeout=120000;
    private static final int DEFAULT_MAX_NUM_PER_ROUTE = 20;
    private static final int DEFAULT_MAX_TOTAL_NUM = 50;

    public static CloseableHttpClient getHttpClient(){

        HttpClientBuilder builder = HttpClients.custom();


        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();
        manager.setDefaultMaxPerRoute(DEFAULT_MAX_NUM_PER_ROUTE);
        manager.setMaxTotal(DEFAULT_MAX_TOTAL_NUM);
        builder.setConnectionManager(manager);
        builder.setMaxConnPerRoute(DEFAULT_MAX_NUM_PER_ROUTE);
        builder.setMaxConnTotal(DEFAULT_MAX_TOTAL_NUM);
        return builder.build();
    }

    private static RequestConfig getRequestConfig(){
        return RequestConfig.custom()
                .setSocketTimeout(socket_timeout)
                .setConnectTimeout(connection_timeout)
                .build();
    }

    protected static HttpGet getHttpGet(String url){
        return getHttpGet(url, null);
    }

    protected static HttpPost getStreamtpPost(String url, String body) {
        HttpPost post = new HttpPost(url);
        if(Strings.isNullOrEmpty(body)){
            post.setConfig(getRequestConfig());
            return post;
        }
        post.setEntity(new StringEntity(body, ContentType.create(ContentType.APPLICATION_JSON.getMimeType(),defaultUTF)));
        post.setConfig(getRequestConfig());
        return post;
    }
    protected static HttpGet getHttpGet(String url ,Map<String,Object> paramas){
        HttpGet get =  new HttpGet(buildGetUrl(url,paramas));
        get.setConfig(getRequestConfig());
        return get;
    }

    protected static HttpPost getFormHttpPost(String url){
        return getFormHttpPost(url,null);
    }
    protected static HttpPost getJsonHttpPost(String url){
        return getJsonHttpPost(url, null);
    }
    protected static HttpPost getJsonHttpPost(String url,Map<String,Object> params){
        HttpPost post = new HttpPost(url);
        HttpEntity entity = null;
        try {
            entity = buildStringPostEntity(params);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        if(null != entity){
            post.setEntity(entity);
        }
        post.setConfig(getRequestConfig());
        return post;
    }
    protected static HttpPost getHttpPost(String url,Map<String,Object> params,Header headers){
        HttpPost post = new HttpPost(url);
        HttpEntity entity = null;
        entity = buildPostEntity(params);
        post.setHeader(headers);
        if(null != entity){
            post.setEntity(entity);
        }
        post.setConfig(getRequestConfig());
        return post;
    }


    protected static HttpPost getFormHttpPost(String url,Map<String,Object> params){
        HttpPost post = new HttpPost(url);
        HttpEntity entity = null;
        entity = buildPostEntity(params);

        if(null != entity){
            post.setEntity(entity);
        }
        post.setConfig(getRequestConfig());
        return post;
    }
    private static HttpEntity buildStringPostEntity(Map<String,Object> params) throws UnsupportedEncodingException {
        if (params != null ) {
            System.out.println("===================="+JSONObject.toJSONString(params));
            return  new StringEntity(JSONObject.toJSONString(params),
                    ContentType.create(ContentType.APPLICATION_JSON.getMimeType(),defaultUTF));
        }
        return null;
    }
    private static HttpEntity buildPostEntity(Map<String,Object> params){
        if (params != null) {
            List<NameValuePair> formparams = Lists.newArrayList();
            for (String key : params.keySet()) {
                formparams.add(new BasicNameValuePair(key, params.get(key).toString()));
            }
            return  new UrlEncodedFormEntity(formparams, UTF_8);
        }
        return null;
    }
    private static String buildGetUrl(String url,Map<String,Object> params){
        StringBuffer uriStr = new StringBuffer(url);
        if (params != null) {
            List<NameValuePair> ps = Lists.newArrayList();
            for (String key : params.keySet()) {
                Object value=params.get(key);
                if(null == value){
                    continue;
                }
                ps.add(new BasicNameValuePair(key, value.toString()));
            }
            uriStr.append("?");
            uriStr.append(URLEncodedUtils.format(ps, UTF_8));
        }
        return uriStr.toString();
    }

    protected static void checkHeader(StatusLine line) throws Exception {
//        if(line.getStatusCode()!=HttpStatus.SC_OK){
//            throw new Exception(line.getReasonPhrase()+"\t"+line.getStatusCode());
//        }
    }

    protected static String toString(HttpEntity entity) throws IOException {
        return EntityUtils.toString(entity,UTF_8);
    }
}
