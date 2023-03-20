import java.lang.Math;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class SearchAlgorithems {

    public int[] randomGenerator(){

        Random random = new Random();

        int[] randomList = new int[1000];

        for (int i=0; i<=999; i++){
           int randomNumber = random.nextInt(1000000);
           randomList[i] = randomNumber;
        }

        return  randomList;

    }



    public void linerSearch(int searchNumber, int[] searchList){

        for (int i=0; i<searchList.length; i++){
            if (searchList[i] == searchNumber){
                System.out.println("number found in " + i + " location");
                break;
            }
        }
    }

    public void  binarySearch(int searchNumber, int[] searchList, int leftPosition, int rightPosition){

        if (rightPosition >= 1){
            int middlePosition = (leftPosition + rightPosition) / 2;

            if (searchNumber == searchList[middlePosition]){
                System.out.println("number found " + middlePosition );
            }
            else if (searchNumber > searchList[middlePosition]){
                binarySearch(searchNumber, searchList, middlePosition+1, rightPosition);
            }
            else {
                leftPosition = leftPosition + 1;
                binarySearch(searchNumber, searchList, leftPosition, middlePosition-1);
            }
        }
    }

    public void jumpSearch(int searchNumber, int[] searchList){

        int jumpValue = (int)Math.floor(Math.sqrt(searchList.length)-1);
        int leftPosition = 0;
        int rightPosition = jumpValue;


        while (searchList[rightPosition]<= searchNumber && rightPosition < searchList.length){
            leftPosition = rightPosition;
            rightPosition = rightPosition + jumpValue;
            System.out.println(rightPosition);

            if (rightPosition > searchList.length-1){
                rightPosition = searchList.length-1;
                break;

            }
        }
        for (int i = leftPosition; i<=rightPosition+1; leftPosition++){
            if (searchNumber == searchList[i]){
                System.out.println("number found in "  + i);
                break;
            }
        }

    }

    public void interpolationSearch(int searchNumber, int[] searchList, int leftPosition, int rightPosition){
        if (leftPosition <= rightPosition && searchNumber >= searchList[leftPosition] && searchNumber <= searchList[rightPosition]){

            int searchLocation = leftPosition + ((rightPosition - leftPosition)/ (searchList[rightPosition]-searchList[leftPosition])*(searchNumber-searchList[leftPosition]));

            if (searchList[searchLocation] == searchNumber){
                System.out.println("Number found");
            }
            else if (searchList[searchLocation]< searchNumber) {
                interpolationSearch(searchNumber, searchList, searchLocation+1, rightPosition);
            } else if (searchList[searchLocation]>searchNumber) {

                interpolationSearch(searchNumber, searchList, leftPosition, searchLocation-1);
            }

        }
        else{
            System.out.println("Number not in the list");
        }
    }

    public void exponentialSearch(int searchNumber, int[] searchList){
        if (searchList[0] == searchNumber){
            System.out.println("number found in first index");
        }

        int i = 0;
        while (i<= searchList.length-1 && searchList[i]<=searchNumber){
            i= i*2;

        }
    }

    public static void main(String [] args){
//        System.out.println("hello");
        SearchAlgorithems randomNumberList = new SearchAlgorithems();
//        System.out.println(Arrays.toString(randomNumberList.randomGenerator()));
        int [] randomList = randomNumberList.randomGenerator();

//        randomNumberList.jumpSearch(randomList[5], randomList);
          randomNumberList.jumpSearch(randomList[999], randomList);
    }

}



