package algoexpert.LinkedList;


public class RemoveDuplicates {

    public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        // Write your code here.
        LinkedList firstnode = linkedList;
        LinkedList leftndoe= linkedList;
        LinkedList rightnode = linkedList;

        while (rightnode.next != null) {
            if (rightnode.next.value == rightnode.value) {
                rightnode = rightnode.next;
            } else {
                if (leftndoe == rightnode) {
        //do nothing
                } else {
                    leftndoe.next = rightnode.next;
                }
                leftndoe = leftndoe.next;
                rightnode = rightnode.next;
            }
        }
        if (rightnode != leftndoe) {
            leftndoe.next = null;
        }
        return firstnode;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 3, 4,4,4,5,6,6};
        LinkedList right = LinkedList.getLinkedListFromArray(arr);
        LinkedList res = removeDuplicatesFromLinkedList(right);
        System.out.println("h");
    }
}
