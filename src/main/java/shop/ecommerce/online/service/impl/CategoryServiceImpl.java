package shop.ecommerce.online.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.ecommerce.online.dto.CategoryDto;
import shop.ecommerce.online.mapper.CategoryMapper;
import shop.ecommerce.online.model.Category;
import shop.ecommerce.online.repository.CategoryRepository;
import shop.ecommerce.online.repository.ProductRepository;
import shop.ecommerce.online.service.CategoryServices;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryServices {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<CategoryDto> findByCategoriesName(String name) {

        List<Category> categories = categoryRepository.findByName(name);
        return categories.stream().map(CategoryMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<CategoryDto> findByCategoriesByPartialName(String partialName) {
        List<Category> categories = categoryRepository.findByPartialName(partialName);
        return categories.stream().map(CategoryMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = CategoryMapper.toEntity(categoryDto);
        Category saveCategory = categoryRepository.save(category);
        return CategoryMapper.toDto(saveCategory);
    }

    @Override
    public CategoryDto updateCategory(Long categoryId, CategoryDto updateCategory) {
        Category existingCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NoSuchElementException("Category is not found !"));
        existingCategory.setName(updateCategory.getName());
        Category updatedCategory = categoryRepository.save(existingCategory);
        return CategoryMapper.toDto(updatedCategory);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public long countProductsInCategory(CategoryDto categoryDto) {
        Category category = CategoryMapper.toEntity(categoryDto);
        return productRepository.countByCategory(category);
    }
}
