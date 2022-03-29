package byfayzullayev.jaluzi.service.product;

import byfayzullayev.jaluzi.entity.product.CategoryEntity;
import byfayzullayev.jaluzi.entity.product.ProductEntity;
import byfayzullayev.jaluzi.entity.product.ProductShortEntity;
import byfayzullayev.jaluzi.model.receive.product.CategoryReceiveModel;
import byfayzullayev.jaluzi.model.response.ApiResponse;
import byfayzullayev.jaluzi.repository.CategoryRepository;
import byfayzullayev.jaluzi.repository.ProductRepository;
import byfayzullayev.jaluzi.repository.ProductShortRepository;
import byfayzullayev.jaluzi.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements BaseService {

    private final CategoryRepository categoryRepository;
    private final ProductShortRepository productShortRepository;
    private final ProductRepository productRepository;

    public CategoryService(CategoryRepository categoryRepository, ProductShortRepository productShortRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productShortRepository = productShortRepository;
        this.productRepository = productRepository;
    }

    public ApiResponse addCategory(CategoryReceiveModel categoryReceiveModel) {
        String category = "qq";

        if (category.isEmpty())
            return ERROR_CATEGORY_NOT_FOUND;

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(categoryReceiveModel.getName());
        categoryRepository.save(categoryEntity);

        return SUCCESS_V2;
    }

    public ApiResponse getCategoryList() {
        SUCCESS.setData(categoryRepository.findAll());
        return SUCCESS;
    }

    public ApiResponse deleteCategory(long id) {
        Optional<CategoryEntity> optionalCategoryEntity = categoryRepository.findById(id);
        if (optionalCategoryEntity.isPresent()) {
            categoryRepository.deleteById(id);
            Optional<ProductShortEntity> optionalProductShortEntity = productShortRepository.findById(id);
            if (optionalProductShortEntity.isPresent())
            productShortRepository.deleteById(id);

            return SUCCESS;
        }
        return ERROR_DELETE;
    }

}
