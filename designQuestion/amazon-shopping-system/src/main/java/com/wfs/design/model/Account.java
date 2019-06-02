package com.wfs.design.model;

import com.wfs.design.constant.AccountStatus;
import com.wfs.design.constant.Address;
import com.wfs.design.service.ProductService;

import java.util.List;

public class Account {
  private String userName;
  private String password;
  private AccountStatus status;
  private String name;
  private List<Address> shippingAddress;
  private String email;
  private String phone;

  private List<PaymentType> paymentTypes;

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }

  public AccountStatus getStatus() {
    return status;
  }

  public String getName() {
    return name;
  }

  public List<Address> getShippingAddress() {
    return shippingAddress;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

  public List<PaymentType> getPaymentTypes() {
    return paymentTypes;
  }

  public ProductService getProductService() {
    return productService;
  }

  private ProductService productService;

  public boolean addProduct(Product product){
    return productService.addProduct(product);
  }

  public boolean addProductReview(ProductReview review){
    return true;
  }

  public boolean resetPassword(){
    return true;
  }
}