//Sebastien Franks 10/9/2019
//RadixSort.java sorts an unsorted array of negative and positive integers using LSD Radix Sort along with a modified bucket sort.

public class RadixSort {

    //implements LSD Radix Sort
    public int[] radixSort(int[] array){
        //find the number of digits by calling countDigits
        int d = countDigits(array);

        //run bucket sort as many times as there are digits in the element with the most digits
        for(int i = 0; i < d; i++){
            bucketSort(array, i);
        }

        //radix sort does not compare elements in the array against each other to sort
        System.out.println("Num Comparisons: 0");
        return array;
    }

    //implements bucket sort
    public int[] bucketSort(int[] array, int currentD){
        int[][] negArray = new int[10][array.length];
        int[][] posArray = new int[10][array.length];

        int dBucket = 0;//stores the number of the bucket for the current array value
        int zeroCount = 0;//keep track of the number of zeros in the array

        //for each value in the array dump it in the correct bucket
        for(int i = 0; i < array.length; i++){
            int valModifier = array[i]; //stores the modified array value to use modulus on and find the correct dBucket value

            //find the 0-9 value in the current iteration digit location
            for(int j = 0; j < currentD+1; j++) { //run for d times, modulo saved as integer truncates
                dBucket = valModifier % 10;
                valModifier = valModifier / 10;
            }

            //check if the number in the array is negative
            //populate the negative array
            if(array[i] < 0){
                negArray[dBucket * -1][i] = array[i];
            }

            //keep track of the number of zeros in the array
            else if(array[i] == 0){
                zeroCount++;
            }

            //else the number is positive
            //populate the positive array
            else{
                posArray[dBucket][i] = array[i];
            }
        }

        //combine the negative and positive arrays.
            //add in the negative elements to array
            int mid = 0;
            for(int h = 9; h >= 0; h--){
                for(int k = 0; k < array.length; k++) {
                    if (negArray[h][k] < 0) {
                        array[mid] = negArray[h][k];
                        mid++;
                    }
                }
            }

            //add in the zeros to array
            for(int t = 0; t < zeroCount; t++){
                array[mid] = 0;
                mid++;
            }

            //add in the positive elements to array
            for(int g = 0; g < 10; g++){
                for(int s = 0; s < array.length; s++) {
                    if (posArray[g][s] > 0) {
                        array[mid] = posArray[g][s];
                        mid++;
                    }
                }
            }

        return array;
    }

    //Counts the number of digits in the absolute value largest number for use by radixSort and bucketSort
    public int countDigits(int[] array){
        int d = array[0];

        //for each element in the array find the largest value with absolute value and count its digits
        for(int i = 1; i < array.length; i++){
            if(Math.abs(array[i]) > Math.abs(d)){
                d = array[i];
            }
        }
        d = Math.abs(d);
        String digits = Integer.toString(d);

        return digits.length();
    }


}
