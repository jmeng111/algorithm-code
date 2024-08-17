package org.example.algorithmcode.sort;

import org.example.algorithmcode.base.BaseSort;

public class QuickSort extends BaseSort {
    public static void main(String[] args) {
        int[] arr = buildArray();
        showArray(arr);
        sort(arr, 0, arr.length - 1);
        showArray(arr);

    }
    public static void sort(int[] arr,int start,int end){
        if(start < end) {
            swap(arr, start + (int) (Math.random() * (end - start + 1)), end);
            int[] p = partition(arr, start, end);
            sort(arr, start, p[0] - 1);
            sort(arr, p[1] + 1, end);
        }
    }
    public static int[] partition(int[] arr,int L,int R){
        int less = L - 1;// <右
        int more = R;//>左
        while (L < more){
            if(arr[L] < arr[R]){
                swap(arr,++less,L++);
            }else if(arr[L] > arr[R]){
                swap(arr,--more,L);
            }else {
                L++;
            }
        }
        swap(arr,more,R);
        return new int[]{less + 1, more};
    }

}
