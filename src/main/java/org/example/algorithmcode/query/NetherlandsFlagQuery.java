package org.example.algorithmcode.query;

import org.example.algorithmcode.base.BaseQuery;

/**
 * 荷兰国旗
 * @author jm132
 * @since 2024-08-16
 */
public class NetherlandsFlagQuery extends BaseQuery {
    public static void main(String[] args) {
        int[] ints = buildArray();
        showArray(ints);
        partition(ints,0,ints.length-1);
        showArray(ints);

    }
    public static void partition(int[] arr,int L,int R){
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
        System.out.println("more = " + more);
        System.out.println("less = " + less);
        swap(arr,more,R);
    }
}
