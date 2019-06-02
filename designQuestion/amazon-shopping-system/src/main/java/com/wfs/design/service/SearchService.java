package com.wfs.design.service;

import com.wfs.design.model.Product;

import java.util.List;

public interface SearchService {
  public List<Product> searchProductsByName(String name);
  public List<Product> searchProductsByCategory(String category);
}