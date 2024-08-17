package org.example.algorithmcode.sort;

import org.example.algorithmcode.base.BaseSort;

/**
 * 选择排序
 */
public class SelectorSort extends BaseSort {
    public static void main(String[] args) {
        int[] arr = buildArray();
        showArray(arr);
        System.out.println("============");
        for(int i = 0; i <= arr.length -1 ;i++){ //遍历0 ~ N-1
            //i 目前待排序的下标
            int minIndex = i;
            for(int j = i + 1; j <= arr.length - 1 ; j++){//i ~ N-1
                minIndex = arr[j] < arr[minIndex] ? j:minIndex;
            }
            swap(arr,i,minIndex); //交换方法
        }
        showArray(arr);
    }
}
