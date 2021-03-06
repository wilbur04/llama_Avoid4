package com.llamaniac.not4.avoid4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class RobotActivity extends AppCompatActivity implements View.OnClickListener{
    private Button c1a, c2a, c3a, c4a, c5a, c1b, c2b, c3b, c4b, c5b, c1c, c2c, c3c, c4c, c5c
            , c1d, c2d, c3d, c4d, c5d, c1e, c2e, c3e, c4e, c5e, restart_button;
    private TextView player_turn_string, jimmy_turn_string, winBoxText;
    private int currentPlayer;
    private int[][] currentBoard;
    public static Grid grid;
    private AI jimmy;
    private int color_player1, color_player2;
    private HashMap<String, Button> buttons;
    private String name1, name2;
    public static final String TAG = RobotActivity.class.getSimpleName();
    private ImageView p1_icon, p2_icon, p1_crown, p2_crown;
    private View game_screen;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        color_player1 = getResources().getColor(R.color.player_1);
        color_player2 = getResources().getColor(R.color.player_2);

        p1_icon = (ImageView) findViewById(R.id.p1imageView);
        p2_icon = (ImageView) findViewById(R.id.p2imageView);
        p1_icon.setColorFilter(color_player1);
        p2_icon.setColorFilter(getResources().getColor(R.color.disable));

        p1_crown = (ImageView) findViewById(R.id.p1crown);
        p2_crown = (ImageView) findViewById(R.id.p2crown);
        p1_crown.setVisibility(View.INVISIBLE);
        p2_crown.setVisibility(View.INVISIBLE);

        name1 = "You";
        name2 = "Jimmy";


        player_turn_string = (TextView)findViewById(R.id.player1_turn_string);
        player_turn_string.setTextColor(color_player1);
        player_turn_string.setText(name1);

        jimmy_turn_string = (TextView)findViewById(R.id.player2_turn_string);
        jimmy_turn_string.setTextColor(getResources().getColor(R.color.disable));
        jimmy_turn_string.setText(name2);

        winBoxText = (TextView)findViewById(R.id.winBoxText);

        grid = new Grid();
        jimmy = new AI();

        buttons = new HashMap<>();
        restart_button = (Button) findViewById(R.id.restart_button);
        restart_button.setOnClickListener(this);
        game_screen = findViewById(R.id.gameScreen);

        initColumnButtons();

    }

    private void initColumnButtons() {
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

    private void endGame() {
        for(Map.Entry<String, Button> entry : buttons.entrySet()) {
            String key = entry.getKey();
            Button value = entry.getValue();
            value.setClickable(false);
        }

        for (Coords c: grid.getLosingLocations()) {
            String s = "c";
            s += (c.getY()+1);
            s += numToString(c.getX());
            Log.d(RobotActivity.TAG, s);
            buttons.get(s).setTextColor(getResources().getColor(R.color.white));
            buttons.get(s).setText("✦");
        }

        findViewById(R.id.restart_button).setVisibility(View.VISIBLE);
        game_screen.setOnClickListener(this);
    }
    private void setButtonsClickable(boolean state) {
        for(Map.Entry<String, Button> entry : buttons.entrySet()) {
            String key = entry.getKey();
            Button value = entry.getValue();
            value.setClickable(state);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.c1a:
                columnBtn(0);
                break;

            case R.id.c2a:
                columnBtn(1);
                break;

            case R.id.c3a:
                columnBtn(2);
                break;

            case R.id.c4a:
                columnBtn(3);
                break;

            case R.id.c5a:
                columnBtn(4);
                break;

            case R.id.c1b:
                columnBtn(0);
                break;

            case R.id.c2b:
                columnBtn(1);
                break;

            case R.id.c3b:
                columnBtn(2);
                break;

            case R.id.c4b:
                columnBtn(3);
                break;

            case R.id.c5b:
                columnBtn(4);
                break;

            case R.id.c1c:
                columnBtn(0);
                break;

            case R.id.c2c:
                columnBtn(1);
                break;

            case R.id.c3c:
                columnBtn(2);
                break;

            case R.id.c4c:
                columnBtn(3);
                break;

            case R.id.c5c:
                columnBtn(4);
                break;

            case R.id.c1d:
                columnBtn(0);
                break;

            case R.id.c2d:
                columnBtn(1);
                break;

            case R.id.c3d:
                columnBtn(2);
                break;

            case R.id.c4d:
                columnBtn(3);
                break;

            case R.id.c5d:
                columnBtn(4);
                break;

            case R.id.c1e:
                columnBtn(0);
                break;

            case R.id.c2e:
                columnBtn(1);
                break;

            case R.id.c3e:
                columnBtn(2);
                break;

            case R.id.c4e:
                columnBtn(3);
                break;

            case R.id.c5e:
                columnBtn(4);
                break;

            case R.id.restart_button:
                findViewById(R.id.restart_button).setVisibility(View.INVISIBLE);
                finish();
                startActivity(getIntent());
                break;

            case R.id.gameScreen:
                if (findViewById(R.id.winBox).getVisibility()==View.VISIBLE) {
                    findViewById(R.id.winBox).setVisibility(View.INVISIBLE);
                } else {
                    findViewById(R.id.winBox).setVisibility(View.VISIBLE);
                }
                break;

            default:
                break;
        }
    }

    private void updatePlayer() {
        currentPlayer = grid.getActivePlayer();
        if(!grid.boardIsFull()) {

            if (currentPlayer == 2) {
                jimmy_turn_string.setTextColor(color_player2);
                p2_icon.setColorFilter(color_player2);
                p1_icon.setColorFilter(getResources().getColor(R.color.disable));
                player_turn_string.setTextColor(getResources().getColor(R.color.disable));
            } else {
                player_turn_string.setTextColor(color_player1);
                p1_icon.setColorFilter(color_player1);
                p2_icon.setColorFilter(getResources().getColor(R.color.disable));
                jimmy_turn_string.setTextColor(getResources().getColor(R.color.disable));
            }
        }else{
            p1_crown.setVisibility(View.VISIBLE);
            p2_crown.setVisibility(View.VISIBLE);
            winBoxText.setText("Draw");
            end_game_settings();
        }
    }


    private void concatNameAndSet() {
        for (int x=0; x<currentBoard.length; x++) {
            for (int y=0; y<currentBoard.length; y++) {
                if (currentBoard[y][x] != 0) {

                    String temp = "c";
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

    private boolean updateGrid() {
        currentBoard = grid.getBoard();
        concatNameAndSet();
        if (grid.getPlayer1lost()) {
            p2_crown.setVisibility(View.VISIBLE);
            winBoxText.setText(name2 + " Won");
            end_game_settings();
            endGame();
            return true;
        } else if (grid.getPlayer2lost()) {
            p1_crown.setVisibility(View.VISIBLE);
            winBoxText.setText(name1 + " Won");
            end_game_settings();
            endGame();
            return true;
        }
        return false;
    }

    private void end_game_settings() {
        endGame();
        findViewById(R.id.winBox).setVisibility(View.VISIBLE);
        p1_icon.setColorFilter(color_player1);
        p2_icon.setColorFilter(color_player2);
        player_turn_string.setTextColor(color_player1);
        jimmy_turn_string.setTextColor(color_player2);
    }

    private void columnBtn(int column) {
        if (grid.add(column) > 0) {
            updatePlayer();
            if (!updateGrid()) {
                robotTurn();
            }
        }
    }
    private void robotTurn() {
        //delay
        setButtonsClickable(false);
        int secs = 1; // Delay in seconds
        Utils.delay(secs, new Utils.DelayCallback() {
            @Override
            public void afterDelay() {
                jimmy.makeMove();
                Log.d(RobotActivity.TAG, "Player 1 lost: " + grid.getPlayer1lost());
                Log.d(RobotActivity.TAG, "Player 2 lost: " + grid.getPlayer2lost());
                updatePlayer();
                if (!updateGrid()) {
                    setButtonsClickable(true);
                }
            }
        });
    }
}
