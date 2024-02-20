package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BagOfRice {

    public static int matSetSize(List<Integer> riceBags) {
        int maxSize = 0;
        for (Integer i: riceBags) {
            List<Integer> tempList = new ArrayList<>();
            int square = i * i;
            tempList.add(i);
            while (riceBags.contains(square)) {
                tempList.add(square);
                square = square * square;
            }
            if (maxSize <= tempList.size()) {
                maxSize = tempList.size();
            }
        }
        if (maxSize == 1) maxSize = 0;
        return maxSize;

    }


    public static void main(String[] args) {
        int result =  BagOfRice.matSetSize(List.of(625, 4, 2, 5, 25));
        System.out.println(result);
    }
}
