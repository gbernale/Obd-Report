package com.bernal.gilberto.obd_report;

public class OrderData {
    public String orderDate;
    public OrderProductData[] products;
    public int orderTotal;
    public String orderFecha;
    public String orderCustomer;
    public String orderAddress1;
    public String orderAddress2;
    public String orderTelephone;
    public String orderComments;
    public String orderStatus;
    public String orderStatusFecha;

    public OrderData(String orderDate, OrderProductData[] products, int orderTotal, String orderFecha,
                     String orderCustomer, String orderAddress1, String orderAddress2,
                     String orderTelephone, String orderComments, String orderStatus, String orderStatusFecha) {

        this.orderDate = orderDate;
        this.products = products;
        this.orderTotal = orderTotal;
        this.orderFecha = orderFecha;
        this.orderCustomer = orderCustomer;
        this.orderAddress1 = orderAddress1;
        this.orderAddress2 = orderAddress2;
        this.orderTelephone = orderTelephone;
        this.orderComments = orderComments;
        this.orderStatus = orderStatus;
        this.orderStatusFecha = orderStatusFecha;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public OrderProductData[] getProducts() {
        return products;
    }

    public int getOrderTotal() {
        return orderTotal;
    }

    public String getOrderFecha() {
        return orderFecha;
    }

    public String getOrderCustomer() {
        return orderCustomer;
    }

    public String getOrderAddress1() {
        return orderAddress1;
    }

    public String getOrderAddress2() {
        return orderAddress2;
    }

    public String getOrderTelephone() {
        return orderTelephone;
    }

    public String getOrderComments() {
        return orderComments;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public String getOrderStatusFecha() {
        return orderStatusFecha;
    }
}
