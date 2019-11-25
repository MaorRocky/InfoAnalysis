import java.util.ArrayList;
import java.util.Random;

public class Utilities {
    // Returns a random sublist of the the given list (Those elements are removed from the original list).
    public static <T> ArrayList<T> getRandomElements(ArrayList<T> list, int numberOfElements)
    {
        Random rand = new Random();
        ArrayList<T> newList = new ArrayList<>();
        for (int i = 0; i < numberOfElements; i++) {

            // take a random index between 0 to size
            // of given List
            int randomIndex = rand.nextInt(list.size());

            // add element in temporary list
            newList.add(list.get(randomIndex));

            // Remove selected element from original list
            list.remove(randomIndex);
        }
        return newList;
    }

    public static int calcIndexOfBiggestElement(int[] arr) {
        int max = 0;
        for (int i = 1; i < arr.length ; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return max;
    }

    /*TODO ask sivan about the log base*/
    // Calc the entropy based on the given function
    public static double calcEntropy(int[] frequencies, int totalAmount) {
        double result = 0.0;
        if (totalAmount != 0) {
            for (int i = 0; i < 10; i++) {
                if (frequencies[i] != 0) {
                    result += (((float) frequencies[i] / totalAmount) * Math.log((float) totalAmount / frequencies[i]));
                }
            }
        }
        return result;
    }
}