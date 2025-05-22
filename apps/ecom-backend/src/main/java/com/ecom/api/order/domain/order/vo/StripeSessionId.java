package com.ecom.api.order.domain.order.vo;

import com.ecom.api.shared.error.domain.Assert;

public record StripeSessionId(String value) {

  public StripeSessionId {
    Assert.notNull("value", value);
  }
}
