package com.galileo.cu.servicio_dma.orchestrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaOrchestrator {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate = null;

    @Autowired
    ObjectMapper objectMapper;

    public KafkaOrchestrator(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "crear-operacion-dma")
    public void listenerDMAOpCreate(String mensaje) throws JsonProcessingException {
        log.info("@@@@@@@@@listenerDMAOpCreate");
    }
}
