package byfayzullayev.jaluzi.controller;

import byfayzullayev.jaluzi.entity.portfolio.PortfolioFrontEntity;
import byfayzullayev.jaluzi.model.receive.portfolio.PortfolioFrontReceiveModel;
import byfayzullayev.jaluzi.model.response.ApiResponse;
import byfayzullayev.jaluzi.service.product.PortfolioFrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/yourjaluzi/portfolioFront")
public class PortfolioFrontController {

    private final PortfolioFrontService portfolioFrontService;

    @Autowired
    public PortfolioFrontController(PortfolioFrontService portfolioFrontService) {
        this.portfolioFrontService = portfolioFrontService;
    }

    @CrossOrigin
    @PostMapping("/add")
    public HttpEntity<?> addPortfolio(@RequestBody PortfolioFrontReceiveModel portfolioFrontReceiveModel) {
        return ResponseEntity.ok(portfolioFrontService.addPortfolioFront(portfolioFrontReceiveModel));
    }

    @CrossOrigin
    @GetMapping("/list")
    public HttpEntity<?> getPortfolioList() {
        return ResponseEntity.ok(portfolioFrontService.getPortfolioFrontList());
    }

    @CrossOrigin
    @PutMapping("/edit/{id}")
    public HttpEntity<?> updateCategory(@RequestBody PortfolioFrontEntity portfolioFrontEntity, @PathVariable("id") long id) {
        return ResponseEntity.ok(portfolioFrontService.updatePortfolioFront(id, portfolioFrontEntity));
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deletePortfolio(@PathVariable long id) {

        ApiResponse delete = portfolioFrontService.deletePortfolioFront(id);
        return ResponseEntity.ok(delete);
    }
}

