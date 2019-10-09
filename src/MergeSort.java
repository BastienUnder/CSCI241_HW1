//Sebastien Franks 10/9/2019
//MergeSort.java implements the mergeSort sorting algorithm recursively running O(nlgn)

public class MergeSort {
    public int numCompHolder = 0;

    //runs mergeSort, implemented recursively
    public int[] mergeSort(int[] array, int low, int high){
        //recursively breaks down the array
        if(low < high){
            int mid = (low + high)/2;
            mergeSort(array, low, mid);
            mergeSort(array, mid+1, high);
            merge(array, low, mid, high);

        }

        //prints out the number of comparisons after the array has been sorted
        if(low == 0 && high == array.length-1){
            System.out.println("Num Comparisons: " + numCompHolder);
        }

        return array;
    }

    //performs merge to sort and build the broken array back up to its sorted form
    public void merge(int[] array, int low, int mid, int high){ //or Array, p, q, r
        //setup infinity
        int inf = Integer.MAX_VALUE;
        int numComp = 0;

        //calculate the sizes of the left and right arrays.
        int sizeL = mid - low + 1;
        int sizeR = high - mid;
        //declare the left and right arrays.
        int L[] = new int[sizeL + 1];
        int R[] = new int[sizeR + 1];

        //populate the left and right arrays.
        for(int i = 0; i < sizeL; i++){
            L[i] = array[low + i];
        }
        for(int j = 0; j < sizeR; j++){
            R[j] = array[mid + j + 1];//add in a 1 to keep J pointed at the index in front of L! Ahhh this got me because my arrays are zero indexed unlike the class examples
            //so that by not adding the +1 the R and L arrays were identical b/c the R array was not getting the right values from array. Works after this fix.
        }
        L[sizeL] = inf;
        R[sizeR] = inf;

        //merge the L and R arrays comparing them to determine which element to place first
        int i = 0;
        int j = 0;
        for(int k = low; k < high + 1; k++){
            numComp++;
            if(L[i] <= R[j]){
                array[k] = L[i];
                i = i + 1;
            }
            else{
                array[k] = R[j];
                j = j + 1;
            }
        }
        mergeSortComp(numComp);
    }

    //tallies the number of comparisons done by merge
    private void mergeSortComp(int numComp){
        numCompHolder += numComp;

    }
}
