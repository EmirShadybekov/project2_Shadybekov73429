package pl.edu.vistula.project2_shadybekov73429.product.api.request;

public class ProductRequest {

    private String name;

    public ProductRequest() {
    }

    public ProductRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
