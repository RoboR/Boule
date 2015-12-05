package com.robor.boule;

/**
 * Created by RoboR on 11/10/2015.
 */
public class BetTracker {
    public static final int BETID_SIZE = 2;
    public static final int BETAMNT_SIZE = 4;

    public static final int BET_ARRAY_SIZE = BETID_SIZE + BETAMNT_SIZE;
    public static final int BETID_START_IDX = 0;
    public static final int BETID_END_IDX = BETID_START_IDX + BETID_SIZE - 1;
    public static final int BETAMNT_START_IDX = BETID_START_IDX + 1;
    public static final int BETAMNT_END_IDX = BETAMNT_START_IDX + BETAMNT_SIZE - 1;
    /**
     *
     *
     *
     *                 Bet Tracker:
     *
     *       -------------------------------------
             |  0  |  1  |  2  |  3  |  4  |  5  |
             -------------------------------------
             |   Bet ID  |         Amount        |
             -------------------------------------
     */

    private int betID;
    private long betAmount;


    /**
     *
     * @param betID
     * @param amount
     * @return true if Successful, false if failed
     */
    public BetTracker(int betID, long amount) {
        this.betID = (betID & 0xFFFF);
        this.betAmount = (amount & 0xFFFFFFFFL);
    }

    /**
     *
     * @param betTracker 6 Byte
     * @return true if Successful, false if failed
     */
    public BetTracker(byte betTracker[]) {
        byte betIdArr[],
             betAmtArr[];

        if ((betIdArr = subByte(betTracker, BETID_START_IDX, BETID_END_IDX)) != null &&
                (betAmtArr = subByte(betTracker, BETAMNT_START_IDX, BETAMNT_END_IDX)) != null)
        {
            this.betID = bytesToInt(betIdArr);
            this.betAmount = bytesToLong(betAmtArr);
        }
    }

    /**
     *
     * @param betID 2 Byte size
     * @param amount 4 Byte size
     * @return true if Successful, false if failed
     *
     */
    public BetTracker(byte betID[], byte amount[]) {
        this.betID = bytesToInt(betID);
        this.betAmount = bytesToLong(amount);
    }


    public byte[] getBetTrackerBytes(BetTracker bet) {
        byte bt[] = combineBtyeArray(valueToByteArr(bet.betID, BETID_SIZE),
                valueToByteArr(bet.betAmount, BETAMNT_SIZE));

        return bt;
    }

    public int getBetID() {
        return this.betID;
    }

    public long getBetAmount() {
        return this.betAmount;
    }



    /**
     * subByte(array, 2, 5) returns a 4 byte array from array[2] to array[5]
     * @param byteArray
     * @param idxFrom
     * @param idxTo
     * @return
     */
    private static byte[] subByte(byte byteArray[], int idxFrom, int idxTo) {
        if (idxFrom < 0 || idxTo > byteArray.length)
            return null;

        byte newByteArray[] = new byte[idxTo-idxFrom+1];

        for (int i=idxFrom, j=0; i <= idxTo; i++, j++)
            newByteArray[j] = byteArray[i];

        return newByteArray;
    }


    /*
        Convert array of byte (size 1 to 4) to long type
     */
    private static long bytesToLong(byte byteArr[]) {
        long valueLong = 0;
        int byteLen = byteArr.length;

        //Not greater than 4 bytes
        if (byteLen > 4)
            return 0;

        //CALCULATE AND CAST TO SIGNED
        for (int i = 0; i < byteLen; i++)
            valueLong += (long)(((int)(byteArr[i]&0xFF)) * Math.pow(0x10, 2*(byteLen-1 - i)));

        valueLong = (valueLong & 0xFFFFFFFF);

        return valueLong;
    }

    /*
    Convert array of byte (size 1 to 4) to integer type
 */
    private static int bytesToInt(byte byteArr[]) {
        long valueLong = 0;
        int valueInt = 0;
        int byteLen = byteArr.length;

        //Not greater than 4 bytes
        if (byteLen > 4)
            return 0;

        //CALCULATE AND CAST TO SIGNED
        for (int i = 0; i < byteLen; i++)
            valueLong += (long)(((int)(byteArr[i]&0xFF)) * Math.pow(0x10, 2*(byteLen-1 - i)));

        valueInt = (int)(valueLong & 0xFFFFFFFF);

        return valueInt;
    }

    /*
        Convert the value (0x000000L to 0xFFFFFFL) to byte array (1 to 4 size)
     */
    private static byte[] valueToByteArray(long value) {
        long valueL = value & 0xFFFFFFFFL;
        int byteLen = 0;
        long bitmask = 0xff000000L;
        long factorBit = 0x01000000L;

        while (bitmask > 0L)
        {
            if ((valueL & bitmask) > 0L) {
                byteLen = ((int) (Math.log10(factorBit) / Math.log10(0xFF)));
                bitmask = 0L;
            }
            bitmask = bitmask >> 8;
            factorBit = factorBit >> 8;
        }

        byte byteArr[] = new byte[byteLen+1];
        bitmask = 0xffL;
        int i = byteArr.length - 1;

        while (valueL > 0L)
        {
            long ll = valueL & bitmask;
            byteArr[i--] = (byte) (valueL & bitmask);
            valueL = valueL >> 8;
        }

        return byteArr;
    }


    /**
     * Convert to a define size
     *
     * @param value
     * @param size
     * @return
     */
    private static byte[] valueToByteArr(long value, int size) {
        byte byteArr[] = valueToByteArray(value);
        byte newByteArr[] = new byte[size];

        for (int i = byteArr.length-1, j = size-1; i >= 0; i--, j--)
            newByteArr[j] = byteArr[i];

        return newByteArr;
    }

    private static byte[] valueToByteArr(int value, int size) {
        byte byteArr[] = valueToByteArray(value);
        byte newByteArr[] = new byte[size];

        for (int i = byteArr.length-1, j = size-1; i >= 0; i--, j--)
            newByteArr[j] = byteArr[i];

        return newByteArr;
    }


    private static byte[] combineBtyeArray(byte startArr[], byte endArr[]) {
        byte newArr[] = new byte[startArr.length + endArr.length];
        int i = 0;

        for (int j = 0; j < startArr.length; i++, j++)
            newArr[i] = startArr[j];
        for (int j = 0; j < endArr.length; i++, j++)
            newArr[i] = endArr[j];

        return newArr;
    }
}
