package http;

import com.platform.common.Md5Func;

/**
 * 单元测试类的基类，主要用于启动Jetty服务器，测试用例资源的初始化和释放
 */
public class TestBase {

    protected static String getTokenM(String t,String userKey) {
    	String lastChar = t.substring(t.length()-1,t.length());//取最后一个字符
    	int i=Integer.parseInt(lastChar);
    	String md5String = userKey +t.substring(i);
    	return Md5Func.md5(md5String.getBytes());//求md5值
    }
}
