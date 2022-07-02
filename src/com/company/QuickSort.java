package com.company;

import java.util.ArrayList;

public class QuickSort {

    public static void quichSort(ArrayList<Integer> arrayList , int low , int high)
    {
        if (low<high)
        {
            int indexOfPivot=partition(arrayList,low,high);

            //befor pivot
            quichSort(arrayList,low,indexOfPivot-1);
            //after pivot
            quichSort(arrayList,indexOfPivot+1,high);
        }
    }

    private static int partition(ArrayList<Integer> arrayList , int low , int high)
    {
        int pivot=arrayList.get(high);

        int lowest=low-1;

        for (int i=low ; i<=high ; i++)
        {
            if (arrayList.get(i)<pivot)
            {
                lowest++;
                int temp=arrayList.get(lowest);
                arrayList.set(lowest,arrayList.get(i));
                arrayList.set(i,temp);

            }
        }

        //swap lowest with pivot
        arrayList.set(high,arrayList.get(lowest+1));
        arrayList.set(lowest+1,pivot);

        return lowest+1;

    }

}
