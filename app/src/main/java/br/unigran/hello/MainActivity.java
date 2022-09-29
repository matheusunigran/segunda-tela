package br.unigran.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.nameid);
    }

    public boolean verificar(){
        String nomeUsuario = nome.getText().toString();

        if ((nomeUsuario.equals(null) || (nomeUsuario.equals("")))) {
            Toast.makeText(this, "Adicione um dado", Toast.LENGTH_SHORT).show();
            return false;
        } else{
            return true;
        }
    }

    public void next(View view){
        if(verificar()){
            Intent it = new Intent(this, SegundaActivity.class);
            String nomeUsuario = nome.getText().toString();
            it.putExtra("Nome", nomeUsuario);

            startActivity(it);
        }
    }
}