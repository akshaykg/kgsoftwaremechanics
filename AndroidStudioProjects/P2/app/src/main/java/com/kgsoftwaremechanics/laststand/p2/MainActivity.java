package com.kgsoftwaremechanics.laststand.p2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button b1,b2;

    public void buts(){


        b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(this);
        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(this);




        /*      b1 = (Button) findViewById(R.id.button);
        b1 = (Button) findViewById(R.id.button); View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aut = new Intent(MainActivity.this,Wait.class);
                startActivity(aut);
            }
        });

        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aut = new Intent(MainActivity.this,EnterXvalue.class);
                startActivity(aut);
            }
        });



        b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.button){
                Intent aut = new Intent(MainActivity.this,Second.class);
                startActivity(aut);
            }
                else if(view.getId()==R.id.button2){

                    Intent aut = new Intent(MainActivity.this,EnterXvalue.class);
                    startActivity(aut);

                }
            }
        });
*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buts();
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.button){
            Intent aut = new Intent(MainActivity.this,Wait.class);
            startActivity(aut);
        }
        else if(view.getId()==R.id.button2){

            Intent aut = new Intent(MainActivity.this,EnterXvalue.class);
            startActivity(aut);

        }
    }
}
