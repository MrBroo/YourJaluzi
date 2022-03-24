package byfayzullayev.jaluzi.repository;

import byfayzullayev.jaluzi.entity.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByProductShortEntity(long categoryId);

}
