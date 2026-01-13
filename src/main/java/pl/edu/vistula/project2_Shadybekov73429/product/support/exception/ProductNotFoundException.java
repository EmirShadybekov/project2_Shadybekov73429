package pl.edu.vistula.project2_shadybekov73429.product.support.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long id) {
        super("Product with id " + id + " not found");
    }
}
