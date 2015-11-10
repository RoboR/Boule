package com.robor.boule;

import android.util.Log;

/**
 * Created by RoboR on 11/10/2015.
 */
public class UtilityCalc {

    /*
        Convert array of byte (size 1 to 4) to integer type
     */
    public static int BytesToInt(int byteArr[]) {
        long valueLong = 0;
        int valueInt;
        int byteLen = byteArr.length;

        //Not greater than 4 bytes
        if (byteLen > 4)
            return 0;

        //CALCULATE AND CAST TO SIGNED
        for (int i = 0; i < byteLen; i++)
            valueLong += (long)((byteArr[i] & 0xFF) * Math.pow(0x10, 2*(byteLen-1 - i)) );

        valueInt = (int)(valueLong & 0xFFFFFFFF);

        return valueInt;
    }


    /*
        Convert the value (0x000000L to 0xFFFFFFL) to byte array (1 to 4 size)
     */
    public static int[] IntToByteArr(int value) {
        long valueL = ((long)value) & 0xFFFFFFFFL;
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

        int byteArr[] = new int[byteLen+1];
        bitmask = 0xffL;
        int i = byteArr.length - 1;

        while (valueL > 0L)
        {
            long ll = valueL & bitmask;
            byteArr[i--] = (int) (valueL & bitmask);
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
    public static int[] IntToByteArr(int value, int size) {
        int byteArr[] = IntToByteArr(value);
        int newByteArr[] = new int[size];

        for (int i = byteArr.length-1, j = size-1; i >= 0; i--, j--)
            newByteArr[j] = byteArr[i];

        return newByteArr;
    }


    public static int[] CombineBtyeArray(int startArr[], int endArr[]) {
        int newArr[] = new int[startArr.length + endArr.length];
        int i = 0;

        for (int j = 0; j < startArr.length; i++, j++)
            newArr[i] = startArr[j];
        for (int j = 0; j < endArr.length; i++, j++)
            newArr[i] = endArr[j];

        return newArr;
    }
}
