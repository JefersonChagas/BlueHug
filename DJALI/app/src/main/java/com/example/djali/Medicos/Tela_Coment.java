package com.example.djali.Medicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.djali.R;
import com.example.djali.TelaDados;
import com.example.djali.TelaPrincipal;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Tela_Coment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_comentarios);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Deixar um comentário", Snackbar.LENGTH_LONG);
                        abreFeedback();
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
                Intent intent = new Intent(this, TelaPrincipal.class);
                startActivity(intent);
                return (true);
            case R.id.Tela_Dados:
                Intent intent1 = new Intent(this, TelaDados.class);
                startActivity(intent1);
                return (true);
        }
        return (super.onOptionsItemSelected(item));
    }

    public void abreFeedback(){
        Intent feedback = new Intent(this, TelaFeedback.class);
        startActivity(feedback);
    }
}