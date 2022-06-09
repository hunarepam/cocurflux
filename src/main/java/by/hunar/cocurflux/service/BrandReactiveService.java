package by.hunar.cocurflux.service;

import by.hunar.cocurflux.model.Brand;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class BrandReactiveService {

    private final BrandService brandService;

    public BrandReactiveService(BrandService brandService) {
        this.brandService = brandService;
    }

    public Flux<Brand> getBrands() {
        return Mono.fromCallable(brandService::getBrands)
            .subscribeOn(Schedulers.boundedElastic()).flatMapIterable(list -> list);
    }

    public Mono<Brand> getBrandById(Long id) {
        return Mono.fromCallable(()-> brandService.getBrandById(id).get())
                   .subscribeOn(Schedulers.boundedElastic());
    }
}
