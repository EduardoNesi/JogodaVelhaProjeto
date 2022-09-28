package com.example.jogodavelhaprojeto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.jogodavelhaprojeto.adapter.ResultadoAdapter;
import com.example.jogodavelhaprojeto.model.Resultado;
import com.example.jogodavelhaprojeto.repository.ResultadoRepository;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton button_add;
    private RecyclerView recyclerViewResultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_add = findViewById(R.id.button_add);

        recyclerViewResultados = findViewById(R.id.recycler_resultados);

        recyclerViewResultados.setLayoutManager(
                new LinearLayoutManager(this)
        );


        //quando o usuario clicar no botao de + é redirecionado para a activity do jogo
        button_add.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(
                                getApplicationContext(),
                                JogoActivity.class
                        );
                        startActivity(intent);

                    }
                });
    }

    @Override
    protected void onResume() {
        super.onResume();

        //recebendo a lista de resultados salva no repository
        ArrayList<Resultado> resultados = ResultadoRepository.getInstance().get();

        //passando a lista de resultados para o adapter para ser mostrado na tela inicial
        ResultadoAdapter resultadoAdapter = new ResultadoAdapter(resultados);
        recyclerViewResultados.setAdapter(resultadoAdapter);

    }
}