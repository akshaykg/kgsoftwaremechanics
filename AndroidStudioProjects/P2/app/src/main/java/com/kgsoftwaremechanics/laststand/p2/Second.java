package com.kgsoftwaremechanics.laststand.p2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

/**
 * Created by Last stand on 8/29/2016.
 */
public class Second extends AppCompatActivity {

    LineGraphSeries<DataPoint> series;
    public double x=0,z,y,amplitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph);
        double[] myIntArray = getIntent().getDoubleArrayExtra("myarray");

        amplitude=myIntArray[0];
        z=myIntArray[1];
        TextView t = (TextView) findViewById(R.id.textView);
        t.setText("Maximum amplitude of wave : "+amplitude+" & number of waves : "+z);
        double temp=z;
        z=628.35*z;//###***Do not change this, multiplier value to make req no. of sin waves***###//



      //  Intent mIntent = getIntent();
       // x = mIntent.getIntExtra("x", 0);

       // z = mIntent.getIntExtra("y", 0);

      //  Intent passY = getIntent();
       // z=passY.getDoubleExtra("y",0);
        //Intent passX = getIntent();
      //  x=passY.getDoubleExtra("x",0);
        // Bundle bd = getIntent().getExtras();
       //Double x = bd.getDouble("one");
        //Comment this out after completing
        //wiring variables from other method

        GraphView graph = (GraphView) findViewById(R.id.graph1);
        series = new LineGraphSeries<DataPoint>();
        for(int i =0; i<(int)z; i++) {
            x = x + 0.01;
            y = amplitude*(Math.sin(x));
            series.appendData(new DataPoint(x, y), true, (int) z);
        }
        graph.addSeries(series);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX((int)temp*7);
        graph.getViewport().setMinY(-Math.ceil(amplitude));
        graph.getViewport().setMaxY(Math.ceil(amplitude));

        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setXAxisBoundsManual(true);


    }

}
