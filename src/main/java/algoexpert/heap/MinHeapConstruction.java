package algoexpert.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//priority queue 本身是最小堆
public class MinHeapConstruction {

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41);
        MinHeap minHeap = new MinHeap(input);
        minHeap.insert(76);
        minHeap.peek();
        minHeap.remove();
        minHeap.peek();
        minHeap.remove();
        minHeap.peek();
        minHeap.insert(87);



    }
    static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        //可以用siftDown.
        //从第一个非叶子节点开始
        public List<Integer> buildHeap(List<Integer> array) {
            // Write your code here.
            for (int i = 0; i < array.size(); i++) {
              insert(array.get(i));
            }
            return heap;
        }

        public int peek() {
            // Write your code here.
            if (heap.size() >= 0) {
                return heap.get(0);
            }
            return -1;
        }

        public int remove() {
            // Write your code here.
            if (heap.size() > 0) {
                int removed = heap.get(0);
                heap.set(0, heap.size() -1);
                siftDown(0, heap.size() - 2, heap);
                return removed;
            }
            return -1;
        }

        public void insert(int value) {
            // Write your code here.
            heap.add(value);
            siftUp(heap.size() - 1, heap);

        }

        //could be better when selecting the child index to SWAP
        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            // Write your code here.

            while (currentIdx <= endIdx) { //has at least one child
                int leftChildIdx = getLeftChildIndx(currentIdx);
                int rightChildIdx = getRightChildIndx(currentIdx);
                if (leftChildIdx <= endIdx) {
                    if (rightChildIdx <= endIdx) {   //have two children
                        int min = Math.min(heap.get(leftChildIdx), heap.get(rightChildIdx));
                        if (min < heap.get(currentIdx)) {
                            if (heap.get(leftChildIdx) < heap.get(rightChildIdx)) {
                                if (heap.get(currentIdx) > heap.get(leftChildIdx)) {
                                    swap(leftChildIdx, currentIdx, heap);
                                    currentIdx = leftChildIdx;
                                }
                            } else {
                                if (heap.get(currentIdx) > heap.get(rightChildIdx)) {
                                    swap(rightChildIdx, currentIdx, heap);
                                    currentIdx = rightChildIdx;
                                }
                            }
                        } else {
                            break;
                        }

                    } else {
                        if (heap.get(currentIdx) > heap.get(leftChildIdx)) {
                            swap(leftChildIdx, currentIdx, heap);
                            currentIdx = leftChildIdx;
                        } else {
                            break;
                        }
                    }
                } else {
                    break;
                }

            }

        }

        public void siftUp(int currentIdx, List<Integer> heap) {

            while(currentIdx != 0) {
                int parentIdx = (currentIdx  - 1) / 2;
                if (heap.get(parentIdx) > heap.get(currentIdx)) {
                    swap(parentIdx, currentIdx, heap);
                    currentIdx = parentIdx;
                } else {
                    break;
                }
            }
            // Write your code here.
        }

       public void swap(int i, int j, List<Integer> heap) {
           int tmp = heap.get(i);
           heap.set(i, heap.get(j));
           heap.set(j, tmp);
       }

       public int getLeftChildIndx(int i) {
            return i *  2+ 1;
       }

       public int getRightChildIndx(int i) {
            return i  * 2+ 2;
       }



    }
}
