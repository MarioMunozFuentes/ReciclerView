package com.mariomunozmyaplication.reciclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //private MiAdaptador adapter;
    private MiAdaptadorSimple adapter;
    private EditText View;
    private EditText view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> animalNames= new ArrayList<>();
        animalNames.add("Caballo");
        animalNames.add("Perro");
        animalNames.add("Gato");
        animalNames.add("Camaleon");
        animalNames.add("Serpiente");
        animalNames.add("Conejo");
        animalNames.add("Pato");
        animalNames.add("Vaca");
        animalNames.add("Oveja");
        animalNames.add("Pez");
        animalNames.add("Camello");
        animalNames.add("Oso");
        animalNames.add("Leon");
        animalNames.add("Gallina");
        animalNames.add("Pajaro");
        animalNames.add("Zorro");

        RecyclerView recyclerView= findViewById(R.id.rvanimales);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayout= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayout);

        //adapter= new MiAdaptador(this, animalNames); java anterior
        adapter= new MiAdaptadorSimple(this, animalNames);
        recyclerView.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration= new DividerItemDecoration(recyclerView.getContext(), mLayout.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        EditText tvAnimalAnadido= findViewById(R.id.tvAnimalAnadir);
        Button bAnadir= findViewById(R.id.bAnadir);
        bAnadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item= tvAnimalAnadido.getText().toString();
                int posicionInsercion= (adapter.getPos()>=0)?adapter.getPos()+1:0;
                animalNames.add(posicionInsercion, item);
                adapter.notifyItemInserted(posicionInsercion);
                adapter.notifyItemRangeChanged(0, animalNames.size());
                recyclerView.scheduleLayoutAnimation();
            }
        });

        Button bBorrar= findViewById(R.id.bBorrar);
        bBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int posicion= adapter.getPos();
                if (adapter.getPos()>=0){
                    animalNames.remove(adapter.getPos());
                    adapter.notifyItemRemoved(adapter.getPos());
                    adapter.notifyItemRangeChanged(0, animalNames.size());
                    adapter.decrementarPos();
                    recyclerView.scheduleLayoutAnimation();
                }
            }
        });
    }
}