package com.ecom.api.order.application;

import com.ecom.api.order.domain.order.aggregate.*;
import com.ecom.api.order.domain.order.service.CartReader;
import com.ecom.api.product.application.ProductsApplicationService;
import com.ecom.api.product.domain.aggregate.Product;
import com.ecom.api.product.domain.vo.PublicId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderApplicationService {

  private final ProductsApplicationService productsApplicationService;
  private final CartReader cartReader;
  private final UsersApplicationService usersApplicationService;

  public OrderApplicationService(ProductsApplicationService productsApplicationService,
                                 UsersApplicationService usersApplicationService) {
    this.productsApplicationService = productsApplicationService;
    this.usersApplicationService = usersApplicationService;
    this.cartReader = new CartReader();
  }

  @Transactional(readOnly = true)
  public DetailCartResponse getCartDetails(DetailCartRequest detailCartRequest) {
    List<PublicId> publicIds = detailCartRequest.items().stream().map(DetailCartItemRequest::productId).toList();
    List<Product> productsInformation = productsApplicationService.getProductsByPublicIdsIn(publicIds);
    return cartReader.getDetails(productsInformation);
  }

}
