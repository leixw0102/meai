package http;

import com.google.common.annotations.VisibleForTesting;
import com.platform.common.ObjectUtils;
import com.platform.common.httpclient.HEHttpClients;
import com.platform.domain.EnterpriseUser;

import java.util.Date;
import java.util.Map;

/**
 * Created by 雷晓武 on 2016/10/9.
 */
public class UserTest extends TestBase{

    @org.junit.Test
    public void testBuyerLoginTest() throws Exception {
        EnterpriseUser serviceOrder = new EnterpriseUser();

        serviceOrder.setAddressDetail("dsf");
        serviceOrder.setCompanyMail("dsf");
        serviceOrder.setContactName("22");
        serviceOrder.setCurrentCity(1L);
        serviceOrder.setEnterpriseName("sds");
        serviceOrder.setInstitutionCode("23");
        serviceOrder.setPassword("11");
        serviceOrder.setTime(new Date());
        serviceOrder.setUserName("df");
        Map<String,Object> maps= ObjectUtils.toMap(serviceOrder);
        String  json =  HEHttpClients.httpJsonPostExecute("http://localhost:9090/api/meai/enterprise/1.0/register", maps);
        System.out.println(json);
    }



//    public static void main(String[]args) throws Exception {
//        testBuyerLoginTest();
//    }


}
