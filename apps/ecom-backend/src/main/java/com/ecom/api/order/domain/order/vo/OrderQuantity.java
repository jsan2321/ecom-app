package com.ecom.api.order.domain.order.vo;

import com.ecom.api.shared.error.domain.Assert;

public record OrderQuantity(long value) {

  public OrderQuantity {
    Assert.field("value", value).positive();
  }
}
