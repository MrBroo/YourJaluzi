package byfayzullayev.jaluzi.service.product;

import byfayzullayev.jaluzi.entity.product.CategoryEntity;
import byfayzullayev.jaluzi.model.receive.product.CategoryReceiveModel;
import byfayzullayev.jaluzi.model.response.ApiResponse;
import byfayzullayev.jaluzi.repository.CategoryRepository;
import byfayzullayev.jaluzi.service.base.BaseService;
import byfayzullayev.jaluzi.service.file.FileService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements BaseService {

    private final CategoryRepository categoryRepository;
    private final FileService fileService;

    public CategoryService(CategoryRepository categoryRepository, FileService fileService) {
        this.categoryRepository = categoryRepository;
        this.fileService = fileService;
    }

    public ApiResponse addCategory(CategoryReceiveModel categoryReceiveModel) {
        String imageUrl = fileService.saveFile(categoryReceiveModel.getBase64(), categoryReceiveModel.getContentType());
        if (imageUrl == null)
            return ERROR_FILE_CREATE;

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(categoryReceiveModel.getName());
        categoryEntity.setImageUrl(imageUrl);
        categoryRepository.save(categoryEntity);

        return SUCCESS_V2;
    }

    public ApiResponse getCategoryList() {
        SUCCESS.setData(categoryRepository.findAll());
        return SUCCESS;
    }

    public ApiResponse getCategoryList(long id) {
        Optional<CategoryEntity> optionalCategoryEntity = categoryRepository.findById(id);
        SUCCESS.setData(optionalCategoryEntity);
        return SUCCESS;
    }


    public ApiResponse updateCategory(long id, CategoryEntity category) {
        Optional<CategoryEntity> optionalCategoryEntity = categoryRepository.findById(id);
        if (optionalCategoryEntity.isPresent()) {
            CategoryEntity updateId = optionalCategoryEntity.get();
            Optional<CategoryEntity> updateCategory = categoryRepository.findByName(category.getName());

            if (updateCategory.isPresent())
                return USER_EXIST;

            updateId.setName(category.getName());
            categoryRepository.save(updateId);
        }
        return SUCCESS_V2;
    }

    public ApiResponse deleteCategory(long id) {
        Optional<CategoryEntity> optionalCategoryEntity = categoryRepository.findById(id);
        if (optionalCategoryEntity.isPresent()) {
            categoryRepository.deleteById(id);

            return SUCCESS_V2;
        }
        return ERROR_DELETE;
    }

}
