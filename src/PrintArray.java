//Sebastien Franks 10/9/2019
//PrintArray.java prints the sorted and unsorted arrays if they contain less than 20 elements

public class PrintArray {

    public void printUnsortedArray(int[] array){
        if(array.length < 20){
            System.out.print("Unsorted array: ");
            for(int i = 0; i < array.length; i++){
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }

    public void printSortedArray(int[] array){
        if(array.length < 20){
            System.out.print("Sorted array: ");
            for(int i = 0; i < array.length; i++){
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }
}
