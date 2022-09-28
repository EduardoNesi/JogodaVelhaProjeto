package com.example.jogodavelhaprojeto;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.jogodavelhaprojeto.model.Resultado;
import com.example.jogodavelhaprojeto.repository.ResultadoRepository;

public class JogoActivity extends AppCompatActivity {

    private int quantidade_jogadas;
    private int jogador; //verifica de quem é a vez de jogar
    private int matriz_jogo[][] = new int[3][3]; // tabuleiro do jogo
    private Button b[] = new Button[9]; // vetor dos botões do jogo
    private String ganhador;
    private String jogador1;
    private String jogador2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        quantidade_jogadas = 1;
        jogador = 1;
        //vinculando os botões do layout nas variaveis
        b[0] = findViewById(R.id.bt_1);
        b[1] = findViewById(R.id.bt_2);
        b[2] = findViewById(R.id.bt_3);
        b[3] = findViewById(R.id.bt_4);
        b[4] = findViewById(R.id.bt_5);
        b[5] = findViewById(R.id.bt_6);
        b[6] = findViewById(R.id.bt_7);
        b[7] = findViewById(R.id.bt_8);
        b[8] = findViewById(R.id.bt_9);

        //colocando listener em todos os botões do jogo
        b[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //passando para a função jogada o número do botão e sua posição na matriz
                jogada(b[0], 0, 0);
            }
        });
        b[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //passando para a função jogada o número do botão e sua posição na matriz
                jogada(b[1], 0, 1);
            }
        });

        b[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //passando para a função jogada o número do botão e sua posição na matriz
                jogada(b[2], 0, 2);
            }
        });
        b[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //passando para a função jogada o número do botão e sua posição na matriz
                jogada(b[3], 1, 0);
            }
        });
        b[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//passando para a função jogada o número do botão e sua posição na matriz
                jogada(b[4], 1, 1);
            }
        });
        b[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//passando para a função jogada o número do botão e sua posição na matriz
                jogada(b[5], 1, 2);
            }
        });
        b[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//passando para a função jogada o número do botão e sua posição na matriz
                jogada(b[6], 2, 0);
            }
        });
        b[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//passando para a função jogada o número do botão e sua posição na matriz
                jogada(b[7], 2, 1);
            }
        });
        b[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//passando para a função jogada o número do botão e sua posição na matriz
                jogada(b[8], 2, 2);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //colocando o menu do jogo na parte superior

        getMenuInflater().inflate(R.menu.menu_principal, menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // quando o usuario clicar em novo jogo vai abrir o modal para preenhcer o nome dos jogadores

        switch (item.getItemId()) {

            case R.id.itemNovo:
                limpar();

                //criando modal do jogador 2
                final EditText editText2 = new EditText(this);
                AlertDialog.Builder segundoJogador = new AlertDialog.Builder(this);
                segundoJogador.setMessage("Digite o nome do jogador 2: ");
                segundoJogador.setTitle("Jogador 2");
                //dizendo que o alerta vai ter uma caixa de texto para o jogador colocar o nome
                segundoJogador.setView(editText2);
                //após clicar em Salvar, o nome do jogador 2 é salvo na variável
                segundoJogador.setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        jogador2 = editText2.getText().toString();
                    }
                });
                segundoJogador.create();
                segundoJogador.show();

                //criando modal do jogador 1
                final EditText editText1 = new EditText(this);
                AlertDialog.Builder primeiroJogador = new AlertDialog.Builder(this);
                primeiroJogador.setMessage("Digite o nome do jogador 1: ");
                primeiroJogador.setTitle("Jogador 1");
                //dizendo que o alerta vai ter uma caixa de texto para o jogador colocar o nome
                primeiroJogador.setView(editText1);
                //após clicar em Salvar, o nome do jogador 2 é salvo na variável
                primeiroJogador.setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        jogador1 = editText1.getText().toString();
                    }
                });
                primeiroJogador.create();
                primeiroJogador.show();

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void jogada(Button botao_clicado, int linha, int coluna){

        //os botões ficam desabilitados até que seja iniciado um novo jogo
        botao_clicado.setEnabled(true);


        if(jogador == 1){
            //localizando a posição marcada e preenchendo como jogada do jogador 1
            matriz_jogo[linha][coluna] = 1;
            //preenchendo o X no jogo
            botao_clicado.setText("X");
            //passando a vez para o jogador 2
            jogador = 2;
            ganhador = jogador1;
            checarJogada(1);
        }
        else{
            //localizando a posição marcada e preenchendo como jogada do jogador 1
            matriz_jogo[linha][coluna] = 2;
            //preenchendo o O no jogo
            botao_clicado.setText("O");
            //passando a vez para o jogador 1
            jogador = 1;
            ganhador = jogador2;
            checarJogada(2);
        }

        quantidade_jogadas++;
    }

    public boolean vitoria(int numero_jogador_na_casa){

        //verifica se o jogo acabou e se tem um vencedor
        for(int i = 0; i < matriz_jogo.length;  i++){
            //verifica jogadas na horizontal
            if(matriz_jogo[i][0] == numero_jogador_na_casa && matriz_jogo[i][1] == numero_jogador_na_casa && matriz_jogo[i][2] == numero_jogador_na_casa){
                return true;
            }

            //verifica jogadas na vertical
            if(matriz_jogo[0][i] == numero_jogador_na_casa && matriz_jogo[1][i] == numero_jogador_na_casa && matriz_jogo[2][i] == numero_jogador_na_casa){
                return true;
            }

        }

        //verifica vitória na primeira diagonal
        if(matriz_jogo[0][0] == numero_jogador_na_casa && matriz_jogo[1][1] == numero_jogador_na_casa && matriz_jogo[2][2] == numero_jogador_na_casa){
            return true;
        }

        //verifica vitória na segunda diagonal
        if(matriz_jogo[0][2] == numero_jogador_na_casa && matriz_jogo[1][1] == numero_jogador_na_casa && matriz_jogo[2][0] == numero_jogador_na_casa){
            return true;
        }


        return false;

    }

    public void checarJogada(int numero_jogador_na_casa) {

        //verifica se já tem um vencedor
        if(vitoria(numero_jogador_na_casa)  == true){
            //criando um novo resultado de vitória e salvando na lista de resultados
            Resultado resultado = new Resultado("Vitoria", ganhador);
            ResultadoRepository.getInstance().save(resultado);

            //criando a mensagem de alerta de fim de jogo e vitória
            AlertDialog.Builder alertaVenceu = new AlertDialog.Builder(this);
            alertaVenceu.setTitle("VITÓRIA");
            alertaVenceu.setMessage("O jogador " + ganhador + " venceu");
            alertaVenceu.setIcon(android.R.drawable.star_on);
            //quando o usuário fechar a caixa de diálogo, é chamada a função que encerra o jogo e volta pra tela inicial
            alertaVenceu.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    fimJogo();
                }
            });
            alertaVenceu.create();
            alertaVenceu.show();

        }

        //verifica se o jogo terminou empatado
        else if(quantidade_jogadas == 9){
            //criando um novo resultado de empate e salvando na lista de resultados
            Resultado resultado = new Resultado("Empate", null);
            ResultadoRepository.getInstance().save(resultado);

            AlertDialog.Builder alertaEmpate = new AlertDialog.Builder(this);
            alertaEmpate.setTitle("EMPATE");
            alertaEmpate.setMessage("O jogo terminou empatado");
            //quando o usuário fechar a caixa de diálogo, é chamada a função que encerra o jogo e volta pra tela inicial
            alertaEmpate.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    fimJogo();
                }
            });
            alertaEmpate.create();
            alertaEmpate.show();

        }
    }

    public void fimJogo(){
        //desabilitando os botões do jogo
        for(int i=0; i < 9; i++){
            b[i].setEnabled(false);
        }

        //retornando para a tela inicial
        onBackPressed();
    }

    public void limpar(){
        //desabilitando botões, limpando os textos e limpando a matriz do jogo
        for(int i = 0; i < 9; i++){
            b[i].setEnabled(true);
            b[i].setText("");
        }

        //zerando a matriz do jogo
        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                matriz_jogo[x][y] = 0;
            }
        }

        //limpando as variaveis
        jogador = 1;
        jogador1 = "";
        jogador2 = "";
        ganhador = "";
    }

 }