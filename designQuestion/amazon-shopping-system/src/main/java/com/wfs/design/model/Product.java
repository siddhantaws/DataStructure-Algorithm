package com.wfs.design.model;

public class Product {
  private String productID;
  private String name;
  private String description;
  private double price;
  private ProductCategory category;
  private int availableItemCount;

  private Account seller;

  public String getProductID() {
    return productID;
  }

  public void setProductID(String productID) {
    this.productID = productID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public ProductCategory getCategory() {
    return category;
  }

  public void setCategory(ProductCategory category) {
    this.category = category;
  }

  public int getAvailableItemCount() {
    return availableItemCount;
  }

  public void setAvailableItemCount(int availableItemCount) {
    this.availableItemCount = availableItemCount;
  }

  public Account getSeller() {
    return seller;
  }

  public void setSeller(Account seller) {
    this.seller = seller;
  }

  public int getAvailableCount(){
    return 0;
  }

  public boolean updatePrice(double newPrice){
    return false;
  }

}