package com.company;

import java.util.ArrayList;
import java.util.List;

public class ArrayBasedHeapPQ<E> {


    int size;
    private Heap<E>[] treeArray;

    public Heap<E>[] getTreeArray() {
        return treeArray;
    }

    public void setTreeArray(Heap<E>[] treeArray) {
        this.treeArray = treeArray;
    }

    public ArrayBasedHeapPQ(int size) {
        treeArray=new Heap[size];
    }

    protected int parent(int index)
    {
        return (index-1)/2;
    }
    protected int leftChild(int index)
    {
        return (2*index)+1;
    }
    protected int rightChild(int index)
    {
        return (2*index)+2;
    }


    protected void swap(int i , int j)
    {
        Heap<E> temp=treeArray[i];

        treeArray[i]=treeArray[j];
        treeArray[j]=temp;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty()
    {
        return size==0;
    }

    public boolean hasLeft(int index)
    {
        return leftChild(index)<size;
    }

    public boolean hasRight(int index)
    {
        return rightChild(index)<size;
    }

    public void upHeap(int index)
    {
        while (index>0)
        {
            if (treeArray[parent(index)].key> treeArray[index].key )
            {
                swap(index, parent(index));

                index=parent(index);
            }
            else
            {
                break;
            }
        }
    }

    public void downeap(int index)
    {
        while (hasLeft(index))
        {
            int smallestChildIndex=leftChild(index);
            if (hasRight(index))
            {
                if (treeArray[rightChild(index)].key<treeArray[leftChild(index)].key)
                {
                    smallestChildIndex=rightChild(index);
                }
            }

            if (treeArray[index].key>treeArray[smallestChildIndex].key)
            {
                swap(index,smallestChildIndex);
                index=smallestChildIndex;
            }
            else
            {
                break;
            }
        }
    }

    public Heap<E> min()
    {
        if (isEmpty()) return null;

        return treeArray[0];
    }

    public Heap<E> insert(int key , E data)
    {
        Heap<E> newest=new Heap<>(data,key);
        treeArray[size]=newest;
        size++;

        upHeap(size-1);
        return newest;
    }



    public Heap<E> removeMin()
    {
        Heap<E> min=treeArray[0];
        swap(0,size-1);
        treeArray[size-1]=null;
        size--;
        downeap(0);

        return min;

    }


    public static ArrayList<Integer> heapSort(List<Integer> unsortedList)
    {
        ArrayBasedHeapPQ<Integer> heapPQ=new ArrayBasedHeapPQ<>(unsortedList.size());

        for (int i=0 ; i<unsortedList.size() ; i++)
        {
            heapPQ.insert(unsortedList.get(i) , 0);
        }

        ArrayList<Integer> returnArray=new ArrayList<>();

        for (int i=0 ; i<unsortedList.size() ; i++)
        {
            returnArray.add(heapPQ.removeMin().key);
        }

        return returnArray;
    }

}
