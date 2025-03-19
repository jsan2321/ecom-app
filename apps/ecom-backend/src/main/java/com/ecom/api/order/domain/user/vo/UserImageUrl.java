package com.ecom.api.order.domain.user.vo;

import com.ecom.api.shared.error.domain.Assert;

public record UserImageUrl(String value) {

  public UserImageUrl {
    Assert.field("value", value).maxLength(1000);
  }
}
