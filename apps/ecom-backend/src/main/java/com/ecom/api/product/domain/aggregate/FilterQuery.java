package com.ecom.api.product.domain.aggregate;

import com.ecom.api.product.domain.vo.ProductSize;
import com.ecom.api.product.domain.vo.PublicId;
import org.jilt.Builder;

import java.util.List;

@Builder
public record FilterQuery(PublicId categoryId, List<ProductSize> sizes) {
}
