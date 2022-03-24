package byfayzullayev.jaluzi.repository;

import byfayzullayev.jaluzi.entity.product.CategoryEntity;
import byfayzullayev.jaluzi.entity.product.ProductShortEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductShortRepository extends JpaRepository<ProductShortEntity, Long> {
List<ProductShortEntity> findByCategoryEntity (CategoryEntity categoryEntity);
List<ProductShortEntity> findByCategoryId (long categoryId);
}
