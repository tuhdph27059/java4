package com.example.ASJava4;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.*;
import java.util.List;

public class SapXep {
    public static void main(String[] args) {
        int[] arr1 = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(1);
        list.add(5);
        list.add(9);
        list.add(2);
        list.add(6);
        list.add(5);
        list.add(3);
        list.add(5);
        Arrays.sort(arr1);
        Collections.sort(list,Collections.reverseOrder());
        System.out.println("Sorted Array:");
        for(int i : arr1) {
            System.out.print(i+"\t");
        }
        System.out.println("Sorted Array:");
        for(int i : list) {
            System.out.print(i+"\t");
        }
    }

}
