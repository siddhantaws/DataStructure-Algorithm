package com.design.pattern.strategy;

public class StatergyDesignPattern {
    public static void main(String[] args) {

        CartService cartService =new CartService();
        cartService.setPaymentStatergy(new CreditcardPaymentStatergy("Siddhanta","7411516220","248"));
        cartService.pay(1500);
    }
}
