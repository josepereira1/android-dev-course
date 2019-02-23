package com.josepereira.toastdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void clickFunction(View view){
        EditText myEditText = (EditText) findViewById(R.id.editText);

        Toast.makeText(this, "Hi "+myEditText.getText().toString()+"!", Toast.LENGTH_SHORT).show();

        /**
         * O Toast exibe um texto num "balão" que aparece no fundo do ecrã do telemóvel;
         */
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
