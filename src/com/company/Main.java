package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {


        //writing and reaing data ////////////////////////////////////////////////////////////////////////////////

        //generating random numbers
        RandomInteger randomInteger=new RandomInteger();
//        randomInteger.generateRandomInteger();

        //save in file
        WriteReadFile<Integer> writeReadFile=new WriteReadFile<>(randomInteger.getRandomIntegerNumbers()
                                                                    ,"RandomInteger.txt");
//        writeReadFile.writeList();

        //read file
        randomInteger.setRandomIntegerNumbers(writeReadFile.readList());


        //sorting in five ways //////////////////////////////////////////////////////////////////////////////////

        long start = System.nanoTime();
        ArrayList<Integer> resultHeap=ArrayBasedHeapPQ.heapSort(randomInteger.getRandomIntegerNumbers());
        long end = System.nanoTime();
        long elapsedTimeHeap = end - start;

        start = System.nanoTime();
        ArrayList<Integer> resultInsertion=SortedPQ.insertionSort(randomInteger.getRandomIntegerNumbers());
        end = System.nanoTime();
        long elapsedTimeInsertion = end - start;

        start = System.nanoTime();
        ArrayList<Integer> resultSelection=UnsortedPQ.selectionSort(randomInteger.getRandomIntegerNumbers());
        end = System.nanoTime();
        long elapsedTimeSelection = end - start;


        ArrayList<Integer> resultMerge=randomInteger.getRandomIntegerNumbers();
        start = System.nanoTime();
        MergeSort.mergeSort(resultMerge,0,resultMerge.size()-1);
        end = System.nanoTime();
        long elapsedTimeMerge = end - start;


        ArrayList<Integer> resultQuick=randomInteger.getRandomIntegerNumbers();
        start = System.nanoTime();
        QuickSort.quichSort(resultQuick,0 , resultQuick.size()-1);
        end = System.nanoTime();
        long elapsedTimeQuick = end - start;


        //showing the result of time calculating

        System.out.println("Heap sort: "+ elapsedTimeHeap/1000000 + " ms");
        System.out.println("Insertion sort: "+elapsedTimeInsertion/1000000 + " ms");
        System.out.println("Selection sort: "+elapsedTimeSelection/1000000 + " ms");
        System.out.println("Merge sort: " + elapsedTimeMerge/1000000 + " ms");
        System.out.println("Quick sort: "+ elapsedTimeQuick/1000000+" ms");


    }
}
