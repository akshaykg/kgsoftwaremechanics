package com.kgsoftwaremechanics.laststand.p2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsMessage;

/**
 * Created by Last stand on 8/30/2016.
 */
public class SmsListener extends BroadcastReceiver {

    public  String msgBody,msg_from;

    private SharedPreferences preferences;

    @Override
    public void onReceive(Context context, Intent intent) {


        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
            Bundle bundle = intent.getExtras();
            //---get the SMS message passed in---
            SmsMessage[] msgs = null;

            if (bundle != null){
                //---retrieve the SMS message received---
                try{
                    Object[] pdus = (Object[]) bundle.get("pdus");
                    msgs = new SmsMessage[pdus.length];
                    for(int i=0; i<msgs.length; i++){
                        msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                        msg_from = msgs[i].getOriginatingAddress();
                        msgBody = msgs[i].getMessageBody();
                    }
                }catch(Exception e){

                    msgBody = "a a";
//                            Log.d("Exception caught",e.getMessage());
                }
            }
        }
    }
}