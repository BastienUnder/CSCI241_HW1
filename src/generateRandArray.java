//Sebastien Franks 10/9/2019
//generateRandArray.java generates a random array and also clones it for use by multiple sorts

import java.util.Random;

public class generateRandArray {
    private int[] array;
    //generates a random array based of user's desired size
    public void genRandArr(int n){
        array = new int[n];
        Random rand = new Random();

        //populate the empty array with random values from -n to n
        for(int i = 0; i < array.length; i++){
            int tempRand = rand.nextInt(n+1);

            //if zero let it be entered
            if(tempRand == 0){
                array[i] = 0;
            }

            //use a second random value to decide whether or not to make the original rand value positive
            else if(rand.nextInt(2) == 0){
                array[i] = rand.nextInt(n);
            }

            //or in this case negative
            else{
                array[i] = rand.nextInt(n+1) * -1;
            }

        }
    }

    //creates a clone of the random array so that the array is not modified by other sorts and then used in its modified form
     public int[] clone() {
        int[] deepCopy = new int[array.length];
        for(int i = 0; i < array.length; i++){
            deepCopy[i] = array[i];
        }
        return deepCopy;

    }
}
