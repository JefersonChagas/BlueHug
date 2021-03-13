package com.example.djali;

import android.content.Intent;
import android.os.Bundle;

import com.example.djali.ui.login.LoginActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TelaDados extends AppCompatActivity {
    TextView retun_nome, retur_sobrenome, return_email;
    ImageView return_perfil;
    Button btAlteraDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_meu_perfil);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Retorna dados do Gmail:
        btAlteraDados = findViewById(R.id.btAlteraDados);
        return_perfil = findViewById(R.id.return_perfil);
        retun_nome = findViewById(R.id.return_nome);
        return_email = findViewById(R.id.return_email);

        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if (signInAccount != null){
            String photoUrl = signInAccount.getPhotoUrl().toString();
            photoUrl = photoUrl + "?type=large";
            Picasso.get().load(photoUrl).into(return_perfil);
            retun_nome.setText(signInAccount.getDisplayName());
            return_email.setText(signInAccount.getEmail());

        }
        //------//

        //coidgo do logout (usando o altera dados como teste)
        btAlteraDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
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
                Intent intent = new Intent(this,TelaPrincipal.class);
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