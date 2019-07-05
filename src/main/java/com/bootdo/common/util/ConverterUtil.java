package com.bootdo.common.util;

import org.springframework.beans.BeanUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lihq
 * @Date: 2019/5/23 14:21
 * @Description:
 */
public class ConverterUtil {


    /**
     * List集合深度复制
     * @param srcList    原集合
     * @param destClass  目标类型
     * @return
     */
    public static List copyList(List<? extends Object> srcList, Class destClass) {

        List destList = new ArrayList();

        Object destObj = null;
        for (Object srcObj : srcList) {
            try {
                destObj = destClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            BeanUtils.copyProperties(srcObj, destObj);
            destList.add(destObj);
        }
        return destList;

    }

}
