package com.wfs.design.model;

import com.wfs.design.constant.OrderStatus;

import java.util.List;
import java.util.Map;

public class ShoppingCart {

  private Map<Item, Integer> items;

  public boolean addItem(Item item){
    items.put(item , items.get(item)+1);
    return true;
  }

  public boolean removeItem(Item item){
    items.put(item , items.get(item)-1);
    return true;
  }

  public boolean updateItemQuantity(Item item, int quantity){
    items.put(item  , quantity);
    return true;
  }

  public Map<Item,Integer> getItems(){
    return items;
  }

  public Order checkout(){
    Order.OrderBuilder builder =new Order.OrderBuilder();
    return builder.setItems((List<Item>) items.keySet()).setOrderStatus(OrderStatus.PENDING).buildOrder();
  }

}