import java.util.Arrays;
import java.util.Random;

public class StringSearchSet {

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


    public static void main(String[] args) {

        StringSearchSet stringSearchSet = new StringSearchSet();
        double startTime;
        double stopTime;
        double executionTime;

        String [] thousandWordList = stringSearchSet.randomWordGenerator(1000);
        System.out.println("Thousand unsorted String list execution liner search");
        startTime = System.nanoTime();
        stringSearchSet.linerSearch(thousandWordList[999], thousandWordList);
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop\n");

        String [] tenThousandWordList = stringSearchSet.randomWordGenerator(10000);
        System.out.println("Ten Thousand unsorted String list execution liner search");
        startTime = System.nanoTime();
        stringSearchSet.linerSearch(tenThousandWordList[9999], tenThousandWordList);
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop\n");

        String [] hundredThousandWordList = stringSearchSet.randomWordGenerator(100000);
        System.out.println("Hundred Thousand unsorted String list execution liner search");
        startTime = System.nanoTime();
        stringSearchSet.linerSearch(hundredThousandWordList[99999], hundredThousandWordList);
        stopTime = System.nanoTime();
        executionTime = stopTime - startTime;
        System.out.println("Execution Time "+executionTime/1000000 + "ms");
        System.out.println("Stop\n");


    }
}
