package com.ecom.api.product.domain.vo;

import com.ecom.api.shared.error.domain.Assert;

public record ProductPrice(double value) {

  public ProductPrice {
    Assert.field("value", value).min(0.1);
  }
}
