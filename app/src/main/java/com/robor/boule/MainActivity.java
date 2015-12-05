package com.robor.boule;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BetTracker initBet[] = new BetTracker[6];

        initBet[0] = new BetTracker(0x97, 5);
        initBet[1] = new BetTracker(0x98, 5);
        initBet[2] = new BetTracker(0x99, 5);
        initBet[3] = new BetTracker(0x9a, 5);
        initBet[4] = new BetTracker(0x9b, 5);
        initBet[5] = new BetTracker(0x9c, 5);



        Game game = new Game(Game.GAMES.EURO_ROULETTE, initBet, new int[]{2000,100});
        BetTracker b[];
        Random rand = new Random();
        rand.setSeed(Runtime.getRuntime().hashCode());

        for (int i=0; i < 15; i++)
        {
            int r = rand.nextInt(37);
            printBetTracker(game.updateNewResults(r), r);
        }

        //check all bets are minimal
        //if (yes), stop the game

        // else (yes), hold the won bets

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void printBetTracker(BetTracker bet[], int rand) {
        String str = rand + ": ";

        for (BetTracker b: bet)
            str += b.getBetAmount() + ";";

        Log.i("TEST",str);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
