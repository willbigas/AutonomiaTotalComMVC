package br.com.willbigas.service;


import java.util.List;

import br.com.willbigas.model.Carro;

public class CarroService {

    public Carro calcular(Carro carro) {
        carro.setConsumoMedio(calcularMediaDeCombustivel(carro.getKmPercorrido(), carro.getQtdCombustivel()));
        return carro;
    }

    private Double calcularMediaDeCombustivel(Double kmPercorrido, Double combustivelGasto) {
        return kmPercorrido / combustivelGasto;

    }

    public Double calcularMedia(List<Carro> carros) {
        Double mediaTotalDeCombustivel = 0.0;

        for (int i = 0; i < carros.size(); i++) {
            Carro umCarro = carros.get(i);
            mediaTotalDeCombustivel += umCarro.getConsumoMedio();
        }

        return mediaTotalDeCombustivel / carros.size();
    }
}
