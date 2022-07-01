package byfayzullayev.jaluzi.repository;

import byfayzullayev.jaluzi.entity.portfolio.PortfolioEntity;
import byfayzullayev.jaluzi.entity.portfolio.PortfolioFrontEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PortfolioFrontRepository extends JpaRepository<PortfolioFrontEntity, Long> {

    Optional<PortfolioEntity> findByName(String portfolioEntity);
}
