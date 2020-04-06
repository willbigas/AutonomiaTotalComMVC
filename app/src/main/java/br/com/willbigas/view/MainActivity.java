package br.com.willbigas.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import br.com.willbigas.R;
import br.com.willbigas.controller.MainControl;

public class MainActivity extends AppCompatActivity {

    private MainControl control;

    private EditText edtNomeCarro;
    private EditText edtKmPercorrida;
    private EditText edtQuantidadeCombustivel;

    private Button btnCalcular;
    private Button btnLimparDados;

    private TextView tvConsumoMedioFrota;

    private LinearLayout layoutTabelaCarros;
    private ListView lvCarros;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarComponentes();
        listenerCalcular();
        listenerLimparDados();
        control = new MainControl(this);
    }

    private void inicializarComponentes() {
        edtNomeCarro = findViewById(R.id.edtNomeCarro);
        edtKmPercorrida = findViewById(R.id.edtKmPercorrida);
        edtQuantidadeCombustivel = findViewById(R.id.edtQtdCombustivel);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimparDados = findViewById(R.id.btnLimparDados);

        tvConsumoMedioFrota = findViewById(R.id.tvConsumoMedioFrota);

        layoutTabelaCarros = findViewById(R.id.layoutTabelaCarros);
        lvCarros = findViewById(R.id.lvCarros);
    }

    private void listenerCalcular() {
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.calcular();
            }
        });
    }

    private void listenerLimparDados() {
        btnLimparDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.limparDados();
            }
        });
    }


    public EditText getEdtNomeCarro() {
        return edtNomeCarro;
    }

    public EditText getEdtKmPercorrida() {
        return edtKmPercorrida;
    }

    public EditText getEdtQuantidadeCombustivel() {
        return edtQuantidadeCombustivel;
    }

    public Button getBtnCalcular() {
        return btnCalcular;
    }

    public Button getBtnLimparDados() {
        return btnLimparDados;
    }

    public TextView getTvConsumoMedioFrota() {
        return tvConsumoMedioFrota;
    }

    public LinearLayout getLayoutTabelaCarros() {
        return layoutTabelaCarros;
    }

    public ListView getLvCarros() {
        return lvCarros;
    }

    public void setLvCarros(ListView lvCarros) {
        this.lvCarros = lvCarros;
    }
}
