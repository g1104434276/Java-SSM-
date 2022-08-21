package com.glk.spring5.Myspring;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class MyAnnotationConfigApplicationContext {
    private Map<String,Object> ioc = new HashMap<String, Object>();

    public MyAnnotationConfigApplicationContext(String pack) {
        //遍历包.获取包下的所有类(原材料)
        Set<BeanDefinition> beanDefinitions = findBeanDefinitions(pack);

        //根据原材料来动态的创建bean
        createObject(beanDefinitions);

        //自动装载
        autowireObject(beanDefinitions);

    }

    public void autowireObject(Set<BeanDefinition> beanDefinitions){
        Iterator<BeanDefinition> iterator = beanDefinitions.iterator();
        while (iterator.hasNext()){
            BeanDefinition beanDefinition = iterator.next();
            Class clazz = beanDefinition.getBeanClass();
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field declaredField:declaredFields){
                Autowired annotation = declaredField.getAnnotation(Autowired.class);
                if (annotation != null){
                    Qualifier qualifier = declaredField.getAnnotation(Qualifier.class);
                    if (qualifier != null){
                        //byName
                        String value = qualifier.value();
                        Object bean = getBean(value);

                        String methodName = "set" + declaredField.getName().substring(0, 1).toUpperCase() + declaredField.getName().substring(1);
                        try {
                            Method method = clazz.getMethod(methodName, declaredField.getType());
                            Object object = getBean(beanDefinition.getBeanName());

                            try {

                                method.invoke(object, bean);

                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        }


                    }else {
                        //byType

                    }
                }
            }
        }

    }


    public Object getBean(String beanName){
        return ioc.get(beanName);
    }

    public void createObject(Set<BeanDefinition> beanDefinitions){
        Iterator<BeanDefinition> iterator = beanDefinitions.iterator();
        while (iterator.hasNext()){
            BeanDefinition beanDefinition = iterator.next();
            Class clazz = beanDefinition.getBeanClass();
            String beanName = beanDefinition.getBeanName();
            try {
                //创建的对象
                Object object = clazz.getConstructor().newInstance();
                //完成属性的赋值
                Field[] declaredFields = clazz.getDeclaredFields();
                for (Field declaredField : declaredFields){
                    //判断属性上是否存在注解
                    Value valueAnnotation = declaredField.getAnnotation(Value.class);
                    if (valueAnnotation != null){
                        //获取注解上的值
                        String value = valueAnnotation.value();
                        String name = declaredField.getName();
                        String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                        Method method = clazz.getMethod(methodName, declaredField.getType());

                        //完成数据类型的转换
                        Object val = null;
                        switch (declaredField.getType().getName()){
                            case "java.lang.Integer" :
                                val = Integer.parseInt(value);
                                break;
                            case "java.lang.String" :
                                val = value;
                                break;
                            case "java.lang.Float" :
                                val = Float.parseFloat(value);
                                break;
                        }
                        method.invoke(object, val);
                    }



                }
                //赋值完成后存入缓存
                ioc.put(beanName, object);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

        }
    }


    public Set<BeanDefinition> findBeanDefinitions(String pack){
        //1. 获取包下的所有类
        Set<Class<?>> classes = MyTools.getClasses(pack);
        Iterator<Class<?>> iterator = classes.iterator();
        Set<BeanDefinition> beanDefinitions = new HashSet<BeanDefinition>();
        while (iterator.hasNext()) {
            //2. 遍历这些类,找到添加了注解的类
            Class<?> clazz = iterator.next();
            Component componentAnnotation = clazz.getAnnotation(Component.class);
            if (componentAnnotation != null){
                //获取Component注解的值
                String beanName = componentAnnotation.value();
                if ("".equals(beanName)){
                    //获取类目的首字母小写
                    String packed = clazz.getPackage().getName()+".";
                    String name = clazz.getName();
                    String replace = name.replace(packed, "");
                    beanName = replace.substring(0, 1).toLowerCase() + replace.substring(1);
                }
                //将这些类装载到BeanDefinition,装载到集合中
                BeanDefinition beanDefinition = new BeanDefinition(beanName, clazz);
                beanDefinitions.add(beanDefinition);
            }

        }
        //3. 将这些类封装成BeanDefinition
        return beanDefinitions;
    }
}
