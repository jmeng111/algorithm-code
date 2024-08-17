package org.example.algorithmcode.sort;

import org.example.algorithmcode.base.BaseSort;

/**
 * 归并排序
 */
public class MergeSort extends BaseSort {
    public static void main(String[] args) {
        int[] ints = buildArray();
        showArray(ints);
        prcess(ints,0,ints.length-1);
        showArray(ints);
    }
    public static void prcess(int[] arr, int L, int R){
        if(L == R){
            return ;
        }
        int M = L + ((R - L) >> 1);
        prcess(arr, L , M);
        prcess(arr, M+1, R);
        merge(arr, L, M, R);
    }
    public static void merge(int[] arr, int L,int M,int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1<=M && p2<=R) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1<=M) {
            help[i++] = arr[p1++];
        }
        while (p2<=R) {
            help[i++] = arr[p2++];
        }
        for (int k = 0; k < help.length; k++) {
            arr[k+L] = help[k];
        }
    }
}
