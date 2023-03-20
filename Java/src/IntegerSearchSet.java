import java.lang.Math;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class IntegerSearchSet {

    public int[] randomGenerator(int n){

        Random random = new Random();
        int[] randomList = new int[n];
        for (int i=0; i<=n-1; i++){
            int randomNumber = random.nextInt(1000000);
            randomList[i] = randomNumber;
        }

        return  randomList;
    }

    public void linerSearch(int searchNumber, int[] searchList){
        boolean isNumberFound = false;
        for (int i=0; i<searchList.length; i++){
            if (searchList[i] == searchNumber){
                System.out.println("number found in " + i + " location");
                isNumberFound = true;
                break;
            }

        }
        if (!isNumberFound){
            System.out.println("Number not found");
        }
    }

    public static void main(String[] args) {
        IntegerSearchSet integerSearchSet = new IntegerSearchSet();
        double startTime;
        double stopTime;
        double executionTime;


        int [] randomThousandList = integerSearchSet.randomGenerator(1000);
        System.out.println("Thousand unsorted integer list execution liner search");
        startTime = System.nanoTime();
        integerSearchSet.linerSearch(randomThousandList[999], randomThousandList);
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop \n");

        int [] randomTenThousandList = integerSearchSet.randomGenerator(10000);
        System.out.println("Ten Thousand unsorted integer list execution liner search");
        startTime = System.nanoTime();
        integerSearchSet.linerSearch(randomTenThousandList[9999], randomTenThousandList);
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop \n");


        int [] randomHundredThousandList = integerSearchSet.randomGenerator(100000);
        System.out.println("Hundred Thousand unsorted integer list execution liner search");
        startTime = System.nanoTime();
        integerSearchSet.linerSearch(randomHundredThousandList[99999], randomHundredThousandList);
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop");


    }

}
