package jianzhi;

public class LittleTrick {
    public static void main(String[] args) {
        String a = "aa";   //公共池
        String b = "aa";
        String c = new String("aa");   //堆
        System.out.println(a ==b);
        System.out.println(a.equals(b));
        System.out.println(a == c);   //是不是同一个对象
        System.out.println(a.equals(c)); //内容相同不相同
    }
}
