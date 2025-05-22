package com.ecom.api.order.domain.order.service;

import com.ecom.api.order.domain.order.aggregate.DetailCartResponse;
import com.ecom.api.order.domain.order.aggregate.DetailCartResponseBuilder;
import com.ecom.api.product.domain.aggregate.Product;
import com.ecom.api.product.domain.aggregate.ProductCart;

import java.util.List;

public class CartReader {

  public CartReader() {
  }

  public DetailCartResponse getDetails(List<Product> products) {
    List<ProductCart> cartProducts = products.stream()
                                             .map(ProductCart::from)
                                             .toList();
    return DetailCartResponseBuilder.detailCartResponse()
                                    .products(cartProducts)
                                    .build();
  }
}
