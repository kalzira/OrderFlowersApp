package com.example.orderflowersapp.Model;

import java.util.List;

public class Request {
    private String phone;
    private String name;
    private String address;
    private String total;
    private String status;
    private List<Order> flowers; //list of flower orders

    public Request() {
    }

    public Request(String phone, String name, String address, String total, List<Order> flowers) {
        this.phone = phone;
        this.name = name;
        this.address = address;
        this.total = total;
        this.flowers = flowers;
        this.status ="0"; //Default is 0 - placed, 1-shipping, 2-shipped
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
