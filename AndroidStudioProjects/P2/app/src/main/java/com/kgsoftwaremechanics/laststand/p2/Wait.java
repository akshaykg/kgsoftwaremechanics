package com.kgsoftwaremechanics.laststand.p2;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsMessage;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Last stand on 8/29/2016.
 */
public class Wait extends AppCompatActivity implements View.OnClickListener {

    BroadcastReceiver receiver = null;
    public String  msgBody="";
    public double[] y = new double[2];

   // public SmsListener sl;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.wait);

        IntentFilter filter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        receiver = new BroadcastReceiver(){
        @Override
            public void onReceive(Context arr0, Intent arr1){

            processReceiver(arr0,arr1);

        }
        };
        //registerReceiver (receiver,filter);
        registerReceiver(receiver,filter);





        Button bt = (Button) findViewById(R.id.button8);
        bt.setOnClickListener(this);


    }


    protected void onDestroy(){
        super.onDestroy();
        unregisterReceiver(receiver);
    }


        public void processReceiver(Context context, Intent intent){

            Toast toast = Toast.makeText(context, "SMS received", Toast.LENGTH_LONG);
            toast.show();
            TextView lbs = (TextView) findViewById(R.id.textView3);
            Bundle bundle = intent.getExtras();
            Object[] obgArr = (Object[]) bundle.get("pdus");

            String  msg_from="";
            for(int i=0; i<obgArr.length; i++){

               SmsMessage msgs = SmsMessage.createFromPdu((byte[])obgArr[i]);
                msg_from = msgs.getOriginatingAddress();
                 msgBody = msgs.getMessageBody();
            }

            lbs.setText(msgBody);
            TextView ph = (TextView) findViewById(R.id.textView6);
            ph.setText(msg_from);

        }


    @Override
    public void onClick(View view) {

        Intent ToGraph = new Intent(this,Second.class);
        try{

            String[] doubs = msgBody.split(" ");
            y[0]= Double.parseDouble(doubs[0]);
            y[1]= Double.parseDouble(doubs[1]);
            double check = y[0]+y[1];
            if(y[0]<-120||y[0]>120||y[1]<0||y[1]>30) check = Double.parseDouble("sdasd");
        }catch(Exception e){
            Context context = getApplicationContext();
            CharSequence text = "SMS received is not of correct syntax please follow the synatx provided above";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            return;
        }

        ToGraph.putExtra("myarray", y);

        startActivity(ToGraph);


    }
}
