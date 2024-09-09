package com.galileo.cu.servicio_dma.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.galileo.cu.servicio_dma.dto.DmaLoginDTO;

@FeignClient(name = "dmaApi", url = "EMPTY", configuration = DynamicFeignUrlInterceptor.class) // configuration =
public interface DMAClient {
    @PostMapping("/ConnectApp")
    String LoginDMA(@RequestBody DmaLoginDTO payload);
}
