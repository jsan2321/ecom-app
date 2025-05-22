package com.ecom.api.order.domain.order.aggregate;

import com.ecom.api.product.domain.vo.PublicId;
import org.jilt.Builder;

@Builder
public record DetailCartItemRequest(PublicId productId, long quantity) {
}
