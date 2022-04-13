package byfayzullayev.jaluzi.controller;

import byfayzullayev.jaluzi.entity.product.ProductShortEntity;
import byfayzullayev.jaluzi.model.receive.product.ProductShortReceiveModel;
import byfayzullayev.jaluzi.model.response.ApiResponse;
import byfayzullayev.jaluzi.service.product.ProductShortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/yourjaluzi/category/shortProduct")
public class ProductShortController {

    private final ProductShortService productShortService;

    @Autowired
    public ProductShortController(ProductShortService productShortService) {
        this.productShortService = productShortService;
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPER_ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<?> addProductShort(
            @RequestBody ProductShortReceiveModel productShortReceiveModel) {
        return ResponseEntity.ok(productShortService.addProductShort(productShortReceiveModel));
    }

    @GetMapping("/list")
    public ResponseEntity<?> getProductShortList() {
        return ResponseEntity.ok(productShortService.getProductShortList());
    }


    @PutMapping("/edit/{id}")
    public HttpEntity<?> updateProductShort(@RequestBody ProductShortEntity productShortEntity, @PathVariable("id") long id) {
        return ResponseEntity.ok(productShortService.updateProductShort(id, productShortEntity));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProductShort(
            @PathVariable("id") long id
    ) {
        ApiResponse delete = productShortService.deleteProductShort(id);
        return ResponseEntity.ok(delete);

    }
}
