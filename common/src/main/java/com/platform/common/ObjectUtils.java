package com.platform.common;

import org.apache.commons.beanutils.BeanUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ehl on 2016/6/5.
 */
public class ObjectUtils {
    /**
     *
     * @return
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public static Map<String,Object> toMap(Object obj) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        if(obj == null)
            return null;

        Map<String, Object> map = new HashMap<String, Object>();

        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            if (key.compareToIgnoreCase("class") == 0) {
                continue;
            }
            Method getter = property.getReadMethod();
            Object value = getter!=null ? getter.invoke(obj) : null;
            map.put(key, value);
        }

        return map;
    }

    /**
     *
     * @param maps
     * @param obj
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static void toObj(Map<String,String> maps,Object obj) throws InvocationTargetException, IllegalAccessException {
        if(null == maps || maps.size()==0){
            return;
        }
        BeanUtils.populate(obj,maps);
    }
}
