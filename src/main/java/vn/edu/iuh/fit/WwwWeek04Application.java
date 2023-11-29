package vn.edu.iuh.fit;

import lombok.AllArgsConstructor;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.models.Address;
import vn.edu.iuh.fit.services.AddressService;

import java.util.UUID;

@SpringBootApplication
@AllArgsConstructor
public class WwwWeek04Application {
	private AddressService addressService;

	public static void main(String[] args) {
		SpringApplication.run(WwwWeek04Application.class, args);
	}

	@Bean
	CommandLineRunner data() {
		return args -> {
			Faker faker = new Faker();
			for (int i = 0; i < 100; i++) {
				Address address = new Address(
						UUID.randomUUID(),
						faker.address().city(),
						Short.valueOf(faker.number().numberBetween(1, 100) + ""),
						faker.address().streetAddressNumber(),
						faker.address().streetAddress(),
						faker.address().zipCode()
				);
				addressService.save(address);
			}
			addressService.getAll().forEach(e -> System.out.println(e));
		};
	}

}
