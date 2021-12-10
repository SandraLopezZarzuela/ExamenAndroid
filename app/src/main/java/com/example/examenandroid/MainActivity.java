package com.example.examenandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private Adapter adapter;

    String[] titulo = new String[]{
            "Extremistas a tope",
            "Agonia Maxima",
            "Entrenamiento especial",
            "Fuerza y longitud",
    };

    int[] imagenes = {
            R.drawable.correr,
            R.drawable.pesa,
            R.drawable.futbol,
            R.drawable.fuerza
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView lista = (ListView) findViewById(R.id.ContenlistView);
        adapter = new Adapter(this, titulo, imagenes);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {

                replaceFragment(new TrainingInfoFragment());

            }
        });


    }

    public void replaceFragment(Fragment fragment){

        FragmentManager manager =  getSupportFragmentManager();
        FragmentTransaction transaction = fragment.getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.fl, fragment);
        transaction.commit();

    }
}

