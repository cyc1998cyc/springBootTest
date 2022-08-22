package com.chen;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 陈宇超
 * 10:31
 */
public class Boy {
    @Autowired(required = false)
    private Pet pet;

    @Autowired
    private Address address;

    public Boy(Pet pet) {
        this.pet = pet;
    }

    /**
     * Autowired 可以注解在构造方法中
     * @param pet
     * @param address
     */
    @Autowired
    public Boy(Pet pet, Address address) {
        this.pet = pet;
        this.address = address;
    }

    public Pet getPet() {
        return pet;
    }

    @Autowired
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Address getAddress() {
        return address;
    }

    /**
     * @Autowired 也可以用到setter方法上
     * @param address
     */
    @Autowired
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "pet=" + pet +
                ", address=" + address +
                '}';
    }
}
