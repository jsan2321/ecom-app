package com.ecom.api.product.application;

import com.ecom.api.product.domain.aggregate.Category;
import com.ecom.api.product.domain.aggregate.Product;
import com.ecom.api.product.domain.repository.CategoryRepository;
import com.ecom.api.product.domain.repository.ProductRepository;
import com.ecom.api.product.domain.service.CategoryCRUD;
import com.ecom.api.product.domain.service.ProductCRUD;
import com.ecom.api.product.domain.service.ProductShop;
import com.ecom.api.product.domain.vo.PublicId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductsApplicationService {

  private ProductCRUD productCRUD;
  private CategoryCRUD categoryCRUD;
  private ProductShop productShop;

  public ProductsApplicationService(ProductRepository productRepository, CategoryRepository categoryRepository) {
    this.productCRUD = new ProductCRUD(productRepository);
    this.categoryCRUD = new CategoryCRUD(categoryRepository);
    this.productShop = new ProductShop(productRepository);
  }

  @Transactional
  public Product createProduct(Product newProduct) {
    return productCRUD.save(newProduct);
  }

  @Transactional(readOnly = true)
  public Page<Product> findAllProduct(Pageable pageable) {
    return productCRUD.findAll(pageable);
  }

  @Transactional
  public PublicId deleteProduct(PublicId publicId) {
    return productCRUD.delete(publicId);
  }

  @Transactional
  public Category createCategory(Category category) {
    return categoryCRUD.save(category);
  }

  @Transactional
  public PublicId deleteCategory(PublicId publicId) {
    return categoryCRUD.delete(publicId);
  }

  @Transactional(readOnly = true)
  public Page<Category> findAllCategory(Pageable pageable) {
    return categoryCRUD.findAll(pageable);
  }

  @Transactional(readOnly = true)
  public Page<Product> getFeaturedProducts(Pageable pageable) {
    return productShop.getFeaturedProducts(pageable);
  }

}
