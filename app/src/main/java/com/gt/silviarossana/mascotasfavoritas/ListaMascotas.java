package com.gt.silviarossana.mascotasfavoritas;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaMascotas extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mascotas);


        this.listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        /*GridLayoutManager glm = new GridLayoutManager(this, 2);*/
        this.listaMascotas.setLayoutManager(llm);

        Bundle parametro = getIntent().getExtras();
        if(parametro != null){
            mascotas = (ArrayList<Mascota>) getIntent().getSerializableExtra("arrayMascotas");
        }else {
            this.inicializarListaMascotas();
        }

        this.inicializarAdaptador();

        FloatingActionButton miFab = (FloatingActionButton) findViewById(R.id.fabMiFab);

    }

    public void inicializarAdaptador(){

        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }


    public void inicializarListaMascotas(){

        mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Pochito", R.drawable.perritouno, "5"));
        mascotas.add(new Mascota("Perla", R.drawable.perritodos, "8"));
        mascotas.add(new Mascota("Estrella", R.drawable.perritotres, "50"));
        mascotas.add(new Mascota("Puppy", R.drawable.perritocuatro, "10"));
        mascotas.add(new Mascota("Blaqui", R.drawable.perritocinco, "30"));
    }

    public void irMascotasFavoritas(View view){

        Intent intent = new Intent(this, MascotasFavoritas.class);
        intent.putExtra("arrayMascotas", mascotas);

        startActivity(intent);

    }


}
