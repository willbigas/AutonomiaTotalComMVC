package br.com.willbigas.controller;

import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.willbigas.R;
import br.com.willbigas.model.Carro;
import br.com.willbigas.model.Frota;
import br.com.willbigas.service.CarroService;
import br.com.willbigas.service.FrotaService;
import br.com.willbigas.util.DecimalFormat;
import br.com.willbigas.view.MainActivity;

public class MainControl {

    private MainActivity mainActivity;

    private CarroService carroService;
    private FrotaService frotaService;
    private ArrayAdapter<Carro> carroAdapter;
    private List<Carro> carros;

    private Carro carro;
    private Frota frota;

    private Integer indiceDeQuantidadeDeCarros;

    public MainControl(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        inicializarFrota();
        inicializarServices();
        inicializarAdapter();
        indiceDeQuantidadeDeCarros = 1;
    }

    public void inicializarAdapter() {
        carros = new ArrayList<>();
        carroAdapter = new ArrayAdapter<>(mainActivity, android.R.layout.simple_list_item_1, carros);
        mainActivity.getLvCarros().setAdapter(carroAdapter);
    }

    private void inicializarFrota() {
        frota = new Frota(new ArrayList<Carro>(), 0.0);
    }

    private void inicializarServices() {
        carroService = new CarroService();
        frotaService = new FrotaService();
    }

    public void calcular() {
        if (validarDadosDaView()) {
            receberDadosDaView();
            carro = carroService.calcular(carro);
            frota = frotaService.calcular(frota);
            adicionar(carro);
            exibirDadosNaView();
            limparDados();
        }
    }

    public void limparDados() {
        mainActivity.getEdtNomeCarro().setText("");
        mainActivity.getEdtKmPercorrida().setText("");
        mainActivity.getEdtQuantidadeCombustivel().setText("");
        carro = new Carro();
    }

    public void adicionar(Carro carro) {
        carroAdapter.add(carro);
    }

    private boolean validarDadosDaView() {
        boolean foiValidado = true;

        if (mainActivity.getEdtNomeCarro().getText().toString() == null || mainActivity.getEdtNomeCarro().getText().toString().equals("")) {
            mainActivity.getEdtNomeCarro().setError(mainActivity.getString(R.string.required_nomeCarro));
            foiValidado = false;
        }

        if (mainActivity.getEdtKmPercorrida().getText().toString() == null || mainActivity.getEdtKmPercorrida().getText().toString().equals("")) {
            mainActivity.getEdtKmPercorrida().setError(mainActivity.getString(R.string.required_kmPercorrido));
            foiValidado = false;
        }

        if (mainActivity.getEdtQuantidadeCombustivel().getText().toString() == null || mainActivity.getEdtQuantidadeCombustivel().getText().toString().equals("")) {
            mainActivity.getEdtQuantidadeCombustivel().setError(mainActivity.getString(R.string.required_combustivelGasto));
            foiValidado = false;
        }
        return foiValidado;
    }

    private void receberDadosDaView() {
        carro = new Carro(indiceDeQuantidadeDeCarros, mainActivity.getEdtNomeCarro().getText().toString(), Double.valueOf(mainActivity.getEdtKmPercorrida().getText().toString()), Double.valueOf(mainActivity.getEdtQuantidadeCombustivel().getText().toString()));
        frota.getCarros().add(carro);
        indiceDeQuantidadeDeCarros++;
    }


    private void exibirDadosNaView() {
//        tvCarroDinamico.setText("Carro" + carro.getId() + " - " + DecimalFormat.deDecimalParaString(carro.getConsumoMedio()) + " km/L");
        mainActivity.getTvConsumoMedioFrota().setText(DecimalFormat.deDecimalParaString(frota.getConsumoMedioDaFrota()) + " km/L");

    }


}
