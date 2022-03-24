package byfayzullayev.jaluzi.repository;

import byfayzullayev.jaluzi.entity.product.ProductShortEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductShortRepository extends JpaRepository<ProductShortEntity, Long> {
    Optional<ProductShortEntity> findByName (String name);
}
