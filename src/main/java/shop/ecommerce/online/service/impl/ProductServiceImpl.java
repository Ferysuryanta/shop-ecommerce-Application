package shop.ecommerce.online.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import shop.ecommerce.online.dto.CategoryDto;
import shop.ecommerce.online.dto.ProductDto;
import shop.ecommerce.online.mapper.CategoryMapper;
import shop.ecommerce.online.mapper.ProductMapper;
import shop.ecommerce.online.model.Category;
import shop.ecommerce.online.model.Product;
import shop.ecommerce.online.repository.ProductRepository;
import shop.ecommerce.online.service.ProductService;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;
    @Override
    public List<ProductDto> findProductsByCategory(CategoryDto categoryDTO) {
        Category category = CategoryMapper.toEntity(categoryDTO);
        List<Product> products = repository.findByCategory(category);
        return products.stream().map(ProductMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findExpensiveProducts(BigDecimal minPrice, BigDecimal maxPrice) {
        List<Product> products = repository.findByPriceBetween(minPrice, maxPrice);
        return products.stream().map(ProductMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> searchProductsByName(String keyword) {
        List<Product> products = repository.searchProductsByName(keyword);
        return products.stream().map(ProductMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public BigDecimal calculateTotalPriceInCategory(CategoryDto categoryDTO) {
        Category category = CategoryMapper.toEntity(categoryDTO);
        List<Product> productsInCategory = repository.findByCategory(category);
        return productsInCategory.stream()
                .map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public ProductDto createProduct(ProductDto productDTO) {
        Product product = ProductMapper.toEntity(productDTO);
        Product saveProduct = repository.save(product);
        return ProductMapper.toDto(saveProduct);
    }

    @Override
    public ProductDto updateProduct(Long productId, ProductDto updatedProductDTO) {
        Product existingProduct = repository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("Product is not found! "));
        existingProduct.setName(updatedProductDTO.getName());
        existingProduct.setPrice(updatedProductDTO.getPrice());
        existingProduct.setCategory(CategoryMapper.toEntity(updatedProductDTO.getCategory()));

        Product product = repository.save(existingProduct);
        return ProductMapper.toDto(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        repository.deleteById(productId);
    }
}
