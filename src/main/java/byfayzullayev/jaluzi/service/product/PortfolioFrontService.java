package byfayzullayev.jaluzi.service.product;

import byfayzullayev.jaluzi.entity.portfolio.PortfolioEntity;
import byfayzullayev.jaluzi.entity.portfolio.PortfolioFrontEntity;
import byfayzullayev.jaluzi.entity.product.CategoryEntity;
import byfayzullayev.jaluzi.model.receive.portfolio.PortfolioFrontReceiveModel;
import byfayzullayev.jaluzi.model.response.ApiResponse;
import byfayzullayev.jaluzi.repository.PortfolioFrontRepository;
import byfayzullayev.jaluzi.service.base.BaseService;
import byfayzullayev.jaluzi.service.file.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PortfolioFrontService implements BaseService {
    private final PortfolioFrontRepository portfolioFrontRepository;
    private final FileService fileService;


    @Autowired
    public PortfolioFrontService(PortfolioFrontRepository portfolioFrontRepository, FileService fileService) {
        this.portfolioFrontRepository = portfolioFrontRepository;
        this.fileService = fileService;
    }

    public ApiResponse addPortfolioFront(
          PortfolioFrontReceiveModel portfolioFrontReceiveModel
    ) {
        String imageUrl = fileService.saveFile(portfolioFrontReceiveModel.getBase64(),
                portfolioFrontReceiveModel.getContentType());
        if (imageUrl == null)
            return ERROR_FILE_CREATE;

        PortfolioFrontEntity portfolioFrontEntity = new PortfolioFrontEntity();
        portfolioFrontEntity.setName(portfolioFrontReceiveModel.getName());
        portfolioFrontEntity.setAbout(portfolioFrontReceiveModel.getAbout());
        portfolioFrontEntity.setImageUrl(imageUrl);
        portfolioFrontRepository.save(portfolioFrontEntity);

        return SUCCESS_V2;
    }


    public ApiResponse updatePortfolioFront(long id, PortfolioFrontEntity portfolioFrontEntity) {
        Optional<PortfolioFrontEntity> optionalPortfolioFrontEntity = portfolioFrontRepository.findById(id);
        if (optionalPortfolioFrontEntity.isPresent()) {
            PortfolioFrontEntity updateId = optionalPortfolioFrontEntity.get();
            Optional<PortfolioFrontEntity> updatePortfolio = portfolioFrontRepository.findByName(portfolioFrontEntity.getName());

            if (updatePortfolio.isPresent())
                return USER_EXIST;

            updateId.setName(portfolioFrontEntity.getName());
            portfolioFrontRepository.save(updateId);
        }
        return SUCCESS_V2;
    }

    public ApiResponse getPortfolioFrontList() {
        SUCCESS.setData(portfolioFrontRepository.findAll());
        return SUCCESS;
    }


    public ApiResponse getPortfolioFrontId(long id) {
        Optional<PortfolioFrontEntity> optionalPortfolioFrontEntity = portfolioFrontRepository.findById(id);
        SUCCESS.setData(optionalPortfolioFrontEntity);
        return SUCCESS;
    }

    public ApiResponse deletePortfolioFront(long id) {
        Optional<PortfolioFrontEntity> optionalPortfolioFrontEntity = portfolioFrontRepository.findById(id);
        if (optionalPortfolioFrontEntity.isPresent()) {
            portfolioFrontRepository.deleteById(id);

            return SUCCESS_V2;
        }
        return ERROR_DELETE;
    }
}
