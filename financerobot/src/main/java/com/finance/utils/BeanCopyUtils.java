package com.finance.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.stream.Collectors;

public class BeanCopyUtils {
    private BeanCopyUtils() {
    }
    public static <V> V copyBean(Object source, Class<V> clazz){
        //创建目标对象
        V target = null;
        try {
             target = clazz.newInstance();
            //实现属性copy
            BeanUtils.copyProperties(source,target);
            //返回目标对象
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return target;
    }
    public static <O,V> List<V> copyBeanList(List<O> list, Class<V> clazz){
        return list.stream().map(item -> copyBean(item,clazz))
                            .collect(Collectors.toList());
    }
}
