import java.util.Random;

public class generateRandArray {
    public int[] genRandArr(int n){
        int[] array = new int[n];
        Random rand = new Random();

        for(int i = 0; i < array.length; i++){
            int tempRand = rand.nextInt(n+1);

            if(tempRand == 0){
                array[i] = 0;
            }

            else if(rand.nextInt(2) == 0){
                array[i] = rand.nextInt(n);
            }
            else{
                array[i] = rand.nextInt(n+1) * -1;
            }

        }

        return array;
    }
}
