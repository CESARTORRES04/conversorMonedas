package com.aluracursos.conversormonedas;

import com.aluracursos.conversormonedas.principal.PrincipalConversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConversorApplicationConsole implements CommandLineRunner {
	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(ConversorApplicationConsole.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		PrincipalConversor principal = new PrincipalConversor();
		principal.muestraElMenu();
	}
}
