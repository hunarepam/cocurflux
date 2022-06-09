package by.hunar.cocurflux.controller;

import by.hunar.cocurflux.model.Brand;
import by.hunar.cocurflux.service.BrandReactiveService;
import by.hunar.cocurflux.service.BrandService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/brands")
public class BrandController {

    private final BrandService brandService;
    private final BrandReactiveService brandReactiveService;

    public BrandController(BrandService brandService, BrandReactiveService brandReactiveService) {
        this.brandService = brandService;
        this.brandReactiveService = brandReactiveService;
    }

    @GetMapping
    public Flux<Brand> getBrands() {
        //return Flux.fromIterable(brandService.getBrands());
        return brandReactiveService.getBrands();
    }

    @GetMapping("/{id}")
    public Mono<Brand> getBrandById(@PathVariable Long id) {
        //return Mono.justOrEmpty(brandService.getBrandById(id));
        return brandReactiveService.getBrandById(id);
    }
}
