package com.wfs.design.constant;

public enum CustomerType {
    GUEST("Guest") ,MEMBER("Member");

    String customerType;
    CustomerType(String customerType){
        this.customerType= customerType;
    }

}
