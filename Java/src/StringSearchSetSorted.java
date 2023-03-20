import java.util.Arrays;
import java.util.Random;


public class StringSearchSetSorted {

    public String[] randomWordGenerator(int n) {
        String [] stringArray = new String[n];
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'

        Random random = new Random();

        for (int a = 0; a<n; a++){
            int targetStringLength = 10;
            StringBuilder buffer = new StringBuilder(targetStringLength);
            for (int i = 0; i < targetStringLength; i++) {
                int randomLimitedInt = leftLimit + (int)
                        (random.nextFloat() * (rightLimit - leftLimit + 1));
                buffer.append((char) randomLimitedInt);
            }
            stringArray[a] = buffer.toString();

        }
        return stringArray;
    }
    public void linerSearch(String searchWord, String[] searchList){
        boolean isWordFound = false;
        for (int i=0; i<searchList.length; i++){
            if (searchList[i].equals(searchWord)){
                System.out.println("word found in " + i + " location");
                isWordFound = true;
                break;
            }

        }
        if (!isWordFound){
            System.out.println("Word not found");
        }

    }

    public void  binarySearch(String searchWord, String[] searchList, int leftPosition, int rightPosition){

        if (rightPosition >= 1){
            int middlePosition = (leftPosition + rightPosition) / 2;
            int switchValue = searchWord.compareTo(searchList[middlePosition]);


            if (switchValue == 0) {
                System.out.println("number found " + middlePosition );
            }
            else if (switchValue > 0 ){
                binarySearch(searchWord, searchList, middlePosition+1, rightPosition);
            }
            else  {
                binarySearch(searchWord, searchList, leftPosition, middlePosition-1);
            }
        }
        else {
            System.out.println("Number not found");
        }
    }


    public void jumpSearch(String searchWord, String[] searchList){

        int jumpValue = (int)Math.floor(Math.sqrt(searchList.length)-1);
        int leftPosition = 0;
        int rightPosition = jumpValue;
        int switchValue = searchWord.compareTo(searchList[rightPosition]);


        while (switchValue >= 0 && rightPosition < searchList.length-1){
            leftPosition = rightPosition;
            rightPosition = rightPosition + jumpValue;

            if (rightPosition > searchList.length-1){
                rightPosition = searchList.length-1;
                break;

            }
        }
        for (int i = leftPosition; i<=rightPosition+1; i++){
            if (searchList[i].equals(searchWord)){
                System.out.println("number found in "  + i);
                break;
            }
        }

    }

    public void exponentialSearch(String searchWord, String[] searchList){
        if (searchList[0].equals(searchWord)){
            System.out.println("number found in first index");

        }

        else{
            int i = 1;
            int switchValue = searchWord.compareTo(searchList[i]);
            while (i < searchList.length && switchValue >=0) {
                i = i * 2;
            }
            binarySearch(searchWord, searchList, i / 2, Math.min(i, searchList.length - 1));
        }
    }


    public static void main(String[] args) {
        StringSearchSetSorted stringSearchSetSorted = new StringSearchSetSorted();

        double startTime;
        double stopTime;
        double executionTime;

        String [] thousandStringList = stringSearchSetSorted.randomWordGenerator(1000);
        Arrays.sort(thousandStringList);

        System.out.println("Thousand sorted String list execution liner search");
        startTime = System.nanoTime();
        stringSearchSetSorted.linerSearch(thousandStringList[999], thousandStringList);
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop\n");

        System.out.println("Thousand sorted String list execution binary search");
        startTime = System.nanoTime();
        stringSearchSetSorted.binarySearch(thousandStringList[999], thousandStringList, 0, thousandStringList.length-1);
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop\n");

        System.out.println("Thousand sorted String list execution jump search");
        startTime = System.nanoTime();
        stringSearchSetSorted.jumpSearch(thousandStringList[999], thousandStringList);
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop\n");

        System.out.println("Thousand sorted String list execution exponential search");
        startTime = System.nanoTime();
        stringSearchSetSorted.exponentialSearch(thousandStringList[999], thousandStringList);
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop\n");

//ten Thousand data set
        String [] tenThousandStringList = stringSearchSetSorted.randomWordGenerator(10000);
        Arrays.sort(tenThousandStringList);

        System.out.println("Ten Thousand sorted String list execution liner search");
        startTime = System.nanoTime();
        stringSearchSetSorted.linerSearch(tenThousandStringList[9999], tenThousandStringList);
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop\n");

        System.out.println("Ten Thousand sorted String list execution binary search");
        startTime = System.nanoTime();
        stringSearchSetSorted.binarySearch(tenThousandStringList[9999], tenThousandStringList, 0, tenThousandStringList.length-1);
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop\n");

        System.out.println("Ten Thousand sorted String list execution jump search");
        startTime = System.nanoTime();
        stringSearchSetSorted.jumpSearch(tenThousandStringList[9999], tenThousandStringList);
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop\n");

        System.out.println("Ten Thousand sorted String list execution exponential search");
        startTime = System.nanoTime();
        stringSearchSetSorted.exponentialSearch(tenThousandStringList[9999], tenThousandStringList);
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop\n");

//hundred thousand data set

        String [] hundredThousandStringList = stringSearchSetSorted.randomWordGenerator(100000);
        Arrays.sort(hundredThousandStringList);

        System.out.println("Hundred Thousand sorted String list execution liner search");
        startTime = System.nanoTime();
        stringSearchSetSorted.linerSearch(hundredThousandStringList[99999], hundredThousandStringList);
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop\n");

        System.out.println("Hundred Thousand sorted String list execution binary search");
        startTime = System.nanoTime();
        stringSearchSetSorted.binarySearch(hundredThousandStringList[99999], hundredThousandStringList, 0, hundredThousandStringList.length-1);
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop\n");

        System.out.println("Hundred Thousand sorted String list execution jump search");
        startTime = System.nanoTime();
        stringSearchSetSorted.jumpSearch(hundredThousandStringList[99999], hundredThousandStringList);
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop\n");

        System.out.println("Hundred Thousand sorted String list execution exponential search");
        startTime = System.nanoTime();
        stringSearchSetSorted.exponentialSearch(hundredThousandStringList[99999], hundredThousandStringList);
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop\n");













    }


}
