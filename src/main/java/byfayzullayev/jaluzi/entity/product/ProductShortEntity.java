package byfayzullayev.jaluzi.entity.product;

import byfayzullayev.jaluzi.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductShortEntity extends BaseEntity {
    private String name;
    private String imageUrl;
    private String price;
    private String sunProtection;
    private String category;

    @ManyToOne
    private CategoryEntity categoryEntity;

    @OneToOne(fetch = FetchType.LAZY)
    private ProductEntity productEntity;



}
