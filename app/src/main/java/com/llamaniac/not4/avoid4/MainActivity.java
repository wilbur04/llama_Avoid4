package com.llamaniac.not4.avoid4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button playBtn, playAIBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playBtn = (Button)findViewById(R.id.two_player_button);
        playBtn.setOnClickListener(this);

        playAIBtn = (Button) findViewById(R.id.one_player_button);
        playAIBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.two_player_button:
                launchActivity(SetupActivity.class);
                break;

            case R.id.one_player_button:
                launchActivity(RobotActivity.class);
                break;

            default:
                break;
        }
    }

    private void launchActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        this.startActivity(intent);
    }
}
