package byfayzullayev.jaluzi.entity.product;

import byfayzullayev.jaluzi.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CategoryEntity extends BaseEntity {
    private String name;
}
