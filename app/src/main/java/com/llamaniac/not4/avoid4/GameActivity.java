package com.llamaniac.not4.avoid4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{
    private Button c1a, c2a, c3a, c4a, c5a, c1b, c2b, c3b, c4b, c5b, c1c, c2c, c3c, c4c, c5c
            , c1d, c2d, c3d, c4d, c5d, c1e, c2e, c3e, c4e, c5e;
    private TextView player_turn_string;
    private int currentPlayer;
    private int[][] currentBoard;
    private Grid game;
    private int color_green, color_blue;
    private HashMap<String, Button> buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        color_green = getResources().getColor(R.color.player_1);
        color_blue = getResources().getColor(R.color.player_2);

        game = new Grid();
        player_turn_string = (TextView)findViewById(R.id.player_turn_string);

        c1a = (Button) findViewById(R.id.c1a);
        c2a = (Button) findViewById(R.id.c2a);
        c3a = (Button) findViewById(R.id.c3a);
        c4a = (Button) findViewById(R.id.c4a);
        c5a = (Button) findViewById(R.id.c5a);

        c1b = (Button) findViewById(R.id.c1b);
        c2b = (Button) findViewById(R.id.c2b);
        c3b = (Button) findViewById(R.id.c3b);
        c4b = (Button) findViewById(R.id.c4b);
        c5b = (Button) findViewById(R.id.c5b);

        c1c = (Button) findViewById(R.id.c1c);
        c2c = (Button) findViewById(R.id.c2c);
        c3c = (Button) findViewById(R.id.c3c);
        c4c = (Button) findViewById(R.id.c4c);
        c5c = (Button) findViewById(R.id.c5c);

        c1d = (Button) findViewById(R.id.c1d);
        c2d = (Button) findViewById(R.id.c2d);
        c3d = (Button) findViewById(R.id.c3d);
        c4d = (Button) findViewById(R.id.c4d);
        c5d = (Button) findViewById(R.id.c5d);

        c1e = (Button) findViewById(R.id.c1e);
        c2e = (Button) findViewById(R.id.c2e);
        c3e = (Button) findViewById(R.id.c3e);
        c4e = (Button) findViewById(R.id.c4e);
        c5e = (Button) findViewById(R.id.c5e);

        c1a.setOnClickListener(this);
        c2a.setOnClickListener(this);
        c3a.setOnClickListener(this);
        c4a.setOnClickListener(this);
        c5a.setOnClickListener(this);

        c1b.setOnClickListener(this);
        c2b.setOnClickListener(this);
        c3b.setOnClickListener(this);
        c4b.setOnClickListener(this);
        c5b.setOnClickListener(this);

        c1c.setOnClickListener(this);
        c2c.setOnClickListener(this);
        c3c.setOnClickListener(this);
        c4c.setOnClickListener(this);
        c5c.setOnClickListener(this);

        c1d.setOnClickListener(this);
        c2d.setOnClickListener(this);
        c3d.setOnClickListener(this);
        c4d.setOnClickListener(this);
        c5d.setOnClickListener(this);

        c1e.setOnClickListener(this);
        c2e.setOnClickListener(this);
        c3e.setOnClickListener(this);
        c4e.setOnClickListener(this);
        c5e.setOnClickListener(this);

        buttons = new HashMap<>();

        buttons.put("c1a" ,c1a);
        buttons.put("c1b" ,c1b);
        buttons.put("c1c" ,c1c);
        buttons.put("c1d" ,c1d);
        buttons.put("c1e" ,c1e);

        buttons.put("c2a" ,c2a);
        buttons.put("c2b" ,c2b);
        buttons.put("c2c" ,c2c);
        buttons.put("c2d" ,c2d);
        buttons.put("c2e" ,c2e);

        buttons.put("c3a" ,c3a);
        buttons.put("c3b" ,c3b);
        buttons.put("c3c" ,c3c);
        buttons.put("c3d" ,c3d);
        buttons.put("c3e" ,c3e);

        buttons.put("c4a" ,c4a);
        buttons.put("c4b" ,c4b);
        buttons.put("c4c" ,c4c);
        buttons.put("c4d" ,c4d);
        buttons.put("c4e" ,c4e);

        buttons.put("c5a" ,c5a);
        buttons.put("c5b" ,c5b);
        buttons.put("c5c" ,c5c);
        buttons.put("c5d" ,c5d);
        buttons.put("c5e" ,c5e);


    }

    private void updateView() {
        int[][] currentBoard = game.getBoard();
        int currentPlayer = game.getActivePlayer();
        player_turn_string.setText("Player " + currentPlayer + "'s Turn");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.c1a:
                column1Btn();
                break;

            case R.id.c2a:
                column2Btn();
                break;

            case R.id.c3a:
                column3Btn();
                break;

            case R.id.c4a:
                column4Btn();
                break;

            case R.id.c5a:
                column5Btn();
                break;

            case R.id.c1b:
                column1Btn();
                break;

            case R.id.c2b:
                column2Btn();
                break;

            case R.id.c3b:
                column3Btn();
                break;

            case R.id.c4b:
                column4Btn();
                break;

            case R.id.c5b:
                column5Btn();
                break;

            case R.id.c1c:
                column1Btn();
                break;

            case R.id.c2c:
                column2Btn();
                break;

            case R.id.c3c:
                column3Btn();
                break;

            case R.id.c4c:
                column4Btn();
                break;

            case R.id.c5c:
                column5Btn();
                break;

            case R.id.c1d:
                column1Btn();
                break;

            case R.id.c2d:
                column2Btn();
                break;

            case R.id.c3d:
                column3Btn();
                break;

            case R.id.c4d:
                column4Btn();
                break;

            case R.id.c5d:
                column5Btn();
                break;

            case R.id.c1e:
                column1Btn();
                break;

            case R.id.c2e:
                column2Btn();
                break;

            case R.id.c3e:
                column3Btn();
                break;

            case R.id.c4e:
                column4Btn();
                break;

            case R.id.c5e:
                column5Btn();
                break;

            default:
                break;
        }
    }

    private void updatePlayer() {
        currentPlayer = game.getActivePlayer();
        player_turn_string.setText("Player " + currentPlayer + "'s Turn");
    }


    private void concatNameAndSet() {
        String temp = "";
        for (int x=0; x<currentBoard.length; x++) {
            for (int y=0; y<currentBoard.length; y++) {
                if (currentBoard[y][x] != 0) {

                    temp = "c";

                    temp += String.valueOf(x+1);
                    temp += numToString(y);

                    if (currentBoard[y][x] == 1) {
                        buttons.get(temp).setBackgroundResource(R.drawable.shape);
                    } else if (currentBoard[y][x] == 2) {
                        buttons.get(temp).setBackgroundResource(R.drawable.shape2);
                    }

                }
            }
        }
    }

    private String numToString(int i) {
        if (i == 0) {
            return "a";
        } else if (i == 1) {
            return "b";
        } else if (i == 2) {
            return "c";
        } else if (i == 3) {
            return "d";
        } else if (i == 4) {
            return "e";
        } return "z";
    }
    private void updateGrid() {
        currentBoard = game.getBoard();
        concatNameAndSet();
    }

    private void column1Btn() {
        game.add(0);
        updatePlayer();
        updateGrid();
    }
    private void column2Btn() {
        game.add(1);
        updatePlayer();
        updateGrid();
    }
    private void column3Btn() {
        game.add(2);
        updatePlayer();
        updateGrid();
    }
    private void column4Btn() {
        game.add(3);
        updatePlayer();
        updateGrid();
    }
    private void column5Btn() {
        game.add(4);
        updatePlayer();
        updateGrid();
    }
}
