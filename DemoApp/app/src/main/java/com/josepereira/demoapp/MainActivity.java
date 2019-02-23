package com.josepereira.demoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void clickFunction(View view){
        //  Um botão é um tipo de objeto chamado View, como muitos outros Widgets, tudo que aparece no ecrã é um objeto do tipo View, ou seja, o view refere-se ao botão que chamou este método

        EditText username = (EditText) findViewById(R.id.editText3);
        EditText password = (EditText) findViewById(R.id.editText5);

        Log.i("username", username.getText().toString());   //  vai enviar uma mensagem para o log a informar que o botão foi pressionado
        Log.i("password", password.getText().toString());

        Toast.makeText(MainActivity.this, "Hi "+username.getText().toString()+"!", Toast.LENGTH_LONG).show();   //  isto faz aparecer um "balão" no fundo do ecrã com a String, muito interessante para usar quando o user enviou dados por exemplo, ou quando algo não está bem;

        /*
        * EditText é um tipo que serve para todos os widgets de texto;
        * o findViewById é um método que devolve o widget com aquele id;
        * é necessário forçar o cast, pois o findViewById retorna um View;
        * o R representa os resources;
        * o getText retorna o texto inserido no widgets de texto;
        * */
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
