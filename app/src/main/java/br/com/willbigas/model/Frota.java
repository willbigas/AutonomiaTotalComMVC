package br.com.willbigas.model;

import java.util.List;

public class Frota {

    private List<Carro> carros;
    private Double consumoMedioDaFrota;


    public Frota(List<Carro> carros, Double consumoMedioDaFrota) {
        this.carros = carros;
        this.consumoMedioDaFrota = consumoMedioDaFrota;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

    public Double getConsumoMedioDaFrota() {
        return consumoMedioDaFrota;
    }

    public void setConsumoMedioDaFrota(Double consumoMedioDaFrota) {
        this.consumoMedioDaFrota = consumoMedioDaFrota;
    }
}
