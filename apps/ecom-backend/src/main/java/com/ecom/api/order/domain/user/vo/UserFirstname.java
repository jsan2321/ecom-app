package com.ecom.api.order.domain.user.vo;

import com.ecom.api.shared.error.domain.Assert;

public record UserFirstname(String value) {

  public UserFirstname {
    Assert.field("value", value).maxLength(255);
  }
}
