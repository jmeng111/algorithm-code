package org.example.algorithmcode.query;

import org.example.algorithmcode.base.BaseQuery;

public class GetMaxQuery extends BaseQuery {
    public static void main(String[] args) {
        int[] ints = buildArray();
        showArray(ints);
        int process = process(ints, 0, ints.length - 1);
        System.out.println("process = " + process);

    }
    public static int process(int[] arr, int start, int end){
        if(start == end){
            return arr[start];
        }
        int mid = start + ((end - start) >> 1);
        int leftMax = process(arr, start, mid);
        int rightMax = process(arr, mid + 1, end);
        return Math.max(leftMax,rightMax);
    }
}
