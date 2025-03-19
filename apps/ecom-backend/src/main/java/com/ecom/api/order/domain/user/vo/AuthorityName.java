package com.ecom.api.order.domain.user.vo;

import com.ecom.api.shared.error.domain.Assert;

public record AuthorityName(String name) {

  public AuthorityName {
    Assert.field("name", name).notNull();
  }
}
