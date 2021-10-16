package com.example.trabalho1bim;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CarregaTelaPrincipal();
    }

    private void CarregaTelaPrincipal() {
        setContentView(R.layout.activity_main);
        Button btRB = findViewById(R.id.btRB);
        Button btCB = findViewById(R.id.btCB);

        btRB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarregaTelaRB();
            }
        });
        btCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarregaTelaCB();
            }
        });
    }

    private void CarregaTelaRB() {
        setContentView(R.layout.telarb);
        Button btVoltarRB = findViewById(R.id.btVoltarRB);
        RadioGroup rgOpcoes = findViewById(R.id.rgOpcoes);
        RadioButton rbPF = findViewById(R.id.rbPF);
        RadioButton rbPJ = findViewById(R.id.rbPJ);

        EditText edtDocumento =  findViewById(R.id.edtDocumento);

        rgOpcoes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                edtDocumento.setText("mudou");
                int optId = rgOpcoes.getCheckedRadioButtonId();
                if (optId == rbPF.getId()) edtDocumento.setText("C.P.F.");
                else edtDocumento.setText("C.N.P.J.");
            }
        });

        btVoltarRB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarregaTelaPrincipal();
            }
        });
    }
    private void CarregaTelaCB() {
        setContentView(R.layout.telacb);
        Button btVoltarCB = findViewById(R.id.btVoltarCB);
        CheckBox cbLeite = findViewById(R.id.cbLeite);
        CheckBox cbQueijo = findViewById(R.id.cbQueijo);
        EditText edTotal = findViewById(R.id.edTotal);

        btVoltarCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarregaTelaPrincipal();
            }
        });

        cbLeite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int iTot = 0;
                if (cbLeite.isChecked()) iTot = 6;
                if (cbQueijo.isChecked()) iTot = iTot + 12;
                edTotal.setText("Total => " + iTot);
            }
        });

        cbQueijo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int iTot = 0;
                if (cbLeite.isChecked()) iTot = 6;
                if (cbQueijo.isChecked()) iTot = iTot + 12;
                edTotal.setText("Total => " + iTot);
            }
        });

    }

}