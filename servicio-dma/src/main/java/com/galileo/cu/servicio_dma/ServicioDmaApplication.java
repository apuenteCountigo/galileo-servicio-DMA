package com.galileo.cu.servicio_dma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// @EntityScan({ "com.galileo.cu.commons.models" })
// @SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(scanBasePackages = "com.galileo.cu")
@EntityScan(basePackages = "com.galileo.cu.commons.models")
@EnableJpaRepositories(basePackages = "com.galileo.cu.servicio_dma.repositories")
public class ServicioDmaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ServicioDmaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("**************************************");
		System.out.println("DMA V-240901554");
	}
}
