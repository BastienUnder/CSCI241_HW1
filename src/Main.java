import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int array[] = {3,2,40,7,4,7,8,5,66,34,12};
        int array2[] = {38, 28, 50, 1, 42, 54, 26, 60, 6, 69, 25, 16, 9, 44, 63};

        //Get array size from user
        System.out.println("How many entries? ");
        Scanner scanner = new Scanner(System.in);
        int userN = scanner.nextInt();

        //generate the random, unsorted array
        generateRandArray g = new generateRandArray();
        int[] arrayR = g.genRandArr(userN);

        //Print the random, unsorted array
        PrintArray pr = new PrintArray();
        System.out.print("Unsorted array: ");
        pr.printArray(arrayR);

        //perform insertionSort on the array
        InsertionSort is = new InsertionSort();
        int[] iSArray = is.insertionSort(arrayR);

        //Print the sorted array sorted by insertionSort
        System.out.print("Sorted array: ");
        pr.printArray(iSArray);

    }
}
