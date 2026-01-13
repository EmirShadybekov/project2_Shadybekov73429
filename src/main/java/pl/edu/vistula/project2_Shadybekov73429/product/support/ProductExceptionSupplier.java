package pl.edu.vistula.project2_shadybekov73429.product.support;

import pl.edu.vistula.project2_shadybekov73429.product.support.exception.ProductNotFoundException;

import java.util.function.Supplier;

public class ProductExceptionSupplier {

    public static Supplier<ProductNotFoundException> productNotFound(Long id) {
        return () -> new ProductNotFoundException(id);
    }
}