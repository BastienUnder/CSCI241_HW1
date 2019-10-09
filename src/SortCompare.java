//Sebastien Franks 10/8/2019
//SortCompare.java calls the implemented sorts to sort an array in a variety of ways so we can compare there performance
//Citations: Got ideas for insertionSort from the Algorithm Design Manual by Steven S. Skiena.
import java.util.Scanner;

public class SortCompare {
    //Starts by getting the user data and generating the array before implementing the sorts
    public static void main(String args[]){
        SortCompare user = new SortCompare();
        user.getUserData();
    }

    //if called run merge sort
    public void mergeSort(int[] array){
        System.out.println("merge sort \n==========");

        PrintArray pr = new PrintArray();
        pr.printUnsortedArray(array);

        //initialize and run MergeSort.java
        MergeSort mg = new MergeSort();
        int[] mgArray = mg.mergeSort(array, 0, array.length-1);

        pr.printSortedArray(mgArray);

    }

    // if called run quick sort
    public void quickSort(int[] array){
        System.out.println("quick sort\n==========");

        PrintArray pr = new PrintArray();
        pr.printUnsortedArray(array);

        //initialize and run QuickSort.java
        QuickSort qs = new QuickSort();
        int[] qsArray = qs.quickSort(array, 0, array.length-1);

        pr.printSortedArray(qsArray);

    }

    //if called run insertion sort
    public void insertionSort(int[] array){
        System.out.println("insertion sort\n==============");

        PrintArray pr = new PrintArray();
        pr.printUnsortedArray(array);

        //initialize and run InsertionSort.java
        InsertionSort is = new InsertionSort();
        int[] isArray = is.insertionSort(array);

        pr.printSortedArray(isArray);

    }

    //if called run radix sort
    public void radixSort(int[] array){
        System.out.println("radix sort\n==========");

        PrintArray pr = new PrintArray();
        pr.printUnsortedArray(array);

        //initialize and run RadixSort.java
        RadixSort rd = new RadixSort();
        int[] rdArray = rd.radixSort(array);

        pr.printSortedArray(rdArray);

    }

    //gets the user to input the size of the array, calls the function to generate the random array and clone it
    public void getUserData(){
        //Get array size from user
        System.out.println("How many entries? ");
        Scanner scanner = new Scanner(System.in);
        int userN = scanner.nextInt();

        //generate the random, unsorted array
        generateRandArray g = new generateRandArray();
        g.genRandArr(userN);

        //generates clones of the array for each sort
        int[] arrayM =  g.clone();
        int[] arrayI = g.clone();
        int[] arrayQ = g.clone();
        int[] arrayR = g.clone();

        //asks user for desired sort
        System.out.println("Which sort [m,i,q,r,all]?");
        String whichSort = scanner.next();

        //calls sort and passes the arrays and decision on which sort to then call and run the desired sort
        sort(arrayM, arrayI, arrayQ, arrayR, whichSort);
    }

    //based off user's decision implements the chosen sort, or all of them
    public void sort(int[] arrayM, int[] arrayI, int[] arrayQ, int[] arrayR, String whichSort){
        switch(whichSort){
            case "m":
                mergeSort(arrayM);
                break;
            case "i":
                insertionSort(arrayI);
                break;
            case "q":
                quickSort(arrayQ);
                break;
            case "r":
                radixSort(arrayR);
                break;
            case "all":
                mergeSort(arrayM);
                System.out.println();

                insertionSort(arrayI);
                System.out.println();

                quickSort(arrayQ);
                System.out.println();

                radixSort(arrayR);
                break;
        }
    }

}
