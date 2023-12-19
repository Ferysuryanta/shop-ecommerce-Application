package shop.ecommerce.online.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.ecommerce.online.dto.CategoryDto;
import shop.ecommerce.online.dto.ProductDto;
import shop.ecommerce.online.model.Category;
import shop.ecommerce.online.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(Category category);

    List<ProductDto> findByPriceGreaterThan(BigDecimal minPrice);

    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    @Query("select p from Product p where p.name like %:keyword%")
    List<Product> searchProductsByName(@Param("keyword") String keyword);

    long countByCategory(Category category);
}
