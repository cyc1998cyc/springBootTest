package com.chen.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

@Component
public class OrderEvent extends ApplicationEvent {

    private String orderId;

    private String userName;

    public OrderEvent(Object source, String orderId, String userName) {
        super(source);
        this.orderId = orderId;
        this.userName = userName;
    }

    public OrderEvent(Object source) {
        super(source);
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
