package com.ecom.api.order.infrastructure.primary.order;

import com.ecom.api.order.application.OrderApplicationService;
import com.ecom.api.order.domain.order.aggregate.DetailCartItemRequest;
import com.ecom.api.order.domain.order.aggregate.DetailCartRequest;
import com.ecom.api.order.domain.order.aggregate.DetailCartRequestBuilder;
import com.ecom.api.order.domain.order.aggregate.DetailCartResponse;
import com.ecom.api.product.domain.vo.PublicId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderResource {

  private final OrderApplicationService orderApplicationService;

  @Value("${application.stripe.webhook-secret}")
  private String webhookSecret;

  public OrderResource(OrderApplicationService orderApplicationService) {
    this.orderApplicationService = orderApplicationService;
  }

  @GetMapping("/get-cart-details")
  public ResponseEntity<RestDetailCartResponse> getDetails(@RequestParam List<UUID> productIds) {
    List<DetailCartItemRequest> cartItemRequests = productIds.stream()
                                                             .map(uuid -> new DetailCartItemRequest(new PublicId(uuid), 1))
                                                             .toList();
    DetailCartRequest detailCartRequest = DetailCartRequestBuilder.detailCartRequest()
                                                                  .items(cartItemRequests)
                                                                  .build();
    DetailCartResponse cartDetails = orderApplicationService.getCartDetails(detailCartRequest);
    return ResponseEntity.ok(RestDetailCartResponse.from(cartDetails));
  }

}
