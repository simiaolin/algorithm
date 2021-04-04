package Morgan;

import java.util.function.DoubleToIntFunction;

public class Document {
     {
        System.out.println("in send docu --------------");
    }
    public Document() {
        System.out.println("start to send");
    }
    static {
        System.out.println("ffffBegin");
    }
}
class Email extends Document {
    static {
        System.out.println("Begin");
    }

    {
        System.out.println("in send docu -++------------");
    }
     public Email(){
         System.out.println("in email");
     }

    static {
        System.out.println("end");
    }
}
class pro extends Email{
    public static void main(String[] args) {
        System.out.println("begin prece");
        new pro();
        System.out.println("end prece");
    }
}