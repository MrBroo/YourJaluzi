package byfayzullayev.jaluzi.controller;

import byfayzullayev.jaluzi.model.receive.product.CategoryReceiveModel;
import byfayzullayev.jaluzi.model.response.ApiResponse;
import byfayzullayev.jaluzi.service.product.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/yourjaluzi/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPER_ADMIN')")
    @PostMapping("/add")
    public HttpEntity<?> addCategory(@RequestBody CategoryReceiveModel categoryReceiveModel) {
        return ResponseEntity.ok(categoryService.addCategory(categoryReceiveModel));

    }

    public HttpEntity<?> getCategoryList() {
        return ResponseEntity.ok(categoryService.getCategoryList());
    }

    public HttpEntity<?> deleteCategory(@PathVariable("id") long id) {
        ApiResponse delete = categoryService.deleteCategory(id);
        return ResponseEntity.ok(delete);

    }
}
