package com.mariomunozmyaplication.reciclerview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MiAdaptadorSimple extends RecyclerView.Adapter<MiAdaptadorSimple.ViewHolder> {
    private List<String> mData;  //List es una coleccion, es como crear un elemento generico de listas
    private LayoutInflater mInflater;
    private int pos= 0;
    public  int getPos(){return this.pos;}
    public void decrementarPos(){this.pos --;}

    //Constructor. Pasamos los datos
    MiAdaptadorSimple(Context context, List<String> data){
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
    public void onBindViewHolder(MiAdaptadorSimple.ViewHolder holder, int position){
        String animal= mData.get(position);
        holder.myTextView.setText(animal);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView myTV= view.findViewById(R.id.tvAnimalNombre);
                ColorDrawable viewColor= (ColorDrawable) myTV.getBackground();

                if(viewColor==null) myTV.setBackgroundColor(Color.RED);
                else myTV.setBackgroundColor(Color.WHITE);{
                    int colorId= viewColor.getColor();
                    if(colorId==Color.WHITE) myTV.setBackgroundColor(Color.RED);
                    else myTV.setBackgroundColor(Color.WHITE);
                }
                pos = position;
            }

        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                TextView myTV= view.findViewById(R.id.tvAnimalNombre);
                myTV.setBackgroundColor(Color.BLUE);
                return false;
            }
        });
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
