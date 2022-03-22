package byfayzullayev.jaluzi.service.product;


import byfayzullayev.jaluzi.config.CurrentUser;
import byfayzullayev.jaluzi.entity.product.CategoryEntity;
import byfayzullayev.jaluzi.entity.product.UrlOrTextEntity;
import byfayzullayev.jaluzi.model.receive.product.ProductContent;
import byfayzullayev.jaluzi.model.receive.product.ProductReceiveModel;
import byfayzullayev.jaluzi.model.response.ApiResponse;
import byfayzullayev.jaluzi.repository.CategoryRepository;
import byfayzullayev.jaluzi.repository.ProductRepository;
import byfayzullayev.jaluzi.repository.UrlOrTextRepository;
import byfayzullayev.jaluzi.service.base.BaseService;
import byfayzullayev.jaluzi.service.file.FileService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements BaseService {
    private final ProductRepository productRepository;
    private final CurrentUser currentUser;
    private final CategoryRepository categoryRepository;
    private final FileService fileService;
    private final UrlOrTextRepository urlOrTextRepository;


    public ProductService(ProductRepository productRepository, CurrentUser currentUser, CategoryRepository categoryRepository, FileService fileService, UrlOrTextRepository urlOrTextRepository) {
        this.productRepository = productRepository;
        this.currentUser = currentUser;
        this.categoryRepository = categoryRepository;
        this.fileService = fileService;
        this.urlOrTextRepository = urlOrTextRepository;
    }

    public ApiResponse addProduct(
            ProductReceiveModel productReceiveModel
    ){
        Optional<CategoryEntity> optionalCategoryEntity = categoryRepository.findById(productReceiveModel.getCategoryId());

        if (optionalCategoryEntity.isEmpty())
            return ERROR_CATEGORY_NOT_FOUND;

    }

    private List<UrlOrTextEntity> add(
            ProductReceiveModel c
    ) {

        List<UrlOrTextEntity> list
                = new ArrayList<>();

        for (ProductContent lessonContent : c.getLessonContentList()) {
            if (lessonContent.getLessonContentType().equals(LessonContentType.IMAGE)) {
                String path = fileService.saveFile(lessonContent.getData(), ".png");

                UrlOrTextEntity urlOrTextEntity = new UrlOrTextEntity();
                urlOrTextEntity.setLessonContentType(LessonContentType.IMAGE);
                urlOrTextEntity.setData(path);
                urlOrTextRepository.save(urlOrTextEntity);
                list.add(urlOrTextEntity);
            } else {
                UrlOrTextEntity urlOrTextEntity = new UrlOrTextEntity();
                urlOrTextEntity.setLessonContentType(LessonContentType.TEXT);
                urlOrTextEntity.setData(lessonContent.getData());
                urlOrTextRepository.save(urlOrTextEntity);
                list.add(urlOrTextEntity);
            }
        }
        return list;
    }
}
