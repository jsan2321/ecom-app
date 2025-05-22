package com.ecom.api.order.domain.order.vo;

import com.ecom.api.shared.error.domain.Assert;

public record OrderPrice(double value) {

  public OrderPrice {
    Assert.field("value", value).strictlyPositive();
  }
}
