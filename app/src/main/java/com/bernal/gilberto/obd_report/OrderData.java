package com.bernal.gilberto.obd_report;

/**
 * Created by Registered User on 4/18/2017.
 */

public class OrderData {
    public   String OrderDate;
    public   ProductData[] products;
    public   int OrderTotal;
    public   String OrderFecha;
    public   String OrderCustomer;
    public   String OrderAddress1;
    public   String OrderAddress2;
    public   String OrderTelephone;
    public   String OrderComments;
    public   String OrderStatus;
    public   String orderStatusFecha;

    public OrderData() { }

    public OrderData(String OrderDate, ProductData [] products, int OrderTotal, String OrderFecha,
                     String OrderCustomer, String OrderAddress1, String OrderAddress2,
                     String OrderTelephone, String OrderComments, String OrderStatus,String orderStatusFecha) {

        this.OrderDate = OrderDate;
        this.products =  products;
        this.OrderTotal  = OrderTotal;
        this.OrderFecha  = OrderFecha;
        this.OrderCustomer  = OrderCustomer;
        this.OrderAddress1  = OrderAddress1;
        this.OrderAddress2  = OrderAddress2;
        this.OrderTelephone  = OrderTelephone;
        this.OrderComments  = OrderComments;
        this.OrderStatus  = OrderStatus;
        this.orderStatusFecha  = orderStatusFecha;
    }

    public String getOrderDate() { return OrderDate;  }
    public ProductData [] getproducts(){return  products;}
    public int getOrderTotal() { return OrderTotal;}
    public String getOrderFecha() { return OrderFecha;}
    public String getOrderCustomer() {return OrderCustomer;}
    public String getOrderAddress1() {return OrderAddress1;}
    public String getOrderAddress2() {return OrderAddress2;}
    public String getOrderTelephone() {return OrderTelephone;}
    public String getOrderComments() {return OrderComments;}
    public String getOrderStatus() {return OrderStatus;}
    public String getOrderStatusFecha() {return OrderFecha;}
}
