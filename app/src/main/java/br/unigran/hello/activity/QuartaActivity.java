package br.unigran.hello.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import br.unigran.hello.R;
import br.unigran.hello.fragmento.Primeiro;
import br.unigran.hello.fragmento.SegundoFragment;

public class QuartaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarta);
        setResult(80);

        Primeiro primeiro = new Primeiro(); //cria fragmento
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction(); //cria transação

        transaction.add(R.id.idframe, primeiro); //add fragmento
        transaction.commit();//valida adição

    }

    public void segundaTela(View view){
        getSupportFragmentManager().beginTransaction().//cria transacao
                replace(R.id.idframe,new SegundoFragment())//add fragmento
                .commit();//valida a adição
    }
    public void primeiraTela(View view){
        getSupportFragmentManager().beginTransaction().//cria transacao
                replace(R.id.idframe,new Primeiro())//add fragmento
                .commit();//valida a adição
    }
}