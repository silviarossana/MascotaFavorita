package com.gt.silviarossana.mascotasfavoritas;

import android.bluetooth.le.BluetoothLeAdvertiser;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MascotasFavoritas extends AppCompatActivity {

    Toolbar tbBarraPrincipal;
    ArrayList<Mascota> mascotas = new ArrayList<Mascota>();;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        this.tbBarraPrincipal = (Toolbar) findViewById(R.id.miActionBar);
        if (this.tbBarraPrincipal != null) {
            setSupportActionBar(this.tbBarraPrincipal);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        this.listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        /*GridLayoutManager glm = new GridLayoutManager(this, 2);*/
        this.listaMascotas.setLayoutManager(llm);


        this.inicializarListaMascotas();
        this.inicializarAdaptador();

    }

    public void inicializarAdaptador(){

        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){

        mascotas = (ArrayList<Mascota>) getIntent().getSerializableExtra("arrayMascotas");
        ordenarListaMascotas();

        /*mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Estrella", R.drawable.perritotres, "50"));
        mascotas.add(new Mascota("Blaqui", R.drawable.perritocinco, "30"));
        mascotas.add(new Mascota("Puppy", R.drawable.perritocuatro, "10"));
        mascotas.add(new Mascota("Perla", R.drawable.perritodos, "8"));
        mascotas.add(new Mascota("Pochito", R.drawable.perritouno, "5"));*/

    }

    public void ordenarListaMascotas(){

        Collections.sort(mascotas, new Comparator() {
            @Override
            public int compare(Object o, Object t1) {

                Mascota mascota1 = (Mascota)o;
                Mascota mascota2 = (Mascota)t1;

                return new Integer(Integer.parseInt(mascota1.getNumLike()))
                        .compareTo(new Integer(Integer.parseInt(mascota2.getNumLike())));
            }
        });
    }


    @Override
    public boolean onSupportNavigateUp() {

        Intent intent = new Intent(this, ListaMascotas.class);
        intent.putExtra("arrayMascotas", mascotas);

        startActivity(intent);

        onBackPressed();
        return false;
    }

}
