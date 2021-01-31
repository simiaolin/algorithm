package daily;

public class Jan28 {
    /**
     * 从前往后 计算 + 比较
     * @param n
     * @param k
     * @return
     */
    static public String getSmallestStringOld(int n, int k) {
        StringBuilder res = new StringBuilder();
        int left = k;
        int currentValue;
        for (int idx = 0; idx < n; idx++) {
            boolean isCurrentOfValueA = left <= (n - 1 - idx) * 26;
            if (isCurrentOfValueA) {
                currentValue = 1;
            } else {
                currentValue = left - (n-1-idx) * 26;
            }
            left = left - currentValue;

            res.append((char)(96 + currentValue));
            if (currentValue > 1) {
                String sameZ = new String(new char[n-1 - idx]).replace('\0', 'z');
                res.append(sameZ);
                break;
            }
        }
        return res.toString();
    }


        public static void main(String[] args) {
        int n = 3;
        int k = 27;
        System.out.println(getSmallestStringOld(n, k));
        System.out.println(getSmallestStringOld(3, 56));
    }
}
