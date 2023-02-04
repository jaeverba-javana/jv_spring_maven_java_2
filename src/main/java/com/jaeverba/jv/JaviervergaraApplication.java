package com.jaeverba.jv;

import com.jaeverba.jv.controller.Engine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JaviervergaraApplication {

	public static void main(String[] args) {
		Engine engine = new Engine();

		//Cambio del puerto
		if (engine.isProduction()) {
			System.setProperty("server.port", "80");
			System.out.println("Aplicación ejecutándose en el puerto 80");
			// System.getProperties().put("server.port", 80);
		} else {
			System.getProperties().put("server.port", 8010);
			System.out.println("Aplicación ejecutándose en el puerto 8082");
		}

		SpringApplication.run(JaviervergaraApplication.class, args);
	}

}
