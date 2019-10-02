public class PrintArray {
    public void printArray(int[] array){
        if(array.length < 20){
            for(int i = 0; i < array.length; i++){
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }
}
