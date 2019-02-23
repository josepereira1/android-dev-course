package com.josepereira.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void testClick(View view){
        EditText userNumber = (EditText) findViewById(R.id.editText);

        Number number = new Number();

        if(userNumber.getText().toString().isEmpty()) {
            Toast.makeText(this, "Enter one number!", Toast.LENGTH_SHORT).show();
        }else{
            number.number = Integer.parseInt(userNumber.getText().toString());

            if (number.isSquare() && number.isTriangular()) {

                Toast.makeText(this, "Is square and triangular!", Toast.LENGTH_SHORT).show();

            } else {
                if (number.isSquare()) {
                    Toast.makeText(this, "Is Square!", Toast.LENGTH_SHORT).show();
                } else {
                    if (number.isTriangular()) {
                        Toast.makeText(this, "Is Triangular!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Nothing!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }

        Log.i("teste", userNumber.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Number myNumber = new Number();

        myNumber.number = 6;

        Log.i("Teste", String.valueOf(myNumber.isTriangular()));
    }
}
