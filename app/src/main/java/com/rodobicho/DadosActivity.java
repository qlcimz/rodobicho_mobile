package com.rodobicho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DadosActivity extends AppCompatActivity {
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);

        btnCadastrar = (Button) findViewById(R.id.btn_cadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navegarCadastrar();
            }
        });
    }

    public void navegarCadastrar(){
        Intent intent = new Intent(this, CadastrarActivity.class);
        startActivity(intent);
    }
}


