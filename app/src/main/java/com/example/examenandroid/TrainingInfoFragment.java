package com.example.examenandroid;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;



public class TrainingInfoFragment extends ListFragment {

    View view;
    String[] titulo = new String[]{
            "Extremistas a tope",
            "Agonia Maxima",
            "Entrenamiento especial",
            "Fuerza y longitud",
    };
    private Bundle b;

    String [] descripcion = new String []{
            "Extremitats a Tope",
                    "5 Flexions a terra\n" +
                    "10 Inclinacions d'una cama\n" +
                    "15 Flexions dorsals\n",
            "Agonia Màxima"+
                                    "100 Flexions inclinades\n" +
                                    "100 Flexions\n" +
                                    "100 Abdominals\n" +
                                    "100 Esquats\n",
            "Entrenament especial"+
                                    "5 Dorsals\n" +
                                    "10 Flexions\n" +
                                    "15 Esquats\n",
            "Força i longitud"+
                                    "500 Metres màxima velocitat\n" +
                                    "21 Llançaments de pes \n" +
                                    "21 Flexions\n"


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
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fl, TrainingSeriesFragment.class, b).setReorderingAllowed(true).commit();
        }
    };


    static interface Listener {
        void itemClicked(long id);
    };

}

