package byfayzullayev.jaluzi.entity.product;

import byfayzullayev.jaluzi.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;-
import javax.persistence.OneToOne;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity extends BaseEntity {
    private String imageUrl;
    private String name;
    private String price;
    private String bio;

    @OneToOne(fetch = FetchType.LAZY)
    private ProductShortEntity productShortEntity;

}
