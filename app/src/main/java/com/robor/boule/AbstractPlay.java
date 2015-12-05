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
    public static final int ONEWINS_EIGHT        = 8;
    public static final int ONEWINS_ELEVEN       = 11;
    public static final int ONEWINS_SEVENTEEN    = 17;
    public static final int ONEWINS_THIRTYFIVE   = 35;




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
    abstract BetTracker[] checkBetWinnings(BetTracker bet[], int resultNum);

    /**
     * For Example, Roulette the lose rate for placing at 0 (ID:0x00) is 36/37 =  0.9729..
     *
     * @return The lose rate of every bet spot with the array index is the bet id.
     */
    abstract double[] getLosingRates();

    abstract int getWinRate(int betID);

    abstract static class BetSpot {
        abstract long checkWinOnThisSpot(int resultNum, long betAmount);
    }
}
