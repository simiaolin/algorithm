package expert;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println(Stream.of("wellow", "green", "blue").max((s1 , s2) -> s1.compareTo(s2)).orElse("yello"));
    }
}
