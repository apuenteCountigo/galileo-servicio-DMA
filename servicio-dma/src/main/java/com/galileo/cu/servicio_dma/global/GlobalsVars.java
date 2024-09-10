package com.galileo.cu.servicio_dma.global;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class GlobalsVars {
    private String token;
    private String host;
    private long timestamp; // Almacena la fecha en milisegundos

    // Método para establecer el token y la fecha actual en milisegundos
    public void setToken(String token) {
        this.token = token;
        this.timestamp = System.currentTimeMillis(); // Establecer la fecha actual en milisegundos
    }

    // Método para calcular la diferencia en minutos entre una fecha dada y la fecha
    // almacenada
    public long calculateDifferenceInMinutes(long currentTimeInMillis) {
        long differenceInMillis = currentTimeInMillis - this.timestamp;
        return differenceInMillis; // / (1000 * 60); // Convertir de milisegundos a minutos
    }
}
