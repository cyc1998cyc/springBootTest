package com.chen.service;

public interface AccountService {

    /**
     * 转账
     * @param from
     * @param to
     * @param money
     */
    void transfer(String from,String to,Integer money);
}
