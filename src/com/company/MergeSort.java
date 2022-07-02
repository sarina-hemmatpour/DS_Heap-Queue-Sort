package com.company;

import java.util.ArrayList;

public class MergeSort {


    public static void mergeSort(ArrayList<Integer> arrayList , int low , int high)
    {
        if (high>low)
        {
            int middle=(low+high)/2;
            mergeSort(arrayList,low,middle);
            mergeSort(arrayList,middle+1,high);

            merge(arrayList,low,middle,high);
        }

    }

    private static void merge(ArrayList<Integer> arrayList , int low , int middle , int high)
    {

        int size1=middle-low+1;
        int size2=high-middle;

        //create copies
        int[] subArray1=new int[size1];
        int[] subArray2=new int[size2];

        for (int i=low ; i<low+size1 ; i++ )
        {
            subArray1[i-low]=arrayList.get(i);
        }
        for (int i=middle+1 ; i<middle+1+size2 ; i++)
        {
            subArray2[i-middle-1]=arrayList.get(i);
        }


        //merging copys
        int[] result=new int[size1+size2];
        int index1=0 , index2=0 , k=0;
        for ( ; index1<size1 && index2<size2 ;)
        {
            if (subArray1[index1]<=subArray2[index2])
            {
                result[k]=subArray1[index1];
                index1++;
                k++;
            }
            else
            {
                result[k]=subArray2[index2];
                index2++;
                k++;
            }

        }

        while (index1<size1)
        {
            result[k]=subArray1[index1];
            index1++;
            k++;
        }

        while (index2<size2)
        {
            result[k]=subArray2[index2];
            index2++;
            k++;
        }

        for (int i=low ; i<=high ; i++)
        {
            arrayList.set(i,result[i-low]);
        }


    }

}
