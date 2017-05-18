package com.llamaniac.not4.avoid4;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Wilbur on 18/05/2017.
 */

public class SetupActivity extends AppCompatActivity implements View.OnClickListener {
    private Button startBtn;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("here");
        setContentView(R.layout.activity_setup);

        startBtn = (Button) findViewById(R.id.start_button);
        startBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.start_button:
                launchActivity();
                break;

            default:
                break;
        }
    }

    private void launchActivity() {
        Intent intent = new Intent(this, GameActivity.class);
        String p1name, p2name;
        p1name = ((TextView) findViewById(R.id.player1Name)).getText().toString();
        if (p1name.equals("")){
            NameStore.INSTANCE.setPlayer1Name("Player1");
        }else{
            NameStore.INSTANCE.setPlayer1Name(p1name);
        }

        p2name = ((TextView) findViewById(R.id.player2Name)).getText().toString();
        if (p2name.equals("")){
            NameStore.INSTANCE.setPlayer2Name("Player2");
        }else{
            NameStore.INSTANCE.setPlayer2Name(p2name);
        }
        this.startActivity(intent);
    }
}
