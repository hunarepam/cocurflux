package by.hunar.cocurflux.service;

import by.hunar.cocurflux.model.Brand;
import by.hunar.cocurflux.properties.BrandProperties;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

    private final BrandProperties brandProperties;

        public BrandService(BrandProperties brandProperties) {
        this.brandProperties = brandProperties;
    }

    public List<Brand> getBrands() {
        simulateBlockingCall();
        return brandProperties.getBrands();
    }

    public Optional<Brand> getBrandById(Long id) {
        simulateBlockingCall();
        return brandProperties.getBrands().stream()
             .filter(brand -> id.equals(brand.getId()))
             .findFirst();
    }

    private void simulateBlockingCall() {
        try {
            // Simulate blocking I/O call with a blocking sleep call
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
