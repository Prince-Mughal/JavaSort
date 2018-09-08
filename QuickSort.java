/*
You may modify or reproduce.
Time: 02:05:17am Sunday
Date: 09-09-2018
Email: mughalb9291@gmail.com
Bugs and Criticisms are warmly welcome :) 
(Improvements will be updated soon, like Generic Node )
*/
package sort;


public class QuickSort {
    /* Mistake Messages */
    private final String OVER_FLOW =" Sorry, Overflow has been occured.";
    private final String UNDER_FLOW =" Sorry, Underflow has been occured.";
    public final int MAX_SIZE = 100; /* Maximum Size */
    private final int MIN_SIZE = 5;
    private int[] array; // Array of Integer
    public QuickSort(int[] iArray){
        sizeVerifier(iArray.length); // Verify size
        copyArray(iArray); // copy array from input 
    }
    // isAscending either true for ascending or false for descending
    public void quickSort(boolean isAscending){
        // Call sorter
        quickSort(0,array.length-1,isAscending);
    }
    // Sort in ascending order
    private void quickSort(int startIndex, int endIndex, boolean isAscending){
        int pivotValue     = -1;
        int sortLeftIndex  = -1;
        int sortRightIndex = -1;
        int dataHolder     =  0;
        if((endIndex - startIndex) > MIN_SIZE){
            // Move Pivot to proper position
            median(startIndex,endIndex);
            pivotValue     = array[startIndex];
            sortLeftIndex  = startIndex+1;
            sortRightIndex = endIndex;
            while(sortLeftIndex < sortRightIndex){
                // Find key on left that belongs on right
                while(array[sortLeftIndex] < pivotValue)
                    sortLeftIndex++;
                // Find key on right that belongs on left
                while(array[sortRightIndex] >= pivotValue)
                    sortRightIndex--;
                if(sortLeftIndex <= sortRightIndex){
                    dataHolder = array[sortLeftIndex];
                    array[sortLeftIndex] = array[sortRightIndex];
                    sortLeftIndex++;
                    sortRightIndex--;
                }
            }
            // Prepare for next Pass
            array[startIndex]      = array[sortLeftIndex-1];
            array[sortLeftIndex-1] = pivotValue;
            if(startIndex < sortRightIndex)
                quickSort(startIndex,sortRightIndex-1,isAscending);
            if(sortLeftIndex < endIndex)
                quickSort(sortLeftIndex,endIndex,isAscending);   
        }else{
            // Ascending Sort or Descending Sort
            if(isAscending)
                insertionSortAscend(startIndex,endIndex);
            else
                insertionSortDescend(startIndex,endIndex);
        }
    }
    // Compute Median
    private void median(int leftIndex, int rightIndex){
        int midIndex = ( leftIndex + rightIndex ) / 2;
        int dataHolder = 0;
        // LeftIndex->Value is greater than midIndex->Value swap them
        if(array[leftIndex] > array[midIndex]){
            dataHolder       = array[leftIndex];
            array[leftIndex] = array[midIndex];
            array[midIndex]  = dataHolder;
        }
        // LeftIndex->Value is greater than rightIndex->Value swap them
        if(array[leftIndex] > array[rightIndex]){
            dataHolder       = array[leftIndex];
            array[leftIndex] = array[rightIndex];
            array[rightIndex]  = dataHolder;
        }
        // midIndex->Value is greater than rightIndex->Value swap them
        if(array[midIndex] > array[rightIndex]){
            dataHolder       = array[midIndex];
            array[midIndex] = array[rightIndex];
            array[rightIndex]  = dataHolder;
        }
        // LeftIndex->Value and rightIndex->Value swap them
        dataHolder       = array[leftIndex];
        array[leftIndex] = array[midIndex];
        array[midIndex]  = dataHolder;
 }
    // Ascending Order
    private void insertionSortAscend(int startIndex, int endIndex){
        int walker = 0;
        int dataHolder = 0;
        for(int current = startIndex+1; current <= endIndex; current++){
            dataHolder = array[current];
            walker = current - 1;
            while( walker >= 0 && dataHolder < array[walker]){
                array[walker+1] = array[walker]; // shift one element right
                walker--;
            }
            // Place to Proper Location
           array[walker+1] = dataHolder;
        }     
    } 
    // Sort descending order
    private void insertionSortDescend(int startIndex,int endIndex){
        int walker = 0;
        int dataHolder = 0;
        for(int current = 1; current < array.length; current++){
            dataHolder = array[current];
            walker = current - 1;
            while( walker >= 0 && dataHolder > array[walker]){
                array[walker+1] = array[walker]; // shift one element right
                walker--;
            }
            // Place to Proper Location
           array[walker+1] = dataHolder;
        }     
    }
    // Print content of entire array
    public void printArray(){
        System.out.println();
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i]+" ");
        System.out.println();
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
