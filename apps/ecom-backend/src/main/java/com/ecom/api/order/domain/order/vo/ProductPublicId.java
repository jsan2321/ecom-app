package com.ecom.api.order.domain.order.vo;

import com.ecom.api.shared.error.domain.Assert;

import java.util.UUID;

public record ProductPublicId(UUID value) {

  public ProductPublicId {
    Assert.notNull("value", value);
  }
}
