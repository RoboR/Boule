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

    public static final double ONEWINS_ONE          = 1.00;
    public static final double ONEWINS_TWO          = 2.00;
    public static final double ONEWINS_FIVE         = 5.00;
    public static final double ONEWINS_SIX          = 6.00;
    public static final double ONEWINS_EIGHT        = 8.00;
    public static final double ONEWINS_ELEVEN       = 11.00;
    public static final double ONEWINS_SEVENTEEN    = 17.00;
    public static final double ONEWINS_THIRTYFIVE   = 35.00;


//    abstract void initializeGame();

    /*
        Parameters: Opening Result

        Will calculate and return the total amount of winnings (can be -ve or +ve)
        base on the opening result and bet placed
     */
    abstract void checkBetWinnings();


    abstract static class BetSpot {}

    abstract class BetResult {
        abstract boolean isBetWon(int betOpen);
    }
}
