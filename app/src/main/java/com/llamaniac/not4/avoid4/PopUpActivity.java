package com.llamaniac.not4.avoid4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Wilbur on 20/05/2017.
 */


public class PopUpActivity  extends AppCompatActivity {
    public  TextView notify_text;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        notify_text = (TextView) findViewById(R.id.notify_text);
        notify_text.setText("");

    }

    public void setNotifyText(String s){
       // notify_text.setText(s);
    }

}
