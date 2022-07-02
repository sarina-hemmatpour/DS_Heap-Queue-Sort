package com.company;

public class Heap<E> {

    E data;
    int key;

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Heap(E data, int key) {
        this.data = data;
        this.key = key;
    }
}
