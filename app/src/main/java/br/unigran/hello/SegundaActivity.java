package br.unigran.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        String[] nome = getIntent().getStringArrayExtra("Nome");
        msg = findViewById(R.id.idmsg2);

        msg.setText("Olá, "+nome);
    }

    public void next(View view){
        Intent it = new Intent(this, TerceiraActivity.class);
        startActivity(it);
        onBackPressed();
    }
}