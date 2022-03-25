package byfayzullayev.jaluzi.repository;

import byfayzullayev.jaluzi.entity.product.CategoryEntity;
import byfayzullayev.jaluzi.entity.product.ProductShortEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductShortRepository extends JpaRepository<ProductShortEntity, Long> {

    List<ProductShortEntity> findByCategoryEntity(CategoryEntity categoryEntity);

    @Query(value = "select t.* from product_short_entity t where t.category_entity_id = ?1", nativeQuery = true)
    List<ProductShortEntity> findByCategoryId(long id);
}
