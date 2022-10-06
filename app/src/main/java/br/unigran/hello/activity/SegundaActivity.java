package br.unigran.hello.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import br.unigran.hello.R;
import br.unigran.hello.fragmento.Primeiro;

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

        Primeiro primeiro = new Primeiro(); //cria fragmento
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction(); //cria transação

        transaction.add(R.id.idframelayout, primeiro); //add fragmento
        transaction.commit();//valida adição

    }

    public void next(View view){
       /*Toast.makeText(this, "Tela em criação", Toast.LENGTH_SHORT).show();
        Intent it = new Intent(this, TerceiraActivity.class);
        startActivity(it);*/

        getSupportFragmentManager().beginTransaction().replace(R.id.idframelayout, new Primeiro()).commit();
    }
}