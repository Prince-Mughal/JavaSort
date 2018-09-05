/*
You may modify or reproduce.
Time: 12:37:17am Thursday
Date: 06-09-2018
Email: mughalb9291@gmail.com
Bugs and Criticisms are warmly welcome :) 
(Improvements are possible in divide and conquer function
 for simplicity i separated ascending and descending.
 Both asDivide and desDivide are identical.
 Both asConquer and desConquer are nearly identical except
 comparison part . So we can split comparison part into Ascending and descanding,
 and call appropriate. 
 remaining code is same for both... 
 in future , I will try to eliminate it.)
*/


public class MergeSort {
    /* Mistake Messages */
    private final String OVER_FLOW =" Sorry, Overflow has been occured.";
    private final String UNDER_FLOW =" Sorry, Underflow has been occured.";
    public final int MAX_SIZE = 100; /* Maximum Size */
    private int[] array; // Array of Integer
    public MergeSort(int[] iArray){
        sizeVerifier(iArray.length); // Verify size
        copyArray(iArray); // copy array from input 
    }
    // Sort in ascending order
    public void sortAscend(){
        // call Sort Handler
        asDivide(0,array.length-1);
    }
    // split into two sublists
    private void asDivide(int start,int end){
        if( start < end){ // base condition
            int mid = (start + end )/ 2; // compute middle
            asDivide(start, mid); // split into sublist recursively
            asDivide(mid+1,end); // slit into sublist recursively
            asConquer(start,mid,end); // combine two sublist recursively
        }
    }
    // combine two sublists
    private void asConquer(int start, int mid, int end){
        int size01  = mid - start + 1; // compute left sublist size
        int size02  = end - mid; // compute right sublist size
        int[] left  = new int[size01];
        int[] right = new int[size02];
        // copy first half
        for(int i = 0; i < left.length; i++)
            left[i] = array[start+i];
        // Compy second half
        for(int j = 0; j < right.length; j++)
            right[j] = array[mid+j+1];
        int iHandler = 0; // left sublist handler
        int jHandler = 0; // right sublist handler
        int kHandler = start; // Proper Position handler
        // Copy until one of them or both sublists get empty
        while( iHandler < left.length && jHandler < right.length){
            if(left[iHandler] <= right[jHandler]){
                array[kHandler++] = left[iHandler++];
            }else{
                array[kHandler++] = right[jHandler++];
            }
        }
        // Copy remaining in Left Sublist
        while(iHandler < jHandler)
            array[kHandler++] = left[iHandler++];
        // Copy remaining in Right Sublist
        while(jHandler < iHandler)
            array[kHandler++] = right[jHandler++];
}
   
  // Sort in ascending order
    public void sortDescend(){
        // call Sort Handler
        desDivide(0,array.length-1);
    }
    // split into two sublists
    private void desDivide(int start,int end){
        if( start < end){ // base condition
            int mid = (start + end )/ 2; // compute middle
            desDivide(start, mid); // split into sublist recursively
            desDivide(mid+1,end); // slit into sublist recursively
            desConquer(start,mid,end); // combine two sublist recursively
        }
    }
    // Combine two sublist
    private void desConquer(int start, int mid, int end){
        int size01  = mid - start + 1; // compute left sublist size
        int size02  = end - mid; // compute right sublist size
        int[] left  = new int[size01];
        int[] right = new int[size02];
        // copy first half
        for(int i = 0; i < left.length; i++)
            left[i] = array[start+i];
        // Compy second half
        for(int j = 0; j < right.length; j++)
            right[j] = array[mid+j+1];
        int iHandler = 0; // left sublist handler
        int jHandler = 0; // right sublist handler
        int kHandler = start; // Proper Position handler
        // Copy until one of them or both sublists get empty
        while( iHandler < left.length && jHandler < right.length){
            if(left[iHandler] >= right[jHandler]){
                array[kHandler++] = left[iHandler++];
            }else{
                array[kHandler++] = right[jHandler++];
            }
        }
        // Copy remaining in Left Sublist
        while(iHandler < jHandler)
            array[kHandler++] = left[iHandler++];
        // Copy remaining in Right Sublist
        while(jHandler < iHandler)
            array[kHandler++] = right[jHandler++];
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
