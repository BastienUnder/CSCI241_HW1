public class InsertionSort {
    public int[] insertionSort(int[] array){
        int numComp = 0;

        for(int i = 1; i < array.length; i++){
            int j = i;

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
