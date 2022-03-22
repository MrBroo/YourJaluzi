package byfayzullayev.jaluzi.service.product;
import byfayzullayev.jaluzi.entity.product.CategoryEntity;
import byfayzullayev.jaluzi.model.receive.product.CategoryReceiveModel;
import byfayzullayev.jaluzi.model.response.ApiResponse;
import byfayzullayev.jaluzi.repository.CategoryRepository;
import byfayzullayev.jaluzi.service.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService implements BaseService {

    private final CategoryRepository categoryRepository;

    public ApiResponse addCategory(CategoryReceiveModel categoryReceiveModel) {
        Optional<CategoryEntity> optionalCategoryEntity = categoryRepository.findByName(categoryReceiveModel.getName());

        if (optionalCategoryEntity.isEmpty())
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


}
