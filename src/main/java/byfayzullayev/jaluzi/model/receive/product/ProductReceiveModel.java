package byfayzullayev.jaluzi.model.receive.product;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProductReceiveModel {
    private String imageUrl;
    private String name;
    private String price;
    private String about;
    @JsonProperty("category_id")
    private long categoryId;



}
