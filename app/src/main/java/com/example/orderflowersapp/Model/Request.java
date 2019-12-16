package com.example.orderflowersapp.Model;

import java.util.List;

public class Request {
    private String phone;
    private String name;
    private String address;
    private String total;
    private List<Order> flowers; //list of flower orders

    public Request() {
    }

    public Request(String phone, String name, String address, String total, List<Order> flowers) {
        this.phone = phone;
        this.name = name;
        this.address = address;
        this.total = total;
        this.flowers = flowers;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Order> getFlowers() {
        return flowers;
    }

    public void setFlowers(List<Order> flowers) {
        this.flowers = flowers;
    }
}
