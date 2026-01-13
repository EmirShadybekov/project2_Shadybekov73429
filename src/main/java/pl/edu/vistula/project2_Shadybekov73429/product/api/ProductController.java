package pl.edu.vistula.project2_shadybekov73429.product.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.vistula.project2_shadybekov73429.product.api.request.ProductRequest;
import pl.edu.vistula.project2_shadybekov73429.product.api.request.UpdateProductRequest;
import pl.edu.vistula.project2_shadybekov73429.product.api.response.ProductResponse;
import pl.edu.vistula.project2_shadybekov73429.product.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest request) {
        return new ResponseEntity<>(service.create(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> find(@PathVariable Long id) {
        return ResponseEntity.ok(service.find(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(
            @PathVariable Long id,
            @RequestBody UpdateProductRequest request
    ) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

