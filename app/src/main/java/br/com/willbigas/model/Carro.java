package br.com.willbigas.model;

import br.com.willbigas.util.DecimalFormat;

public class Carro {

    private Integer id;
    private String nome;
    private Double kmPercorrido;
    private Double qtdCombustivel;
    private Double consumoMedio;


    public Carro() {
    }

    public Carro(Integer id , String nome, Double kmPercorrido, Double qtdCombustivel) {
        this.id = id;
        this.nome = nome;
        this.kmPercorrido = kmPercorrido;
        this.qtdCombustivel = qtdCombustivel;
    }

    public Carro(String nome, Double kmPercorrido, Double qtdCombustivel, Double consumoMedio) {
        this.nome = nome;
        this.kmPercorrido = kmPercorrido;
        this.qtdCombustivel = qtdCombustivel;
        this.consumoMedio = consumoMedio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getKmPercorrido() {
        return kmPercorrido;
    }

    public void setKmPercorrido(Double kmPercorrido) {
        this.kmPercorrido = kmPercorrido;
    }

    public Double getQtdCombustivel() {
        return qtdCombustivel;
    }

    public void setQtdCombustivel(Double qtdCombustivel) {
        this.qtdCombustivel = qtdCombustivel;
    }

    public Double getConsumoMedio() {
        return consumoMedio;
    }

    public void setConsumoMedio(Double consumoMedio) {
        this.consumoMedio = consumoMedio;
    }

    @Override
    public String toString() {
        return "Carro " + id + " - " + DecimalFormat.deDecimalParaString(consumoMedio) + " km/L";
    }
}
