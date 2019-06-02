package com.wfs.design.model;

import com.wfs.design.constant.OrderStatus;

import java.util.Date;
import java.util.List;

public class Order {
    private String orderNumber;
    private OrderStatus status;
    private Date orderDate;
    private List<OrderLog> orderLog;
    private List<Item> items;

    public Order(String orderNumber, List<Item> items) {
        this.orderNumber = orderNumber;
        this.items = items;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderLog> getOrderLog() {
        return orderLog;
    }

    public void setOrderLog(List<OrderLog> orderLog) {
        this.orderLog = orderLog;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public boolean sendForShipment() {
        return true;
    }

    public boolean addOrderLog(OrderLog orderLog) {
        this.orderLog.add(orderLog);
        return true;
    }

    static class OrderBuilder {
        List<Item> items;
        String orderNumber;
        OrderStatus orderStatus;

        public OrderBuilder setItems(List<Item> items) {
            this.items = items;
            return this;
        }

        public OrderBuilder setOrderNumber(String orderNumber) {
            this.orderNumber = orderNumber;
            return this;
        }


        public OrderBuilder setOrderStatus(OrderStatus orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public Order buildOrder(){
            Order order=new Order(this.getOrderNumber(), this.items);
            order.orderDate =new Date();
            return order;
        }
        private String getOrderNumber(){
            return "";
        }
    }
}