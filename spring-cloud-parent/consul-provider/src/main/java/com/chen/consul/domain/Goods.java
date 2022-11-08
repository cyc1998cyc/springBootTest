package com.chen.consul.domain;

import java.io.Serializable;

/**
 * 陈宇超
 * 1:06
 */
public class Goods implements Serializable {
    private Integer goodsId;
    private String title;
    private double price;
    private Integer stock;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Goods() {
    }

    public Goods(Integer goodsId, String title, double price, Integer stock) {
        this.goodsId = goodsId;
        this.title = title;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
