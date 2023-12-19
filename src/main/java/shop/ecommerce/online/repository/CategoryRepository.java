package shop.ecommerce.online.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.ecommerce.online.dto.CategoryDto;
import shop.ecommerce.online.model.Category;
import shop.ecommerce.online.model.Product;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByName(String name);

    //mencari kategori berdasarkan sebagian nama
    @Query("SELECT c FROM Category c WHERE lower(c.name) like %:partialName%")
    List<Category> findByPartialName(@Param("partialName") String partialName);

    //menghitung jumlah produk dalam suatu kategori
    @Query("SELECT count (p) from Product p where p.category = :category")
    Long countProductsInCategory(@Param("category") Category category);
}
