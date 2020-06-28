package leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 滑动窗口中位数
 *
 * @author yitian
 * @date 2020/6/20 11:33
 */
public class Solution2 {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((Collections.reverseOrder()));
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (maxHeap.size() == 0 || maxHeap.peek() >= nums[i]) {
                maxHeap.add(nums[i]);
            } else {
                minHeap.add(nums[i]);
            }
            balanceHeaps();

            if (i - k + 1 >= 0) {
                if (maxHeap.size() == minHeap.size()) {
                    result[i - k + 1] = maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
                } else {
                    result[i - k + 1] = maxHeap.peek();
                }

                int elementToBeRemoved = nums[i - k + 1];
                if (elementToBeRemoved <= maxHeap.peek()) {
                    maxHeap.remove(elementToBeRemoved);
                } else {
                    minHeap.remove(elementToBeRemoved);
                }
                balanceHeaps();
            }
        }
        return result;
    }

    private void balanceHeaps() {
        if (maxHeap.size() > minHeap.size() + 1){
            minHeap.add(maxHeap.poll());
        }
        else if (maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.poll());
        }

    }




        public static double[] medianSlidingWindow1(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return new double[]{};
            }
            double[] res = new double[nums.length - k + 1];
            PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Double> minHeap = new PriorityQueue<>();
            //滑动窗口固定写法
            int i = 0, j = 0;
            int count = 0;
            int index = 0;  //res的下标
            for (i = 0; i < nums.length - k + 1; i++) {
                while (j < nums.length && count < k) {
                    add(maxHeap, minHeap, nums[j]);
                    count++;
                    j++;
                }
                if (count == k) {
                    if (maxHeap.size() == minHeap.size()) {
                        res[index++] = (maxHeap.peek() + minHeap.peek()) * 0.5;     //这边给[2147483647,2147483647]，这就越界了，用long～
                    } else {
                        res[index++] = maxHeap.peek();
                    }
                }
                count--;
                remove(maxHeap, minHeap, (double)nums[i]);
            }
            return res;
        }

        public static void add(PriorityQueue<Double> maxHeap, PriorityQueue<Double> minHeap, double num) {
            maxHeap.offer((double)num);
            minHeap.offer(maxHeap.poll());
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
            return;
        }

        public static void remove(PriorityQueue<Double> maxHeap, PriorityQueue<Double> minHeap, double del) {
            if (del <= maxHeap.peek()) {
                maxHeap.remove(del);
            } else {
                minHeap.remove(del);
            }
            return;
        }

}
