package com.example.djali;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.djali.ui.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Para configurar o time na tela de inicio:
        setContentView(R.layout.activity_tela_abertura);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarMainActivity();
            }
        }, 5000); // 5 Segundos para exibir abertura.
    }


    //TELA PÓS ABERTURA...
    private void mostrarMainActivity() {
        Intent intent = new Intent(
                SplashActivity.this, LoginActivity.class
        );
        startActivity(intent);
        finish();
    }
}