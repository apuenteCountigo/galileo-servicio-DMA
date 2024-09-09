package com.galileo.cu.servicio_dma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@EntityScan({ "com.galileo.cu.commons.models" })
@SpringBootApplication
public class ServicioDmaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ServicioDmaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("**************************************");
		System.out.println("DMA V-240901544");
	}
}
