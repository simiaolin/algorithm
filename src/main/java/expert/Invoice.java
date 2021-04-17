package expert;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Invoice {
    public static void pr() {
        System.out.println("father");
    }


    public static void main(String[] args) throws IOException {
        byte c1[] = {10,20,30,40,50};
        byte c2[] = {60,70,80,90};
        ByteArrayOutputStream b1 = new ByteArrayOutputStream();
        ByteArrayOutputStream b2 = new ByteArrayOutputStream(10);

        b2.write(100);
        System.out.println(b2.size());
        b2.write(c1, 0 , c2.length);
        System.out.println(b2.size());
        byte b[] =  b2.toByteArray();
        System.out.println(b.length);
        b2.flush();
        System.out.println(b2.size());
        b2.reset();
        System.out.println(b2.size());
        b1.writeTo(b2);
        System.out.println(b1.size());
        System.out.println(b2.size());

    }
}

class SalesInvoice extends Invoice {
    public static void pr() {
        System.out.println("child");
    }
}