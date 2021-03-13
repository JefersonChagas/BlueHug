package com.example.djali.Medicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.djali.R;
import com.example.djali.TelaDados;
import com.example.djali.ui.login.LoginActivity;

public class Espec_A extends AppCompatActivity {
    ImageView capa_tela_contato;
    TextView nome_esp_contato, espec_esp_contato, crm_esp_contato, perfilEsp_A;
    Button btComent_A;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_especialista);

        capa_tela_contato = findViewById(R.id.return_capa_esp);
        nome_esp_contato  = findViewById(R.id.return_nome_esp);
        espec_esp_contato = findViewById(R.id.ret_especialidade);
        btComent_A = findViewById(R.id.btComent_A);


        btComent_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Tela_Coment.class);
                startActivity(intent);
            }
        });
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
        }
        return (super.onOptionsItemSelected(item));
    }

}