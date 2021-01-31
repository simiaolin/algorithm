package pickOne;


import java.util.Stack;

/**
 * 使用了递减stack
 */
public class DailyTemperature {
    static  public int[] dailyTemperatures(int[] T) {
        Stack<Integer> descendentTemps = new Stack<Integer>();
        int[] res = new int[T.length];
        descendentTemps.push(0);
        for(int idx = 1; idx < T.length; idx++) {
            int topOfStack = descendentTemps.peek();
            if (T[idx] <= T[topOfStack]) {
                descendentTemps.push(idx);
            } else {
                while(descendentTemps.size() > 0 && T[descendentTemps.peek()] <  T[idx]) {
                    int currentTop = descendentTemps.pop();
                    res[currentTop] = idx - currentTop;
                }
                descendentTemps.push(idx);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] temps = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperatures(temps);
        for (int r : res) {
            System.out.println(r);
        }
    }
}
