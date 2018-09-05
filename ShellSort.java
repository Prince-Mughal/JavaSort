/*
You may modify or reproduce.
Time: 03:48:17pm Wednesday
Date: 05-09-2018
Email: mughalb9291@gmail.com
Bugs and Criticisms are warmly welcome :) 
(Improvements will be updated soon, like Generic Node )
*/


public class ShellSort {
    /* Mistake Messages */
    private final String OVER_FLOW =" Sorry, Overflow has been occured.";
    private final String UNDER_FLOW =" Sorry, Underflow has been occured.";
    public final int MAX_SIZE = 100; /* Maximum Size */
    private int[] array; // Array of Integer
    public ShellSort(int[] iArray){
        sizeVerifier(iArray.length); // Verify size
        copyArray(iArray); // copy array from input 
    }
    // Ascending Order
    public void sortAscend(){
        int length = array.length; // partition a list
        int dataHolder = 0;
        for(int increment = length/2; increment != 0; increment /= 2){
            for(int current = increment; current < length ; current++){
                dataHolder = array[current];
                int walker;
                for(walker = current - increment;
                        walker >= 0 && dataHolder < array[walker];
                        walker -= increment){
                    // Large Element apart
                    array[walker + increment] = array[walker];
                }
                // Move to proper location
                array[walker + increment] = dataHolder;
            }
        }     
    } 
    // Sort descending order
    public void sortDescend(){
        long length = array.length; // partition a list
        int dataHolder = 0;
        for(int increment = (int)length/2; increment != 0; increment /= 2){
            for(int current = increment; current < length ; current++){
                dataHolder = array[current];
                int walker;
                for(walker = current - increment;
                        walker >= 0 && dataHolder  > array[walker];
                        walker -= increment){
                    // Large Element apart
                    array[walker + increment] = array[walker];
                }
                // Move to proper location
                array[walker + increment] = dataHolder;
            }
        }     
    }
    // Copy array
    private void copyArray(int[] iArray){
        array = new int[iArray.length];
        for(int i = 0; i < array.length; i++)
            array[i] = iArray[i];
    }
    // Check Overflow / Underflow
    private void sizeVerifier(long iSize){
        if(iSize > MAX_SIZE)
            takeMeOut(OVER_FLOW);
        if(iSize == 0)
            takeMeOut(UNDER_FLOW);
    }
    // Leave a Mistake Message and Exit safely
    private void takeMeOut(String leaveMessage){
        System.err.println(leaveMessage);
        System.exit(0);
    }
}
