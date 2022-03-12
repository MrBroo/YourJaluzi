package byfayzullayev.jaluzi.entity.product;

import byfayzullayev.jaluzi.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@Entity
public class UrlOrTextEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private ProductContentType productContentType;
    private String data;
}
