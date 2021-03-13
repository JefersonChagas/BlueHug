package com.example.djali;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.example.djali.Medicos.Espec_A;
import com.example.djali.ui.login.LoginActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class TelaPrincipal extends AppCompatActivity {
    Spinner spnESP;
    CardView card_viewP;
    TextView ret_nomeEsp, ret_especialidade;
    ImageView capa_do_esp, img1, img2, img3, img4;
    Button bt_contato_esp, bt_local_esp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        capa_do_esp = findViewById(R.id.return_capa_esp);
        ret_nomeEsp = findViewById(R.id.return_nome_esp);
        ret_especialidade = findViewById(R.id.ret_especialidade);
        bt_contato_esp = (Button)findViewById(R.id.bt_contato_esp);
        bt_local_esp = (Button)findViewById(R.id.bt_local_esp);

        spnESP = (Spinner)findViewById(R.id.spn_esp);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.especialidade, android.R.layout.simple_spinner_item);
        spnESP.setAdapter(adapter);
        spnESP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Integer opcao = (int) spnESP.getSelectedItemId();
                if (opcao == 0)
                {
                    dadosEsp1();
                }
                /*
                if (opcao == 1)
                {
                    dadosEsp2();
                }
                if (opcao == 2)
                {
                    dadosEsp3();
                }
                if (opcao == 3)
                {
                    dadosEsp4();
                }*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }); // SPINNER FIM
    }

    @Override //chama o actionbar
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId())
        {
            case R.id.voltar:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                return (true);
            case R.id.Tela_Dados:
                Intent intent1 = new Intent(this, TelaDados.class);
                startActivity(intent1);
                return (true);
            case R.id.btExitApp:
                checkExit();
        }
        return (super.onOptionsItemSelected(item));
    }

    //Confirmação de Saída:
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            checkExit();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    private void checkExit()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Deseja Realmente sair?").setCancelable(false).setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int id) {
                finish();
            }
        }).setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int id) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }//fim

    private void dadosEsp1(){
        //
        card_viewP = (CardView)findViewById(R.id.card_viewP);
        card_viewP.setVisibility(View.VISIBLE);
        //
        //capa_do_esp.setBackgroundColor(Color.BLUE);
        //capa_do_esp.setImageResource(R.drawable.img1); --> (RETORNE A CAPA DO BANCO DE DADOS)
        ret_nomeEsp.setText("Dr. Alberto Rodrigues");
        ret_especialidade.setText("Pediatra");
        //BOTÃO CONTATO:
        bt_contato_esp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContatoEsp_A();
            }
        });
        //
        bt_local_esp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LocalEsp_A();
            }
        });
    }

    // Telas de Dados
    private void ContatoEsp_A() {
        Intent tela = new Intent(TelaPrincipal.this, Espec_A.class);
        startActivity(tela);
    }

    // Telas de Localização
    private void LocalEsp_A(){
        Intent telaLocal = new Intent(TelaPrincipal.this, Mapa_A.class);
        startActivity(telaLocal);
    }
}