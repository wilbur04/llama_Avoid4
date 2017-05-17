package com.llamaniac.not4.avoid4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button playBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playBtn = (Button)findViewById(R.id.play_button);
        playBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.play_button:
                launchActivity();
                break;

            default:
                break;
        }
    }

    private void launchActivity() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}
