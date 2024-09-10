package com.galileo.cu.servicio_dma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galileo.cu.servicio_dma.clients.DMAClient;
import com.galileo.cu.servicio_dma.dto.DmaLoginDTO;
import com.galileo.cu.servicio_dma.dto.DmaToken;
import com.galileo.cu.servicio_dma.global.GlobalsVars;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EntityScan({ "com.galileo.cu.commons.models" })
public class ServicioDmaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ServicioDmaApplication.class, args);
	}

	@Autowired
	DMAClient dmaClient;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("**************************************");
		System.out.println("DMA V-2409101039");
	}

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	GlobalsVars gV;

	// Se asegura de que el código se ejecute una vez que la aplicación esté
	// completamente iniciada
	@EventListener(ApplicationReadyEvent.class)
	public void executeAfterStartup() {
		try {
			DmaLoginDTO payload = new DmaLoginDTO();
			payload.setClientAppName("test");
			payload.setHost("192.168.0.200");
			payload.setLogin("countigo");
			payload.setPassword("Countigo2022!");
			String token = dmaClient.LoginDMA(payload);
			log.info("Token DMA: " + token);
			DmaToken tkn = objectMapper.readValue(token, DmaToken.class);
			log.info(tkn.getD());
			gV.setToken(tkn.getD());
			log.info(gV.getToken());
			// Thread.sleep(45000); // Pausa por 4 minutos y 59 segundos
			// log.info("Han Transcurrido: " +
			// gV.calculateDifferenceInMinutes(System.currentTimeMillis()));
		} catch (Exception e) {
			log.error("Error durante el login de DMA: ", e);
		}
	}
}
