package shop.ecommerce.online.service;

import shop.ecommerce.online.dto.CategoryDto;
import shop.ecommerce.online.dto.ProductDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    List<ProductDto> findProductsByCategory(CategoryDto categoryDTO);

    List<ProductDto> findExpensiveProducts(BigDecimal minPrice, BigDecimal maxPrice);

    List<ProductDto> searchProductsByName(String keyword);

    BigDecimal calculateTotalPriceInCategory(CategoryDto categoryDTO);

    ProductDto createProduct(ProductDto productDTO);

    ProductDto updateProduct(Long productId, ProductDto updatedProductDTO);

    void deleteProduct(Long productId);
}
