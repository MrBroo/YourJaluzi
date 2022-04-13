package byfayzullayev.jaluzi.entity.product;
import byfayzullayev.jaluzi.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity extends BaseEntity {
    private String name;
    private String imageUrl;
    private String price;
    private String sunProtection;
    private String about;
//    private String category;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private ProductShortEntity productShortEntity;

}
