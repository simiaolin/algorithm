package Morgan;

import java.io.*;

public class Iostream implements Serializable {
 Iostream() {
     System.out.println("ioooo");

 }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        IKMTest ikmTest  = new IKMTest("xyz");
        FileOutputStream f = new FileOutputStream("ada.txt");
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(ikmTest);
        o.close();
        FileInputStream fi = new FileInputStream("ada.txt");
        ObjectInputStream i = new ObjectInputStream(fi);
        IKMTest ikmTest2 = (IKMTest) i.readObject();
        System.out.println(ikmTest2.getName());
        i.close();
    }
}

class IKMTest extends Iostream implements Serializable{
    private String name;
    IKMTest (String name) {
        this.name = name;
        System.out.println("testtttt");
    }
    public String getName() {
        return name;
    }
}