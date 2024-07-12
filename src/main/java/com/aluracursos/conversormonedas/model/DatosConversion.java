package com.aluracursos.conversormonedas.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosConversion(
        @JsonAlias("USD") Double usd,
        @JsonAlias("ARS") Double ars,
        @JsonAlias("BOB") Double bob,
        @JsonAlias("COP") Double cop
) {
}
