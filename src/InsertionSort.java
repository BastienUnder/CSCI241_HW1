//Sebastien Franks 10/9/2019
//InsertionSort.java sorts the array and returns the number of comparisons it took to sort

public class InsertionSort {

    //sorts the array using insertion sort
    public int[] insertionSort(int[] array){
        int numComp = 0;

        //implement through each element in the array
        for(int i = 1; i < array.length; i++){
            int j = i;

            //for each element in the array move the current i element to its sorted location
            while(j > 0 && array[j] < array[j-1]){
                numComp++;
                int tempVar = array[j];

                //swap the values in the array
                array[j] = array[j-1];
                array[j-1] = tempVar;
                j--;
            }
        }

        System.out.println("Num Comparisons: " + numComp);

        return array;
    }
}
