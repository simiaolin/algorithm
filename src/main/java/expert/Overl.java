package expert;

import java.util.Formatter;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Overl {
    public static void main(String[] args) {
        testConsumerAndSupplier();


    }

    static void testConsumerAndSupplier() {
        Supplier<String> i = () -> "cAr";
        Consumer<String> c = x -> System.out.println(x.toLowerCase());
        Consumer<String> u = x -> System.out.println(x.toUpperCase());
        c.andThen(u).accept(i.get());
        System.out.println();
    }
    public static void main() {
        System.out.println("main 2");
    }

    static void testInt() {
        Integer a = 1;
        Integer b = a;
        a = a+1;
        System.out.println(a);
        System.out.println(b);
    }

    static void testLocal() {
        Locale l = new Locale("USA");
        System.out.println(l.getCountry());
    }
static     void testp() {
        boolean b= false;
        int n=1;
        System.out.println(b || n == 1);
        System.out.println(b = true || n==5);
        System.out.println(b);
    }
static void testfomatter() {
    String a = "a";
    String b = "b";
    String c = null;
    StringBuffer st = new StringBuffer("c");
    Formatter f = new Formatter(st);
    f.format("%s%s", a, b);
    System.out.println(f);

    f.format("%b", c);
    System.out.println(f);

    f.format("%-2s", b);
    System.out.println(f);
}

}
