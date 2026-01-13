package pl.edu.vistula.project2_shadybekov73429.product.service;

import org.springframework.stereotype.Service;
import pl.edu.vistula.project2_shadybekov73429.product.api.request.ProductRequest;
import pl.edu.vistula.project2_shadybekov73429.product.api.request.UpdateProductRequest;
import pl.edu.vistula.project2_shadybekov73429.product.api.response.ProductResponse;
import pl.edu.vistula.project2_shadybekov73429.product.domain.Product;
import pl.edu.vistula.project2_shadybekov73429.product.repository.ProductRepository;
import pl.edu.vistula.project2_shadybekov73429.product.support.ProductExceptionSupplier;
import pl.edu.vistula.project2_shadybekov73429.product.support.ProductMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ProductService(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ProductResponse create(ProductRequest request) {
        Product product = mapper.toProduct(request);
        return mapper.toProductResponse(repository.save(product));
    }

    public ProductResponse find(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(ProductExceptionSupplier.productNotFound(id));
        return mapper.toProductResponse(product);
    }

    public List<ProductResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toProductResponse)
                .collect(Collectors.toList());
    }

    public ProductResponse update(Long id, UpdateProductRequest request) {
        Product product = repository.findById(id)
                .orElseThrow(ProductExceptionSupplier.productNotFound(id));

        mapper.toProduct(product, request);
        return mapper.toProductResponse(repository.save(product));
    }

    public void delete(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(ProductExceptionSupplier.productNotFound(id));
        repository.deleteById(product.getId());
    }
}
