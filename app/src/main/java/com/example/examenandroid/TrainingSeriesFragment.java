package com.example.examenandroid;


import androidx.fragment.app.ListFragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;


public class TrainingSeriesFragment extends ListFragment {


    private Adapter adapt;
    View view;
    long programId;

    Bundle b = new Bundle();

    String[] titulo = new String[]{
            "Extremistas a tope",
            "Agonia Maxima",
            "Entrenamiento especial",
            "Fuerza y longitud",
    };

    String [] descripcion = new String []{
            "\"5 Flexions a terra\\n\" +\n" +
                    "            \"10 Inclinacions d'una cama\\n\" +\n" +
                    "            \"15 Flexions dorsals\\n\"", "\"100 Flexions inclinades\\n\" +\n" +
            "                                    \"100 Flexions\\n\" +\n" +
            "                                    \"100 Abdominals\\n\" +\n" +
            "                                    \"100 Esquats\\n\"", "\"Entrenament especial\",\n" +
            "                                    \"5 Dorsals\\n\" +\n" +
            "                                    \"10 Flexions\\n\" +\n" +
            "                                    \"15 Esquats\\n\"", "\"500 Metres màxima velocitat\\n\" +\n" +
            "                                    \"21 Llançaments de pes \\n\" +\n" +
            "                                    \"21 Flexions\\n\""
    };

    int[] imagenes = {
            R.drawable.correr,
            R.drawable.pesa,
            R.drawable.futbol,
            R.drawable.fuerza
    };



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        b = this.getArguments();

        view = inflater.inflate(R.layout.fragment_fragment, container, false);
        return view;

    }


    public void onItemClick(AdapterView adapterView, View view, int i, long l) {
        while (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            b.putString("Titulo", titulo[i]);
            b.putString("Description", descripcion[i]);
            b.putInt("Image", imagenes[i]);
            int commit = getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fl, TrainingInfoFragment.class, b)
                    .setReorderingAllowed(true).commit();
        }

    };

    public void setProgram(long id) {
        this.programId = id;
    }

}