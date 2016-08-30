package com.kgsoftwaremechanics.laststand.p2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Last stand on 8/29/2016.
 */
public class EnterXvalue extends AppCompatActivity implements View.OnClickListener {


    public Button bty;
    public double x=0;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.validatex);
        defy();


    }

    public void defy() {

        bty= (Button) findViewById(R.id.button);
        bty.setOnClickListener(this);
      /*
        bty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent valx = new Intent(EnterXvalue.this,ValidateY.class);
                EditText ex = (EditText) findViewById(R.id.editText) ;
               String s = ex.getText().toString();
                try{
                    x = Double.parseDouble(s);

                }catch(Exception e){

                ex.setText("");
                    Context context = getApplicationContext();
                    CharSequence text = "Entered value in out of bound";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();


                    return;
                }
                Intent i = new Intent (EnterXvalue.this,EnterXvalue.class);
                Bundle bd = new Bundle();
                bd.putDouble("one",x);
                i.putExtras(bd);
                startActivity(valx);
            }
        });

        */

    }


    @Override
    public void onClick(View view) {

        EditText ex = (EditText) findViewById(R.id.editText) ;

        try{
            String s = ex.getText().toString();

            double check = Double.parseDouble(s);
            if(check<-120||check>120){
              s="a";
            }
            x = Double.parseDouble(s);

        }catch(Exception e){

            ex.setText("");
            Context context = getApplicationContext();
            CharSequence text = "Entered value in out of bound the value must be between 0 and 120";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();


            return;
        }



        Intent valx = new Intent(EnterXvalue.this,ValidateY.class);
        valx.putExtra("x",x);
        startActivity(valx);

    }
}
