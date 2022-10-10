package com.chen.spring.api;

import java.io.InputStream;

/**
 * 陈宇超
 * 22:45
 */
public interface Resource {

    /**
     * 通过文件流读取配置文件
     * @param config
     * @return
     */
    InputStream readXML(String config);

}
