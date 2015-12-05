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

    private static int GOAL_BASE_CAPITAL;
    private static int GOAL_TARGET_WINNINGS;

    private static GAMES selected_game = GAMES.NOGAME;
    private static AbstractPlay game = null;



    /* Need to define and configure for the bet_status_table
     Contains the
     1) bet placed
     2) Probability of Losing
     3) Bet to place for Next round
     */
    private static BetStatus bet_status_table;
    private static int inHandMoney;



    /**
     *
     * @param game
     * @param starting_bets
     * @param todaysGoal Array of 2,
     *                   base capital: amount of money held from the start
     *                   target winnings: the amount of money to win
     *                   | Base Capital | Target Winnings|
     */
    public Game(GAMES game, BetTracker starting_bets[], int todaysGoal[])
    {
        GOAL_BASE_CAPITAL = todaysGoal[0];
        GOAL_TARGET_WINNINGS = todaysGoal[1];
        this.inHandMoney = GOAL_BASE_CAPITAL;

        initializeGame(game, starting_bets);
    }


    //Game specific settings
    private static void initializeGame(GAMES selGame, BetTracker start_bets[])
    {
        switch (selGame) {
            case EURO_ROULETTE: {
                selected_game = GAMES.EURO_ROULETTE;
                game = new PlayRoulette();
            }
            default:
            {}
        }

        bet_status_table = new BetStatus(start_bets, game.getLosingRates());
    }


    /*
        With the result, bet_status_table will be updated

        returns an BetStatus array stating the next bets,
        0 in amount stating that no further bet should be placed
        All 0 states that the target amount has achieved
     */
    public BetTracker[] updateNewResults(int openResult)
    {
        BetTracker pre_bet[] = bet_status_table.getNextBets();
        BetTracker cur_bet[];

        for (int i=0; i < pre_bet.length; i++)
            inHandMoney -= pre_bet[i].getBetAmount();

        //Get winnings
        cur_bet = game.checkBetWinnings(pre_bet, openResult);
        //Update BST with result from bet
        bet_status_table.updateBetStatus(cur_bet);

        //With winnings, calculate the money in hand
        for (int i=0; i < cur_bet.length; i++)
            inHandMoney += cur_bet[i].getBetAmount();

        //Hold the bets if winning
        if (GOAL_TARGET_WINNINGS <= (inHandMoney - GOAL_BASE_CAPITAL))
            BetStatus.holdWonBets();

        //get & return next bet
        return bet_status_table.getNextBets();
    }




    public BetTracker[] getNextBetting()
    {
        BetTracker nextBet[] = bet_status_table.getNextBets();

        return nextBet;
    }



    private static class BetStatus {
        private static BetTracker base_bets[];

        //Not used
        private static double lose_probability[];

        private static BetTracker net_lost[];
        private static BetTracker next_bets[];


        public BetStatus(BetTracker starting_bets[], double PLose[]) {
            this.base_bets = starting_bets;
            this.lose_probability = PLose;
            this.net_lost = new BetTracker[starting_bets.length];
            this.next_bets = new BetTracker[starting_bets.length];


            for (int i=0; i < starting_bets.length; i++) {
                net_lost[i] = new BetTracker(starting_bets[i].getBetID(), 0);
                next_bets[i] = new BetTracker(starting_bets[i].getBetID(),
                        starting_bets[i].getBetAmount());
            }
        }


        /**
         * Change the next_bet which are equal to base_bet to 0
         *
         */
        private static void holdWonBets() {
            for (int i=0; i < base_bets.length; i++)
            {
                if (base_bets[i].getBetAmount() == next_bets[i].getBetAmount())
                    next_bets[i] = new BetTracker(next_bets[i].getBetID(), 0);
            }
        }


        public static void updateBetStatus(BetTracker bet_results[]) {
            //Check bet result
            for (int i=0; i < bet_results.length; i++)
            {
                int curBetID = bet_results[i].getBetID();
                long curBetWins = bet_results[i].getBetAmount();

                //Win, set next bet to base bet
                if (curBetWins > 0)
                {
                    next_bets[i] = base_bets[i];
                    net_lost[i] = new BetTracker(curBetID, 0);
                }
                //Lose apply algorithm to get next bet
                else
                {
                    if (0 != next_bets[i].getBetAmount())
                    {
                        long cumNetLost = net_lost[i].getBetAmount() + next_bets[i].getBetAmount();
                        net_lost[i] = new BetTracker(curBetID, cumNetLost);

                        int incRate = (int) (cumNetLost / game.getWinRate(curBetID));
                        long betToPlace = base_bets[i].getBetAmount() + (long)incRate;
                        next_bets[i] = new BetTracker(curBetID, betToPlace);
                    }
                }
            }
        }


        public static BetTracker[] getNextBets() {
            return next_bets;
        }

    }

}
