package br.unigran.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SegundaActivity extends AppCompatActivity {

    TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        setResult(80);

        msg = findViewById(R.id.idmsg2);

        String nome = getIntent().getStringExtra("Nome");
        msg.setText("Olá, "+ nome);
    }

    public void next(View view){
        Toast.makeText(this, "Tela em criação", Toast.LENGTH_SHORT).show();
        Intent it = new Intent(this, TerceiraActivity.class);
        startActivity(it);

    }
}