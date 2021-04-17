package expert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class tEST {
    public static void main(String[] args) {
            List<Integer> li = new ArrayList<>();
            li.add(5);
            li.add(3);
            li.add(4);
            li.add(2);
            li.add(1);

           int res = maxConvert(li);
        System.out.println(res);
    }
    public static long euqla(List<Long> p) {
        Collections.sort(p);
        int midiumIndex = p.size() / 2;
        Long midium = p.get(midiumIndex);
        int change = 0;
        for (int i = 0; i < p.size(); i++) {
            change += Math.abs(p.get(i) - midium);
        }
        return change;
    }

    public static int maxConvert(List<Integer> arr) {
        ArrayList<Integer> smallerThanOne = new ArrayList<>(arr.size());
        ArrayList<Integer> smallerThanTwo = new ArrayList<>(arr.size());
        smallerThanOne.set(arr.size() - 1, 0);
        smallerThanTwo.set(arr.size() - 1, 0);
        for (int i = arr.size() - 2; i >= 0; i--) {
            int curSmallerThanOne = 0;
            int curSmallerThanTwo = 0;

            for (int j = i+1; j < arr.size(); j++) {
                if (arr.get(i) > arr.get(j)) {
                    curSmallerThanOne++;
                    curSmallerThanTwo += smallerThanOne.get(j);
                }
            }
            smallerThanOne.set(i, curSmallerThanOne);
            smallerThanTwo.set(i, curSmallerThanTwo);
        }
        int res = 0;

        for (int i = 0; i < smallerThanTwo.size(); i++) {
            res += smallerThanTwo.get(i);
        }
        return res;
    }
}
