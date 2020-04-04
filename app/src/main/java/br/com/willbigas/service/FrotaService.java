package br.com.willbigas.service;

import br.com.willbigas.model.Frota;

public class FrotaService {

    private CarroService carroService;

    public FrotaService() {
        carroService = new CarroService();
    }

    public Frota calcular(Frota frota) {
        frota.setConsumoMedioDaFrota(carroService.calcularMedia(frota.getCarros()));
        return frota;
    }
}
