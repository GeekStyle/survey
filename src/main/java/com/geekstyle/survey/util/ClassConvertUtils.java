package com.geekstyle.survey.util;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ClassConvertUtils {
    private ClassConvertUtils(){}


    public static Map<String,String> convertBeanToMap(Object model){
        HashMap<String, String> resultMap = new HashMap<>();
        Class beanClass = model.getClass();
        Field[] fields = beanClass.getDeclaredFields();
        Method[] methods = beanClass.getMethods();
        for(Method method:methods){
//            resultMap.put(field.getName().toLowerCase(),)
            if(method.getName().startsWith("get")){
                try {
                    Object obj = method.invoke(model);
                    System.out.println(method.getName());
                    if(obj != null)
                    resultMap.put(method.getName().toLowerCase().substring(3),obj.toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultMap;
    }

}
