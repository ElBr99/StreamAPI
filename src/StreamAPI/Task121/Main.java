package StreamAPI.Task121;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        intList.sort(Comparator.naturalOrder());
        for (int x : intList) {
            if (x > 0 && x % 2 == 0) {
                System.out.println(x);
            }
        }
    }
}
