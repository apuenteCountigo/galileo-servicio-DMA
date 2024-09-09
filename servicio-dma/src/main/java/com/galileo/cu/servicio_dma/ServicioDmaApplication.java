package com.galileo.cu.servicio_dma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import com.galileo.cu.servicio_dma.clients.*;
import com.galileo.cu.servicio_dma.dto.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
		log.info("**************************************");
		log.info("DMA V-2409091111");
	}
}
