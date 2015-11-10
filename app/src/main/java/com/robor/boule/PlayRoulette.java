package com.robor.boule;



/**
 * Created by RoboR on 11/4/2015.
 */
public class PlayRoulette extends AbstractPlay {


    private final RouletteSpot betSpots[] = {
            new RouletteSpot(0x00, new int[]{0}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x01, new int[]{0, 1}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x02, new int[]{0,1,2}, ONEWINS_ELEVEN),
            new RouletteSpot(0x03, new int[]{0,2}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x04, new int[]{0,2,3}, ONEWINS_ELEVEN),
            new RouletteSpot(0x05, new int[]{0,3}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x06, new int[]{0,1,2,3}, ONEWINS_EIGHT),
            new RouletteSpot(0x07, new int[]{1}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x08, new int[]{1,2}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x09, new int[]{2}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x0a, new int[]{2,3}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x0b, new int[]{3}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x0c, new int[]{1,2,3}, ONEWINS_ELEVEN),
            new RouletteSpot(0x0d, new int[]{1,4}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x0e, new int[]{1,2,4,5}, ONEWINS_EIGHT),
            new RouletteSpot(0x0f, new int[]{2,5}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x10, new int[]{2,3,5,6}, ONEWINS_EIGHT),
            new RouletteSpot(0x11, new int[]{3,6}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x12, new int[]{1,2,3,4,5,6}, ONEWINS_FIVE),
            new RouletteSpot(0x13, new int[]{4}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x14, new int[]{4,5}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x15, new int[]{5}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x16, new int[]{5,6}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x17, new int[]{6}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x18, new int[]{4,5,6}, ONEWINS_ELEVEN),
            new RouletteSpot(0x19, new int[]{4,7}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x1a, new int[]{4,5,7,8}, ONEWINS_EIGHT),
            new RouletteSpot(0x1b, new int[]{5,8}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x1c, new int[]{5,6,8,9}, ONEWINS_EIGHT),
            new RouletteSpot(0x1d, new int[]{6,9}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x1e, new int[]{4,5,6,7,8,9}, ONEWINS_FIVE),
            new RouletteSpot(0x1f, new int[]{7}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x20, new int[]{7,8}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x21, new int[]{8}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x22, new int[]{8,9}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x23, new int[]{9}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x24, new int[]{7,8,9}, ONEWINS_ELEVEN),
            new RouletteSpot(0x25, new int[]{7,10}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x26, new int[]{7,8,10,11}, ONEWINS_EIGHT),
            new RouletteSpot(0x27, new int[]{8,11}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x28, new int[]{8,9,11,12}, ONEWINS_EIGHT),
            new RouletteSpot(0x29, new int[]{9,12}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x2a, new int[]{7,8,9,10,11,12}, ONEWINS_FIVE),
            new RouletteSpot(0x2b, new int[]{10}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x2c, new int[]{10,11}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x2d, new int[]{11}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x2e, new int[]{11,12}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x2f, new int[]{12}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x30, new int[]{10,11,12}, ONEWINS_ELEVEN),
            new RouletteSpot(0x31, new int[]{10,13}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x32, new int[]{10,11,13,14}, ONEWINS_EIGHT),
            new RouletteSpot(0x33, new int[]{11,14}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x34, new int[]{11,12,14,15}, ONEWINS_EIGHT),
            new RouletteSpot(0x35, new int[]{12,15}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x36, new int[]{10,11,12,13,14,15}, ONEWINS_FIVE),
            new RouletteSpot(0x37, new int[]{13}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x38, new int[]{13,14}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x39, new int[]{14}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x3a, new int[]{14,15}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x3b, new int[]{15}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x3c, new int[]{13,14,15}, ONEWINS_ELEVEN),
            new RouletteSpot(0x3d, new int[]{13,16}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x3e, new int[]{13,14,16,17}, ONEWINS_EIGHT),
            new RouletteSpot(0x3f, new int[]{14,17}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x40, new int[]{14,15,17,18}, ONEWINS_EIGHT),
            new RouletteSpot(0x41, new int[]{15,18}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x42, new int[]{13,14,15,16,17,18}, ONEWINS_FIVE),
            new RouletteSpot(0x43, new int[]{16}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x44, new int[]{16,17}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x45, new int[]{17}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x46, new int[]{17,18}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x47, new int[]{18}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x48, new int[]{16,17,18}, ONEWINS_ELEVEN),
            new RouletteSpot(0x49, new int[]{16,19}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x4a, new int[]{16,17,19,20}, ONEWINS_EIGHT),
            new RouletteSpot(0x4b, new int[]{17,20}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x4c, new int[]{17,18,20,21}, ONEWINS_EIGHT),
            new RouletteSpot(0x4d, new int[]{18,21}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x4e, new int[]{16,17,18,19,20,21}, ONEWINS_FIVE),
            new RouletteSpot(0x4f, new int[]{19}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x50, new int[]{19,20}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x51, new int[]{20}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x52, new int[]{20,21}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x53, new int[]{21}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x54, new int[]{19,20,21}, ONEWINS_ELEVEN),
            new RouletteSpot(0x55, new int[]{19,22}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x56, new int[]{19,20,22,23}, ONEWINS_EIGHT),
            new RouletteSpot(0x57, new int[]{20,23}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x58, new int[]{20,21,23,24}, ONEWINS_EIGHT),
            new RouletteSpot(0x59, new int[]{21,24}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x5a, new int[]{19,20,21,22,23,24}, ONEWINS_FIVE),
            new RouletteSpot(0x5b, new int[]{22}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x5c, new int[]{22,23}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x5d, new int[]{23}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x5e, new int[]{23,24}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x5f, new int[]{24}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x60, new int[]{22,23,24}, ONEWINS_ELEVEN),
            new RouletteSpot(0x61, new int[]{22,25}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x62, new int[]{22,23,25,26}, ONEWINS_EIGHT),
            new RouletteSpot(0x63, new int[]{23,26}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x64, new int[]{23,24,26,27}, ONEWINS_EIGHT),
            new RouletteSpot(0x65, new int[]{24,27}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x66, new int[]{22,23,24,25,26,27}, ONEWINS_FIVE),
            new RouletteSpot(0x67, new int[]{25}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x68, new int[]{25,26}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x69, new int[]{26}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x6a, new int[]{26,27}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x6b, new int[]{27}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x6c, new int[]{25,26,27}, ONEWINS_ELEVEN),
            new RouletteSpot(0x6d, new int[]{25,28}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x6e, new int[]{25,26,28,29}, ONEWINS_EIGHT),
            new RouletteSpot(0x6f, new int[]{26,29}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x70, new int[]{26,27,29,30}, ONEWINS_EIGHT),
            new RouletteSpot(0x71, new int[]{27,30}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x72, new int[]{25,26,27,28,29,30}, ONEWINS_FIVE),
            new RouletteSpot(0x73, new int[]{28}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x74, new int[]{28,29}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x75, new int[]{29}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x76, new int[]{29,30}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x77, new int[]{30}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x78, new int[]{28,29,30}, ONEWINS_ELEVEN),
            new RouletteSpot(0x79, new int[]{28,31}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x7a, new int[]{28,29,31,32}, ONEWINS_EIGHT),
            new RouletteSpot(0x7b, new int[]{29,32}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x7c, new int[]{29,30,32,33}, ONEWINS_EIGHT),
            new RouletteSpot(0x7d, new int[]{30,33}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x7e, new int[]{28,29,30,31,32,33}, ONEWINS_FIVE),
            new RouletteSpot(0x7f, new int[]{31}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x80, new int[]{31,32}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x81, new int[]{32}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x82, new int[]{32,33}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x83, new int[]{33}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x84, new int[]{31,32,33}, ONEWINS_ELEVEN),
            new RouletteSpot(0x85, new int[]{31,34}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x86, new int[]{31,32,34,35}, ONEWINS_EIGHT),
            new RouletteSpot(0x87, new int[]{32,35}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x88, new int[]{32,33,35,36}, ONEWINS_EIGHT),
            new RouletteSpot(0x89, new int[]{33,36}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x8a, new int[]{31,32,33,34,35,36}, ONEWINS_FIVE),
            new RouletteSpot(0x8b, new int[]{34}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x8c, new int[]{34,35}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x8d, new int[]{35}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x8e, new int[]{35,36}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x8f, new int[]{36}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x90, new int[]{34,35,36}, ONEWINS_ELEVEN),
            new RouletteSpot(0x91, new int[]{1,4,7,10,13,16,19,22,25,28,31,34}, ONEWINS_TWO),
            new RouletteSpot(0x92, new int[]{2,5,8,11,14,17,20,23,26,29,32,35}, ONEWINS_TWO),
            new RouletteSpot(0x93, new int[]{3,6,9,12,15,18,21,24,27,30,33,36}, ONEWINS_TWO),
            new RouletteSpot(0x94, new int[]{1,2,3,4,5,6,7,8,9,10,11,12}, ONEWINS_TWO),
            new RouletteSpot(0x95, new int[]{13,14,15,16,17,18,19,20,21,22,23,24}, ONEWINS_TWO),
            new RouletteSpot(0x96, new int[]{25,26,27,28,29,30,31,32,33,34,35,36}, ONEWINS_TWO),
            new RouletteSpot(0x97, new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18}, ONEWINS_ONE),
            new RouletteSpot(0x98, new int[]{2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36}, ONEWINS_ONE),
            new RouletteSpot(0x99, new int[]{1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36}, ONEWINS_ONE),
            new RouletteSpot(0x9a, new int[]{2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35}, ONEWINS_ONE),
            new RouletteSpot(0x9b, new int[]{1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35}, ONEWINS_ONE),
            new RouletteSpot(0x9c, new int[]{19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36}, ONEWINS_ONE),
    };



    // Detail Combination and corresponding ID, refer to roulette_bets.png
    private final int TOTAL_BET_SPOTS = betSpots.length;



    public PlayRoulette() {}

    /*

    Inputs:
        result - the number from 0 to 36
        betPlaced - array of the id of the bet placed with the amount of bet
                      first 2 bytes is the unique id next 4 bytes is the amount placed

    return
        An array

        -------------------------------------
        |  0  |  1  |  2  |  3  |  4  |  5  |
        -------------------------------------
        |   Bet ID  |         Amount        |
        -------------------------------------
     */
    public int[][] checkBetWinnings(int resultNum, int betPlaced[][])
    {
        int betWinnings[][] = new int[betPlaced.length][BET_ARRAY_SIZE];


        for (int i = 0; i < betPlaced.length; i++)
        {
            int betID = 0;
            int betAmount = 0;
            int betIdArr[] = new int[BETID_SIZE];
            int betAmountArr[] = new int[BETAMNT_SIZE];


            if (betPlaced[i].length != BET_ARRAY_SIZE)
                return betWinnings;
            else    //Get bet id & bet amount
            {
                int k = BETID_START_IDX;

                for (int j=0; j < BETID_SIZE; j++, k++)
                    betIdArr[j] = betPlaced[i][k];
                for (int j=0; j < BETAMNT_SIZE; j++, k++)
                    betAmountArr[j] = betPlaced[i][k];

                betID = UtilityCalc.BytesToInt(betIdArr);
                betAmount = UtilityCalc.BytesToInt(betAmountArr);
            }

            //Calculate winnings
            int winnings = betSpots[betID].checkWinnings(resultNum, betAmount);

            betWinnings[i] = UtilityCalc.CombineBtyeArray(UtilityCalc.IntToByteArr(betID, BETID_SIZE),
                    UtilityCalc.IntToByteArr(winnings, BETAMNT_SIZE));
        }

        return betWinnings;
    }


    /*
        Roulette betting spot will have the following attribute
          1) Color: RED, BLACK, or None (only 0x99 & 0x9a has color attribute
          2) Parity: ODD, EVEN, or None (only 0x98 & 0x9b has parity attribute.
                     This can be calculate with 'Value'
          3) Value: Can be single or multiple value combination of the possible outcome of results
          E.g. 0x01 will be {number 0 and 1}, 0x07 will be {number 1}

          Each spot will come with its own unique ID reference
     */
    private class RouletteSpot extends BetSpot {

        private int betID;
        private int value[];
        private int winRate;


        private RouletteSpot (int betID, int value[], int winRate)
        {
            this.betID = betID;
            this.value = value;
            this.winRate = winRate;
        }



        /*
            Roulette have only a single outcome, the value of the roll.
            Given the result, will calculate the winnings base on the bet placed.

            Input:
            Roulette result, value 0 to 36

            Return:
            0 if there is no winning
            win = bet amount * pay rate
         */
        int checkWinnings(int resultNum, int betAmount) {
            int i = 0;
            int wins = 0;

            while(i < this.value.length && wins <= 0)
            {
                if (this.value[i++] == resultNum)
                    wins = betAmount * this.winRate;
            }

            return wins;
        }

    }

}
