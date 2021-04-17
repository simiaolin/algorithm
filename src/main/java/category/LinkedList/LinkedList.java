package category.LinkedList;

public class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
        this.value = value;
        this.next = null;
    }

    public LinkedList(int value, LinkedList next) {
        this.value = value;
        this.next = next;
    }
    
    public static LinkedList getLinkedListFromArray(int[] arr) {
        LinkedList right = new LinkedList(arr[arr.length - 1]);
        LinkedList left = null;
        for (int i = arr.length - 2; i >=0 ;i--) {
            left = new LinkedList(arr[i], right);
            right = left;
        }
        return right;
    }
}
