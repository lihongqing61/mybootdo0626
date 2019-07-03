package com.bootdo.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: lihq
 * @Date: 2019/7/2 22:30
 * @Description:
 */
public class PropertiesUtil {

    public static String getValue(String key){
        Properties prop = new Properties();
        InputStream in = new PropertiesUtil().getClass().getResourceAsStream("/prop.properties");
        try {
            prop.load(in);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }

    public static void main(String[] args) {
        System.out.println(getValue("pName"));
    }
}
