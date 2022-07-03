package byfayzullayev.jaluzi.repository;

import byfayzullayev.jaluzi.entity.portfolio.PortfolioFrontEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PortfolioFrontRepository extends JpaRepository<PortfolioFrontEntity, Long> {

    Optional<PortfolioFrontEntity> findByName(String portfolioFront);
}
