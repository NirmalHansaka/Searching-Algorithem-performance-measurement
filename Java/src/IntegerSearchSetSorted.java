import java.lang.Math;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;


public class IntegerSearchSetSorted {

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
            if (searchNumber == searchList[i]){
                System.out.println("number found in " + i + " location");
                isNumberFound = true;
                break;
            }

        }
        if (!isNumberFound){
            System.out.println("Number not found");
        }
    }
    public void  binarySearch(int searchNumber, int[] searchList, int leftPosition, int rightPosition){

        if (rightPosition >= 1){
            int middlePosition = (leftPosition + rightPosition) / 2;



            if (searchList[middlePosition] == searchNumber) {
                System.out.println("number found " + middlePosition );
            }
            else if (searchList[middlePosition] < searchNumber  ){
                binarySearch(searchNumber, searchList, middlePosition+1, rightPosition);
            }
            else  {
                binarySearch(searchNumber, searchList, leftPosition, middlePosition-1);
            }
        }
        else {
            System.out.println("Number not found");
        }
    }

    public void jumpSearch(int searchNumber, int[] searchList){

        int jumpValue = (int)Math.floor(Math.sqrt(searchList.length)-1);
        int leftPosition = 0;
        int rightPosition = jumpValue;


        while (searchList[rightPosition]<= searchNumber && rightPosition < searchList.length-1){
            leftPosition = rightPosition;
            rightPosition = rightPosition + jumpValue;

            if (rightPosition > searchList.length-1){
                rightPosition = searchList.length-1;
                break;

            }
        }
        for (int i = leftPosition; i<=rightPosition+1; i++){
            if (searchList[i]== searchNumber ){
                System.out.println("number found in "  + i);
                break;
            }
        }

    }

    public void exponentialSearch(int searchNumber, int[] searchList){
        if (searchList[0] == searchNumber){
            System.out.println("number found in first index");

        }

        else{
            int i = 1;
            while (i < searchList.length && searchList[i] <= searchNumber) {
                i = i * 2;
            }
            binarySearch(searchNumber, searchList, i / 2, Math.min(i, searchList.length - 1));
        }
    }

    public void interpolationSearch(int searchNumber, int[] searchList){

        int leftPosition = 0;
        int rightPosition = searchList.length-1;

        while (searchList[rightPosition] != searchList[leftPosition] && searchNumber <= searchList[rightPosition] && searchList[leftPosition] <= searchNumber){
            int midPosition = leftPosition + (searchNumber - searchList[leftPosition]) * (int)((rightPosition-leftPosition)/ (searchList[rightPosition]-searchList[leftPosition]));
            if (searchList[midPosition] == searchNumber){
                System.out.println("Number found");
                break;
            } else if (searchList[midPosition] < searchNumber) {
                leftPosition = midPosition + 1;
            }

              else {
                  rightPosition = midPosition + 1;
            }

            }
        }

    public static void main(String[] args) {

        IntegerSearchSetSorted integerSearchSetSorted = new IntegerSearchSetSorted();

        double startTime;
        double stopTime;
        double executionTime;

        int [] thousandRandomList = integerSearchSetSorted.randomGenerator(1000);
        Arrays.sort(thousandRandomList);

        System.out.println("Thousand sorted integer list  liner search execution");
        startTime = System.nanoTime();
        integerSearchSetSorted.linerSearch(thousandRandomList[999], thousandRandomList);
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop \n");

        System.out.println("Thousand sorted integer list  binary search execution");
        startTime = System.nanoTime();
        stopTime = System.nanoTime();
        integerSearchSetSorted.binarySearch(thousandRandomList[999], thousandRandomList, 0, thousandRandomList.length-1 );
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop \n");

        System.out.println("Thousand sorted integer list jump search execution");
        startTime = System.nanoTime();
        integerSearchSetSorted.jumpSearch(thousandRandomList[999], thousandRandomList);
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop \n");

        System.out.println("Thousand sorted integer list exponential search execution");
        startTime = System.nanoTime();
        integerSearchSetSorted.exponentialSearch(thousandRandomList[999], thousandRandomList );
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop \n");

        System.out.println("Thousand sorted integer list interpolation search execution");
        startTime = System.nanoTime();
        integerSearchSetSorted.interpolationSearch(thousandRandomList[999], thousandRandomList );
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop \n");


        int [] tenThousandRandomList = integerSearchSetSorted.randomGenerator(10000);
        Arrays.sort(tenThousandRandomList);

        System.out.println("Ten Thousand sorted integer list  liner search execution");
        startTime = System.nanoTime();
        integerSearchSetSorted.linerSearch(tenThousandRandomList[9999], tenThousandRandomList);
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop \n");

        System.out.println("Ten Thousand sorted integer list  binary search execution");
        startTime = System.nanoTime();
        integerSearchSetSorted.binarySearch(tenThousandRandomList[9999], tenThousandRandomList, 0, tenThousandRandomList.length-1);
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop \n");

        System.out.println("Ten Thousand sorted integer list  jump search execution");
        startTime = System.nanoTime();
        integerSearchSetSorted.jumpSearch(tenThousandRandomList[9999], tenThousandRandomList );
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop \n");


        System.out.println("Ten Thousand sorted integer list exponential search execution");
        startTime = System.nanoTime();
        integerSearchSetSorted.exponentialSearch(tenThousandRandomList[9999], tenThousandRandomList );
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop \n");
//
        System.out.println("Ten Thousand sorted integer list interpolation search execution");
        startTime = System.nanoTime();
        integerSearchSetSorted.interpolationSearch(tenThousandRandomList[9999], tenThousandRandomList );
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop \n");
//
        int [] hundredThousandRandomList = integerSearchSetSorted.randomGenerator(100000);
        Arrays.sort(hundredThousandRandomList);

        System.out.println("Hundred Thousand sorted integer list  liner search execution");
        startTime = System.nanoTime();
        integerSearchSetSorted.linerSearch(hundredThousandRandomList[99999], hundredThousandRandomList);
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop \n");

        System.out.println("Hundred Thousand sorted integer list  binary search execution");
        startTime = System.nanoTime();
        integerSearchSetSorted.binarySearch(hundredThousandRandomList[99999], hundredThousandRandomList, 0, hundredThousandRandomList.length-1);
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop \n");

        System.out.println("Hundred Thousand sorted integer list  jump search execution");
        startTime = System.nanoTime();
        integerSearchSetSorted.jumpSearch(hundredThousandRandomList[99999], hundredThousandRandomList );
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop \n");


        System.out.println("Hundred Thousand sorted integer list exponential search execution");
        startTime = System.nanoTime();
        integerSearchSetSorted.exponentialSearch(hundredThousandRandomList[99999], hundredThousandRandomList );
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop \n");

        System.out.println("Hundred Thousand sorted integer list interpolation search execution");
        startTime = System.nanoTime();
        integerSearchSetSorted.interpolationSearch(hundredThousandRandomList[99999], hundredThousandRandomList );
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop \n");


    }


}
