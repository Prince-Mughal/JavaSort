/*
You may modify or reproduce.
Time: 03:48:17pm Wednesday
Date: 05-09-2018
Email: mughalb9291@gmail.com
Bugs and Criticisms are warmly welcome :) 
(Improvements will be updated soon, like Generic Node )
*/


public class BubbleSort {
    /* Mistake Messages */
    private final String OVER_FLOW =" Sorry, Overflow has been occured.";
    private final String UNDER_FLOW =" Sorry, Underflow has been occured.";
    public final int MAX_SIZE = 100; /* Maximum Size */
    private int[] array; // Array of Integer
    public BubbleSort(int[] iArray){
        sizeVerifier(iArray.length); // Verify size
        copyArray(iArray); // copy array from input 
    }
    // Sort in ascending order
    public void sortAscend(){
        boolean isSorted = false;
        int length       = array.length;
        int dataHolder   = 0;
        for(int current = 0; 
               current < length && isSorted == false;
               current++){
            isSorted = true;
            // each iteration is one sort pass
            for(int walker = length-1; walker > current; walker--){
                if(array[walker] < array[walker-1]){
                    // any exchane means list is not sorted
                    isSorted = false;
                    dataHolder = array[walker];
                    array[walker]   = array[walker-1];
                    array[walker-1] = dataHolder; 
                    
                }
            }
        }
    } 
    // Sort in descending order
    public void sortDescend(){
        boolean isSorted = false;
        int length       = array.length;
        int dataHolder   = 0;
        for(int current = 0; 
               current < length && isSorted == false;
               current++){
            isSorted = true;
            for(int walker = length-1; walker > current; walker--){
                if(array[walker] > array[walker-1]){
                    isSorted = false;
                    dataHolder = array[walker];
                    array[walker]   = array[walker-1];
                    array[walker-1] = dataHolder; 
                    
                }
            }
        }
    } 
    // Print content of entire array
    public void printArray(){
        for(int i = 0; i < array.length; i++)
            System.out.println(array[i]);
    
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
