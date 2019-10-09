//Sebastien Franks 10/9/2019
//QuickSort.java implements the recursive quick sort on an array

public class QuickSort {
    public int numCompHolder = 0;

    //implements the recursive aspect of quick sort
    public int[] quickSort(int[] array, int low, int high){
        //base case when if statement not met.
        if(low < high){
            int q = partition(array, low, high);
            quickSort(array,low, q-1);
            quickSort(array, q+1, high);
        }

        //print out the number of comparisons quick sort took after done sorting the array
        if(low == 0 && high == array.length-1){
            System.out.println("Num Comparisons: " + numCompHolder);
        }

        return array;
    }

    //run the partition function to sort the array based around the pivot method
    public int partition(int[] array, int low, int high){
        int x = array[high];
        int i = low - 1;
        int numComp = 0;

        //Created an error here by setting j = 0 instead of low which of course led to outOfBounds Exception.
        //Also second error was that I set j < high - 1 which is wrong because it will do one too few iterations.
        for(int j = low; j < high; j++){ //run through this section of the array and set a pivot point so that the pivot is in its final, sorted, location
            if(array[j] <= x){
                numComp++;
                i = i + 1;
                //swap array[i] with array[j]
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        //swaps high value with i+1 value to set the pivot
        int temp2 = array[i+1];
        array[i+1] = array[high];
        array[high] = temp2;

        quickSortComp(numComp);

        //returns the location of the pivot
        return i+1;
    }

    //tallies the number of comparisons done by quick sort
    private void quickSortComp(int numComp){
        numCompHolder += numComp;

    }
}
