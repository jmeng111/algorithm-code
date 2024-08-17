package org.example.algorithmcode.base;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public abstract class BaseQuery {

    final static int siez = 10;

    public static int[] buildArray(){
        Random random = new Random();
        Set<Integer> ints = new HashSet<Integer>();
        int[] arr = new int[siez];
        int index = 0;
        while (index < siez){
            int a = random.nextInt(99)+1;
            if(ints.add(a)){
                arr[index] = a;
                index++;
            }
        }
        return arr;
    }

    public static void showArray(int[] arr){
        for (int i : arr) {
            System.out.print("i = " + i + ", ");
        }
        System.out.println("");
        System.out.println("arr ========== ");
    }

    public static void swap(int[] arr, int left,int right){
        if(left==right){
            return;
        }
        arr[left] = arr[left]^arr[right];
        arr[right] = arr[left]^arr[right];
        arr[left] = arr[left]^arr[right];
    }
}
