package daily;

public class Feb1 {
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
                res+= n&1;
            n = n >> 1;
        }
        return res;
    }

    public int hammingWeightWrong(int n) {
        int left = n;
        int res = 0;
        while (left > 1) {
            if (! isOdd(left)) {
                res += 1;
            }
            left = left >> 1;
        }
        res++;
        return res;
    }


    public boolean isOdd(int i) {
        if ((i & 1) == 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Feb1 f = new Feb1();
        int n_1 = -3;
        int n_2 = 11;
        System.out.println(f.hammingWeight(n_1));
        System.out.println(f.hammingWeight(n_2));
    }
}
