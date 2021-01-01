package com.gupaoedu.result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Created by huawd
 * @date 2020/12/22
 */
public class RecursiveTestArrayList {

    //排序方法
    public static ArrayList<Integer> quickSort(ArrayList<Integer> arr) {

        int pivot = arr.get(0); //可替换代码
        //int mid = arr.size()/2;
        //int pivot = arr.get(mid);
        ArrayList<Integer> smaller = new ArrayList<Integer>(); //放置小于基准值的数据
        ArrayList<Integer> bigger = new ArrayList<Integer>(); //放置大于基准值的数据

        //分解当前列表的数据
        for(int i=1; i<arr.size();i++){ //替换i=0
            //if(i == mid)
            //continue;
            //else
            if(pivot >= arr.get(i)) {
                smaller.add(arr.get(i));
            } else {
                bigger.add(arr.get(i));
            }
        }

        //递归调用
        if(smaller.size() > 1) {
            quickSort(smaller);
        }
        if(bigger.size() > 1) {
            quickSort(bigger);
        }
        arr.removeAll(arr);
        arr.addAll(smaller);
        arr.add(pivot);
        arr.addAll(bigger);

        return arr;
    }

    public static void main(String[] args) {

        //初始化列表
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        ArrayList<Integer> arrListFinal = new ArrayList<Integer>();
        List<Integer> listA = Arrays.asList(9,5,4,10,0,1,2,6,3);

        arrList.addAll(listA);

        System.out.println("Before Sort:");
        for(int i=0; i<arrList.size(); i++) {
            System.out.print(arrList.get(i) + "  ");
        }

        arrListFinal.addAll(quickSort(arrList));

        System.out.println(" ");
        System.out.println("After Sort:");
        for(int j=0; j<arrListFinal.size(); j++) {
            System.out.print(arrListFinal.get(j) + "  ");
        }
    }

}
