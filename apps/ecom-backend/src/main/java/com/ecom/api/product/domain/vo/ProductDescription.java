package com.ecom.api.product.domain.vo;

import com.ecom.api.shared.error.domain.Assert;

public record ProductDescription(String value) {

  public ProductDescription {
    Assert.field("value", value).notNull().minLength(10);
  }
}
