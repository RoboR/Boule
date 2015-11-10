package com.robor.boule;

/**
 * Created by RoboR on 11/4/2015.
 *
 * An Abstract Class that handles all the operation and calculation for each type of game
 *
 * It handles some general operation for
 * 1) initializing a game
 * 2) Set player bets
 * 3) Check bets won for each Openings
 *
 */
public abstract class AbstractPlay {

    public static final int ONEWINS_ONE          = 1;
    public static final int ONEWINS_TWO          = 2;
    public static final int ONEWINS_FIVE         = 5;
    public static final int ONEWINS_SIX          = 6;
    public static final int ONEWINS_EIGHT        = 8;
    public static final int ONEWINS_ELEVEN       = 11;
    public static final int ONEWINS_SEVENTEEN    = 17;
    public static final int ONEWINS_THIRTYFIVE   = 35;

    /**
     *
     *               -------------------------------------
                     |  0  |  1  |  2  |  3  |  4  |  5  |
                     -------------------------------------
                     |   Bet ID  |         Amount        |
                     -------------------------------------
     */
    public static final int BETID_SIZE = 2;
    public static final int BETAMNT_SIZE = 4;
    public static final int BET_ARRAY_SIZE = BETID_SIZE + BETAMNT_SIZE;
    public static final int BETID_START_IDX = 0;
    public static final int BETID_END_IDX = BETID_START_IDX + BETID_SIZE - 1;
    public static final int BETAMNT_START_IDX = BETID_START_IDX + 1;
    public static final int BETAMNT_END_IDX = BETAMNT_START_IDX + BETAMNT_SIZE - 1;


    /*
        Will calculate and return the total amount of winnings (can be 0 or +ve)
        base on the opening result and bet placed


        Inputs:
            result - the number from 0 to 36
            betPlaced - array of the id of the bet placed with the amount of bet
                          first 2 bytes is the unique id next 4 bytes is the amount placed

        return
            An array



     */
    abstract int[][] checkBetWinnings(int result, int betPlaced[][]);


    abstract static class BetSpot {
        abstract int checkWinnings(int resultNum, int betAmount);
    }
}
