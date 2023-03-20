import java.util.Random;

public class ThousandStringUnsorted {

//    public String[] randomStringArray () {
//        int leftValue = 97;
//        int rightValue = 122;
//        int stringLength = 10;
//
//        Random random = new Random();
//
//        StringBuilder stringBuilder = new StringBuilder(stringLength);
//        for (int i=0; i < stringLength; i++){
//            int randomInt = leftValue + ()
//        }
//    }

    public void givenUsingPlainJava_whenGeneratingRandomStringBounded_thenCorrect() {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);

            System.out.println(randomLimitedInt);
        }

        String generatedString = buffer.toString();

        System.out.println(generatedString);
    }

    public static void main(String[] args) {
        ThousandStringUnsorted tss = new ThousandStringUnsorted();
        tss.givenUsingPlainJava_whenGeneratingRandomStringBounded_thenCorrect();
    }

}
