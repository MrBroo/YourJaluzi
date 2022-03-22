package byfayzullayev.jaluzi.repository;

import byfayzullayev.jaluzi.entity.product.UrlOrTextEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlOrTextRepository extends JpaRepository<UrlOrTextEntity, Long> {

}
