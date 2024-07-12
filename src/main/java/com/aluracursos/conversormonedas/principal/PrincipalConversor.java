package com.aluracursos.conversormonedas.principal;

import com.aluracursos.conversormonedas.model.*;
import com.aluracursos.conversormonedas.service.ConsumoAPI;
import com.google.gson.Gson;
import java.text.DecimalFormat;
import java.util.*;

public class PrincipalConversor {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://v6.exchangerate-api.com/v6/4496823ba9c2004396224c10/latest/USD";
    private Gson gson = new Gson();
    private DecimalFormat df = new DecimalFormat("#.##");
    public PrincipalConversor() {

    }

    public void muestraElMenu() {
        var opcion = -1;
        System.out.println("Coversor de Monedas Alura Latam");
        while (opcion != 0) {
            var menu = """
                    1 - Dólar =>> Peso Argentino 
                    2 - Dólar =>> Peso Colombiano
                    3 - Peso Argentino =>> Dólar
                    4 - Peso Colombiano =>> Dólar
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    obtenerMonto("ARS");
                    break;
                case 2:
                    obtenerMonto("COP");
                    break;
                case 3:
                    obtenerMontoReverso("ARS");
                    break;
                case 4:
                    obtenerMontoReverso("COP");
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }

    private DatosMoneda obtenerMonto(String peso) {
        df.setMaximumFractionDigits(2);
        var json = consumoApi.obtenerDatos(URL_BASE);
        DatosMoneda datos = gson.fromJson(json,DatosMoneda.class);
        Double pesoConversion = datos.getConversiones().get(peso);
        System.out.println("Ingresa el monto a convertir:");
        Double monto = teclado.nextDouble();
        Double resultado = pesoConversion * monto;
        System.out.println("El valor "+monto+ " [USD] corresponde al valor final de =>> "+ df.format(resultado) + " ["+peso+"]");

        return datos;
    }
    private DatosMoneda obtenerMontoReverso(String peso) {
        df.setMaximumFractionDigits(2);
        var json = consumoApi.obtenerDatos(URL_BASE);
        DatosMoneda datos = gson.fromJson(json,DatosMoneda.class);
        Double pesoConversion = datos.getConversiones().get(peso);
        System.out.println("Ingresa el monto a convertir:");
        Double monto = teclado.nextDouble();
        Double resultado =  monto / pesoConversion;
        System.out.println("El valor "+monto+ " ["+peso+"] corresponde al valor final de =>> "+ df.format(resultado) + " [USD]");
        return datos;
    }


}

