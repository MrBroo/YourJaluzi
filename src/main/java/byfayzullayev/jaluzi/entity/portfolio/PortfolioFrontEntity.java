package byfayzullayev.jaluzi.entity.portfolio;

import byfayzullayev.jaluzi.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class PortfolioFrontEntity extends BaseEntity {
    private String name;
    private String about;
    private String imageUrl;
}
