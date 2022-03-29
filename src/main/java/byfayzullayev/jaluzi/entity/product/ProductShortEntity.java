package byfayzullayev.jaluzi.entity.product;

import byfayzullayev.jaluzi.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
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


    @JsonIgnore
    @ManyToOne(optional = false)
    private CategoryEntity categoryEntity;

    @OneToOne(mappedBy = "productShortEntity")
    private ProductEntity productEntity;



}
