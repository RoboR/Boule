package com.robor.boule;


/**
 * Created by RoboR on 11/4/2015.
 *
 * This class handles the operation, status of the bets
 */
public class Game {
    public enum GAMES
    {
        EURO_ROULETTE,      //Single Roulette
        AMERICA_ROULETTE,   //Double Roulette
        NOGAME
    }

    private static final int BASE_CAPITAL = 0;
    private static final int TARGET_WINNINGS = 1;


    private GAMES selected_game = GAMES.NOGAME;
    private AbstractPlay game = null;

    private double todaysGoal[] = new double[2];

    /* Need to define and configure for the bet_status_table
     Contains the
     1) bet placed
     2) Probabilty of Losing
     3) Bet to place for Next round
     */
    private int bet_status_table[];




    public Game(GAMES game, int total_bets[], double todaysGoal[])
    {
        this.todaysGoal[BASE_CAPITAL] = todaysGoal[BASE_CAPITAL];
        this.todaysGoal[TARGET_WINNINGS] = todaysGoal[TARGET_WINNINGS];

        initializeGame(game, total_bets);
    }

    private void initializeGame(GAMES game, int total_bets[])
    {
        if (game != null)
        {
            switch(game)
            {
                case EURO_ROULETTE:
                {
                    this.selected_game = GAMES.EURO_ROULETTE;
                    this.game = new PlayRoulette();
                    this.bet_status_table = new int[total_bets.length];
                }

                default:
                {}
            }

        }
    }


    /*
    Check all the bets to get the result and update bet_status_table
     */
    private void updateNewResults()
    {
    }


    private boolean isWinning()
    {
        return false;
    }


    private void getNextBetting()
    {
    }


    private void isReadyToEndGame()
    {
    }

}
