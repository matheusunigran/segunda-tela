package br.unigran.hello.activity;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import br.unigran.hello.R;

/*Eu não sei a razão mas quando clica em fornecedor ele não abre, que seria a QuartaActivity
 sendo que está igual as outras telas*/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void cliente(View view){
        Intent it = new Intent(this, SegundaActivity.class);
        resultLauncher.launch(it);
    }
    public void produto(View view){
        Intent it = new Intent(this, TerceiraActivity.class);
        resultLauncher.launch(it);
    }
    public void fornecedor(View view){
        Intent it = new Intent(this, QuartaActivity.class);
        resultLauncher.launch(it);
    }
    ActivityResultLauncher resultLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>(){
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            if(result.getResultCode()==80)
                                Toast.makeText(getApplicationContext(),
                                        "retorno",Toast.LENGTH_SHORT).show();
                        }
                    });
    /*ActivityResultLauncher resultLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    result -> {
                        if(result.getResultCode()==80)
                            Toast.makeText(getApplicationContext(),
                                    "retorno",Toast.LENGTH_SHORT).show();
                    });*/

    public void sair(View view){
        finish();
    }

}