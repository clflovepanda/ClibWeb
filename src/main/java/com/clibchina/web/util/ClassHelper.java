package com.clibchina.web.util;

import com.clibchina.web.anno.Controller;
import com.clibchina.web.anno.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by changlifeng on 16/12/29.
 */
public class ClassHelper {

    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = "";
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    public static Set<Class<?>> getClassSet() {
        return CLASS_SET;
    }

    public static Set<Class<?>> getServiceClassSet() {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls : CLASS_SET) {
            if (cls.isAnnotationPresent(Service.class)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

    public static Set<Class<?>> getControllerClassSet() {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls : CLASS_SET) {
            if (cls.isAnnotationPresent(Controller.class)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

    public static Set<Class<?>> getBeanClassSet() {
        Set<Class<?>> beanCLassSet = new HashSet<Class<?>>();
        beanCLassSet.addAll(getServiceClassSet());
        beanCLassSet.addAll(getControllerClassSet());
        return beanCLassSet;
    }
}
