package com.mariomunozmyaplication.reciclerview;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.ViewHolder> {
    private List<String> mData;  //List es una coleccion, es como crear un elemento generico de listas
    private LayoutInflater mInflater;

    //Constructor. Pasamos los datos
    MiAdaptador(Context context, List<String> data){
        this.mInflater= LayoutInflater.from(context);
        this.mData= data;
    }

    //infla cada fil del layout que  hemos hecho para cada fila
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view= mInflater.inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    //recupera la posicion del array en el que estamos y
    //asigna en TextView el nombre del animal
    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        String animal= mData.get(position);
        holder.myTextView.setText(animal);
    }

    @Override
    public int getItemCount(){return mData.size();}

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView myTextView;

        ViewHolder(View itemView){
            super(itemView);
            myTextView= itemView.findViewById(R.id.tvAnimalNombre);
        }
    }


}
