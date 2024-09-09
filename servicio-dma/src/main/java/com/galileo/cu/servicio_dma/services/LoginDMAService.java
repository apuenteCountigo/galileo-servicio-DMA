package com.galileo.cu.servicio_dma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.galileo.cu.servicio_dma.dto.DmaLoginDTO;
import com.galileo.cu.servicio_dma.clients.DMAClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoginDMAService {
    @Autowired
    private DMAClient dMAClient;

    DmaLoginDTO payload = new DmaLoginDTO();

    @EventListener
    public void Autenticate(ContextRefreshedEvent event) {
        DmaLoginDTO payload = new DmaLoginDTO();
        payload.setHost("192.168.0.200");
        payload.setLogin("countigo");
        payload.setPassword("Countigo2022!");
        payload.setClientAppName("test");
        String token = dMAClient.LoginDMA(payload);
        log.info(token);
    }
}
