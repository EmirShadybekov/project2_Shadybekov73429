package pl.edu.vistula.project2_shadybekov73429.product.support;

import org.springframework.stereotype.Component;
import pl.edu.vistula.project2_shadybekov73429.product.api.request.ProductRequest;
import pl.edu.vistula.project2_shadybekov73429.product.api.request.UpdateProductRequest;
import pl.edu.vistula.project2_shadybekov73429.product.api.response.ProductResponse;
import pl.edu.vistula.project2_shadybekov73429.product.domain.Product;

@Component
public class ProductMapper {

    public Product toProduct(ProductRequest request) {
        return new Product(request.getName());
    }

    public Product toProduct(Product product, UpdateProductRequest request) {
        product.setName(request.getName());
        return product;
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(product.getId(), product.getName());
    }
}