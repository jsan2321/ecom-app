package com.ecom.api.product.domain.repository;

import com.ecom.api.product.domain.aggregate.FilterQuery;
import com.ecom.api.product.domain.aggregate.Product;
import com.ecom.api.product.domain.vo.PublicId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

  Product save(Product productToCreate);

  Page<Product> findAll(Pageable pageable);

  int delete(PublicId publicId);

  Page<Product> findAllFeaturedProduct(Pageable pageable);

  Optional<Product> findOne(PublicId publicId);

  Page<Product> findByCategoryExcludingOne(Pageable pageable, PublicId categoryPublicId, PublicId productPublicId);

  Page<Product> findByCategoryAndSize(Pageable pageable, FilterQuery filterQuery);

  List<Product> findByPublicIds(List<PublicId> publicIds);

}
