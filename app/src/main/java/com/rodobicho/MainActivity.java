package com.rodobicho;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private ImageButton btnDados;
    private ImageButton btnEnviar;
    private ImageButton btnOcorrencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDados = (ImageButton) findViewById(R.id.btn_dados);
        btnOcorrencias = (ImageButton) findViewById(R.id.btn_ocorrencias);
        btnEnviar = (ImageButton) findViewById(R.id.btn_enviar);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        btnDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navegarDados();
            }
        });

        btnOcorrencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navegarOcorrencias();
            }
        });

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navegarEnviar();
            }
        });


    }

    public void navegarDados(){
        Intent intent = new Intent(this, DadosActivity.class);
        startActivity(intent);
    }

    public void navegarOcorrencias(){
        Intent intent = new Intent(this, OcorrenciasActivity.class);
        startActivity(intent);
    }

    public void navegarEnviar(){
        Intent intent = new Intent(this, EnviarActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onNavigationItemSelected (@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_enviar:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new EnviarFragment()).commit();
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_ocorrencias:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new OcorrenciasFragment()).commit();
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_dados:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DadosFragment()).commit();
                drawer.closeDrawer(GravityCompat.START);
                break;
        }
        return true;

    }

    @Override
    public void onBackPressed(){
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
