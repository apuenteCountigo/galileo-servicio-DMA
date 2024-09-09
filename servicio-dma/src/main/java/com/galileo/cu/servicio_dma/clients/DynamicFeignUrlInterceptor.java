package com.galileo.cu.servicio_dma.clients;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;

import com.galileo.cu.commons.models.Conexiones;
import com.galileo.cu.servicio_dma.repositories.ConexionesRepository;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class DynamicFeignUrlInterceptor implements RequestInterceptor {
    @Autowired
    private ConexionesRepository conRepo; // Este servicio recuperará la URL de la base de datos

    @Override
    public void apply(RequestTemplate template) {
        List<Conexiones> cons = conRepo.findByServicio("DMA");
        Conexiones con = cons.get(0);
        String dynamicUrl = "http://" + con.getIpServicio() + "/API/v1/json.asmx"; // Aquí obtienes la URL
                                                                                   // desde la base
        // de datos
        template.target(dynamicUrl); // Establece la URL base dinámica

        // Obtener las credenciales desde la base de datos o configuración
        // String username = con.getUsuario(); // Ejemplo de método para obtener el
        // usuario
        // String password = con.getPassword(); // Ejemplo de método para obtener la
        // contraseña

        // // Construir la cabecera Authorization con Basic Auth
        // String auth = username + ":" + password;
        // String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
        // String authHeader = "Basic " + encodedAuth;

        // // Añadir la cabecera Authorization a la solicitud
        // template.header("Authorization", authHeader);
    }
}
