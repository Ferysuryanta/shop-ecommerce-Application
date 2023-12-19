package shop.ecommerce.online.mapper;

import org.springframework.stereotype.Component;
import shop.ecommerce.online.dto.ProductDto;
import shop.ecommerce.online.model.Product;

@Component
public class ProductMapper {

    public static ProductDto toDto(Product product) {

        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());
        productDto.setCategory(CategoryMapper.toDto(product.getCategory()));
        return productDto;
    }

    public static Product toEntity(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setCategory(CategoryMapper.toEntity(productDto.getCategory()));
        return product;
    }
}
