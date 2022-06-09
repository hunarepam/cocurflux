package by.hunar.cocurflux;

import by.hunar.cocurflux.properties.BrandProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import reactor.blockhound.BlockHound;

@SpringBootApplication
@EnableConfigurationProperties(BrandProperties.class)
public class CocurfluxApplication {

	static {
		BlockHound.install();
	}

	public static void main(String[] args) {
		SpringApplication.run(CocurfluxApplication.class, args);
	}

}
