package expert;

public interface Comp {
    public String getAddress(String compnmae);
    default public String getPhoneNum() { return "1122";}
}

class OneCm implements Comp {

    @Override
    public String getAddress(String compnmae) {
        return null;
    }
//
//    @Override
//    public String getPhoneNum() {
//        return null;
//    }
}