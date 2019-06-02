package com.wfs.design.model;

import com.wfs.design.constant.CustomerType;

public abstract class Customer {

  private CustomerType customerType;

  protected ShoppingCart shoppingCart;

  private Account account;

  public Customer(CustomerType customerType) {
    this.customerType = customerType;
  }

  private ShoppingCart cart;
  private Order order;

  public ShoppingCart getShoppingCart(){
    return shoppingCart;
  }
  public boolean addItemToCart(Item item){
    shoppingCart.addItem(item);
    return true;
  }

  public boolean removeItemFromCart(Item item){
    shoppingCart.removeItem(item);
    return true;
  }
}