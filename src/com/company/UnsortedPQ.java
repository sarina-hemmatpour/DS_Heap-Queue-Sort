package com.company;

import java.util.ArrayList;
import java.util.List;

public class UnsortedPQ<E> {


    private ArrayList<Entry<E>> entryList;

    public ArrayList<Entry<E>> getEntryList() {
        return entryList;
    }

    public UnsortedPQ() {
        entryList=new ArrayList<>();
    }

    public int size()
    {
        return entryList.size();
    }

    public boolean isEmpty()
    {
        return entryList.size()==0;
    }

    public Entry<E> insert(int key , E data)
    {
        Entry<E> newest=new Entry<>(key , data);
        entryList.add(newest);
        return newest;
    }

    public Entry<E> min()
    {
        int smallestKey=entryList.get(0).key;
        int minIndex=0;
        for (int i=1 ; i<entryList.size() ; i++)
        {
            if (entryList.get(i).key<smallestKey)
            {
                smallestKey=entryList.get(i).key;
                minIndex=i;
            }
        }

        return entryList.get(minIndex);
    }

    public Entry<E> removeMin()
    {
        Entry<E> reMin=min();

        entryList.remove(entryList.indexOf(min()));

        return reMin;
    }

    public static ArrayList<Integer> selectionSort(List<Integer> unsortedList)
    {
        UnsortedPQ<Integer> unsortedPQ=new UnsortedPQ<>();

        for (int i=0 ; i<unsortedList.size() ; i++)
        {
            unsortedPQ.insert(unsortedList.get(i) , 0);
        }

        ArrayList<Integer> result=new ArrayList<>();

        for (int i=0 ; i<unsortedList.size() ; i++)
        {
            result.add(unsortedPQ.removeMin().key);
        }

        return result;
    }

}
