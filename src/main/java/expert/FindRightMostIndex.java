package expert;

public class FindRightMostIndex {
    public static int findRightMostIndex (int[] arr, int toBeFound) {
       int left = 0;
       int right = arr.length - 1;
       while ( left < right ) {
           if (left + 1 == right) {             //这个时候mid==left, 可能出现死循环 [mid, right]
               if (arr[right] == toBeFound) {
                   return right;
               } else if (arr[left] == toBeFound) {
                   return left;
               } else {
                   return -1;
               }
           }
           int mid = (left + right) / 2;
           if (arr[mid] <= toBeFound) {
                left = mid;
           } else {
               right = mid - 1;               //不用左开右闭
           }
       }
       return arr[left] == toBeFound ?  left : -1;   //当左右相遇时
    }

    public static void main(String[] args) {
        int[] arr1 = new int[10];
        for (int i = 0; i < 10;i++) {
            arr1[i] = i+1;
        }

        int res1 = findRightMostIndex(arr1, 1);


        int[] arr2 = new int[] {1, 2,2,2,4,5};
        int res2 = findRightMostIndex(arr2, 0);

        System.out.println("Res1 "  + res1);
        System.out.println("Res2 "  + res2);

    }
}
