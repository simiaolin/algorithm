package category.LinkedList;

//是一道很好的理解边界的问题
public class RemoveKthNodeFromEnd {
    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        // Write your code here.
        LinkedList right = head;
        LinkedList left = head;
        while (right != null && k > 0) {
            right = right.next;
            k--;
        }
        if (k > 0) {           //欲求不满，超出边界了
            return;
        }
        if (right == null) { // to remove the head
            head.value = head.next.value;
            head.next = head.next.next;
        } else {
            while (right.next != null) {
                left = left.next;
                right = right.next;
            }
            left.next = left.next.next;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,3,4,5, 6,7,8,9};
        LinkedList right = LinkedList.getLinkedListFromArray(arr);
        removeKthNodeFromEnd(right, 4);
        System.out.println("h");
    }
}
