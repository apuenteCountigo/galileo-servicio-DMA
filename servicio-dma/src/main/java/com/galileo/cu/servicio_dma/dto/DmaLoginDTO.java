package com.galileo.cu.servicio_dma.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DmaLoginDTO {
    String host;
    String login;
    String password;
    String clientAppName = "test";
    String clientAppVersion = null;
    String clientComputerName = null;
}
