package com.aluracursos.conversormonedas.model;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class DatosMoneda {
    @SerializedName("conversion_rates")
    private HashMap<String, Double> conversiones;

    public HashMap<String, Double> getConversiones() {
        return conversiones;
    }

    public void setConversiones(HashMap<String, Double> conversiones) {
        this.conversiones = conversiones;
    }
    public Double getCurrencyCode(DatosMoneda datosMoneda, String currencyCode) {
        HashMap<String, Double> conversionRates = datosMoneda.getConversiones();
        return conversionRates.get(currencyCode);
    }
    @Override
    public String toString() {
        return "DatosMoneda{" +
                "conversiones=" + conversiones +
                '}';
    }
}
