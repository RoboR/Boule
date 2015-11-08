package com.robor.boule;

import android.util.Log;

/**
 * Created by RoboR on 11/4/2015.
 */
public class PlayRoulette extends AbstractPlay {


    /**
     * Definition
     */
    private static enum COLORS
    {
        RED,
        BLACK,
        NONE
    };

    private static enum PARITY
    {
        EVEN,
        ODD,
        NONE
    }


    private final RouletteSpot rSpots[] = {
            new RouletteSpot(0x00, COLORS.NONE, new int[]{0}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x01, COLORS.NONE, new int[]{0, 1}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x02, COLORS.NONE, new int[]{0,1,2}, ONEWINS_ELEVEN),
            new RouletteSpot(0x03, COLORS.NONE, new int[]{0,2}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x04, COLORS.NONE, new int[]{0,2,3}, ONEWINS_ELEVEN),
            new RouletteSpot(0x05, COLORS.NONE, new int[]{0,3}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x06, COLORS.NONE, new int[]{0,1,2,3}, ONEWINS_EIGHT),
            new RouletteSpot(0x07, COLORS.NONE, new int[]{1}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x08, COLORS.NONE, new int[]{1,2}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x09, COLORS.NONE, new int[]{2}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x0a, COLORS.NONE, new int[]{2,3}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x0b, COLORS.NONE, new int[]{3}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x0c, COLORS.NONE, new int[]{1,2,3}, ONEWINS_ELEVEN),
            new RouletteSpot(0x0d, COLORS.NONE, new int[]{1,4}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x0e, COLORS.NONE, new int[]{1,2,4,5}, ONEWINS_EIGHT),
            new RouletteSpot(0x0f, COLORS.NONE, new int[]{2,5}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x10, COLORS.NONE, new int[]{2,3,5,6}, ONEWINS_EIGHT),
            new RouletteSpot(0x11, COLORS.NONE, new int[]{3,6}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x12, COLORS.NONE, new int[]{1,2,3,4,5,6}, ONEWINS_FIVE),
            new RouletteSpot(0x13, COLORS.NONE, new int[]{4}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x14, COLORS.NONE, new int[]{4,5}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x15, COLORS.NONE, new int[]{5}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x16, COLORS.NONE, new int[]{5,6}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x17, COLORS.NONE, new int[]{6}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x18, COLORS.NONE, new int[]{4,5,6}, ONEWINS_ELEVEN),
            new RouletteSpot(0x19, COLORS.NONE, new int[]{4,7}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x1a, COLORS.NONE, new int[]{4,5,7,8}, ONEWINS_EIGHT),
            new RouletteSpot(0x1b, COLORS.NONE, new int[]{5,8}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x1c, COLORS.NONE, new int[]{5,6,8,9}, ONEWINS_EIGHT),
            new RouletteSpot(0x1d, COLORS.NONE, new int[]{6,9}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x1e, COLORS.NONE, new int[]{4,5,6,7,8,9}, ONEWINS_FIVE),
            new RouletteSpot(0x1f, COLORS.NONE, new int[]{7}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x20, COLORS.NONE, new int[]{7,8}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x21, COLORS.NONE, new int[]{8}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x22, COLORS.NONE, new int[]{8,9}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x23, COLORS.NONE, new int[]{9}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x24, COLORS.NONE, new int[]{7,8,9}, ONEWINS_ELEVEN),
            new RouletteSpot(0x25, COLORS.NONE, new int[]{7,10}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x26, COLORS.NONE, new int[]{7,8,10,11}, ONEWINS_EIGHT),
            new RouletteSpot(0x27, COLORS.NONE, new int[]{8,11}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x28, COLORS.NONE, new int[]{8,9,11,12}, ONEWINS_EIGHT),
            new RouletteSpot(0x29, COLORS.NONE, new int[]{9,12}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x2a, COLORS.NONE, new int[]{7,8,9,10,11,12}, ONEWINS_FIVE),
            new RouletteSpot(0x2b, COLORS.NONE, new int[]{10}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x2c, COLORS.NONE, new int[]{10,11}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x2d, COLORS.NONE, new int[]{11}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x2e, COLORS.NONE, new int[]{11,12}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x2f, COLORS.NONE, new int[]{12}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x30, COLORS.NONE, new int[]{10,11,12}, ONEWINS_ELEVEN),
            new RouletteSpot(0x31, COLORS.NONE, new int[]{10,13}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x32, COLORS.NONE, new int[]{10,11,13,14}, ONEWINS_EIGHT),
            new RouletteSpot(0x33, COLORS.NONE, new int[]{11,14}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x34, COLORS.NONE, new int[]{11,12,14,15}, ONEWINS_EIGHT),
            new RouletteSpot(0x35, COLORS.NONE, new int[]{12,15}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x36, COLORS.NONE, new int[]{10,11,12,13,14,15}, ONEWINS_FIVE),
            new RouletteSpot(0x37, COLORS.NONE, new int[]{13}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x38, COLORS.NONE, new int[]{13,14}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x39, COLORS.NONE, new int[]{14}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x3a, COLORS.NONE, new int[]{14,15}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x3b, COLORS.NONE, new int[]{15}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x3c, COLORS.NONE, new int[]{13,14,15}, ONEWINS_ELEVEN),
            new RouletteSpot(0x3d, COLORS.NONE, new int[]{13,16}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x3e, COLORS.NONE, new int[]{13,14,16,17}, ONEWINS_EIGHT),
            new RouletteSpot(0x3f, COLORS.NONE, new int[]{14,17}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x40, COLORS.NONE, new int[]{14,15,17,18}, ONEWINS_EIGHT),
            new RouletteSpot(0x41, COLORS.NONE, new int[]{15,18}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x42, COLORS.NONE, new int[]{13,14,15,16,17,18}, ONEWINS_FIVE),
            new RouletteSpot(0x43, COLORS.NONE, new int[]{16}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x44, COLORS.NONE, new int[]{16,17}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x45, COLORS.NONE, new int[]{17}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x46, COLORS.NONE, new int[]{17,18}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x47, COLORS.NONE, new int[]{18}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x48, COLORS.NONE, new int[]{16,17,18}, ONEWINS_ELEVEN),
            new RouletteSpot(0x49, COLORS.NONE, new int[]{16,19}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x4a, COLORS.NONE, new int[]{16,17,19,20}, ONEWINS_EIGHT),
            new RouletteSpot(0x4b, COLORS.NONE, new int[]{17,20}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x4c, COLORS.NONE, new int[]{17,18,20,21}, ONEWINS_EIGHT),
            new RouletteSpot(0x4d, COLORS.NONE, new int[]{18,21}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x4e, COLORS.NONE, new int[]{16,17,18,19,20,21}, ONEWINS_FIVE),
            new RouletteSpot(0x4f, COLORS.NONE, new int[]{19}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x50, COLORS.NONE, new int[]{19,20}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x51, COLORS.NONE, new int[]{20}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x52, COLORS.NONE, new int[]{20,21}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x53, COLORS.NONE, new int[]{21}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x54, COLORS.NONE, new int[]{19,20,21}, ONEWINS_ELEVEN),
            new RouletteSpot(0x55, COLORS.NONE, new int[]{19,22}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x56, COLORS.NONE, new int[]{19,20,22,23}, ONEWINS_EIGHT),
            new RouletteSpot(0x57, COLORS.NONE, new int[]{20,23}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x58, COLORS.NONE, new int[]{20,21,23,24}, ONEWINS_EIGHT),
            new RouletteSpot(0x59, COLORS.NONE, new int[]{21,24}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x5a, COLORS.NONE, new int[]{19,20,21,22,23,24}, ONEWINS_FIVE),
            new RouletteSpot(0x5b, COLORS.NONE, new int[]{22}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x5c, COLORS.NONE, new int[]{22,23}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x5d, COLORS.NONE, new int[]{23}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x5e, COLORS.NONE, new int[]{23,24}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x5f, COLORS.NONE, new int[]{24}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x60, COLORS.NONE, new int[]{22,23,24}, ONEWINS_ELEVEN),
            new RouletteSpot(0x61, COLORS.NONE, new int[]{22,25}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x62, COLORS.NONE, new int[]{22,23,25,26}, ONEWINS_EIGHT),
            new RouletteSpot(0x63, COLORS.NONE, new int[]{23,26}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x64, COLORS.NONE, new int[]{23,24,26,27}, ONEWINS_EIGHT),
            new RouletteSpot(0x65, COLORS.NONE, new int[]{24,27}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x66, COLORS.NONE, new int[]{22,23,24,25,26,27}, ONEWINS_FIVE),
            new RouletteSpot(0x67, COLORS.NONE, new int[]{25}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x68, COLORS.NONE, new int[]{25,26}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x69, COLORS.NONE, new int[]{26}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x6a, COLORS.NONE, new int[]{26,27}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x6b, COLORS.NONE, new int[]{27}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x6c, COLORS.NONE, new int[]{25,26,27}, ONEWINS_ELEVEN),
            new RouletteSpot(0x6d, COLORS.NONE, new int[]{25,28}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x6e, COLORS.NONE, new int[]{25,26,28,29}, ONEWINS_EIGHT),
            new RouletteSpot(0x6f, COLORS.NONE, new int[]{26,29}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x70, COLORS.NONE, new int[]{26,27,29,30}, ONEWINS_EIGHT),
            new RouletteSpot(0x71, COLORS.NONE, new int[]{27,30}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x72, COLORS.NONE, new int[]{25,26,27,28,29,30}, ONEWINS_FIVE),
            new RouletteSpot(0x73, COLORS.NONE, new int[]{28}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x74, COLORS.NONE, new int[]{28,29}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x75, COLORS.NONE, new int[]{29}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x76, COLORS.NONE, new int[]{29,30}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x77, COLORS.NONE, new int[]{30}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x78, COLORS.NONE, new int[]{28,29,30}, ONEWINS_ELEVEN),
            new RouletteSpot(0x79, COLORS.NONE, new int[]{28,31}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x7a, COLORS.NONE, new int[]{28,29,31,32}, ONEWINS_EIGHT),
            new RouletteSpot(0x7b, COLORS.NONE, new int[]{29,32}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x7c, COLORS.NONE, new int[]{29,30,32,33}, ONEWINS_EIGHT),
            new RouletteSpot(0x7d, COLORS.NONE, new int[]{30,33}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x7e, COLORS.NONE, new int[]{28,29,30,31,32,33}, ONEWINS_FIVE),
            new RouletteSpot(0x7f, COLORS.NONE, new int[]{31}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x80, COLORS.NONE, new int[]{31,32}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x81, COLORS.NONE, new int[]{32}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x82, COLORS.NONE, new int[]{32,33}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x83, COLORS.NONE, new int[]{33}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x84, COLORS.NONE, new int[]{31,32,33}, ONEWINS_ELEVEN),
            new RouletteSpot(0x85, COLORS.NONE, new int[]{31,34}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x86, COLORS.NONE, new int[]{31,32,34,35}, ONEWINS_EIGHT),
            new RouletteSpot(0x87, COLORS.NONE, new int[]{32,35}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x88, COLORS.NONE, new int[]{32,33,35,36}, ONEWINS_EIGHT),
            new RouletteSpot(0x89, COLORS.NONE, new int[]{33,36}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x8a, COLORS.NONE, new int[]{31,32,33,34,35,36}, ONEWINS_FIVE),
            new RouletteSpot(0x8b, COLORS.NONE, new int[]{34}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x8c, COLORS.NONE, new int[]{34,35}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x8d, COLORS.NONE, new int[]{35}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x8e, COLORS.NONE, new int[]{35,36}, ONEWINS_SEVENTEEN),
            new RouletteSpot(0x8f, COLORS.NONE, new int[]{36}, ONEWINS_THIRTYFIVE),
            new RouletteSpot(0x90, COLORS.NONE, new int[]{34,35,36}, ONEWINS_ELEVEN),
            new RouletteSpot(0x91, COLORS.NONE, new int[]{1,4,7,10,13,16,19,22,25,28,31,34}, ONEWINS_TWO),
            new RouletteSpot(0x92, COLORS.NONE, new int[]{2,5,8,11,14,17,20,23,26,29,32,35}, ONEWINS_TWO),
            new RouletteSpot(0x93, COLORS.NONE, new int[]{3,6,9,12,15,18,21,24,27,30,33,36}, ONEWINS_TWO),
            new RouletteSpot(0x94, COLORS.NONE, new int[]{1,2,3,4,5,6,7,8,9,10,11,12}, ONEWINS_TWO),
            new RouletteSpot(0x95, COLORS.NONE, new int[]{13,14,15,16,17,18,19,20,21,22,23,24}, ONEWINS_TWO),
            new RouletteSpot(0x96, COLORS.NONE, new int[]{25,26,27,28,29,30,31,32,33,34,35,36}, ONEWINS_TWO),
            new RouletteSpot(0x97, COLORS.NONE, new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18}, ONEWINS_ONE),
            new RouletteSpot(0x98, COLORS.NONE, new int[]{2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36}, ONEWINS_ONE),
            new RouletteSpot(0x99, COLORS.RED, new int[]{1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36}, ONEWINS_ONE),
            new RouletteSpot(0x9a, COLORS.BLACK, new int[]{2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35}, ONEWINS_ONE),
            new RouletteSpot(0x9b, COLORS.NONE, new int[]{1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35}, ONEWINS_ONE),
            new RouletteSpot(0x9c, COLORS.NONE, new int[]{19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36}, ONEWINS_ONE),
    };


    private final RouletteResult results[] = {
            new RouletteResult(COLORS.NONE, PARITY.NONE, 0),
            new RouletteResult(COLORS.RED, PARITY.ODD, 1),
            new RouletteResult(COLORS.BLACK, PARITY.EVEN, 2),
            new RouletteResult(COLORS.RED, PARITY.ODD, 3),
            new RouletteResult(COLORS.BLACK, PARITY.EVEN, 4),
            new RouletteResult(COLORS.RED, PARITY.ODD, 5),
            new RouletteResult(COLORS.BLACK, PARITY.EVEN, 6),
            new RouletteResult(COLORS.RED, PARITY.ODD, 7),
            new RouletteResult(COLORS.BLACK, PARITY.EVEN, 8),
            new RouletteResult(COLORS.RED, PARITY.ODD, 9),
            new RouletteResult(COLORS.BLACK, PARITY.EVEN, 10),
            new RouletteResult(COLORS.BLACK, PARITY.ODD, 11),
            new RouletteResult(COLORS.RED, PARITY.EVEN, 12),
            new RouletteResult(COLORS.BLACK, PARITY.ODD, 13),
            new RouletteResult(COLORS.RED, PARITY.EVEN, 14),
            new RouletteResult(COLORS.BLACK, PARITY.ODD, 15),
            new RouletteResult(COLORS.RED, PARITY.EVEN, 16),
            new RouletteResult(COLORS.BLACK, PARITY.ODD, 17),
            new RouletteResult(COLORS.RED, PARITY.EVEN, 18),
            new RouletteResult(COLORS.RED, PARITY.ODD, 19),
            new RouletteResult(COLORS.BLACK, PARITY.EVEN, 20),
            new RouletteResult(COLORS.RED, PARITY.ODD, 21),
            new RouletteResult(COLORS.BLACK, PARITY.EVEN, 22),
            new RouletteResult(COLORS.RED, PARITY.ODD, 23),
            new RouletteResult(COLORS.BLACK, PARITY.EVEN, 24),
            new RouletteResult(COLORS.RED, PARITY.ODD, 25),
            new RouletteResult(COLORS.BLACK, PARITY.EVEN, 26),
            new RouletteResult(COLORS.RED, PARITY.ODD, 27),
            new RouletteResult(COLORS.BLACK, PARITY.EVEN, 28),
            new RouletteResult(COLORS.BLACK, PARITY.ODD, 29),
            new RouletteResult(COLORS.RED, PARITY.EVEN, 30),
            new RouletteResult(COLORS.BLACK, PARITY.ODD, 31),
            new RouletteResult(COLORS.RED, PARITY.EVEN, 32),
            new RouletteResult(COLORS.BLACK, PARITY.ODD, 33),
            new RouletteResult(COLORS.RED, PARITY.EVEN, 34),
            new RouletteResult(COLORS.BLACK, PARITY.ODD, 35),
            new RouletteResult(COLORS.RED, PARITY.EVEN, 36)
        };



    // Detail Combination and corresponding ID, refer to roulette_bets.png
    private final int TOTAL_BET_SPOTS = rSpots.length;

    //  Roulette results are from number 0 to 36
    private final int TOTAL_RESULTS = results.length;


    public PlayRoulette()
    {

//        for (int i = 0; i < TOTAL_BET_SPOTS; i++)
//        {
//            Log.i("BET", String.format("%2x", rSpots[i].getBetID()));
//
//            int v[] = rSpots[i].getValue();
//            String vStr = "";
//
//            for (int j = 0; j < v.length; j++)
//                vStr += String.format("%2d", v[j]) + ",";
//            Log.i("VALUE", vStr);
//        }
    }


//    public void initializeGame()
//    {
//    }

    public void checkBetWinnings()
    {
    }


    /*
        Roulette betting spot will have the following attribute
          1) Color: RED, BLACK, or None (only 0x99 & 0x9a has color attribute
          2) Parity: ODD, EVEN, or None (only 0x98 & 0x9b has parity attribute.
                     This can be calculate with 'Value'
          3) Value: Can be single or multiple value combination.
          E.g. 0x01 will be {number 0 and 1}, 0x07 will be {number 1}

          Each spot will come with its own unique ID reference
     */
    private class RouletteSpot extends BetSpot {

        private int betID;
        private COLORS color;
        private int value[];
        private double winRate;


        private RouletteSpot (int betID, COLORS color, int value[], double winRate)
        {
            this.betID = betID;
            this.color = color;
            this.value = value;
            this.winRate = winRate;
        }

        private int[] getValue()
        {
            return this.value;
        }

        private int getBetID()
        {
            return this.betID;
        }
    }

    /*
        Roulette Result will roll from 0 to 36 with the attribute of Color, Parity, and Value
     */
    private class RouletteResult extends BetResult {
        COLORS color;
        PARITY parity;
        int value;


        private RouletteResult(COLORS color, PARITY parity, int value)
        {
            this.color = color;
            this.parity = parity;
            this.value = value;
        }

        boolean isBetWon(int betOpen)
        {
            return false;
        }
    }



}
