package pl.edu.vistula.project2_shadybekov73429.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.vistula.project2_shadybekov73429.product.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}