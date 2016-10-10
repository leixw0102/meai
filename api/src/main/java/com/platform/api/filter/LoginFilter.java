package com.platform.api.filter;


import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 过滤GZIP请求的数据
 */
public class LoginFilter implements Filter {

    private static final Logger sLogger = LoggerFactory.getLogger(LoginFilter.class);

    private static final String DEFAULT_CHARSET = "utf-8";
    ApplicationContext applicationContext;
    
//    private UserService userService;
    private String mCharset;

    /**
     * 初始化传输内容的编码
     */
    @Override
    public void init(FilterConfig config) throws ServletException {
//        sLogger.debug("LoginFilter.init");
//        String charset = config.getInitParameter("charset");
//        if (Strings.isNullOrEmpty(charset) || !Charset.isSupported(charset)) {
//            mCharset = DEFAULT_CHARSET;
//        } else {
//            mCharset = charset;
//        }
//        applicationContext=WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
//        userService = applicationContext.getBean(UserService.class);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
    	   if (req instanceof HttpServletRequest) {
        	
	    	//  req.setCharacterEncoding("utf-8");
	          //resp.setCharacterEncoding("utf-8");
	          //resp.setContentType("text/json;charset=".concat("utf-8")); 
            HttpServletRequest request = (HttpServletRequest) req;
            String type = request.getHeader("type");
               sLogger.error("type =="+type);
//            if(!"wx".equals(type)){
//                String userkey =request.getHeader("x-haier-accesstoken");//登录前，或未取得key时，输入空字符串
//                int u =Integer.parseInt(Strings.isNullOrEmpty(request.getHeader("u"))?"000":request.getHeader("u"));
//                String t =request.getHeader("t");
//                String m =request.getHeader("m");
//                HttpServletResponse response = (HttpServletResponse) resp;
//                String reqUri =request.getRequestURI();
//                sLogger.info("reqUri:"+reqUri+ "\t"+u+"\t"+m+"\t"+t+"\t"+userkey);
//                if (Token.isValid(userkey,t,m)) {
//                    if (reqUri.equals("/api/haier/1.0/user/register")
//                            || reqUri.equals("/api/haier/1.0/user/login")){
//                        //not check token
//                    }else{
//                        if (userService.IsValidAccess(userkey,u,t,m)==false){
//                            JSONObject returnJson = new JSONObject();
//                            returnJson.put("code", 2121);
//                            returnJson.put("msg", "user key is not valid");
//                            returnInfo(request, response, 200, returnJson.toString());
//                            return;
//                        }
//                    }
//                }else{
//                    JSONObject returnJson = new JSONObject();
//                    returnJson.put("code", 2001);
//                    returnJson.put("msg", "t and m is not valid");
//                    returnInfo(request, response, 200, returnJson.toString());
//                    return;
//                }
//            }
            chain.doFilter(req, resp);
        } 
    }
       
    protected void returnInfo(HttpServletRequest request, HttpServletResponse response, int httpStatusCode, String returnInfo) throws IOException {
        response.setStatus(httpStatusCode);
        if (returnInfo != null && returnInfo.trim().length() > 0) {
            PrintWriter out = response.getWriter();
           // logger.info("返回终端数据：" + returnInfo);
            out.print(returnInfo);
            out.flush();
            out.close();
        } else {
         //   logger.info("本次请求无返回数据！");
        }
    }

    @Override
    public void destroy() {
    }

    /**
     * 自定义的Request，以便使用GZIP格式读取客户端上报的数据
     */
    class GzipHttpServletRequest extends HttpServletRequestWrapper {

        public GzipHttpServletRequest(HttpServletRequest request) throws IOException {
            super(request);
            request.setCharacterEncoding(mCharset);
        }

        /**
         * 返回GZIP格式的数据流对象
         */
        @Override
        public ServletInputStream getInputStream() throws IOException {
            return new GzipInputStream((HttpServletRequest) getRequest());
        }

    }

    /**
     * 自定义输入流，采用GZIP方式来读取数据
     */
    class GzipInputStream extends ServletInputStream {

        private GZIPInputStream stream;

        public GzipInputStream(HttpServletRequest req) throws IOException {
            this.stream = new GZIPInputStream(req.getInputStream());
        }

        @Override
        public int read() throws IOException {
            return stream.read();
        }

        @Override
        public int read(byte[] b, int off, int len) throws IOException {
            return stream.read(b, off, len);
        }

        @Override
        public void close() throws IOException {
            stream.close();
        }

    }

    /**
     * 自定义Response，以便使用GZIP格式向客户端传输数据
     */
    class GzipHttpServletResponse extends HttpServletResponseWrapper {

        public GzipHttpServletResponse(HttpServletResponse response) {
            super(response);
        }

        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            return new GzipOutputStream((HttpServletResponse) getResponse());
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            return new PrintWriter(new OutputStreamWriter(getOutputStream(), mCharset));
        }

    }

    /**
     * 自定义输出流，采用GZIP方式往客户端返回数据
     */
    class GzipOutputStream extends ServletOutputStream {

        private GZIPOutputStream stream;

        public GzipOutputStream(HttpServletResponse resp) throws IOException {
            resp.setCharacterEncoding(mCharset);
            resp.setContentType("text/json;charset=".concat(mCharset));
            resp.setHeader("content-encoding", "gzip");

            this.stream = new GZIPOutputStream(resp.getOutputStream());
        }

        @Override
        public void write(int b) throws IOException {
            stream.write(b);
        }

        @Override
        public void write(byte[] b, int off, int len) throws IOException {
            stream.write(b, off, len);
        }

        @Override
        public void flush() throws IOException {
            stream.flush();
        }

        @Override
        public void close() throws IOException {
            stream.close();
        }

    }
}
