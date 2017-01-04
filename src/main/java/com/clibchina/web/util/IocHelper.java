package com.clibchina.web.util;

import com.clibchina.web.anno.Inject;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by changlifeng on 16/12/29.
 */
public class IocHelper {
    static {
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (beanMap != null && beanMap.size() > 0) {
            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                Field[] beanFields = beanClass.getDeclaredFields();
                if (beanFields != null && beanFields.length > 0) {
                    for (Field beanField : beanFields) {
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance != null) {
                                ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
