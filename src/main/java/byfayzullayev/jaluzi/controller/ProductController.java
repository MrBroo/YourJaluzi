package byfayzullayev.jaluzi.controller;

import byfayzullayev.jaluzi.model.receive.product.ProductReceiveModel;
import byfayzullayev.jaluzi.model.response.ApiResponse;
import byfayzullayev.jaluzi.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Handler;

@RestController
@RequestMapping("/api/yourjaluzi/category/shortProduct/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPER_ADMIN')")
    @PostMapping("/add")
    public HttpEntity<?> addProduct(@RequestBody ProductReceiveModel productReceiveModel) {
        return ResponseEntity.ok(productService.addProduct(productReceiveModel));

    }
    @GetMapping("/list")
    public HttpEntity<?> getCourseList() {
        return ResponseEntity.ok(productService.getProductList());

    }
    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteProduct(@PathVariable("id") long id ){
        ApiResponse delete = productService.deleteProduct(id);
        return ResponseEntity.ok(delete);

    }


}
