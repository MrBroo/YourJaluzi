package byfayzullayev.jaluzi.model.receive.product;

import byfayzullayev.jaluzi.entity.product.ProductContentType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductContent {
    @JsonProperty("product_content_type")
    private ProductContentType productContentType;
    private String data;
}
