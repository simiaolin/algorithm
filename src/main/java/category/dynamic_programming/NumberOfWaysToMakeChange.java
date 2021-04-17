package category.dynamic_programming;

public class NumberOfWaysToMakeChange {

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        // Write your code here.
        int[] numberOfWaysToMakeChange = new int[n+1];
        numberOfWaysToMakeChange[0] = 1;          //not select anything is also a solution.
        for (int denom : denoms) {
            for (int amount = denom; amount < n+1 ; amount++) {
                numberOfWaysToMakeChange[amount] += numberOfWaysToMakeChange[amount - denom];
            }
        }
        return numberOfWaysToMakeChange[n];
    }

    public static void main(String[] args) {
        int n = 0;
        int[] denoms = new int[] {2, 3, 4,7};
        System.out.println(numberOfWaysToMakeChange(n, denoms));
    }
}
