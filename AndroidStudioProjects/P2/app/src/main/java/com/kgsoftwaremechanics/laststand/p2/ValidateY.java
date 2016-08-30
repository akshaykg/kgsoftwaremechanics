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
public class ValidateY extends AppCompatActivity implements View.OnClickListener {

    public Button bty;
    public double[] y = new double[2];
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.validatey);
        defy();

    }

    public void defy() {

        bty = (Button) findViewById(R.id.button);
        bty.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        EditText ex = (EditText) findViewById(R.id.editText) ;

        try{
            String s = ex.getText().toString();

            double check = Double.parseDouble(s);
            if(check<0||check>30){
                s="a";
            }
            y[1] = Double.parseDouble(s);

        }catch(Exception e){

            ex.setText("");
            Context context = getApplicationContext();
            CharSequence text = "Entered value in out of bound the patient cannot breath more than 30" +
                    " in 30 seconds so, value must be between 0 and 30";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();


            return;
        }


        y[0] = getIntent().getDoubleExtra("x",0);

        Intent ToGraph = new Intent(ValidateY.this,Second.class);
       // ToGraph.putExtra("y",double[] y );
        ToGraph.putExtra("myarray", y);

        startActivity(ToGraph);
    }
}
