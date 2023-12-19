package shop.ecommerce.online.service;

import shop.ecommerce.online.dto.CategoryDto;

import java.util.List;

public interface CategoryServices {

    List<CategoryDto> findByCategoriesName(String name);

    List<CategoryDto> findByCategoriesByPartialName(String partialName);

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(Long categoryId, CategoryDto updateCategory);

    void deleteCategory(Long categoryId);

    long countProductsInCategory(CategoryDto categoryDto);

}
