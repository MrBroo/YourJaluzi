package byfayzullayev.jaluzi.service.product;

import byfayzullayev.jaluzi.entity.product.CategoryEntity;
import byfayzullayev.jaluzi.entity.product.ProductShortEntity;
import byfayzullayev.jaluzi.model.receive.product.ProductShortReceiveModel;
import byfayzullayev.jaluzi.model.response.ApiResponse;
import byfayzullayev.jaluzi.repository.CategoryRepository;
import byfayzullayev.jaluzi.repository.ProductShortRepository;
import byfayzullayev.jaluzi.service.base.BaseService;
import byfayzullayev.jaluzi.service.file.FileService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductShortService implements BaseService {
    private final ProductShortRepository productShortRepository;
    private final CategoryRepository categoryRepository;
    private final FileService fileService;


    public ProductShortService(ProductShortRepository productShortRepository, CategoryRepository categoryRepository, FileService fileService) {
        this.productShortRepository = productShortRepository;
        this.categoryRepository = categoryRepository;
        this.fileService = fileService;
    }

    public ApiResponse addProductShort(
            ProductShortReceiveModel productShortReceiveModel
    ){
        Optional<CategoryEntity> optionalCategoryEntity = categoryRepository.findById(productShortReceiveModel.getCategoryId());
        if (optionalCategoryEntity.isEmpty())
            return ERROR_CATEGORY_NOT_FOUND;

        String imageUrl = fileService.saveFile(productShortReceiveModel.getBase64(), productShortReceiveModel.getContentType());
        if (imageUrl == null)
            return ERROR_FILE_CREATE;

        ProductShortEntity productShortEntity = new ProductShortEntity();
        productShortEntity.setCategoryEntity(optionalCategoryEntity.get());
        productShortEntity.setName(productShortReceiveModel.getName());
        productShortEntity.setImageUrl(imageUrl);
        productShortEntity.setPrice(productShortReceiveModel.getPrice());
        productShortReceiveModel.setSunProtection(productShortReceiveModel.getSunProtection());
        productShortRepository.save(productShortEntity);

        return SUCCESS_V2;


    }
}
