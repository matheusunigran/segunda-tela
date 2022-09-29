package br.unigran.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.nameid);
    }

    public void next(View view){
        Intent it = new Intent(this, SegundaActivity.class);
        it.putExtra("Nome",nome.getText());

        startActivity(it);
        onBackPressed();
    }
}