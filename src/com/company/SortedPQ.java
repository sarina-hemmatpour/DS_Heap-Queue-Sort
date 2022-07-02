package com.company;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

public class SortedPQ<E> {

    private ArrayList<Entry<E>> entryList;

    public ArrayList<Entry<E>> getEntryList() {
        return entryList;
    }

    public SortedPQ() {
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

    public Entry<E> min()
    {
        if (entryList.isEmpty()) return null;
        return entryList.get(0);
    }

    public void setEntryList(ArrayList<Entry<E>> entryList) {
        this.entryList = entryList;
    }

    public Entry<E> insert(int key , E data)
    {
        Entry<E> newest =new Entry<>(key,data);

        if (entryList.isEmpty())
        {
            entryList.add(newest);
            return newest;
        }

        boolean hasSet=false;
        for (int i=0 ; i<entryList.size() ; i++)
        {
            if (entryList.get(i).key>newest.key)
            {
                int newestIndex=i;

                entryList.add(entryList.get(entryList.size()-1));

                for (int j=entryList.size()-2 ; j>=i ; j--)
                {
                    entryList.set(j+1,entryList.get(j));
                }

                entryList.set(i,newest);

                hasSet=true;
                break;
            }
        }
        if (!hasSet)
        {
            entryList.add(newest);
        }

        return newest;
    }

    public Entry<E> removeMin()
    {
        Entry<E> min=min();

        entryList.remove(0);

        return min;
    }

    public static ArrayList<Integer> insertionSort(List<Integer> unsortedList)
    {
        SortedPQ<Integer> sortedPQ=new SortedPQ<>();

        for (int i=0 ; i<unsortedList.size() ; i++)
        {
            sortedPQ.insert(unsortedList.get(i) , 0);
        }

        ArrayList<Integer> result=new ArrayList<>();

        for (int i=0 ; i<unsortedList.size() ; i++)
        {
            result.add(sortedPQ.removeMin().key);
        }

        return result;
    }

}
