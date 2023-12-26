package com.soa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.soa.dto.VelascoRicardezResponse;
import com.soa.soap.NombreClient;

@SpringBootApplication
public class NombreClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(NombreClientApplication.class, args);
	}

	@Bean
    CommandLineRunner lookup(NombreClient client) {
        return args -> {
            VelascoRicardezResponse response = client.execute();
            System.err.println(response.getApellidoPaterno());
            System.err.println(response.getApellidoMaterno());
            System.err.println(response.getNombre());
            
            
        };
    }
}
