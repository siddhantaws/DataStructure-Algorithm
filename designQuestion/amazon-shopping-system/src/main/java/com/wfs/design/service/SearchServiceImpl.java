package com.wfs.design.service;

import com.wfs.design.model.Product;

import java.util.HashMap;
import java.util.List;

public class SearchServiceImpl implements SearchService {
   HashMap<String, List<Product>> productNames;
   HashMap<String, List<Product>> productCategories;

  public List<Product> searchProductsByName(String name) {
    return productNames.get(name);
  }

  public List<Product> searchProductsByCategory(String category) {
    return productCategories.get(category);
  }
}