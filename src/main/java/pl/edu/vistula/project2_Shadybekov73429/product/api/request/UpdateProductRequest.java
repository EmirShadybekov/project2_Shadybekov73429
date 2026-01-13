package pl.edu.vistula.project2_shadybekov73429.product.api.request;

public class UpdateProductRequest {

    private String name;

    public UpdateProductRequest() {
    }

    public UpdateProductRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
