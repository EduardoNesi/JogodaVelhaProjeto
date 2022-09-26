package com.example.jogodavelhaprojeto.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jogodavelhaprojeto.R;
import com.example.jogodavelhaprojeto.model.Resultado;

import java.util.ArrayList;

public class ResultadoAdapter extends RecyclerView.Adapter<ResultadoAdapter.ResultadoViewHolder> {

    private ArrayList<Resultado> resultados;

    public  ResultadoAdapter(ArrayList<Resultado> resultados){
        this.resultados = resultados;
    }

    @NonNull
    @Override
    public ResultadoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View layout = inflater.inflate(R.layout.view_item_resultado, parent, false);
        return new ResultadoViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultadoViewHolder holder,
                                 int position) {

        Resultado resultado = resultados.get(position);

        //passando os textos que serão mostrados na recycle View
        TextView textViewTipoResultado = holder.itemView.findViewById(R.id.text_tipo_resultado);
        TextView textViewGanhador = holder.itemView.findViewById(R.id.text_ganhador);

        textViewTipoResultado.setText(resultado.getTipo_resultado());
        textViewGanhador.setText(resultado.getNome_vencedor());

    }

    @Override
    public int getItemCount() {
        return resultados.size();
    }

    public static class ResultadoViewHolder
            extends RecyclerView.ViewHolder{

        public ResultadoViewHolder(View view){
            super(view);
        }
    }


}
